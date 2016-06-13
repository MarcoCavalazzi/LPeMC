import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class ClassNode implements Node{
	private Node sc;
	private String name;
	private ArrayList<Node> dec = new ArrayList<Node>();
	private ArrayList<Node> fields = new ArrayList<Node>();
	private ArrayList<MethodNode> methods = new ArrayList<MethodNode>();
	private CTentry classEntry;
	private CTentry superEntry;

	public ClassNode(String id){
		name = id;
	}

	public String getName() {
		return name;
	}

	public void setSuperEntry(CTentry sE)
	{
		superEntry = sE;
	}

	public void setClassEntry(CTentry cE)
	{
		classEntry = cE;
	}


	public String toPrint(String s) {
		String ret = s+"Class "+name+"\n" + s + "   " + (fields.size() > 0 ? " parameters:" : "") + " \n";
		for(int j=0;j < fields.size();j++){
			ret += s+fields.get(j).toPrint(s+" ")+"\n";
		}

		if(sc != null && (sc instanceof ClassNode)){
			ret += s+"superclass: "+(((ClassNode)sc).getName())+"\n";
		}

		int i;
		if (dec != null ){
			ret += s+"body:\n";
			for(i=0;i < dec.size();i++){
				ret += s+dec.get(i).toPrint(s+" ")+"\n";
			}
		}
		return ret;
	}

	/*
	 * -ClassNode
		si richiama sui figli che sono metodi, poi -> in caso di ereditarietà:
		 controlla che l'overriding sia di campi che di metodi sia corretto 
		 usando i campi allFields e allMethods delle CTentry in classEntry e superEntry
		 (per semplicità controllare che tutti i campi ed i metodi del padre abbiano tipo 
		 corretto nel figlio anche se, in realtà, non è avvenuto alcun overriding):
		 il controllo avviene recuperando i tipi tramite il metodo getSymType() sui nodi in 
		 allFields e allMethods e invocando poi isSubtype()
	 */
	public Node typeCheck() {
		// First we call the function typeCheck() on every method of this class
		for( MethodNode m : methods ){
			m.typeCheck();
		}

		/* Then, considering that there could have been some overriding (we consider the overriding in place anyway),
		 * we check the fields and the methods of the superEntry
		 * comparing them to the ones in the classEntry. */

		/*
		 * Checking the types of the methods and their parameters with the parent class' methods.
		 */
		if( superEntry != null ){	// If the parent class has been extended...
			// ...check if the parent methods have been implemented (or overridden).

			superEntry.getLocals().retainAll(classEntry.getLocals());//considero solo i metodi/field con overriding (retainAll fa una unione degli elementi di locals di superEntry e classEntry

			List<Integer> overOffset = new ArrayList<Integer>(superEntry.getLocals());			
			int val = 0;
			for(int i = 0; i < overOffset.size();i++) 
			{	
				val = overOffset.get(i);
				if(val >=0)//cioè offset di metodo
				{ 
					if( !(FOOLlib.isSubtype(((MethodNode)classEntry.allMethods.get(val)).getSymType() ,((MethodNode)superEntry.allMethods.get(val)).getSymType())) )
					{
						System.out.println("[ClassNode] Type check found a problem:");
						System.out.println("-> method:"+((MethodNode)superEntry.allMethods.get(val)).getName()+" did not have a match in the child/extended class.");
						System.exit(0);
					}					
				}	
				else
				{
					val = -(val)-1;
					if( !(FOOLlib.isSubtype(((FieldNode)classEntry.allFields.get(val)).getSymType(),((FieldNode)superEntry.allFields.get(val)).getSymType( ))) )
					{
						System.out.println("[ClassNode] Type check found a problem:");
						System.out.println("-> field:"+((FieldNode)superEntry.allFields.get(val)).getName()+" did not have a match in the child/extended class.");
						System.exit(0);
					}
				}
			}
		}

		return new ClassTypeNode(name); 
	}








	public Node getSuperClass() {
		return sc;
	}

	public void addField(Node f){
		fields.add(f);
	}

	public ArrayList<Node> getPar(){
		return fields;
	}

	public ArrayList<Node> getBody(){
		return dec;
	}

	public void addMethod(Node method){
		dec.add(method);
	}



	public void setMethod(MethodNode Node)
	{
		methods.add(Node);
	}




	public String codeGeneration() {



		for (MethodNode method:methods)
		{
			method.setLabel(FOOLlib.freshFunLabel());
			method.codeGeneration();
		}	



		return "";//forse ci vuole ClassTypeNode

	}
}
