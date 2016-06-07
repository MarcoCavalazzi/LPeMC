import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class CTentry {

	HashMap<String,STentry> vTable = new HashMap<String,STentry>();
	private int offsetFields = -1;               						// offset (<=-1) da usare per un nuovo field                                                                                  (decrementati)
	private int offsetMethods= 0;               						// offset (>=0) da usare per nuovo metodo
	//(incrementati)
	ArrayList<Node> allFields = new ArrayList<Node>();      //tutti i figli virtuali che sono campi 
	// ordinati in base al loro offset, cioè 
	// indice array è: -(offset campo)-1
	ArrayList<Node> allMethods = new ArrayList<Node>();     // tutti i figli virtuali che sono metodi 
	// ordinati in base al loro offset, cioè
	// indice array è: offset metodo
	
	HashSet<Integer> locals;	// Conterrà gli offset di campi e metodi definiti da questa classe
	
	private int nestingLevel;
	private Node type;
	private Node dec;
	private int newOffset = 0;
	
	public CTentry(Node d, int nl)
	{
		dec = d;
		nestingLevel = nl;
		locals = new HashSet<Integer>();
	}
	
	
	public boolean setFieldAndCheck(Node node, String s)
	{
		for(int i = 0;i < allFields.size();i++)
		{
			if(((FieldNode)allFields.get(i)).getName().equals(s))
			{
				allFields.remove(i);
				offsetFields++;
				allFields.add(node);
				return true;
			}
		}
		
		allFields.add(node);
		return false;
	}
	// Versione ESTENSIONE OPZIONALE
	public boolean setFieldAndCheck_Opt(Node node, String s, Integer fieldOff)	// Optimized version.
	{
		if( !locals.contains( fieldOff )){ // ?? locals dovrebbe contenere solo interi pare, come lo usiamo?
			locals.add(fieldOff);
			allFields.add(node);
			return true;
		}
		
		System.out.println("Redefinition of the field \""+s+"\" in the same class. Terminating execution.");
		System.exit(0);
		return false;
		
		/*
		for(int i = 0;i < allFields.size();i++)
		{
			if(((FieldNode)allFields.get(i)).getName().equals(s))
			{
				allFields.remove(i);
				offsetFields++;
				allFields.add(node);
				return true;
			}
		}
		
		allFields.add(node);*/
	}
	
	public boolean setMethodAndCheck(Node node, String s)
	{
		for(int i = 0;i < allMethods.size();i++)
		{
			if(((MethodNode)allMethods.get(i)).getName().equals(s))
			{
				allMethods.remove(i);
				offsetMethods--;
				allMethods.add(node);
				return true;
			}
		}

		allMethods.add(node);
		return false;
	}
	// Versione ESTENSIONE OPZIONALE
	public boolean setMethodAndCheck_Opt(Node node, String s, Integer methodOff)
	{
		if( !locals.contains( methodOff )){ // ?? locals dovrebbe contenere solo interi pare, come lo usiamo?
			locals.add(methodOff);
			allFields.add(node);
			return true;
		}
		
		System.out.println("Redefinition of the method \""+s+"\" in the same class. Terminating execution.");
		System.exit(0);
		return false;
	}
	
	public void setMethodOffset(int offset)
	{
		offsetMethods = offset;
	}
	
	public void incMethodOffset()
	{
		if( locals.add(offsetMethods) != true ){	// If the element was not present yet in the HashSet the function returns 'true'.
			// There is already an element in the HashSet with value 'offsetMethods'.
			// The method has already been defined.
			// si tratta di una ridefinizione effettuata all'interno della stessa classe: notifico l'errore.
			System.out.println("Error: redefinition of a method with the same name in the same class.");
			System.exit(0);
		}
		offsetMethods++;
	}

	public void decFieldOffset(){
		offsetFields--;
	}
	
	public void setFieldOffset(int offset)
	{
		offsetFields = offset;
	}

	public void setMethod(Node method)
	{
		allMethods.add(method);
	}

	public void setField(Node field)
	{
		allFields.add(field);
	}

	public void addType(Node t)
	{
		type = t;
	}

	public ArrayList<Node> getFields()
	{
		return allFields;
	}

	public ArrayList<Node> getMethods()
	{
		return allMethods;
	}

	public void setMethods(ArrayList <Node> mList)
	{
		allMethods = mList;
	}

	public void setFields(ArrayList <Node> fList)
	{
		allFields = fList;
	}

	public void addvTable(STentry e, String s)
	{
		vTable.put(s,e);
	}

	public String toPrint(String string) {
		return "CTentry";
	}

	public void setAllField(ArrayList<Node> af)
	{
		for(int i =0; i < af.size();i++)
		{
			allFields.add(af.get(i));
		}
	}

	public Node getType() {

		return type;
	}

	public int getNestinglevel() {

		return nestingLevel;
	}

	public int getFieldOffset() {

		return offsetFields;
	}

	public int getMethodOffset() {

		return offsetMethods;
	}

	public HashMap<String,STentry> getVirtualTable()
	{
		return vTable;
	}

	public void setVirtualTable(HashMap<String,STentry> vt)
	{
		vTable = vt;
	}

	public  STentry putvTable(String s, STentry st, CTentry ctentry)
	{	
		if(ctentry != null){
			if(ctentry.getVirtualTable().containsKey(s))
				vTable.remove(s);
		}
		return vTable.put(s, st);
	}

	public Node getDec() {
		// TODO Auto-generated method stub
		return dec;
	}
	public void setNewOffset(int nO)
	{
		newOffset = nO;
	}

	public int getNewOffset()
	{
		return newOffset;
	}
}
