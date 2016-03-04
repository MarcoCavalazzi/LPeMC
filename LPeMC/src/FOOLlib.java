public class FOOLlib {
	// classe usata per consentire di mettere il booleano, un sottotipo di un altro tipo, sia utilizzato laddove ci si aspetterebbe un intero.
	//valuta se il tipo "a" è <= al tipo "b", dove "a" e "b" sono tipi di base: int o bool
	
  private static int labCount=0;
  
  private static int funLabCount=0;
  
  private static String funCode="";
  
  //valuta se il tipo "a" e' <= al tipo "b", dove "a" e "b" sono tipi di base: int o bool
  public static boolean isSubtype (Node a, Node b) {
	  boolean ret = false;
	  boolean ret2 = false;
	  if((a instanceof ArrowTypeNode) && (b instanceof ArrowTypeNode))
	  {
		  ret = isSubtype(((ArrowTypeNode)a).getRet(), b);
		  /*
		  for(int i=0; i < (ArrowTypeNode)a).getPar().getSize(); i++)
		  ret2 = isSubtype(b, ((ArrowTypeNode)a).getPar().get(i));
		  */
		 // return ( ((ArrowTypeNode) a).getPar().equals(((ArrowTypeNode) b).getRet()));
		  return ret = true;
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