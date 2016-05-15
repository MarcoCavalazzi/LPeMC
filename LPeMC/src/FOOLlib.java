import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Set;

public class FOOLlib {
	// classe usata per consentire di mettere il booleano, un sottotipo di un altro tipo, sia utilizzato laddove ci si aspetterebbe un intero.
	//valuta se il tipo "a" è <= al tipo "b", dove "a" e "b" sono tipi di base: int o bool
	
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
		  String tmp = "tmp";
	  
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
	  /*
	  if(a instanceof ClassTypeNode && b instanceof ClassTypeNode)
	  {
		  String tmp = "tmp";
	  
		  tmp = superType.get( ((ClassTypeNode) a).getName());
	  
		  if(tmp == superType.get( ((ClassTypeNode) b).getName()))
		  {
			  return true;
		  }	  
	  
		  while(tmp != null)
		  {
			  tmp = superType.get(tmp);
		  
			  if(tmp == superType.get( ((ClassTypeNode) b).getName()))
			  {
				  return true;
			  }
		  
		  }
	  
	      return false;
	  }
	  */
	  if(a instanceof EmptyTypeNode && b instanceof ClassTypeNode )
	  {
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
   * @param isCallMethod : flag indicante se la classe è istanziata all'interno di un metodo
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
   * @param typeName : nome della classe di cui la variabile è istanza
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
   * metodo per verificare se una classe ï¿½ istanziata
   * @param className : nome della classe
   * @return : verifica se la classe ï¿½ istanziata
   */
  public static boolean isInstancedClass(String className){
	  return clInstance.contains(className);
  }

  /**
   * Metodo per capire se una classe Ã¨ stata istanziata o meno
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
  public static int getOnlySuperClassesMethodsNumber(ClassNode target) {
	  ArrayList<Node> tdec = new ArrayList<Node>();
	  
	  for(ClassNode n = (ClassNode)target.getSuperClass(); n != null; n=(ClassNode)n.getSuperClass()){
		  tdec.addAll(n.getBody());
	  }
	  
	  ArrayList<Node> toOverride = new ArrayList<Node>();
	  for(int i = 0; i < tdec.size();i++){
		  for(int j = 0;j < target.getBody().size();j++){
			  if(((FunNode)tdec.get(i)).getName().equals(((FunNode)target.getBody().get(j)).getName())){
				  toOverride.add(tdec.get(i));
			  }
		  }
	  }
	  
	  for(int i = 0; i < toOverride.size();i++){
		  tdec.remove(toOverride.get(i));
	  }
	  return tdec.size();
  }
  
  /**
   * Metodo per controllare se esiste una indicizzazione della classe
   * @param className : nome della classe
   * @return : true se essa Ã¨ indicizzata, false altrimenti
   */
  public static boolean checkClassIndex(String className) {
	  return (classIndex.get(className) != null);
  }
  
  /** 
   * Metodo per prelevare l'indice di riferimento di una classe
   * @param className : nome della classe
   * @return : l'indice riferito a tale classe
   */
  public static int getClassIndex(String className) {
	  return classIndex.get(className);
  }
  
  /**
   * Metodo per aggiungere una corrispondenza fra superclasse e subclasse
   * @param fatherClass : nome della superclasse
   * @param childClass : nome della subclasse
   */
  public static void addClassHierarchy(String fatherClass, String childClass) {
	  classHierarchy.put(childClass, fatherClass);
	  //Set<String> keys = classHierarchy.keySet();
	  //System.out.println("SEARCHING " + child);
	  //for(String key : keys) {
	  //	  String cur = classHierarchy.get(key);
		  //System.out.println("HIERARCHY: " + key  + " SON OF " + cur + "       " + keys.size());
	  //}
  }
  
  /**
   * Metodo per prelevare la gerarchia delle classi partendo da una subclasse
   * @param childClass : nome della classe figlia
   * @return : arraylist con tutte le classi padri partendo da quella figlia (indice 0)
   */
  public static ArrayList<String> getClassHierarchy(String childClass) {
	  ArrayList<String> classes = new ArrayList<String>();
	  classes.add(childClass);
	  String child = childClass;
	  boolean hasFather = true;
	  while(hasFather)
	  {
		  hasFather = false;
		  String father = classHierarchy.get(child);
		  if(father != null) {
			  hasFather = true;
			  child = father;
			  classes.add(father);
		  }
	  }
	  return classes;
  }
  
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
	   * 
	   * @param target : classe considerata
	   * @param methodName : nome del metodo considerato
	   * @return : la posizione di quel metodo considerando i metodi delle superclassi
	   */
	  public static int getMethodRealOffset(ClassNode target,String methodName){
		  ArrayList<Node> tdec = new ArrayList<Node>();
		  ArrayList<ClassNode> cls = new ArrayList<ClassNode>();

		  for(ClassNode n = (ClassNode)target; n != null; n=(ClassNode)n.getSuperClass()){
			  cls.add(0, n);
		  }
		  tdec.addAll(cls.get(0).getBody());
		  
		  for(int padreIndex = 1; padreIndex < cls.size(); padreIndex++){
			  ArrayList<Integer> overridenPos = new ArrayList<Integer>();
			  for(int i = 0; i < tdec.size(); i++){
				  for(int j = 0;j < cls.get(padreIndex).getBody().size();j++){
					  //System.out.println("TDEC: " + ((FunNode)tdec.get(i)).getName() + " Class:" + cls.get(padreIndex).getName() + " : " +((FunNode)cls.get(padreIndex).getBody().get(j)).getName());

					  if(((FunNode)tdec.get(i)).getName().equals(((FunNode)cls.get(padreIndex).getBody().get(j)).getName())){
						  tdec.set(i, ((FunNode)cls.get(padreIndex).getBody().get(j)));
						  overridenPos.add(j);
						  //System.out.println("Ovverridden " + ((FunNode)tdec.get(i)).getName() + " by " + cls.get(padreIndex).getName());
					  }
				  }
			  }
			  for(int j = 0;j < cls.get(padreIndex).getBody().size();j++){
				  if(!overridenPos.contains(j)){
					  tdec.add(((FunNode)cls.get(padreIndex).getBody().get(j)));
				  }
			  }
		  }
		  
		  int i = 0;
		  for(;i < tdec.size();i++){
			  //System.out.println("TDEC " + ((FunNode)tdec.get(i)).getName());
			  if (((FunNode)tdec.get(i)).getName().equals(methodName)){
				  break;
			  }
		  }
		  /*for(;i < tdec.size();i++){
			  System.out.println("TDEC " + ((FunNode)tdec.get(i)).getName());
		  }*/
		  //System.out.println("FOUND METHOD " + methodName + " AT INDEX " + i + " IN CLASS " + target.getName());
		  return i+1;
	  }
	  
	  /**
	   * 
	   * @param target : classe considerata
	   * @param parName : nome del parametro considerato
	   * @return : la posizione di quel parametro considerando i parametri delle superclassi
	   */
	  public static int getParamRealOffset(ClassNode target,String parName){
		  ArrayList<Node> tdec = new ArrayList<Node>();
		  ArrayList<ClassNode> cls = new ArrayList<ClassNode>();

		  for(ClassNode n = (ClassNode)target; n != null; n=(ClassNode)n.getSuperClass()){
			  cls.add(0, n);
		  }
		  tdec.addAll(cls.get(0).getPar());
		  
		  ArrayList<Node> childParams = new ArrayList<Node>();
		  childParams.addAll(cls.get(0).getPar());
		  
		  //System.out.println("INIT TDEC SIZE:   " +tdec.size());
		  for(int padreIndex = 1; padreIndex < cls.size(); padreIndex++){
			  ArrayList<Integer> overridenPos = new ArrayList<Integer>();
			  for(int i = 0; i < childParams.size(); i++){
				  for(int j = 0;j < cls.get(padreIndex).getPar().size();j++){
					  if(((ParNode)childParams.get(i)).getName().equals(((ParNode)cls.get(padreIndex).getPar().get(j)).getName())){
						  childParams.set(i, (ParNode)cls.get(padreIndex).getPar().get(j));
						  overridenPos.add(j);
						  //System.out.println("Ovverridden: " + ((ParNode)childParams.get(i)).getName());
					  }
				  }
			  }
			  for(int j = 0;j < cls.get(padreIndex).getPar().size();j++){
				  if(!overridenPos.contains(j)){
					  childParams.add((ParNode)cls.get(padreIndex).getPar().get(j));
				  }
			  }
		  }
		  
		  int i = 0;
		  for(;i < childParams.size();i++){
			  //System.out.println("TDEC " + ((FunNode)tdec.get(i)).getName());
			  if (((ParNode)childParams.get(i)).getName().equals(parName)){
				  break;
			  }
		  }
		  /*for(;i < tdec.size();i++){
			  System.out.println("TDEC " + ((FunNode)tdec.get(i)).getName());
		  }*/
		  //System.out.println("Params num: " + childParams.size() + " IN CLASS " + target.getName());
		  //return i+1;
		  return i+1;
	  }

	  /**
	   * Metodo per prelevare il numero di parametri di una classe
	   * @param className : nome della classe
	   * @return : il numero di parametri della classe
	   */
	  public static int getClassParamSize(String className) {
		  /*
		  Set<String> keys = classParameters.keySet();
		  for(String s : keys) {
			  for(Node n : classParameters.get(s)){
				  System.out.println(s + " -> " + ((ParNode)n).getName());
			  }
		  }
		  */
		  return (classParameters.get(className).size());
	  }
	  
	  /**
	   * Metodo per ottenere tutti i metodi e campi di una classe
	   * @param target : classe considerata
	   * @return : lista di tutti i nodi relativi a metodi e campi di quella classe
	   */
	  public static ArrayList<Node> getTotalDecMethodsAndFields(ClassNode target) {
		  ArrayList<Node> tdec = new ArrayList<Node>();
		  ArrayList<ClassNode> cls = new ArrayList<ClassNode>();
		  
		  if(classMethods.get(target.getName()) != null){
			  return classMethods.get(target.getName());
		  }
		  
		  for(ClassNode n = (ClassNode)target; n != null; n=(ClassNode)n.getSuperClass()){
			  cls.add(0, n);
		  }
		  tdec.addAll(cls.get(0).getBody());
		  
		  //System.out.println("Class " + target.getName() + " -> tdec: " + tdec.size());
		  
		  for(int padreIndex = 1; padreIndex < cls.size(); padreIndex++){
			  ArrayList<Integer> overridenPos = new ArrayList<Integer>();
			  for(int i = 0; i < tdec.size(); i++){
				  for(int j = 0;j < cls.get(padreIndex).getBody().size();j++){
					  //System.out.println("TDEC: " + ((FunNode)tdec.get(i)).getName() + " Class:" + cls.get(padreIndex).getName() + " : " +((FunNode)cls.get(padreIndex).getBody().get(j)).getName());

					  if(((FunNode)tdec.get(i)).getName().equals(((FunNode)cls.get(padreIndex).getBody().get(j)).getName())){
						  tdec.set(i, ((FunNode)cls.get(padreIndex).getBody().get(j)));
						  overridenPos.add(j);
						  //System.out.println("Ovverridden " + ((FunNode)tdec.get(i)).getName() + " by " + cls.get(padreIndex).getName());
					  }
				  }
			  }
			  for(int j = 0;j < cls.get(padreIndex).getBody().size();j++){
				  if(!overridenPos.contains(j)){
					  tdec.add(((FunNode)cls.get(padreIndex).getBody().get(j)));
				  }
			  }
		  }

		  //System.out.println("Class " + target.getName() + " -> tdec: " + tdec.size());
		  /*
		  for(ClassNode c : cls) {
			  System.out.println("Class: " + c.getName() + " with target: " + target.getName() + " tdec: " +tdec.size());
		  }
		  */
		  
		  ArrayList<Node> childParams = new ArrayList<Node>();
		  childParams.addAll(cls.get(0).getPar());
		  
		  /*
		  for(Node n : childParams) {
			  System.out.println("Params: " + ((ParNode)n).getName());
		  }
		  */
		  
		  //System.out.println("INIT TDEC SIZE:   " +tdec.size());
		  for(int padreIndex = 1; padreIndex < cls.size(); padreIndex++){
			  ArrayList<Integer> overridenPos = new ArrayList<Integer>();
			  for(int i = 0; i < childParams.size(); i++){
				  for(int j = 0;j < cls.get(padreIndex).getPar().size();j++){
					  if(((ParNode)childParams.get(i)).getName().equals(((ParNode)cls.get(padreIndex).getPar().get(j)).getName())){
						  childParams.set(i, (ParNode)cls.get(padreIndex).getPar().get(j));
						  overridenPos.add(j);
						  //System.out.println("Overridden " + ((ParNode)cls.get(padreIndex).getPar().get(j)).getName() + " -> " + i);
					  }
				  }
			  }
			  for(int j = 0;j < cls.get(padreIndex).getPar().size();j++){
				  if(!overridenPos.contains(j)){
					  childParams.add((ParNode)cls.get(padreIndex).getPar().get(j));
				  }
			  }
		  }
		  tdec.addAll(childParams);
		  
		  classParameters.put(target.getName(), childParams);
		  //System.out.println("PARAM COUNT OF CLASS :   " + target.getName() + " ->" +childParams.size());
		 
		  if(classMethods.get(target.getName()) == null){
			  classMethods.put(target.getName(), tdec);
		  }
		  return classMethods.get(target.getName());
	  }

	  /**
	   * Metodo per aggiungere un par alla collezione e un riferimento alla classe
	   * @param className : nome della classe
	   * @param parName : nome del parametro
	   * @param offset : offset del parametro
	   */
	  public static void addParTuple(String className, String parName, int offset) {
		  parTuples.add(new AttributeTuple(parName, className, offset));
		  
		  if(parOnlyOfClass.get(className) == null) {
			  parOnlyOfClass.put(className, 1);
		  } else {
			  int n = parOnlyOfClass.get(className) + 1;
			  parOnlyOfClass.remove(className);
			  parOnlyOfClass.put(className, n);
		  }
		  //System.out.println("Partuple: cl-> " + className + "   pn-> " + parName + "   os-> " + offset + "       SIZE: " + parTuples.size());
	  }
	  
	  /**
	   * Metodo per prelevare una tupla di un parametro riferito ad una classe
	   * @param className : nome della classe
	   * @param parName : nome del parametro ricercato
	   * @return : la tupla riferita a quel parametro di quella classe
	   */
	  public static AttributeTuple getParTuple(String className, String parName) {
		  for(AttributeTuple t : parTuples) {
			  //System.out.println("Partuple: cl-> " + t.getClassName() + "   pn-> " + t.getAttributeName() + "   os-> " + t.getOffset());
			  if(t.getClassName().equals(className) && t.getAttributeName().equals(parName)) {
				  return t;
			  }
		  }
		  return null;
	  }
	  
	  /**
	   * metodo per controllare la dichiarazione di un nodo del body una classe
	   * @param dec1 : dichiarazione della classe
	   * @param dec2 : dichiarazione di un altra classe
	   * @return : true se le due dichiarazioni sono compatibili, false altrimenti
	   */
	  protected static boolean checkClassBodyDec(Node dec1, Node dec2) {
		  if(dec1 instanceof FunNode && dec2 instanceof FunNode) {
			  return ((FunNode)dec1).getName().equals(((FunNode)dec2).getName());
		  } else if(dec1 instanceof ParNode && dec2 instanceof ParNode) {
			  return ((ParNode)dec1).getName().equals(((ParNode)dec2).getName());
		  }
		  return false;
	  }
	  
	  /**
	   * Metodo per prelevare il codice delle classi dichiarate
	   * @return : codice delle classi dichiarate
	   */
	  public static String getClassCode() {
	    return classCode;
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