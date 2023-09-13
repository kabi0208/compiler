// $ANTLR 3.5.3 mylexter.g 2023-03-23 19:51:20

import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class mylexter extends Lexer {
	public static final int EOF=-1;
	public static final int AND_AR=4;
	public static final int AND_OP=5;
	public static final int BOOL_TYPE=6;
	public static final int BREAK_=7;
	public static final int CASE_=8;
	public static final int CHARACTER=9;
	public static final int CHAR_TYPE=10;
	public static final int CM_OP=11;
	public static final int COL_OP=12;
	public static final int COMMENT1=13;
	public static final int COMMENT2=14;
	public static final int COMP_OP=15;
	public static final int CONST_TYPE=16;
	public static final int CONTINUE_=17;
	public static final int DEC_NUM=18;
	public static final int DEFAULT_=19;
	public static final int DEFINE_=20;
	public static final int DIE_OP=21;
	public static final int DIGIT=22;
	public static final int DI_AR=23;
	public static final int DOUBLE_TYPE=24;
	public static final int DO_=25;
	public static final int EEOF=26;
	public static final int ELSE_=27;
	public static final int ENUM_TYPE=28;
	public static final int EQ_AR=29;
	public static final int EQ_OP=30;
	public static final int FLOAT_NUM=31;
	public static final int FLOAT_NUM1=32;
	public static final int FLOAT_NUM2=33;
	public static final int FLOAT_NUM3=34;
	public static final int FLOAT_TYPE=35;
	public static final int FOR_=36;
	public static final int GE_OP=37;
	public static final int GT_OP=38;
	public static final int HEADER=39;
	public static final int HT_OP=40;
	public static final int ID=41;
	public static final int IF_=42;
	public static final int INCLUDE_=43;
	public static final int INT_TYPE=44;
	public static final int LETTER=45;
	public static final int LE_OP=46;
	public static final int LITERAL=47;
	public static final int LLP_OP=48;
	public static final int LMP_OP=49;
	public static final int LONG_TYPE=50;
	public static final int LSHIFTE_OP=51;
	public static final int LSHIFT_OP=52;
	public static final int LSP_OP=53;
	public static final int LT_OP=54;
	public static final int MAIN_=55;
	public static final int MIE_OP=56;
	public static final int MI_AR=57;
	public static final int MM_OP=58;
	public static final int MULE_OP=59;
	public static final int MUL_AR=60;
	public static final int NEW_LINE=61;
	public static final int NE_OP=62;
	public static final int NOT_OP=63;
	public static final int NULL=64;
	public static final int OR_AR=65;
	public static final int OR_OP=66;
	public static final int PE_OP=67;
	public static final int PLU_AR=68;
	public static final int PP_OP=69;
	public static final int PRINTF_=70;
	public static final int PR_OP=71;
	public static final int PT_OP=72;
	public static final int QUE_OP=73;
	public static final int REE_OP=74;
	public static final int RETURN_=75;
	public static final int RE_AR=76;
	public static final int RLP_OP=77;
	public static final int RMP_OP=78;
	public static final int RSHIFTE_OP=79;
	public static final int RSHIFT_OP=80;
	public static final int RSP_OP=81;
	public static final int SCANF_=82;
	public static final int SC_OP=83;
	public static final int SHORT_TYPE=84;
	public static final int SIGNED_TYPE=85;
	public static final int SIZEOF_=86;
	public static final int STRUCT_TYPE=87;
	public static final int SWITCH_=88;
	public static final int TYPEDEF_=89;
	public static final int UNION_TYPE=90;
	public static final int UNSIGNED_TYPE=91;
	public static final int VOID_TYPE=92;
	public static final int WHILE_=93;
	public static final int WS=94;
	public static final int XOR_AR=95;

	// delegates
	// delegators
	public Lexer[] getDelegates() {
		return new Lexer[] {};
	}

	public mylexter() {} 
	public mylexter(CharStream input) {
		this(input, new RecognizerSharedState());
	}
	public mylexter(CharStream input, RecognizerSharedState state) {
		super(input,state);
	}
	@Override public String getGrammarFileName() { return "mylexter.g"; }

	// $ANTLR start "LITERAL"
	public final void mLITERAL() throws RecognitionException {
		try {
			int _type = LITERAL;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// mylexter.g:7:9: ( '\"' ( options {greedy=false; } : . )* '\"' )
			// mylexter.g:7:11: '\"' ( options {greedy=false; } : . )* '\"'
			{
			match('\"'); 
			// mylexter.g:7:15: ( options {greedy=false; } : . )*
			loop1:
			while (true) {
				int alt1=2;
				int LA1_0 = input.LA(1);
				if ( (LA1_0=='\"') ) {
					alt1=2;
				}
				else if ( ((LA1_0 >= '\u0000' && LA1_0 <= '!')||(LA1_0 >= '#' && LA1_0 <= '\uFFFF')) ) {
					alt1=1;
				}

				switch (alt1) {
				case 1 :
					// mylexter.g:7:40: .
					{
					matchAny(); 
					}
					break;

				default :
					break loop1;
				}
			}

			match('\"'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "LITERAL"

	// $ANTLR start "CHARACTER"
	public final void mCHARACTER() throws RecognitionException {
		try {
			int _type = CHARACTER;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// mylexter.g:8:11: ( '\\'' ( options {greedy=false; } : . )* '\\'' )
			// mylexter.g:8:14: '\\'' ( options {greedy=false; } : . )* '\\''
			{
			match('\''); 
			// mylexter.g:8:19: ( options {greedy=false; } : . )*
			loop2:
			while (true) {
				int alt2=2;
				int LA2_0 = input.LA(1);
				if ( (LA2_0=='\'') ) {
					alt2=2;
				}
				else if ( ((LA2_0 >= '\u0000' && LA2_0 <= '&')||(LA2_0 >= '(' && LA2_0 <= '\uFFFF')) ) {
					alt2=1;
				}

				switch (alt2) {
				case 1 :
					// mylexter.g:8:44: .
					{
					matchAny(); 
					}
					break;

				default :
					break loop2;
				}
			}

			match('\''); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "CHARACTER"

	// $ANTLR start "HEADER"
	public final void mHEADER() throws RecognitionException {
		try {
			int _type = HEADER;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// mylexter.g:9:8: ( ( LETTER )* '.h' )
			// mylexter.g:9:10: ( LETTER )* '.h'
			{
			// mylexter.g:9:10: ( LETTER )*
			loop3:
			while (true) {
				int alt3=2;
				int LA3_0 = input.LA(1);
				if ( ((LA3_0 >= 'A' && LA3_0 <= 'Z')||LA3_0=='_'||(LA3_0 >= 'a' && LA3_0 <= 'z')) ) {
					alt3=1;
				}

				switch (alt3) {
				case 1 :
					// mylexter.g:
					{
					if ( (input.LA(1) >= 'A' && input.LA(1) <= 'Z')||input.LA(1)=='_'||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					}
					break;

				default :
					break loop3;
				}
			}

			match(".h"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "HEADER"

	// $ANTLR start "COMMENT1"
	public final void mCOMMENT1() throws RecognitionException {
		try {
			int _type = COMMENT1;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// mylexter.g:10:10: ( '//' ( . )* '\\n' )
			// mylexter.g:10:12: '//' ( . )* '\\n'
			{
			match("//"); 

			// mylexter.g:10:16: ( . )*
			loop4:
			while (true) {
				int alt4=2;
				int LA4_0 = input.LA(1);
				if ( (LA4_0=='\n') ) {
					alt4=2;
				}
				else if ( ((LA4_0 >= '\u0000' && LA4_0 <= '\t')||(LA4_0 >= '\u000B' && LA4_0 <= '\uFFFF')) ) {
					alt4=1;
				}

				switch (alt4) {
				case 1 :
					// mylexter.g:10:17: .
					{
					matchAny(); 
					}
					break;

				default :
					break loop4;
				}
			}

			match('\n'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "COMMENT1"

	// $ANTLR start "COMMENT2"
	public final void mCOMMENT2() throws RecognitionException {
		try {
			int _type = COMMENT2;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// mylexter.g:11:10: ( '/*' ( options {greedy=false; } : . )* '*/' )
			// mylexter.g:11:12: '/*' ( options {greedy=false; } : . )* '*/'
			{
			match("/*"); 

			// mylexter.g:11:17: ( options {greedy=false; } : . )*
			loop5:
			while (true) {
				int alt5=2;
				int LA5_0 = input.LA(1);
				if ( (LA5_0=='*') ) {
					int LA5_1 = input.LA(2);
					if ( (LA5_1=='/') ) {
						alt5=2;
					}
					else if ( ((LA5_1 >= '\u0000' && LA5_1 <= '.')||(LA5_1 >= '0' && LA5_1 <= '\uFFFF')) ) {
						alt5=1;
					}

				}
				else if ( ((LA5_0 >= '\u0000' && LA5_0 <= ')')||(LA5_0 >= '+' && LA5_0 <= '\uFFFF')) ) {
					alt5=1;
				}

				switch (alt5) {
				case 1 :
					// mylexter.g:11:42: .
					{
					matchAny(); 
					}
					break;

				default :
					break loop5;
				}
			}

			match("*/"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "COMMENT2"

	// $ANTLR start "INT_TYPE"
	public final void mINT_TYPE() throws RecognitionException {
		try {
			int _type = INT_TYPE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// mylexter.g:17:11: ( 'int' )
			// mylexter.g:17:13: 'int'
			{
			match("int"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "INT_TYPE"

	// $ANTLR start "CHAR_TYPE"
	public final void mCHAR_TYPE() throws RecognitionException {
		try {
			int _type = CHAR_TYPE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// mylexter.g:18:11: ( 'char' )
			// mylexter.g:18:13: 'char'
			{
			match("char"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "CHAR_TYPE"

	// $ANTLR start "VOID_TYPE"
	public final void mVOID_TYPE() throws RecognitionException {
		try {
			int _type = VOID_TYPE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// mylexter.g:19:11: ( 'void' )
			// mylexter.g:19:13: 'void'
			{
			match("void"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "VOID_TYPE"

	// $ANTLR start "FLOAT_TYPE"
	public final void mFLOAT_TYPE() throws RecognitionException {
		try {
			int _type = FLOAT_TYPE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// mylexter.g:20:11: ( 'float' )
			// mylexter.g:20:13: 'float'
			{
			match("float"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "FLOAT_TYPE"

	// $ANTLR start "DOUBLE_TYPE"
	public final void mDOUBLE_TYPE() throws RecognitionException {
		try {
			int _type = DOUBLE_TYPE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// mylexter.g:21:13: ( 'double' )
			// mylexter.g:21:15: 'double'
			{
			match("double"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "DOUBLE_TYPE"

	// $ANTLR start "BOOL_TYPE"
	public final void mBOOL_TYPE() throws RecognitionException {
		try {
			int _type = BOOL_TYPE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// mylexter.g:22:11: ( '_Bool' )
			// mylexter.g:22:13: '_Bool'
			{
			match("_Bool"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "BOOL_TYPE"

	// $ANTLR start "UNSIGNED_TYPE"
	public final void mUNSIGNED_TYPE() throws RecognitionException {
		try {
			int _type = UNSIGNED_TYPE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// mylexter.g:23:15: ( 'unsigned' )
			// mylexter.g:23:17: 'unsigned'
			{
			match("unsigned"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "UNSIGNED_TYPE"

	// $ANTLR start "SIGNED_TYPE"
	public final void mSIGNED_TYPE() throws RecognitionException {
		try {
			int _type = SIGNED_TYPE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// mylexter.g:24:13: ( 'signed' )
			// mylexter.g:24:15: 'signed'
			{
			match("signed"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "SIGNED_TYPE"

	// $ANTLR start "LONG_TYPE"
	public final void mLONG_TYPE() throws RecognitionException {
		try {
			int _type = LONG_TYPE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// mylexter.g:25:11: ( 'long' )
			// mylexter.g:25:13: 'long'
			{
			match("long"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "LONG_TYPE"

	// $ANTLR start "SHORT_TYPE"
	public final void mSHORT_TYPE() throws RecognitionException {
		try {
			int _type = SHORT_TYPE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// mylexter.g:26:12: ( 'short' )
			// mylexter.g:26:14: 'short'
			{
			match("short"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "SHORT_TYPE"

	// $ANTLR start "CONST_TYPE"
	public final void mCONST_TYPE() throws RecognitionException {
		try {
			int _type = CONST_TYPE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// mylexter.g:27:12: ( 'const' )
			// mylexter.g:27:14: 'const'
			{
			match("const"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "CONST_TYPE"

	// $ANTLR start "STRUCT_TYPE"
	public final void mSTRUCT_TYPE() throws RecognitionException {
		try {
			int _type = STRUCT_TYPE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// mylexter.g:28:13: ( 'struct' )
			// mylexter.g:28:15: 'struct'
			{
			match("struct"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "STRUCT_TYPE"

	// $ANTLR start "UNION_TYPE"
	public final void mUNION_TYPE() throws RecognitionException {
		try {
			int _type = UNION_TYPE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// mylexter.g:29:12: ( 'union' )
			// mylexter.g:29:14: 'union'
			{
			match("union"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "UNION_TYPE"

	// $ANTLR start "ENUM_TYPE"
	public final void mENUM_TYPE() throws RecognitionException {
		try {
			int _type = ENUM_TYPE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// mylexter.g:30:11: ( 'enum' )
			// mylexter.g:30:13: 'enum'
			{
			match("enum"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "ENUM_TYPE"

	// $ANTLR start "TYPEDEF_"
	public final void mTYPEDEF_() throws RecognitionException {
		try {
			int _type = TYPEDEF_;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// mylexter.g:32:10: ( 'typedef' )
			// mylexter.g:32:12: 'typedef'
			{
			match("typedef"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "TYPEDEF_"

	// $ANTLR start "MAIN_"
	public final void mMAIN_() throws RecognitionException {
		try {
			int _type = MAIN_;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// mylexter.g:34:7: ( 'main' )
			// mylexter.g:34:9: 'main'
			{
			match("main"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "MAIN_"

	// $ANTLR start "WHILE_"
	public final void mWHILE_() throws RecognitionException {
		try {
			int _type = WHILE_;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// mylexter.g:35:11: ( 'while' )
			// mylexter.g:35:13: 'while'
			{
			match("while"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "WHILE_"

	// $ANTLR start "DO_"
	public final void mDO_() throws RecognitionException {
		try {
			int _type = DO_;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// mylexter.g:36:5: ( 'do' )
			// mylexter.g:36:7: 'do'
			{
			match("do"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "DO_"

	// $ANTLR start "IF_"
	public final void mIF_() throws RecognitionException {
		try {
			int _type = IF_;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// mylexter.g:37:5: ( 'if' )
			// mylexter.g:37:7: 'if'
			{
			match("if"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "IF_"

	// $ANTLR start "ELSE_"
	public final void mELSE_() throws RecognitionException {
		try {
			int _type = ELSE_;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// mylexter.g:38:7: ( 'else' )
			// mylexter.g:38:9: 'else'
			{
			match("else"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "ELSE_"

	// $ANTLR start "FOR_"
	public final void mFOR_() throws RecognitionException {
		try {
			int _type = FOR_;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// mylexter.g:39:6: ( 'for' )
			// mylexter.g:39:8: 'for'
			{
			match("for"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "FOR_"

	// $ANTLR start "RETURN_"
	public final void mRETURN_() throws RecognitionException {
		try {
			int _type = RETURN_;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// mylexter.g:40:9: ( 'return' )
			// mylexter.g:40:11: 'return'
			{
			match("return"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "RETURN_"

	// $ANTLR start "CONTINUE_"
	public final void mCONTINUE_() throws RecognitionException {
		try {
			int _type = CONTINUE_;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// mylexter.g:41:11: ( 'continue' )
			// mylexter.g:41:13: 'continue'
			{
			match("continue"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "CONTINUE_"

	// $ANTLR start "BREAK_"
	public final void mBREAK_() throws RecognitionException {
		try {
			int _type = BREAK_;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// mylexter.g:42:8: ( 'break' )
			// mylexter.g:42:10: 'break'
			{
			match("break"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "BREAK_"

	// $ANTLR start "SWITCH_"
	public final void mSWITCH_() throws RecognitionException {
		try {
			int _type = SWITCH_;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// mylexter.g:43:9: ( 'switch' )
			// mylexter.g:43:11: 'switch'
			{
			match("switch"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "SWITCH_"

	// $ANTLR start "CASE_"
	public final void mCASE_() throws RecognitionException {
		try {
			int _type = CASE_;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// mylexter.g:44:6: ( 'case' )
			// mylexter.g:44:8: 'case'
			{
			match("case"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "CASE_"

	// $ANTLR start "DEFAULT_"
	public final void mDEFAULT_() throws RecognitionException {
		try {
			int _type = DEFAULT_;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// mylexter.g:45:9: ( 'default' )
			// mylexter.g:45:11: 'default'
			{
			match("default"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "DEFAULT_"

	// $ANTLR start "PRINTF_"
	public final void mPRINTF_() throws RecognitionException {
		try {
			int _type = PRINTF_;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// mylexter.g:46:9: ( 'printf' )
			// mylexter.g:46:11: 'printf'
			{
			match("printf"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "PRINTF_"

	// $ANTLR start "SCANF_"
	public final void mSCANF_() throws RecognitionException {
		try {
			int _type = SCANF_;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// mylexter.g:47:8: ( 'scanf' )
			// mylexter.g:47:10: 'scanf'
			{
			match("scanf"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "SCANF_"

	// $ANTLR start "INCLUDE_"
	public final void mINCLUDE_() throws RecognitionException {
		try {
			int _type = INCLUDE_;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// mylexter.g:49:9: ( 'include' )
			// mylexter.g:49:11: 'include'
			{
			match("include"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "INCLUDE_"

	// $ANTLR start "DEFINE_"
	public final void mDEFINE_() throws RecognitionException {
		try {
			int _type = DEFINE_;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// mylexter.g:50:8: ( 'define' )
			// mylexter.g:50:10: 'define'
			{
			match("define"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "DEFINE_"

	// $ANTLR start "NULL"
	public final void mNULL() throws RecognitionException {
		try {
			int _type = NULL;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// mylexter.g:52:5: ( 'NULL' )
			// mylexter.g:52:7: 'NULL'
			{
			match("NULL"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "NULL"

	// $ANTLR start "EEOF"
	public final void mEEOF() throws RecognitionException {
		try {
			int _type = EEOF;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// mylexter.g:53:5: ( 'EOF' )
			// mylexter.g:53:7: 'EOF'
			{
			match("EOF"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "EEOF"

	// $ANTLR start "RSHIFTE_OP"
	public final void mRSHIFTE_OP() throws RecognitionException {
		try {
			int _type = RSHIFTE_OP;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// mylexter.g:58:12: ( '<<=' )
			// mylexter.g:58:14: '<<='
			{
			match("<<="); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "RSHIFTE_OP"

	// $ANTLR start "LSHIFTE_OP"
	public final void mLSHIFTE_OP() throws RecognitionException {
		try {
			int _type = LSHIFTE_OP;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// mylexter.g:59:12: ( '>>=' )
			// mylexter.g:59:14: '>>='
			{
			match(">>="); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "LSHIFTE_OP"

	// $ANTLR start "EQ_OP"
	public final void mEQ_OP() throws RecognitionException {
		try {
			int _type = EQ_OP;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// mylexter.g:60:7: ( '==' )
			// mylexter.g:60:9: '=='
			{
			match("=="); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "EQ_OP"

	// $ANTLR start "LE_OP"
	public final void mLE_OP() throws RecognitionException {
		try {
			int _type = LE_OP;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// mylexter.g:61:7: ( '<=' )
			// mylexter.g:61:9: '<='
			{
			match("<="); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "LE_OP"

	// $ANTLR start "GE_OP"
	public final void mGE_OP() throws RecognitionException {
		try {
			int _type = GE_OP;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// mylexter.g:62:7: ( '>=' )
			// mylexter.g:62:9: '>='
			{
			match(">="); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "GE_OP"

	// $ANTLR start "NE_OP"
	public final void mNE_OP() throws RecognitionException {
		try {
			int _type = NE_OP;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// mylexter.g:64:7: ( '!=' )
			// mylexter.g:64:9: '!='
			{
			match("!="); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "NE_OP"

	// $ANTLR start "PP_OP"
	public final void mPP_OP() throws RecognitionException {
		try {
			int _type = PP_OP;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// mylexter.g:65:7: ( '++' )
			// mylexter.g:65:9: '++'
			{
			match("++"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "PP_OP"

	// $ANTLR start "MM_OP"
	public final void mMM_OP() throws RecognitionException {
		try {
			int _type = MM_OP;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// mylexter.g:66:7: ( '--' )
			// mylexter.g:66:9: '--'
			{
			match("--"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "MM_OP"

	// $ANTLR start "PE_OP"
	public final void mPE_OP() throws RecognitionException {
		try {
			int _type = PE_OP;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// mylexter.g:67:7: ( '+=' )
			// mylexter.g:67:9: '+='
			{
			match("+="); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "PE_OP"

	// $ANTLR start "MIE_OP"
	public final void mMIE_OP() throws RecognitionException {
		try {
			int _type = MIE_OP;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// mylexter.g:68:8: ( '-=' )
			// mylexter.g:68:10: '-='
			{
			match("-="); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "MIE_OP"

	// $ANTLR start "MULE_OP"
	public final void mMULE_OP() throws RecognitionException {
		try {
			int _type = MULE_OP;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// mylexter.g:69:9: ( '*=' )
			// mylexter.g:69:11: '*='
			{
			match("*="); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "MULE_OP"

	// $ANTLR start "DIE_OP"
	public final void mDIE_OP() throws RecognitionException {
		try {
			int _type = DIE_OP;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// mylexter.g:70:7: ( '/=' )
			// mylexter.g:70:9: '/='
			{
			match("/="); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "DIE_OP"

	// $ANTLR start "REE_OP"
	public final void mREE_OP() throws RecognitionException {
		try {
			int _type = REE_OP;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// mylexter.g:71:7: ( '%=' )
			// mylexter.g:71:9: '%='
			{
			match("%="); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "REE_OP"

	// $ANTLR start "RSHIFT_OP"
	public final void mRSHIFT_OP() throws RecognitionException {
		try {
			int _type = RSHIFT_OP;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// mylexter.g:73:11: ( '<<' )
			// mylexter.g:73:13: '<<'
			{
			match("<<"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "RSHIFT_OP"

	// $ANTLR start "LSHIFT_OP"
	public final void mLSHIFT_OP() throws RecognitionException {
		try {
			int _type = LSHIFT_OP;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// mylexter.g:74:11: ( '>>' )
			// mylexter.g:74:13: '>>'
			{
			match(">>"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "LSHIFT_OP"

	// $ANTLR start "LT_OP"
	public final void mLT_OP() throws RecognitionException {
		try {
			int _type = LT_OP;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// mylexter.g:75:7: ( '<' )
			// mylexter.g:75:9: '<'
			{
			match('<'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "LT_OP"

	// $ANTLR start "GT_OP"
	public final void mGT_OP() throws RecognitionException {
		try {
			int _type = GT_OP;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// mylexter.g:76:6: ( '>' )
			// mylexter.g:76:8: '>'
			{
			match('>'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "GT_OP"

	// $ANTLR start "NOT_OP"
	public final void mNOT_OP() throws RecognitionException {
		try {
			int _type = NOT_OP;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// mylexter.g:77:7: ( '!' )
			// mylexter.g:77:9: '!'
			{
			match('!'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "NOT_OP"

	// $ANTLR start "AND_OP"
	public final void mAND_OP() throws RecognitionException {
		try {
			int _type = AND_OP;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// mylexter.g:78:7: ( '&&' )
			// mylexter.g:78:9: '&&'
			{
			match("&&"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "AND_OP"

	// $ANTLR start "OR_OP"
	public final void mOR_OP() throws RecognitionException {
		try {
			int _type = OR_OP;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// mylexter.g:79:6: ( '||' )
			// mylexter.g:79:8: '||'
			{
			match("||"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "OR_OP"

	// $ANTLR start "LMP_OP"
	public final void mLMP_OP() throws RecognitionException {
		try {
			int _type = LMP_OP;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// mylexter.g:80:8: ( '[' )
			// mylexter.g:80:10: '['
			{
			match('['); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "LMP_OP"

	// $ANTLR start "RMP_OP"
	public final void mRMP_OP() throws RecognitionException {
		try {
			int _type = RMP_OP;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// mylexter.g:81:8: ( ']' )
			// mylexter.g:81:10: ']'
			{
			match(']'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "RMP_OP"

	// $ANTLR start "LLP_OP"
	public final void mLLP_OP() throws RecognitionException {
		try {
			int _type = LLP_OP;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// mylexter.g:82:8: ( '{' )
			// mylexter.g:82:10: '{'
			{
			match('{'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "LLP_OP"

	// $ANTLR start "RLP_OP"
	public final void mRLP_OP() throws RecognitionException {
		try {
			int _type = RLP_OP;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// mylexter.g:83:8: ( '}' )
			// mylexter.g:83:10: '}'
			{
			match('}'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "RLP_OP"

	// $ANTLR start "LSP_OP"
	public final void mLSP_OP() throws RecognitionException {
		try {
			int _type = LSP_OP;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// mylexter.g:84:8: ( '(' )
			// mylexter.g:84:10: '('
			{
			match('('); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "LSP_OP"

	// $ANTLR start "RSP_OP"
	public final void mRSP_OP() throws RecognitionException {
		try {
			int _type = RSP_OP;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// mylexter.g:85:8: ( ')' )
			// mylexter.g:85:10: ')'
			{
			match(')'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "RSP_OP"

	// $ANTLR start "CM_OP"
	public final void mCM_OP() throws RecognitionException {
		try {
			int _type = CM_OP;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// mylexter.g:86:7: ( ',' )
			// mylexter.g:86:9: ','
			{
			match(','); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "CM_OP"

	// $ANTLR start "SC_OP"
	public final void mSC_OP() throws RecognitionException {
		try {
			int _type = SC_OP;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// mylexter.g:87:7: ( ';' )
			// mylexter.g:87:9: ';'
			{
			match(';'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "SC_OP"

	// $ANTLR start "PT_OP"
	public final void mPT_OP() throws RecognitionException {
		try {
			int _type = PT_OP;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// mylexter.g:89:6: ( '->' )
			// mylexter.g:89:8: '->'
			{
			match("->"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "PT_OP"

	// $ANTLR start "PR_OP"
	public final void mPR_OP() throws RecognitionException {
		try {
			int _type = PR_OP;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// mylexter.g:90:6: ( '.' )
			// mylexter.g:90:8: '.'
			{
			match('.'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "PR_OP"

	// $ANTLR start "AND_AR"
	public final void mAND_AR() throws RecognitionException {
		try {
			int _type = AND_AR;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// mylexter.g:91:7: ( '&' )
			// mylexter.g:91:9: '&'
			{
			match('&'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "AND_AR"

	// $ANTLR start "OR_AR"
	public final void mOR_AR() throws RecognitionException {
		try {
			int _type = OR_AR;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// mylexter.g:92:6: ( '|' )
			// mylexter.g:92:8: '|'
			{
			match('|'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "OR_AR"

	// $ANTLR start "PLU_AR"
	public final void mPLU_AR() throws RecognitionException {
		try {
			int _type = PLU_AR;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// mylexter.g:93:7: ( '+' )
			// mylexter.g:93:9: '+'
			{
			match('+'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "PLU_AR"

	// $ANTLR start "MI_AR"
	public final void mMI_AR() throws RecognitionException {
		try {
			int _type = MI_AR;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// mylexter.g:94:7: ( '-' )
			// mylexter.g:94:9: '-'
			{
			match('-'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "MI_AR"

	// $ANTLR start "MUL_AR"
	public final void mMUL_AR() throws RecognitionException {
		try {
			int _type = MUL_AR;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// mylexter.g:95:8: ( '*' )
			// mylexter.g:95:10: '*'
			{
			match('*'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "MUL_AR"

	// $ANTLR start "DI_AR"
	public final void mDI_AR() throws RecognitionException {
		try {
			int _type = DI_AR;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// mylexter.g:96:7: ( '/' )
			// mylexter.g:96:9: '/'
			{
			match('/'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "DI_AR"

	// $ANTLR start "RE_AR"
	public final void mRE_AR() throws RecognitionException {
		try {
			int _type = RE_AR;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// mylexter.g:97:7: ( '%' )
			// mylexter.g:97:9: '%'
			{
			match('%'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "RE_AR"

	// $ANTLR start "EQ_AR"
	public final void mEQ_AR() throws RecognitionException {
		try {
			int _type = EQ_AR;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// mylexter.g:98:7: ( '=' )
			// mylexter.g:98:9: '='
			{
			match('='); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "EQ_AR"

	// $ANTLR start "COMP_OP"
	public final void mCOMP_OP() throws RecognitionException {
		try {
			int _type = COMP_OP;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// mylexter.g:99:9: ( '~' )
			// mylexter.g:99:11: '~'
			{
			match('~'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "COMP_OP"

	// $ANTLR start "XOR_AR"
	public final void mXOR_AR() throws RecognitionException {
		try {
			int _type = XOR_AR;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// mylexter.g:100:8: ( '^' )
			// mylexter.g:100:10: '^'
			{
			match('^'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "XOR_AR"

	// $ANTLR start "QUE_OP"
	public final void mQUE_OP() throws RecognitionException {
		try {
			int _type = QUE_OP;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// mylexter.g:101:8: ( '?' )
			// mylexter.g:101:10: '?'
			{
			match('?'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "QUE_OP"

	// $ANTLR start "COL_OP"
	public final void mCOL_OP() throws RecognitionException {
		try {
			int _type = COL_OP;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// mylexter.g:102:8: ( ':' )
			// mylexter.g:102:10: ':'
			{
			match(':'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "COL_OP"

	// $ANTLR start "HT_OP"
	public final void mHT_OP() throws RecognitionException {
		try {
			int _type = HT_OP;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// mylexter.g:103:6: ( '#' )
			// mylexter.g:103:8: '#'
			{
			match('#'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "HT_OP"

	// $ANTLR start "SIZEOF_"
	public final void mSIZEOF_() throws RecognitionException {
		try {
			int _type = SIZEOF_;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// mylexter.g:105:8: ( 'sizeof' )
			// mylexter.g:105:10: 'sizeof'
			{
			match("sizeof"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "SIZEOF_"

	// $ANTLR start "DEC_NUM"
	public final void mDEC_NUM() throws RecognitionException {
		try {
			int _type = DEC_NUM;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// mylexter.g:108:9: ( ( '0' | ( '1' .. '9' ) ( DIGIT )* ) )
			// mylexter.g:108:11: ( '0' | ( '1' .. '9' ) ( DIGIT )* )
			{
			// mylexter.g:108:11: ( '0' | ( '1' .. '9' ) ( DIGIT )* )
			int alt7=2;
			int LA7_0 = input.LA(1);
			if ( (LA7_0=='0') ) {
				alt7=1;
			}
			else if ( ((LA7_0 >= '1' && LA7_0 <= '9')) ) {
				alt7=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 7, 0, input);
				throw nvae;
			}

			switch (alt7) {
				case 1 :
					// mylexter.g:108:12: '0'
					{
					match('0'); 
					}
					break;
				case 2 :
					// mylexter.g:108:18: ( '1' .. '9' ) ( DIGIT )*
					{
					if ( (input.LA(1) >= '1' && input.LA(1) <= '9') ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					// mylexter.g:108:28: ( DIGIT )*
					loop6:
					while (true) {
						int alt6=2;
						int LA6_0 = input.LA(1);
						if ( ((LA6_0 >= '0' && LA6_0 <= '9')) ) {
							alt6=1;
						}

						switch (alt6) {
						case 1 :
							// mylexter.g:
							{
							if ( (input.LA(1) >= '0' && input.LA(1) <= '9') ) {
								input.consume();
							}
							else {
								MismatchedSetException mse = new MismatchedSetException(null,input);
								recover(mse);
								throw mse;
							}
							}
							break;

						default :
							break loop6;
						}
					}

					}
					break;

			}

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "DEC_NUM"

	// $ANTLR start "ID"
	public final void mID() throws RecognitionException {
		try {
			int _type = ID;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// mylexter.g:110:4: ( ( LETTER ) ( LETTER | DIGIT )* )
			// mylexter.g:110:6: ( LETTER ) ( LETTER | DIGIT )*
			{
			if ( (input.LA(1) >= 'A' && input.LA(1) <= 'Z')||input.LA(1)=='_'||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			// mylexter.g:110:14: ( LETTER | DIGIT )*
			loop8:
			while (true) {
				int alt8=2;
				int LA8_0 = input.LA(1);
				if ( ((LA8_0 >= '0' && LA8_0 <= '9')||(LA8_0 >= 'A' && LA8_0 <= 'Z')||LA8_0=='_'||(LA8_0 >= 'a' && LA8_0 <= 'z')) ) {
					alt8=1;
				}

				switch (alt8) {
				case 1 :
					// mylexter.g:
					{
					if ( (input.LA(1) >= '0' && input.LA(1) <= '9')||(input.LA(1) >= 'A' && input.LA(1) <= 'Z')||input.LA(1)=='_'||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					}
					break;

				default :
					break loop8;
				}
			}

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "ID"

	// $ANTLR start "FLOAT_NUM"
	public final void mFLOAT_NUM() throws RecognitionException {
		try {
			int _type = FLOAT_NUM;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// mylexter.g:112:10: ( FLOAT_NUM1 | FLOAT_NUM2 | FLOAT_NUM3 )
			int alt9=3;
			alt9 = dfa9.predict(input);
			switch (alt9) {
				case 1 :
					// mylexter.g:112:12: FLOAT_NUM1
					{
					mFLOAT_NUM1(); 

					}
					break;
				case 2 :
					// mylexter.g:112:25: FLOAT_NUM2
					{
					mFLOAT_NUM2(); 

					}
					break;
				case 3 :
					// mylexter.g:112:38: FLOAT_NUM3
					{
					mFLOAT_NUM3(); 

					}
					break;

			}
			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "FLOAT_NUM"

	// $ANTLR start "FLOAT_NUM1"
	public final void mFLOAT_NUM1() throws RecognitionException {
		try {
			// mylexter.g:113:20: ( ( DIGIT )+ '.' ( DIGIT )* )
			// mylexter.g:113:22: ( DIGIT )+ '.' ( DIGIT )*
			{
			// mylexter.g:113:22: ( DIGIT )+
			int cnt10=0;
			loop10:
			while (true) {
				int alt10=2;
				int LA10_0 = input.LA(1);
				if ( ((LA10_0 >= '0' && LA10_0 <= '9')) ) {
					alt10=1;
				}

				switch (alt10) {
				case 1 :
					// mylexter.g:
					{
					if ( (input.LA(1) >= '0' && input.LA(1) <= '9') ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					}
					break;

				default :
					if ( cnt10 >= 1 ) break loop10;
					EarlyExitException eee = new EarlyExitException(10, input);
					throw eee;
				}
				cnt10++;
			}

			match('.'); 
			// mylexter.g:113:33: ( DIGIT )*
			loop11:
			while (true) {
				int alt11=2;
				int LA11_0 = input.LA(1);
				if ( ((LA11_0 >= '0' && LA11_0 <= '9')) ) {
					alt11=1;
				}

				switch (alt11) {
				case 1 :
					// mylexter.g:
					{
					if ( (input.LA(1) >= '0' && input.LA(1) <= '9') ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					}
					break;

				default :
					break loop11;
				}
			}

			}

		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "FLOAT_NUM1"

	// $ANTLR start "FLOAT_NUM2"
	public final void mFLOAT_NUM2() throws RecognitionException {
		try {
			// mylexter.g:114:20: ( '.' ( DIGIT )+ )
			// mylexter.g:114:22: '.' ( DIGIT )+
			{
			match('.'); 
			// mylexter.g:114:25: ( DIGIT )+
			int cnt12=0;
			loop12:
			while (true) {
				int alt12=2;
				int LA12_0 = input.LA(1);
				if ( ((LA12_0 >= '0' && LA12_0 <= '9')) ) {
					alt12=1;
				}

				switch (alt12) {
				case 1 :
					// mylexter.g:
					{
					if ( (input.LA(1) >= '0' && input.LA(1) <= '9') ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					}
					break;

				default :
					if ( cnt12 >= 1 ) break loop12;
					EarlyExitException eee = new EarlyExitException(12, input);
					throw eee;
				}
				cnt12++;
			}

			}

		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "FLOAT_NUM2"

	// $ANTLR start "FLOAT_NUM3"
	public final void mFLOAT_NUM3() throws RecognitionException {
		try {
			// mylexter.g:115:20: ( ( DIGIT )+ )
			// mylexter.g:115:22: ( DIGIT )+
			{
			// mylexter.g:115:22: ( DIGIT )+
			int cnt13=0;
			loop13:
			while (true) {
				int alt13=2;
				int LA13_0 = input.LA(1);
				if ( ((LA13_0 >= '0' && LA13_0 <= '9')) ) {
					alt13=1;
				}

				switch (alt13) {
				case 1 :
					// mylexter.g:
					{
					if ( (input.LA(1) >= '0' && input.LA(1) <= '9') ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					}
					break;

				default :
					if ( cnt13 >= 1 ) break loop13;
					EarlyExitException eee = new EarlyExitException(13, input);
					throw eee;
				}
				cnt13++;
			}

			}

		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "FLOAT_NUM3"

	// $ANTLR start "NEW_LINE"
	public final void mNEW_LINE() throws RecognitionException {
		try {
			int _type = NEW_LINE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// mylexter.g:118:9: ( '\\n' )
			// mylexter.g:118:11: '\\n'
			{
			match('\n'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "NEW_LINE"

	// $ANTLR start "LETTER"
	public final void mLETTER() throws RecognitionException {
		try {
			// mylexter.g:120:17: ( 'a' .. 'z' | 'A' .. 'Z' | '_' )
			// mylexter.g:
			{
			if ( (input.LA(1) >= 'A' && input.LA(1) <= 'Z')||input.LA(1)=='_'||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			}

		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "LETTER"

	// $ANTLR start "DIGIT"
	public final void mDIGIT() throws RecognitionException {
		try {
			// mylexter.g:121:16: ( '0' .. '9' )
			// mylexter.g:
			{
			if ( (input.LA(1) >= '0' && input.LA(1) <= '9') ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			}

		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "DIGIT"

	// $ANTLR start "WS"
	public final void mWS() throws RecognitionException {
		try {
			int _type = WS;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// mylexter.g:124:5: ( ( ' ' | '\\r' | '\\t' )+ )
			// mylexter.g:124:7: ( ' ' | '\\r' | '\\t' )+
			{
			// mylexter.g:124:7: ( ' ' | '\\r' | '\\t' )+
			int cnt14=0;
			loop14:
			while (true) {
				int alt14=2;
				int LA14_0 = input.LA(1);
				if ( (LA14_0=='\t'||LA14_0=='\r'||LA14_0==' ') ) {
					alt14=1;
				}

				switch (alt14) {
				case 1 :
					// mylexter.g:
					{
					if ( input.LA(1)=='\t'||input.LA(1)=='\r'||input.LA(1)==' ' ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					}
					break;

				default :
					if ( cnt14 >= 1 ) break loop14;
					EarlyExitException eee = new EarlyExitException(14, input);
					throw eee;
				}
				cnt14++;
			}

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "WS"

	@Override
	public void mTokens() throws RecognitionException {
		// mylexter.g:1:8: ( LITERAL | CHARACTER | HEADER | COMMENT1 | COMMENT2 | INT_TYPE | CHAR_TYPE | VOID_TYPE | FLOAT_TYPE | DOUBLE_TYPE | BOOL_TYPE | UNSIGNED_TYPE | SIGNED_TYPE | LONG_TYPE | SHORT_TYPE | CONST_TYPE | STRUCT_TYPE | UNION_TYPE | ENUM_TYPE | TYPEDEF_ | MAIN_ | WHILE_ | DO_ | IF_ | ELSE_ | FOR_ | RETURN_ | CONTINUE_ | BREAK_ | SWITCH_ | CASE_ | DEFAULT_ | PRINTF_ | SCANF_ | INCLUDE_ | DEFINE_ | NULL | EEOF | RSHIFTE_OP | LSHIFTE_OP | EQ_OP | LE_OP | GE_OP | NE_OP | PP_OP | MM_OP | PE_OP | MIE_OP | MULE_OP | DIE_OP | REE_OP | RSHIFT_OP | LSHIFT_OP | LT_OP | GT_OP | NOT_OP | AND_OP | OR_OP | LMP_OP | RMP_OP | LLP_OP | RLP_OP | LSP_OP | RSP_OP | CM_OP | SC_OP | PT_OP | PR_OP | AND_AR | OR_AR | PLU_AR | MI_AR | MUL_AR | DI_AR | RE_AR | EQ_AR | COMP_OP | XOR_AR | QUE_OP | COL_OP | HT_OP | SIZEOF_ | DEC_NUM | ID | FLOAT_NUM | NEW_LINE | WS )
		int alt15=87;
		alt15 = dfa15.predict(input);
		switch (alt15) {
			case 1 :
				// mylexter.g:1:10: LITERAL
				{
				mLITERAL(); 

				}
				break;
			case 2 :
				// mylexter.g:1:18: CHARACTER
				{
				mCHARACTER(); 

				}
				break;
			case 3 :
				// mylexter.g:1:28: HEADER
				{
				mHEADER(); 

				}
				break;
			case 4 :
				// mylexter.g:1:35: COMMENT1
				{
				mCOMMENT1(); 

				}
				break;
			case 5 :
				// mylexter.g:1:44: COMMENT2
				{
				mCOMMENT2(); 

				}
				break;
			case 6 :
				// mylexter.g:1:53: INT_TYPE
				{
				mINT_TYPE(); 

				}
				break;
			case 7 :
				// mylexter.g:1:62: CHAR_TYPE
				{
				mCHAR_TYPE(); 

				}
				break;
			case 8 :
				// mylexter.g:1:72: VOID_TYPE
				{
				mVOID_TYPE(); 

				}
				break;
			case 9 :
				// mylexter.g:1:82: FLOAT_TYPE
				{
				mFLOAT_TYPE(); 

				}
				break;
			case 10 :
				// mylexter.g:1:93: DOUBLE_TYPE
				{
				mDOUBLE_TYPE(); 

				}
				break;
			case 11 :
				// mylexter.g:1:105: BOOL_TYPE
				{
				mBOOL_TYPE(); 

				}
				break;
			case 12 :
				// mylexter.g:1:115: UNSIGNED_TYPE
				{
				mUNSIGNED_TYPE(); 

				}
				break;
			case 13 :
				// mylexter.g:1:129: SIGNED_TYPE
				{
				mSIGNED_TYPE(); 

				}
				break;
			case 14 :
				// mylexter.g:1:141: LONG_TYPE
				{
				mLONG_TYPE(); 

				}
				break;
			case 15 :
				// mylexter.g:1:151: SHORT_TYPE
				{
				mSHORT_TYPE(); 

				}
				break;
			case 16 :
				// mylexter.g:1:162: CONST_TYPE
				{
				mCONST_TYPE(); 

				}
				break;
			case 17 :
				// mylexter.g:1:173: STRUCT_TYPE
				{
				mSTRUCT_TYPE(); 

				}
				break;
			case 18 :
				// mylexter.g:1:185: UNION_TYPE
				{
				mUNION_TYPE(); 

				}
				break;
			case 19 :
				// mylexter.g:1:196: ENUM_TYPE
				{
				mENUM_TYPE(); 

				}
				break;
			case 20 :
				// mylexter.g:1:206: TYPEDEF_
				{
				mTYPEDEF_(); 

				}
				break;
			case 21 :
				// mylexter.g:1:215: MAIN_
				{
				mMAIN_(); 

				}
				break;
			case 22 :
				// mylexter.g:1:221: WHILE_
				{
				mWHILE_(); 

				}
				break;
			case 23 :
				// mylexter.g:1:228: DO_
				{
				mDO_(); 

				}
				break;
			case 24 :
				// mylexter.g:1:232: IF_
				{
				mIF_(); 

				}
				break;
			case 25 :
				// mylexter.g:1:236: ELSE_
				{
				mELSE_(); 

				}
				break;
			case 26 :
				// mylexter.g:1:242: FOR_
				{
				mFOR_(); 

				}
				break;
			case 27 :
				// mylexter.g:1:247: RETURN_
				{
				mRETURN_(); 

				}
				break;
			case 28 :
				// mylexter.g:1:255: CONTINUE_
				{
				mCONTINUE_(); 

				}
				break;
			case 29 :
				// mylexter.g:1:265: BREAK_
				{
				mBREAK_(); 

				}
				break;
			case 30 :
				// mylexter.g:1:272: SWITCH_
				{
				mSWITCH_(); 

				}
				break;
			case 31 :
				// mylexter.g:1:280: CASE_
				{
				mCASE_(); 

				}
				break;
			case 32 :
				// mylexter.g:1:286: DEFAULT_
				{
				mDEFAULT_(); 

				}
				break;
			case 33 :
				// mylexter.g:1:295: PRINTF_
				{
				mPRINTF_(); 

				}
				break;
			case 34 :
				// mylexter.g:1:303: SCANF_
				{
				mSCANF_(); 

				}
				break;
			case 35 :
				// mylexter.g:1:310: INCLUDE_
				{
				mINCLUDE_(); 

				}
				break;
			case 36 :
				// mylexter.g:1:319: DEFINE_
				{
				mDEFINE_(); 

				}
				break;
			case 37 :
				// mylexter.g:1:327: NULL
				{
				mNULL(); 

				}
				break;
			case 38 :
				// mylexter.g:1:332: EEOF
				{
				mEEOF(); 

				}
				break;
			case 39 :
				// mylexter.g:1:337: RSHIFTE_OP
				{
				mRSHIFTE_OP(); 

				}
				break;
			case 40 :
				// mylexter.g:1:348: LSHIFTE_OP
				{
				mLSHIFTE_OP(); 

				}
				break;
			case 41 :
				// mylexter.g:1:359: EQ_OP
				{
				mEQ_OP(); 

				}
				break;
			case 42 :
				// mylexter.g:1:365: LE_OP
				{
				mLE_OP(); 

				}
				break;
			case 43 :
				// mylexter.g:1:371: GE_OP
				{
				mGE_OP(); 

				}
				break;
			case 44 :
				// mylexter.g:1:377: NE_OP
				{
				mNE_OP(); 

				}
				break;
			case 45 :
				// mylexter.g:1:383: PP_OP
				{
				mPP_OP(); 

				}
				break;
			case 46 :
				// mylexter.g:1:389: MM_OP
				{
				mMM_OP(); 

				}
				break;
			case 47 :
				// mylexter.g:1:395: PE_OP
				{
				mPE_OP(); 

				}
				break;
			case 48 :
				// mylexter.g:1:401: MIE_OP
				{
				mMIE_OP(); 

				}
				break;
			case 49 :
				// mylexter.g:1:408: MULE_OP
				{
				mMULE_OP(); 

				}
				break;
			case 50 :
				// mylexter.g:1:416: DIE_OP
				{
				mDIE_OP(); 

				}
				break;
			case 51 :
				// mylexter.g:1:423: REE_OP
				{
				mREE_OP(); 

				}
				break;
			case 52 :
				// mylexter.g:1:430: RSHIFT_OP
				{
				mRSHIFT_OP(); 

				}
				break;
			case 53 :
				// mylexter.g:1:440: LSHIFT_OP
				{
				mLSHIFT_OP(); 

				}
				break;
			case 54 :
				// mylexter.g:1:450: LT_OP
				{
				mLT_OP(); 

				}
				break;
			case 55 :
				// mylexter.g:1:456: GT_OP
				{
				mGT_OP(); 

				}
				break;
			case 56 :
				// mylexter.g:1:462: NOT_OP
				{
				mNOT_OP(); 

				}
				break;
			case 57 :
				// mylexter.g:1:469: AND_OP
				{
				mAND_OP(); 

				}
				break;
			case 58 :
				// mylexter.g:1:476: OR_OP
				{
				mOR_OP(); 

				}
				break;
			case 59 :
				// mylexter.g:1:482: LMP_OP
				{
				mLMP_OP(); 

				}
				break;
			case 60 :
				// mylexter.g:1:489: RMP_OP
				{
				mRMP_OP(); 

				}
				break;
			case 61 :
				// mylexter.g:1:496: LLP_OP
				{
				mLLP_OP(); 

				}
				break;
			case 62 :
				// mylexter.g:1:503: RLP_OP
				{
				mRLP_OP(); 

				}
				break;
			case 63 :
				// mylexter.g:1:510: LSP_OP
				{
				mLSP_OP(); 

				}
				break;
			case 64 :
				// mylexter.g:1:517: RSP_OP
				{
				mRSP_OP(); 

				}
				break;
			case 65 :
				// mylexter.g:1:524: CM_OP
				{
				mCM_OP(); 

				}
				break;
			case 66 :
				// mylexter.g:1:530: SC_OP
				{
				mSC_OP(); 

				}
				break;
			case 67 :
				// mylexter.g:1:536: PT_OP
				{
				mPT_OP(); 

				}
				break;
			case 68 :
				// mylexter.g:1:542: PR_OP
				{
				mPR_OP(); 

				}
				break;
			case 69 :
				// mylexter.g:1:548: AND_AR
				{
				mAND_AR(); 

				}
				break;
			case 70 :
				// mylexter.g:1:555: OR_AR
				{
				mOR_AR(); 

				}
				break;
			case 71 :
				// mylexter.g:1:561: PLU_AR
				{
				mPLU_AR(); 

				}
				break;
			case 72 :
				// mylexter.g:1:568: MI_AR
				{
				mMI_AR(); 

				}
				break;
			case 73 :
				// mylexter.g:1:574: MUL_AR
				{
				mMUL_AR(); 

				}
				break;
			case 74 :
				// mylexter.g:1:581: DI_AR
				{
				mDI_AR(); 

				}
				break;
			case 75 :
				// mylexter.g:1:587: RE_AR
				{
				mRE_AR(); 

				}
				break;
			case 76 :
				// mylexter.g:1:593: EQ_AR
				{
				mEQ_AR(); 

				}
				break;
			case 77 :
				// mylexter.g:1:599: COMP_OP
				{
				mCOMP_OP(); 

				}
				break;
			case 78 :
				// mylexter.g:1:607: XOR_AR
				{
				mXOR_AR(); 

				}
				break;
			case 79 :
				// mylexter.g:1:614: QUE_OP
				{
				mQUE_OP(); 

				}
				break;
			case 80 :
				// mylexter.g:1:621: COL_OP
				{
				mCOL_OP(); 

				}
				break;
			case 81 :
				// mylexter.g:1:628: HT_OP
				{
				mHT_OP(); 

				}
				break;
			case 82 :
				// mylexter.g:1:634: SIZEOF_
				{
				mSIZEOF_(); 

				}
				break;
			case 83 :
				// mylexter.g:1:642: DEC_NUM
				{
				mDEC_NUM(); 

				}
				break;
			case 84 :
				// mylexter.g:1:650: ID
				{
				mID(); 

				}
				break;
			case 85 :
				// mylexter.g:1:653: FLOAT_NUM
				{
				mFLOAT_NUM(); 

				}
				break;
			case 86 :
				// mylexter.g:1:663: NEW_LINE
				{
				mNEW_LINE(); 

				}
				break;
			case 87 :
				// mylexter.g:1:672: WS
				{
				mWS(); 

				}
				break;

		}
	}


	protected DFA9 dfa9 = new DFA9(this);
	protected DFA15 dfa15 = new DFA15(this);
	static final String DFA9_eotS =
		"\1\uffff\1\4\3\uffff";
	static final String DFA9_eofS =
		"\5\uffff";
	static final String DFA9_minS =
		"\2\56\3\uffff";
	static final String DFA9_maxS =
		"\2\71\3\uffff";
	static final String DFA9_acceptS =
		"\2\uffff\1\2\1\1\1\3";
	static final String DFA9_specialS =
		"\5\uffff}>";
	static final String[] DFA9_transitionS = {
			"\1\2\1\uffff\12\1",
			"\1\3\1\uffff\12\1",
			"",
			"",
			""
	};

	static final short[] DFA9_eot = DFA.unpackEncodedString(DFA9_eotS);
	static final short[] DFA9_eof = DFA.unpackEncodedString(DFA9_eofS);
	static final char[] DFA9_min = DFA.unpackEncodedStringToUnsignedChars(DFA9_minS);
	static final char[] DFA9_max = DFA.unpackEncodedStringToUnsignedChars(DFA9_maxS);
	static final short[] DFA9_accept = DFA.unpackEncodedString(DFA9_acceptS);
	static final short[] DFA9_special = DFA.unpackEncodedString(DFA9_specialS);
	static final short[][] DFA9_transition;

	static {
		int numStates = DFA9_transitionS.length;
		DFA9_transition = new short[numStates][];
		for (int i=0; i<numStates; i++) {
			DFA9_transition[i] = DFA.unpackEncodedString(DFA9_transitionS[i]);
		}
	}

	protected class DFA9 extends DFA {

		public DFA9(BaseRecognizer recognizer) {
			this.recognizer = recognizer;
			this.decisionNumber = 9;
			this.eot = DFA9_eot;
			this.eof = DFA9_eof;
			this.min = DFA9_min;
			this.max = DFA9_max;
			this.accept = DFA9_accept;
			this.special = DFA9_special;
			this.transition = DFA9_transition;
		}
		@Override
		public String getDescription() {
			return "112:1: FLOAT_NUM : ( FLOAT_NUM1 | FLOAT_NUM2 | FLOAT_NUM3 );";
		}
	}

	static final String DFA15_eotS =
		"\3\uffff\1\67\1\70\1\75\22\67\1\132\1\135\1\137\1\141\1\144\1\150\1\152"+
		"\1\154\1\156\1\160\15\uffff\2\161\2\uffff\1\67\1\165\1\uffff\1\67\7\uffff"+
		"\6\67\1\175\23\67\1\u0094\2\uffff\1\u0096\26\uffff\1\161\1\u0097\1\67"+
		"\1\uffff\5\67\1\u009f\1\67\1\uffff\24\67\1\u00b6\5\uffff\1\67\1\u00b8"+
		"\2\67\1\u00bb\1\u00bc\1\67\1\uffff\14\67\1\u00ca\1\u00cb\1\u00cc\1\67"+
		"\1\u00ce\4\67\1\u00d3\1\uffff\1\67\1\uffff\1\u00d5\1\67\2\uffff\1\u00d7"+
		"\3\67\1\u00db\1\67\1\u00dd\2\67\1\u00e0\2\67\1\u00e3\3\uffff\1\67\1\uffff"+
		"\1\u00e5\1\67\1\u00e7\1\67\1\uffff\1\67\1\uffff\1\67\1\uffff\1\u00eb\1"+
		"\67\1\u00ed\1\uffff\1\67\1\uffff\1\u00ef\1\u00f0\1\uffff\1\u00f1\1\u00f2"+
		"\1\uffff\1\67\1\uffff\1\u00f4\1\uffff\1\u00f5\1\u00f6\1\67\1\uffff\1\u00f8"+
		"\1\uffff\1\67\4\uffff\1\u00fa\3\uffff\1\u00fb\1\uffff\1\u00fc\3\uffff";
	static final String DFA15_eofS =
		"\u00fd\uffff";
	static final String DFA15_minS =
		"\1\11\2\uffff\1\56\1\60\1\52\22\56\1\74\3\75\1\53\1\55\2\75\1\46\1\174"+
		"\15\uffff\2\56\2\uffff\2\56\1\uffff\1\56\7\uffff\32\56\1\75\2\uffff\1"+
		"\75\26\uffff\3\56\1\uffff\7\56\1\uffff\25\56\5\uffff\7\56\1\uffff\26\56"+
		"\1\uffff\1\56\1\uffff\2\56\2\uffff\15\56\3\uffff\1\56\1\uffff\4\56\1\uffff"+
		"\1\56\1\uffff\1\56\1\uffff\3\56\1\uffff\1\56\1\uffff\2\56\1\uffff\2\56"+
		"\1\uffff\1\56\1\uffff\1\56\1\uffff\3\56\1\uffff\1\56\1\uffff\1\56\4\uffff"+
		"\1\56\3\uffff\1\56\1\uffff\1\56\3\uffff";
	static final String DFA15_maxS =
		"\1\176\2\uffff\1\172\1\150\1\75\22\172\1\75\1\76\3\75\1\76\2\75\1\46\1"+
		"\174\15\uffff\2\71\2\uffff\2\172\1\uffff\1\172\7\uffff\32\172\1\75\2\uffff"+
		"\1\75\26\uffff\1\71\2\172\1\uffff\7\172\1\uffff\25\172\5\uffff\7\172\1"+
		"\uffff\26\172\1\uffff\1\172\1\uffff\2\172\2\uffff\15\172\3\uffff\1\172"+
		"\1\uffff\4\172\1\uffff\1\172\1\uffff\1\172\1\uffff\3\172\1\uffff\1\172"+
		"\1\uffff\2\172\1\uffff\2\172\1\uffff\1\172\1\uffff\1\172\1\uffff\3\172"+
		"\1\uffff\1\172\1\uffff\1\172\4\uffff\1\172\3\uffff\1\172\1\uffff\1\172"+
		"\3\uffff";
	static final String DFA15_acceptS =
		"\1\uffff\1\1\1\2\37\uffff\1\73\1\74\1\75\1\76\1\77\1\100\1\101\1\102\1"+
		"\115\1\116\1\117\1\120\1\121\2\uffff\1\126\1\127\2\uffff\1\3\1\uffff\1"+
		"\124\1\104\1\125\1\4\1\5\1\62\1\112\33\uffff\1\52\1\66\1\uffff\1\53\1"+
		"\67\1\51\1\114\1\54\1\70\1\55\1\57\1\107\1\56\1\60\1\103\1\110\1\61\1"+
		"\111\1\63\1\113\1\71\1\105\1\72\1\106\1\123\3\uffff\1\30\7\uffff\1\27"+
		"\25\uffff\1\47\1\64\1\50\1\65\1\6\7\uffff\1\32\26\uffff\1\46\1\uffff\1"+
		"\7\2\uffff\1\37\1\10\15\uffff\1\16\1\23\1\31\1\uffff\1\25\4\uffff\1\45"+
		"\1\uffff\1\20\1\uffff\1\11\3\uffff\1\13\1\uffff\1\22\2\uffff\1\17\2\uffff"+
		"\1\42\1\uffff\1\26\1\uffff\1\35\3\uffff\1\12\1\uffff\1\44\1\uffff\1\15"+
		"\1\122\1\21\1\36\1\uffff\1\33\1\41\1\43\1\uffff\1\40\1\uffff\1\24\1\34"+
		"\1\14";
	static final String DFA15_specialS =
		"\u00fd\uffff}>";
	static final String[] DFA15_transitionS = {
			"\1\62\1\61\2\uffff\1\62\22\uffff\1\62\1\33\1\1\1\56\1\uffff\1\37\1\40"+
			"\1\2\1\46\1\47\1\36\1\34\1\50\1\35\1\4\1\5\1\57\11\60\1\55\1\51\1\30"+
			"\1\32\1\31\1\54\1\uffff\4\27\1\26\10\27\1\25\14\27\1\42\1\uffff\1\43"+
			"\1\53\1\12\1\uffff\1\27\1\23\1\6\1\11\1\16\1\10\2\27\1\3\2\27\1\15\1"+
			"\20\2\27\1\24\1\27\1\22\1\14\1\17\1\13\1\7\1\21\3\27\1\44\1\41\1\45\1"+
			"\52",
			"",
			"",
			"\1\65\22\uffff\32\66\4\uffff\1\66\1\uffff\5\66\1\64\7\66\1\63\14\66",
			"\12\71\56\uffff\1\65",
			"\1\73\4\uffff\1\72\15\uffff\1\74",
			"\1\65\22\uffff\32\66\4\uffff\1\66\1\uffff\1\100\6\66\1\76\6\66\1\77"+
			"\13\66",
			"\1\65\22\uffff\32\66\4\uffff\1\66\1\uffff\16\66\1\101\13\66",
			"\1\65\22\uffff\32\66\4\uffff\1\66\1\uffff\13\66\1\102\2\66\1\103\13"+
			"\66",
			"\1\65\22\uffff\32\66\4\uffff\1\66\1\uffff\4\66\1\105\11\66\1\104\13"+
			"\66",
			"\1\65\22\uffff\1\66\1\106\30\66\4\uffff\1\66\1\uffff\32\66",
			"\1\65\22\uffff\32\66\4\uffff\1\66\1\uffff\15\66\1\107\14\66",
			"\1\65\22\uffff\32\66\4\uffff\1\66\1\uffff\2\66\1\114\4\66\1\111\1\110"+
			"\12\66\1\112\2\66\1\113\3\66",
			"\1\65\22\uffff\32\66\4\uffff\1\66\1\uffff\16\66\1\115\13\66",
			"\1\65\22\uffff\32\66\4\uffff\1\66\1\uffff\13\66\1\117\1\66\1\116\14"+
			"\66",
			"\1\65\22\uffff\32\66\4\uffff\1\66\1\uffff\30\66\1\120\1\66",
			"\1\65\22\uffff\32\66\4\uffff\1\66\1\uffff\1\121\31\66",
			"\1\65\22\uffff\32\66\4\uffff\1\66\1\uffff\7\66\1\122\22\66",
			"\1\65\22\uffff\32\66\4\uffff\1\66\1\uffff\4\66\1\123\25\66",
			"\1\65\22\uffff\32\66\4\uffff\1\66\1\uffff\21\66\1\124\10\66",
			"\1\65\22\uffff\32\66\4\uffff\1\66\1\uffff\21\66\1\125\10\66",
			"\1\65\22\uffff\24\66\1\126\5\66\4\uffff\1\66\1\uffff\32\66",
			"\1\65\22\uffff\16\66\1\127\13\66\4\uffff\1\66\1\uffff\32\66",
			"\1\65\22\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
			"\1\130\1\131",
			"\1\134\1\133",
			"\1\136",
			"\1\140",
			"\1\142\21\uffff\1\143",
			"\1\145\17\uffff\1\146\1\147",
			"\1\151",
			"\1\153",
			"\1\155",
			"\1\157",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"\1\71\1\uffff\12\71",
			"\1\71\1\uffff\12\162",
			"",
			"",
			"\1\65\22\uffff\32\66\4\uffff\1\66\1\uffff\2\66\1\164\20\66\1\163\6\66",
			"\1\65\1\uffff\12\67\7\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
			"",
			"\1\65\22\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"\1\65\22\uffff\32\66\4\uffff\1\66\1\uffff\1\166\31\66",
			"\1\65\22\uffff\32\66\4\uffff\1\66\1\uffff\15\66\1\167\14\66",
			"\1\65\22\uffff\32\66\4\uffff\1\66\1\uffff\22\66\1\170\7\66",
			"\1\65\22\uffff\32\66\4\uffff\1\66\1\uffff\10\66\1\171\21\66",
			"\1\65\22\uffff\32\66\4\uffff\1\66\1\uffff\16\66\1\172\13\66",
			"\1\65\22\uffff\32\66\4\uffff\1\66\1\uffff\21\66\1\173\10\66",
			"\1\65\1\uffff\12\67\7\uffff\32\66\4\uffff\1\66\1\uffff\24\66\1\174\5"+
			"\66",
			"\1\65\22\uffff\32\66\4\uffff\1\66\1\uffff\5\66\1\176\24\66",
			"\1\65\22\uffff\32\66\4\uffff\1\66\1\uffff\16\66\1\177\13\66",
			"\1\65\22\uffff\32\66\4\uffff\1\66\1\uffff\10\66\1\u0081\11\66\1\u0080"+
			"\7\66",
			"\1\65\22\uffff\32\66\4\uffff\1\66\1\uffff\6\66\1\u0082\22\66\1\u0083",
			"\1\65\22\uffff\32\66\4\uffff\1\66\1\uffff\16\66\1\u0084\13\66",
			"\1\65\22\uffff\32\66\4\uffff\1\66\1\uffff\21\66\1\u0085\10\66",
			"\1\65\22\uffff\32\66\4\uffff\1\66\1\uffff\10\66\1\u0086\21\66",
			"\1\65\22\uffff\32\66\4\uffff\1\66\1\uffff\1\u0087\31\66",
			"\1\65\22\uffff\32\66\4\uffff\1\66\1\uffff\15\66\1\u0088\14\66",
			"\1\65\22\uffff\32\66\4\uffff\1\66\1\uffff\24\66\1\u0089\5\66",
			"\1\65\22\uffff\32\66\4\uffff\1\66\1\uffff\22\66\1\u008a\7\66",
			"\1\65\22\uffff\32\66\4\uffff\1\66\1\uffff\17\66\1\u008b\12\66",
			"\1\65\22\uffff\32\66\4\uffff\1\66\1\uffff\10\66\1\u008c\21\66",
			"\1\65\22\uffff\32\66\4\uffff\1\66\1\uffff\10\66\1\u008d\21\66",
			"\1\65\22\uffff\32\66\4\uffff\1\66\1\uffff\23\66\1\u008e\6\66",
			"\1\65\22\uffff\32\66\4\uffff\1\66\1\uffff\4\66\1\u008f\25\66",
			"\1\65\22\uffff\32\66\4\uffff\1\66\1\uffff\10\66\1\u0090\21\66",
			"\1\65\22\uffff\13\66\1\u0091\16\66\4\uffff\1\66\1\uffff\32\66",
			"\1\65\22\uffff\5\66\1\u0092\24\66\4\uffff\1\66\1\uffff\32\66",
			"\1\u0093",
			"",
			"",
			"\1\u0095",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"\1\71\1\uffff\12\162",
			"\1\65\1\uffff\12\67\7\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
			"\1\65\22\uffff\32\66\4\uffff\1\66\1\uffff\13\66\1\u0098\16\66",
			"",
			"\1\65\22\uffff\32\66\4\uffff\1\66\1\uffff\21\66\1\u0099\10\66",
			"\1\65\22\uffff\32\66\4\uffff\1\66\1\uffff\22\66\1\u009a\1\u009b\6\66",
			"\1\65\22\uffff\32\66\4\uffff\1\66\1\uffff\4\66\1\u009c\25\66",
			"\1\65\22\uffff\32\66\4\uffff\1\66\1\uffff\3\66\1\u009d\26\66",
			"\1\65\22\uffff\32\66\4\uffff\1\66\1\uffff\1\u009e\31\66",
			"\1\65\1\uffff\12\67\7\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
			"\1\65\22\uffff\32\66\4\uffff\1\66\1\uffff\1\66\1\u00a0\30\66",
			"",
			"\1\65\22\uffff\32\66\4\uffff\1\66\1\uffff\1\u00a1\7\66\1\u00a2\21\66",
			"\1\65\22\uffff\32\66\4\uffff\1\66\1\uffff\16\66\1\u00a3\13\66",
			"\1\65\22\uffff\32\66\4\uffff\1\66\1\uffff\10\66\1\u00a4\21\66",
			"\1\65\22\uffff\32\66\4\uffff\1\66\1\uffff\16\66\1\u00a5\13\66",
			"\1\65\22\uffff\32\66\4\uffff\1\66\1\uffff\15\66\1\u00a6\14\66",
			"\1\65\22\uffff\32\66\4\uffff\1\66\1\uffff\4\66\1\u00a7\25\66",
			"\1\65\22\uffff\32\66\4\uffff\1\66\1\uffff\21\66\1\u00a8\10\66",
			"\1\65\22\uffff\32\66\4\uffff\1\66\1\uffff\24\66\1\u00a9\5\66",
			"\1\65\22\uffff\32\66\4\uffff\1\66\1\uffff\23\66\1\u00aa\6\66",
			"\1\65\22\uffff\32\66\4\uffff\1\66\1\uffff\15\66\1\u00ab\14\66",
			"\1\65\22\uffff\32\66\4\uffff\1\66\1\uffff\6\66\1\u00ac\23\66",
			"\1\65\22\uffff\32\66\4\uffff\1\66\1\uffff\14\66\1\u00ad\15\66",
			"\1\65\22\uffff\32\66\4\uffff\1\66\1\uffff\4\66\1\u00ae\25\66",
			"\1\65\22\uffff\32\66\4\uffff\1\66\1\uffff\4\66\1\u00af\25\66",
			"\1\65\22\uffff\32\66\4\uffff\1\66\1\uffff\15\66\1\u00b0\14\66",
			"\1\65\22\uffff\32\66\4\uffff\1\66\1\uffff\13\66\1\u00b1\16\66",
			"\1\65\22\uffff\32\66\4\uffff\1\66\1\uffff\24\66\1\u00b2\5\66",
			"\1\65\22\uffff\32\66\4\uffff\1\66\1\uffff\1\u00b3\31\66",
			"\1\65\22\uffff\32\66\4\uffff\1\66\1\uffff\15\66\1\u00b4\14\66",
			"\1\65\22\uffff\13\66\1\u00b5\16\66\4\uffff\1\66\1\uffff\32\66",
			"\1\65\1\uffff\12\67\7\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
			"",
			"",
			"",
			"",
			"",
			"\1\65\22\uffff\32\66\4\uffff\1\66\1\uffff\24\66\1\u00b7\5\66",
			"\1\65\1\uffff\12\67\7\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
			"\1\65\22\uffff\32\66\4\uffff\1\66\1\uffff\23\66\1\u00b9\6\66",
			"\1\65\22\uffff\32\66\4\uffff\1\66\1\uffff\10\66\1\u00ba\21\66",
			"\1\65\1\uffff\12\67\7\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
			"\1\65\1\uffff\12\67\7\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
			"\1\65\22\uffff\32\66\4\uffff\1\66\1\uffff\23\66\1\u00bd\6\66",
			"",
			"\1\65\22\uffff\32\66\4\uffff\1\66\1\uffff\13\66\1\u00be\16\66",
			"\1\65\22\uffff\32\66\4\uffff\1\66\1\uffff\24\66\1\u00bf\5\66",
			"\1\65\22\uffff\32\66\4\uffff\1\66\1\uffff\15\66\1\u00c0\14\66",
			"\1\65\22\uffff\32\66\4\uffff\1\66\1\uffff\13\66\1\u00c1\16\66",
			"\1\65\22\uffff\32\66\4\uffff\1\66\1\uffff\6\66\1\u00c2\23\66",
			"\1\65\22\uffff\32\66\4\uffff\1\66\1\uffff\15\66\1\u00c3\14\66",
			"\1\65\22\uffff\32\66\4\uffff\1\66\1\uffff\4\66\1\u00c4\25\66",
			"\1\65\22\uffff\32\66\4\uffff\1\66\1\uffff\16\66\1\u00c5\13\66",
			"\1\65\22\uffff\32\66\4\uffff\1\66\1\uffff\23\66\1\u00c6\6\66",
			"\1\65\22\uffff\32\66\4\uffff\1\66\1\uffff\2\66\1\u00c7\27\66",
			"\1\65\22\uffff\32\66\4\uffff\1\66\1\uffff\2\66\1\u00c8\27\66",
			"\1\65\22\uffff\32\66\4\uffff\1\66\1\uffff\5\66\1\u00c9\24\66",
			"\1\65\1\uffff\12\67\7\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
			"\1\65\1\uffff\12\67\7\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
			"\1\65\1\uffff\12\67\7\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
			"\1\65\22\uffff\32\66\4\uffff\1\66\1\uffff\3\66\1\u00cd\26\66",
			"\1\65\1\uffff\12\67\7\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
			"\1\65\22\uffff\32\66\4\uffff\1\66\1\uffff\4\66\1\u00cf\25\66",
			"\1\65\22\uffff\32\66\4\uffff\1\66\1\uffff\21\66\1\u00d0\10\66",
			"\1\65\22\uffff\32\66\4\uffff\1\66\1\uffff\12\66\1\u00d1\17\66",
			"\1\65\22\uffff\32\66\4\uffff\1\66\1\uffff\23\66\1\u00d2\6\66",
			"\1\65\1\uffff\12\67\7\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
			"",
			"\1\65\22\uffff\32\66\4\uffff\1\66\1\uffff\3\66\1\u00d4\26\66",
			"",
			"\1\65\1\uffff\12\67\7\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
			"\1\65\22\uffff\32\66\4\uffff\1\66\1\uffff\15\66\1\u00d6\14\66",
			"",
			"",
			"\1\65\1\uffff\12\67\7\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
			"\1\65\22\uffff\32\66\4\uffff\1\66\1\uffff\4\66\1\u00d8\25\66",
			"\1\65\22\uffff\32\66\4\uffff\1\66\1\uffff\13\66\1\u00d9\16\66",
			"\1\65\22\uffff\32\66\4\uffff\1\66\1\uffff\4\66\1\u00da\25\66",
			"\1\65\1\uffff\12\67\7\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
			"\1\65\22\uffff\32\66\4\uffff\1\66\1\uffff\15\66\1\u00dc\14\66",
			"\1\65\1\uffff\12\67\7\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
			"\1\65\22\uffff\32\66\4\uffff\1\66\1\uffff\3\66\1\u00de\26\66",
			"\1\65\22\uffff\32\66\4\uffff\1\66\1\uffff\5\66\1\u00df\24\66",
			"\1\65\1\uffff\12\67\7\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
			"\1\65\22\uffff\32\66\4\uffff\1\66\1\uffff\23\66\1\u00e1\6\66",
			"\1\65\22\uffff\32\66\4\uffff\1\66\1\uffff\7\66\1\u00e2\22\66",
			"\1\65\1\uffff\12\67\7\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
			"",
			"",
			"",
			"\1\65\22\uffff\32\66\4\uffff\1\66\1\uffff\4\66\1\u00e4\25\66",
			"",
			"\1\65\1\uffff\12\67\7\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
			"\1\65\22\uffff\32\66\4\uffff\1\66\1\uffff\15\66\1\u00e6\14\66",
			"\1\65\1\uffff\12\67\7\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
			"\1\65\22\uffff\32\66\4\uffff\1\66\1\uffff\5\66\1\u00e8\24\66",
			"",
			"\1\65\22\uffff\32\66\4\uffff\1\66\1\uffff\4\66\1\u00e9\25\66",
			"",
			"\1\65\22\uffff\32\66\4\uffff\1\66\1\uffff\24\66\1\u00ea\5\66",
			"",
			"\1\65\1\uffff\12\67\7\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
			"\1\65\22\uffff\32\66\4\uffff\1\66\1\uffff\23\66\1\u00ec\6\66",
			"\1\65\1\uffff\12\67\7\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
			"",
			"\1\65\22\uffff\32\66\4\uffff\1\66\1\uffff\4\66\1\u00ee\25\66",
			"",
			"\1\65\1\uffff\12\67\7\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
			"\1\65\1\uffff\12\67\7\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
			"",
			"\1\65\1\uffff\12\67\7\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
			"\1\65\1\uffff\12\67\7\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
			"",
			"\1\65\22\uffff\32\66\4\uffff\1\66\1\uffff\5\66\1\u00f3\24\66",
			"",
			"\1\65\1\uffff\12\67\7\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
			"",
			"\1\65\1\uffff\12\67\7\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
			"\1\65\1\uffff\12\67\7\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
			"\1\65\22\uffff\32\66\4\uffff\1\66\1\uffff\4\66\1\u00f7\25\66",
			"",
			"\1\65\1\uffff\12\67\7\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
			"",
			"\1\65\22\uffff\32\66\4\uffff\1\66\1\uffff\3\66\1\u00f9\26\66",
			"",
			"",
			"",
			"",
			"\1\65\1\uffff\12\67\7\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
			"",
			"",
			"",
			"\1\65\1\uffff\12\67\7\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
			"",
			"\1\65\1\uffff\12\67\7\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
			"",
			"",
			""
	};

	static final short[] DFA15_eot = DFA.unpackEncodedString(DFA15_eotS);
	static final short[] DFA15_eof = DFA.unpackEncodedString(DFA15_eofS);
	static final char[] DFA15_min = DFA.unpackEncodedStringToUnsignedChars(DFA15_minS);
	static final char[] DFA15_max = DFA.unpackEncodedStringToUnsignedChars(DFA15_maxS);
	static final short[] DFA15_accept = DFA.unpackEncodedString(DFA15_acceptS);
	static final short[] DFA15_special = DFA.unpackEncodedString(DFA15_specialS);
	static final short[][] DFA15_transition;

	static {
		int numStates = DFA15_transitionS.length;
		DFA15_transition = new short[numStates][];
		for (int i=0; i<numStates; i++) {
			DFA15_transition[i] = DFA.unpackEncodedString(DFA15_transitionS[i]);
		}
	}

	protected class DFA15 extends DFA {

		public DFA15(BaseRecognizer recognizer) {
			this.recognizer = recognizer;
			this.decisionNumber = 15;
			this.eot = DFA15_eot;
			this.eof = DFA15_eof;
			this.min = DFA15_min;
			this.max = DFA15_max;
			this.accept = DFA15_accept;
			this.special = DFA15_special;
			this.transition = DFA15_transition;
		}
		@Override
		public String getDescription() {
			return "1:1: Tokens : ( LITERAL | CHARACTER | HEADER | COMMENT1 | COMMENT2 | INT_TYPE | CHAR_TYPE | VOID_TYPE | FLOAT_TYPE | DOUBLE_TYPE | BOOL_TYPE | UNSIGNED_TYPE | SIGNED_TYPE | LONG_TYPE | SHORT_TYPE | CONST_TYPE | STRUCT_TYPE | UNION_TYPE | ENUM_TYPE | TYPEDEF_ | MAIN_ | WHILE_ | DO_ | IF_ | ELSE_ | FOR_ | RETURN_ | CONTINUE_ | BREAK_ | SWITCH_ | CASE_ | DEFAULT_ | PRINTF_ | SCANF_ | INCLUDE_ | DEFINE_ | NULL | EEOF | RSHIFTE_OP | LSHIFTE_OP | EQ_OP | LE_OP | GE_OP | NE_OP | PP_OP | MM_OP | PE_OP | MIE_OP | MULE_OP | DIE_OP | REE_OP | RSHIFT_OP | LSHIFT_OP | LT_OP | GT_OP | NOT_OP | AND_OP | OR_OP | LMP_OP | RMP_OP | LLP_OP | RLP_OP | LSP_OP | RSP_OP | CM_OP | SC_OP | PT_OP | PR_OP | AND_AR | OR_AR | PLU_AR | MI_AR | MUL_AR | DI_AR | RE_AR | EQ_AR | COMP_OP | XOR_AR | QUE_OP | COL_OP | HT_OP | SIZEOF_ | DEC_NUM | ID | FLOAT_NUM | NEW_LINE | WS );";
		}
	}

}
