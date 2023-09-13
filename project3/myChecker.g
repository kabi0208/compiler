/*大寫：terminal/token type 小寫：nonterminal*/
grammar myChecker; // 前面沒寫type代表包含parser跟scanner

options { 
  language = Java;
}
@header {
    // import packages here.
    import java.util.HashMap;
}
@members { //全域變數的概念
    boolean TRACEON = false;
    HashMap<String,Integer> symtab = new HashMap<String,Integer>();
}



program returns [int return_type]
    : (prepare)* (VOID {$return_type = 3;}| INT{$return_type = 1;}) MAIN LSP_OP RSP_OP LLP_OP statements (ret[$return_type])? RLP_OP
    {if (TRACEON) System.out.println("program:(prepare)* (VOID | INT) MAIN ( ) { statements ret}");}
        ;

gol [int type]
    :(CM_OP list (opc arith_expression)?) gol[type]
    {
        if (symtab.containsKey($list.name)) {
            System.out.println("Error! " + $CM_OP.getLine() + ": Redeclared list.");
        } 
        else {
            symtab.put($list.name, type);	   
        }
    }
    |
;
prepare: inc { if (TRACEON) System.out.println("prepare: inc"); }
    | def  { if (TRACEON) System.out.println("prepare: def"); }
    | type list (opc arith_expression)?  gol[$type.attr_type] SC_OP  
    { 
        if (TRACEON) System.out.println("prepare: type list (opc arith_expression)? (, list (opc arith_expression)?)*;"); 
        if (symtab.containsKey($list.name)) {
            System.out.println("Error! " + $type.start.getLine() + ": Redeclared list.");
        } 
        else {
            symtab.put($list.name, $type.attr_type);	   
        }
        if($arith_expression.attr_type > 0){
            if ($arith_expression.attr_type != $type.attr_type) {
                System.out.println("Error! " + $type.start.getLine() + ": Type mismatch for the two silde operands in an assignment statement.");
            }
       }
    }
    
    | func { if (TRACEON) System.out.println("prepare: func"); }
    ; 

inc: HT_OP INCLUDE LT_OP HEADER GT_OP { if (TRACEON) System.out.println("inc: # INCLUDE < HEADER >"); }
    ;

def: HT_OP DEFINE Identifier number 
    { 
        if (TRACEON) System.out.println("def: # DEFINE Identifier number"); 
        if (symtab.containsKey($Identifier.text)) {
            System.out.println("Error! " + $HT_OP.getLine() + ": Redeclared Identifier.");
        } 
        else {
            symtab.put($Identifier.text, $number.attr_type);	   
        }
    }
    ;

funcb: (CM_OP type list (opc arith_expression)?) funcb
    {
        if (symtab.containsKey($list.name)) {
            System.out.println("Error! " + $type.start.getLine() + ": Redeclared list.");
        } 
        else {
            symtab.put($list.name, $type.attr_type);	   
        }
        if($arith_expression.attr_type > 0){
            if ($arith_expression.attr_type != $type.attr_type) {
                System.out.println("Error! " + $type.start.getLine() + ": Type mismatch for the two silde operands in an assignment statement.");
            }
       }
    }
    |
    ;
funca: type list (opc arith_expression)? // 分副函式變數?
    {
        if (symtab.containsKey($list.name)) {
            System.out.println("Error! " + $type.start.getLine() + ": Redeclared list.");
        } 
        else {
            symtab.put($list.name, $type.attr_type);	   
        }
        if($arith_expression.attr_type > 0){
            if ($arith_expression.attr_type != $type.attr_type) {
                System.out.println("Error! " + $type.start.getLine() + ": Type mismatch for the two silde operands in an assignment statement.");
            }
       }
    }
;
func:a=type Identifier LSP_OP funca funcb RSP_OP LLP_OP  statements (ret[$a.attr_type])? RLP_OP
    { 
        if (TRACEON) System.out.println("func:type MAIN~ Identifier ( type list (opc arith_expression)? (, type list (opc arith_expression)?)* ) {  statements ret}"); 
        if (symtab.containsKey($Identifier.text)) {
            System.out.println("Error! " + $a.start.getLine() + ": Redeclared Identifier.");
        } 
        else {
            symtab.put($Identifier.text, $a.attr_type);	   
        }
    }
    ;

