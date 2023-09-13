grammar myCompiler;

options {
   language = Java;
}

@header {
    // import packages here.
    import java.util.HashMap;
    import java.util.ArrayList;
}

@members {
    boolean TRACEON = false;

    // Type information.
    public enum Type{
       ERR, BOOL, INT, FLOAT, CHAR, CONST_INT, CONST_FLOAT;
    }

    // This structure is used to record the information of a variable or a constant.
    class tVar {
	   int   varIndex; // temporary variable's index. Ex: t1, t2, ..., etc.
	   int   iValue;   // value of constant integer. Ex: 123.
	   float fValue;   // value of constant floating point. Ex: 2.314.
	};

    class Info {
       Type theType;  // type information.
       tVar theVar;
	   
	   Info() {
         theType = Type.ERR;
		   theVar = new tVar();
	   }
    };

	
    // ============================================
    // Create a symbol table.
	// ArrayList is easy to extend to add more info. into symbol table.
	//
	// The structure of symbol table:
	// <variable ID, [Type, [varIndex or iValue, or fValue]]>
	//    - type: the variable type   (please check "enum Type")
	//    - varIndex: the variable's index, ex: t1, t2, ...
	//    - iValue: value of integer constant.
	//    - fValue: value of floating-point constant.
    // ============================================

    HashMap<String, Info> symtab = new HashMap<String, Info>();
   
    String[]PrintStr=new String[10000];
    String[]PrintVar=new String[10000];
    String[]ForAssign=new String[100];
    String[]Lend = new String[100];
    String[]Lfalse = new String[100];
    int LCount = 0;
    int stringCnt = 0;
    // labelCount is used to represent temporary label.
    // The first index is 0.
    int labelCount = 0;
    int ForCount = 0;
	
    // varCount is used to represent temporary variables.
    // The first index is 0.
    int varCount = 0;
    int condCount = 0;

    // Record all assembly instructions.
    List<String> TextCode = new ArrayList<String>();


    /*
     * Output prologue.
     */
    void prologue()
    {
       TextCode.add("; === prologue ====");
       TextCode.add("declare dso_local i32 @printf(i8*, ...)\n");
	   TextCode.add("define dso_local i32 @main()");
	   TextCode.add("{");
    }
    
	
    /*
     * Output epilogue.
     */
    void epilogue()
    {
       /* handle epilogue */
       TextCode.add("\n; === epilogue ===");
	   TextCode.add("ret i32 0");
       TextCode.add("}");
       for(int i = 0 ; i< stringCnt ; i++){
         TextCode.add(PrintStr[i]);
       }
    }
    
    
    /* Generate a new label */
    String newLabel()
    {
       labelCount ++;
       return (new String("L")) + Integer.toString(labelCount);
    } 
    
    
    public List<String> getTextCode()
    {
       return TextCode;
    }
}

program  returns [int return_type]
:  (VOID {$return_type = 3;}| INT{$return_type = 1;}) MAIN '(' ')'
        {
           /* Output function prologue */
           prologue();
        }

        '{' 
           declarations
           statements
           (ret[$return_type])?
        '}'
        {
	   if (TRACEON)
	      System.out.println("VOID MAIN () {declarations statements}");

           /* output function epilogue */	  
           epilogue();
        }
        ;

ret [int return_type]
    : RETURN arith_expression ';'
    { 
        if($return_type == 3){
            
        }
        else {
            TextCode.add("ret i32 " + $arith_expression.theInfo.theVar.varIndex);
        }
    }
    ;

declarations: type (Identifier{
           if (TRACEON)
              System.out.println("declarations: type Identifier : declarations");

           if (symtab.containsKey($Identifier.text)) {
              // variable re-declared.
              System.out.println("Type Error: " + 
                                  $Identifier.getLine() + 
                                 ": Redeclared identifier.");
              System.exit(0);
           }
                 
           /* Add ID and its info into the symbol table. */
	       Info the_entry = new Info();
		   the_entry.theType = $type.attr_type;
		   the_entry.theVar.varIndex = varCount;
		   varCount ++;
		   symtab.put($Identifier.text, the_entry);

           // issue the instruction.
		   // Ex: \%a = alloca i32, align 4
           if ($type.attr_type == Type.INT) { 
              TextCode.add("\%t" + the_entry.theVar.varIndex + " = alloca i32, align 4");
           }
           if ($type.attr_type == Type.FLOAT) { 
              TextCode.add("\%t" + the_entry.theVar.varIndex + " = alloca float, align 4");
           }
        } | assign_stmtt[$type.attr_type])  varr[$type.attr_type] ';' declarations
        | 
        {
           if (TRACEON)
              System.out.println("declarations: ");
        }
        ;

varr [Type type]
   :(',' Identifier varr[type]{
      Info the_entry = new Info();
		   the_entry.theType = type;
		   the_entry.theVar.varIndex = varCount;
		   varCount ++;
		   symtab.put($Identifier.text, the_entry);

           if (type == Type.INT) { 
              TextCode.add("\%t" + the_entry.theVar.varIndex + " = alloca i32, align 4");
           }
           if (type == Type.FLOAT) { 
              TextCode.add("\%t" + the_entry.theVar.varIndex + " = alloca float, align 4");
           }
   })
   |(',' assign_stmtt[type] varr[type])
   |
   ;

assign_stmtt [Type type]
: Identifier '=' arith_expression
             {
                Info theRHS = $arith_expression.theInfo;

            Info theLHS = new Info();
		   theLHS.theType = type;
		   theLHS.theVar.varIndex = varCount;
		   varCount ++;
		   symtab.put($Identifier.text, theLHS);

           if (type == Type.INT) { 
              TextCode.add("\%t" + theLHS.theVar.varIndex + " = alloca i32, align 4");
           }
           if (type == Type.FLOAT) { 
              TextCode.add("\%t" + theLHS.theVar.varIndex + " = alloca float, align 4");
           }

		   
                if ((theLHS.theType == Type.INT) &&
                    (theRHS.theType == Type.INT)) {		   
                   // issue store insruction.
                   // Ex: store i32 \%tx, i32* \%ty
                   TextCode.add("store i32 \%t" + theRHS.theVar.varIndex + ", i32* \%t" + theLHS.theVar.varIndex);
				} else if ((theLHS.theType == Type.INT) &&
				    (theRHS.theType == Type.CONST_INT)) {
                   // issue store insruction.
                   // Ex: store i32 value, i32* \%ty
                   TextCode.add("store i32 " + theRHS.theVar.iValue + ", i32* \%t" + theLHS.theVar.varIndex);				
				}
            else if ((theLHS.theType == Type.FLOAT) &&
				    (theRHS.theType == Type.FLOAT)) {
                   TextCode.add("store float \%t" + theRHS.theVar.varIndex + ", float* \%t" + theLHS.theVar.varIndex);				
				}
            else if ((theLHS.theType == Type.FLOAT) &&
				    (theRHS.theType == Type.CONST_FLOAT)) {
                  String ans = Long.toHexString(Double.doubleToLongBits(theRHS.theVar.fValue));
                  
                  TextCode.add("store float 0x" + ans + ", float* \%t" + theLHS.theVar.varIndex);				
				}
			 }
             ;



