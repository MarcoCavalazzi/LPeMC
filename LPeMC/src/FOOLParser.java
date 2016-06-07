// $ANTLR 3.5.2 C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g 2016-06-07 22:04:39

	import java.util.ArrayList;
	import java.util.HashMap;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class FOOLParser extends Parser {
	public static final String[] tokenNames = new String[] {
		"<invalid>", "<EOR>", "<DOWN>", "<UP>", "AND", "ARROW", "ASS", "BOOL", 
		"CLASS", "CLPAR", "COLON", "COMMA", "CRPAR", "DIV", "DOT", "ELSE", "EQ", 
		"ERR", "EXTENDS", "FALSE", "FUN", "GR", "ID", "IF", "IN", "INT", "INTEGER", 
		"LE", "LET", "LPAR", "MINUS", "MULT", "NEW", "NOT", "NULL", "OR", "PLUS", 
		"PRINT", "RPAR", "SEMIC", "THEN", "TRUE", "VAR", "WHITESP"
	};
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

	// delegates
	public Parser[] getDelegates() {
		return new Parser[] {};
	}

	// delegators


	public FOOLParser(TokenStream input) {
		this(input, new RecognizerSharedState());
	}
	public FOOLParser(TokenStream input, RecognizerSharedState state) {
		super(input, state);
	}

	@Override public String[] getTokenNames() { return FOOLParser.tokenNames; }
	@Override public String getGrammarFileName() { return "C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g"; }


		private ArrayList<HashMap<String,STentry>>  symTable = new ArrayList<HashMap<String,STentry>>();
		private HashMap<String,CTentry> classTable = new HashMap<String,CTentry>();
		private int nestingLevel = -1;
		//livello ambiente con dichiarazioni piu' esterno è 0 (prima posizione ArrayList) invece che 1 (slides)
		//il "fronte" della lista di tabelle symTable.get(nestingLevel)



	// $ANTLR start "prog"
	// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:24:1: prog returns [Node ast] : (e= exp SEMIC | LET cl= cllist d= declist IN e= exp SEMIC );
	public final Node prog() throws RecognitionException {
		Node ast = null;


		Node e =null;
		ArrayList<Node> cl =null;
		ArrayList<Node> d =null;

		try {
			// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:25:3: (e= exp SEMIC | LET cl= cllist d= declist IN e= exp SEMIC )
			int alt1=2;
			int LA1_0 = input.LA(1);
			if ( (LA1_0==FALSE||(LA1_0 >= ID && LA1_0 <= IF)||LA1_0==INTEGER||LA1_0==LPAR||(LA1_0 >= NEW && LA1_0 <= NULL)||LA1_0==PRINT||LA1_0==TRUE) ) {
				alt1=1;
			}
			else if ( (LA1_0==LET) ) {
				alt1=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 1, 0, input);
				throw nvae;
			}

			switch (alt1) {
				case 1 :
					// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:25:5: e= exp SEMIC
					{
					pushFollow(FOLLOW_exp_in_prog41);
					e=exp();
					state._fsp--;

					match(input,SEMIC,FOLLOW_SEMIC_in_prog43); 
					ast = new ProgNode(e);
					}
					break;
				case 2 :
					// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:26:11: LET cl= cllist d= declist IN e= exp SEMIC
					{
					match(input,LET,FOLLOW_LET_in_prog57); 

					              nestingLevel++;
					              HashMap<String,STentry> hm = new HashMap<String,STentry> ();
					              symTable.add(hm);
					            
					pushFollow(FOLLOW_cllist_in_prog85);
					cl=cllist();
					state._fsp--;

					pushFollow(FOLLOW_declist_in_prog90);
					d=declist();
					state._fsp--;

					match(input,IN,FOLLOW_IN_in_prog92); 
					pushFollow(FOLLOW_exp_in_prog96);
					e=exp();
					state._fsp--;

					match(input,SEMIC,FOLLOW_SEMIC_in_prog98); 

					              symTable.remove(nestingLevel--);
					              ast = new LetInNode(d,cl,e) ;
					            
					}
					break;

			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return ast;
	}
	// $ANTLR end "prog"



	// $ANTLR start "cllist"
	// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:40:1: cllist returns [ArrayList<Node> astlist] : ( CLASS cid= ID ( EXTENDS cidext= ID )? LPAR (p1= ID COLON t1= basic ( COMMA pn= ID COLON tn= basic )* )? RPAR CLPAR ( FUN mid= ID COLON retm= basic LPAR (mp1= ID COLON mpt1= type ( COMMA mpn= ID COLON mptn= type )* )? RPAR ( LET ( VAR vid= ID COLON vt= type ASS ve= exp SEMIC )* IN )? varE= exp SEMIC )* CRPAR )* ;
	public final ArrayList<Node> cllist() throws RecognitionException {
		ArrayList<Node> astlist = null;


		Token cid=null;
		Token cidext=null;
		Token p1=null;
		Token pn=null;
		Token mid=null;
		Token mp1=null;
		Token mpn=null;
		Token vid=null;
		Node t1 =null;
		Node tn =null;
		Node retm =null;
		Node mpt1 =null;
		Node mptn =null;
		Node vt =null;
		Node ve =null;
		Node varE =null;

		try {
			// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:41:4: ( ( CLASS cid= ID ( EXTENDS cidext= ID )? LPAR (p1= ID COLON t1= basic ( COMMA pn= ID COLON tn= basic )* )? RPAR CLPAR ( FUN mid= ID COLON retm= basic LPAR (mp1= ID COLON mpt1= type ( COMMA mpn= ID COLON mptn= type )* )? RPAR ( LET ( VAR vid= ID COLON vt= type ASS ve= exp SEMIC )* IN )? varE= exp SEMIC )* CRPAR )* )
			// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:41:6: ( CLASS cid= ID ( EXTENDS cidext= ID )? LPAR (p1= ID COLON t1= basic ( COMMA pn= ID COLON tn= basic )* )? RPAR CLPAR ( FUN mid= ID COLON retm= basic LPAR (mp1= ID COLON mpt1= type ( COMMA mpn= ID COLON mptn= type )* )? RPAR ( LET ( VAR vid= ID COLON vt= type ASS ve= exp SEMIC )* IN )? varE= exp SEMIC )* CRPAR )*
			{
			 
				     astlist = new ArrayList<Node>() ;
				     int offset      = -2;
				     int classoffset = -2;	     
				     //int methodOffset = 0;
				   
			// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:47:5: ( CLASS cid= ID ( EXTENDS cidext= ID )? LPAR (p1= ID COLON t1= basic ( COMMA pn= ID COLON tn= basic )* )? RPAR CLPAR ( FUN mid= ID COLON retm= basic LPAR (mp1= ID COLON mpt1= type ( COMMA mpn= ID COLON mptn= type )* )? RPAR ( LET ( VAR vid= ID COLON vt= type ASS ve= exp SEMIC )* IN )? varE= exp SEMIC )* CRPAR )*
			loop10:
			while (true) {
				int alt10=2;
				int LA10_0 = input.LA(1);
				if ( (LA10_0==CLASS) ) {
					alt10=1;
				}

				switch (alt10) {
				case 1 :
					// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:47:6: CLASS cid= ID ( EXTENDS cidext= ID )? LPAR (p1= ID COLON t1= basic ( COMMA pn= ID COLON tn= basic )* )? RPAR CLPAR ( FUN mid= ID COLON retm= basic LPAR (mp1= ID COLON mpt1= type ( COMMA mpn= ID COLON mptn= type )* )? RPAR ( LET ( VAR vid= ID COLON vt= type ASS ve= exp SEMIC )* IN )? varE= exp SEMIC )* CRPAR
					{
					match(input,CLASS,FOLLOW_CLASS_in_cllist141); 
					cid=(Token)match(input,ID,FOLLOW_ID_in_cllist145); 

					         ClassNode Obj = new ClassNode((cid!=null?cid.getText():null));
					         astlist.add(Obj);
					         CTentry extendedEntry = null;
					         CTentry ctentry       = null;
					         HashMap<String,STentry> hm = symTable.get(nestingLevel);
					         System.out.println("La STentry di class "+(cid!=null?cid.getText():null)+" ha nl = "+nestingLevel);   
					         STentry entryCl = new STentry(Obj,nestingLevel);
					         nestingLevel++;
					         ctentry = new CTentry(Obj,nestingLevel);
					         entryCl.setClassName((cid!=null?cid.getText():null));
					         
					         STentry tmp  = hm.put((cid!=null?cid.getText():null),entryCl);
					         CTentry tmp2 = classTable.put((cid!=null?cid.getText():null),ctentry);
					         
					         if (tmp != null && tmp2 != null)
					         {
					            System.out.println("Class id "+(cid!=null?cid.getText():null)+" at line "+(cid!=null?cid.getLine():0)+" already declared");
					            System.exit(0); 
					         }                
					         
					         HashMap<String,STentry> classLevelSymTable =  new HashMap<String,STentry>(); 
					         symTable.add(classLevelSymTable);        
					         ctentry.setVirtualTable(classLevelSymTable);
					      
					// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:73:6: ( EXTENDS cidext= ID )?
					int alt2=2;
					int LA2_0 = input.LA(1);
					if ( (LA2_0==EXTENDS) ) {
						alt2=1;
					}
					switch (alt2) {
						case 1 :
							// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:73:7: EXTENDS cidext= ID
							{
							match(input,EXTENDS,FOLLOW_EXTENDS_in_cllist161); 
							cidext=(Token)match(input,ID,FOLLOW_ID_in_cllist165); 

								     
							           // HashMap<String,STentry> hmSuper = classTable.get(nestingClassLevel-1);           
							           // verifico che la classe estesa sia già stata dichiarata in precedenza          
							           extendedEntry = classTable.get((cidext!=null?cidext.getText():null));
							         
							                 
							           if(extendedEntry == null){
							           System.out.println("Class id "+(cidext!=null?cidext.getText():null)+" at line "+(cidext!=null?cidext.getLine():0)+" not declared");
							              System.exit(0);
							           }
							           
							           
							           ArrayList<Node> tmpField  = (ArrayList<Node>) extendedEntry.getFields().clone(); //necessario per non rischiare di copiare il riferimento all'oggetto
							           ArrayList<Node> tmpMethod = (ArrayList<Node>) extendedEntry.getMethods().clone();
							           ctentry.setFields(tmpField);
							           ctentry.setMethods(tmpMethod);
							           HashMap<String,STentry> tmpMap = (HashMap<String, STentry>) extendedEntry.getVirtualTable().clone();
							           //ctentry.setVirtualTable(tmpMap);
							           
							  //         symTable.putAll(tmp);
							//           HashMap<String,STentry> vTableExtendedEntry = extendedEntry.getVirtualTable();
							//           HashMap<String,STentry> tempSymTable = symTable.get(nestingLevel);
							//           vTableExtendedEntry.forEach( STentry s ){
							//              tempSymTable.put(s);
							//           }
							           //ctentry.getVirtualTable().putAll(tempMap);
							//           for(int i=0; i<tmpMap.size(); i++){
							//              symTable.get(nestingLevel).put(tmpMap.get(i).getKey(), tmpMap.get(i).getValue());
							////                ctentry.putvTable(tmpMap.get(i));
							//           }
							           symTable.get(nestingLevel).putAll(tmpMap);
							           Obj.setSuperEntry(extendedEntry);
							           Obj.setClassEntry(ctentry);
							           FOOLlib.putSuperType((cid!=null?cid.getText():null),(cidext!=null?cidext.getText():null));
							           ctentry.setMethodOffset(extendedEntry.getMethodOffset());
							           ctentry.setFieldOffset(extendedEntry.getFieldOffset());
							           //nestingVirtualLevel = extendedEntry.getNestinglevel();
							           //hmn = symTable.get(extendedEntry.getNestinglevel());
								     
							}
							break;

					}

					match(input,LPAR,FOLLOW_LPAR_in_cllist190); 

					           ArrayList<Node> ConstrPar = new ArrayList<Node>();
					          // int fieldOffset=-1; 
					       
					// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:120:7: (p1= ID COLON t1= basic ( COMMA pn= ID COLON tn= basic )* )?
					int alt4=2;
					int LA4_0 = input.LA(1);
					if ( (LA4_0==ID) ) {
						alt4=1;
					}
					switch (alt4) {
						case 1 :
							// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:120:8: p1= ID COLON t1= basic ( COMMA pn= ID COLON tn= basic )*
							{
							p1=(Token)match(input,ID,FOLLOW_ID_in_cllist210); 
							match(input,COLON,FOLLOW_COLON_in_cllist212); 
							pushFollow(FOLLOW_basic_in_cllist216);
							t1=basic();
							state._fsp--;


								       
								         ConstrPar.add(t1);
							           FieldNode objField = new FieldNode((p1!=null?p1.getText():null),t1,(cid!=null?cid.getText():null));
							           Obj.addField(objField);
							           //ctentry.setFieldOffset(fieldOffset);
							           STentry  tempEntry = new STentry(objField,nestingLevel,t1,ctentry.getFieldOffset());
							           tempEntry.setClassName((cid!=null?cid.getText():null));
							           if(ctentry.putvTable((p1!=null?p1.getText():null),tempEntry, extendedEntry) != null)//putvTable controlla anche se c'è overriding, in caso positivo sovrascrive
							           {
							              System.out.println("Parameter id "+(p1!=null?p1.getText():null)+" at line "+(p1!=null?p1.getLine():0)+" already declared!");
							              System.exit(0);
							           }         
							           if(ctentry.setFieldAndCheck(objField,(p1!=null?p1.getText():null)))
							               tempEntry.setOffset(ctentry.getFieldOffset());//controlla in allFields se c'è già come campo, in caso positivo sovrascrive (overriding)
							//           if( ctentry.setFieldAndCheck_Opt(objField, (p1!=null?p1.getText():null), ctentry.getFieldOffset()) )
							//               tempEntry.setOffset( ctentry.getFieldOffset() );//controlla in allFields se c'è già come campo, in caso positivo sovrascrive (overriding)
							           
							           
							           
							           ctentry.decFieldOffset();
								     
							// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:143:7: ( COMMA pn= ID COLON tn= basic )*
							loop3:
							while (true) {
								int alt3=2;
								int LA3_0 = input.LA(1);
								if ( (LA3_0==COMMA) ) {
									alt3=1;
								}

								switch (alt3) {
								case 1 :
									// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:143:8: COMMA pn= ID COLON tn= basic
									{
									match(input,COMMA,FOLLOW_COMMA_in_cllist234); 
									pn=(Token)match(input,ID,FOLLOW_ID_in_cllist238); 
									match(input,COLON,FOLLOW_COLON_in_cllist240); 
									pushFollow(FOLLOW_basic_in_cllist244);
									tn=basic();
									state._fsp--;


										        ConstrPar.add(tn);
									          FieldNode objFieldN = new FieldNode((pn!=null?pn.getText():null),tn,(cid!=null?cid.getText():null));
									          Obj.addField(objFieldN);
									          //ctentry.setFieldOffset(fieldOffset);
									          STentry tmpSTentry = new STentry(objFieldN,nestingLevel,tn,ctentry.getFieldOffset());
									        //  System.out.println("La entry "+(pn!=null?pn.getText():null)+" ha nl = "+nestingLevel);
									          if ( ctentry.putvTable((pn!=null?pn.getText():null),tmpSTentry,extendedEntry) != null  )
									          {
									             System.out.println("Parameter id "+(pn!=null?pn.getText():null)+" at line "+(pn!=null?pn.getLine():0)+" already declared");
									             System.exit(0); 
									          }         
									          if(ctentry.setFieldAndCheck(objFieldN,(pn!=null?pn.getText():null)))
									             tmpSTentry.setOffset(ctentry.getFieldOffset());
									//          if( ctentry.setFieldAndCheck_Opt(objFieldN, (pn!=null?pn.getText():null), ctentry.getFieldOffset()) )
									//             tmpSTentry.setOffset( ctentry.getFieldOffset() );//controlla in allFields se c'è già come campo, in caso positivo sovrascrive (overriding)
									           
									             
									          ctentry.decFieldOffset();
										     
									}
									break;

								default :
									break loop3;
								}
							}

							}
							break;

					}

					match(input,RPAR,FOLLOW_RPAR_in_cllist266); 

						        ctentry.addType( new ArrowTypeNode(ConstrPar, Obj) ); 
						     
					match(input,CLPAR,FOLLOW_CLPAR_in_cllist282); 
					// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:169:9: ( FUN mid= ID COLON retm= basic LPAR (mp1= ID COLON mpt1= type ( COMMA mpn= ID COLON mptn= type )* )? RPAR ( LET ( VAR vid= ID COLON vt= type ASS ve= exp SEMIC )* IN )? varE= exp SEMIC )*
					loop9:
					while (true) {
						int alt9=2;
						int LA9_0 = input.LA(1);
						if ( (LA9_0==FUN) ) {
							alt9=1;
						}

						switch (alt9) {
						case 1 :
							// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:169:10: FUN mid= ID COLON retm= basic LPAR (mp1= ID COLON mpt1= type ( COMMA mpn= ID COLON mptn= type )* )? RPAR ( LET ( VAR vid= ID COLON vt= type ASS ve= exp SEMIC )* IN )? varE= exp SEMIC
							{
							match(input,FUN,FOLLOW_FUN_in_cllist293); 
							mid=(Token)match(input,ID,FOLLOW_ID_in_cllist297); 
							match(input,COLON,FOLLOW_COLON_in_cllist299); 
							pushFollow(FOLLOW_basic_in_cllist303);
							retm=basic();
							state._fsp--;

							 
							             MethodNode mNode = new MethodNode((mid!=null?mid.getText():null),retm); 
							                      
							             //astlist.add(f);//giusto o da commentare???
							             STentry entry = new STentry(mNode,nestingLevel,retm,ctentry.getMethodOffset());
							             entry.setClassName((cid!=null?cid.getText():null));
							             entry.setIsMethod();             
							             if ( ctentry.putvTable((mid!=null?mid.getText():null),entry,extendedEntry) != null  )
							             {
							                System.out.println("Method id "+(mid!=null?mid.getText():null)+" at line "+(mid!=null?mid.getLine():0)+" already declared");
							                System.exit(0); 
							             }
							            // ctentry.setMethodOffset(methodOffset);  //            
							             ctentry.incMethodOffset();
							             if(ctentry.setMethodAndCheck(mNode,(mid!=null?mid.getText():null)))
							                entry.setOffset(ctentry.getMethodOffset());
							//              if(ctentry.setMethodAndCheck_Opt( mNode, (mid!=null?mid.getText():null), ctentry.getMethodOffset() ))
							//                entry.setOffset(ctentry.getMethodOffset());
							                
							              Obj.setMethod(mNode);
							              nestingLevel++;
							              HashMap<String,STentry> hmMethod = new HashMap<String,STentry> ();
							              symTable.add(hmMethod);
								       
							match(input,LPAR,FOLLOW_LPAR_in_cllist323); 

								          ArrayList<Node> parTypes = new ArrayList<Node>();
							            int parOffset = 1;
								       
							// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:199:9: (mp1= ID COLON mpt1= type ( COMMA mpn= ID COLON mptn= type )* )?
							int alt6=2;
							int LA6_0 = input.LA(1);
							if ( (LA6_0==ID) ) {
								alt6=1;
							}
							switch (alt6) {
								case 1 :
									// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:199:10: mp1= ID COLON mpt1= type ( COMMA mpn= ID COLON mptn= type )*
									{
									mp1=(Token)match(input,ID,FOLLOW_ID_in_cllist347); 
									match(input,COLON,FOLLOW_COLON_in_cllist349); 
									pushFollow(FOLLOW_type_in_cllist353);
									mpt1=type();
									state._fsp--;


										          parTypes.add(mpt1);
									            ParNode fpar = new ParNode((mp1!=null?mp1.getText():null),mpt1);
									            mNode.addPar(fpar);
									            STentry tmpEntryPar = new STentry(fpar,nestingLevel,mpt1,parOffset);             
									            
									            if ( hmMethod.put((mp1!=null?mp1.getText():null),tmpEntryPar) != null  ){
									             System.out.println("Parameter id "+(mp1!=null?mp1.getText():null)+" at line "+(mp1!=null?mp1.getLine():0)+" already declared");
									             System.exit(0);
									             }
									             
									             parOffset++;
										          
									            
										       
									// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:215:9: ( COMMA mpn= ID COLON mptn= type )*
									loop5:
									while (true) {
										int alt5=2;
										int LA5_0 = input.LA(1);
										if ( (LA5_0==COMMA) ) {
											alt5=1;
										}

										switch (alt5) {
										case 1 :
											// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:215:10: COMMA mpn= ID COLON mptn= type
											{
											match(input,COMMA,FOLLOW_COMMA_in_cllist375); 
											mpn=(Token)match(input,ID,FOLLOW_ID_in_cllist379); 
											match(input,COLON,FOLLOW_COLON_in_cllist381); 
											pushFollow(FOLLOW_type_in_cllist385);
											mptn=type();
											state._fsp--;


												          parTypes.add(mptn);
											            ParNode par = new ParNode((mpn!=null?mpn.getText():null),mptn);
											            mNode.addPar(par);
											           
											            STentry stPar = new STentry(fpar,nestingLevel,mptn,parOffset);
											            if (hmMethod.put((mpn!=null?mpn.getText():null),stPar) != null ){
											               System.out.println("Parameter id "+(mpn!=null?mpn.getText():null)+" at line "+(mpn!=null?mpn.getLine():0)+" already declared");
											               System.exit(0);
											               }
											               
											            parOffset++;

												       
											}
											break;

										default :
											break loop5;
										}
									}

									}
									break;

							}

							match(input,RPAR,FOLLOW_RPAR_in_cllist402); 

								          entry.addType( new ArrowTypeNode(parTypes , retm) );
							            ArrayList<Node> letInMethodList = new ArrayList<Node>();       
							            
							            
								       
							// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:236:9: ( LET ( VAR vid= ID COLON vt= type ASS ve= exp SEMIC )* IN )?
							int alt8=2;
							int LA8_0 = input.LA(1);
							if ( (LA8_0==LET) ) {
								alt8=1;
							}
							switch (alt8) {
								case 1 :
									// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:236:10: LET ( VAR vid= ID COLON vt= type ASS ve= exp SEMIC )* IN
									{
									match(input,LET,FOLLOW_LET_in_cllist423); 

										           int innerOffset = 0; 
										           nestingLevel++;
										       
									// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:241:9: ( VAR vid= ID COLON vt= type ASS ve= exp SEMIC )*
									loop7:
									while (true) {
										int alt7=2;
										int LA7_0 = input.LA(1);
										if ( (LA7_0==VAR) ) {
											alt7=1;
										}

										switch (alt7) {
										case 1 :
											// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:241:10: VAR vid= ID COLON vt= type ASS ve= exp SEMIC
											{
											match(input,VAR,FOLLOW_VAR_in_cllist445); 
											vid=(Token)match(input,ID,FOLLOW_ID_in_cllist449); 
											match(input,COLON,FOLLOW_COLON_in_cllist451); 
											pushFollow(FOLLOW_type_in_cllist455);
											vt=type();
											state._fsp--;

											match(input,ASS,FOLLOW_ASS_in_cllist457); 
											pushFollow(FOLLOW_exp_in_cllist461);
											ve=exp();
											state._fsp--;


												          VarNode v = new VarNode((vid!=null?vid.getText():null),vt,ve);
											           // letInMethodList.add(v); 
											            astlist.add(v);
											            HashMap<String,STentry> varhm =  new HashMap<String,STentry>(); 
											            symTable.add(varhm);
											            
											            if ( varhm.put((vid!=null?vid.getText():null),new STentry(v,nestingLevel,vt,innerOffset++)) != null  )
											            {
											               System.out.println("Var id "+(vid!=null?vid.getText():null)+" at line "+(vid!=null?vid.getLine():0)+" already declared");
											               System.exit(0); 
											            } 
											                         
											          
											match(input,SEMIC,FOLLOW_SEMIC_in_cllist483); 
											}
											break;

										default :
											break loop7;
										}
									}

									match(input,IN,FOLLOW_IN_in_cllist487); 

										          
										        
									}
									break;

							}

							pushFollow(FOLLOW_exp_in_cllist515);
							varE=exp();
							state._fsp--;


								            //chiudere scope                       
							              symTable.remove(nestingLevel--);           
							              mNode.addBody(varE);
							              //aggiungo il metodo alla classe
							              Obj.addMethod(mNode); 
							              
								        
							match(input,SEMIC,FOLLOW_SEMIC_in_cllist538); 
							}
							break;

						default :
							break loop9;
						}
					}

					match(input,CRPAR,FOLLOW_CRPAR_in_cllist549); 

					        symTable.remove(nestingLevel--);  
					      
					}
					break;

				default :
					break loop10;
				}
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
		return astlist;
	}
	// $ANTLR end "cllist"



	// $ANTLR start "declist"
	// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:278:1: declist returns [ArrayList<Node> astlist] : ( ( VAR i= ID COLON t= type ASS e= exp | FUN i= ID COLON t= basic LPAR (fid= ID COLON fty= type ( COMMA id= ID COLON ty= type )* )? RPAR ( LET d= declist IN )? e= exp ) SEMIC )* ;
	public final ArrayList<Node> declist() throws RecognitionException {
		ArrayList<Node> astlist = null;


		Token i=null;
		Token fid=null;
		Token id=null;
		Node t =null;
		Node e =null;
		Node fty =null;
		Node ty =null;
		ArrayList<Node> d =null;

		try {
			// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:279:2: ( ( ( VAR i= ID COLON t= type ASS e= exp | FUN i= ID COLON t= basic LPAR (fid= ID COLON fty= type ( COMMA id= ID COLON ty= type )* )? RPAR ( LET d= declist IN )? e= exp ) SEMIC )* )
			// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:279:4: ( ( VAR i= ID COLON t= type ASS e= exp | FUN i= ID COLON t= basic LPAR (fid= ID COLON fty= type ( COMMA id= ID COLON ty= type )* )? RPAR ( LET d= declist IN )? e= exp ) SEMIC )*
			{

				    astlist = new ArrayList<Node>() ;
				    int offset=-2;
				  
			// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:283:5: ( ( VAR i= ID COLON t= type ASS e= exp | FUN i= ID COLON t= basic LPAR (fid= ID COLON fty= type ( COMMA id= ID COLON ty= type )* )? RPAR ( LET d= declist IN )? e= exp ) SEMIC )*
			loop15:
			while (true) {
				int alt15=2;
				int LA15_0 = input.LA(1);
				if ( (LA15_0==FUN||LA15_0==VAR) ) {
					alt15=1;
				}

				switch (alt15) {
				case 1 :
					// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:284:6: ( VAR i= ID COLON t= type ASS e= exp | FUN i= ID COLON t= basic LPAR (fid= ID COLON fty= type ( COMMA id= ID COLON ty= type )* )? RPAR ( LET d= declist IN )? e= exp ) SEMIC
					{
					// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:284:6: ( VAR i= ID COLON t= type ASS e= exp | FUN i= ID COLON t= basic LPAR (fid= ID COLON fty= type ( COMMA id= ID COLON ty= type )* )? RPAR ( LET d= declist IN )? e= exp )
					int alt14=2;
					int LA14_0 = input.LA(1);
					if ( (LA14_0==VAR) ) {
						alt14=1;
					}
					else if ( (LA14_0==FUN) ) {
						alt14=2;
					}

					else {
						NoViableAltException nvae =
							new NoViableAltException("", 14, 0, input);
						throw nvae;
					}

					switch (alt14) {
						case 1 :
							// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:285:8: VAR i= ID COLON t= type ASS e= exp
							{
							match(input,VAR,FOLLOW_VAR_in_declist620); 
							i=(Token)match(input,ID,FOLLOW_ID_in_declist624); 
							match(input,COLON,FOLLOW_COLON_in_declist626); 
							pushFollow(FOLLOW_type_in_declist630);
							t=type();
							state._fsp--;

							match(input,ASS,FOLLOW_ASS_in_declist632); 
							pushFollow(FOLLOW_exp_in_declist636);
							e=exp();
							state._fsp--;


							          VarNode v = new VarNode((i!=null?i.getText():null),t,e);
							          astlist.add(v);
							          //System.out.println("type: "+t + "var "+(i!=null?i.getText():null));
							          if(t instanceof ArrowTypeNode)
							          {
							             offset--;
							          }
							          
							          System.out.println("[FOOL.g] VAR    "+ v.toPrint(""));
							            
							          HashMap<String,STentry> hm = symTable.get(nestingLevel);
							          //System.out.println("Var id "+(i!=null?i.getText():null)+" at line "+(i!=null?i.getLine():0)+" ha nesting = "+nestingLevel);
							          STentry varEntry = new STentry(nestingLevel,t,offset--);
							          if ( hm.put((i!=null?i.getText():null),varEntry) != null  ){
							             System.out.println("Var id "+(i!=null?i.getText():null)+" at line "+(i!=null?i.getLine():0)+" already declared");
							             System.exit(0);
							          }
							       
							       
							}
							break;
						case 2 :
							// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:307:8: FUN i= ID COLON t= basic LPAR (fid= ID COLON fty= type ( COMMA id= ID COLON ty= type )* )? RPAR ( LET d= declist IN )? e= exp
							{
							match(input,FUN,FOLLOW_FUN_in_declist663); 
							i=(Token)match(input,ID,FOLLOW_ID_in_declist667); 
							match(input,COLON,FOLLOW_COLON_in_declist669); 
							pushFollow(FOLLOW_basic_in_declist673);
							t=basic();
							state._fsp--;

							  
							          //inserimento di ID nella symtable
							          FunNode f = new FunNode((i!=null?i.getText():null),t);
							          astlist.add(f);
							          HashMap<String,STentry> hm = symTable.get(nestingLevel);                
							          STentry entry = new STentry(nestingLevel,offset);
							          offset=offset - 2;
							          //STentry entry = new STentry(nestingLevel,f,offset-=2);
							          if ( hm.put((i!=null?i.getText():null),entry) != null ){
							             System.out.println("Fun id "+(i!=null?i.getText():null)+" at line "+(i!=null?i.getLine():0)+" already declared");
							             System.exit(0);
							          }
							          //creare una nuova hashmap per la symTable
							          nestingLevel++;
							          HashMap<String,STentry> hmn = new HashMap<String,STentry> ();
							          symTable.add(hmn);
							       
							match(input,LPAR,FOLLOW_LPAR_in_declist691); 
							 ArrayList<Node> parTypes = new ArrayList<Node>(); int paroffset=1; 
							// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:326:8: (fid= ID COLON fty= type ( COMMA id= ID COLON ty= type )* )?
							int alt12=2;
							int LA12_0 = input.LA(1);
							if ( (LA12_0==ID) ) {
								alt12=1;
							}
							switch (alt12) {
								case 1 :
									// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:327:10: fid= ID COLON fty= type ( COMMA id= ID COLON ty= type )*
									{
									fid=(Token)match(input,ID,FOLLOW_ID_in_declist716); 
									match(input,COLON,FOLLOW_COLON_in_declist718); 
									pushFollow(FOLLOW_type_in_declist722);
									fty=type();
									state._fsp--;


										          parTypes.add(fty); 
										          ParNode fpar = new ParNode((fid!=null?fid.getText():null),fty);
										          
										          if(fty instanceof ArrowTypeNode )            
									               paroffset++;
									             
									                      	        
										          f.addPar(fpar);
										                             
										          if ( hmn.put((fid!=null?fid.getText():null),new STentry(fpar,nestingLevel,fty,paroffset++)) != null  ){
										             System.out.println("Parameter id "+(fid!=null?fid.getText():null)+" at line "+(fid!=null?fid.getLine():0)+" already declared");
										             System.exit(0);
										          }
									         
									// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:343:10: ( COMMA id= ID COLON ty= type )*
									loop11:
									while (true) {
										int alt11=2;
										int LA11_0 = input.LA(1);
										if ( (LA11_0==COMMA) ) {
											alt11=1;
										}

										switch (alt11) {
										case 1 :
											// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:344:12: COMMA id= ID COLON ty= type
											{
											match(input,COMMA,FOLLOW_COMMA_in_declist757); 
											id=(Token)match(input,ID,FOLLOW_ID_in_declist761); 
											match(input,COLON,FOLLOW_COLON_in_declist763); 
											pushFollow(FOLLOW_type_in_declist767);
											ty=type();
											state._fsp--;


													           parTypes.add(ty); 
													           ParNode par = new ParNode((id!=null?id.getText():null),ty);
													           if(ty instanceof ArrowTypeNode)
													              paroffset++;
											             
													           f.addPar(par);
													           if ( hmn.put((id!=null?id.getText():null),new STentry(par,nestingLevel,ty,paroffset++)) != null  ){
													              System.out.println("Parameter id "+(id!=null?id.getText():null)+" at line "+(id!=null?id.getLine():0)+" already declared");
													              System.exit(0);
													           }
												          
											}
											break;

										default :
											break loop11;
										}
									}

									}
									break;

							}

							match(input,RPAR,FOLLOW_RPAR_in_declist812); 
							 entry.addType( new ArrowTypeNode(parTypes, t) ); 
							// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:360:8: ( LET d= declist IN )?
							int alt13=2;
							int LA13_0 = input.LA(1);
							if ( (LA13_0==LET) ) {
								alt13=1;
							}
							switch (alt13) {
								case 1 :
									// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:360:10: LET d= declist IN
									{
									match(input,LET,FOLLOW_LET_in_declist826); 
									pushFollow(FOLLOW_declist_in_declist830);
									d=declist();
									state._fsp--;

									match(input,IN,FOLLOW_IN_in_declist832); 
									}
									break;

							}

							pushFollow(FOLLOW_exp_in_declist857);
							e=exp();
							state._fsp--;

							//chiudere scope
							          symTable.remove(nestingLevel--);
							          f.addDecBody(d, e);//abbiamo cambiato add body con addDecBody (dichiarazione dei parametri ed espressione del corpo della funzione)
							       
							}
							break;

					}

					match(input,SEMIC,FOLLOW_SEMIC_in_declist877); 
					}
					break;

				default :
					break loop15;
				}
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
		return astlist;
	}
	// $ANTLR end "declist"



	// $ANTLR start "type"
	// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:371:1: type returns [Node ast] : (bas= basic |art= arrow );
	public final Node type() throws RecognitionException {
		Node ast = null;


		Node bas =null;
		Node art =null;

		try {
			// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:372:9: (bas= basic |art= arrow )
			int alt16=2;
			int LA16_0 = input.LA(1);
			if ( (LA16_0==BOOL||LA16_0==ID||LA16_0==INT) ) {
				alt16=1;
			}
			else if ( (LA16_0==LPAR) ) {
				alt16=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 16, 0, input);
				throw nvae;
			}

			switch (alt16) {
				case 1 :
					// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:372:11: bas= basic
					{
					pushFollow(FOLLOW_basic_in_type911);
					bas=basic();
					state._fsp--;

					ast = bas;
					}
					break;
				case 2 :
					// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:373:11: art= arrow
					{
					pushFollow(FOLLOW_arrow_in_type927);
					art=arrow();
					state._fsp--;

					ast = art;
					}
					break;

			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return ast;
	}
	// $ANTLR end "type"



	// $ANTLR start "basic"
	// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:376:1: basic returns [Node ast] : ( INT | BOOL |i= ID );
	public final Node basic() throws RecognitionException {
		Node ast = null;


		Token i=null;

		try {
			// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:377:3: ( INT | BOOL |i= ID )
			int alt17=3;
			switch ( input.LA(1) ) {
			case INT:
				{
				alt17=1;
				}
				break;
			case BOOL:
				{
				alt17=2;
				}
				break;
			case ID:
				{
				alt17=3;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 17, 0, input);
				throw nvae;
			}
			switch (alt17) {
				case 1 :
					// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:377:11: INT
					{
					match(input,INT,FOLLOW_INT_in_basic955); 
					ast =new IntTypeNode();
					}
					break;
				case 2 :
					// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:378:11: BOOL
					{
					match(input,BOOL,FOLLOW_BOOL_in_basic970); 
					ast =new BoolTypeNode();
					}
					break;
				case 3 :
					// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:379:11: i= ID
					{
					i=(Token)match(input,ID,FOLLOW_ID_in_basic987); 

					         int jj = nestingLevel;    
					         STentry classEntry = null;    
					         while (jj>=0 && classEntry==null){
					           classEntry=(symTable.get(jj--)).get((i!=null?i.getText():null));         
					         }       
					                  if(classEntry != null)
					                  {
					                    ast =new ClassTypeNode((i!=null?i.getText():null));                  
					                   }
					                  else
					                  ast =new IdNode();
					        
					}
					break;

			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return ast;
	}
	// $ANTLR end "basic"



	// $ANTLR start "arrow"
	// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:398:1: arrow returns [Node ast] : LPAR (funParT= type ( COMMA funParTy= type )* )? RPAR ARROW retTy= basic ;
	public final Node arrow() throws RecognitionException {
		Node ast = null;


		Node funParT =null;
		Node funParTy =null;
		Node retTy =null;

		try {
			// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:399:9: ( LPAR (funParT= type ( COMMA funParTy= type )* )? RPAR ARROW retTy= basic )
			// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:399:11: LPAR (funParT= type ( COMMA funParTy= type )* )? RPAR ARROW retTy= basic
			{
			match(input,LPAR,FOLLOW_LPAR_in_arrow1016); 

			            //creazione di una lista vuota per i parametri
			            ArrayList<Node> funParTypes = new ArrayList<Node>();
			          
			// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:404:11: (funParT= type ( COMMA funParTy= type )* )?
			int alt19=2;
			int LA19_0 = input.LA(1);
			if ( (LA19_0==BOOL||LA19_0==ID||LA19_0==INT||LA19_0==LPAR) ) {
				alt19=1;
			}
			switch (alt19) {
				case 1 :
					// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:405:13: funParT= type ( COMMA funParTy= type )*
					{
					pushFollow(FOLLOW_type_in_arrow1057);
					funParT=type();
					state._fsp--;


					              funParTypes.add(funParT);
					            
					// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:409:13: ( COMMA funParTy= type )*
					loop18:
					while (true) {
						int alt18=2;
						int LA18_0 = input.LA(1);
						if ( (LA18_0==COMMA) ) {
							alt18=1;
						}

						switch (alt18) {
						case 1 :
							// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:409:14: COMMA funParTy= type
							{
							match(input,COMMA,FOLLOW_COMMA_in_arrow1087); 
							pushFollow(FOLLOW_type_in_arrow1091);
							funParTy=type();
							state._fsp--;


							              funParTypes.add(funParTy);
							            
							}
							break;

						default :
							break loop18;
						}
					}

					}
					break;

			}

			match(input,RPAR,FOLLOW_RPAR_in_arrow1123); 
			match(input,ARROW,FOLLOW_ARROW_in_arrow1125); 
			pushFollow(FOLLOW_basic_in_arrow1129);
			retTy=basic();
			state._fsp--;


			           //creazione del nodo della funzione High Order
			           ast = new ArrowTypeNode(funParTypes,retTy);
			          
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return ast;
	}
	// $ANTLR end "arrow"



	// $ANTLR start "exp"
	// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:419:1: exp returns [Node ast] : f= term ( PLUS l= term | MINUS l= term | OR l= term )* ;
	public final Node exp() throws RecognitionException {
		Node ast = null;


		Node f =null;
		Node l =null;

		try {
			// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:420:3: (f= term ( PLUS l= term | MINUS l= term | OR l= term )* )
			// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:420:5: f= term ( PLUS l= term | MINUS l= term | OR l= term )*
			{
			pushFollow(FOLLOW_term_in_exp1161);
			f=term();
			state._fsp--;

			ast = f;
			// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:421:7: ( PLUS l= term | MINUS l= term | OR l= term )*
			loop20:
			while (true) {
				int alt20=4;
				switch ( input.LA(1) ) {
				case PLUS:
					{
					alt20=1;
					}
					break;
				case MINUS:
					{
					alt20=2;
					}
					break;
				case OR:
					{
					alt20=3;
					}
					break;
				}
				switch (alt20) {
				case 1 :
					// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:422:8: PLUS l= term
					{
					match(input,PLUS,FOLLOW_PLUS_in_exp1180); 
					pushFollow(FOLLOW_term_in_exp1184);
					l=term();
					state._fsp--;

					ast = new PlusNode (ast,l);
					}
					break;
				case 2 :
					// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:423:10: MINUS l= term
					{
					match(input,MINUS,FOLLOW_MINUS_in_exp1198); 
					pushFollow(FOLLOW_term_in_exp1202);
					l=term();
					state._fsp--;

					ast = new MinusNode(ast,l);
					}
					break;
				case 3 :
					// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:424:10: OR l= term
					{
					match(input,OR,FOLLOW_OR_in_exp1215); 
					pushFollow(FOLLOW_term_in_exp1219);
					l=term();
					state._fsp--;

					ast = new OrNode   (ast,l);
					}
					break;

				default :
					break loop20;
				}
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
		return ast;
	}
	// $ANTLR end "exp"



	// $ANTLR start "term"
	// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:428:1: term returns [Node ast] : f= factor ( MULT l= factor | DIV l= factor | AND l= factor )* ;
	public final Node term() throws RecognitionException {
		Node ast = null;


		Node f =null;
		Node l =null;

		try {
			// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:429:2: (f= factor ( MULT l= factor | DIV l= factor | AND l= factor )* )
			// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:429:4: f= factor ( MULT l= factor | DIV l= factor | AND l= factor )*
			{
			pushFollow(FOLLOW_factor_in_term1253);
			f=factor();
			state._fsp--;

			ast = f;
			// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:430:6: ( MULT l= factor | DIV l= factor | AND l= factor )*
			loop21:
			while (true) {
				int alt21=4;
				switch ( input.LA(1) ) {
				case MULT:
					{
					alt21=1;
					}
					break;
				case DIV:
					{
					alt21=2;
					}
					break;
				case AND:
					{
					alt21=3;
					}
					break;
				}
				switch (alt21) {
				case 1 :
					// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:431:7: MULT l= factor
					{
					match(input,MULT,FOLLOW_MULT_in_term1270); 
					pushFollow(FOLLOW_factor_in_term1274);
					l=factor();
					state._fsp--;

					ast = new MultNode (ast,l);
					}
					break;
				case 2 :
					// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:432:9: DIV l= factor
					{
					match(input,DIV,FOLLOW_DIV_in_term1286); 
					pushFollow(FOLLOW_factor_in_term1291);
					l=factor();
					state._fsp--;

					ast = new DivNode (ast,l);
					}
					break;
				case 3 :
					// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:433:9: AND l= factor
					{
					match(input,AND,FOLLOW_AND_in_term1303); 
					pushFollow(FOLLOW_factor_in_term1308);
					l=factor();
					state._fsp--;

					ast = new AndNode (ast,l);
					}
					break;

				default :
					break loop21;
				}
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
		return ast;
	}
	// $ANTLR end "term"



	// $ANTLR start "value"
	// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:437:1: value returns [Node ast] : (i= INTEGER | TRUE | FALSE | NULL | NEW i= ID LPAR (fa= exp ( COMMA a= exp )* )? RPAR | IF LPAR x= exp RPAR THEN CLPAR y= exp CRPAR ELSE CLPAR z= exp CRPAR | NOT LPAR x= exp RPAR | PRINT LPAR e= exp RPAR | LPAR e= exp RPAR |i= ID ( LPAR (fa= exp ( COMMA a= exp )* )? RPAR | DOT cmid= ID LPAR (cmex1= exp ( COMMA cmexn= exp )* )? RPAR )? );
	public final Node value() throws RecognitionException {
		Node ast = null;


		Token i=null;
		Token cmid=null;
		Node fa =null;
		Node a =null;
		Node x =null;
		Node y =null;
		Node z =null;
		Node e =null;
		Node cmex1 =null;
		Node cmexn =null;

		try {
			// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:438:2: (i= INTEGER | TRUE | FALSE | NULL | NEW i= ID LPAR (fa= exp ( COMMA a= exp )* )? RPAR | IF LPAR x= exp RPAR THEN CLPAR y= exp CRPAR ELSE CLPAR z= exp CRPAR | NOT LPAR x= exp RPAR | PRINT LPAR e= exp RPAR | LPAR e= exp RPAR |i= ID ( LPAR (fa= exp ( COMMA a= exp )* )? RPAR | DOT cmid= ID LPAR (cmex1= exp ( COMMA cmexn= exp )* )? RPAR )? )
			int alt29=10;
			switch ( input.LA(1) ) {
			case INTEGER:
				{
				alt29=1;
				}
				break;
			case TRUE:
				{
				alt29=2;
				}
				break;
			case FALSE:
				{
				alt29=3;
				}
				break;
			case NULL:
				{
				alt29=4;
				}
				break;
			case NEW:
				{
				alt29=5;
				}
				break;
			case IF:
				{
				alt29=6;
				}
				break;
			case NOT:
				{
				alt29=7;
				}
				break;
			case PRINT:
				{
				alt29=8;
				}
				break;
			case LPAR:
				{
				alt29=9;
				}
				break;
			case ID:
				{
				alt29=10;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 29, 0, input);
				throw nvae;
			}
			switch (alt29) {
				case 1 :
					// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:438:4: i= INTEGER
					{
					i=(Token)match(input,INTEGER,FOLLOW_INTEGER_in_value1335); 
					ast = new NatNode(Integer.parseInt((i!=null?i.getText():null)));
					}
					break;
				case 2 :
					// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:439:4: TRUE
					{
					match(input,TRUE,FOLLOW_TRUE_in_value1344); 
					ast = new BoolNode(true);
					}
					break;
				case 3 :
					// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:440:5: FALSE
					{
					match(input,FALSE,FOLLOW_FALSE_in_value1353); 
					ast = new BoolNode(false);
					}
					break;
				case 4 :
					// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:441:5: NULL
					{
					match(input,NULL,FOLLOW_NULL_in_value1361); 
					ast = new EmptyNode();
					}
					break;
				case 5 :
					// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:442:5: NEW i= ID LPAR (fa= exp ( COMMA a= exp )* )? RPAR
					{
					match(input,NEW,FOLLOW_NEW_in_value1370); 
					i=(Token)match(input,ID,FOLLOW_ID_in_value1374); 

					       CTentry ctEntry=null; 
					       ctEntry=classTable.get((i!=null?i.getText():null));
					       
					       
					       if(ctEntry==null)
					       {
					          System.out.println("Class "+(i!=null?i.getText():null)+" at line "+(i!=null?i.getLine():0)+" not declared!!!!");
					          System.exit(0); 
					       }
					    
					match(input,LPAR,FOLLOW_LPAR_in_value1386); 

					       ArrayList<Node> argList = new ArrayList<Node>();
					    
					// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:458:5: (fa= exp ( COMMA a= exp )* )?
					int alt23=2;
					int LA23_0 = input.LA(1);
					if ( (LA23_0==FALSE||(LA23_0 >= ID && LA23_0 <= IF)||LA23_0==INTEGER||LA23_0==LPAR||(LA23_0 >= NEW && LA23_0 <= NULL)||LA23_0==PRINT||LA23_0==TRUE) ) {
						alt23=1;
					}
					switch (alt23) {
						case 1 :
							// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:458:6: fa= exp ( COMMA a= exp )*
							{
							pushFollow(FOLLOW_exp_in_value1401);
							fa=exp();
							state._fsp--;


							       argList.add(fa);
							       //ctEntry.setField(fa);
							    
							// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:463:7: ( COMMA a= exp )*
							loop22:
							while (true) {
								int alt22=2;
								int LA22_0 = input.LA(1);
								if ( (LA22_0==COMMA) ) {
									alt22=1;
								}

								switch (alt22) {
								case 1 :
									// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:463:8: COMMA a= exp
									{
									match(input,COMMA,FOLLOW_COMMA_in_value1416); 
									pushFollow(FOLLOW_exp_in_value1420);
									a=exp();
									state._fsp--;


										        argList.add(a);
										        // ctEntry.setField(a);
										     
									}
									break;

								default :
									break loop22;
								}
							}

							}
							break;

					}


					            //ClassCallNode c= new ClassCallNode((i!=null?i.getText():null),entry,argList,nNewClass);
					         // ast =c;
					        // ctEntry.setNewOffset(newOffset);
					         ast = new NewNode((i!=null?i.getText():null),ctEntry,argList);
					        // newOffset++;
					//     
					    
					match(input,RPAR,FOLLOW_RPAR_in_value1456); 
					}
					break;
				case 6 :
					// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:480:5: IF LPAR x= exp RPAR THEN CLPAR y= exp CRPAR ELSE CLPAR z= exp CRPAR
					{
					match(input,IF,FOLLOW_IF_in_value1471); 
					match(input,LPAR,FOLLOW_LPAR_in_value1473); 
					pushFollow(FOLLOW_exp_in_value1477);
					x=exp();
					state._fsp--;

					match(input,RPAR,FOLLOW_RPAR_in_value1479); 
					match(input,THEN,FOLLOW_THEN_in_value1481); 
					match(input,CLPAR,FOLLOW_CLPAR_in_value1483); 
					pushFollow(FOLLOW_exp_in_value1487);
					y=exp();
					state._fsp--;

					match(input,CRPAR,FOLLOW_CRPAR_in_value1489); 
					match(input,ELSE,FOLLOW_ELSE_in_value1499); 
					match(input,CLPAR,FOLLOW_CLPAR_in_value1501); 
					pushFollow(FOLLOW_exp_in_value1505);
					z=exp();
					state._fsp--;

					match(input,CRPAR,FOLLOW_CRPAR_in_value1507); 
					ast = new IfNode(x,y,z);
					}
					break;
				case 7 :
					// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:483:5: NOT LPAR x= exp RPAR
					{
					match(input,NOT,FOLLOW_NOT_in_value1523); 
					match(input,LPAR,FOLLOW_LPAR_in_value1525); 
					pushFollow(FOLLOW_exp_in_value1530);
					x=exp();
					state._fsp--;

					match(input,RPAR,FOLLOW_RPAR_in_value1532); 
					ast = new NotNode(x);
					}
					break;
				case 8 :
					// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:484:5: PRINT LPAR e= exp RPAR
					{
					match(input,PRINT,FOLLOW_PRINT_in_value1541); 
					match(input,LPAR,FOLLOW_LPAR_in_value1543); 
					pushFollow(FOLLOW_exp_in_value1547);
					e=exp();
					state._fsp--;

					match(input,RPAR,FOLLOW_RPAR_in_value1549); 
					ast = new PrintNode(e);
					}
					break;
				case 9 :
					// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:485:5: LPAR e= exp RPAR
					{
					match(input,LPAR,FOLLOW_LPAR_in_value1557); 
					pushFollow(FOLLOW_exp_in_value1561);
					e=exp();
					state._fsp--;

					match(input,RPAR,FOLLOW_RPAR_in_value1563); 
					ast = e;
					}
					break;
				case 10 :
					// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:486:6: i= ID ( LPAR (fa= exp ( COMMA a= exp )* )? RPAR | DOT cmid= ID LPAR (cmex1= exp ( COMMA cmexn= exp )* )? RPAR )?
					{
					i=(Token)match(input,ID,FOLLOW_ID_in_value1574); 
					//cercare la dichiarazione (cioè quando lo usa)
						    int j  = nestingLevel;
						    STentry entry     = null; 
						    CTentry classEntry = null;
						    classEntry = classTable.get((i!=null?i.getText():null));
						        
						  //   while (j>=0 && entry==null)
						 //     entry=(symTable.get(j--)).get((i!=null?i.getText():null));
					//	    for(j=0;j<symTable.size() && entry==null;j++)
					//	       entry=(symTable.get(j)).get((i!=null?i.getText():null));
					//	     
						    if(classEntry==null)    
						    {
					         while (j>=0 && entry==null)
					         entry=(symTable.get(j--)).get((i!=null?i.getText():null));
					      }
					      
						    if (entry == null && classEntry == null){
						       System.out.println("Id "+(i!=null?i.getText():null)+" at line "+(i!=null?i.getLine():0)+" not declared!!");	       
						       System.exit(0);
						    }
						     	 
						    //if( classEntry != null )	        
						       // ast = new IdNode((i!=null?i.getText():null),classEntry,nestingLevel);
						  //  else
						        ast = new IdNode((i!=null?i.getText():null),entry,nestingLevel);
						    
					                 
					    
					// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:516:5: ( LPAR (fa= exp ( COMMA a= exp )* )? RPAR | DOT cmid= ID LPAR (cmex1= exp ( COMMA cmexn= exp )* )? RPAR )?
					int alt28=3;
					int LA28_0 = input.LA(1);
					if ( (LA28_0==LPAR) ) {
						alt28=1;
					}
					else if ( (LA28_0==DOT) ) {
						alt28=2;
					}
					switch (alt28) {
						case 1 :
							// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:517:7: LPAR (fa= exp ( COMMA a= exp )* )? RPAR
							{
							match(input,LPAR,FOLLOW_LPAR_in_value1594); 
							 ArrayList<Node> argList = new ArrayList<Node>(); 
							// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:518:7: (fa= exp ( COMMA a= exp )* )?
							int alt25=2;
							int LA25_0 = input.LA(1);
							if ( (LA25_0==FALSE||(LA25_0 >= ID && LA25_0 <= IF)||LA25_0==INTEGER||LA25_0==LPAR||(LA25_0 >= NEW && LA25_0 <= NULL)||LA25_0==PRINT||LA25_0==TRUE) ) {
								alt25=1;
							}
							switch (alt25) {
								case 1 :
									// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:518:8: fa= exp ( COMMA a= exp )*
									{
									pushFollow(FOLLOW_exp_in_value1608);
									fa=exp();
									state._fsp--;

									argList.add(fa);
									// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:519:9: ( COMMA a= exp )*
									loop24:
									while (true) {
										int alt24=2;
										int LA24_0 = input.LA(1);
										if ( (LA24_0==COMMA) ) {
											alt24=1;
										}

										switch (alt24) {
										case 1 :
											// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:519:10: COMMA a= exp
											{
											match(input,COMMA,FOLLOW_COMMA_in_value1621); 
											pushFollow(FOLLOW_exp_in_value1625);
											a=exp();
											state._fsp--;

											argList.add(a);
											}
											break;

										default :
											break loop24;
										}
									}

									}
									break;

							}


							      
							       // System.out.println("nl - (j+1) = "+(nestingLevel-(j+1))+" nl = "+nestingLevel+" j = "+j);
							        if( classEntry != null) 
							         ast =new CallNode((i!=null?i.getText():null),entry,argList,nestingLevel);
							        else 
							        ast =new CallNode((i!=null?i.getText():null),entry,argList,nestingLevel);//è esatto? quasi sicuramente no!
							      
							match(input,RPAR,FOLLOW_RPAR_in_value1657); 
							}
							break;
						case 2 :
							// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:530:8: DOT cmid= ID LPAR (cmex1= exp ( COMMA cmexn= exp )* )? RPAR
							{
							match(input,DOT,FOLLOW_DOT_in_value1666); 
							cmid=(Token)match(input,ID,FOLLOW_ID_in_value1670); 

							       
							       STentry entryM = null;

							       CTentry ctentryClass = classTable.get(((ClassTypeNode)entry.getType()).getName());      
							     // ricerca della entry relativa alla classe dell'oggetto istanza su cui viene richiamato il metodo
							//       -ClassCallNode  ID1.ID2() 
							//        STentry dell'ID1 in campo "entry"
							//        STentry dell'ID2 in campo "methodEntry"
							//        (ID2 cercato in vTable della CTentry della classe del tipo di ID1)      
							       //ricerca dell'entry del metodo all'interno della classe relativa ad esso trovata in precedenza

							       entryM = ctentryClass.getVirtualTable().get((cmid!=null?cmid.getText():null));
							       
							       if (entryM==null){
							         System.out.println("Method Call "+(cmid!=null?cmid.getText():null)+" at line "+(cmid!=null?cmid.getLine():0)+" not declared");
							         System.exit(0); 
							       }        
							  
							    
							match(input,LPAR,FOLLOW_LPAR_in_value1683); 

							        ArrayList<Node> mArgList = new ArrayList<Node>();
							     
							// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:555:6: (cmex1= exp ( COMMA cmexn= exp )* )?
							int alt27=2;
							int LA27_0 = input.LA(1);
							if ( (LA27_0==FALSE||(LA27_0 >= ID && LA27_0 <= IF)||LA27_0==INTEGER||LA27_0==LPAR||(LA27_0 >= NEW && LA27_0 <= NULL)||LA27_0==PRINT||LA27_0==TRUE) ) {
								alt27=1;
							}
							switch (alt27) {
								case 1 :
									// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:555:7: cmex1= exp ( COMMA cmexn= exp )*
									{
									pushFollow(FOLLOW_exp_in_value1700);
									cmex1=exp();
									state._fsp--;


									        mArgList.add(cmex1);
									     
									// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:559:6: ( COMMA cmexn= exp )*
									loop26:
									while (true) {
										int alt26=2;
										int LA26_0 = input.LA(1);
										if ( (LA26_0==COMMA) ) {
											alt26=1;
										}

										switch (alt26) {
										case 1 :
											// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:559:7: COMMA cmexn= exp
											{
											match(input,COMMA,FOLLOW_COMMA_in_value1715); 
											pushFollow(FOLLOW_exp_in_value1719);
											cmexn=exp();
											state._fsp--;


											        mArgList.add(cmexn);
											     
											}
											break;

										default :
											break loop26;
										}
									}

									}
									break;

							}


							        ast = new ClassCallNode((cmid!=null?cmid.getText():null), entry,entryM, mArgList, nestingLevel, ctentryClass);
							     
							match(input,RPAR,FOLLOW_RPAR_in_value1752); 
							}
							break;

					}

					}
					break;

			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return ast;
	}
	// $ANTLR end "value"



	// $ANTLR start "factor"
	// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:572:1: factor returns [Node ast] : f= value ( EQ l= value | GR l= value | LE l= value )* ;
	public final Node factor() throws RecognitionException {
		Node ast = null;


		Node f =null;
		Node l =null;

		try {
			// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:573:5: (f= value ( EQ l= value | GR l= value | LE l= value )* )
			// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:573:7: f= value ( EQ l= value | GR l= value | LE l= value )*
			{
			pushFollow(FOLLOW_value_in_factor1796);
			f=value();
			state._fsp--;

			ast = f;
			// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:574:5: ( EQ l= value | GR l= value | LE l= value )*
			loop30:
			while (true) {
				int alt30=4;
				switch ( input.LA(1) ) {
				case EQ:
					{
					alt30=1;
					}
					break;
				case GR:
					{
					alt30=2;
					}
					break;
				case LE:
					{
					alt30=3;
					}
					break;
				}
				switch (alt30) {
				case 1 :
					// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:575:9: EQ l= value
					{
					match(input,EQ,FOLLOW_EQ_in_factor1814); 
					pushFollow(FOLLOW_value_in_factor1818);
					l=value();
					state._fsp--;

					ast = new EqualNode(ast,l);
					}
					break;
				case 2 :
					// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:576:9: GR l= value
					{
					match(input,GR,FOLLOW_GR_in_factor1830); 
					pushFollow(FOLLOW_value_in_factor1834);
					l=value();
					state._fsp--;

					ast = new GreaterOrEqualNode(ast,l);
					}
					break;
				case 3 :
					// C:\\Users\\Mark\\git\\LPeMC\\LPeMC\\FOOL.g:577:9: LE l= value
					{
					match(input,LE,FOLLOW_LE_in_factor1847); 
					pushFollow(FOLLOW_value_in_factor1851);
					l=value();
					state._fsp--;

					ast = new LessOrEqualNode(ast,l);
					}
					break;

				default :
					break loop30;
				}
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
		return ast;
	}
	// $ANTLR end "factor"

	// Delegated rules



	public static final BitSet FOLLOW_exp_in_prog41 = new BitSet(new long[]{0x0000008000000000L});
	public static final BitSet FOLLOW_SEMIC_in_prog43 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LET_in_prog57 = new BitSet(new long[]{0x0000040001100100L});
	public static final BitSet FOLLOW_cllist_in_prog85 = new BitSet(new long[]{0x0000040001100000L});
	public static final BitSet FOLLOW_declist_in_prog90 = new BitSet(new long[]{0x0000000001000000L});
	public static final BitSet FOLLOW_IN_in_prog92 = new BitSet(new long[]{0x0000022724C80000L});
	public static final BitSet FOLLOW_exp_in_prog96 = new BitSet(new long[]{0x0000008000000000L});
	public static final BitSet FOLLOW_SEMIC_in_prog98 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_CLASS_in_cllist141 = new BitSet(new long[]{0x0000000000400000L});
	public static final BitSet FOLLOW_ID_in_cllist145 = new BitSet(new long[]{0x0000000020040000L});
	public static final BitSet FOLLOW_EXTENDS_in_cllist161 = new BitSet(new long[]{0x0000000000400000L});
	public static final BitSet FOLLOW_ID_in_cllist165 = new BitSet(new long[]{0x0000000020000000L});
	public static final BitSet FOLLOW_LPAR_in_cllist190 = new BitSet(new long[]{0x0000004000400000L});
	public static final BitSet FOLLOW_ID_in_cllist210 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_COLON_in_cllist212 = new BitSet(new long[]{0x0000000002400080L});
	public static final BitSet FOLLOW_basic_in_cllist216 = new BitSet(new long[]{0x0000004000000800L});
	public static final BitSet FOLLOW_COMMA_in_cllist234 = new BitSet(new long[]{0x0000000000400000L});
	public static final BitSet FOLLOW_ID_in_cllist238 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_COLON_in_cllist240 = new BitSet(new long[]{0x0000000002400080L});
	public static final BitSet FOLLOW_basic_in_cllist244 = new BitSet(new long[]{0x0000004000000800L});
	public static final BitSet FOLLOW_RPAR_in_cllist266 = new BitSet(new long[]{0x0000000000000200L});
	public static final BitSet FOLLOW_CLPAR_in_cllist282 = new BitSet(new long[]{0x0000000000101000L});
	public static final BitSet FOLLOW_FUN_in_cllist293 = new BitSet(new long[]{0x0000000000400000L});
	public static final BitSet FOLLOW_ID_in_cllist297 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_COLON_in_cllist299 = new BitSet(new long[]{0x0000000002400080L});
	public static final BitSet FOLLOW_basic_in_cllist303 = new BitSet(new long[]{0x0000000020000000L});
	public static final BitSet FOLLOW_LPAR_in_cllist323 = new BitSet(new long[]{0x0000004000400000L});
	public static final BitSet FOLLOW_ID_in_cllist347 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_COLON_in_cllist349 = new BitSet(new long[]{0x0000000022400080L});
	public static final BitSet FOLLOW_type_in_cllist353 = new BitSet(new long[]{0x0000004000000800L});
	public static final BitSet FOLLOW_COMMA_in_cllist375 = new BitSet(new long[]{0x0000000000400000L});
	public static final BitSet FOLLOW_ID_in_cllist379 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_COLON_in_cllist381 = new BitSet(new long[]{0x0000000022400080L});
	public static final BitSet FOLLOW_type_in_cllist385 = new BitSet(new long[]{0x0000004000000800L});
	public static final BitSet FOLLOW_RPAR_in_cllist402 = new BitSet(new long[]{0x0000022734C80000L});
	public static final BitSet FOLLOW_LET_in_cllist423 = new BitSet(new long[]{0x0000040001000000L});
	public static final BitSet FOLLOW_VAR_in_cllist445 = new BitSet(new long[]{0x0000000000400000L});
	public static final BitSet FOLLOW_ID_in_cllist449 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_COLON_in_cllist451 = new BitSet(new long[]{0x0000000022400080L});
	public static final BitSet FOLLOW_type_in_cllist455 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_ASS_in_cllist457 = new BitSet(new long[]{0x0000022724C80000L});
	public static final BitSet FOLLOW_exp_in_cllist461 = new BitSet(new long[]{0x0000008000000000L});
	public static final BitSet FOLLOW_SEMIC_in_cllist483 = new BitSet(new long[]{0x0000040001000000L});
	public static final BitSet FOLLOW_IN_in_cllist487 = new BitSet(new long[]{0x0000022724C80000L});
	public static final BitSet FOLLOW_exp_in_cllist515 = new BitSet(new long[]{0x0000008000000000L});
	public static final BitSet FOLLOW_SEMIC_in_cllist538 = new BitSet(new long[]{0x0000000000101000L});
	public static final BitSet FOLLOW_CRPAR_in_cllist549 = new BitSet(new long[]{0x0000000000000102L});
	public static final BitSet FOLLOW_VAR_in_declist620 = new BitSet(new long[]{0x0000000000400000L});
	public static final BitSet FOLLOW_ID_in_declist624 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_COLON_in_declist626 = new BitSet(new long[]{0x0000000022400080L});
	public static final BitSet FOLLOW_type_in_declist630 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_ASS_in_declist632 = new BitSet(new long[]{0x0000022724C80000L});
	public static final BitSet FOLLOW_exp_in_declist636 = new BitSet(new long[]{0x0000008000000000L});
	public static final BitSet FOLLOW_FUN_in_declist663 = new BitSet(new long[]{0x0000000000400000L});
	public static final BitSet FOLLOW_ID_in_declist667 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_COLON_in_declist669 = new BitSet(new long[]{0x0000000002400080L});
	public static final BitSet FOLLOW_basic_in_declist673 = new BitSet(new long[]{0x0000000020000000L});
	public static final BitSet FOLLOW_LPAR_in_declist691 = new BitSet(new long[]{0x0000004000400000L});
	public static final BitSet FOLLOW_ID_in_declist716 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_COLON_in_declist718 = new BitSet(new long[]{0x0000000022400080L});
	public static final BitSet FOLLOW_type_in_declist722 = new BitSet(new long[]{0x0000004000000800L});
	public static final BitSet FOLLOW_COMMA_in_declist757 = new BitSet(new long[]{0x0000000000400000L});
	public static final BitSet FOLLOW_ID_in_declist761 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_COLON_in_declist763 = new BitSet(new long[]{0x0000000022400080L});
	public static final BitSet FOLLOW_type_in_declist767 = new BitSet(new long[]{0x0000004000000800L});
	public static final BitSet FOLLOW_RPAR_in_declist812 = new BitSet(new long[]{0x0000022734C80000L});
	public static final BitSet FOLLOW_LET_in_declist826 = new BitSet(new long[]{0x0000040001100000L});
	public static final BitSet FOLLOW_declist_in_declist830 = new BitSet(new long[]{0x0000000001000000L});
	public static final BitSet FOLLOW_IN_in_declist832 = new BitSet(new long[]{0x0000022724C80000L});
	public static final BitSet FOLLOW_exp_in_declist857 = new BitSet(new long[]{0x0000008000000000L});
	public static final BitSet FOLLOW_SEMIC_in_declist877 = new BitSet(new long[]{0x0000040000100002L});
	public static final BitSet FOLLOW_basic_in_type911 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_arrow_in_type927 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_INT_in_basic955 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_BOOL_in_basic970 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ID_in_basic987 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LPAR_in_arrow1016 = new BitSet(new long[]{0x0000004022400080L});
	public static final BitSet FOLLOW_type_in_arrow1057 = new BitSet(new long[]{0x0000004000000800L});
	public static final BitSet FOLLOW_COMMA_in_arrow1087 = new BitSet(new long[]{0x0000000022400080L});
	public static final BitSet FOLLOW_type_in_arrow1091 = new BitSet(new long[]{0x0000004000000800L});
	public static final BitSet FOLLOW_RPAR_in_arrow1123 = new BitSet(new long[]{0x0000000000000020L});
	public static final BitSet FOLLOW_ARROW_in_arrow1125 = new BitSet(new long[]{0x0000000002400080L});
	public static final BitSet FOLLOW_basic_in_arrow1129 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_term_in_exp1161 = new BitSet(new long[]{0x0000001840000002L});
	public static final BitSet FOLLOW_PLUS_in_exp1180 = new BitSet(new long[]{0x0000022724C80000L});
	public static final BitSet FOLLOW_term_in_exp1184 = new BitSet(new long[]{0x0000001840000002L});
	public static final BitSet FOLLOW_MINUS_in_exp1198 = new BitSet(new long[]{0x0000022724C80000L});
	public static final BitSet FOLLOW_term_in_exp1202 = new BitSet(new long[]{0x0000001840000002L});
	public static final BitSet FOLLOW_OR_in_exp1215 = new BitSet(new long[]{0x0000022724C80000L});
	public static final BitSet FOLLOW_term_in_exp1219 = new BitSet(new long[]{0x0000001840000002L});
	public static final BitSet FOLLOW_factor_in_term1253 = new BitSet(new long[]{0x0000000080002012L});
	public static final BitSet FOLLOW_MULT_in_term1270 = new BitSet(new long[]{0x0000022724C80000L});
	public static final BitSet FOLLOW_factor_in_term1274 = new BitSet(new long[]{0x0000000080002012L});
	public static final BitSet FOLLOW_DIV_in_term1286 = new BitSet(new long[]{0x0000022724C80000L});
	public static final BitSet FOLLOW_factor_in_term1291 = new BitSet(new long[]{0x0000000080002012L});
	public static final BitSet FOLLOW_AND_in_term1303 = new BitSet(new long[]{0x0000022724C80000L});
	public static final BitSet FOLLOW_factor_in_term1308 = new BitSet(new long[]{0x0000000080002012L});
	public static final BitSet FOLLOW_INTEGER_in_value1335 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_TRUE_in_value1344 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_FALSE_in_value1353 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_NULL_in_value1361 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_NEW_in_value1370 = new BitSet(new long[]{0x0000000000400000L});
	public static final BitSet FOLLOW_ID_in_value1374 = new BitSet(new long[]{0x0000000020000000L});
	public static final BitSet FOLLOW_LPAR_in_value1386 = new BitSet(new long[]{0x0000026724C80000L});
	public static final BitSet FOLLOW_exp_in_value1401 = new BitSet(new long[]{0x0000004000000800L});
	public static final BitSet FOLLOW_COMMA_in_value1416 = new BitSet(new long[]{0x0000022724C80000L});
	public static final BitSet FOLLOW_exp_in_value1420 = new BitSet(new long[]{0x0000004000000800L});
	public static final BitSet FOLLOW_RPAR_in_value1456 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_IF_in_value1471 = new BitSet(new long[]{0x0000000020000000L});
	public static final BitSet FOLLOW_LPAR_in_value1473 = new BitSet(new long[]{0x0000022724C80000L});
	public static final BitSet FOLLOW_exp_in_value1477 = new BitSet(new long[]{0x0000004000000000L});
	public static final BitSet FOLLOW_RPAR_in_value1479 = new BitSet(new long[]{0x0000010000000000L});
	public static final BitSet FOLLOW_THEN_in_value1481 = new BitSet(new long[]{0x0000000000000200L});
	public static final BitSet FOLLOW_CLPAR_in_value1483 = new BitSet(new long[]{0x0000022724C80000L});
	public static final BitSet FOLLOW_exp_in_value1487 = new BitSet(new long[]{0x0000000000001000L});
	public static final BitSet FOLLOW_CRPAR_in_value1489 = new BitSet(new long[]{0x0000000000008000L});
	public static final BitSet FOLLOW_ELSE_in_value1499 = new BitSet(new long[]{0x0000000000000200L});
	public static final BitSet FOLLOW_CLPAR_in_value1501 = new BitSet(new long[]{0x0000022724C80000L});
	public static final BitSet FOLLOW_exp_in_value1505 = new BitSet(new long[]{0x0000000000001000L});
	public static final BitSet FOLLOW_CRPAR_in_value1507 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_NOT_in_value1523 = new BitSet(new long[]{0x0000000020000000L});
	public static final BitSet FOLLOW_LPAR_in_value1525 = new BitSet(new long[]{0x0000022724C80000L});
	public static final BitSet FOLLOW_exp_in_value1530 = new BitSet(new long[]{0x0000004000000000L});
	public static final BitSet FOLLOW_RPAR_in_value1532 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_PRINT_in_value1541 = new BitSet(new long[]{0x0000000020000000L});
	public static final BitSet FOLLOW_LPAR_in_value1543 = new BitSet(new long[]{0x0000022724C80000L});
	public static final BitSet FOLLOW_exp_in_value1547 = new BitSet(new long[]{0x0000004000000000L});
	public static final BitSet FOLLOW_RPAR_in_value1549 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LPAR_in_value1557 = new BitSet(new long[]{0x0000022724C80000L});
	public static final BitSet FOLLOW_exp_in_value1561 = new BitSet(new long[]{0x0000004000000000L});
	public static final BitSet FOLLOW_RPAR_in_value1563 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ID_in_value1574 = new BitSet(new long[]{0x0000000020004002L});
	public static final BitSet FOLLOW_LPAR_in_value1594 = new BitSet(new long[]{0x0000026724C80000L});
	public static final BitSet FOLLOW_exp_in_value1608 = new BitSet(new long[]{0x0000004000000800L});
	public static final BitSet FOLLOW_COMMA_in_value1621 = new BitSet(new long[]{0x0000022724C80000L});
	public static final BitSet FOLLOW_exp_in_value1625 = new BitSet(new long[]{0x0000004000000800L});
	public static final BitSet FOLLOW_RPAR_in_value1657 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_DOT_in_value1666 = new BitSet(new long[]{0x0000000000400000L});
	public static final BitSet FOLLOW_ID_in_value1670 = new BitSet(new long[]{0x0000000020000000L});
	public static final BitSet FOLLOW_LPAR_in_value1683 = new BitSet(new long[]{0x0000026724C80000L});
	public static final BitSet FOLLOW_exp_in_value1700 = new BitSet(new long[]{0x0000004000000800L});
	public static final BitSet FOLLOW_COMMA_in_value1715 = new BitSet(new long[]{0x0000022724C80000L});
	public static final BitSet FOLLOW_exp_in_value1719 = new BitSet(new long[]{0x0000004000000800L});
	public static final BitSet FOLLOW_RPAR_in_value1752 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_value_in_factor1796 = new BitSet(new long[]{0x0000000008210002L});
	public static final BitSet FOLLOW_EQ_in_factor1814 = new BitSet(new long[]{0x0000022724C80000L});
	public static final BitSet FOLLOW_value_in_factor1818 = new BitSet(new long[]{0x0000000008210002L});
	public static final BitSet FOLLOW_GR_in_factor1830 = new BitSet(new long[]{0x0000022724C80000L});
	public static final BitSet FOLLOW_value_in_factor1834 = new BitSet(new long[]{0x0000000008210002L});
	public static final BitSet FOLLOW_LE_in_factor1847 = new BitSet(new long[]{0x0000022724C80000L});
	public static final BitSet FOLLOW_value_in_factor1851 = new BitSet(new long[]{0x0000000008210002L});
}
