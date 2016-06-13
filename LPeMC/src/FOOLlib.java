import java.util.ArrayList;
import java.util.HashMap;

public class FOOLlib {
	// classe usata per consentire di mettere il booleano, un sottotipo di un altro tipo, sia utilizzato laddove ci si aspetterebbe un intero.
	//valuta se il tipo "a" è <= al tipo "b", dove "a" e "b" sono tipi di base: int o bool

	private static int labCount=0;
	private static int funLabCount=0; 
	private static String funCode="";

	private static HashMap<String,String> superType = new HashMap<String,String>();

	// Metodo che controllerà che il primo elemento sia di un tipo che è uguale al secondo oppure è un suo sottotipo.
	// Valuta se il tipo "a" e' <= al tipo "b", dove "a" e "b" sono tipi di base: int o bool
	public static boolean isSubtype (Node a, Node b) {
		
		// Nel caso delle classi controlla che 'a' sia di tipo uguale a 'b' o che 'a' sia di un tipo "parent" di 'b'.
		if(a instanceof ClassTypeNode && b instanceof ClassTypeNode)
		{
			// initial check that controls if the classes are the same.
			if( ((ClassTypeNode)a).getName().equals(((ClassTypeNode)b).getName())  )
			{
				return true;
			}

			// We will now check all the parents (super-classes) of 'b' to see if they match with 'a'.
			String tmp = "";
			
			tmp = superType.get( ((ClassTypeNode)a).getName());
			
			if( ((ClassTypeNode)b).getName().equals(tmp))
			{
				return true;
			}
			
			while(tmp != null)
			{
				tmp = superType.get(tmp);

				if( ((ClassTypeNode)b).getName().equals(tmp) )
				{
					return true;
				}
			}
			
			return false;
		}
		
		if(a instanceof EmptyTypeNode && b instanceof ClassTypeNode ||
				(a instanceof ClassTypeNode && b instanceof EmptyTypeNode))
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
		
		Node retA;
		Node retB;
		if((a instanceof ArrowTypeNode) && (b instanceof ArrowTypeNode))
		{
			// Sono entrambi elementi di tipo funzionale. 
			// Controlliamo i tipi dei loro valori di ritorno.
			retA = ((ArrowTypeNode)a).getRet();	// valore di ritorno della prima funzione
			retB = ((ArrowTypeNode)b).getRet();	// valore di ritorno della seconda funzione
			// Confrontiamo i tipi dei due elementi. Deve essere valida la proprietà di co-varianza (cioè a deve essere sottotipo di b )
			if(!(isSubtype(retA,retB))) 
				return false;
			
			// Ora controlliamo i tipi dei parametri richiesti in input. Li controlliamo a coppie, se anche solo una coppia ha elementi di classi diverse interrompiamo ritornando "false".
			ArrayList<Node> parListA = ((ArrowTypeNode)a).getParList();
			ArrayList<Node> parListB = ((ArrowTypeNode)b).getParList();
			if(parListA.size() != parListB.size()){ return false; }	// Per prima cosa il numero di parametri richiesti in ingresso deve essere lo stesso per entrambi.
			for(int i=0; i<parListA.size(); i++){ 
				if(!(isSubtype(parListB.get(i),parListA.get(i)))) //proprietà di controvarianza (cioè  i-esimo par di b deve essere sottotipo dell'i-esimo par di a )
					return false;
			}

			return true;	// Le relazioni di co-variazna sui parametri di ritorno e quelle di contro-varianza sui parametri in ingresso sono rispettate.
		}

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
		
		if( a instanceof EmptyTypeNode && b instanceof ClassTypeNode )
			return b;
		if( b instanceof EmptyTypeNode && a instanceof ClassTypeNode )
			return a;
		
		
		if(a instanceof ClassTypeNode && b instanceof ClassTypeNode ){
			// Initial check to see if they are already subtypes.
			if( isSubtype(b, a) )
			{
				return b;
			}
			
			// We will now check all the parents (super-classes) of 'b' to see if they match with the parents of 'a'.
			String parentAname = superType.get( ((ClassTypeNode)a).getName() );	// Finding the parent class of 'a'.
			ClassTypeNode parentA = new ClassTypeNode(parentAname);
			
			/*
			 * VERSIONE DEL PROF. SECONDO LE SPECIFICHE:
			 */
			while(parentAname != null){
				if( isSubtype(b, parentA) )
				{
					return b;
				}
				
				parentAname = superType.get( parentAname );	// Finding the parent class of 'a'.
				parentA = new ClassTypeNode(parentAname);
			}
		}
			/*
			
			// VERSIONE DI MARCO:
			// First check for 'parentA'.
			if( isSubtype(b, parentA) )
			{
				return b;
			}
			
			String parentBname = ((ClassTypeNode)b).getName();	// Initialization of 'parentBname'
			ClassTypeNode parentB;
			
			// Cycling checks. We keep on looking for the parent classes of A while checking all 'b' and its parents for a positive outcome for the isSubtype() function.
			while(parentBname != null)
			{
				// Reset of the parent of the class A considered. Necessary for the while cycles afterwards.
				parentAname = ((ClassTypeNode)a).getName();
				parentA = (ClassTypeNode)a;
				
				parentBname = superType.get( parentBname );
				parentB = new ClassTypeNode( parentBname );
				
				// First check for parentB.
				if( isSubtype(parentB, parentA) )
				{
					return parentB;
				}
				
				// At every cycle we compare a parent of B with all the parents of A.
				while(parentAname != null){
					
					parentAname = superType.get(parentAname);
					parentA = new ClassTypeNode(parentAname);
					
					if( isSubtype(parentB, parentA) )
					{
						return parentB;
					}
				}
			}
		}
		
		*/
		
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
		
		
		return null;
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
	/**
	 * Metodo per aggiungere il codice di una funzione
	 * @param c : codice della funzione
	 */
	public static void putFunCode(String c){
		funCode += c;
	}


}