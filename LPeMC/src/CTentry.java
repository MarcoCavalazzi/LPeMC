import java.util.ArrayList;
import java.util.HashMap;

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
	private int nestingLevel;
	private Node type;
	private Node dec;
	private int newOffset = 0;
	public CTentry(Node d, int nl)
	{
		dec = d;
		nestingLevel = nl;
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



	public void setMethodOffset(int offset)
	{
		offsetMethods = offset;
	}
	public void incMethodOffset()
	{
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
