public class IntTypeNode implements Node {
  
  public IntTypeNode () {
  }
  
  public String toPrint(String s) {
	return s+"IntType\n";  
  }
  
  //non utilizzato
  public Node typeCheck() {
    return null;
  }
  
  public String codeGeneration() {
		return "";
  }
  
}  