type returns [Type attr_type]
    : INT { if (TRACEON) System.out.println("type: INT"); $attr_type=Type.INT; }
    | CHAR { if (TRACEON) System.out.println("type: CHAR"); $attr_type=Type.CHAR; }
    | FLOAT {if (TRACEON) System.out.println("type: FLOAT"); $attr_type=Type.FLOAT; }
	;


statements:statement statements
          |
          ;


statement: assign_stmt ';'
         | if_stmt
         | func_no_return_stmt ';'
         | for_stmt
         | while_stmt
         | print_stmt ';'
         ;
while_stmt: WHILE {
               int Count = LCount; LCount++;
                     Lend[Count] = newLabel();
                     TextCode.add("br label \%" + Lend[Count]);
                     TextCode.add(Lend[Count] + ":");
      }'(' cond_expression ')' {
         String Ltrue = newLabel();
                           Lfalse[Count] = newLabel();
                           TextCode.add("br i1 \%cond" + $cond_expression.theInfo.theVar.varIndex+", label \%" + Ltrue + ", label \%" + Lfalse[Count]);
                           TextCode.add(Ltrue + ":");

      }block_stmt for_end[Count]
;

for_stmt:  FOR '(' assign_stmt ';'{
               int Count = LCount; LCount++;
                     Lend[Count] = newLabel();
                     TextCode.add("br label \%" + Lend[Count]);
                     TextCode.add(Lend[Count] + ":");
}
                  cond_expression ';'{
                     
                     String Ltrue = newLabel();
                     Lfalse[Count] = newLabel();
                     TextCode.add("br i1 \%cond" + $cond_expression.theInfo.theVar.varIndex+", label \%" + Ltrue + ", label \%" + Lfalse[Count]);
                     TextCode.add(Ltrue + ":");
                  }
                  a=for_assign_stmt
              ')'
                  block_stmt {TextCode.add($a.s);}for_end[Count]
        ;
for_end [int Count]:{
   
   TextCode.add("br label \%" + Lend[Count]);
   TextCode.add(Lfalse[Count] + ":");
}
;

for_assign_stmt returns [String s] : Identifier '=' arith_expression
             {
                Info theRHS = $arith_expression.theInfo;
				Info theLHS = symtab.get($Identifier.text); 
                if ((theLHS.theType == Type.INT) &&
                    (theRHS.theType == Type.INT)) {		   
                   // issue store insruction.
                   // Ex: store i32 \%tx, i32* \%ty
                   s = "store i32 \%t" + theRHS.theVar.varIndex + ", i32* \%t" + theLHS.theVar.varIndex;
				} else if ((theLHS.theType == Type.INT) &&
				    (theRHS.theType == Type.CONST_INT)) {
                   // issue store insruction.
                   // Ex: store i32 value, i32* \%ty
                   s = "store i32 " + theRHS.theVar.iValue + ", i32* \%t" + theLHS.theVar.varIndex;			
				}
            else if ((theLHS.theType == Type.FLOAT) &&
				    (theRHS.theType == Type.FLOAT)) {
                  s = "store float \%t" + theRHS.theVar.varIndex + ", float* \%t" + theLHS.theVar.varIndex;	
				}
            else if ((theLHS.theType == Type.FLOAT) &&
				    (theRHS.theType == Type.CONST_FLOAT)) {
                  String ans = Long.toHexString(Double.doubleToLongBits(theRHS.theVar.fValue));
                  s =	"store float 0x" + ans + ", float* \%t" + theLHS.theVar.varIndex;	

				}
			 }
             ;

print_var returns [int printcount] :
',' b=arith_expression a=print_var {
      $printcount = $a.printcount + 1;
      Info theInfo = new Info();
      theInfo = $b.theInfo;
      Integer i = 3;
      int t = varCount++;
      if(theInfo.theType == Type.FLOAT){
         int ft = varCount++;
         PrintVar[$printcount] = 
         "\%t"+ ft + " = fpext float " + "\%t" + theInfo.theVar.varIndex + " to double " +
         "\%t"+ t + " = call i32 (i8*, ...) @printf(i8* getelementptr inbounds (["+i+" x i8], ["+i+" x i8]* @.str." + stringCnt + ", i64 0, i64 0), double \%t"+ ft +")";
         PrintStr[stringCnt] = "@.str." + stringCnt+" = private unnamed_addr constant ["+i+" x i8] c\"\%f\\00\", align 1";   
      }
      if(theInfo.theType == Type.INT){
         PrintVar[$printcount] =  "\%t"+ t + " = call i32 (i8*, ...) @printf(i8* getelementptr inbounds (["+i+" x i8], ["+i+" x i8]* @.str." + stringCnt + ", i64 0, i64 0), i32 \%t"+theInfo.theVar.varIndex+")";
         PrintStr[stringCnt] = "@.str." + stringCnt+" = private unnamed_addr constant ["+i+" x i8] c\"\%d\\00\", align 1";   
      }
      stringCnt ++;
   }
| {$printcount = 0;}
;

