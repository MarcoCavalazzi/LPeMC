public class IdNode implements Node {

  private String id;
  private STentry entry;
  private CTentry ctentry = null;
  private int nl;
  
  public IdNode (String i, STentry st, int n) {
    id=i;
    entry=st;
    nl=n;	// il nesting level ci farà capire, atraverso la differenza, se l'ID trovato si riferisce ad una variabile locale o globale.
  }
   
  public IdNode (String i, CTentry ct, int n) {
	  id=i;
	  ctentry=ct;
	  nl=n;
  }
  
  public IdNode ()
  {
	  
  }
  
  public String getName()
  {
	  return id;
  }
  
  public String toPrint(String s) {
	return s+"Id:" + id +" at nestlev "+ nl +"\n" + entry.toPrint(s+"  ") ;  
  }
  
  public Node typeCheck () {
	/*
	  if ((entry.getType() instanceof ArrowTypeNode)) { //
	  System.out.println("Wrong usage of function identifier");
      System.exit(0);
    }
    tolto perchè adesso possiamo usare anche gli arrowtypenode	
    */
	  
	//credo ci sia da aggiungere varList.getType() instance of ArrowTypeNode
    //ma come ottengo la lista dei parametri o delle variabili che possono essere di tipo funzionale?
	if(entry.getType() instanceof ClassTypeNode)
	{
		if(id.equals(entry.getClassName()) || (id.equals(entry.getMethodName())))
		{	
			System.out.println("Id "+id+" already declared");
			System.exit(0);	
		}	
	}
	  
    return entry.getType();
  }
  
  public String codeGeneration() {
	
	if(ctentry != null)
	{
		String getAR="";
		for (int i=0;i<nl-ctentry.getNestinglevel(); i++ )
		  getAR+="lw\n";	
			
		return "push "+entry.getOffset()+"\n"+
	           "lfp\n"+
			   getAR+
			   "add\n"+
	           "lw\n";
	}
	  
	String getAR="";
	for (int i=0;i<nl-entry.getNestinglevel(); i++ )
	  getAR+="lw\n";	
		
	return "push "+entry.getOffset()+"\n"+
           "lfp\n"+
		   getAR+
		   "add\n"+
           "lw\n";
  }
  
}  