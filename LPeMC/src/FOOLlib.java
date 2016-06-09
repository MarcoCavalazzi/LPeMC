import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Set;

public class FOOLlib {
	// classe usata per consentire di mettere il booleano, un sottotipo di un altro tipo, sia utilizzato laddove ci si aspetterebbe un intero.
	//valuta se il tipo "a" � <= al tipo "b", dove "a" e "b" sono tipi di base: int o bool

	private static int labCount=0;
	//private static int newlabel=0;  questi 2 campi noi li abbiamo chiamati labCount e funLabCount
	// private static int newFunctionlabel=0;
	private static int funLabCount=0; 

	private static String funCode="";

	public static HashMap<String,Integer> objectPointerMap = new HashMap<String,Integer>();
	public static int objectPointer = 0;

	//OO
	/**
	 * Campo pubblico relativo alla costante true nel codice eseguibile
	 */
	public static int TRUE=1;
	/**
	 * Campo pubblico relativo alla costante false nel codice eseguibile
	 */
	public static int FALSE=0;

	private static HashMap<String,String> superType = new HashMap<String,String>();

	private static LinkedHashMap<String, LinkedHashMap<String, String>> dtmc = new LinkedHashMap<String, LinkedHashMap<String, String>>();
	private static LinkedHashMap<String, Integer> classIndex = new LinkedHashMap<String, Integer>();
	private static LinkedHashMap<String, String> classHierarchy = new LinkedHashMap<String, String>();
	private static ArrayList<String> classInstances = new ArrayList<String>();
	private static ArrayList<AttributeTuple> parTuples = new ArrayList<AttributeTuple>();
	private static LinkedHashMap<String, Integer> parOnlyOfClass = new LinkedHashMap<String, Integer>();
	private static LinkedHashMap<String, ArrayList<Node>> classMethods = new LinkedHashMap<String, ArrayList<Node>>();
	private static LinkedHashMap<String, ArrayList<Node>> classParameters = new LinkedHashMap<String, ArrayList<Node>>();
	private static ArrayList<String> clInstance = new ArrayList<String>();
	private static String classCode = "";
	private static String curFunClassName;
	private static int lastClassSize = 0;
	private static LinkedHashMap<String, ClassCallNode> varsAndCallClassNode = new LinkedHashMap<String, ClassCallNode>();
	private static ArrayList<String> realVarType = new ArrayList<String>();
	private static int varAndCallIndex = 0;
	private static String lastVarNameForClass;

	//valuta se il tipo "a" e' <= al tipo "b", dove "a" e "b" sono tipi di base: int o bool
	public static boolean isSubtype (Node a, Node b) {
		if(a instanceof ClassTypeNode && b instanceof ClassTypeNode)
		{
			// initial check that controls if the classes are the same.
			if( ((ClassTypeNode)a).getName().equals(((ClassTypeNode)b).getName())  )
			{
				return true;
			}

			// We will now check all the parents (super-classes) of 'b' to see if they match with 'a'.
			String tmp = "";
			
			tmp = superType.get( ((ClassTypeNode)b).getName());
			
			if( ((ClassTypeNode)a).getName().equals(tmp))
			{
				return true;
			}
			
			while(tmp != null)
			{
				tmp = superType.get(tmp);

				if( ((ClassTypeNode)a).getName().equals(tmp) )
				{
					return true;
				}
			}
			
			return false;
		}
		
		if(a instanceof EmptyTypeNode && b instanceof ClassTypeNode)
		{
			return true;
		}
		
		if( (a instanceof EmptyTypeNode && b instanceof BoolTypeNode) ||
			(a instanceof BoolTypeNode && b instanceof EmptyTypeNode)
		){
			return false;
		}
		
		if( a instanceof EmptyTypeNode && b instanceof EmptyTypeNode ){
			return true;
		}
		
		
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
		// MARCO: Io penso che il codice dovrebbe essere cos�:
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
				return false;	// Se siamo qui � perch� le due classi sono differenti.
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

		//OO ma da controllare
		//	  if(a instanceof ClassTypeNode && b instanceof ClassTypeNode) {
		//	    	ArrayList<String> gerarchia = getClassHierarchy(((ClassTypeNode)a).getName());
		//	    	for(int i = 0; i < gerarchia.size(); i++) {
		//	    		if(gerarchia.get(i).equals(((ClassTypeNode)b).getName())){
		//	    			return true;
		//	    		}
		//	    	}
		//	    	return false;
		//	    }

		return a.getClass().equals(b.getClass())
				|| ( (a instanceof BoolTypeNode) && (b instanceof IntTypeNode)  		  		   
						); 
	}