print_stmt 
: PRINTF '(' STRING_LITERAL b=print_var')'
   {
      int i, j, k;
      int tmp = $b.printcount;
      k = tmp;
      String strMain = $STRING_LITERAL.text;
      String p = strMain.substring(strMain.length()-1,strMain.length() );
      strMain = strMain.replace("\%f", "\%d");
      String[] arrSplit = strMain.split("\%d");
      Info theInfo = new Info();
	   theInfo.theType = Type.INT;
      for(j = 0; j < arrSplit.length; j++){
	      
         String s = arrSplit[j];
         if (j > 0){
            s = p + s;
         }
         s = s.replace("\\n", "@");
         s = s.replace("\%d", "");
         i = s.length() -1;
         if(j < arrSplit.length - 1){
            i++;
         }
         
         if(i > 0){
         s = s.replace("@", "\\0A");
         if(j >= arrSplit.length - 1){
            s = s.substring(0, s.length()-1);
         }
         
         theInfo.theVar.varIndex = varCount++;
         TextCode.add("\%t"+theInfo.theVar.varIndex + " = call i32 (i8*, ...) @printf(i8* getelementptr inbounds (["+i+" x i8], ["+i+" x i8]* @.str." + stringCnt + ", i64 0, i64 0))");
         PrintStr[stringCnt] = "@.str." + stringCnt +" = private unnamed_addr constant ["+i+" x i8] c"+s+"\\00\", align 1";   
         stringCnt ++;
         }
         if(k > 0){
            TextCode.add(PrintVar[k]);
            k--;
         }
      }
   }
;
		 
if_stmt
            : {int tmp = LCount; LCount++;}if_then_stmt [tmp]
            if_else_if_stmt[tmp]
            if_else_stmt[tmp]
            ;

	   
if_then_stmt [int Count]
            : IF '(' cond_expression ')'{
                  String Ltrue = newLabel();
                  Lfalse[Count] = newLabel();
                  Lend[Count] = newLabel();
                  TextCode.add("br i1 \%cond" + $cond_expression.theInfo.theVar.varIndex+", label \%" + Ltrue + ", label \%" + Lfalse[Count]);
                  TextCode.add(Ltrue + ":");
               } block_stmt
            ;

if_else_if_stmt  [int Count] :
         ELSE IF {TextCode.add("br label \%"+Lend[Count]);TextCode.add(Lfalse[Count] + ":");}'(' cond_expression ')'{
                  String Ltrue = newLabel();
                  Lfalse[Count] = newLabel();
                  TextCode.add("br i1 \%cond" + $cond_expression.theInfo.theVar.varIndex+", label \%" + Ltrue + ", label \%" + Lfalse[Count]);
                  TextCode.add(Ltrue + ":");
               } block_stmt if_else_if_stmt[Count]
         | 
;

if_else_stmt [int Count]
            : ELSE{
               TextCode.add("br label \%"+Lend[Count]);
               TextCode.add(Lfalse[Count]+ ":");
            }
            block_stmt{
                  TextCode.add("br label \%" + Lend[Count]);
                  TextCode.add(Lend[Count] + ":");
            }
      | {
            TextCode.add("br label \%" + Lend[Count]);
            TextCode.add(Lfalse[Count]+ ":");
            TextCode.add("br label \%" + Lend[Count]);
            TextCode.add(Lend[Count] + ":");
         }
      ;

				  
block_stmt: '{' statements '}'
	  ;


assign_stmt: Identifier '=' arith_expression
             {
                Info theRHS = $arith_expression.theInfo;
				Info theLHS = symtab.get($Identifier.text); 
		   
                if ((theLHS.theType == Type.INT) &&
                    (theRHS.theType == Type.INT)) {		   
                   // issue store insruction.
                   // Ex: store i32 \%tx, i32* \%ty
                   TextCode.add("store i32 \%t" + theRHS.theVar.varIndex + ", i32* \%t" + theLHS.theVar.varIndex);
				} else if ((theLHS.theType == Type.INT) &&
				    (theRHS.theType == Type.CONST_INT)) {
                   // issue store insruction.
                   // Ex: store i32 value, i32* \%ty
                   TextCode.add("store i32 " + theRHS.theVar.iValue + ", i32* \%t" + theLHS.theVar.varIndex);				
				}
            else if ((theLHS.theType == Type.FLOAT) &&
				    (theRHS.theType == Type.FLOAT)) {
                   TextCode.add("store float \%t" + theRHS.theVar.varIndex + ", float* \%t" + theLHS.theVar.varIndex);				
				}
            else if ((theLHS.theType == Type.FLOAT) &&
				    (theRHS.theType == Type.CONST_FLOAT)) {
                  String ans = Long.toHexString(Double.doubleToLongBits(theRHS.theVar.fValue));
                  
                  TextCode.add("store float 0x" + ans + ", float* \%t" + theLHS.theVar.varIndex);				
				}
			 }
             ;

		   
func_no_return_stmt: Identifier '(' argument ')'
                   ;


argument: arg (',' arg)*
        ;

arg: arith_expression
   | STRING_LITERAL
   ;
		   
