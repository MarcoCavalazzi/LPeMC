// $ANTLR 3.5.2 C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g 2016-06-27 18:38:30

import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class FOOLLexer extends Lexer {
	public static final int EOF=-1;
	public static final int AND=4;
	public static final int ARROW=5;
	public static final int ASS=6;
	public static final int BOOL=7;
	public static final int CLASS=8;
	public static final int CLPAR=9;
	public static final int COLON=10;
	public static final int COMMA=11;
	public static final int CRPAR=12;
	public static final int DIV=13;
	public static final int DOT=14;
	public static final int ELSE=15;
	public static final int EQ=16;
	public static final int ERR=17;
	public static final int EXTENDS=18;
	public static final int FALSE=19;
	public static final int FUN=20;
	public static final int GR=21;
	public static final int ID=22;
	public static final int IF=23;
	public static final int IN=24;
	public static final int INT=25;
	public static final int INTEGER=26;
	public static final int LE=27;
	public static final int LET=28;
	public static final int LPAR=29;
	public static final int MINUS=30;
	public static final int MULT=31;
	public static final int NEW=32;
	public static final int NOT=33;
	public static final int NULL=34;
	public static final int OR=35;
	public static final int PLUS=36;
	public static final int PRINT=37;
	public static final int RPAR=38;
	public static final int SEMIC=39;
	public static final int THEN=40;
	public static final int TRUE=41;
	public static final int VAR=42;
	public static final int WHITESP=43;

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
	@Override public String getGrammarFileName() { return "C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g"; }

	// $ANTLR start "PLUS"
	public final void mPLUS() throws RecognitionException {
		try {
			int _type = PLUS;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:636:9: ( '+' )
			// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:636:11: '+'
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

	// $ANTLR start "MINUS"
	public final void mMINUS() throws RecognitionException {
		try {
			int _type = MINUS;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:637:9: ( '-' )
			// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:637:11: '-'
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
	// $ANTLR end "MINUS"

	// $ANTLR start "MULT"
	public final void mMULT() throws RecognitionException {
		try {
			int _type = MULT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:638:9: ( '*' )
			// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:638:11: '*'
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
	// $ANTLR end "MULT"

	// $ANTLR start "DIV"
	public final void mDIV() throws RecognitionException {
		try {
			int _type = DIV;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:639:9: ( '/' )
			// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:639:11: '/'
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
	// $ANTLR end "DIV"

	// $ANTLR start "LPAR"
	public final void mLPAR() throws RecognitionException {
		try {
			int _type = LPAR;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:640:9: ( '(' )
			// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:640:11: '('
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
			// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:641:9: ( ')' )
			// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:641:11: ')'
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
			// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:642:9: ( '{' )
			// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:642:11: '{'
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
			// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:643:9: ( '}' )
			// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:643:11: '}'
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

	// $ANTLR start "SEMIC"
	public final void mSEMIC() throws RecognitionException {
		try {
			int _type = SEMIC;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:644:9: ( ';' )
			// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:644:11: ';'
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
			// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:645:9: ( ':' )
			// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:645:11: ':'
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
			// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:646:9: ( ',' )
			// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:646:11: ','
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

	// $ANTLR start "DOT"
	public final void mDOT() throws RecognitionException {
		try {
			int _type = DOT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:647:5: ( '.' )
			// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:647:7: '.'
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
	// $ANTLR end "DOT"

	// $ANTLR start "OR"
	public final void mOR() throws RecognitionException {
		try {
			int _type = OR;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:648:5: ( '||' )
			// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:648:7: '||'
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
	// $ANTLR end "OR"

	// $ANTLR start "AND"
	public final void mAND() throws RecognitionException {
		try {
			int _type = AND;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:649:5: ( '&&' )
			// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:649:7: '&&'
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
	// $ANTLR end "AND"

	// $ANTLR start "NOT"
	public final void mNOT() throws RecognitionException {
		try {
			int _type = NOT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:650:5: ( 'not' )
			// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:650:7: 'not'
			{
			match("not"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "NOT"

	// $ANTLR start "GR"
	public final void mGR() throws RecognitionException {
		try {
			int _type = GR;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:651:5: ( '>=' )
			// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:651:7: '>='
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
	// $ANTLR end "GR"

	// $ANTLR start "LE"
	public final void mLE() throws RecognitionException {
		try {
			int _type = LE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:652:5: ( '<=' )
			// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:652:7: '<='
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
	// $ANTLR end "LE"

	// $ANTLR start "EQ"
	public final void mEQ() throws RecognitionException {
		try {
			int _type = EQ;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:653:5: ( '==' )
			// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:653:7: '=='
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
			// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:654:5: ( '=' )
			// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:654:7: '='
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

	// $ANTLR start "TRUE"
	public final void mTRUE() throws RecognitionException {
		try {
			int _type = TRUE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:655:7: ( 'true' )
			// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:655:9: 'true'
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
			// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:656:7: ( 'false' )
			// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:656:9: 'false'
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

	// $ANTLR start "IF"
	public final void mIF() throws RecognitionException {
		try {
			int _type = IF;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:657:7: ( 'if' )
			// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:657:9: 'if'
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
			// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:658:7: ( 'then' )
			// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:658:9: 'then'
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
			// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:659:7: ( 'else' )
			// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:659:9: 'else'
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
			// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:660:7: ( 'print' )
			// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:660:9: 'print'
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
			// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:661:7: ( 'let' )
			// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:661:9: 'let'
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
			// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:662:7: ( 'in' )
			// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:662:9: 'in'
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
			// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:663:7: ( 'var' )
			// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:663:9: 'var'
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
			// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:664:7: ( 'fun' )
			// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:664:9: 'fun'
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

	// $ANTLR start "CLASS"
	public final void mCLASS() throws RecognitionException {
		try {
			int _type = CLASS;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:665:7: ( 'class' )
			// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:665:9: 'class'
			{
			match("class"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "CLASS"

	// $ANTLR start "EXTENDS"
	public final void mEXTENDS() throws RecognitionException {
		try {
			int _type = EXTENDS;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:666:9: ( 'extends' )
			// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:666:11: 'extends'
			{
			match("extends"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "EXTENDS"

	// $ANTLR start "NEW"
	public final void mNEW() throws RecognitionException {
		try {
			int _type = NEW;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:667:7: ( 'new' )
			// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:667:9: 'new'
			{
			match("new"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "NEW"

	// $ANTLR start "NULL"
	public final void mNULL() throws RecognitionException {
		try {
			int _type = NULL;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:668:7: ( 'null' )
			// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:668:9: 'null'
			{
			match("null"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "NULL"

	// $ANTLR start "INT"
	public final void mINT() throws RecognitionException {
		try {
			int _type = INT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:669:7: ( 'int' )
			// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:669:9: 'int'
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
			// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:670:7: ( 'bool' )
			// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:670:9: 'bool'
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

	// $ANTLR start "ARROW"
	public final void mARROW() throws RecognitionException {
		try {
			int _type = ARROW;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:671:7: ( '->' )
			// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:671:9: '->'
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
	// $ANTLR end "ARROW"

	// $ANTLR start "INTEGER"
	public final void mINTEGER() throws RecognitionException {
		try {
			int _type = INTEGER;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:672:9: ( ( ( '-' )? ( '1' .. '9' ) ( '0' .. '9' )* ) | '0' )
			int alt3=2;
			int LA3_0 = input.LA(1);
			if ( (LA3_0=='-'||(LA3_0 >= '1' && LA3_0 <= '9')) ) {
				alt3=1;
			}
			else if ( (LA3_0=='0') ) {
				alt3=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 3, 0, input);
				throw nvae;
			}

			switch (alt3) {
				case 1 :
					// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:672:11: ( ( '-' )? ( '1' .. '9' ) ( '0' .. '9' )* )
					{
					// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:672:11: ( ( '-' )? ( '1' .. '9' ) ( '0' .. '9' )* )
					// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:672:12: ( '-' )? ( '1' .. '9' ) ( '0' .. '9' )*
					{
					// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:672:12: ( '-' )?
					int alt1=2;
					int LA1_0 = input.LA(1);
					if ( (LA1_0=='-') ) {
						alt1=1;
					}
					switch (alt1) {
						case 1 :
							// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:672:13: '-'
							{
							match('-'); 
							}
							break;

					}

					if ( (input.LA(1) >= '1' && input.LA(1) <= '9') ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:672:28: ( '0' .. '9' )*
					loop2:
					while (true) {
						int alt2=2;
						int LA2_0 = input.LA(1);
						if ( ((LA2_0 >= '0' && LA2_0 <= '9')) ) {
							alt2=1;
						}

						switch (alt2) {
						case 1 :
							// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:
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
							break loop2;
						}
					}

					}

					}
					break;
				case 2 :
					// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:672:43: '0'
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
	// $ANTLR end "INTEGER"

	// $ANTLR start "ID"
	public final void mID() throws RecognitionException {
		try {
			int _type = ID;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:673:9: ( ( 'a' .. 'z' | 'A' .. 'Z' ) ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' )* )
			// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:673:11: ( 'a' .. 'z' | 'A' .. 'Z' ) ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' )*
			{
			if ( (input.LA(1) >= 'A' && input.LA(1) <= 'Z')||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:673:30: ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' )*
			loop4:
			while (true) {
				int alt4=2;
				int LA4_0 = input.LA(1);
				if ( ((LA4_0 >= '0' && LA4_0 <= '9')||(LA4_0 >= 'A' && LA4_0 <= 'Z')||(LA4_0 >= 'a' && LA4_0 <= 'z')) ) {
					alt4=1;
				}

				switch (alt4) {
				case 1 :
					// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:
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
					break loop4;
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
			// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:674:9: ( ( '\\t' | ' ' | '\\r' | '\\n' )+ )
			// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:674:11: ( '\\t' | ' ' | '\\r' | '\\n' )+
			{
			// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:674:11: ( '\\t' | ' ' | '\\r' | '\\n' )+
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
					// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:
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
			// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:676:9: ( . )
			// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:676:11: .
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
		// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:1:8: ( PLUS | MINUS | MULT | DIV | LPAR | RPAR | CLPAR | CRPAR | SEMIC | COLON | COMMA | DOT | OR | AND | NOT | GR | LE | EQ | ASS | TRUE | FALSE | IF | THEN | ELSE | PRINT | LET | IN | VAR | FUN | CLASS | EXTENDS | NEW | NULL | INT | BOOL | ARROW | INTEGER | ID | WHITESP | ERR )
		int alt6=40;
		alt6 = dfa6.predict(input);
		switch (alt6) {
			case 1 :
				// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:1:10: PLUS
				{
				mPLUS(); 

				}
				break;
			case 2 :
				// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:1:15: MINUS
				{
				mMINUS(); 

				}
				break;
			case 3 :
				// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:1:21: MULT
				{
				mMULT(); 

				}
				break;
			case 4 :
				// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:1:26: DIV
				{
				mDIV(); 

				}
				break;
			case 5 :
				// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:1:30: LPAR
				{
				mLPAR(); 

				}
				break;
			case 6 :
				// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:1:35: RPAR
				{
				mRPAR(); 

				}
				break;
			case 7 :
				// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:1:40: CLPAR
				{
				mCLPAR(); 

				}
				break;
			case 8 :
				// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:1:46: CRPAR
				{
				mCRPAR(); 

				}
				break;
			case 9 :
				// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:1:52: SEMIC
				{
				mSEMIC(); 

				}
				break;
			case 10 :
				// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:1:58: COLON
				{
				mCOLON(); 

				}
				break;
			case 11 :
				// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:1:64: COMMA
				{
				mCOMMA(); 

				}
				break;
			case 12 :
				// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:1:70: DOT
				{
				mDOT(); 

				}
				break;
			case 13 :
				// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:1:74: OR
				{
				mOR(); 

				}
				break;
			case 14 :
				// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:1:77: AND
				{
				mAND(); 

				}
				break;
			case 15 :
				// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:1:81: NOT
				{
				mNOT(); 

				}
				break;
			case 16 :
				// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:1:85: GR
				{
				mGR(); 

				}
				break;
			case 17 :
				// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:1:88: LE
				{
				mLE(); 

				}
				break;
			case 18 :
				// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:1:91: EQ
				{
				mEQ(); 

				}
				break;
			case 19 :
				// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:1:94: ASS
				{
				mASS(); 

				}
				break;
			case 20 :
				// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:1:98: TRUE
				{
				mTRUE(); 

				}
				break;
			case 21 :
				// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:1:103: FALSE
				{
				mFALSE(); 

				}
				break;
			case 22 :
				// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:1:109: IF
				{
				mIF(); 

				}
				break;
			case 23 :
				// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:1:112: THEN
				{
				mTHEN(); 

				}
				break;
			case 24 :
				// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:1:117: ELSE
				{
				mELSE(); 

				}
				break;
			case 25 :
				// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:1:122: PRINT
				{
				mPRINT(); 

				}
				break;
			case 26 :
				// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:1:128: LET
				{
				mLET(); 

				}
				break;
			case 27 :
				// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:1:132: IN
				{
				mIN(); 

				}
				break;
			case 28 :
				// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:1:135: VAR
				{
				mVAR(); 

				}
				break;
			case 29 :
				// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:1:139: FUN
				{
				mFUN(); 

				}
				break;
			case 30 :
				// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:1:143: CLASS
				{
				mCLASS(); 

				}
				break;
			case 31 :
				// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:1:149: EXTENDS
				{
				mEXTENDS(); 

				}
				break;
			case 32 :
				// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:1:157: NEW
				{
				mNEW(); 

				}
				break;
			case 33 :
				// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:1:161: NULL
				{
				mNULL(); 

				}
				break;
			case 34 :
				// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:1:166: INT
				{
				mINT(); 

				}
				break;
			case 35 :
				// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:1:170: BOOL
				{
				mBOOL(); 

				}
				break;
			case 36 :
				// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:1:175: ARROW
				{
				mARROW(); 

				}
				break;
			case 37 :
				// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:1:181: INTEGER
				{
				mINTEGER(); 

				}
				break;
			case 38 :
				// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:1:189: ID
				{
				mID(); 

				}
				break;
			case 39 :
				// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:1:192: WHITESP
				{
				mWHITESP(); 

				}
				break;
			case 40 :
				// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:1:200: ERR
				{
				mERR(); 

				}
				break;

		}
	}


	protected DFA6 dfa6 = new DFA6(this);
	static final String DFA6_eotS =
		"\2\uffff\1\43\12\uffff\2\40\1\64\2\40\1\70\11\64\25\uffff\3\64\5\uffff"+
		"\4\64\1\116\1\120\7\64\1\uffff\1\130\1\131\4\64\1\136\1\uffff\1\137\1"+
		"\uffff\3\64\1\143\1\144\2\64\2\uffff\1\147\1\150\1\151\1\64\2\uffff\1"+
		"\153\2\64\2\uffff\1\64\1\157\3\uffff\1\160\1\uffff\1\64\1\162\1\163\2"+
		"\uffff\1\64\2\uffff\1\165\1\uffff";
	static final String DFA6_eofS =
		"\166\uffff";
	static final String DFA6_minS =
		"\1\0\1\uffff\1\61\12\uffff\1\174\1\46\1\145\3\75\1\150\1\141\1\146\1\154"+
		"\1\162\1\145\1\141\1\154\1\157\25\uffff\1\164\1\167\1\154\5\uffff\1\165"+
		"\1\145\1\154\1\156\2\60\1\163\1\164\1\151\1\164\1\162\1\141\1\157\1\uffff"+
		"\2\60\1\154\1\145\1\156\1\163\1\60\1\uffff\1\60\1\uffff\2\145\1\156\2"+
		"\60\1\163\1\154\2\uffff\3\60\1\145\2\uffff\1\60\1\156\1\164\2\uffff\1"+
		"\163\1\60\3\uffff\1\60\1\uffff\1\144\2\60\2\uffff\1\163\2\uffff\1\60\1"+
		"\uffff";
	static final String DFA6_maxS =
		"\1\uffff\1\uffff\1\76\12\uffff\1\174\1\46\1\165\3\75\1\162\1\165\1\156"+
		"\1\170\1\162\1\145\1\141\1\154\1\157\25\uffff\1\164\1\167\1\154\5\uffff"+
		"\1\165\1\145\1\154\1\156\2\172\1\163\1\164\1\151\1\164\1\162\1\141\1\157"+
		"\1\uffff\2\172\1\154\1\145\1\156\1\163\1\172\1\uffff\1\172\1\uffff\2\145"+
		"\1\156\2\172\1\163\1\154\2\uffff\3\172\1\145\2\uffff\1\172\1\156\1\164"+
		"\2\uffff\1\163\1\172\3\uffff\1\172\1\uffff\1\144\2\172\2\uffff\1\163\2"+
		"\uffff\1\172\1\uffff";
	static final String DFA6_acceptS =
		"\1\uffff\1\1\1\uffff\1\3\1\4\1\5\1\6\1\7\1\10\1\11\1\12\1\13\1\14\17\uffff"+
		"\2\45\1\46\1\47\1\50\1\1\1\44\1\2\1\45\1\3\1\4\1\5\1\6\1\7\1\10\1\11\1"+
		"\12\1\13\1\14\1\15\1\16\3\uffff\1\46\1\20\1\21\1\22\1\23\15\uffff\1\47"+
		"\7\uffff\1\26\1\uffff\1\33\7\uffff\1\17\1\40\4\uffff\1\35\1\42\3\uffff"+
		"\1\32\1\34\2\uffff\1\41\1\24\1\27\1\uffff\1\30\3\uffff\1\43\1\25\1\uffff"+
		"\1\31\1\36\1\uffff\1\37";
	static final String DFA6_specialS =
		"\1\0\165\uffff}>";
	static final String[] DFA6_transitionS = {
			"\11\40\2\37\2\40\1\37\22\40\1\37\5\40\1\16\1\40\1\5\1\6\1\3\1\1\1\13"+
			"\1\2\1\14\1\4\1\35\11\34\1\12\1\11\1\21\1\22\1\20\2\40\32\36\6\40\1\36"+
			"\1\33\1\32\1\36\1\26\1\24\2\36\1\25\2\36\1\30\1\36\1\17\1\36\1\27\3\36"+
			"\1\23\1\36\1\31\4\36\1\7\1\15\1\10\uff82\40",
			"",
			"\11\44\4\uffff\1\42",
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
			"\1\57",
			"\1\60",
			"\1\62\11\uffff\1\61\5\uffff\1\63",
			"\1\65",
			"\1\66",
			"\1\67",
			"\1\72\11\uffff\1\71",
			"\1\73\23\uffff\1\74",
			"\1\75\7\uffff\1\76",
			"\1\77\13\uffff\1\100",
			"\1\101",
			"\1\102",
			"\1\103",
			"\1\104",
			"\1\105",
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
			"\1\107",
			"\1\110",
			"\1\111",
			"",
			"",
			"",
			"",
			"",
			"\1\112",
			"\1\113",
			"\1\114",
			"\1\115",
			"\12\64\7\uffff\32\64\6\uffff\32\64",
			"\12\64\7\uffff\32\64\6\uffff\23\64\1\117\6\64",
			"\1\121",
			"\1\122",
			"\1\123",
			"\1\124",
			"\1\125",
			"\1\126",
			"\1\127",
			"",
			"\12\64\7\uffff\32\64\6\uffff\32\64",
			"\12\64\7\uffff\32\64\6\uffff\32\64",
			"\1\132",
			"\1\133",
			"\1\134",
			"\1\135",
			"\12\64\7\uffff\32\64\6\uffff\32\64",
			"",
			"\12\64\7\uffff\32\64\6\uffff\32\64",
			"",
			"\1\140",
			"\1\141",
			"\1\142",
			"\12\64\7\uffff\32\64\6\uffff\32\64",
			"\12\64\7\uffff\32\64\6\uffff\32\64",
			"\1\145",
			"\1\146",
			"",
			"",
			"\12\64\7\uffff\32\64\6\uffff\32\64",
			"\12\64\7\uffff\32\64\6\uffff\32\64",
			"\12\64\7\uffff\32\64\6\uffff\32\64",
			"\1\152",
			"",
			"",
			"\12\64\7\uffff\32\64\6\uffff\32\64",
			"\1\154",
			"\1\155",
			"",
			"",
			"\1\156",
			"\12\64\7\uffff\32\64\6\uffff\32\64",
			"",
			"",
			"",
			"\12\64\7\uffff\32\64\6\uffff\32\64",
			"",
			"\1\161",
			"\12\64\7\uffff\32\64\6\uffff\32\64",
			"\12\64\7\uffff\32\64\6\uffff\32\64",
			"",
			"",
			"\1\164",
			"",
			"",
			"\12\64\7\uffff\32\64\6\uffff\32\64",
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
			return "1:1: Tokens : ( PLUS | MINUS | MULT | DIV | LPAR | RPAR | CLPAR | CRPAR | SEMIC | COLON | COMMA | DOT | OR | AND | NOT | GR | LE | EQ | ASS | TRUE | FALSE | IF | THEN | ELSE | PRINT | LET | IN | VAR | FUN | CLASS | EXTENDS | NEW | NULL | INT | BOOL | ARROW | INTEGER | ID | WHITESP | ERR );";
		}
		@Override
		public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
			IntStream input = _input;
			int _s = s;
			switch ( s ) {
					case 0 : 
						int LA6_0 = input.LA(1);
						s = -1;
						if ( (LA6_0=='+') ) {s = 1;}
						else if ( (LA6_0=='-') ) {s = 2;}
						else if ( (LA6_0=='*') ) {s = 3;}
						else if ( (LA6_0=='/') ) {s = 4;}
						else if ( (LA6_0=='(') ) {s = 5;}
						else if ( (LA6_0==')') ) {s = 6;}
						else if ( (LA6_0=='{') ) {s = 7;}
						else if ( (LA6_0=='}') ) {s = 8;}
						else if ( (LA6_0==';') ) {s = 9;}
						else if ( (LA6_0==':') ) {s = 10;}
						else if ( (LA6_0==',') ) {s = 11;}
						else if ( (LA6_0=='.') ) {s = 12;}
						else if ( (LA6_0=='|') ) {s = 13;}
						else if ( (LA6_0=='&') ) {s = 14;}
						else if ( (LA6_0=='n') ) {s = 15;}
						else if ( (LA6_0=='>') ) {s = 16;}
						else if ( (LA6_0=='<') ) {s = 17;}
						else if ( (LA6_0=='=') ) {s = 18;}
						else if ( (LA6_0=='t') ) {s = 19;}
						else if ( (LA6_0=='f') ) {s = 20;}
						else if ( (LA6_0=='i') ) {s = 21;}
						else if ( (LA6_0=='e') ) {s = 22;}
						else if ( (LA6_0=='p') ) {s = 23;}
						else if ( (LA6_0=='l') ) {s = 24;}
						else if ( (LA6_0=='v') ) {s = 25;}
						else if ( (LA6_0=='c') ) {s = 26;}
						else if ( (LA6_0=='b') ) {s = 27;}
						else if ( ((LA6_0 >= '1' && LA6_0 <= '9')) ) {s = 28;}
						else if ( (LA6_0=='0') ) {s = 29;}
						else if ( ((LA6_0 >= 'A' && LA6_0 <= 'Z')||LA6_0=='a'||LA6_0=='d'||(LA6_0 >= 'g' && LA6_0 <= 'h')||(LA6_0 >= 'j' && LA6_0 <= 'k')||LA6_0=='m'||LA6_0=='o'||(LA6_0 >= 'q' && LA6_0 <= 's')||LA6_0=='u'||(LA6_0 >= 'w' && LA6_0 <= 'z')) ) {s = 30;}
						else if ( ((LA6_0 >= '\t' && LA6_0 <= '\n')||LA6_0=='\r'||LA6_0==' ') ) {s = 31;}
						else if ( ((LA6_0 >= '\u0000' && LA6_0 <= '\b')||(LA6_0 >= '\u000B' && LA6_0 <= '\f')||(LA6_0 >= '\u000E' && LA6_0 <= '\u001F')||(LA6_0 >= '!' && LA6_0 <= '%')||LA6_0=='\''||(LA6_0 >= '?' && LA6_0 <= '@')||(LA6_0 >= '[' && LA6_0 <= '`')||(LA6_0 >= '~' && LA6_0 <= '\uFFFF')) ) {s = 32;}
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
