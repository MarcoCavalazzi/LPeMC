
public class ClassTypeNode implements Node {

	 private String name;
		
	  public ClassTypeNode(String n) {
		  name = n;
	  }
	  
	  public String getName(){
		  return name;
	  }
	  
	  public String toPrint(String s) {
	        return name;
	  }
	  
	  public Node typeCheck() {
	    return new ClassTypeNode(name);
	  }
	  
	  public String codeGeneration() {
	    return "";
	  }

}