cond_expression
returns [Info theInfo]
@init{theInfo = new Info();}
               : a = arith_expression (RelationOP b = arith_expression)*{
                  $theInfo.theType = Type.BOOL;
                  $theInfo.theVar.varIndex = condCount;
                  String op = String.valueOf($RelationOP.text);
                  if(op.compareTo("==") == 0){
                        if(($a.theInfo.theType == Type.INT) && ($b.theInfo.theType == Type.INT)){
                           TextCode.add("\%cond" + condCount + " = icmp eq i32 \%t" + $a.theInfo.theVar.varIndex + ", \%t" + $b.theInfo.theVar.varIndex);
                           condCount++;
                        }
                        else if (($a.theInfo.theType == Type.INT) && ($b.theInfo.theType == Type.CONST_INT)) {
                           TextCode.add("\%cond" + condCount + " = icmp eq i32 \%t" + $a.theInfo.theVar.varIndex + ", " + $b.theInfo.theVar.iValue);
                           condCount++;
                        }
                        else if (($a.theInfo.theType == Type.CONST_INT) && ($b.theInfo.theType == Type.INT)) {
                           TextCode.add("\%cond" + condCount + " = icmp eq i32 "  + $a.theInfo.theVar.iValue + ", \%t" + $b.theInfo.theVar.varIndex);
                           condCount++;
                        }
                        else if (($a.theInfo.theType == Type.CONST_INT) && ($b.theInfo.theType == Type.CONST_INT)) {
                           TextCode.add("\%cond" + condCount + " = icmp eq i32 "  + $a.theInfo.theVar.iValue + ", " + $b.theInfo.theVar.iValue);
                           condCount++;
                        }
                        else if(($a.theInfo.theType == Type.FLOAT) && ($b.theInfo.theType == Type.FLOAT)){
                           TextCode.add("\%cond" + condCount + " = fcmp oeq float \%t" + $a.theInfo.theVar.varIndex + ", \%t" + $b.theInfo.theVar.varIndex);
                           condCount++;
                        }
                        else if (($a.theInfo.theType == Type.FLOAT) && ($b.theInfo.theType == Type.CONST_FLOAT)) {
                           TextCode.add("\%cond" + condCount + " = fcmp oeq  float \%t" + $a.theInfo.theVar.varIndex + ", " + $b.theInfo.theVar.fValue);
                           condCount++;
                        }
                        else if (($a.theInfo.theType == Type.CONST_FLOAT) && ($b.theInfo.theType == Type.FLOAT)) {
                           TextCode.add("\%cond" + condCount + " = fcmp oeq  float " + $a.theInfo.theVar.fValue + ", \%t" + $b.theInfo.theVar.varIndex);
                           condCount++;
                        }
                        else if (($a.theInfo.theType == Type.CONST_FLOAT) && ($b.theInfo.theType == Type.CONST_FLOAT)) {
                           TextCode.add("\%cond" + condCount + " = fcmp oeq  float " + $a.theInfo.theVar.fValue + ", " + $b.theInfo.theVar.fValue);
                           condCount++;
                        }
                  }
                  else if (op.compareTo("!=") == 0){
                        if(($a.theInfo.theType == Type.INT) && ($b.theInfo.theType == Type.INT)){
                           TextCode.add("\%cond" + condCount + " = icmp ne i32 \%t" + $a.theInfo.theVar.varIndex + ", \%t" + $b.theInfo.theVar.varIndex);
                           condCount++;
                        }
                        else if (($a.theInfo.theType == Type.INT) && ($b.theInfo.theType == Type.CONST_INT)) {
                           TextCode.add("\%cond" + condCount + " = icmp ne i32 \%t" + $a.theInfo.theVar.varIndex + ", " + $b.theInfo.theVar.iValue);
                           condCount++;
                        }
                        else if (($a.theInfo.theType == Type.CONST_INT) && ($b.theInfo.theType == Type.INT)) {
                           TextCode.add("\%cond" + condCount + " = icmp ne i32 "  + $a.theInfo.theVar.iValue + ", \%t" + $b.theInfo.theVar.varIndex);
                           condCount++;
                        }
                        else if (($a.theInfo.theType == Type.CONST_INT) && ($b.theInfo.theType == Type.CONST_INT)) {
                           TextCode.add("\%cond" + condCount + " = icmp ne i32 "  + $a.theInfo.theVar.iValue + ", " + $b.theInfo.theVar.iValue);
                           condCount++;
                        }
                        else if(($a.theInfo.theType == Type.FLOAT) && ($b.theInfo.theType == Type.FLOAT)){
                           TextCode.add("\%cond" + condCount + " = fcmp une float \%t" + $a.theInfo.theVar.varIndex + ", \%t" + $b.theInfo.theVar.varIndex);
                           condCount++;
                        }
                        else if (($a.theInfo.theType == Type.FLOAT) && ($b.theInfo.theType == Type.CONST_FLOAT)) {
                           TextCode.add("\%cond" + condCount + " = fcmp une  float \%t" + $a.theInfo.theVar.varIndex + ", " + $b.theInfo.theVar.fValue);
                           condCount++;
                        }
                        else if (($a.theInfo.theType == Type.CONST_FLOAT) && ($b.theInfo.theType == Type.FLOAT)) {
                           TextCode.add("\%cond" + condCount + " = fcmp une  float " + $a.theInfo.theVar.fValue + ", \%t" + $b.theInfo.theVar.varIndex);
                           condCount++;
                        }
                        else if (($a.theInfo.theType == Type.CONST_FLOAT) && ($b.theInfo.theType == Type.CONST_FLOAT)) {
                           TextCode.add("\%cond" + condCount + " = fcmp une  float " + $a.theInfo.theVar.fValue + ", " + $b.theInfo.theVar.fValue);
                           condCount++;
                        }
                  }
                  else if (op.compareTo(">=") == 0){
                        if(($a.theInfo.theType == Type.INT) && ($b.theInfo.theType == Type.INT)){
                           TextCode.add("\%cond" + condCount + " = icmp sge i32 \%t" + $a.theInfo.theVar.varIndex + ", \%t" + $b.theInfo.theVar.varIndex);
                           condCount++;
                        }
                        else if (($a.theInfo.theType == Type.INT) && ($b.theInfo.theType == Type.CONST_INT)) {
                           TextCode.add("\%cond" + condCount + " = icmp sge i32 \%t" + $a.theInfo.theVar.varIndex + ", " + $b.theInfo.theVar.iValue);
                           condCount++;
                        }
                        else if (($a.theInfo.theType == Type.CONST_INT) && ($b.theInfo.theType == Type.INT)) {
                           TextCode.add("\%cond" + condCount + " = icmp sge i32 "  + $a.theInfo.theVar.iValue + ", \%t" + $b.theInfo.theVar.varIndex);
                           condCount++;
                        }
                        else if (($a.theInfo.theType == Type.CONST_INT) && ($b.theInfo.theType == Type.CONST_INT)) {
                           TextCode.add("\%cond" + condCount + " = icmp sge i32 "  + $a.theInfo.theVar.iValue + ", " + $b.theInfo.theVar.iValue);
                           condCount++;
                        }
                        else if(($a.theInfo.theType == Type.FLOAT) && ($b.theInfo.theType == Type.FLOAT)){
                           TextCode.add("\%cond" + condCount + " = fcmp oge float \%t" + $a.theInfo.theVar.varIndex + ", \%t" + $b.theInfo.theVar.varIndex);
                           condCount++;
                        }
                        else if (($a.theInfo.theType == Type.FLOAT) && ($b.theInfo.theType == Type.CONST_FLOAT)) {
                           TextCode.add("\%cond" + condCount + " = fcmp oge  float \%t" + $a.theInfo.theVar.varIndex + ", " + $b.theInfo.theVar.fValue);
                           condCount++;
                        }
                        else if (($a.theInfo.theType == Type.CONST_FLOAT) && ($b.theInfo.theType == Type.FLOAT)) {
                           TextCode.add("\%cond" + condCount + " = fcmp oge  float " + $a.theInfo.theVar.fValue + ", \%t" + $b.theInfo.theVar.varIndex);
                           condCount++;
                        }
                        else if (($a.theInfo.theType == Type.CONST_FLOAT) && ($b.theInfo.theType == Type.CONST_FLOAT)) {
                           TextCode.add("\%cond" + condCount + " = fcmp oge  float " + $a.theInfo.theVar.fValue + ", " + $b.theInfo.theVar.fValue);
                           condCount++;
                        }
                  }
                  else if (op.compareTo("<=") == 0){
                        if(($a.theInfo.theType == Type.INT) && ($b.theInfo.theType == Type.INT)){
                           TextCode.add("\%cond" + condCount + " = icmp sle i32 \%t" + $a.theInfo.theVar.varIndex + ", \%t" + $b.theInfo.theVar.varIndex);
                           condCount++;
                        }
                        else if (($a.theInfo.theType == Type.INT) && ($b.theInfo.theType == Type.CONST_INT)) {
                           TextCode.add("\%cond" + condCount + " = icmp sle i32 \%t" + $a.theInfo.theVar.varIndex + ", " + $b.theInfo.theVar.iValue);
                           condCount++;
                        }
                        else if (($a.theInfo.theType == Type.CONST_INT) && ($b.theInfo.theType == Type.INT)) {
                           TextCode.add("\%cond" + condCount + " = icmp sle i32 "  + $a.theInfo.theVar.iValue + ", \%t" + $b.theInfo.theVar.varIndex);
                           condCount++;
                        }
                        else if (($a.theInfo.theType == Type.CONST_INT) && ($b.theInfo.theType == Type.CONST_INT)) {
                           TextCode.add("\%cond" + condCount + " = icmp sle i32 "  + $a.theInfo.theVar.iValue + ", " + $b.theInfo.theVar.iValue);
                           condCount++;
                        }
                        else if(($a.theInfo.theType == Type.FLOAT) && ($b.theInfo.theType == Type.FLOAT)){
                           TextCode.add("\%cond" + condCount + " = fcmp ole float \%t" + $a.theInfo.theVar.varIndex + ", \%t" + $b.theInfo.theVar.varIndex);
                           condCount++;
                        }
                        else if (($a.theInfo.theType == Type.FLOAT) && ($b.theInfo.theType == Type.CONST_FLOAT)) {
                           TextCode.add("\%cond" + condCount + " = fcmp ole float \%t" + $a.theInfo.theVar.varIndex + ", " + $b.theInfo.theVar.fValue);
                           condCount++;
                        }
                        else if (($a.theInfo.theType == Type.CONST_FLOAT) && ($b.theInfo.theType == Type.FLOAT)) {
                           TextCode.add("\%cond" + condCount + " = fcmp ole float " + $a.theInfo.theVar.fValue + ", \%t" + $b.theInfo.theVar.varIndex);
                           condCount++;
                        }
                        else if (($a.theInfo.theType == Type.CONST_FLOAT) && ($b.theInfo.theType == Type.CONST_FLOAT)) {
                           TextCode.add("\%cond" + condCount + " = fcmp ole float " + $a.theInfo.theVar.fValue + ", " + $b.theInfo.theVar.fValue);
                           condCount++;
                        }
                  }
                  else if (op.compareTo(">") == 0){
                        if(($a.theInfo.theType == Type.INT) && ($b.theInfo.theType == Type.INT)){
                           TextCode.add("\%cond" + condCount + " = icmp sgt i32 \%t" + $a.theInfo.theVar.varIndex + ", \%t" + $b.theInfo.theVar.varIndex);
                           condCount++;
                        }
                        else if (($a.theInfo.theType == Type.INT) && ($b.theInfo.theType == Type.CONST_INT)) {
                           TextCode.add("\%cond" + condCount + " = icmp sgt i32 \%t" + $a.theInfo.theVar.varIndex + ", " + $b.theInfo.theVar.iValue);
                           condCount++;
                        }
                        else if (($a.theInfo.theType == Type.CONST_INT) && ($b.theInfo.theType == Type.INT)) {
                           TextCode.add("\%cond" + condCount + " = icmp sgt i32 "  + $a.theInfo.theVar.iValue + ", \%t" + $b.theInfo.theVar.varIndex);
                           condCount++;
                        }
                        else if (($a.theInfo.theType == Type.CONST_INT) && ($b.theInfo.theType == Type.CONST_INT)) {
                           TextCode.add("\%cond" + condCount + " = icmp sgt i32 "  + $a.theInfo.theVar.iValue + ", " + $b.theInfo.theVar.iValue);
                           condCount++;
                        }
                        else if(($a.theInfo.theType == Type.FLOAT) && ($b.theInfo.theType == Type.FLOAT)){
                           TextCode.add("\%cond" + condCount + " = fcmp ogt float \%t" + $a.theInfo.theVar.varIndex + ", \%t" + $b.theInfo.theVar.varIndex);
                           condCount++;
                        }
                        else if (($a.theInfo.theType == Type.FLOAT) && ($b.theInfo.theType == Type.CONST_FLOAT)) {
                           TextCode.add("\%cond" + condCount + " = fcmp ogt float \%t" + $a.theInfo.theVar.varIndex + ", " + $b.theInfo.theVar.fValue);
                           condCount++;
                        }
                        else if (($a.theInfo.theType == Type.CONST_FLOAT) && ($b.theInfo.theType == Type.FLOAT)) {
                           TextCode.add("\%cond" + condCount + " = fcmp ogt float " + $a.theInfo.theVar.fValue + ", \%t" + $b.theInfo.theVar.varIndex);
                           condCount++;
                        }
                        else if (($a.theInfo.theType == Type.CONST_FLOAT) && ($b.theInfo.theType == Type.CONST_FLOAT)) {
                           TextCode.add("\%cond" + condCount + " = fcmp ogt float " + $a.theInfo.theVar.fValue + ", " + $b.theInfo.theVar.fValue);
                           condCount++;
                        }
                  }
                  else if (op.compareTo("<") == 0){
                        if(($a.theInfo.theType == Type.INT) && ($b.theInfo.theType == Type.INT)){
                           TextCode.add("\%cond" + condCount + " = icmp slt i32 \%t" + $a.theInfo.theVar.varIndex + ", \%t" + $b.theInfo.theVar.varIndex);
                           condCount++;
                        }
                        else if (($a.theInfo.theType == Type.INT) && ($b.theInfo.theType == Type.CONST_INT)) {
                           TextCode.add("\%cond" + condCount + " = icmp slt i32 \%t" + $a.theInfo.theVar.varIndex + ", " + $b.theInfo.theVar.iValue);
                           condCount++;
                        }
                        else if (($a.theInfo.theType == Type.CONST_INT) && ($b.theInfo.theType == Type.INT)) {
                           TextCode.add("\%cond" + condCount + " = icmp slt i32 "  + $a.theInfo.theVar.iValue + ", \%t" + $b.theInfo.theVar.varIndex);
                           condCount++;
                        }
                        else if (($a.theInfo.theType == Type.CONST_INT) && ($b.theInfo.theType == Type.CONST_INT)) {
                           TextCode.add("\%cond" + condCount + " = icmp slt i32 "  + $a.theInfo.theVar.iValue + ", " + $b.theInfo.theVar.iValue);
                           condCount++;
                        }
                        else if(($a.theInfo.theType == Type.FLOAT) && ($b.theInfo.theType == Type.FLOAT)){
                           TextCode.add("\%cond" + condCount + " = fcmp olt float \%t" + $a.theInfo.theVar.varIndex + ", \%t" + $b.theInfo.theVar.varIndex);
                           condCount++;
                        }
                        else if (($a.theInfo.theType == Type.FLOAT) && ($b.theInfo.theType == Type.CONST_FLOAT)) {
                           TextCode.add("\%cond" + condCount + " = fcmp olt float \%t" + $a.theInfo.theVar.varIndex + ", " + $b.theInfo.theVar.fValue);
                           condCount++;
                        }
                        else if (($a.theInfo.theType == Type.CONST_FLOAT) && ($b.theInfo.theType == Type.FLOAT)) {
                           TextCode.add("\%cond" + condCount + " = fcmp olt float " + $a.theInfo.theVar.fValue + ", \%t" + $b.theInfo.theVar.varIndex);
                           condCount++;
                        }
                        else if (($a.theInfo.theType == Type.CONST_FLOAT) && ($b.theInfo.theType == Type.CONST_FLOAT)) {
                           TextCode.add("\%cond" + condCount + " = fcmp olt float " + $a.theInfo.theVar.fValue + ", " + $b.theInfo.theVar.fValue);
                           condCount++;
                        }
                        
                  }
               }
               ;
			   