ret [int return_type]
    : RETURN arith_expression SC_OP 
    { 
        if (TRACEON) System.out.println("ret: RETURN arith_expression ;"); 
        if($arith_expression.attr_type!=return_type){
            System.out.println("Error! " + $RETURN.getLine() + ": Wrong return type.");
        }
    }
    ;


type  returns [int attr_type]
:typeb typea { if (TRACEON) System.out.println("type:typeb typea"); $attr_type = $typea.attr_type;}
   ;

typea returns [int attr_type]
    : INT {if (TRACEON) System.out.println("typea: INT");  $attr_type = 1; }
    | CHAR {if (TRACEON) System.out.println("typea: CHAR");  $attr_type = 2; }
    | VOID {if (TRACEON) System.out.println("typea: VOID");  $attr_type = 3; }
    | FLOAT {if (TRACEON) System.out.println("typea: FLOAT");  $attr_type = 4; }
    | BOOL {if (TRACEON) System.out.println("typea: BOOL");  $attr_type = 5; }
    | DOUBLE {if (TRACEON) System.out.println("typea: DOUBLE");  $attr_type = 4; }
    | ENUM{if (TRACEON) System.out.println("typea: ENUM");  $attr_type = 7; }
    ;

typeb: UNSIGNED {if (TRACEON) System.out.println("typeb: UNSIGNED"); }
    | SIGNED {if (TRACEON) System.out.println("typeb: SIGNED"); }
    | LONG {if (TRACEON) System.out.println("typeb: LONG"); }
    | SHORT {if (TRACEON) System.out.println("typeb: SHORT"); }
    | CONST {if (TRACEON) System.out.println("typeb: CONST"); }
    | {if (TRACEON) System.out.println("typeb: "); }
    ;

statements:statement statements {if (TRACEON) System.out.println("statements:statement statements"); }
    | {if (TRACEON) System.out.println("statements: "); }
    ;

calculate returns [int attr_type]
    : arith_expression {if (TRACEON) System.out.println("calculate: arith_expression");  $attr_type = $arith_expression.attr_type; }
    | LLP_OP decar RLP_OP {if (TRACEON) System.out.println("calculate: LLP_OP decar RLP_OP");  $attr_type = $decar.attr_type; }
    ;
statement: list opc calculate SC_OP 
    {
        if (TRACEON) System.out.println("statement: list opc (arith_expression | {decar});");
        if (symtab.containsKey($list.name)) {
            if(symtab.get($list.name)!=$calculate.attr_type){
                System.out.println("Error! " + $list.start.getLine() + ": Type mismatch for the two silde operands in an assignment statement.");
            }
        } 
        else {
            System.out.println("Error! " + $list.start.getLine() + ": Undefined list.");
        } 
    }
    | IF if_then_statements (ELSE IF if_then_statements)* (ELSE loop_statements)? {if (TRACEON) System.out.println("statement: IF if_then_statements (ELSE IF if_then_statements)* (ELSE loop_statements)?"); }
	| FOR LSP_OP for_expression RSP_OP loop_statements {if (TRACEON) System.out.println("statement: FOR ( for_expression ) loop_statements"); }
    | DO LLP_OP statements RLP_OP WHILE LSP_OP arith_expression RSP_OP SC_OP {if (TRACEON) System.out.println("statement: DO { statements } WHILE ( arith_expression ) ;"); }
    | WHILE LSP_OP arith_expression (CM_OP arith_expression)* RSP_OP loop_statements {if (TRACEON) System.out.println("statement: WHILE LSP_OP arith_expression (, arith_expression)* RSP_OP loop_statements"); }
    | PRINTF LSP_OP LITERAL  (CM_OP arith_expression )*RSP_OP SC_OP {if (TRACEON) System.out.println("statement: PRINTF ( LITERAL  (, arith_expression )*) ;"); }
    | SCANF LSP_OP LITERAL (CM_OP (AND_AR)? list)*RSP_OP SC_OP {if (TRACEON) System.out.println("statement: SCANF ( LITERAL (, (&)? list)*) ;"); }
    | type list (opc calculate)? (more[$type.attr_type]) SC_OP 
    {
        if (TRACEON) System.out.println("statement: type list (opc (arith_expression | { decar }))? more ;"); 
        if (symtab.containsKey($list.name)) {
            System.out.println("Error! " + $type.start.getLine() + ": Redeclared list.");
        } 
        else {
            symtab.put($list.name, $type.attr_type);   
        }
        if ($calculate.attr_type > 0) {
            if(symtab.get($list.name)!=$calculate.attr_type){
                System.out.println("Error! " + $type.start.getLine() + ": Type mismatch for the two silde operands in an assignment statement.");
            }
        } 
    }
    | BREAK SC_OP {if (TRACEON) System.out.println("statement: BREAK ;"); }
    | CONTINUE SC_OP {if (TRACEON) System.out.println("statement: CONTINUE ;"); }
    | SC_OP {if (TRACEON) System.out.println("statement: ;"); }
    | list (opb) SC_OP {if (TRACEON) System.out.println("statement: list (opb) ;"); } //
    | (opb) list SC_OP {if (TRACEON) System.out.println("statement: (opb) list ;"); }
    | SWITCH LSP_OP arith_expression RSP_OP LLP_OP (CASE (number | CHARACTER) COL_OP (statement)*)* (DEFAULT COL_OP (statement)*)? RLP_OP 
    {if (TRACEON) System.out.println("statement: SWITCH ( arith_expression ) { (CASE (number | CHARACTER) : statement)* (DEFAULT : statement)? }"); }
    ;

