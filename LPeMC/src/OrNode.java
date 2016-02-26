
public class OrNode implements Node {
	  
	private Node left;
	  private Node right;
	  
	  public OrNode(Node l, Node r){
	    left=l;
	    right=r;
	  }
	  public String toPrint(String s){
	    return s+ "OrNode"+left.toPrint(s)+","+right.toPrint(s);
	  }
	  public Node typeCheck(){
		// Type checking. Se ci sono due sottotipi di BOOL va avanti, altrimenti si ferma.
	    if (! (FOOLlib.isSubtype(left,new BoolTypeNode()))  &&  (FOOLlib.isSubtype(right,new BoolTypeNode())) ){
	    	System.out.println("Non BOOL in OR operation");
	    	System.exit(0);
	    }
	    
	    return new BoolTypeNode();
	  }
	  
	  public String codeGeneration(){
		  return left.codeGeneration()+right.codeGeneration()+"add\n"; 
	  }
}