arith_expression
returns [Info theInfo]
@init {theInfo = new Info();}
                : a=multExpr { $theInfo=$a.theInfo; }
                 ( '+' b=multExpr
                    {
                        if (($a.theInfo.theType == Type.INT) && ($b.theInfo.theType == Type.INT)) {
                           TextCode.add("\%t" + varCount + " = add nsw i32 \%t" + $theInfo.theVar.varIndex + ", \%t" + $b.theInfo.theVar.varIndex);
					            $theInfo.theType = Type.INT;
					            $theInfo.theVar.varIndex = varCount;
                           
					            varCount ++;
                        } 
                        else if (($a.theInfo.theType == Type.INT) && ($b.theInfo.theType == Type.CONST_INT))
		                  {
                           TextCode.add("\%t" + varCount + " = add nsw i32 \%t" + $theInfo.theVar.varIndex + ", " + $b.theInfo.theVar.iValue);
			                  $theInfo.theType = Type.INT;
			                  $theInfo.theVar.varIndex = varCount;
                           varCount ++;
                        }
                        else if (($a.theInfo.theType == Type.CONST_INT) && ($b.theInfo.theType == Type.INT))
		                  {
                           TextCode.add("\%t" + varCount + " = add nsw i32 " + $a.theInfo.theVar.iValue + ", \%t" + $b.theInfo.theVar.varIndex);
			                  $theInfo.theType = Type.INT;
			                  $theInfo.theVar.varIndex = varCount;
                           varCount ++;
                        }
                        else if (($a.theInfo.theType == Type.CONST_INT) && ($b.theInfo.theType == Type.CONST_INT))
		                  {
                            TextCode.add("\%t" + varCount + " = add nsw i32 " + $a.theInfo.theVar.iValue + ", " + $b.theInfo.theVar.iValue);
			                  $theInfo.theType = Type.INT;
			                  $theInfo.theVar.varIndex = varCount;
                           varCount ++;
                        }
                        else if (($a.theInfo.theType == Type.FLOAT) && ($b.theInfo.theType == Type.FLOAT)) {
                           TextCode.add("\%t" + varCount + " = fadd float \%t" + $theInfo.theVar.varIndex + ", \%t" + $b.theInfo.theVar.varIndex);
   					         $theInfo.theType = Type.FLOAT;
					            $theInfo.theVar.varIndex = varCount;
					            varCount ++;
                        }
                        else if (($a.theInfo.theType == Type.FLOAT) && ($b.theInfo.theType == Type.CONST_FLOAT)) {
                           TextCode.add("\%t" + varCount + " = fadd float \%t" + $theInfo.theVar.varIndex + ", " + $b.theInfo.theVar.fValue);
			                  $theInfo.theType = Type.FLOAT;
			                  $theInfo.theVar.varIndex = varCount;
                           varCount ++;
                        }
                        else if (($a.theInfo.theType == Type.CONST_FLOAT) && ($b.theInfo.theType == Type.FLOAT)) {
                           TextCode.add("\%t" + varCount + " = fadd float "+ $a.theInfo.theVar.fValue + ", \%t" + $b.theInfo.theVar.varIndex);
			                  $theInfo.theType = Type.FLOAT;
			                  $theInfo.theVar.varIndex = varCount;
                           varCount ++;
                        }
                        else if (($a.theInfo.theType == Type.CONST_FLOAT) && ($b.theInfo.theType == Type.CONST_FLOAT)) {
                           TextCode.add("\%t" + varCount + " = fadd float "+ $a.theInfo.theVar.fValue +", " + $b.theInfo.theVar.fValue);
                                 $theInfo.theType = Type.FLOAT;
                                 $theInfo.theVar.varIndex = varCount;
                                 varCount ++;
                        }
                        
                    }
                 | '-' b=multExpr
                     {
                        if (($a.theInfo.theType == Type.INT) && ($b.theInfo.theType == Type.INT)) {
                           TextCode.add("\%t" + varCount + " = sub nsw i32 \%t" + $theInfo.theVar.varIndex + ", \%t" + $b.theInfo.theVar.varIndex);
					            $theInfo.theType = Type.INT;
					            $theInfo.theVar.varIndex = varCount;
                           
					            varCount ++;
                        } 
                        else if (($a.theInfo.theType == Type.INT) && ($b.theInfo.theType == Type.CONST_INT))
		                  {
                           TextCode.add("\%t" + varCount + " = sub nsw i32 \%t" + $theInfo.theVar.varIndex + ", " + $b.theInfo.theVar.iValue);
			                  $theInfo.theType = Type.INT;
			                  $theInfo.theVar.varIndex = varCount;
                           varCount ++;
                        }
                        else if (($a.theInfo.theType == Type.CONST_INT) && ($b.theInfo.theType == Type.INT))
		                  {
                           TextCode.add("\%t" + varCount + " = sub nsw i32 " + $a.theInfo.theVar.iValue + ", \%t" + $b.theInfo.theVar.varIndex);
			                  $theInfo.theType = Type.INT;
			                  $theInfo.theVar.varIndex = varCount;
                           varCount ++;
                        }
                        else if (($a.theInfo.theType == Type.CONST_INT) && ($b.theInfo.theType == Type.CONST_INT))
		                  {
                            TextCode.add("\%t" + varCount + " = sub nsw i32 " + $a.theInfo.theVar.iValue + ", " + $b.theInfo.theVar.iValue);
			                  $theInfo.theType = Type.INT;
			                  $theInfo.theVar.varIndex = varCount;
                           varCount ++;
                        }
                        else if (($a.theInfo.theType == Type.FLOAT) && ($b.theInfo.theType == Type.FLOAT)) {
                           TextCode.add("\%t" + varCount + " = fsub float \%t" + $theInfo.theVar.varIndex + ", \%t" + $b.theInfo.theVar.varIndex);
   					         $theInfo.theType = Type.FLOAT;
					            $theInfo.theVar.varIndex = varCount;
					            varCount ++;
                        }
                        else if (($a.theInfo.theType == Type.FLOAT) && ($b.theInfo.theType == Type.CONST_FLOAT)) {
                           TextCode.add("\%t" + varCount + " = fsub float \%t" + $theInfo.theVar.varIndex + ", " + $b.theInfo.theVar.fValue);
			                  $theInfo.theType = Type.FLOAT;
			                  $theInfo.theVar.varIndex = varCount;
                           varCount ++;
                        }
                        else if (($a.theInfo.theType == Type.CONST_FLOAT) && ($b.theInfo.theType == Type.FLOAT)) {
                           TextCode.add("\%t" + varCount + " = fsub float "+ $a.theInfo.theVar.fValue + ", \%t" + $b.theInfo.theVar.varIndex);
			                  $theInfo.theType = Type.FLOAT;
			                  $theInfo.theVar.varIndex = varCount;
                           varCount ++;
                        }
                        else if (($a.theInfo.theType == Type.CONST_FLOAT) && ($b.theInfo.theType == Type.CONST_FLOAT)) {
                           TextCode.add("\%t" + varCount + " = fsub float "+ $a.theInfo.theVar.fValue +", " + $b.theInfo.theVar.fValue);
                                 $theInfo.theType = Type.FLOAT;
                                 $theInfo.theVar.varIndex = varCount;
                                 varCount ++;
                        }
                    }
                 )*
                 ;