more [int type]
    : (CM_OP list (opc calculate)?) more[type]
    {
        if (symtab.containsKey($list.name)) {
            System.out.println("Error! " + $CM_OP.getLine() + ": Redeclared list.");
        } 
        else {
            symtab.put($list.name, type);	   
        }
        if ($calculate.attr_type > 0) {
            if(symtab.get($list.name)!=$calculate.attr_type){
                System.out.println("Error! " + $CM_OP.getLine() + ": Type mismatch for the two silde operands in an assignment statement.");
            }
        } 
    }
    | 
    ;

for_expression: e = type? f=Identifier (EQ_AR | opa) g=arith_expression SC_OP h=Identifier (EQ_AR | opa) i=arith_expression SC_OP (j=Identifier opc k=arith_expression | Identifier (opb) | (opb) Identifier) 
    {
        if (TRACEON) System.out.println("for_expression: type? Identifier (EQ_AR | opa) arith_expression ; Identifier (EQ_AR | opa) arith_expression ; (Identifier opc arith_expression | Identifier (opb) | (opb) Identifier)"); 
        if($e.attr_type > 0){
            if (symtab.containsKey($f.text)) {
                System.out.println("Error! " + $e.start.getLine() + ": Redeclared Identifier.");
            } 
            else {
                symtab.put($f.text, $e.attr_type);	   
            }
        }
        /*
        if($g.attr_type<5 || $i.attr_type<5){
            System.out.println("Error! "+ $f.getLine() + ": Type error, expect boolen.");
            System.out.println($g.attr_type);
        }*/
        
        if(symtab.get($f.text)!=$g.attr_type||symtab.get($h.text)!=$i.attr_type){
            System.out.println("Error! " + $e.start.getLine() + ": Type mismatch for the two silde operands in an assignment statement.");
        }
        
        if($k.attr_type>0){
            if(symtab.get($j.text)!=$k.attr_type){
                System.out.println("Error! " + $e.start.getLine() + ": Type mismatch for the two silde operands in an assignment statement.");
            }
        }
    }
    ;

decar  returns [int attr_type]
    : LLP_OP a = decar (CM_OP decar)* RLP_OP {if (TRACEON) System.out.println("decar: { decar (, decar)* }"); $attr_type = $a.attr_type;}
    | CHARACTER {if (TRACEON) System.out.println("decar: CHARACTER"); $attr_type = 2;}
    | LITERAL {if (TRACEON) System.out.println("decar: LITERAL"); $attr_type = 2;}
    ;
opmult  returns [int attr_type, int op_type]
    : opd multExpr aa=opmult 
    {
        $attr_type = $multExpr.attr_type;
        $op_type = $opd.op_type;
        if($aa.attr_type>0 ){//
            if($multExpr.attr_type!=$aa.attr_type&& ($aa.op_type!=3)){
                System.out.println("Error! " + $opd.start.getLine() + ": Type mismatch for the two silde operands in an assignment statement.");
            }
            if($aa.op_type == 3){
                $attr_type = 5;
            }
        }
    }
    | {$attr_type = 0;}
    ;
