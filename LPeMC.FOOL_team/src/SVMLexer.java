// $ANTLR 3.5.2 S:\\LPeMC\\MaterialeDidattico\\Esercitazione_12_04\\FOOL\\SVM.g 2015-12-04 14:31:07

import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class SVMLexer extends Lexer {
	public static final int EOF=-1;
	public static final int ADD=4;
	public static final int BRANCH=5;
	public static final int BRANCHEQ=6;
	public static final int BRANCHLESS=7;
	public static final int COL=8;
	public static final int COPYFP=9;
	public static final int DIV=10;
	public static final int ERR=11;
	public static final int HALT=12;
	public static final int JS=13;
	public static final int LABEL=14;
	public static final int LOADFP=15;
	public static final int LOADHP=16;
	public static final int LOADRA=17;
	public static final int LOADRV=18;
	public static final int LOADW=19;
	public static final int MULT=20;
	public static final int NUMBER=21;
	public static final int POP=22;
	public static final int PRINT=23;
	public static final int PUSH=24;
	public static final int STOREFP=25;
	public static final int STOREHP=26;
	public static final int STORERA=27;
	public static final int STORERV=28;
	public static final int STOREW=29;
	public static final int SUB=30;
	public static final int WHITESP=31;

	// delegates
	// delegators
	public Lexer[] getDelegates() {
		return new Lexer[] {};
	}

	public SVMLexer() {} 
	public SVMLexer(CharStream input) {
		this(input, new RecognizerSharedState());
	}
	public SVMLexer(CharStream input, RecognizerSharedState state) {
		super(input,state);
	}
	@Override public String getGrammarFileName() { return "S:\\LPeMC\\MaterialeDidattico\\Esercitazione_12_04\\FOOL\\SVM.g"; }

	// $ANTLR start "PUSH"
	public final void mPUSH() throws RecognitionException {
		try {
			int _type = PUSH;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// S:\\LPeMC\\MaterialeDidattico\\Esercitazione_12_04\\FOOL\\SVM.g:60:9: ( 'push' )
			// S:\\LPeMC\\MaterialeDidattico\\Esercitazione_12_04\\FOOL\\SVM.g:60:11: 'push'
			{
			match("push"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "PUSH"

	// $ANTLR start "POP"
	public final void mPOP() throws RecognitionException {
		try {
			int _type = POP;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// S:\\LPeMC\\MaterialeDidattico\\Esercitazione_12_04\\FOOL\\SVM.g:61:6: ( 'pop' )
			// S:\\LPeMC\\MaterialeDidattico\\Esercitazione_12_04\\FOOL\\SVM.g:61:8: 'pop'
			{
			match("pop"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "POP"

	// $ANTLR start "ADD"
	public final void mADD() throws RecognitionException {
		try {
			int _type = ADD;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// S:\\LPeMC\\MaterialeDidattico\\Esercitazione_12_04\\FOOL\\SVM.g:62:6: ( 'add' )
			// S:\\LPeMC\\MaterialeDidattico\\Esercitazione_12_04\\FOOL\\SVM.g:62:8: 'add'
			{
			match("add"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "ADD"

	// $ANTLR start "SUB"
	public final void mSUB() throws RecognitionException {
		try {
			int _type = SUB;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// S:\\LPeMC\\MaterialeDidattico\\Esercitazione_12_04\\FOOL\\SVM.g:63:6: ( 'sub' )
			// S:\\LPeMC\\MaterialeDidattico\\Esercitazione_12_04\\FOOL\\SVM.g:63:8: 'sub'
			{
			match("sub"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "SUB"

	// $ANTLR start "MULT"
	public final void mMULT() throws RecognitionException {
		try {
			int _type = MULT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// S:\\LPeMC\\MaterialeDidattico\\Esercitazione_12_04\\FOOL\\SVM.g:64:7: ( 'mult' )
			// S:\\LPeMC\\MaterialeDidattico\\Esercitazione_12_04\\FOOL\\SVM.g:64:9: 'mult'
			{
			match("mult"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "MULT"

	// $ANTLR start "DIV"
	public final void mDIV() throws RecognitionException {
		try {
			int _type = DIV;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// S:\\LPeMC\\MaterialeDidattico\\Esercitazione_12_04\\FOOL\\SVM.g:65:6: ( 'div' )
			// S:\\LPeMC\\MaterialeDidattico\\Esercitazione_12_04\\FOOL\\SVM.g:65:8: 'div'
			{
			match("div"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "DIV"

	// $ANTLR start "STOREW"
	public final void mSTOREW() throws RecognitionException {
		try {
			int _type = STOREW;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// S:\\LPeMC\\MaterialeDidattico\\Esercitazione_12_04\\FOOL\\SVM.g:66:9: ( 'sw' )
			// S:\\LPeMC\\MaterialeDidattico\\Esercitazione_12_04\\FOOL\\SVM.g:66:11: 'sw'
			{
			match("sw"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "STOREW"

	// $ANTLR start "LOADW"
	public final void mLOADW() throws RecognitionException {
		try {
			int _type = LOADW;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// S:\\LPeMC\\MaterialeDidattico\\Esercitazione_12_04\\FOOL\\SVM.g:67:8: ( 'lw' )
			// S:\\LPeMC\\MaterialeDidattico\\Esercitazione_12_04\\FOOL\\SVM.g:67:10: 'lw'
			{
			match("lw"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "LOADW"

	// $ANTLR start "BRANCH"
	public final void mBRANCH() throws RecognitionException {
		try {
			int _type = BRANCH;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// S:\\LPeMC\\MaterialeDidattico\\Esercitazione_12_04\\FOOL\\SVM.g:68:9: ( 'b' )
			// S:\\LPeMC\\MaterialeDidattico\\Esercitazione_12_04\\FOOL\\SVM.g:68:11: 'b'
			{
			match('b'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "BRANCH"

	// $ANTLR start "BRANCHEQ"
	public final void mBRANCHEQ() throws RecognitionException {
		try {
			int _type = BRANCHEQ;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// S:\\LPeMC\\MaterialeDidattico\\Esercitazione_12_04\\FOOL\\SVM.g:69:10: ( 'beq' )
			// S:\\LPeMC\\MaterialeDidattico\\Esercitazione_12_04\\FOOL\\SVM.g:69:12: 'beq'
			{
			match("beq"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "BRANCHEQ"

	// $ANTLR start "BRANCHLESS"
	public final void mBRANCHLESS() throws RecognitionException {
		try {
			int _type = BRANCHLESS;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// S:\\LPeMC\\MaterialeDidattico\\Esercitazione_12_04\\FOOL\\SVM.g:70:11: ( 'bless' )
			// S:\\LPeMC\\MaterialeDidattico\\Esercitazione_12_04\\FOOL\\SVM.g:70:12: 'bless'
			{
			match("bless"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "BRANCHLESS"

	// $ANTLR start "JS"
	public final void mJS() throws RecognitionException {
		try {
			int _type = JS;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// S:\\LPeMC\\MaterialeDidattico\\Esercitazione_12_04\\FOOL\\SVM.g:71:5: ( 'js' )
			// S:\\LPeMC\\MaterialeDidattico\\Esercitazione_12_04\\FOOL\\SVM.g:71:7: 'js'
			{
			match("js"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "JS"

	// $ANTLR start "LOADRA"
	public final void mLOADRA() throws RecognitionException {
		try {
			int _type = LOADRA;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// S:\\LPeMC\\MaterialeDidattico\\Esercitazione_12_04\\FOOL\\SVM.g:72:9: ( 'lra' )
			// S:\\LPeMC\\MaterialeDidattico\\Esercitazione_12_04\\FOOL\\SVM.g:72:11: 'lra'
			{
			match("lra"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "LOADRA"

	// $ANTLR start "STORERA"
	public final void mSTORERA() throws RecognitionException {
		try {
			int _type = STORERA;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// S:\\LPeMC\\MaterialeDidattico\\Esercitazione_12_04\\FOOL\\SVM.g:73:10: ( 'sra' )
			// S:\\LPeMC\\MaterialeDidattico\\Esercitazione_12_04\\FOOL\\SVM.g:73:12: 'sra'
			{
			match("sra"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "STORERA"

	// $ANTLR start "LOADRV"
	public final void mLOADRV() throws RecognitionException {
		try {
			int _type = LOADRV;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// S:\\LPeMC\\MaterialeDidattico\\Esercitazione_12_04\\FOOL\\SVM.g:74:9: ( 'lrv' )
			// S:\\LPeMC\\MaterialeDidattico\\Esercitazione_12_04\\FOOL\\SVM.g:74:11: 'lrv'
			{
			match("lrv"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "LOADRV"

	// $ANTLR start "STORERV"
	public final void mSTORERV() throws RecognitionException {
		try {
			int _type = STORERV;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// S:\\LPeMC\\MaterialeDidattico\\Esercitazione_12_04\\FOOL\\SVM.g:75:10: ( 'srv' )
			// S:\\LPeMC\\MaterialeDidattico\\Esercitazione_12_04\\FOOL\\SVM.g:75:12: 'srv'
			{
			match("srv"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "STORERV"

	// $ANTLR start "LOADFP"
	public final void mLOADFP() throws RecognitionException {
		try {
			int _type = LOADFP;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// S:\\LPeMC\\MaterialeDidattico\\Esercitazione_12_04\\FOOL\\SVM.g:76:9: ( 'lfp' )
			// S:\\LPeMC\\MaterialeDidattico\\Esercitazione_12_04\\FOOL\\SVM.g:76:11: 'lfp'
			{
			match("lfp"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "LOADFP"

	// $ANTLR start "STOREFP"
	public final void mSTOREFP() throws RecognitionException {
		try {
			int _type = STOREFP;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// S:\\LPeMC\\MaterialeDidattico\\Esercitazione_12_04\\FOOL\\SVM.g:77:10: ( 'sfp' )
			// S:\\LPeMC\\MaterialeDidattico\\Esercitazione_12_04\\FOOL\\SVM.g:77:12: 'sfp'
			{
			match("sfp"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "STOREFP"

	// $ANTLR start "COPYFP"
	public final void mCOPYFP() throws RecognitionException {
		try {
			int _type = COPYFP;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// S:\\LPeMC\\MaterialeDidattico\\Esercitazione_12_04\\FOOL\\SVM.g:78:10: ( 'cfp' )
			// S:\\LPeMC\\MaterialeDidattico\\Esercitazione_12_04\\FOOL\\SVM.g:78:12: 'cfp'
			{
			match("cfp"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "COPYFP"

	// $ANTLR start "LOADHP"
	public final void mLOADHP() throws RecognitionException {
		try {
			int _type = LOADHP;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// S:\\LPeMC\\MaterialeDidattico\\Esercitazione_12_04\\FOOL\\SVM.g:79:9: ( 'lhp' )
			// S:\\LPeMC\\MaterialeDidattico\\Esercitazione_12_04\\FOOL\\SVM.g:79:11: 'lhp'
			{
			match("lhp"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "LOADHP"

	// $ANTLR start "STOREHP"
	public final void mSTOREHP() throws RecognitionException {
		try {
			int _type = STOREHP;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// S:\\LPeMC\\MaterialeDidattico\\Esercitazione_12_04\\FOOL\\SVM.g:80:10: ( 'shp' )
			// S:\\LPeMC\\MaterialeDidattico\\Esercitazione_12_04\\FOOL\\SVM.g:80:12: 'shp'
			{
			match("shp"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "STOREHP"

	// $ANTLR start "PRINT"
	public final void mPRINT() throws RecognitionException {
		try {
			int _type = PRINT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// S:\\LPeMC\\MaterialeDidattico\\Esercitazione_12_04\\FOOL\\SVM.g:81:8: ( 'print' )
			// S:\\LPeMC\\MaterialeDidattico\\Esercitazione_12_04\\FOOL\\SVM.g:81:10: 'print'
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

	// $ANTLR start "HALT"
	public final void mHALT() throws RecognitionException {
		try {
			int _type = HALT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// S:\\LPeMC\\MaterialeDidattico\\Esercitazione_12_04\\FOOL\\SVM.g:82:7: ( 'halt' )
			// S:\\LPeMC\\MaterialeDidattico\\Esercitazione_12_04\\FOOL\\SVM.g:82:9: 'halt'
			{
			match("halt"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "HALT"

	// $ANTLR start "COL"
	public final void mCOL() throws RecognitionException {
		try {
			int _type = COL;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// S:\\LPeMC\\MaterialeDidattico\\Esercitazione_12_04\\FOOL\\SVM.g:84:6: ( ':' )
			// S:\\LPeMC\\MaterialeDidattico\\Esercitazione_12_04\\FOOL\\SVM.g:84:8: ':'
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
	// $ANTLR end "COL"

	// $ANTLR start "LABEL"
	public final void mLABEL() throws RecognitionException {
		try {
			int _type = LABEL;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// S:\\LPeMC\\MaterialeDidattico\\Esercitazione_12_04\\FOOL\\SVM.g:85:8: ( ( 'a' .. 'z' | 'A' .. 'Z' ) ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' )* )
			// S:\\LPeMC\\MaterialeDidattico\\Esercitazione_12_04\\FOOL\\SVM.g:85:10: ( 'a' .. 'z' | 'A' .. 'Z' ) ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' )*
			{
			if ( (input.LA(1) >= 'A' && input.LA(1) <= 'Z')||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			// S:\\LPeMC\\MaterialeDidattico\\Esercitazione_12_04\\FOOL\\SVM.g:85:29: ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' )*
			loop1:
			while (true) {
				int alt1=2;
				int LA1_0 = input.LA(1);
				if ( ((LA1_0 >= '0' && LA1_0 <= '9')||(LA1_0 >= 'A' && LA1_0 <= 'Z')||(LA1_0 >= 'a' && LA1_0 <= 'z')) ) {
					alt1=1;
				}

				switch (alt1) {
				case 1 :
					// S:\\LPeMC\\MaterialeDidattico\\Esercitazione_12_04\\FOOL\\SVM.g:
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
					break loop1;
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
	// $ANTLR end "LABEL"

	// $ANTLR start "NUMBER"
	public final void mNUMBER() throws RecognitionException {
		try {
			int _type = NUMBER;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// S:\\LPeMC\\MaterialeDidattico\\Esercitazione_12_04\\FOOL\\SVM.g:86:9: ( '0' | ( '-' )? ( ( '1' .. '9' ) ( '0' .. '9' )* ) )
			int alt4=2;
			int LA4_0 = input.LA(1);
			if ( (LA4_0=='0') ) {
				alt4=1;
			}
			else if ( (LA4_0=='-'||(LA4_0 >= '1' && LA4_0 <= '9')) ) {
				alt4=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 4, 0, input);
				throw nvae;
			}

			switch (alt4) {
				case 1 :
					// S:\\LPeMC\\MaterialeDidattico\\Esercitazione_12_04\\FOOL\\SVM.g:86:11: '0'
					{
					match('0'); 
					}
					break;
				case 2 :
					// S:\\LPeMC\\MaterialeDidattico\\Esercitazione_12_04\\FOOL\\SVM.g:86:17: ( '-' )? ( ( '1' .. '9' ) ( '0' .. '9' )* )
					{
					// S:\\LPeMC\\MaterialeDidattico\\Esercitazione_12_04\\FOOL\\SVM.g:86:17: ( '-' )?
					int alt2=2;
					int LA2_0 = input.LA(1);
					if ( (LA2_0=='-') ) {
						alt2=1;
					}
					switch (alt2) {
						case 1 :
							// S:\\LPeMC\\MaterialeDidattico\\Esercitazione_12_04\\FOOL\\SVM.g:86:18: '-'
							{
							match('-'); 
							}
							break;

					}

					// S:\\LPeMC\\MaterialeDidattico\\Esercitazione_12_04\\FOOL\\SVM.g:86:23: ( ( '1' .. '9' ) ( '0' .. '9' )* )
					// S:\\LPeMC\\MaterialeDidattico\\Esercitazione_12_04\\FOOL\\SVM.g:86:24: ( '1' .. '9' ) ( '0' .. '9' )*
					{
					if ( (input.LA(1) >= '1' && input.LA(1) <= '9') ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					// S:\\LPeMC\\MaterialeDidattico\\Esercitazione_12_04\\FOOL\\SVM.g:86:34: ( '0' .. '9' )*
					loop3:
					while (true) {
						int alt3=2;
						int LA3_0 = input.LA(1);
						if ( ((LA3_0 >= '0' && LA3_0 <= '9')) ) {
							alt3=1;
						}

						switch (alt3) {
						case 1 :
							// S:\\LPeMC\\MaterialeDidattico\\Esercitazione_12_04\\FOOL\\SVM.g:
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
							break loop3;
						}
					}

					}

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
	// $ANTLR end "NUMBER"

	// $ANTLR start "WHITESP"
	public final void mWHITESP() throws RecognitionException {
		try {
			int _type = WHITESP;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// S:\\LPeMC\\MaterialeDidattico\\Esercitazione_12_04\\FOOL\\SVM.g:88:10: ( ( '\\t' | ' ' | '\\r' | '\\n' )+ )
			// S:\\LPeMC\\MaterialeDidattico\\Esercitazione_12_04\\FOOL\\SVM.g:88:12: ( '\\t' | ' ' | '\\r' | '\\n' )+
			{
			// S:\\LPeMC\\MaterialeDidattico\\Esercitazione_12_04\\FOOL\\SVM.g:88:12: ( '\\t' | ' ' | '\\r' | '\\n' )+
			int cnt5=0;
			loop5:
			while (true) {
				int alt5=2;
				int LA5_0 = input.LA(1);
				if ( ((LA5_0 >= '\t' && LA5_0 <= '\n')||LA5_0=='\r'||LA5_0==' ') ) {
					alt5=1;
				}

				switch (alt5) {
				case 1 :
					// S:\\LPeMC\\MaterialeDidattico\\Esercitazione_12_04\\FOOL\\SVM.g:
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
					if ( cnt5 >= 1 ) break loop5;
					EarlyExitException eee = new EarlyExitException(5, input);
					throw eee;
				}
				cnt5++;
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

	// $ANTLR start "ERR"
	public final void mERR() throws RecognitionException {
		try {
			int _type = ERR;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// S:\\LPeMC\\MaterialeDidattico\\Esercitazione_12_04\\FOOL\\SVM.g:90:9: ( . )
			// S:\\LPeMC\\MaterialeDidattico\\Esercitazione_12_04\\FOOL\\SVM.g:90:11: .
			{
			matchAny(); 
			 System.err.println("Invalid char: "+getText()); _channel=HIDDEN; 
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
		// S:\\LPeMC\\MaterialeDidattico\\Esercitazione_12_04\\FOOL\\SVM.g:1:8: ( PUSH | POP | ADD | SUB | MULT | DIV | STOREW | LOADW | BRANCH | BRANCHEQ | BRANCHLESS | JS | LOADRA | STORERA | LOADRV | STORERV | LOADFP | STOREFP | COPYFP | LOADHP | STOREHP | PRINT | HALT | COL | LABEL | NUMBER | WHITESP | ERR )
		int alt6=28;
		alt6 = dfa6.predict(input);
		switch (alt6) {
			case 1 :
				// S:\\LPeMC\\MaterialeDidattico\\Esercitazione_12_04\\FOOL\\SVM.g:1:10: PUSH
				{
				mPUSH(); 

				}
				break;
			case 2 :
				// S:\\LPeMC\\MaterialeDidattico\\Esercitazione_12_04\\FOOL\\SVM.g:1:15: POP
				{
				mPOP(); 

				}
				break;
			case 3 :
				// S:\\LPeMC\\MaterialeDidattico\\Esercitazione_12_04\\FOOL\\SVM.g:1:19: ADD
				{
				mADD(); 

				}
				break;
			case 4 :
				// S:\\LPeMC\\MaterialeDidattico\\Esercitazione_12_04\\FOOL\\SVM.g:1:23: SUB
				{
				mSUB(); 

				}
				break;
			case 5 :
				// S:\\LPeMC\\MaterialeDidattico\\Esercitazione_12_04\\FOOL\\SVM.g:1:27: MULT
				{
				mMULT(); 

				}
				break;
			case 6 :
				// S:\\LPeMC\\MaterialeDidattico\\Esercitazione_12_04\\FOOL\\SVM.g:1:32: DIV
				{
				mDIV(); 

				}
				break;
			case 7 :
				// S:\\LPeMC\\MaterialeDidattico\\Esercitazione_12_04\\FOOL\\SVM.g:1:36: STOREW
				{
				mSTOREW(); 

				}
				break;
			case 8 :
				// S:\\LPeMC\\MaterialeDidattico\\Esercitazione_12_04\\FOOL\\SVM.g:1:43: LOADW
				{
				mLOADW(); 

				}
				break;
			case 9 :
				// S:\\LPeMC\\MaterialeDidattico\\Esercitazione_12_04\\FOOL\\SVM.g:1:49: BRANCH
				{
				mBRANCH(); 

				}
				break;
			case 10 :
				// S:\\LPeMC\\MaterialeDidattico\\Esercitazione_12_04\\FOOL\\SVM.g:1:56: BRANCHEQ
				{
				mBRANCHEQ(); 

				}
				break;
			case 11 :
				// S:\\LPeMC\\MaterialeDidattico\\Esercitazione_12_04\\FOOL\\SVM.g:1:65: BRANCHLESS
				{
				mBRANCHLESS(); 

				}
				break;
			case 12 :
				// S:\\LPeMC\\MaterialeDidattico\\Esercitazione_12_04\\FOOL\\SVM.g:1:76: JS
				{
				mJS(); 

				}
				break;
			case 13 :
				// S:\\LPeMC\\MaterialeDidattico\\Esercitazione_12_04\\FOOL\\SVM.g:1:79: LOADRA
				{
				mLOADRA(); 

				}
				break;
			case 14 :
				// S:\\LPeMC\\MaterialeDidattico\\Esercitazione_12_04\\FOOL\\SVM.g:1:86: STORERA
				{
				mSTORERA(); 

				}
				break;
			case 15 :
				// S:\\LPeMC\\MaterialeDidattico\\Esercitazione_12_04\\FOOL\\SVM.g:1:94: LOADRV
				{
				mLOADRV(); 

				}
				break;
			case 16 :
				// S:\\LPeMC\\MaterialeDidattico\\Esercitazione_12_04\\FOOL\\SVM.g:1:101: STORERV
				{
				mSTORERV(); 

				}
				break;
			case 17 :
				// S:\\LPeMC\\MaterialeDidattico\\Esercitazione_12_04\\FOOL\\SVM.g:1:109: LOADFP
				{
				mLOADFP(); 

				}
				break;
			case 18 :
				// S:\\LPeMC\\MaterialeDidattico\\Esercitazione_12_04\\FOOL\\SVM.g:1:116: STOREFP
				{
				mSTOREFP(); 

				}
				break;
			case 19 :
				// S:\\LPeMC\\MaterialeDidattico\\Esercitazione_12_04\\FOOL\\SVM.g:1:124: COPYFP
				{
				mCOPYFP(); 

				}
				break;
			case 20 :
				// S:\\LPeMC\\MaterialeDidattico\\Esercitazione_12_04\\FOOL\\SVM.g:1:131: LOADHP
				{
				mLOADHP(); 

				}
				break;
			case 21 :
				// S:\\LPeMC\\MaterialeDidattico\\Esercitazione_12_04\\FOOL\\SVM.g:1:138: STOREHP
				{
				mSTOREHP(); 

				}
				break;
			case 22 :
				// S:\\LPeMC\\MaterialeDidattico\\Esercitazione_12_04\\FOOL\\SVM.g:1:146: PRINT
				{
				mPRINT(); 

				}
				break;
			case 23 :
				// S:\\LPeMC\\MaterialeDidattico\\Esercitazione_12_04\\FOOL\\SVM.g:1:152: HALT
				{
				mHALT(); 

				}
				break;
			case 24 :
				// S:\\LPeMC\\MaterialeDidattico\\Esercitazione_12_04\\FOOL\\SVM.g:1:157: COL
				{
				mCOL(); 

				}
				break;
			case 25 :
				// S:\\LPeMC\\MaterialeDidattico\\Esercitazione_12_04\\FOOL\\SVM.g:1:161: LABEL
				{
				mLABEL(); 

				}
				break;
			case 26 :
				// S:\\LPeMC\\MaterialeDidattico\\Esercitazione_12_04\\FOOL\\SVM.g:1:167: NUMBER
				{
				mNUMBER(); 

				}
				break;
			case 27 :
				// S:\\LPeMC\\MaterialeDidattico\\Esercitazione_12_04\\FOOL\\SVM.g:1:174: WHITESP
				{
				mWHITESP(); 

				}
				break;
			case 28 :
				// S:\\LPeMC\\MaterialeDidattico\\Esercitazione_12_04\\FOOL\\SVM.g:1:182: ERR
				{
				mERR(); 

				}
				break;

		}
	}


	protected DFA6 dfa6 = new DFA6(this);
	static final String DFA6_eotS =
		"\1\uffff\6\25\1\44\3\25\3\uffff\1\21\3\uffff\3\25\1\uffff\2\25\1\60\5"+
		"\25\1\67\5\25\1\uffff\1\76\2\25\3\uffff\1\25\1\102\1\25\1\104\1\105\1"+
		"\uffff\1\106\1\107\1\110\1\111\1\25\1\113\1\uffff\1\114\1\115\1\116\1"+
		"\117\1\120\1\25\1\uffff\1\122\1\25\1\124\1\uffff\1\25\6\uffff\1\126\6"+
		"\uffff\1\25\1\uffff\1\130\1\uffff\1\131\1\uffff\1\132\3\uffff";
	static final String DFA6_eofS =
		"\133\uffff";
	static final String DFA6_minS =
		"\1\0\1\157\1\144\1\146\1\165\1\151\1\146\1\60\1\163\1\146\1\141\3\uffff"+
		"\1\61\3\uffff\1\163\1\160\1\151\1\uffff\1\144\1\142\1\60\1\141\2\160\1"+
		"\154\1\166\1\60\1\141\2\160\1\161\1\145\1\uffff\1\60\1\160\1\154\3\uffff"+
		"\1\150\1\60\1\156\2\60\1\uffff\4\60\1\164\1\60\1\uffff\5\60\1\163\1\uffff"+
		"\1\60\1\164\1\60\1\uffff\1\164\6\uffff\1\60\6\uffff\1\163\1\uffff\1\60"+
		"\1\uffff\1\60\1\uffff\1\60\3\uffff";
	static final String DFA6_maxS =
		"\1\uffff\1\165\1\144\1\167\1\165\1\151\1\167\1\172\1\163\1\146\1\141\3"+
		"\uffff\1\71\3\uffff\1\163\1\160\1\151\1\uffff\1\144\1\142\1\172\1\166"+
		"\2\160\1\154\1\166\1\172\1\166\2\160\1\161\1\145\1\uffff\1\172\1\160\1"+
		"\154\3\uffff\1\150\1\172\1\156\2\172\1\uffff\4\172\1\164\1\172\1\uffff"+
		"\5\172\1\163\1\uffff\1\172\1\164\1\172\1\uffff\1\164\6\uffff\1\172\6\uffff"+
		"\1\163\1\uffff\1\172\1\uffff\1\172\1\uffff\1\172\3\uffff";
	static final String DFA6_acceptS =
		"\13\uffff\1\30\1\31\1\32\1\uffff\1\32\1\33\1\34\3\uffff\1\31\16\uffff"+
		"\1\11\3\uffff\1\30\1\32\1\33\5\uffff\1\7\6\uffff\1\10\6\uffff\1\14\3\uffff"+
		"\1\2\1\uffff\1\3\1\4\1\16\1\20\1\22\1\25\1\uffff\1\6\1\15\1\17\1\21\1"+
		"\24\1\12\1\uffff\1\23\1\uffff\1\1\1\uffff\1\5\1\uffff\1\27\1\26\1\13";
	static final String DFA6_specialS =
		"\1\0\132\uffff}>";
	static final String[] DFA6_transitionS = {
			"\11\21\2\20\2\21\1\20\22\21\1\20\14\21\1\16\2\21\1\15\11\17\1\13\6\21"+
			"\32\14\6\21\1\2\1\7\1\11\1\5\3\14\1\12\1\14\1\10\1\14\1\6\1\4\2\14\1"+
			"\1\2\14\1\3\7\14\uff85\21",
			"\1\23\2\uffff\1\24\2\uffff\1\22",
			"\1\26",
			"\1\32\1\uffff\1\33\11\uffff\1\31\2\uffff\1\27\1\uffff\1\30",
			"\1\34",
			"\1\35",
			"\1\40\1\uffff\1\41\11\uffff\1\37\4\uffff\1\36",
			"\12\25\7\uffff\32\25\6\uffff\4\25\1\42\6\25\1\43\16\25",
			"\1\45",
			"\1\46",
			"\1\47",
			"",
			"",
			"",
			"\11\51",
			"",
			"",
			"",
			"\1\53",
			"\1\54",
			"\1\55",
			"",
			"\1\56",
			"\1\57",
			"\12\25\7\uffff\32\25\6\uffff\32\25",
			"\1\61\24\uffff\1\62",
			"\1\63",
			"\1\64",
			"\1\65",
			"\1\66",
			"\12\25\7\uffff\32\25\6\uffff\32\25",
			"\1\70\24\uffff\1\71",
			"\1\72",
			"\1\73",
			"\1\74",
			"\1\75",
			"",
			"\12\25\7\uffff\32\25\6\uffff\32\25",
			"\1\77",
			"\1\100",
			"",
			"",
			"",
			"\1\101",
			"\12\25\7\uffff\32\25\6\uffff\32\25",
			"\1\103",
			"\12\25\7\uffff\32\25\6\uffff\32\25",
			"\12\25\7\uffff\32\25\6\uffff\32\25",
			"",
			"\12\25\7\uffff\32\25\6\uffff\32\25",
			"\12\25\7\uffff\32\25\6\uffff\32\25",
			"\12\25\7\uffff\32\25\6\uffff\32\25",
			"\12\25\7\uffff\32\25\6\uffff\32\25",
			"\1\112",
			"\12\25\7\uffff\32\25\6\uffff\32\25",
			"",
			"\12\25\7\uffff\32\25\6\uffff\32\25",
			"\12\25\7\uffff\32\25\6\uffff\32\25",
			"\12\25\7\uffff\32\25\6\uffff\32\25",
			"\12\25\7\uffff\32\25\6\uffff\32\25",
			"\12\25\7\uffff\32\25\6\uffff\32\25",
			"\1\121",
			"",
			"\12\25\7\uffff\32\25\6\uffff\32\25",
			"\1\123",
			"\12\25\7\uffff\32\25\6\uffff\32\25",
			"",
			"\1\125",
			"",
			"",
			"",
			"",
			"",
			"",
			"\12\25\7\uffff\32\25\6\uffff\32\25",
			"",
			"",
			"",
			"",
			"",
			"",
			"\1\127",
			"",
			"\12\25\7\uffff\32\25\6\uffff\32\25",
			"",
			"\12\25\7\uffff\32\25\6\uffff\32\25",
			"",
			"\12\25\7\uffff\32\25\6\uffff\32\25",
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
			return "1:1: Tokens : ( PUSH | POP | ADD | SUB | MULT | DIV | STOREW | LOADW | BRANCH | BRANCHEQ | BRANCHLESS | JS | LOADRA | STORERA | LOADRV | STORERV | LOADFP | STOREFP | COPYFP | LOADHP | STOREHP | PRINT | HALT | COL | LABEL | NUMBER | WHITESP | ERR );";
		}
		@Override
		public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
			IntStream input = _input;
			int _s = s;
			switch ( s ) {
					case 0 : 
						int LA6_0 = input.LA(1);
						s = -1;
						if ( (LA6_0=='p') ) {s = 1;}
						else if ( (LA6_0=='a') ) {s = 2;}
						else if ( (LA6_0=='s') ) {s = 3;}
						else if ( (LA6_0=='m') ) {s = 4;}
						else if ( (LA6_0=='d') ) {s = 5;}
						else if ( (LA6_0=='l') ) {s = 6;}
						else if ( (LA6_0=='b') ) {s = 7;}
						else if ( (LA6_0=='j') ) {s = 8;}
						else if ( (LA6_0=='c') ) {s = 9;}
						else if ( (LA6_0=='h') ) {s = 10;}
						else if ( (LA6_0==':') ) {s = 11;}
						else if ( ((LA6_0 >= 'A' && LA6_0 <= 'Z')||(LA6_0 >= 'e' && LA6_0 <= 'g')||LA6_0=='i'||LA6_0=='k'||(LA6_0 >= 'n' && LA6_0 <= 'o')||(LA6_0 >= 'q' && LA6_0 <= 'r')||(LA6_0 >= 't' && LA6_0 <= 'z')) ) {s = 12;}
						else if ( (LA6_0=='0') ) {s = 13;}
						else if ( (LA6_0=='-') ) {s = 14;}
						else if ( ((LA6_0 >= '1' && LA6_0 <= '9')) ) {s = 15;}
						else if ( ((LA6_0 >= '\t' && LA6_0 <= '\n')||LA6_0=='\r'||LA6_0==' ') ) {s = 16;}
						else if ( ((LA6_0 >= '\u0000' && LA6_0 <= '\b')||(LA6_0 >= '\u000B' && LA6_0 <= '\f')||(LA6_0 >= '\u000E' && LA6_0 <= '\u001F')||(LA6_0 >= '!' && LA6_0 <= ',')||(LA6_0 >= '.' && LA6_0 <= '/')||(LA6_0 >= ';' && LA6_0 <= '@')||(LA6_0 >= '[' && LA6_0 <= '`')||(LA6_0 >= '{' && LA6_0 <= '\uFFFF')) ) {s = 17;}
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
