
public class OrNode implements Node {
	  
	private Node left;
	  private Node right;
	  
	  public OrNode(Node l, Node r){
	    left=l;
	    right=r;
	  }
	  public String toPrint(String s){
	    return s+ "OrNode\n"+left.toPrint(s)+","+right.toPrint(s);
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
	    String l1=FOOLlib.freshLabel();
	    String l2=FOOLlib.freshLabel();
	    return left.codeGeneration() + "push 1\n"            // vado nel label 1 se almeno uno dei 2 termini ha 1 faccio push di 1 e vado in l2
		     + "beq " + l1 + "\n" + right.codeGeneration()   //se entrambi sono diversi da 1, push 0 e vado in l2
		     + "push 1\n"
		     + "beq " + l1 + "\n" + "push 0\n" + "b "    
		     + l2 + "\n" + l1 + ": \n" + "push 1\n" + l2 
		     + ": \n";
	  }
}
