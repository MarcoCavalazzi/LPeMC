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
  
  public void addDecBody(ArrayList<Node> d, Node b)
  {
	  declist = d;
	  body = b;
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
	String decCode = "";
	String popDec = "";
	String popParNode = "";
	String funl=FOOLlib.freshFunLabel();
	
	if(declist != null){//aggiunto il controllo se la nostra declist non risulti vuota
		for(Node dec:declist){
			decCode += dec.codeGeneration();	// creiamo il codice delle dichiarazioni
		}
		
		// Marco: Scusate l'ignoranza, ma vorrei capire meglio il funzionamento di FunNode:
		// Qui di seguito aggiungiamo già dei "pop", 
		//  dobbiamo forse togliere questi due cicli su "declist" e "parlist" visto che facciamo già il controllo con i 2 "pop" extra (vedi più sotto)?
		
		for(Node dec:declist){
			popDec += "pop\n";
		}
	}
	
	String popPar = "";
	for(Node dec:parlist){
		popPar += "pop\n";
	}
	
	String popArrowTypeNode = "";
	if(getSymType() instanceof ArrowTypeNode)
	{
		popArrowTypeNode = "pop\n" + "pop\n";
	}
	// Marco: aggiunto controllo if per evitare di inserire più "pop" del dovuto e convertiti tutti gli assegnamenti di popArrowTypeNode da "+=" a "=".
	

	if(popDec == "" && declist!=null)	
	{
		for(int i=0; i < declist.size();i++)
		{
			if(((VarNode)declist.get(i)).getSymType() instanceof ArrowTypeNode)//decNode è corretto? è solo un'interfaccia!
			{
				popDec = "pop\n" + "pop\n";
				break;
			}
		}
	}
	
	//////DUBBIO!!!!//////
	
	if(popParNode == "")	
	{
		for(int i=0; i < parlist.size();i++)
		{
			if(((ParNode)parlist.get(i)).getSymType() instanceof ArrowTypeNode)//decNode è corretto? è solo un'interfaccia!
			{
				popParNode = "pop\n" + "pop\n";
				break;
			}
		}
	}
	
	
	
	FOOLlib.putCode(
	    "\n"+funl+":\n"+		
		"cfp\n"+	// setta il registro $fp / copy stack pointer into frame pointer
	    "lra\n"+   // load from ra sullo stack
		decCode+	// codice delle dichiarazioni
		body.codeGeneration()+
		"srv\n"+	//salvo il risultato in un registro 
		//popDec+		//devo svuotare lo stack, e faccio pop tanti quanti sono le var/fun dichiarate
		
		
		"sra\n"+    //salvo il return address
		"pop\n"+	// pop dell'AL (access link)
		popPar+     //pop dei parametri che ho in parlist
		popParNode+ //dubbio!!
		popDec+
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