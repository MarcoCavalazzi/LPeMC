// $ANTLR 3.5.2 C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\SVM.g 2016-06-14 16:36:03

import java.util.HashMap;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class SVMParser extends Parser {
	public static final String[] tokenNames = new String[] {
		"<invalid>", "<EOR>", "<DOWN>", "<UP>", "ADD", "BRANCH", "BRANCHEQ", "BRANCHGR", 
		"BRANCHLESS", "COL", "COPYFP", "DIV", "ERR", "HALT", "JS", "LABEL", "LOADFP", 
		"LOADHP", "LOADRA", "LOADRV", "LOADW", "MULT", "NUMBER", "POP", "PRINT", 
		"PUSH", "STOREFP", "STOREHP", "STORERA", "STORERV", "STOREW", "SUB", "WHITESP"
	};
	public static final int EOF=-1;
	public static final int ADD=4;
	public static final int BRANCH=5;
	public static final int BRANCHEQ=6;
	public static final int BRANCHGR=7;
	public static final int BRANCHLESS=8;
	public static final int COL=9;
	public static final int COPYFP=10;
	public static final int DIV=11;
	public static final int ERR=12;
	public static final int HALT=13;
	public static final int JS=14;
	public static final int LABEL=15;
	public static final int LOADFP=16;
	public static final int LOADHP=17;
	public static final int LOADRA=18;
	public static final int LOADRV=19;
	public static final int LOADW=20;
	public static final int MULT=21;
	public static final int NUMBER=22;
	public static final int POP=23;
	public static final int PRINT=24;
	public static final int PUSH=25;
	public static final int STOREFP=26;
	public static final int STOREHP=27;
	public static final int STORERA=28;
	public static final int STORERV=29;
	public static final int STOREW=30;
	public static final int SUB=31;
	public static final int WHITESP=32;

	// delegates
	public Parser[] getDelegates() {
		return new Parser[] {};
	}

	// delegators


	public SVMParser(TokenStream input) {
		this(input, new RecognizerSharedState());
	}
	public SVMParser(TokenStream input, RecognizerSharedState state) {
		super(input, state);
	}

	@Override public String[] getTokenNames() { return SVMParser.tokenNames; }
	@Override public String getGrammarFileName() { return "C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\SVM.g"; }


	    int[] code = new int[ExecuteVM.CODESIZE];    
	    private int i = 0;
	    private HashMap<String,Integer> labelAdd = new HashMap<String,Integer>();
	    private HashMap<Integer,String> labelRef = new HashMap<Integer,String>();     



	// $ANTLR start "assembly"
	// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\SVM.g:18:1: assembly : ( PUSH e= NUMBER | PUSH e= LABEL | POP | ADD | SUB | MULT | DIV | STOREW | LOADW |e= LABEL COL | BRANCH e= LABEL | BRANCHEQ e= LABEL | BRANCHLESS e= LABEL | JS | LOADRA | STORERA | LOADRV | STORERV | LOADFP | STOREFP | COPYFP | LOADHP | STOREHP | PRINT | HALT )* ;
	public final void assembly() throws RecognitionException {
		Token e=null;

		try {
			// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\SVM.g:18:9: ( ( PUSH e= NUMBER | PUSH e= LABEL | POP | ADD | SUB | MULT | DIV | STOREW | LOADW |e= LABEL COL | BRANCH e= LABEL | BRANCHEQ e= LABEL | BRANCHLESS e= LABEL | JS | LOADRA | STORERA | LOADRV | STORERV | LOADFP | STOREFP | COPYFP | LOADHP | STOREHP | PRINT | HALT )* )
			// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\SVM.g:19:5: ( PUSH e= NUMBER | PUSH e= LABEL | POP | ADD | SUB | MULT | DIV | STOREW | LOADW |e= LABEL COL | BRANCH e= LABEL | BRANCHEQ e= LABEL | BRANCHLESS e= LABEL | JS | LOADRA | STORERA | LOADRV | STORERV | LOADFP | STOREFP | COPYFP | LOADHP | STOREHP | PRINT | HALT )*
			{
			// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\SVM.g:19:5: ( PUSH e= NUMBER | PUSH e= LABEL | POP | ADD | SUB | MULT | DIV | STOREW | LOADW |e= LABEL COL | BRANCH e= LABEL | BRANCHEQ e= LABEL | BRANCHLESS e= LABEL | JS | LOADRA | STORERA | LOADRV | STORERV | LOADFP | STOREFP | COPYFP | LOADHP | STOREHP | PRINT | HALT )*
			loop1:
			while (true) {
				int alt1=26;
				switch ( input.LA(1) ) {
				case PUSH:
					{
					int LA1_2 = input.LA(2);
					if ( (LA1_2==NUMBER) ) {
						alt1=1;
					}
					else if ( (LA1_2==LABEL) ) {
						alt1=2;
					}

					}
					break;
				case POP:
					{
					alt1=3;
					}
					break;
				case ADD:
					{
					alt1=4;
					}
					break;
				case SUB:
					{
					alt1=5;
					}
					break;
				case MULT:
					{
					alt1=6;
					}
					break;
				case DIV:
					{
					alt1=7;
					}
					break;
				case STOREW:
					{
					alt1=8;
					}
					break;
				case LOADW:
					{
					alt1=9;
					}
					break;
				case LABEL:
					{
					alt1=10;
					}
					break;
				case BRANCH:
					{
					alt1=11;
					}
					break;
				case BRANCHEQ:
					{
					alt1=12;
					}
					break;
				case BRANCHLESS:
					{
					alt1=13;
					}
					break;
				case JS:
					{
					alt1=14;
					}
					break;
				case LOADRA:
					{
					alt1=15;
					}
					break;
				case STORERA:
					{
					alt1=16;
					}
					break;
				case LOADRV:
					{
					alt1=17;
					}
					break;
				case STORERV:
					{
					alt1=18;
					}
					break;
				case LOADFP:
					{
					alt1=19;
					}
					break;
				case STOREFP:
					{
					alt1=20;
					}
					break;
				case COPYFP:
					{
					alt1=21;
					}
					break;
				case LOADHP:
					{
					alt1=22;
					}
					break;
				case STOREHP:
					{
					alt1=23;
					}
					break;
				case PRINT:
					{
					alt1=24;
					}
					break;
				case HALT:
					{
					alt1=25;
					}
					break;
				}
				switch (alt1) {
				case 1 :
					// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\SVM.g:19:7: PUSH e= NUMBER
					{
					match(input,PUSH,FOLLOW_PUSH_in_assembly30); 
					e=(Token)match(input,NUMBER,FOLLOW_NUMBER_in_assembly34); 
					code[i++] = PUSH; 
								                 code[i++] = Integer.parseInt((e!=null?e.getText():null));
					}
					break;
				case 2 :
					// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\SVM.g:21:6: PUSH e= LABEL
					{
					match(input,PUSH,FOLLOW_PUSH_in_assembly45); 
					e=(Token)match(input,LABEL,FOLLOW_LABEL_in_assembly49); 
					code[i++] = PUSH;
						    		             labelRef.put(i++,(e!=null?e.getText():null));
					}
					break;
				case 3 :
					// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\SVM.g:23:6: POP
					{
					match(input,POP,FOLLOW_POP_in_assembly61); 
					code[i++] = POP;
					}
					break;
				case 4 :
					// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\SVM.g:24:6: ADD
					{
					match(input,ADD,FOLLOW_ADD_in_assembly76); 
					code[i++] = ADD;
					}
					break;
				case 5 :
					// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\SVM.g:25:6: SUB
					{
					match(input,SUB,FOLLOW_SUB_in_assembly90); 
					code[i++] = SUB;
					}
					break;
				case 6 :
					// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\SVM.g:26:6: MULT
					{
					match(input,MULT,FOLLOW_MULT_in_assembly104); 
					code[i++] = MULT;
					}
					break;
				case 7 :
					// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\SVM.g:27:6: DIV
					{
					match(input,DIV,FOLLOW_DIV_in_assembly117); 
					code[i++] = DIV;
					}
					break;
				case 8 :
					// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\SVM.g:28:6: STOREW
					{
					match(input,STOREW,FOLLOW_STOREW_in_assembly131); 
					code[i++] = STOREW;
					}
					break;
				case 9 :
					// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\SVM.g:29:6: LOADW
					{
					match(input,LOADW,FOLLOW_LOADW_in_assembly142); 
					code[i++] = LOADW;
					}
					break;
				case 10 :
					// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\SVM.g:30:6: e= LABEL COL
					{
					e=(Token)match(input,LABEL,FOLLOW_LABEL_in_assembly163); 
					match(input,COL,FOLLOW_COL_in_assembly165); 
					labelAdd.put((e!=null?e.getText():null),i);
					}
					break;
				case 11 :
					// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\SVM.g:31:6: BRANCH e= LABEL
					{
					match(input,BRANCH,FOLLOW_BRANCH_in_assembly178); 
					e=(Token)match(input,LABEL,FOLLOW_LABEL_in_assembly182); 
					code[i++] = BRANCH;
					                       labelRef.put(i++,(e!=null?e.getText():null));
					}
					break;
				case 12 :
					// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\SVM.g:33:6: BRANCHEQ e= LABEL
					{
					match(input,BRANCHEQ,FOLLOW_BRANCHEQ_in_assembly192); 
					e=(Token)match(input,LABEL,FOLLOW_LABEL_in_assembly196); 
					code[i++] = BRANCHEQ;
					                        labelRef.put(i++,(e!=null?e.getText():null));
					}
					break;
				case 13 :
					// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\SVM.g:35:6: BRANCHLESS e= LABEL
					{
					match(input,BRANCHLESS,FOLLOW_BRANCHLESS_in_assembly205); 
					e=(Token)match(input,LABEL,FOLLOW_LABEL_in_assembly209); 
					code[i++] = BRANCHLESS;
					                          labelRef.put(i++,(e!=null?e.getText():null));
					}
					break;
				case 14 :
					// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\SVM.g:37:6: JS
					{
					match(input,JS,FOLLOW_JS_in_assembly218); 
					code[i++] = JS;
					}
					break;
				case 15 :
					// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\SVM.g:38:6: LOADRA
					{
					match(input,LOADRA,FOLLOW_LOADRA_in_assembly240); 
					code[i++] = LOADRA;
					}
					break;
				case 16 :
					// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\SVM.g:39:6: STORERA
					{
					match(input,STORERA,FOLLOW_STORERA_in_assembly258); 
					code[i++] = STORERA;
					}
					break;
				case 17 :
					// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\SVM.g:40:6: LOADRV
					{
					match(input,LOADRV,FOLLOW_LOADRV_in_assembly275); 
					code[i++] = LOADRV;
					}
					break;
				case 18 :
					// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\SVM.g:41:6: STORERV
					{
					match(input,STORERV,FOLLOW_STORERV_in_assembly293); 
					code[i++] = STORERV;
					}
					break;
				case 19 :
					// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\SVM.g:42:6: LOADFP
					{
					match(input,LOADFP,FOLLOW_LOADFP_in_assembly310); 
					code[i++] = LOADFP;
					}
					break;
				case 20 :
					// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\SVM.g:43:6: STOREFP
					{
					match(input,STOREFP,FOLLOW_STOREFP_in_assembly328); 
					code[i++] = STOREFP;
					}
					break;
				case 21 :
					// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\SVM.g:44:6: COPYFP
					{
					match(input,COPYFP,FOLLOW_COPYFP_in_assembly345); 
					code[i++] = COPYFP;
					}
					break;
				case 22 :
					// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\SVM.g:45:6: LOADHP
					{
					match(input,LOADHP,FOLLOW_LOADHP_in_assembly363); 
					code[i++] = LOADHP;
					}
					break;
				case 23 :
					// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\SVM.g:46:6: STOREHP
					{
					match(input,STOREHP,FOLLOW_STOREHP_in_assembly381); 
					code[i++] = STOREHP;
					}
					break;
				case 24 :
					// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\SVM.g:47:6: PRINT
					{
					match(input,PRINT,FOLLOW_PRINT_in_assembly398); 
					code[i++] = PRINT;
					}
					break;
				case 25 :
					// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\SVM.g:48:6: HALT
					{
					match(input,HALT,FOLLOW_HALT_in_assembly417); 
					code[i++] = HALT;
					}
					break;

				default :
					break loop1;
				}
			}

			 
				       for (Integer refAdd: labelRef.keySet()) {
				          code[refAdd]=labelAdd.get(labelRef.get(refAdd));
					     }
					   
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "assembly"

	// Delegated rules



	public static final BitSet FOLLOW_PUSH_in_assembly30 = new BitSet(new long[]{0x0000000000400000L});
	public static final BitSet FOLLOW_NUMBER_in_assembly34 = new BitSet(new long[]{0x00000000FFBFED72L});
	public static final BitSet FOLLOW_PUSH_in_assembly45 = new BitSet(new long[]{0x0000000000008000L});
	public static final BitSet FOLLOW_LABEL_in_assembly49 = new BitSet(new long[]{0x00000000FFBFED72L});
	public static final BitSet FOLLOW_POP_in_assembly61 = new BitSet(new long[]{0x00000000FFBFED72L});
	public static final BitSet FOLLOW_ADD_in_assembly76 = new BitSet(new long[]{0x00000000FFBFED72L});
	public static final BitSet FOLLOW_SUB_in_assembly90 = new BitSet(new long[]{0x00000000FFBFED72L});
	public static final BitSet FOLLOW_MULT_in_assembly104 = new BitSet(new long[]{0x00000000FFBFED72L});
	public static final BitSet FOLLOW_DIV_in_assembly117 = new BitSet(new long[]{0x00000000FFBFED72L});
	public static final BitSet FOLLOW_STOREW_in_assembly131 = new BitSet(new long[]{0x00000000FFBFED72L});
	public static final BitSet FOLLOW_LOADW_in_assembly142 = new BitSet(new long[]{0x00000000FFBFED72L});
	public static final BitSet FOLLOW_LABEL_in_assembly163 = new BitSet(new long[]{0x0000000000000200L});
	public static final BitSet FOLLOW_COL_in_assembly165 = new BitSet(new long[]{0x00000000FFBFED72L});
	public static final BitSet FOLLOW_BRANCH_in_assembly178 = new BitSet(new long[]{0x0000000000008000L});
	public static final BitSet FOLLOW_LABEL_in_assembly182 = new BitSet(new long[]{0x00000000FFBFED72L});
	public static final BitSet FOLLOW_BRANCHEQ_in_assembly192 = new BitSet(new long[]{0x0000000000008000L});
	public static final BitSet FOLLOW_LABEL_in_assembly196 = new BitSet(new long[]{0x00000000FFBFED72L});
	public static final BitSet FOLLOW_BRANCHLESS_in_assembly205 = new BitSet(new long[]{0x0000000000008000L});
	public static final BitSet FOLLOW_LABEL_in_assembly209 = new BitSet(new long[]{0x00000000FFBFED72L});
	public static final BitSet FOLLOW_JS_in_assembly218 = new BitSet(new long[]{0x00000000FFBFED72L});
	public static final BitSet FOLLOW_LOADRA_in_assembly240 = new BitSet(new long[]{0x00000000FFBFED72L});
	public static final BitSet FOLLOW_STORERA_in_assembly258 = new BitSet(new long[]{0x00000000FFBFED72L});
	public static final BitSet FOLLOW_LOADRV_in_assembly275 = new BitSet(new long[]{0x00000000FFBFED72L});
	public static final BitSet FOLLOW_STORERV_in_assembly293 = new BitSet(new long[]{0x00000000FFBFED72L});
	public static final BitSet FOLLOW_LOADFP_in_assembly310 = new BitSet(new long[]{0x00000000FFBFED72L});
	public static final BitSet FOLLOW_STOREFP_in_assembly328 = new BitSet(new long[]{0x00000000FFBFED72L});
	public static final BitSet FOLLOW_COPYFP_in_assembly345 = new BitSet(new long[]{0x00000000FFBFED72L});
	public static final BitSet FOLLOW_LOADHP_in_assembly363 = new BitSet(new long[]{0x00000000FFBFED72L});
	public static final BitSet FOLLOW_STOREHP_in_assembly381 = new BitSet(new long[]{0x00000000FFBFED72L});
	public static final BitSet FOLLOW_PRINT_in_assembly398 = new BitSet(new long[]{0x00000000FFBFED72L});
	public static final BitSet FOLLOW_HALT_in_assembly417 = new BitSet(new long[]{0x00000000FFBFED72L});
}
