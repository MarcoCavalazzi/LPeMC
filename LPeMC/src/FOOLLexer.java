// $ANTLR 3.5.2 C:\\Users\\Mark\\Documents\\UNI\\IngSS\\2015_2016\\eclipse\\workspace\\LPeMC.FOOL3_prof version\\FOOL.g 2015-12-11 15:21:40

import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class FOOLLexer extends Lexer {
	public static final int EOF=-1;
	public static final int ASS=4;
	public static final int BOOL=5;
	public static final int CLPAR=6;
	public static final int COLON=7;
	public static final int COMMA=8;
	public static final int COMMENT=9;
	public static final int CRPAR=10;
	public static final int ELSE=11;
	public static final int EQ=12;
	public static final int ERR=13;
	public static final int FALSE=14;
	public static final int FUN=15;
	public static final int ID=16;
	public static final int IF=17;
	public static final int IN=18;
	public static final int INT=19;
	public static final int LET=20;
	public static final int LPAR=21;
	public static final int NAT=22;
	public static final int PLUS=23;
	public static final int PRINT=24;
	public static final int RPAR=25;
	public static final int SEMIC=26;
	public static final int THEN=27;
	public static final int TIMES=28;
	public static final int TRUE=29;
	public static final int VAR=30;
	public static final int WHITESP=31;

	int lexicalErrors=0;


	// delegates
	// delegators
	public Lexer[] getDelegates() {
		return new Lexer[] {};
	}

	public FOOLLexer() {} 
	public FOOLLexer(CharStream input) {
		this(input, new RecognizerSharedState());
	}
	public FOOLLexer(CharStream input, RecognizerSharedState state) {
		super(input,state);
	}
	@Override public String getGrammarFileName() { return "C:\\Users\\Mark\\Documents\\UNI\\IngSS\\2015_2016\\eclipse\\workspace\\LPeMC.FOOL3_prof version\\FOOL.g"; }

	// $ANTLR start "SEMIC"
	public final void mSEMIC() throws RecognitionException {
		try {
			int _type = SEMIC;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\Mark\\Documents\\UNI\\IngSS\\2015_2016\\eclipse\\workspace\\LPeMC.FOOL3_prof version\\FOOL.g:156:7: ( ';' )
			// C:\\Users\\Mark\\Documents\\UNI\\IngSS\\2015_2016\\eclipse\\workspace\\LPeMC.FOOL3_prof version\\FOOL.g:156:9: ';'
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
	// $ANTLR end "SEMIC"

	// $ANTLR start "COLON"
	public final void mCOLON() throws RecognitionException {
		try {
			int _type = COLON;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\Mark\\Documents\\UNI\\IngSS\\2015_2016\\eclipse\\workspace\\LPeMC.FOOL3_prof version\\FOOL.g:157:7: ( ':' )
			// C:\\Users\\Mark\\Documents\\UNI\\IngSS\\2015_2016\\eclipse\\workspace\\LPeMC.FOOL3_prof version\\FOOL.g:157:9: ':'
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
	// $ANTLR end "COLON"

	// $ANTLR start "COMMA"
	public final void mCOMMA() throws RecognitionException {
		try {
			int _type = COMMA;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\Mark\\Documents\\UNI\\IngSS\\2015_2016\\eclipse\\workspace\\LPeMC.FOOL3_prof version\\FOOL.g:158:7: ( ',' )
			// C:\\Users\\Mark\\Documents\\UNI\\IngSS\\2015_2016\\eclipse\\workspace\\LPeMC.FOOL3_prof version\\FOOL.g:158:9: ','
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
	// $ANTLR end "COMMA"

	// $ANTLR start "EQ"
	public final void mEQ() throws RecognitionException {
		try {
			int _type = EQ;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\Mark\\Documents\\UNI\\IngSS\\2015_2016\\eclipse\\workspace\\LPeMC.FOOL3_prof version\\FOOL.g:159:4: ( '==' )
			// C:\\Users\\Mark\\Documents\\UNI\\IngSS\\2015_2016\\eclipse\\workspace\\LPeMC.FOOL3_prof version\\FOOL.g:159:6: '=='
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
	// $ANTLR end "EQ"

	// $ANTLR start "ASS"
	public final void mASS() throws RecognitionException {
		try {
			int _type = ASS;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\Mark\\Documents\\UNI\\IngSS\\2015_2016\\eclipse\\workspace\\LPeMC.FOOL3_prof version\\FOOL.g:160:5: ( '=' )
			// C:\\Users\\Mark\\Documents\\UNI\\IngSS\\2015_2016\\eclipse\\workspace\\LPeMC.FOOL3_prof version\\FOOL.g:160:7: '='
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
	// $ANTLR end "ASS"

	// $ANTLR start "PLUS"
	public final void mPLUS() throws RecognitionException {
		try {
			int _type = PLUS;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\Mark\\Documents\\UNI\\IngSS\\2015_2016\\eclipse\\workspace\\LPeMC.FOOL3_prof version\\FOOL.g:161:6: ( '+' )
			// C:\\Users\\Mark\\Documents\\UNI\\IngSS\\2015_2016\\eclipse\\workspace\\LPeMC.FOOL3_prof version\\FOOL.g:161:8: '+'
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
	// $ANTLR end "PLUS"

	// $ANTLR start "TIMES"
	public final void mTIMES() throws RecognitionException {
		try {
			int _type = TIMES;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\Mark\\Documents\\UNI\\IngSS\\2015_2016\\eclipse\\workspace\\LPeMC.FOOL3_prof version\\FOOL.g:162:7: ( '*' )
			// C:\\Users\\Mark\\Documents\\UNI\\IngSS\\2015_2016\\eclipse\\workspace\\LPeMC.FOOL3_prof version\\FOOL.g:162:9: '*'
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
	// $ANTLR end "TIMES"

	// $ANTLR start "NAT"
	public final void mNAT() throws RecognitionException {
		try {
			int _type = NAT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\Mark\\Documents\\UNI\\IngSS\\2015_2016\\eclipse\\workspace\\LPeMC.FOOL3_prof version\\FOOL.g:163:5: ( ( ( '1' .. '9' ) ( '0' .. '9' )* ) | '0' )
			int alt2=2;
			int LA2_0 = input.LA(1);
			if ( ((LA2_0 >= '1' && LA2_0 <= '9')) ) {
				alt2=1;
			}
			else if ( (LA2_0=='0') ) {
				alt2=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 2, 0, input);
				throw nvae;
			}

			switch (alt2) {
				case 1 :
					// C:\\Users\\Mark\\Documents\\UNI\\IngSS\\2015_2016\\eclipse\\workspace\\LPeMC.FOOL3_prof version\\FOOL.g:163:7: ( ( '1' .. '9' ) ( '0' .. '9' )* )
					{
					// C:\\Users\\Mark\\Documents\\UNI\\IngSS\\2015_2016\\eclipse\\workspace\\LPeMC.FOOL3_prof version\\FOOL.g:163:7: ( ( '1' .. '9' ) ( '0' .. '9' )* )
					// C:\\Users\\Mark\\Documents\\UNI\\IngSS\\2015_2016\\eclipse\\workspace\\LPeMC.FOOL3_prof version\\FOOL.g:163:8: ( '1' .. '9' ) ( '0' .. '9' )*
					{
					if ( (input.LA(1) >= '1' && input.LA(1) <= '9') ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					// C:\\Users\\Mark\\Documents\\UNI\\IngSS\\2015_2016\\eclipse\\workspace\\LPeMC.FOOL3_prof version\\FOOL.g:163:18: ( '0' .. '9' )*
					loop1:
					while (true) {
						int alt1=2;
						int LA1_0 = input.LA(1);
						if ( ((LA1_0 >= '0' && LA1_0 <= '9')) ) {
							alt1=1;
						}

						switch (alt1) {
						case 1 :
							// C:\\Users\\Mark\\Documents\\UNI\\IngSS\\2015_2016\\eclipse\\workspace\\LPeMC.FOOL3_prof version\\FOOL.g:
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
							break loop1;
						}
					}

					}

					}
					break;
				case 2 :
					// C:\\Users\\Mark\\Documents\\UNI\\IngSS\\2015_2016\\eclipse\\workspace\\LPeMC.FOOL3_prof version\\FOOL.g:163:33: '0'
					{
					match('0'); 
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
	// $ANTLR end "NAT"

	// $ANTLR start "TRUE"
	public final void mTRUE() throws RecognitionException {
		try {
			int _type = TRUE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\Mark\\Documents\\UNI\\IngSS\\2015_2016\\eclipse\\workspace\\LPeMC.FOOL3_prof version\\FOOL.g:164:6: ( 'true' )
			// C:\\Users\\Mark\\Documents\\UNI\\IngSS\\2015_2016\\eclipse\\workspace\\LPeMC.FOOL3_prof version\\FOOL.g:164:8: 'true'
			{
			match("true"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "TRUE"

	// $ANTLR start "FALSE"
	public final void mFALSE() throws RecognitionException {
		try {
			int _type = FALSE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\Mark\\Documents\\UNI\\IngSS\\2015_2016\\eclipse\\workspace\\LPeMC.FOOL3_prof version\\FOOL.g:165:7: ( 'false' )
			// C:\\Users\\Mark\\Documents\\UNI\\IngSS\\2015_2016\\eclipse\\workspace\\LPeMC.FOOL3_prof version\\FOOL.g:165:9: 'false'
			{
			match("false"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "FALSE"

	// $ANTLR start "LPAR"
	public final void mLPAR() throws RecognitionException {
		try {
			int _type = LPAR;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\Mark\\Documents\\UNI\\IngSS\\2015_2016\\eclipse\\workspace\\LPeMC.FOOL3_prof version\\FOOL.g:166:7: ( '(' )
			// C:\\Users\\Mark\\Documents\\UNI\\IngSS\\2015_2016\\eclipse\\workspace\\LPeMC.FOOL3_prof version\\FOOL.g:166:9: '('
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
	// $ANTLR end "LPAR"

	// $ANTLR start "RPAR"
	public final void mRPAR() throws RecognitionException {
		try {
			int _type = RPAR;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\Mark\\Documents\\UNI\\IngSS\\2015_2016\\eclipse\\workspace\\LPeMC.FOOL3_prof version\\FOOL.g:167:6: ( ')' )
			// C:\\Users\\Mark\\Documents\\UNI\\IngSS\\2015_2016\\eclipse\\workspace\\LPeMC.FOOL3_prof version\\FOOL.g:167:8: ')'
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
	// $ANTLR end "RPAR"

	// $ANTLR start "CLPAR"
	public final void mCLPAR() throws RecognitionException {
		try {
			int _type = CLPAR;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\Mark\\Documents\\UNI\\IngSS\\2015_2016\\eclipse\\workspace\\LPeMC.FOOL3_prof version\\FOOL.g:168:8: ( '{' )
			// C:\\Users\\Mark\\Documents\\UNI\\IngSS\\2015_2016\\eclipse\\workspace\\LPeMC.FOOL3_prof version\\FOOL.g:168:10: '{'
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
	// $ANTLR end "CLPAR"

	// $ANTLR start "CRPAR"
	public final void mCRPAR() throws RecognitionException {
		try {
			int _type = CRPAR;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\Mark\\Documents\\UNI\\IngSS\\2015_2016\\eclipse\\workspace\\LPeMC.FOOL3_prof version\\FOOL.g:169:7: ( '}' )
			// C:\\Users\\Mark\\Documents\\UNI\\IngSS\\2015_2016\\eclipse\\workspace\\LPeMC.FOOL3_prof version\\FOOL.g:169:9: '}'
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
	// $ANTLR end "CRPAR"

	// $ANTLR start "IF"
	public final void mIF() throws RecognitionException {
		try {
			int _type = IF;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\Mark\\Documents\\UNI\\IngSS\\2015_2016\\eclipse\\workspace\\LPeMC.FOOL3_prof version\\FOOL.g:170:5: ( 'if' )
			// C:\\Users\\Mark\\Documents\\UNI\\IngSS\\2015_2016\\eclipse\\workspace\\LPeMC.FOOL3_prof version\\FOOL.g:170:7: 'if'
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
	// $ANTLR end "IF"

	// $ANTLR start "THEN"
	public final void mTHEN() throws RecognitionException {
		try {
			int _type = THEN;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\Mark\\Documents\\UNI\\IngSS\\2015_2016\\eclipse\\workspace\\LPeMC.FOOL3_prof version\\FOOL.g:171:7: ( 'then' )
			// C:\\Users\\Mark\\Documents\\UNI\\IngSS\\2015_2016\\eclipse\\workspace\\LPeMC.FOOL3_prof version\\FOOL.g:171:9: 'then'
			{
			match("then"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "THEN"

	// $ANTLR start "ELSE"
	public final void mELSE() throws RecognitionException {
		try {
			int _type = ELSE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\Mark\\Documents\\UNI\\IngSS\\2015_2016\\eclipse\\workspace\\LPeMC.FOOL3_prof version\\FOOL.g:172:7: ( 'else' )
			// C:\\Users\\Mark\\Documents\\UNI\\IngSS\\2015_2016\\eclipse\\workspace\\LPeMC.FOOL3_prof version\\FOOL.g:172:9: 'else'
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
	// $ANTLR end "ELSE"

	// $ANTLR start "PRINT"
	public final void mPRINT() throws RecognitionException {
		try {
			int _type = PRINT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\Mark\\Documents\\UNI\\IngSS\\2015_2016\\eclipse\\workspace\\LPeMC.FOOL3_prof version\\FOOL.g:173:7: ( 'print' )
			// C:\\Users\\Mark\\Documents\\UNI\\IngSS\\2015_2016\\eclipse\\workspace\\LPeMC.FOOL3_prof version\\FOOL.g:173:9: 'print'
			{
			match("print"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "PRINT"

	// $ANTLR start "LET"
	public final void mLET() throws RecognitionException {
		try {
			int _type = LET;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\Mark\\Documents\\UNI\\IngSS\\2015_2016\\eclipse\\workspace\\LPeMC.FOOL3_prof version\\FOOL.g:174:5: ( 'let' )
			// C:\\Users\\Mark\\Documents\\UNI\\IngSS\\2015_2016\\eclipse\\workspace\\LPeMC.FOOL3_prof version\\FOOL.g:174:7: 'let'
			{
			match("let"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "LET"

	// $ANTLR start "IN"
	public final void mIN() throws RecognitionException {
		try {
			int _type = IN;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\Mark\\Documents\\UNI\\IngSS\\2015_2016\\eclipse\\workspace\\LPeMC.FOOL3_prof version\\FOOL.g:175:4: ( 'in' )
			// C:\\Users\\Mark\\Documents\\UNI\\IngSS\\2015_2016\\eclipse\\workspace\\LPeMC.FOOL3_prof version\\FOOL.g:175:6: 'in'
			{
			match("in"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "IN"

	// $ANTLR start "VAR"
	public final void mVAR() throws RecognitionException {
		try {
			int _type = VAR;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\Mark\\Documents\\UNI\\IngSS\\2015_2016\\eclipse\\workspace\\LPeMC.FOOL3_prof version\\FOOL.g:176:5: ( 'var' )
			// C:\\Users\\Mark\\Documents\\UNI\\IngSS\\2015_2016\\eclipse\\workspace\\LPeMC.FOOL3_prof version\\FOOL.g:176:7: 'var'
			{
			match("var"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "VAR"

	// $ANTLR start "FUN"
	public final void mFUN() throws RecognitionException {
		try {
			int _type = FUN;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\Mark\\Documents\\UNI\\IngSS\\2015_2016\\eclipse\\workspace\\LPeMC.FOOL3_prof version\\FOOL.g:177:5: ( 'fun' )
			// C:\\Users\\Mark\\Documents\\UNI\\IngSS\\2015_2016\\eclipse\\workspace\\LPeMC.FOOL3_prof version\\FOOL.g:177:7: 'fun'
			{
			match("fun"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "FUN"

	// $ANTLR start "INT"
	public final void mINT() throws RecognitionException {
		try {
			int _type = INT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\Mark\\Documents\\UNI\\IngSS\\2015_2016\\eclipse\\workspace\\LPeMC.FOOL3_prof version\\FOOL.g:178:5: ( 'int' )
			// C:\\Users\\Mark\\Documents\\UNI\\IngSS\\2015_2016\\eclipse\\workspace\\LPeMC.FOOL3_prof version\\FOOL.g:178:7: 'int'
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
	// $ANTLR end "INT"

	// $ANTLR start "BOOL"
	public final void mBOOL() throws RecognitionException {
		try {
			int _type = BOOL;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\Mark\\Documents\\UNI\\IngSS\\2015_2016\\eclipse\\workspace\\LPeMC.FOOL3_prof version\\FOOL.g:179:6: ( 'bool' )
			// C:\\Users\\Mark\\Documents\\UNI\\IngSS\\2015_2016\\eclipse\\workspace\\LPeMC.FOOL3_prof version\\FOOL.g:179:8: 'bool'
			{
			match("bool"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "BOOL"

	// $ANTLR start "ID"
	public final void mID() throws RecognitionException {
		try {
			int _type = ID;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\Mark\\Documents\\UNI\\IngSS\\2015_2016\\eclipse\\workspace\\LPeMC.FOOL3_prof version\\FOOL.g:181:5: ( ( 'a' .. 'z' | 'A' .. 'Z' ) ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' )* )
			// C:\\Users\\Mark\\Documents\\UNI\\IngSS\\2015_2016\\eclipse\\workspace\\LPeMC.FOOL3_prof version\\FOOL.g:181:7: ( 'a' .. 'z' | 'A' .. 'Z' ) ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' )*
			{
			if ( (input.LA(1) >= 'A' && input.LA(1) <= 'Z')||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			// C:\\Users\\Mark\\Documents\\UNI\\IngSS\\2015_2016\\eclipse\\workspace\\LPeMC.FOOL3_prof version\\FOOL.g:182:5: ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' )*
			loop3:
			while (true) {
				int alt3=2;
				int LA3_0 = input.LA(1);
				if ( ((LA3_0 >= '0' && LA3_0 <= '9')||(LA3_0 >= 'A' && LA3_0 <= 'Z')||(LA3_0 >= 'a' && LA3_0 <= 'z')) ) {
					alt3=1;
				}

				switch (alt3) {
				case 1 :
					// C:\\Users\\Mark\\Documents\\UNI\\IngSS\\2015_2016\\eclipse\\workspace\\LPeMC.FOOL3_prof version\\FOOL.g:
					{
					if ( (input.LA(1) >= '0' && input.LA(1) <= '9')||(input.LA(1) >= 'A' && input.LA(1) <= 'Z')||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
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

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "ID"

	// $ANTLR start "WHITESP"
	public final void mWHITESP() throws RecognitionException {
		try {
			int _type = WHITESP;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\Mark\\Documents\\UNI\\IngSS\\2015_2016\\eclipse\\workspace\\LPeMC.FOOL3_prof version\\FOOL.g:184:10: ( ( '\\t' | ' ' | '\\r' | '\\n' )+ )
			// C:\\Users\\Mark\\Documents\\UNI\\IngSS\\2015_2016\\eclipse\\workspace\\LPeMC.FOOL3_prof version\\FOOL.g:184:12: ( '\\t' | ' ' | '\\r' | '\\n' )+
			{
			// C:\\Users\\Mark\\Documents\\UNI\\IngSS\\2015_2016\\eclipse\\workspace\\LPeMC.FOOL3_prof version\\FOOL.g:184:12: ( '\\t' | ' ' | '\\r' | '\\n' )+
			int cnt4=0;
			loop4:
			while (true) {
				int alt4=2;
				int LA4_0 = input.LA(1);
				if ( ((LA4_0 >= '\t' && LA4_0 <= '\n')||LA4_0=='\r'||LA4_0==' ') ) {
					alt4=1;
				}

				switch (alt4) {
				case 1 :
					// C:\\Users\\Mark\\Documents\\UNI\\IngSS\\2015_2016\\eclipse\\workspace\\LPeMC.FOOL3_prof version\\FOOL.g:
					{
					if ( (input.LA(1) >= '\t' && input.LA(1) <= '\n')||input.LA(1)=='\r'||input.LA(1)==' ' ) {
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
					if ( cnt4 >= 1 ) break loop4;
					EarlyExitException eee = new EarlyExitException(4, input);
					throw eee;
				}
				cnt4++;
			}

			 _channel=HIDDEN; 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "WHITESP"

	// $ANTLR start "COMMENT"
	public final void mCOMMENT() throws RecognitionException {
		try {
			int _type = COMMENT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\Mark\\Documents\\UNI\\IngSS\\2015_2016\\eclipse\\workspace\\LPeMC.FOOL3_prof version\\FOOL.g:186:9: ( '/*' ( . )* '*/' )
			// C:\\Users\\Mark\\Documents\\UNI\\IngSS\\2015_2016\\eclipse\\workspace\\LPeMC.FOOL3_prof version\\FOOL.g:186:11: '/*' ( . )* '*/'
			{
			match("/*"); 

			// C:\\Users\\Mark\\Documents\\UNI\\IngSS\\2015_2016\\eclipse\\workspace\\LPeMC.FOOL3_prof version\\FOOL.g:186:16: ( . )*
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
					// C:\\Users\\Mark\\Documents\\UNI\\IngSS\\2015_2016\\eclipse\\workspace\\LPeMC.FOOL3_prof version\\FOOL.g:186:16: .
					{
					matchAny(); 
					}
					break;

				default :
					break loop5;
				}
			}

			match("*/"); 

			 _channel=HIDDEN; 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "COMMENT"

	// $ANTLR start "ERR"
	public final void mERR() throws RecognitionException {
		try {
			int _type = ERR;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\Mark\\Documents\\UNI\\IngSS\\2015_2016\\eclipse\\workspace\\LPeMC.FOOL3_prof version\\FOOL.g:188:9: ( . )
			// C:\\Users\\Mark\\Documents\\UNI\\IngSS\\2015_2016\\eclipse\\workspace\\LPeMC.FOOL3_prof version\\FOOL.g:188:11: .
			{
			matchAny(); 
			 System.out.println("Invalid char: "+getText()); lexicalErrors++; _channel=HIDDEN; 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "ERR"

	@Override
	public void mTokens() throws RecognitionException {
		// C:\\Users\\Mark\\Documents\\UNI\\IngSS\\2015_2016\\eclipse\\workspace\\LPeMC.FOOL3_prof version\\FOOL.g:1:8: ( SEMIC | COLON | COMMA | EQ | ASS | PLUS | TIMES | NAT | TRUE | FALSE | LPAR | RPAR | CLPAR | CRPAR | IF | THEN | ELSE | PRINT | LET | IN | VAR | FUN | INT | BOOL | ID | WHITESP | COMMENT | ERR )
		int alt6=28;
		alt6 = dfa6.predict(input);
		switch (alt6) {
			case 1 :
				// C:\\Users\\Mark\\Documents\\UNI\\IngSS\\2015_2016\\eclipse\\workspace\\LPeMC.FOOL3_prof version\\FOOL.g:1:10: SEMIC
				{
				mSEMIC(); 

				}
				break;
			case 2 :
				// C:\\Users\\Mark\\Documents\\UNI\\IngSS\\2015_2016\\eclipse\\workspace\\LPeMC.FOOL3_prof version\\FOOL.g:1:16: COLON
				{
				mCOLON(); 

				}
				break;
			case 3 :
				// C:\\Users\\Mark\\Documents\\UNI\\IngSS\\2015_2016\\eclipse\\workspace\\LPeMC.FOOL3_prof version\\FOOL.g:1:22: COMMA
				{
				mCOMMA(); 

				}
				break;
			case 4 :
				// C:\\Users\\Mark\\Documents\\UNI\\IngSS\\2015_2016\\eclipse\\workspace\\LPeMC.FOOL3_prof version\\FOOL.g:1:28: EQ
				{
				mEQ(); 

				}
				break;
			case 5 :
				// C:\\Users\\Mark\\Documents\\UNI\\IngSS\\2015_2016\\eclipse\\workspace\\LPeMC.FOOL3_prof version\\FOOL.g:1:31: ASS
				{
				mASS(); 

				}
				break;
			case 6 :
				// C:\\Users\\Mark\\Documents\\UNI\\IngSS\\2015_2016\\eclipse\\workspace\\LPeMC.FOOL3_prof version\\FOOL.g:1:35: PLUS
				{
				mPLUS(); 

				}
				break;
			case 7 :
				// C:\\Users\\Mark\\Documents\\UNI\\IngSS\\2015_2016\\eclipse\\workspace\\LPeMC.FOOL3_prof version\\FOOL.g:1:40: TIMES
				{
				mTIMES(); 

				}
				break;
			case 8 :
				// C:\\Users\\Mark\\Documents\\UNI\\IngSS\\2015_2016\\eclipse\\workspace\\LPeMC.FOOL3_prof version\\FOOL.g:1:46: NAT
				{
				mNAT(); 

				}
				break;
			case 9 :
				// C:\\Users\\Mark\\Documents\\UNI\\IngSS\\2015_2016\\eclipse\\workspace\\LPeMC.FOOL3_prof version\\FOOL.g:1:50: TRUE
				{
				mTRUE(); 

				}
				break;
			case 10 :
				// C:\\Users\\Mark\\Documents\\UNI\\IngSS\\2015_2016\\eclipse\\workspace\\LPeMC.FOOL3_prof version\\FOOL.g:1:55: FALSE
				{
				mFALSE(); 

				}
				break;
			case 11 :
				// C:\\Users\\Mark\\Documents\\UNI\\IngSS\\2015_2016\\eclipse\\workspace\\LPeMC.FOOL3_prof version\\FOOL.g:1:61: LPAR
				{
				mLPAR(); 

				}
				break;
			case 12 :
				// C:\\Users\\Mark\\Documents\\UNI\\IngSS\\2015_2016\\eclipse\\workspace\\LPeMC.FOOL3_prof version\\FOOL.g:1:66: RPAR
				{
				mRPAR(); 

				}
				break;
			case 13 :
				// C:\\Users\\Mark\\Documents\\UNI\\IngSS\\2015_2016\\eclipse\\workspace\\LPeMC.FOOL3_prof version\\FOOL.g:1:71: CLPAR
				{
				mCLPAR(); 

				}
				break;
			case 14 :
				// C:\\Users\\Mark\\Documents\\UNI\\IngSS\\2015_2016\\eclipse\\workspace\\LPeMC.FOOL3_prof version\\FOOL.g:1:77: CRPAR
				{
				mCRPAR(); 

				}
				break;
			case 15 :
				// C:\\Users\\Mark\\Documents\\UNI\\IngSS\\2015_2016\\eclipse\\workspace\\LPeMC.FOOL3_prof version\\FOOL.g:1:83: IF
				{
				mIF(); 

				}
				break;
			case 16 :
				// C:\\Users\\Mark\\Documents\\UNI\\IngSS\\2015_2016\\eclipse\\workspace\\LPeMC.FOOL3_prof version\\FOOL.g:1:86: THEN
				{
				mTHEN(); 

				}
				break;
			case 17 :
				// C:\\Users\\Mark\\Documents\\UNI\\IngSS\\2015_2016\\eclipse\\workspace\\LPeMC.FOOL3_prof version\\FOOL.g:1:91: ELSE
				{
				mELSE(); 

				}
				break;
			case 18 :
				// C:\\Users\\Mark\\Documents\\UNI\\IngSS\\2015_2016\\eclipse\\workspace\\LPeMC.FOOL3_prof version\\FOOL.g:1:96: PRINT
				{
				mPRINT(); 

				}
				break;
			case 19 :
				// C:\\Users\\Mark\\Documents\\UNI\\IngSS\\2015_2016\\eclipse\\workspace\\LPeMC.FOOL3_prof version\\FOOL.g:1:102: LET
				{
				mLET(); 

				}
				break;
			case 20 :
				// C:\\Users\\Mark\\Documents\\UNI\\IngSS\\2015_2016\\eclipse\\workspace\\LPeMC.FOOL3_prof version\\FOOL.g:1:106: IN
				{
				mIN(); 

				}
				break;
			case 21 :
				// C:\\Users\\Mark\\Documents\\UNI\\IngSS\\2015_2016\\eclipse\\workspace\\LPeMC.FOOL3_prof version\\FOOL.g:1:109: VAR
				{
				mVAR(); 

				}
				break;
			case 22 :
				// C:\\Users\\Mark\\Documents\\UNI\\IngSS\\2015_2016\\eclipse\\workspace\\LPeMC.FOOL3_prof version\\FOOL.g:1:113: FUN
				{
				mFUN(); 

				}
				break;
			case 23 :
				// C:\\Users\\Mark\\Documents\\UNI\\IngSS\\2015_2016\\eclipse\\workspace\\LPeMC.FOOL3_prof version\\FOOL.g:1:117: INT
				{
				mINT(); 

				}
				break;
			case 24 :
				// C:\\Users\\Mark\\Documents\\UNI\\IngSS\\2015_2016\\eclipse\\workspace\\LPeMC.FOOL3_prof version\\FOOL.g:1:121: BOOL
				{
				mBOOL(); 

				}
				break;
			case 25 :
				// C:\\Users\\Mark\\Documents\\UNI\\IngSS\\2015_2016\\eclipse\\workspace\\LPeMC.FOOL3_prof version\\FOOL.g:1:126: ID
				{
				mID(); 

				}
				break;
			case 26 :
				// C:\\Users\\Mark\\Documents\\UNI\\IngSS\\2015_2016\\eclipse\\workspace\\LPeMC.FOOL3_prof version\\FOOL.g:1:129: WHITESP
				{
				mWHITESP(); 

				}
				break;
			case 27 :
				// C:\\Users\\Mark\\Documents\\UNI\\IngSS\\2015_2016\\eclipse\\workspace\\LPeMC.FOOL3_prof version\\FOOL.g:1:137: COMMENT
				{
				mCOMMENT(); 

				}
				break;
			case 28 :
				// C:\\Users\\Mark\\Documents\\UNI\\IngSS\\2015_2016\\eclipse\\workspace\\LPeMC.FOOL3_prof version\\FOOL.g:1:145: ERR
				{
				mERR(); 

				}
				break;

		}
	}


	protected DFA6 dfa6 = new DFA6(this);
	static final String DFA6_eotS =
		"\4\uffff\1\35\4\uffff\2\43\4\uffff\6\43\2\uffff\1\30\11\uffff\2\43\1\uffff"+
		"\2\43\4\uffff\1\67\1\71\5\43\2\uffff\3\43\1\102\1\uffff\1\103\1\uffff"+
		"\2\43\1\106\1\107\1\43\1\111\1\112\1\43\2\uffff\1\114\1\43\2\uffff\1\116"+
		"\2\uffff\1\117\1\uffff\1\120\3\uffff";
	static final String DFA6_eofS =
		"\121\uffff";
	static final String DFA6_minS =
		"\1\0\3\uffff\1\75\4\uffff\1\150\1\141\4\uffff\1\146\1\154\1\162\1\145"+
		"\1\141\1\157\2\uffff\1\52\11\uffff\1\165\1\145\1\uffff\1\154\1\156\4\uffff"+
		"\2\60\1\163\1\151\1\164\1\162\1\157\2\uffff\1\145\1\156\1\163\1\60\1\uffff"+
		"\1\60\1\uffff\1\145\1\156\2\60\1\154\2\60\1\145\2\uffff\1\60\1\164\2\uffff"+
		"\1\60\2\uffff\1\60\1\uffff\1\60\3\uffff";
	static final String DFA6_maxS =
		"\1\uffff\3\uffff\1\75\4\uffff\1\162\1\165\4\uffff\1\156\1\154\1\162\1"+
		"\145\1\141\1\157\2\uffff\1\52\11\uffff\1\165\1\145\1\uffff\1\154\1\156"+
		"\4\uffff\2\172\1\163\1\151\1\164\1\162\1\157\2\uffff\1\145\1\156\1\163"+
		"\1\172\1\uffff\1\172\1\uffff\1\145\1\156\2\172\1\154\2\172\1\145\2\uffff"+
		"\1\172\1\164\2\uffff\1\172\2\uffff\1\172\1\uffff\1\172\3\uffff";
	static final String DFA6_acceptS =
		"\1\uffff\1\1\1\2\1\3\1\uffff\1\6\1\7\2\10\2\uffff\1\13\1\14\1\15\1\16"+
		"\6\uffff\1\31\1\32\1\uffff\1\34\1\1\1\2\1\3\1\4\1\5\1\6\1\7\1\10\2\uffff"+
		"\1\31\2\uffff\1\13\1\14\1\15\1\16\7\uffff\1\32\1\33\4\uffff\1\17\1\uffff"+
		"\1\24\10\uffff\1\26\1\27\2\uffff\1\23\1\25\1\uffff\1\11\1\20\1\uffff\1"+
		"\21\1\uffff\1\30\1\12\1\22";
	static final String DFA6_specialS =
		"\1\0\120\uffff}>";
	static final String[] DFA6_transitionS = {
			"\11\30\2\26\2\30\1\26\22\30\1\26\7\30\1\13\1\14\1\6\1\5\1\3\2\30\1\27"+
			"\1\10\11\7\1\2\1\1\1\30\1\4\3\30\32\25\6\30\1\25\1\24\2\25\1\20\1\12"+
			"\2\25\1\17\2\25\1\22\3\25\1\21\3\25\1\11\1\25\1\23\4\25\1\15\1\30\1\16"+
			"\uff82\30",
			"",
			"",
			"",
			"\1\34",
			"",
			"",
			"",
			"",
			"\1\42\11\uffff\1\41",
			"\1\44\23\uffff\1\45",
			"",
			"",
			"",
			"",
			"\1\52\7\uffff\1\53",
			"\1\54",
			"\1\55",
			"\1\56",
			"\1\57",
			"\1\60",
			"",
			"",
			"\1\62",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"\1\63",
			"\1\64",
			"",
			"\1\65",
			"\1\66",
			"",
			"",
			"",
			"",
			"\12\43\7\uffff\32\43\6\uffff\32\43",
			"\12\43\7\uffff\32\43\6\uffff\23\43\1\70\6\43",
			"\1\72",
			"\1\73",
			"\1\74",
			"\1\75",
			"\1\76",
			"",
			"",
			"\1\77",
			"\1\100",
			"\1\101",
			"\12\43\7\uffff\32\43\6\uffff\32\43",
			"",
			"\12\43\7\uffff\32\43\6\uffff\32\43",
			"",
			"\1\104",
			"\1\105",
			"\12\43\7\uffff\32\43\6\uffff\32\43",
			"\12\43\7\uffff\32\43\6\uffff\32\43",
			"\1\110",
			"\12\43\7\uffff\32\43\6\uffff\32\43",
			"\12\43\7\uffff\32\43\6\uffff\32\43",
			"\1\113",
			"",
			"",
			"\12\43\7\uffff\32\43\6\uffff\32\43",
			"\1\115",
			"",
			"",
			"\12\43\7\uffff\32\43\6\uffff\32\43",
			"",
			"",
			"\12\43\7\uffff\32\43\6\uffff\32\43",
			"",
			"\12\43\7\uffff\32\43\6\uffff\32\43",
			"",
			"",
			""
	};

	static final short[] DFA6_eot = DFA.unpackEncodedString(DFA6_eotS);
	static final short[] DFA6_eof = DFA.unpackEncodedString(DFA6_eofS);
	static final char[] DFA6_min = DFA.unpackEncodedStringToUnsignedChars(DFA6_minS);
	static final char[] DFA6_max = DFA.unpackEncodedStringToUnsignedChars(DFA6_maxS);
	static final short[] DFA6_accept = DFA.unpackEncodedString(DFA6_acceptS);
	static final short[] DFA6_special = DFA.unpackEncodedString(DFA6_specialS);
	static final short[][] DFA6_transition;

	static {
		int numStates = DFA6_transitionS.length;
		DFA6_transition = new short[numStates][];
		for (int i=0; i<numStates; i++) {
			DFA6_transition[i] = DFA.unpackEncodedString(DFA6_transitionS[i]);
		}
	}

	protected class DFA6 extends DFA {

		public DFA6(BaseRecognizer recognizer) {
			this.recognizer = recognizer;
			this.decisionNumber = 6;
			this.eot = DFA6_eot;
			this.eof = DFA6_eof;
			this.min = DFA6_min;
			this.max = DFA6_max;
			this.accept = DFA6_accept;
			this.special = DFA6_special;
			this.transition = DFA6_transition;
		}
		@Override
		public String getDescription() {
			return "1:1: Tokens : ( SEMIC | COLON | COMMA | EQ | ASS | PLUS | TIMES | NAT | TRUE | FALSE | LPAR | RPAR | CLPAR | CRPAR | IF | THEN | ELSE | PRINT | LET | IN | VAR | FUN | INT | BOOL | ID | WHITESP | COMMENT | ERR );";
		}
		@Override
		public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
			IntStream input = _input;
			int _s = s;
			switch ( s ) {
					case 0 : 
						int LA6_0 = input.LA(1);
						s = -1;
						if ( (LA6_0==';') ) {s = 1;}
						else if ( (LA6_0==':') ) {s = 2;}
						else if ( (LA6_0==',') ) {s = 3;}
						else if ( (LA6_0=='=') ) {s = 4;}
						else if ( (LA6_0=='+') ) {s = 5;}
						else if ( (LA6_0=='*') ) {s = 6;}
						else if ( ((LA6_0 >= '1' && LA6_0 <= '9')) ) {s = 7;}
						else if ( (LA6_0=='0') ) {s = 8;}
						else if ( (LA6_0=='t') ) {s = 9;}
						else if ( (LA6_0=='f') ) {s = 10;}
						else if ( (LA6_0=='(') ) {s = 11;}
						else if ( (LA6_0==')') ) {s = 12;}
						else if ( (LA6_0=='{') ) {s = 13;}
						else if ( (LA6_0=='}') ) {s = 14;}
						else if ( (LA6_0=='i') ) {s = 15;}
						else if ( (LA6_0=='e') ) {s = 16;}
						else if ( (LA6_0=='p') ) {s = 17;}
						else if ( (LA6_0=='l') ) {s = 18;}
						else if ( (LA6_0=='v') ) {s = 19;}
						else if ( (LA6_0=='b') ) {s = 20;}
						else if ( ((LA6_0 >= 'A' && LA6_0 <= 'Z')||LA6_0=='a'||(LA6_0 >= 'c' && LA6_0 <= 'd')||(LA6_0 >= 'g' && LA6_0 <= 'h')||(LA6_0 >= 'j' && LA6_0 <= 'k')||(LA6_0 >= 'm' && LA6_0 <= 'o')||(LA6_0 >= 'q' && LA6_0 <= 's')||LA6_0=='u'||(LA6_0 >= 'w' && LA6_0 <= 'z')) ) {s = 21;}
						else if ( ((LA6_0 >= '\t' && LA6_0 <= '\n')||LA6_0=='\r'||LA6_0==' ') ) {s = 22;}
						else if ( (LA6_0=='/') ) {s = 23;}
						else if ( ((LA6_0 >= '\u0000' && LA6_0 <= '\b')||(LA6_0 >= '\u000B' && LA6_0 <= '\f')||(LA6_0 >= '\u000E' && LA6_0 <= '\u001F')||(LA6_0 >= '!' && LA6_0 <= '\'')||(LA6_0 >= '-' && LA6_0 <= '.')||LA6_0=='<'||(LA6_0 >= '>' && LA6_0 <= '@')||(LA6_0 >= '[' && LA6_0 <= '`')||LA6_0=='|'||(LA6_0 >= '~' && LA6_0 <= '\uFFFF')) ) {s = 24;}
						if ( s>=0 ) return s;
						break;
			}
			NoViableAltException nvae =
				new NoViableAltException(getDescription(), 6, _s, input);
			error(nvae);
			throw nvae;
		}
	}

}
