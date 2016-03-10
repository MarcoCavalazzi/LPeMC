import java.util.ArrayList;

public class LetInNode implements Node {

  private ArrayList<Node> declist;
  private Node exp;
  
  public LetInNode (ArrayList<Node> d, Node e) {
    declist=d;
    exp=e;
  }
  
  public String toPrint(String s) {
	String declstr="";
    for (Node dec:declist)
      declstr+=dec.toPrint(s+"  ");
	return s+"Let\n" + declstr +"In\n"+ exp.toPrint(s+"  ") +"EndLetIn"; 
  }
  
  public Node typeCheck () {
    for (Node dec:declist)
      dec.typeCheck();
    return exp.typeCheck();
  }
  
  // Questa funzione stamperà un valore per ognuna delle dichiarazioni, mostrando lo stato dello stack.
  public String codeGeneration() {
	String declcode="";
	for (Node dec:declist)
	  declcode+=dec.codeGeneration();
    return "push 0\n"+
    	   declcode+
    	   exp.codeGeneration()+
 		   "halt\n"+
    	   FOOLlib.getCode();
  }
    
}  