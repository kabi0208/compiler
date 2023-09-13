/*大寫：terminal/token type 小寫：nonterminal*/
grammar myparser; // 前面沒寫type代表包含parser跟scanner

options { 
  language = Java;
}

@members { //全域變數的概念
    boolean TRACEON = false;
}



program: (prepare)* (VOID | INT) MAIN LSP_OP RSP_OP LLP_OP statements (ret)? RLP_OP
        {if (TRACEON) System.out.println("program:(prepare)* (VOID | INT) MAIN ( ) { statements ret}");}
        ;

prepare: inc { if (TRACEON) System.out.println("prepare: inc"); }
    | def  { if (TRACEON) System.out.println("prepare: def"); }
    | type list (opc arith_expression)? (CM_OP list (opc arith_expression)?)* SC_OP  { if (TRACEON) System.out.println("prepare: type list (opc arith_expression)? (, list (opc arith_expression)?)*;"); }
    | func { if (TRACEON) System.out.println("prepare: func"); }
    ; 

inc: HT_OP INCLUDE LT_OP HEADER GT_OP { if (TRACEON) System.out.println("inc: # INCLUDE < HEADER >"); }
    ;

def: HT_OP DEFINE Identifier Number { if (TRACEON) System.out.println("def: # DEFINE Identifier Number"); }
    ;

gol: type list (opc arith_expression)? SC_OP { if (TRACEON) System.out.println("gol: type list (opc arith_expression)? ;"); }
    ;

func:type Identifier LSP_OP type list (opc arith_expression)? (CM_OP type list (opc arith_expression)?)* RSP_OP LLP_OP  statements (ret)? RLP_OP
    { if (TRACEON) System.out.println("func:type MAIN~ Identifier ( type list (opc arith_expression)? (, type list (opc arith_expression)?)* ) {  statements ret}"); }
    ;

ret: RETURN arith_expression SC_OP { if (TRACEON) System.out.println("ret: RETURN arith_expression ;"); }
    ;


type:typeb typea { if (TRACEON) System.out.println("type:typeb typea"); }
   ;

typea: INT {if (TRACEON) System.out.println("typea: INT"); }
    | CHAR {if (TRACEON) System.out.println("typea: CHAR"); }
    | VOID {if (TRACEON) System.out.println("typea: VOID"); }
    | FLOAT {if (TRACEON) System.out.println("typea: FLOAT"); }
    | BOOL {if (TRACEON) System.out.println("typea: BOOL"); }
    | DOUBLE {if (TRACEON) System.out.println("typea: DOUBLE"); }
    | LONG {if (TRACEON) System.out.println("typea: LONG"); }
    | ENUM{if (TRACEON) System.out.println("typea: ENUM"); }
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