arith_expression  returns [int attr_type, int op_type]
    : multExpr opmult 
    {
        $op_type = $multExpr.op_type;
        if (TRACEON) System.out.println("arith_expression: multExpr (opequ multExpr)*");$attr_type = $multExpr.attr_type;
        if($opmult.attr_type!=0 ){
            $op_type = $opmult.op_type;
            if ($opmult.attr_type != $multExpr.attr_type && ($opmult.op_type!=3)) {
                System.out.println("Error! " + $multExpr.start.getLine() + ": Type mismatch for the two silde operands in an assignment statement.");
                $attr_type = -1;
            }
            
       }
       if($op_type > 1){
            $attr_type = 5;
        }
    } // + -
    ;
opsign  returns [int attr_type, int op_type]
    : opequ signExpr aa=opsign 
    {
        $attr_type = $signExpr.attr_type;
        $op_type = $opequ.op_type;
        if(($aa.attr_type>0)){//
            if($signExpr.attr_type!=$aa.attr_type && ($aa.op_type!=3)){
                System.out.println("Error! " + $opequ.start.getLine() + ": Type mismatch for the two silde operands in an assignment statement.");
            }
            if($aa.op_type == 3){
                $attr_type = 5;
            }
        }
    }
    | {$attr_type = 0;$op_type = 3;}
    ;
multExpr  returns [int attr_type, int op_type]
    : signExpr opsign 
    {
        $op_type = $signExpr.op_type;
        if (TRACEON) System.out.println("multExpr: signExpr (opg signExpr)*"); $attr_type = $signExpr.attr_type;
        if(($opsign.attr_type!=0) ){
            $op_type = $opsign.op_type;
            if ($opsign.attr_type != $signExpr.attr_type&& ($opsign.op_type!=3)) {
                System.out.println("Error! " + $signExpr.start.getLine() + ": Type mismatch for the two silde operands in an assignment statement.");
                $attr_type = -2;
            }
            if($opsign.op_type == 3){
                $attr_type = 5;
            }
       }
    }// * / %
    ;

signExpr  returns [int attr_type, int op_type]
    : primaryExpr {if (TRACEON) System.out.println("signExpr: primaryExpr"); $attr_type = $primaryExpr.attr_type; $op_type = $primaryExpr.op_type;}
    | MI_AR number {if (TRACEON) System.out.println("signExpr: MI_AR number"); $attr_type = $number.attr_type;}
    | NOT_OP primaryExpr {if (TRACEON) System.out.println("signExpr: NOT_OP primaryExpr"); $attr_type = $primaryExpr.attr_type;$op_type = $primaryExpr.op_type;}
	;
number  returns [int attr_type]
    : Int {if (TRACEON) System.out.println("number: Int");  $attr_type = 1; }
    | Float {if (TRACEON) System.out.println("number: Float");  $attr_type = 4; }
    ;
primaryExpr returns [int attr_type, int op_type]
    : number {if (TRACEON) System.out.println("primaryExpr: number");  $attr_type = $number.attr_type;}
    | list 
    {
        if (TRACEON) System.out.println("primaryExpr: list");
        if (symtab.containsKey($list.name)) {
            $attr_type = symtab.get($list.name);
        } 
        else {
            System.out.println("Error! " + $list.start.getLine() + ": Undefined list.");
        } 
    }
    | LSP_OP arith_expression RSP_OP {if (TRACEON) System.out.println("primaryExpr: ( arith_expression )"); $attr_type = $arith_expression.attr_type;$op_type = $arith_expression.op_type;}
    | list (opb) 
    {
        $op_type = 2;
        if (TRACEON) System.out.println("primaryExpr: list (opb) ");
        if (symtab.containsKey($list.name)) {
            $attr_type = symtab.get($list.name);
        } 
        else {
            System.out.println("Error! " + $list.start.getLine() + ": Undefined list.");
        } 
    }
    | opb list 
    {
        $op_type = 2;
        if (TRACEON) System.out.println("primaryExpr: (opb) list  ");
        if (symtab.containsKey($list.name)) {
            $attr_type = symtab.get($list.name);
        } 
        else {
            System.out.println("Error! " + $opb.start.getLine() + ": Undefined list.");
        } 
    }
    | CHARACTER {if (TRACEON) System.out.println("primaryExpr: CHARACTER"); $attr_type = 2;}
    | LITERAL {if (TRACEON) System.out.println("primaryExpr: LITERAL"); $attr_type = 2;}
    | NULL {if (TRACEON) System.out.println("primaryExpr: NULL"); $attr_type = 2;}
    | EOF {if (TRACEON) System.out.println("primaryExpr: EOF"); $attr_type = 2;}
    | idd = Identifier LSP_OP (arith_expression(CM_OP  arith_expression)*)?RSP_OP  // call function
    {
        if (TRACEON) System.out.println("primaryExpr: Identifier ( (arith_expression(',' arith_expression)*)?')'"); 
        if (symtab.containsKey($idd.text)) {
            $attr_type = symtab.get($idd.text);
        } 
        else {
            System.out.println("Error! " + $Identifier.getLine() + ": Undefined Identifier.");
        } 
    }
    ;

