import java.util.ArrayList;

public class LetInNode implements Node {

  private ArrayList<Node> declist;
  private ArrayList<Node> cllist = null;
  private Node exp;
  
  public LetInNode (ArrayList<Node> d, Node e) {
	declist=d;
    exp=e;
  }
  
  public LetInNode (ArrayList<Node> d,ArrayList<Node> cl, Node e) {
	  declist=d;
	  cllist = cl;
	  exp=e;
  }
  
  public String toPrint(String s) {
	String declstr="";
	String clliststr="";
	
	if(cllist != null)
		for(Node cl:cllist)
			clliststr += cl.toPrint(s+"  ");
	
	if(declist != null)
	{	
		for (Node dec:declist)
			declstr+=dec.toPrint(s+"  ");
	}
	return s+"Let\n" + clliststr + declstr + "In\n"+ exp.toPrint(s+"  ") +"EndLetIn\n"; 
  }
  
  public Node typeCheck () {
	  
    for (Node dec:declist)
      dec.typeCheck();
    
    if(cllist != null)
    	for(Node cl:cllist)
			  cl.typeCheck();
    	
    return exp.typeCheck();
    
    
    
    
  }
  
  // Questa funzione stamperà un valore per ognuna delle dichiarazioni, mostrando lo stato dello stack.
  public String codeGeneration() {
	
	  String clcode="";
	  if(cllist!=null){
		  for(Node cl:cllist)
			  clcode+=cl.codeGeneration();
	  }
	  String declcode="";
	  for (Node dec:declist)
	  declcode+=dec.codeGeneration();
	
	return "push 0\n"+
		   clcode+
    	   declcode+
    	   exp.codeGeneration()+
 		   "halt\n"+
    	   FOOLlib.getCode();
  }
    
}  