statement: list opc (arith_expression | LLP_OP decar RLP_OP) SC_OP {if (TRACEON) System.out.println("statement: list opc (arith_expression | {decar});"); }
    | IF if_then_statements (ELSE IF if_then_statements)* (ELSE loop_statements)? {if (TRACEON) System.out.println("statement: IF if_then_statements (ELSE IF if_then_statements)* (ELSE loop_statements)?"); }
	| FOR LSP_OP for_expression RSP_OP loop_statements {if (TRACEON) System.out.println("statement: FOR ( for_expression ) loop_statements"); }
    | DO LLP_OP statements RLP_OP WHILE LSP_OP arith_expression RSP_OP SC_OP {if (TRACEON) System.out.println("statement: DO { statements } WHILE ( arith_expression ) ;"); }
    | WHILE LSP_OP arith_expression (CM_OP arith_expression)* RSP_OP loop_statements {if (TRACEON) System.out.println("statement: WHILE LSP_OP arith_expression (, arith_expression)* RSP_OP loop_statements"); }
    | PRINTF LSP_OP LITERAL  (CM_OP arith_expression )*RSP_OP SC_OP {if (TRACEON) System.out.println("statement: PRINTF ( LITERAL  (, arith_expression )*) ;"); }
    | SCANF LSP_OP LITERAL (CM_OP (AND_AR)? list)*RSP_OP SC_OP {if (TRACEON) System.out.println("statement: SCANF ( LITERAL (, (&)? list)*) ;"); }
    | type list (opc (arith_expression | LLP_OP decar RLP_OP))? (CM_OP list (opc (arith_expression | LLP_OP decar RLP_OP))?)*SC_OP 
    {if (TRACEON) System.out.println("statement: type list (opc (arith_expression | { decar }))? (, list (opc (arith_expression | { decar }))?)*;"); }
    | BREAK SC_OP {if (TRACEON) System.out.println("statement: BREAK ;"); }
    | CONTINUE SC_OP {if (TRACEON) System.out.println("statement: CONTINUE ;"); }
    | SC_OP {if (TRACEON) System.out.println("statement: ;"); }
    | list (opb) SC_OP {if (TRACEON) System.out.println("statement: list (opb) ;"); }
    | (opb) list SC_OP {if (TRACEON) System.out.println("statement: (opb) list ;"); }
    | SWITCH LSP_OP arith_expression RSP_OP LLP_OP (CASE (Number | CHARACTER) COL_OP (statement)*)* (DEFAULT COL_OP (statement)*)? RLP_OP 
    {if (TRACEON) System.out.println("statement: SWITCH ( arith_expression ) { (CASE (Number | CHARACTER) : statement)* (DEFAULT : statement)? }"); }
    ;

for_expression: type? Identifier (EQ_AR | opa) arith_expression SC_OP Identifier (EQ_AR | opa) arith_expression SC_OP (Identifier opc arith_expression | Identifier (opb) | (opb) Identifier) 
    {if (TRACEON) System.out.println("for_expression: type? Identifier (EQ_AR | opa) arith_expression ; Identifier (EQ_AR | opa) arith_expression ; (Identifier opc arith_expression | Identifier (opb) | (opb) Identifier)"); }
    ;

decar: LLP_OP decar (CM_OP decar)* RLP_OP {if (TRACEON) System.out.println("decar: { decar (, decar)* }"); }
    | CHARACTER {if (TRACEON) System.out.println("decar: CHARACTER"); }
    | LITERAL {if (TRACEON) System.out.println("decar: LITERAL"); }
    ;

arith_expression: multExpr (opequ multExpr)* {if (TRACEON) System.out.println("arith_expression: multExpr (opequ multExpr)*"); } // + -
    ;

multExpr: signExpr (opg signExpr)* {if (TRACEON) System.out.println("multExpr: signExpr (opg signExpr)*"); }// * / %
    ;

signExpr: primaryExpr {if (TRACEON) System.out.println("signExpr: primaryExpr"); }
    | MI_AR Number {if (TRACEON) System.out.println("signExpr: MI_AR Number"); }
    | NOT_OP primaryExpr {if (TRACEON) System.out.println("signExpr: NOT_OP primaryExpr"); }
	;
		  
primaryExpr: Number {if (TRACEON) System.out.println("primaryExpr: Number"); }
    | list {if (TRACEON) System.out.println("primaryExpr: list"); }
    | LSP_OP arith_expression RSP_OP {if (TRACEON) System.out.println("primaryExpr: ( arith_expression )"); }
    | list (opb) {if (TRACEON) System.out.println("primaryExpr: list (opb)"); }
    | (opb) list {if (TRACEON) System.out.println("primaryExpr: (opb) list"); }
    | CHARACTER {if (TRACEON) System.out.println("primaryExpr: CHARACTER"); }
    | LITERAL {if (TRACEON) System.out.println("primaryExpr: LITERAL"); }
    | NULL {if (TRACEON) System.out.println("primaryExpr: NULL"); }
    | EOF {if (TRACEON) System.out.println("primaryExpr: EOF"); }
    | Identifier LSP_OP (arith_expression(CM_OP  arith_expression)*)?RSP_OP  {if (TRACEON) System.out.println("primaryExpr: Identifier ( (arith_expression(',' arith_expression)*)?')'"); }
    ;