	// This function finds the lowest common ancestor for the Nodes in input and, if it exists, it returns it. Otherwise it returns null.
	public static Node lowestCommonAncestor(Node a, Node b){
		
		if( (a instanceof BoolTypeNode) && (b instanceof BoolTypeNode))
			return new BoolTypeNode();
		
		if( (a instanceof BoolTypeNode) && (b instanceof IntTypeNode)|| 
				(a instanceof IntTypeNode) && (b instanceof BoolTypeNode)||
				(a instanceof IntTypeNode) && (b instanceof IntTypeNode))
			return new IntTypeNode();
		
		if( a instanceof EmptyTypeNode && b instanceof EmptyTypeNode )
			return new EmptyTypeNode();
//		if( (a instanceof EmptyTypeNode && !(b instanceof EmptyTypeNode)) ||
//			(b instanceof EmptyTypeNode && !(a instanceof EmptyTypeNode))	)
//			return new BoolTypeNode();
		
		
		if( a instanceof EmptyTypeNode && b instanceof ClassTypeNode )
			return b;
		
		if( b instanceof EmptyTypeNode && a instanceof ClassTypeNode )
			return a;
		
		
		if(a instanceof ClassTypeNode && b instanceof ClassTypeNode ){
			
			// We will now check all the parents (super-classes) of 'b' to see if they match with 'a'.
			String tmp = "";
			
			tmp = superType.get( ((ClassTypeNode)a).getName() );	// Finding the parent class of 'a'.
			
			if( isSubtype(b, new ClassTypeNode(tmp)) )//((ClassTypeNode)a).getName().equals(tmp)
			{
				return new ClassTypeNode(tmp);
			}
			
			while(tmp != null)
			{
				tmp = superType.get(tmp);
	
				if( isSubtype(b, new ClassTypeNode(tmp)) )
				{
					return new ClassTypeNode(tmp);
				}
			}
		}
		
		ArrowTypeNode res = new ArrowTypeNode();
		if((a instanceof ArrowTypeNode) && (b instanceof ArrowTypeNode))
		{
			if(((ArrowTypeNode)a).getParList().size() == ((ArrowTypeNode)b).getParList().size())
			{
				Node lowestRes = lowestCommonAncestor(((ArrowTypeNode)a).getRet(), ((ArrowTypeNode)b).getRet());
				if(lowestRes != null)
				{
					res.setRet(lowestRes);
					for(int i =0; i < ((ArrowTypeNode)a).getParList().size(); i++)
					{
						if( isSubtype( ((ArrowTypeNode)a).getParList().get(i), ((ArrowTypeNode)b).getParList().get(i) ) )
							res.addParListElem(((ArrowTypeNode)a).getParList().get(i));
						else{
							if( isSubtype( ((ArrowTypeNode)b).getParList().get(i), ((ArrowTypeNode)a).getParList().get(i) ) )
							{
								res.addParListElem(((ArrowTypeNode)b).getParList().get(i));
							}
						}
					}
				}
				//else: return null; (we use the default one at the end of the function)
			}
		}
		
		
		return null;	// Returned when the Nodes in input are not EmptyTypeNodes nor ClassTypeNodes.
	}
	
	
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

	public static void putSuperType(String subClass, String superClass) //da gestire nel parsing
	{
		superType.put(subClass, superClass);
	}


	//da qui in poi, funzioni per l'OO

	/** 
	 * Metodo per resettare il parser
	 */
	public static void reset() {
		dtmc = new LinkedHashMap<String, LinkedHashMap<String, String>>();
		classIndex = new LinkedHashMap<String, Integer>();
		classHierarchy = new LinkedHashMap<String, String>();
		classInstances = new ArrayList<String>();
		parTuples = new ArrayList<AttributeTuple>();
		parOnlyOfClass = new LinkedHashMap<String, Integer>();
		classMethods = new LinkedHashMap<String, ArrayList<Node>>();
		classParameters = new LinkedHashMap<String, ArrayList<Node>>();
		clInstance = new ArrayList<String>();
		labCount=0;
		funLabCount=0;
		funCode = "";
		classCode = "";
		curFunClassName = "";
		lastClassSize = 0;
		varsAndCallClassNode = new LinkedHashMap<String, ClassCallNode>();
		realVarType = new ArrayList<String>();
		varAndCallIndex = 0;
		lastVarNameForClass = "";
	}

	/**
	 * Metodo per settare il nome l'ultimo var istanza di classe 
	 * @param varName	: nome del var
	 */
	public static void setLastVarNameForClass(String varName) {
		lastVarNameForClass = varName;
	}

	/**
	 * Metodo che restituisce il nome l'ultimo var istanza di classe 
	 * @return : il nome l'ultimo var istanza di classe 
	 */
	public static String getLastVarNameForClass() {
		return lastVarNameForClass;
	}

	/**
	 * Metodo per aggiungere una variabile e il relativo nodo costruttore richiamato
	 * @param varName : nome della variabile
	 * @param ccn : nodo del costruttore
	 */
	public static void putVarAndCallClassNode(String varName, ClassCallNode ccn) {
		//System.out.println("Putting " + varName + " with ccn: " + ccn.getClassName());
		varsAndCallClassNode.put(varName, ccn);
	}

