import java.util.ArrayList;

public class ClassCallNode implements Node {

	private String id;
	private STentry entry; 
	private STentry methodEntry;
	private ArrayList<Node> par = new ArrayList<Node>();
	//private int nNewClass;
	private int nl;
	
	
	
	 public ClassCallNode (String i, STentry e,STentry me, ArrayList<Node> p, int n) {
	   id=i;
	   entry=e;
	   methodEntry = me;
	   par = p;
	   nl = n;
	   
	}
	public String toPrint(String s) {
		
		String str = s+"CALL CLASS " + id + " \n"+s+"  Parameters type: \n";
		 for(int j=0;j < par.size();j++){
		     str += s+"   "+par.get(j).toPrint(s+" ");
		    }
		 return str;
	}

	
	public Node typeCheck() {
		/*
		 ArrowTypeNode classAtn = (ArrowTypeNode)((ClassNode)((ArrowTypeNode)entry.getType()).getRet()).typeCheck();
		  if(classAtn.getPar().size() != par.size()) {
			  System.out.println("Wrong parameter's number for constructor of " + id);
		}
		 
		for(int i = 0; i < par.size(); i++) {
			  Node curP = par.get(i);
			  if (!(FOOLlib.isSubtype(curP.typeCheck(), classAtn.getPar().get(i).typeCheck()))){
			        System.out.println("Wrong type for constructor of " + id);
			        //System.exit(0); 
			  }
		  }
		  return new ClassTypeNode(((ClassNode)classAtn.getRet()).getName());
		  
		
		*/
		return entry.getType();
	}

	
	public String codeGeneration() {
		
		  String parCode = "";	// codice per la prima parte dell'activation record (vedi file "progettiamo il nostro layout" nell'esercitazione 12_04).
		  for(int i=par.size()-1; i>=0; i--){
			  parCode += par.get(i).codeGeneration();
		  }
		  
		  String getAR = "";
		  for(int i=0; i< nl-methodEntry.getNestinglevel(); i++){
			  getAR += "lw\n";
		  }
		
		  return "lfp\n"+		// CL
			parCode+	// parametri
			"lfp\n"+	
			getAR+		// AL ;
			"push "+entry.getOffset()+"\n"+
			"lfp\n"+
			getAR+
			"add\n"+
			"lw\n"+		
			"js\n";	
		  
//		//System.out.println("Generazione CallClassNode");
//		  String ret = "";
//		  String parCode = "";
//		  String NameCl = "";
//		 // ClassNode obj = ((ClassNode)((ArrowTypeNode)entry.getType()).getRet());
//		  /*
//		   * generazione del codice relativa ai metodi dell'oggetto istanziato
//		   */
//		  //String methods = (obj).codeGeneration();
//		  
//		  /*
//		   * memorizzo nell'heap l'identificatore dell'oggetto
//		   * e mi sposto nella locazione successiva dell'heap (la prima libera)
//		   */
//		  NameCl = "push " + nNewClass + "\n" +
//				   "lhp \n" +
//				   "sw \n" +
//				   "lhp\n" +
//				   "push 1\n"+ 
//				   "lhp\n"+ //carico l'heap pointer corrente
//				   "add\n"+
//				   "shp\n";
//		  
//		  parCode = "";
//		  //System.out.println("Class " + obj.getName() + " par num: " + par.size());
//		  for(int i = 0; i < par.size() ;i++){
//				  parCode += par.get(i).codeGeneration()+
//							 "lhp\n"+
//							 "sw\n" +
//							 "push 1\n"+ 
//							 "lhp\n"+ //carico l'heap pointer corrente
//							 "add\n"+
//							 "shp\n"/*+
//							 "lhp\n"+
//							 "lw\n"*/;
//		  }
//		  /*
//		   * restituzione della generazione di codice relativa all'identificatore della classe,
//		   * seguita dal codice dei suoi parametri (utilizzati nella call dell'istanza) e dei 
//		   * relativi metodi di classe
//		   */
//		  ret= NameCl+
//		 	   parCode;
//		 	  // methods;
//		  
//		  return ret;
		
	}

	 public String getClassName(){
		 return ((ClassNode)((ArrowTypeNode)entry.getType()).getRet()).getName();
	  
	 }
	 
	 
}
