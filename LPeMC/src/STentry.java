
public class STentry {

	private int nl;		// nesting level
	private Node type;
	private String className = null;
	private boolean isMethod = false;	// Variabile usata per identificare i metodi (se è un metodo -> isMethod=true).
	private String methodName= null;
	private int offset;	// per poter leggere il valore scelto a partire dal fp.
	private Node dec;

	public STentry (int n, int o)
	{
		nl=n;
		offset=o;
	}

	public STentry (int n, Node t, int o)
	{
		nl=n;
		type=t;
		offset=o;
	}

	public STentry (Node d, int n, Node t,int os)
	{
		dec=d;
		nl=n;
		type=t;
		offset=os;
	}

	public STentry (Node d, int n)
	{
		dec = d;
		nl = n;
	}

	public STentry() { }

	
	public void addType (Node t)
	{
		type=t;
	}
	public Node getType ()
	{
		return type;
	}
	public void setType(Node s)
	{
		type = s;
	}
	
	public int getOffset ()
	{
		return offset;
	}
	public void setOffset(int off)
	{
		offset = off;
	}
	
	public int getNestinglevel ()
	{
		return nl;
	}

	public Node getDecl() {
		return dec;
	}
	
	public String toPrint(String s) { //
		return s+"STentry: nestlev " + Integer.toString(nl) +"\n"+
		s+"STentry: offset " + Integer.toString(offset) +"\n"+ 
		s+"STentry: type\n" + 
		type.toPrint(s+"  ");  
	}
	
	public void setIsMethod()
	{
		isMethod = true;
	}
	public boolean getIsMethod()
	{
		return isMethod;
	}

	public String getClassName()
	{
		return className;
	}
	public void setClassName(String s)
	{
		className = s;
	}
	
	public String getMethodName() {
		return methodName;
	}
	public void setMethodName(String s)
	{
		methodName = s;
	}

}  