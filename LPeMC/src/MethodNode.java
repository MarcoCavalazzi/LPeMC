import java.util.ArrayList;

public class MethodNode implements Node, DecNode {

  private String id;
  private Node type; 
  private ArrayList<Node> parlist; 
  private Node body;
  
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
  
// Per capire questa funzione vedi file "progettiamo il nostro layout" nell'esercitazione 12_04.
  public String codeGeneration() {
	String parCode = "";
	String funl=FOOLlib.freshFunLabel();		
	String popPar = "";
	for(Node dec:parlist){
		popPar += "pop\n";
	}
	
	FOOLlib.putCode(
	    "\n"+funl+":\n"+		
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
	
	/* codice del progetto funzionante:
	//inserisco la serie di istruzioni della funzione che poi verranno utilizzate
    //nel letinNode
    FOOLlib.putFunCode(
    				"\n"+funl+":\n"+
                    "cfp\n"+ //aggiorniamo il frame pointer
                    "lra\n"+ //carichiamo il return address
                    decCode+ //preparo le dichiarazioni locali della funzione
                    body.codeGeneration()+ //eseguo il corpo della funzione
                    "srv\n"+ //gestisco il return value(registro)
                    popDec+ //carico le dichiarazioni locali della funzione
                    "sra\n"+ //ci salviamo il return address
                    "pop\n"+ //butto via l'access link
                    popPar+  //prelievo dei i parametri
                    "sfp\n"+ //memorizzo il frame pointer a cui ero arrivato
                    "lrv\n"+ //mi preparo a ritornare
                    "lra\n"+ //ritorno all'AR precedente
                    "js\n"
                   );*/
	
	return "push "+funl+"\n";
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
  
}