if_then_statements: LSP_OP arith_expression RSP_OP loop_statements 
    {
        if (TRACEON) System.out.println("if_then_statements:( arith_expression ) loop_statements"); 
        if($arith_expression.attr_type!=5){
            System.out.println("Error! "+ $LSP_OP.getLine() + ": Type error, expect boolen.");
        }
    }
    ;


loop_statements: arith_expression 
    {
        if (TRACEON) System.out.println("loop_statements: arith_expression"); 
        if($arith_expression.attr_type!=5){
            System.out.println("Error! "+ $arith_expression.start.getLine() + ": Type error, expect boolen.");
        }
    }
    | LLP_OP statements RLP_OP {if (TRACEON) System.out.println("loop_statements: { statements }"); }
	;

opequ returns [int op_type]
    : opf {if (TRACEON) System.out.println("opequ: opf"); $op_type = $opf.op_type;}
    | opa {if (TRACEON) System.out.println("opequ: opa"); $op_type = $opa.op_type;}
    | opg {if (TRACEON) System.out.println("opequ: opd"); $op_type = $opg.op_type;}
    | ope {if (TRACEON) System.out.println("opequ: ope"); $op_type = $ope.op_type;}
    ;

opa returns [int op_type]
    : EQ_OP {if (TRACEON) System.out.println("opa: =="); $op_type = 2;}
    | LE_OP {if (TRACEON) System.out.println("opa: <="); $op_type = 2;}
    | GE_OP {if (TRACEON) System.out.println("opa: >="); $op_type = 2;}
    | NE_OP {if (TRACEON) System.out.println("opa: !="); $op_type = 2;}
    | LT_OP {if (TRACEON) System.out.println("opa: <"); $op_type = 2;}
    | GT_OP {if (TRACEON) System.out.println("opa: >"); $op_type = 2;}//== <= >= != < >
    ;
opb returns [int op_type]
    : PP_OP {if (TRACEON) System.out.println("opb: ++"); $op_type = 2;}
    | MM_OP {if (TRACEON) System.out.println("opb: --"); $op_type = 2;}// ++ --
    ;
opc returns [int op_type]
    : PE_OP  {if (TRACEON) System.out.println("opc: +=");  $op_type = 2;}
    | MIE_OP {if (TRACEON) System.out.println("opc: -=");  $op_type = 2;}
    | MULE_OP {if (TRACEON) System.out.println("opc: *=");  $op_type = 2;}
    | DIE_OP {if (TRACEON) System.out.println("opc: /=");  $op_type = 2;}
    | RSHIFTE_OP {if (TRACEON) System.out.println("opc: <<=");  $op_type = 2;}
    | LSHIFTE_OP {if (TRACEON) System.out.println("opc: >>=");  $op_type = 2;}
    | ANDEQL_OP {if (TRACEON) System.out.println("opc: &="); $op_type = 2;}
    | XOREQL_OP {if (TRACEON) System.out.println("opc: ^="); $op_type = 2;}
    | OREQL_OP {if (TRACEON) System.out.println("opc: |="); $op_type = 2;}
    | REE_OP {if (TRACEON) System.out.println("opc:REE_OP"); $op_type = 2;}
    | EQ_AR {if (TRACEON) System.out.println("opc: ="); $op_type = 2;}// += -= *= /= %= =
    ;
