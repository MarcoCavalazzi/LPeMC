public class NatNode implements Node {

  private Integer val;
  
  public NatNode (Integer n) {
    val=n;
  }
  
  public String toPrint(String s) {
    return s+"Nat:" + Integer.toString(val) +"\n";  
  }
  
  public Node typeCheck() {
    return new IntTypeNode();
  } 
  
  public String codeGeneration() {
	return "push "+val+"\n";	// aggiungiamo un'istruzione che dirà di fare push sullo stack del valore (e andiamo a capo).
  }
  
}  