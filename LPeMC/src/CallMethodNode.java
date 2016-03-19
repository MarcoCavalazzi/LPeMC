import java.util.ArrayList;

public class CallMethodNode implements Node {

	private String id;
	  private STentry st; 
	  private STentry stRealCl; 
	  private ArrayList<Node> par = new ArrayList<Node>(); 
	  private String varName;
	  
	  public CallMethodNode (String i, STentry e, STentry realCl, ArrayList<Node> p, String varN) {
	   id=i;
	   st=e;
	   stRealCl = realCl;
	   par = p;
	   varName = varN;
	  }
	  
	  public String toPrint(String s) {
		  String str = s+"CALL METHOD " + id + " OF CLASS " + ((ClassNode)((ArrowTypeNode)stRealCl.getType()).getRet()).getName() + " \n"+s+"  Parameters type: \n";
		  for(int j=0;j < par.size();j++){
		      str += s+"   "+par.get(j).toPrint(s+" ");
		    }
		    str += s+"  Return type: \n"+s+((ArrowTypeNode)st.getType()).getRet().toPrint(s+" ");
		  return str;
	  }
	  
	  public Node typeCheck () {
		  if(((ArrowTypeNode)st.getType()).getPar().size() != par.size()) {
			  System.out.println("Wrong parameter's number for method " + id);
		  }
		  for(int i = 0; i < par.size(); i++) {
			  if(!FOOLlib.isSubtype(par.get(i).typeCheck(), ((ArrowTypeNode)st.getType()).getPar().get(i))) {
				  System.out.println("Wrong type for method " + id);
			  }
		  }
		  return ((ArrowTypeNode)st.getType()).getRet();
	  }

	  public String codeGeneration() {
		  //System.out.println("Generazione del CallMethodNode");
		  
		  /*
		   * recupero della classe che contiene il metodo richiamato e del relativo indirizzo nell'heap
		   */		 
		  ClassNode realClNode = (ClassNode)((ArrowTypeNode)stRealCl.getType()).getRet();
		//  int clIndex = FOOLlib.checkClassIndex(realClNode.getName()+"-"+varName) ? FOOLlib.getClassIndex(realClNode.getName()+"-"+varName) : 0;
		  /*
		   * se non vi è l'indirizzo della classe all'interno dell'heap, viene ricercata l'indirizzo della variabile istanziata
		   */
		//  if(!FOOLlib.checkClassIndex(realClNode.getName()+"-"+varName)){
			  //System.out.println("Beccato -> " + FOOLlib.searchLastClassIndexed(realClNode.getName()));
		//	  clIndex = FOOLlib.getClassIndex(FOOLlib.searchLastClassIndexed(realClNode.getName()));
		 // }
		  
		  //System.out.println("ClIndex: " + clIndex +" of " + realClNode.getName() + " -> " + varName);
		  String parCode = "";
		  for(int i = par.size()-1; i >=0 ;i--){
			  parCode += par.get(i).codeGeneration();
		  }
		  //int clParSize = FOOLlib.getClassParamSize(realClNode.getName());
		  //System.out.println("Real CL: " + realClNode.getName()  + " ---> " + id + " PARSIZE " + clParSize + " CLIND "+ clIndex + " ENTRYOS " + st.getOffset());
		  
		  /*
		   * caricamento dei parametri del metodo, posizionamento all'indirizzo di memoria del metodo richiamato
		   * e caricamento della label associata a cui "jumpare" nella memoria per l'esecuzione
		   */
		  /*
		  return  "lfp\n" + 
			  		parCode+
			  		"lfp\n" + 
			         "push " + (clIndex + clParSize+st.getOffset()) + "\n" +
			         "lw\n" +
			         "js\n"; 
			         */
		  return null;
	  }

}
