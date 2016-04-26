
public class ClassTypeNode implements Node {

	 private String name;
		
	  public ClassTypeNode(String n) {
		  name = n;
	  }
	  
	  public ClassTypeNode() {
		// TODO Auto-generated constructor stub
	}

	public String getName(){
		  return name;
	  }
	  
	  public String toPrint(String s) {
	        return s+"ClassTypeNode\n";
	  }
	  
	  public Node typeCheck() {
	    return new ClassTypeNode(name);
	  }
	  
	  public String codeGeneration() {
	    return "";
	  }

}
