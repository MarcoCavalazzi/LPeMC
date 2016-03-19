import java.util.ArrayList;

public class CallClassNode implements Node {

	private String id;
	private STentry st; 
	private ArrayList<Node> par = new ArrayList<Node>();
	private int nNewClass;
	
	 public CallClassNode (String i, STentry e, ArrayList<Node> p,int nCl) {
	   id=i;
	   st=e;
	   par = p;
	   nNewClass = nCl;
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
		 ArrowTypeNode classAtn = (ArrowTypeNode)((ClassNode)((ArrowTypeNode)st.getType()).getRet()).typeCheck();
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
		return null;
	}

	
	public String codeGeneration() {
		
		//System.out.println("Generazione CallClassNode");
		  String ret = "";
		  String parCode = "";
		  String NameCl = "";
		  ClassNode obj = ((ClassNode)((ArrowTypeNode)st.getType()).getRet());
		  /*
		   * generazione del codice relativa ai metodi dell'oggetto istanziato
		   */
		  String methods = (obj).codeGeneration();
		  
		  /*
		   * memorizzo nell'heap l'identificatore dell'oggetto
		   * e mi sposto nella locazione successiva dell'heap (la prima libera)
		   */
		  NameCl = "push " + nNewClass + "\n" +
				   "lhp \n" +
				   "sw \n" +
				   "lhp\n" +
				   "push 1\n"+ 
				   "lhp\n"+ //carico l'heap pointer corrente
				   "add\n"+
				   "shp\n";
		  
		  parCode = "";
		  //System.out.println("Class " + obj.getName() + " par num: " + par.size());
		  for(int i = 0; i < par.size() ;i++){
				  parCode += par.get(i).codeGeneration()+
							 "lhp\n"+
							 "sw\n" +
							 "push 1\n"+ 
							 "lhp\n"+ //carico l'heap pointer corrente
							 "add\n"+
							 "shp\n"/*+
							 "lhp\n"+
							 "lw\n"*/;
		  }
		  /*
		   * restituzione della generazione di codice relativa all'identificatore della classe,
		   * seguita dal codice dei suoi parametri (utilizzati nella call dell'istanza) e dei 
		   * relativi metodi di classe
		   */
		  ret= NameCl+
		 	   parCode+
		 	   methods;
		  
		  return ret;
	}

	 public String getClassName(){
		  	//return ((ClassNode)((ArrowTypeNode)st.getType()).getRet()).getName();
	  return null;
	 }
	 
	 
}
