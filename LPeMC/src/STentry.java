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
  
  //funzioni per l'OO
  
  /***
   * Metodo per prelevare la classe corrente relativa all'istanza chiamata e il relativo offset
   * @param className : nome della classe
   * @param name : nome dell'id utilizzato nella chiamata
   * @return : l'offset dell'id settato all'oggetto utilizzato nella chiamata
   */
  public int getInstanceClassIndex(String className, String name) {
	  if(!instancesCounters.containsKey(className)) {
		  return -1;
	  }
	  int counter = instancesCounters.get(className);
	  int curIndex = instancesClasses.indexOf(className+name+counter);
	  instancesCounters.put(className, curIndex >= 0 ? counter + 1 : counter);
	  //System.out.println("curind: " + curIndex + " counter: " + counter);
	  if(curIndex < 0 && counter > 0) {
		  counter--;
	  }
	  return instancesClasses.indexOf(className+name+counter);
  }
  
  /**
   * Metodo per registrare la classe corrente relativa all'istanza chiamata e il relativo offset
   * @param className : nome della classe
   * @param name : nome dell'id utilizzato nella chiamata
   * @param offset : offset della variabile utilizzata nella chiamata all'oggetto
   */
  public void putInstanceClassAndOffset(String className, String name, int offset) {
	  instancesCounters.put(className, 0);
	  int counter = 0;
	  if(instancesInsertCounters.get(className) != null){
		  counter++;
	  }
	  instancesInsertCounters.put(className, counter);
	  //System.out.println("PUT " + className+name + counter + " OS " + offset);
	  putInstanceClass(className + name + counter);
	  putInstanceOffset(offset);
  }
  
  public void setIsMethod()
  {
	  isMethod = true;
  }
  
  public String getClassName()
  {
	  return className;
  }
  public String getInstanceClass (int index)
  {return instancesClasses.get(index);}
  
  private void putInstanceClass(String className) {
	  instancesClasses.add(className);
  }
  
  public int getInstanceOffset (int index)
  {return instancesOffset.get(index);}
  
  private void putInstanceOffset(int os) {
	  instancesOffset.add(os);
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