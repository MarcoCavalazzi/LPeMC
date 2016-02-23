public class BoolNode implements Node {

  private boolean val;
  
  public BoolNode (boolean n) {
    val=n;
  }
  
  public String toPrint(String s) {
    if (val) return s+"Bool:true\n";
    else return s+"Bool:false\n";  
  }
  
  public Node typeCheck() {
    return new BoolTypeNode();
  }   
  
  public String codeGeneration() {
	return val?"push 1\n":"push 0\n";	// Istruzione che dirà di fare push sullo stack del valore (e andiamo a capo).
  }
         
}  