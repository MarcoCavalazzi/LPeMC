import java.util.ArrayList;

public class FOOLlib {
	// classe usata per consentire di mettere il booleano, un sottotipo di un altro tipo, sia utilizzato laddove ci si aspetterebbe un intero.
	//valuta se il tipo "a" è <= al tipo "b", dove "a" e "b" sono tipi di base: int o bool
	
  private static int labCount=0;
  
  private static int funLabCount=0;
  
  private static String funCode="";
  
  //valuta se il tipo "a" e' <= al tipo "b", dove "a" e "b" sono tipi di base: int o bool
  public static boolean isSubtype (Node a, Node b) {
	  /*
	  boolean ret = false;
	  boolean ret2 = false;
	  if((a instanceof ArrowTypeNode) && (b instanceof ArrowTypeNode))
	  {
		  ret = isSubtype(((ArrowTypeNode)a).getRet(), b);
		  
		  //for(int i=0; i < (ArrowTypeNode)a).getPar().getSize(); i++)
		  //ret2 = isSubtype(b, ((ArrowTypeNode)a).getPar().get(i));
		  
		 // return ( ((ArrowTypeNode) a).getPar().equals(((ArrowTypeNode) b).getRet()));
		  return ret = true;
	  }
	  */
	  // MARCO: Io penso che il codice dovrebbe essere così:
	  Node retA;
	  Node retB;
	  if((a instanceof ArrowTypeNode) && (b instanceof ArrowTypeNode))
	  {
		  // Sono entrambi elementi di tipo funzionale. 
		  // Controlliamo i tipi dei loro valori di ritorno.
		  retA = ((ArrowTypeNode)a).getRet();	// valore di ritorno della prima funzione
		  retB = ((ArrowTypeNode)b).getRet();	// valore di ritorno della seconda funzione
		  // Confrontiamo i tipi dei due elementi. Devono essere identici per poter proseguire, altrimenti ci blocchiamo.
		  if( !(retA.getClass().equals(retB.getClass())) )	// Since each class is like a singleton - there's only one instance of each Class per JVM - it is even possible to use an identity comparison "=="
		  {
			  return false;	// Se siamo qui è perché le due classi sono differenti.
		  }
		  
		  // Ora controlliamo i tipi dei parametri richiesti in input. Li controlliamo a coppie, se anche solo una coppia ha elementi di classi diverse interrompiamo ritornando "false".
		  ArrayList<Node> parListA = ((ArrowTypeNode)a).getParList();
		  ArrayList<Node> parListB = ((ArrowTypeNode)b).getParList();
		  if(parListA.size() != parListB.size()){ return false; }	// Per prima cosa il numero di parametri richiesti in ingresso deve essere lo stesso per entrambi.
		  for(int i=0; i<parListA.size(); i++){
			  if( !(parListA.get(i).getClass().equals( parListB.get(i).getClass() ) ) )
			  {
				  // De parametri presi allo stesso indice dalle due liste appartengono a classi differenti.
				  return false;
			  }
		  }
		  
		  return true;	// Le relazioni di co-variazna sui parametri di ritorno e quelle di contro-varianza sui parametri in ingresso sono rispettate.
	  }
	  
	  
    return a.getClass().equals(b.getClass())
    		|| ( (a instanceof BoolTypeNode) && (b instanceof IntTypeNode)  		  		   
    	       ); //
  } 
  //non ho idea se vada bene
  public static String freshLabel() {
	return "label"+(labCount++);	  
  }
  
  public static String freshFunLabel() {
	return "function"+(funLabCount++);	  
  }
  
  public static void putCode(String c) {
	funCode+="\n"+c;
  }
  
  public static String getCode() {
	return funCode;
  }
}