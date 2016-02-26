public class BoolTypeNode implements Node {
  
  public BoolTypeNode () {
  }
  
  public String toPrint(String s) {
	return s+"BoolType\n";  
  }
    
  //non utilizzato
  public Node typeCheck() {
    return null;	// volendo si può restituire BoolNode(false);
  }
  
  public String codeGeneration() {
		return "";
  }
    
}  