opd returns [int op_type]
    :  AND_OP {if (TRACEON) System.out.println("opd: &&"); $op_type = 3;}
    | OR_OP {if (TRACEON) System.out.println("opd: ||"); $op_type = 3;}// && || 
    ;
ope returns [int op_type]
    : AND_AR {if (TRACEON) System.out.println("ope: & "); $op_type = 2;}
    | OR_AR {if (TRACEON) System.out.println("ope: | "); $op_type = 2;}
    | XOR_AR {if (TRACEON) System.out.println("ope: ^ "); $op_type = 2;}// & | ^
    ;
opf returns [int op_type]
    : PLU_AR {if (TRACEON) System.out.println("opf: + "); $op_type = 1;}
    | MI_AR {if (TRACEON) System.out.println("opf: - "); $op_type = 1;}// + -
    ;
opg returns [int op_type]
    : MUL_AR {if (TRACEON) System.out.println("opg: * "); $op_type = 1;}
    | DI_AR {if (TRACEON) System.out.println("opg: / "); $op_type = 1;}
    | RE_AR {if (TRACEON) System.out.println("opg: RE_AR "); $op_type = 1;}// * / %
    ;
list returns [String name]
    : kabi = Identifier (LMP_OP (Identifier | Int) ((opf | opg) (Identifier | Int))* RMP_OP)* //
    {if (TRACEON) System.out.println("list: Identifier ([ (Identifier | Int) ((opf | opg) (Identifier | Int))*  ])*"); $name = $kabi.text;}
    ;

/* description of the tokens */
INT : 'int';
CHAR : 'char';
VOID : 'void';
FLOAT: 'float';
DOUBLE : 'double';
BOOL : '_Bool';
UNSIGNED : 'unsigned';
SIGNED : 'signed';
LONG : 'long';
SHORT : 'short';
CONST : 'const';
ENUM : 'enum';

EQ_OP : '==';
LE_OP : '<=';
GE_OP : '>=';
NE_OP : '!=';
PE_OP : '+=';
MIE_OP : '-=';
MULE_OP : '*=';
DIE_OP: '/=';
REE_OP: '%=';
RSHIFTE_OP : '<<=';
LSHIFTE_OP : '>>=';
ANDEQL_OP: '&=';
XOREQL_OP: '^=';
OREQL_OP: '|=';

LT_OP : '<';
GT_OP: '>';
AND_OP: '&&';
OR_OP: '||';
AND_AR: '&';
OR_AR: '|';
PLU_AR: '+';
MI_AR : '-';
MUL_AR : '*';
DI_AR : '/';
RE_AR : '%';
XOR_AR : '^';
EQ_AR : '=';

NOT_OP: '!';
HT_OP: '#';
COL_OP : ':';
CM_OP : ',';
SC_OP : ';';
LMP_OP : '[';
RMP_OP : ']';
LLP_OP : '{';
RLP_OP : '}';
LSP_OP : '(';
RSP_OP : ')';
PP_OP : '++';
MM_OP : '--'; 

MAIN: 'main';
IF: 'if';
FOR: 'for';
RETURN: 'return';
WHILE: 'while';
DO: 'do';
PRINTF: 'printf';
ELSE: 'else';
INCLUDE: 'include';
DEFINE: 'define';
SCANF: 'scanf';
CONTINUE: 'continue';
BREAK: 'break';
NULL: 'NULL';
EEOF: 'EOF';

SWITCH: 'switch';
CASE: 'case';
DEFAULT: 'default';

Identifier:('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'0'..'9'|'_')* ;

Float: ('0'..'9')+ ('.' ('0'..'9')+);
Int :('0'..'9')+;


WS:( ' ' | '\t' | '\r' | '\n' ) {$channel=HIDDEN;};
COMMENT1:'/*' .* '*/' {$channel=HIDDEN;};
COMMENT2 : '//'(.)*'\n' {$channel=HIDDEN;};
LITERAL : '"'  .*  '"';
CHARACTER :  '\'' .*  '\'';
HEADER : (Identifier)*'.h';