multExpr
returns [Info theInfo]
@init {theInfo = new Info();}
          : a=signExpr { $theInfo=$a.theInfo; }
          ( '*' b = signExpr
            {
               if (($a.theInfo.theType == Type.INT) && ($b.theInfo.theType == Type.INT)) {
                           TextCode.add("\%t" + varCount + " = mul nsw i32 \%t" + $theInfo.theVar.varIndex + ", \%t" + $b.theInfo.theVar.varIndex);
					            $theInfo.theType = Type.INT;
					            $theInfo.theVar.varIndex = varCount;
                           
					            varCount ++;
                        } 
                        else if (($a.theInfo.theType == Type.INT) && ($b.theInfo.theType == Type.CONST_INT))
		                  {
                           TextCode.add("\%t" + varCount + " = mul nsw i32 \%t" + $theInfo.theVar.varIndex + ", " + $b.theInfo.theVar.iValue);
			                  $theInfo.theType = Type.INT;
			                  $theInfo.theVar.varIndex = varCount;
                           varCount ++;
                        }
                        else if (($a.theInfo.theType == Type.CONST_INT) && ($b.theInfo.theType == Type.INT))
		                  {
                           TextCode.add("\%t" + varCount + " = mul nsw i32 " + $a.theInfo.theVar.iValue + ", \%t" + $b.theInfo.theVar.varIndex);
			                  $theInfo.theType = Type.INT;
			                  $theInfo.theVar.varIndex = varCount;
                           varCount ++;
                        }
                        else if (($a.theInfo.theType == Type.CONST_INT) && ($b.theInfo.theType == Type.CONST_INT))
		                  {
                            TextCode.add("\%t" + varCount + " = mul nsw i32 " + $a.theInfo.theVar.iValue + ", " + $b.theInfo.theVar.iValue);
			                  $theInfo.theType = Type.INT;
			                  $theInfo.theVar.varIndex = varCount;
                           varCount ++;
                        }
                        else if (($a.theInfo.theType == Type.FLOAT) && ($b.theInfo.theType == Type.FLOAT)) {
                           TextCode.add("\%t" + varCount + " = fmul float \%t" + $theInfo.theVar.varIndex + ", \%t" + $b.theInfo.theVar.varIndex);
   					         $theInfo.theType = Type.FLOAT;
					            $theInfo.theVar.varIndex = varCount;
					            varCount ++;
                        }
                        else if (($a.theInfo.theType == Type.FLOAT) && ($b.theInfo.theType == Type.CONST_FLOAT)) {
                           TextCode.add("\%t" + varCount + " = fmul float \%t" + $theInfo.theVar.varIndex + ", " + $b.theInfo.theVar.fValue);
			                  $theInfo.theType = Type.FLOAT;
			                  $theInfo.theVar.varIndex = varCount;
                           varCount ++;
                        }
                        else if (($a.theInfo.theType == Type.CONST_FLOAT) && ($b.theInfo.theType == Type.FLOAT)) {
                           TextCode.add("\%t" + varCount + " = fmul float "+ $a.theInfo.theVar.fValue + ", \%t" + $b.theInfo.theVar.varIndex);
			                  $theInfo.theType = Type.FLOAT;
			                  $theInfo.theVar.varIndex = varCount;
                           varCount ++;
                        }
                        else if (($a.theInfo.theType == Type.CONST_FLOAT) && ($b.theInfo.theType == Type.CONST_FLOAT)) {
                           TextCode.add("\%t" + varCount + " = fmul float "+ $a.theInfo.theVar.fValue +", " + $b.theInfo.theVar.fValue);
                                 $theInfo.theType = Type.FLOAT;
                                 $theInfo.theVar.varIndex = varCount;
                                 varCount ++;
                        }
            }
          | '/' b=signExpr
            {
               if (($a.theInfo.theType == Type.INT) && ($b.theInfo.theType == Type.INT)) {
                           TextCode.add("\%t" + varCount + " = sdiv nsw i32 \%t" + $theInfo.theVar.varIndex + ", \%t" + $b.theInfo.theVar.varIndex);
					            $theInfo.theType = Type.INT;
					            $theInfo.theVar.varIndex = varCount;
                           
					            varCount ++;
                        } 
                        else if (($a.theInfo.theType == Type.INT) && ($b.theInfo.theType == Type.CONST_INT))
		                  {
                           TextCode.add("\%t" + varCount + " = sdiv nsw i32 \%t" + $theInfo.theVar.varIndex + ", " + $b.theInfo.theVar.iValue);
			                  $theInfo.theType = Type.INT;
			                  $theInfo.theVar.varIndex = varCount;
                           varCount ++;
                        }
                        else if (($a.theInfo.theType == Type.CONST_INT) && ($b.theInfo.theType == Type.INT))
		                  {
                           TextCode.add("\%t" + varCount + " = sdiv nsw i32 " + $a.theInfo.theVar.iValue + ", \%t" + $b.theInfo.theVar.varIndex);
			                  $theInfo.theType = Type.INT;
			                  $theInfo.theVar.varIndex = varCount;
                           varCount ++;
                        }
                        else if (($a.theInfo.theType == Type.CONST_INT) && ($b.theInfo.theType == Type.CONST_INT))
		                  {
                            TextCode.add("\%t" + varCount + " = sdiv nsw i32 " + $a.theInfo.theVar.iValue + ", " + $b.theInfo.theVar.iValue);
			                  $theInfo.theType = Type.INT;
			                  $theInfo.theVar.varIndex = varCount;
                           varCount ++;
                        }
                        else if (($a.theInfo.theType == Type.FLOAT) && ($b.theInfo.theType == Type.FLOAT)) {
                           TextCode.add("\%t" + varCount + " = fdiv float \%t" + $theInfo.theVar.varIndex + ", \%t" + $b.theInfo.theVar.varIndex);
   					         $theInfo.theType = Type.FLOAT;
					            $theInfo.theVar.varIndex = varCount;
					            varCount ++;
                        }
                        else if (($a.theInfo.theType == Type.FLOAT) && ($b.theInfo.theType == Type.CONST_FLOAT)) {
                           TextCode.add("\%t" + varCount + " = fdiv float \%t" + $theInfo.theVar.varIndex + ", " + $b.theInfo.theVar.fValue);
			                  $theInfo.theType = Type.FLOAT;
			                  $theInfo.theVar.varIndex = varCount;
                           varCount ++;
                        }
                        else if (($a.theInfo.theType == Type.CONST_FLOAT) && ($b.theInfo.theType == Type.FLOAT)) {
                           TextCode.add("\%t" + varCount + " = fdiv float "+ $a.theInfo.theVar.fValue + ", \%t" + $b.theInfo.theVar.varIndex);
			                  $theInfo.theType = Type.FLOAT;
			                  $theInfo.theVar.varIndex = varCount;
                           varCount ++;
                        }
                        else if (($a.theInfo.theType == Type.CONST_FLOAT) && ($b.theInfo.theType == Type.CONST_FLOAT)) {
                           TextCode.add("\%t" + varCount + " = fdiv float "+ $a.theInfo.theVar.fValue +", " + $b.theInfo.theVar.fValue);
                                 $theInfo.theType = Type.FLOAT;
                                 $theInfo.theVar.varIndex = varCount;
                                 varCount ++;
                        }
            }
	      )*
	  ;

