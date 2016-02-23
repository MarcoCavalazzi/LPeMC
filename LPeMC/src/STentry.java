public class STentry {
 
  private int nl;		// nesting level
  private Node type;
  private int offset;	// per poter leggere il valore scelto a partire dal fp.
 
  public STentry (int n, int o)
  {nl=n;
   offset=o;}
  
  public STentry (int n, Node t, int o)
  {nl=n;
   type=t;
   offset=o;}
   
  public void addType (Node t)
  {type=t;}
  
  public Node getType ()
  {return type;}
  
  public int getOffset ()
  {return offset;}
  
  public int getNestinglevel ()
  {return nl;}
  
  public String toPrint(String s) { //
	   return s+"STentry: nestlev " + Integer.toString(nl) +"\n"+
		      s+"STentry: offset " + Integer.toString(offset) +"\n"+ 
			  s+"STentry: type\n" + 
			  type.toPrint(s+"  ");  
  }
  
}  