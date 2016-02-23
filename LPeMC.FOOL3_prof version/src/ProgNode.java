public class ProgNode implements Node {

  private Node exp;
  
  public ProgNode (Node e) {
    exp=e;
  }
  
  public String toPrint(String s) {
    
    return "Prog\n" + exp.toPrint("  ") ;
  }
  
  public Node typeCheck() {
    return exp.typeCheck();
  }  
  
  public String codeGeneration() {
	return exp.codeGeneration()+
		   "halt\n";
  }
    
}  