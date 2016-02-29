import java.util.ArrayList;

public class FunNode implements Node, DecNode {

  private String id;
  private Node type; 
  private ArrayList<Node> parlist = new ArrayList<Node>(); 
  private ArrayList<Node> declist; 
  private Node body;
  
  public FunNode (String i, Node t) {
    id=i;
    type=t;
  }
  
  public void addDec (ArrayList<Node> d) {
	  declist=d;
  }  
  
  public void addBody(Node b){
	  body=b;
  }
  
  public void addPar (Node p) {
    parlist.add(p);
  }  
  
  public String toPrint(String s) {
	String parlstr="";
	for (Node par:parlist)
	  parlstr+=par.toPrint(s+"  ");
	String declstr="";
	if (declist!=null) 
	  for (Node dec:declist)
	    declstr+=dec.toPrint(s+"  ");
    return s+"Fun:" + id +"\n"
		   +type.toPrint(s+"  ")
		   +parlstr
	   	   +declstr
           +body.toPrint(s+"  ") ; 
  }
  
// Per capire questa funzione vedi file "progettiamo il nostro layout" nell'esercitazione 12_04.
  public String codeGeneration() {
	
	String funl=FOOLlib.freshFunLabel();
	
	String decCode = "";
	for(Node dec:declist){
		decCode += dec.codeGeneration();	// creiamo il codice delle dichiarazioni
	}
	
	String popDec = "";
	for(Node dec:declist){
		popDec += "pop\n";
	}
	
	String popPar = "";
	for(Node dec:parlist){
		popPar += "pop\n";
	}
	
	FOOLlib.putCode(
	    funl+":\n"+
		"cfp\n"+	// setta il registro $fp
	    "lra\n"+
		decCode+	// codice delle dichiarazioni
		body.codeGeneration()+
		"srv\n"+
		popDec+
		"sra\n"+
		"pop\n"+	// pop dell'AL
		popPar+
		"sfp\n"+	// ripristino il registro $fp al CL, in maniera che sia l'fp dell'AR del chiamante.
		"lrv\n"+
		"lra\n"+
		"js\n"
    );
	
	return "push "+funl+"\n";
  }
  
  //valore di ritorno non utilizzato
  public Node typeCheck () {
	if (declist!=null) 
	  for (Node dec:declist)
		dec.typeCheck();
    if ( !(FOOLlib.isSubtype(body.typeCheck(),type)) ){
      System.out.println("Wrong return type for function "+id);
      System.exit(0);
    }  
    return null;
  }

@Override
public Node getSymType() {
	
	return type;
}
  
}  