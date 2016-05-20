import java.util.ArrayList;
import java.util.LinkedHashMap;

public class STentry {
 
  private int nl;		// nesting level
  private Node type;
  private String className = null;
  private boolean isMethod = false;
  private String methodName= null;
  private int offset;	// per poter leggere il valore scelto a partire dal fp.
  private Node dec;
  //OO
  private ArrayList<Integer> instancesOffset = new ArrayList<Integer>();
  private ArrayList<String> instancesClasses = new ArrayList<String>();
  private LinkedHashMap<String, Integer> instancesCounters = new LinkedHashMap<String, Integer>();
  private LinkedHashMap<String, Integer> instancesInsertCounters = new LinkedHashMap<String, Integer>();
  
  public STentry (int n, int o)
  {nl=n;
   offset=o;}
  
  public STentry (int n, Node t, int o)
  {nl=n;
   type=t;
   offset=o;
   }
  
  public STentry (Node d, int n, Node t,int os)
  {dec=d;
   nl=n;
   type=t;
   offset=os;}
  
  public STentry (Node d, int n)
  {
	  dec = d;
	  nl = n;
  }
   
  public void addType (Node t)
  {type=t;}
  
  public Node getType ()
  {return type;}
  
  public int getOffset ()
  {return offset;}
  
  public int getNestinglevel ()
  {return nl;}
  
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
  
  public String getClassName()
  {
	  return className;
  }
  

  public String getMethodName() {
	return methodName;
  }
  
  public void setMethodName(String s)
  {
	  methodName = s;
  }
  
  public void setClassName(String s)
  {
	  className = s;
  }

  
}  