signExpr
returns [Info theInfo]
@init {theInfo = new Info();}
        : a=primaryExpr { $theInfo=$a.theInfo; } 
        | '-' primaryExpr {$theInfo=$a.theInfo; $theInfo.theVar.iValue = -$a.theInfo.theVar.iValue; $theInfo.theVar.fValue = -$a.theInfo.theVar.fValue;}
   ;
		  
primaryExpr
returns [Info theInfo]
@init {theInfo = new Info();}
           : Integer_constant
	     {
            $theInfo.theType = Type.CONST_INT;
			$theInfo.theVar.iValue = Integer.parseInt($Integer_constant.text);
         
         
         }
           | Floating_point_constant
           {
            $theInfo.theType = Type.CONST_FLOAT;
			$theInfo.theVar.fValue = Float.parseFloat($Floating_point_constant.text);
         //System.out.println($theInfo.theVar.fValue);
         }
           

           | Identifier
              {
                // get type information from symtab.
                Type the_type = symtab.get($Identifier.text).theType;
				$theInfo.theType = the_type;

                // get variable index from symtab.
                int vIndex = symtab.get($Identifier.text).theVar.varIndex;
				
                switch (the_type) {
                case INT: 
                         // get a new temporary variable and
						 // load the variable into the temporary variable.
                         
						 // Ex: \%tx = load i32, i32* \%ty.
						 TextCode.add("\%t" + varCount + "=load i32, i32* \%t" + vIndex);
				         
						 // Now, Identifier's value is at the temporary variable \%t[varCount].
						 // Therefore, update it.
						 $theInfo.theVar.varIndex = varCount;
						 varCount ++;
                         break;
                case FLOAT:
                     TextCode.add("\%t" + varCount + "=load float, float* \%t" + vIndex);
                     $theInfo.theVar.varIndex = varCount;
                     varCount ++;
                         break;
                case CHAR:
                         break;
			
                }
              }
	   | '&' Identifier
	   | '(' a=arith_expression ')'{ $theInfo=$a.theInfo; } 
           ;

		   
/* description of the tokens */
FLOAT:'float';
INT:'int';
CHAR: 'char';

MAIN: 'main';
VOID: 'void';
IF: 'if';
ELSE: 'else';
FOR: 'for';
WHILE: 'while';
PRINTF: 'printf';
RETURN:'return';
DEFINE: 'define';
INCLUDE: 'include';

RelationOP: '>' |'>=' | '<' | '<=' | '==' | '!=';

Identifier:('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'0'..'9'|'_')*;
Integer_constant:'0'..'9'+;
Floating_point_constant:'0'..'9'+ '.' '0'..'9'+;

STRING_LITERAL
    :  '"' ( EscapeSequence | ~('\\'|'"') )* '"'
    ;

WS:( ' ' | '\t' | '\r' | '\n' ) {$channel=HIDDEN;};
COMMENT:'/*' .* '*/' {$channel=HIDDEN;};
HEADER : (Identifier)*'.h';

fragment
EscapeSequence
    :   '\\' ('b'|'t'|'n'|'f'|'r'|'\"'|'\''|'\\')
    ;