if_then_statements: LSP_OP arith_expression RSP_OP loop_statements {if (TRACEON) System.out.println("if_then_statements:( arith_expression ) loop_statements"); }
    ;


loop_statements: arith_expression {if (TRACEON) System.out.println("loop_statements: arith_expression"); }
    | LLP_OP statements RLP_OP {if (TRACEON) System.out.println("loop_statements: { statements }"); }
	;

opequ: opf {if (TRACEON) System.out.println("opequ: opf"); }
    | opa {if (TRACEON) System.out.println("opequ: opa"); }
    | opd {if (TRACEON) System.out.println("opequ: opd"); }
    | ope {if (TRACEON) System.out.println("opequ: ope"); }
    ;

opa: EQ_OP {if (TRACEON) System.out.println("opa: =="); }
    | LE_OP {if (TRACEON) System.out.println("opa: <="); }
    | GE_OP {if (TRACEON) System.out.println("opa: >="); }
    | NE_OP {if (TRACEON) System.out.println("opa: !="); }
    | LT_OP {if (TRACEON) System.out.println("opa: <"); }
    | GT_OP {if (TRACEON) System.out.println("opa: >"); }//== <= >= != < >
    ;
opb: PP_OP {if (TRACEON) System.out.println("opb: ++"); }
    | MM_OP {if (TRACEON) System.out.println("opb: --"); }// ++ --
    ;
opc: PE_OP  {if (TRACEON) System.out.println("opc: +="); }
    | MIE_OP {if (TRACEON) System.out.println("opc: -="); }
    | MULE_OP {if (TRACEON) System.out.println("opc: *="); }
    | DIE_OP {if (TRACEON) System.out.println("opc: /="); }
    | RSHIFTE_OP {if (TRACEON) System.out.println("opc: <<="); }
    | LSHIFTE_OP {if (TRACEON) System.out.println("opc: >>="); }
    | ANDEQL_OP {if (TRACEON) System.out.println("opc: &="); }
    | XOREQL_OP {if (TRACEON) System.out.println("opc: ^="); }
    | OREQL_OP {if (TRACEON) System.out.println("opc: |="); }
    | REE_OP {if (TRACEON) System.out.println("opc:REE_OP"); }
    | EQ_AR {if (TRACEON) System.out.println("opc: ="); }// += -= *= /= %= =
    ;
opd:  AND_OP {if (TRACEON) System.out.println("opd: &&"); }
    | OR_OP {if (TRACEON) System.out.println("opd: ||"); }// && || 
    ;
ope: AND_AR {if (TRACEON) System.out.println("ope: & "); }
    | OR_AR {if (TRACEON) System.out.println("ope: | "); }
    | XOR_AR {if (TRACEON) System.out.println("ope: ^ "); }// & | ^
    ;
opf: PLU_AR {if (TRACEON) System.out.println("opf: + "); }
    | MI_AR {if (TRACEON) System.out.println("opf: - "); }// + -
    ;
opg: MUL_AR {if (TRACEON) System.out.println("opg: * "); }
    | DI_AR {if (TRACEON) System.out.println("opg: / "); }
    | RE_AR {if (TRACEON) System.out.println("opg: RE_AR "); }// * / %
    ;
list: Identifier (LMP_OP (Identifier | Number) ((opf | opg) (Identifier | Number))* RMP_OP)*
    {if (TRACEON) System.out.println("list: Identifier ([ (Identifier | Number) ((opf | opg) (Identifier | Number))*  ])*"); }
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

Number: ('0'..'9')+ ('.' ('0'..'9')+)?;


WS:( ' ' | '\t' | '\r' | '\n' ) {$channel=HIDDEN;};
COMMENT1:'/*' .* '*/' {$channel=HIDDEN;};
COMMENT2 : '//'(.)*'\n' {$channel=HIDDEN;};
LITERAL : '"'  .*  '"';
CHARACTER :  '\'' .*  '\'';
HEADER : (Identifier)*'.h';