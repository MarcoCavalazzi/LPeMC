import java.util.ArrayList;

public class CallNode implements Node {

  private String id;
  private STentry entry; 
  private ArrayList<Node> parlist; 
  private int nl;
  
  public CallNode (String i, STentry e, ArrayList<Node> p, int n) {
    id=i;
    entry=e;
    parlist = p;
    nl =n;
  }
  
  public String toPrint(String s) {  //
    String parlstr="";
	for (Node par:parlist)
	  parlstr+=par.toPrint(s+"  ");		
	return s+"Call:" + id +" at nestlev "+ nl +"\n" 
           +entry.toPrint(s+"  ")
           +parlstr;        
  }
  
  public Node typeCheck () {  // 
	 ArrowTypeNode t=null;
     if (entry.getType() instanceof ArrowTypeNode) t=(ArrowTypeNode) entry.getType(); 
     else {
       System.out.println("Invocation of a non-function "+id);
       System.exit(0);
     }
   //parlist sono i figli del CallNode
     ArrayList<Node> p = t.getParList();	// otteniamo la lista dei tipi dei parametri formali
     if ( !(p.size() == parlist.size()) ) {	// controlliamo che il numero dei parametri formali sia uguale al numero di aprametri passati in input.
       System.out.println("Wrong number of parameters in the invocation of "+id);
       System.exit(0);
     } 
  // ora controlliamo che il tipo degli argomenti sia minore o uguale al p.get (che è già un tipo, il tipo del parametro formale che ho recuperato dall'elenco che era dentro al TypNode)
     for (int i=0; i<parlist.size(); i++) 
       if (
    		  // !(FOOLlib.isSubtype( (parlist.get(i)).typeCheck(), p.get(i)) ) 
    		   !(FOOLlib.isSubtype((p.get(i)),(parlist.get(i)).typeCheck())) //nei parametri il nodo a deve essere supertipo perchè applichiamo la controvarianza
    		   ) {
         System.out.println("Wrong type for "+(i+1)+"-th parameter in the invocation of "+id);
         System.exit(0);
       } 
     return t.getRet();
  }
  
  public String codeGeneration(){
	  // fp al frame del chiamante e poi i parametri in ordine inverso
	  // -> ciclo di creazione di una stringa
	  String parCode = "";	// codice per la prima parte dell'activation record (vedi file "progettiamo il nostro layout" nell'esercitazione 12_04).
	  for(int i=parlist.size()-1; i>=0; i++){
		  parCode += parlist.get(i).codeGeneration();
	  }
	  
	  String getAR = "";
	  for(int i=0; i<nl-entry.getNestinglevel(); i++){
		  getAR += "lw\n";
	  }
	  
	  return "lfp\n"+		// CL
	  			parCode+	// parametri
	  			"lfp\n"+	
	  			getAR+		// AL ;
	  			"push "+entry.getOffset()+"\n"+
	  			"lfp\n"+
	  			getAR+
	  			"add\n"+
	  			"lw\n"+		// //recupera indirizzo  AL:address (fp) di AR dichiarazione (vedi file progettiamo nostro layout.txt)
	  			"js\n";		// salto
  }
    
}  