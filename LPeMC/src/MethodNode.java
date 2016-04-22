import java.util.ArrayList;

public class MethodNode implements Node, DecNode {

  private String id;
  private Node type; 
  private ArrayList<Node> parlist; 
  private Node body;
  private String label;
  
  public MethodNode (String i, Node t) {
    id=i;
    type=t;
  }    
  
  public void addBody(Node b){
	  body=b;
  }
  
  public void addParBody(ArrayList<Node> p, Node b)
  {
	  parlist = p;
	  body    = b;			  
  }
  
  public void addPar (Node p) {
    parlist.add(p);
  }  

  public String toPrint(String s) {
	String parlstr="";
	if (parlist!=null)
		for (Node par:parlist)
			 parlstr+=par.toPrint(s+"  ");
	
    return s+"Method:" + id +"\n"
		   +type.toPrint(s+"  ")
		   +parlstr
           +body.toPrint(s+"  ") ; 
  }
  
  
  public String codeGeneration() {
	String parCode = "";	
	
	String popPar = "";
	String popParNode = "";
	
	for(Node dec:parlist){
		popPar += "pop\n";
	}
	
	//String popArrowTypeNode = "";
	//if(getSymType() instanceof ArrowTypeNode)
	//{
	//	popArrowTypeNode = "pop\n" + "pop\n";
	//}
	
	//////DUBBIO!!!!//////
	
	if(popParNode == "")	
	{
		for(int i=0; i < parlist.size();i++)
		{
			if(((ParNode)parlist.get(i)).getSymType() instanceof ArrowTypeNode)//decNode è corretto? è solo un'interfaccia!
			{
				popParNode += "pop\n" + "pop\n";
				break;
			}
		}
	}
	
	FOOLlib.putCode(
	    "\n"+label+":\n"+		
		"cfp\n"+	// setta il registro $fp / copy stack pointer into frame pointer
	    "lra\n"+   // load from ra sullo stack
		parCode+	// codice delle dichiarazioni
		body.codeGeneration()+
		"srv\n"+	//salvo il risultato in un registro 
		"sra\n"+    //salvo il return address
		"pop\n"+	// pop dell'AL (access link)
		popPar+     //pop dei parametri che ho in parlist
		"sfp\n"+	// ripristino il registro $fp al CL, in maniera che sia l'fp dell'AR del chiamante.
		"lrv\n"+
		"lra\n"+
		"js\n"      //js salta all'indirizzo che è in cima allo stack e salva la prossima istruzione in ra.
    );
	
	
	return "push "+label+"\n";
  }
  
  public Node typeCheck () {
	if (parlist!=null) 
	  for (Node dec:parlist)
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
  
  //Funzioni per l'OO
  
  public String getName() {
	  return id;
  }
  
  public void setLabel(String l){
	  label = l;
  }
}
