import java.util.ArrayList;
import java.util.HashMap;

public class FOOLlib {
	// Classe usata per consentire di permettere (ad es. ad un booleano) che un sottotipo di un altro tipo sia utilizzato laddove ci si aspetterebbe un suo supertipo (ad es. un intero).
	// Valuta se il tipo "a" è <= al tipo "b", dove "a" e "b" sono tipi di base: int o bool
	
	private static int labCount=0;
	private static int funLabCount=0; 
	private static String funCode="";
	
	private static HashMap<String,String> superType = new HashMap<String,String>();	// Struttura che conterrà i nomi della classi in coppie <figlio, parent>.
	
	// Metodo che controllerà che il primo elemento sia di un tipo che è uguale al secondo oppure è un suo sottotipo.
	// Valuta se il tipo "a" e' <= al tipo "b", dove "a" e "b" sono tipi di base: int o bool
	public static boolean isSubtype (Node a, Node b) {

		// Nel caso delle classi controlla che 'a' sia di tipo uguale a 'b' o che 'a' sia di un tipo "parent" di 'b'.
		if(a instanceof ClassTypeNode && b instanceof ClassTypeNode)
		{
			// Initial check that controls if the classes are the same.
			if( ((ClassTypeNode)a).getName().equals(((ClassTypeNode)b).getName()) )
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
		
		// Consideriamo i casi con EmptyTypeNode
		if(a instanceof EmptyTypeNode && b instanceof ClassTypeNode ||
				(a instanceof ClassTypeNode && b instanceof EmptyTypeNode)){
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
		
		// Consideriamo ora i casi in cui si tratti di due tipi funzionali
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
				|| ( (a instanceof BoolTypeNode) && (b instanceof IntTypeNode) ); 
	}

	/** Questa funzione cerca il lowest common ancestor per i nodi in input e, se esiste, lo ritorna in output. Altrimenti ritorna 'null'.
	 * metodo "Node lowestCommonAncestor(Node a, Node b)" che:
		- per a e b tipi classe (o EmptyTypeNode)
		all'inizio considera la classe "a" e risale le sue super classi (tramite la funzione "superType") 
		controllando, ogni volta, se "b" sia sottotipo (metodo "isSubtype") della classe considerata: 
		torna tale classe qualora il controllo abbia, prima o poi, successo, altrimenti null.
		(se uno tra a e b è di tipo EmptyTypeNode torna l'altro)
		- per a e b tipi funzionali con stesso numero di tipi parametri
		controlla se esiste il lowest common ancestor dei due tipi di ritorno di a e b (si richiama ricorsivamente) e... se, per ogni i, i due tipi parametro i-esimi sono uno sottotipo dell'altro (metodo "isSubtype"): 
		se il controllo non ha successo torna null, 
		altrimenti torna un tipo funzionale che ha come tipo di ritorno il risultato della chiamata 
		 ricorsiva e come tipo di parametro i-esimo il tipo che è sottotipo dell'altro.
		- per a e b tipi bool/int 
		torna int se almeno uno è int, bool altrimenti 
		- in ogni altro caso torna null  */
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
			
			while(parentAname != null){
				if( isSubtype(b, parentA) )
				{
					return b;
				}

				parentAname = superType.get( parentAname );	// Finding the parent class of 'a'.
				parentA = new ClassTypeNode(parentAname);
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
							}else{
								return null;
							}
						}
					}
					return res;
				}
			}
			//else: return null; (we use the default one at the end of the function)
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
	
	// Aggiunge una nuova coppia di elementi a superType.
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