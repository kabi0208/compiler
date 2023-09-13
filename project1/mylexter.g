lexer grammar mylexter;

options {
  language = Java;
}

LITERAL : '"' (options{greedy=false;}: .)*  '"';
CHARACTER :  '\'' (options{greedy=false;}: .)*  '\'';
HEADER : (LETTER)*'.h';
COMMENT1 : '//'(.)*'\n';
COMMENT2 : '/*' (options{greedy=false;}: .)* '*/';

/*----------------------*/
/*   Reserved Keywords  */
/*----------------------*/

INT_TYPE  : 'int';
CHAR_TYPE : 'char';
VOID_TYPE : 'void';
FLOAT_TYPE: 'float';
DOUBLE_TYPE : 'double';
BOOL_TYPE : '_Bool';
UNSIGNED_TYPE : 'unsigned';
SIGNED_TYPE : 'signed';
LONG_TYPE : 'long';
SHORT_TYPE : 'short';
CONST_TYPE : 'const';
STRUCT_TYPE : 'struct';//
UNION_TYPE : 'union';//
ENUM_TYPE : 'enum';

TYPEDEF_ : 'typedef'; //

MAIN_ : 'main';
WHILE_    : 'while';
DO_ : 'do';
IF_ : 'if';
ELSE_ : 'else';
FOR_ : 'for';
RETURN_ : 'return';
CONTINUE_ : 'continue';
BREAK_ : 'break';
SWITCH_ : 'switch'; //
CASE_: 'case'; //
DEFAULT_: 'default'; //
PRINTF_ : 'printf';
SCANF_ : 'scanf';

INCLUDE_: 'include';
DEFINE_: 'define';

NULL: 'NULL';
EEOF: 'EOF';

/*----------------------*/
/*  Compound Operators  */
/*----------------------*/
RSHIFTE_OP : '<<=';//
LSHIFTE_OP : '>>=';//
EQ_OP : '==';
LE_OP : '<=';
GE_OP : '>=';
NE_OP : '!=';

PP_OP : '++';
MM_OP : '--'; 

PE_OP : '+=';
MIE_OP : '-=';
MULE_OP : '*=';
DIE_OP: '/=';
REE_OP: '%=';

RSHIFT_OP : '<<';
LSHIFT_OP : '>>';
LT_OP : '<';
GT_OP: '>';
NOT_OP: '!';
AND_OP: '&&';
OR_OP: '||';
LMP_OP : '[';
RMP_OP : ']';
LLP_OP : '{';
RLP_OP : '}';
LSP_OP : '(';
RSP_OP : ')';
CM_OP : ',';
SC_OP : ';';

PT_OP: '->'; //
PR_OP: '.'; //
AND_AR: '&';
OR_AR: '|';
PLU_AR: '+';
MI_AR : '-';
MUL_AR : '*';
DI_AR : '/';
RE_AR : '%';
EQ_AR : '=';
COMP_OP : '~'; //
XOR_AR : '^';
QUE_OP : '?';//
COL_OP : ':';
HT_OP: '#';

SIZEOF_: 'sizeof'; //


DEC_NUM : ('0' | ('1'..'9')(DIGIT)*);

ID : (LETTER)(LETTER | DIGIT)*;

FLOAT_NUM: FLOAT_NUM1 | FLOAT_NUM2 | FLOAT_NUM3;
fragment FLOAT_NUM1: (DIGIT)+'.'(DIGIT)*;
fragment FLOAT_NUM2: '.'(DIGIT)+;
fragment FLOAT_NUM3: (DIGIT)+;


NEW_LINE: '\n';

fragment LETTER : 'a'..'z' | 'A'..'Z' | '_';
fragment DIGIT : '0'..'9';


WS  : (' '|'\r'|'\t')+
    ;
