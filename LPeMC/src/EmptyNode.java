
public class EmptyNode implements Node{

	  
	  public EmptyNode () {
		  
	  }
	  
	  public String toPrint(String s) {
	    return s+("Null")+"\n";  
	  }
	  
	  public Node typeCheck() {
	    return new EmptyTypeNode();
	  } 
	  
	  public String codeGeneration() {
		return "push -1\n";	
	  }

}