	/**
	 * Metodo per ricercare il nome composto dell'ultima classe indicizzata
	 * @param className : nome della classe
	 * @return : il nome composto dell'ultima classe indicizzata
	 */
	public static String searchLastClassIndexed(String className) {
		Set<String> k = classIndex.keySet();
		for(String s:k) {
			String[] div = s.split("-");
			if(className.equals(div[0])) {
				return s;
			}
		}
		return null;
	}

	/**
	 * Metodo per costruire il nome composto delle classi indicizzate
	 * @param isCallMethod : flag indicante se la classe � istanziata all'interno di un metodo
	 * @return : il nome composto della classe indicizzata
	 */
	public static String getVarNameForClass(boolean isCallMethod) {
		String ret = null;
		Set<String> keys = varsAndCallClassNode.keySet();
		int index = 0;
		for(String k : keys) {
			if(index == varAndCallIndex){
				ret = realVarType.get(varAndCallIndex)+"-"+k;
				if (isCallMethod){
					ret = k;	
				}
				//System.out.println("FOUND " + k + " index " + index + " offset " + varAndCallIndex + " REAL TYPE "+ realVarType.get(varAndCallIndex));
				if(!isCallMethod){
					varAndCallIndex++;
				}
				break;
			} else {
				index++;
			}
		}
		return ret;
	}

	/**
	 * Metodo per settare il nome della classe riferito ad una variabile
	 * @param typeName : nome della classe di cui la variabile � istanza
	 */
	public static void setRealVarType(String typeName){
		realVarType.add(typeName);
	}

	/**
	 * metodo per memorizzare le classi istanziate
	 * @param className : nome della classe
	 */
	public static void setInstanceClass(String className){
		if(!clInstance.contains(className)){
			clInstance.add(className);
		}
	}

	/**
	 * metodo per verificare se una classe � istanziata
	 * @param className : nome della classe
	 * @return : verifica se la classe � istanziata
	 */
	public static boolean isInstancedClass(String className){
		return clInstance.contains(className);
	}

	/**
	 * Metodo per capire se una classe è stata istanziata o meno
	 * @param clName
	 * @return
	 */
	public static boolean existsClassInstanceByName(String clName){
		return (classInstances.contains(clName));
	}

	/**
	 * Metodo per impostare l'indicizzazione di una classe
	 * @param className : nome della classe
	 * @param classSize : dimensione della classe
	 */
	public static void putClassIndex(String className, int classSize) {
		//System.out.println("PUT " + className + "   " + (lastClassSize));
		classIndex.put(className,lastClassSize);

		lastClassSize += classSize;
		//heapIndex = lastClassSize + classSize;
	}

	/** 
	 * Metodo per prelevare l'indirizzo della prima locazione di memoria vuota dell'heap
	 * @return : l'indirizzo della prima locazione di memoria vuota dell'heap
	 */
	public static int getLastClassSize(){
		return lastClassSize;
	}

	/**
	 * Metodo per prelevare il numero di metodi che sono nelle superclassi di quella target
	 * @param target : classe di cui sapere il numero di metodi delle classi padri
	 * @return : il numero di metodi che sono nelle superclassi di quella target
	 */

	public static String freshFunctionLabel(String id, boolean isClassMethod) {
		if(dtmc.get(curFunClassName) != null) {
			if(dtmc.get(curFunClassName).get(id) != null) {
				return (dtmc.get(curFunClassName).get(id));
			}
		}
		funLabCount++;
		if(curFunClassName != null && isClassMethod) {
			LinkedHashMap<String, String> cclass = dtmc.get(curFunClassName);
			if(cclass == null) {
				cclass = new LinkedHashMap<String, String>();
				dtmc.put(curFunClassName, cclass);
			}
			String funName = cclass.get(id);
			if(funName == null) {
				//System.out.println("PUT METHOD " + id + " label " +  newFunctionlabel);
				cclass.put(id, "function"+funLabCount);
			}
			curFunClassName = null;
		}
		return "function"+funLabCount;
	} 

	/**
	 * metodo che recupera la label associata al metodo
	 * @param className : nome della classe
	 * @param id : nome del metodo
	 * @return : la label associata al metodo
	 */
	public static String getFunctionLabel(String className,String id){
		if(dtmc.get(className) != null) {
			if(dtmc.get(className).get(id) != null) {
				return (dtmc.get(className).get(id));
			}
		}
		return null;
	}

	/**
	 * Metodo per impostare il nome della classe corrente
	 * @param id : nome della classe
	 */
	public static void setFunClassName(String id) {
		curFunClassName = id;
	}



	/**
	 * Metodo per aggiungere il codice di una classe
	 * @param c : codice della classe
	 */
	public static void putClassCode(String c){
		classCode += c;
	}

	/**
	 * Metodo per prelevare il codice delle funzioni dichiarate
	 * @return : codice delle funzioni dichiarate
	 */
	public static String getFunCode() {
		return funCode;
	}

	/**
	 * Metodo per aggiungere il codice di una funzione
	 * @param c : codice della funzione
	 */
	public static void putFunCode(String c){
		funCode += c;
	}


}