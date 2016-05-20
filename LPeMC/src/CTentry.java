import java.util.ArrayList;
import java.util.HashMap;

public class CTentry {
	
	HashMap<String,STentry> vTable = new HashMap<String,STentry>();
	private int offsetFields = -3;               						// offset (<=-1) da usare per un nuovo field                                                                                  (decrementati)
	private int offsetMethods= -3;               						// offset (>=0) da usare per nuovo metodo
															//(incrementati)
	ArrayList<Node> allFields = new ArrayList<Node>();      //tutti i figli virtuali che sono campi 
															// ordinati in base al loro offset, cio� 
															// indice array �: -(offset campo)-1
	ArrayList<Node> allMethods = new ArrayList<Node>();     // tutti i figli virtuali che sono metodi 
															// ordinati in base al loro offset, cio�
															// indice array �: offset metodo
	private int nestingLevel;
	private Node type;
	private Node dec;
	public CTentry(Node d, int nl)
	{
		dec = d;
		nestingLevel = nl;
	}
	
	public CTentry(Node d)
	{
		dec = d;
	}
	
	public void setFieldAndCheck(Node node, String s)
	{
		for(int i = 0;i < allFields.size();i++)
		{
			if(((FieldNode)allFields.get(i)).getName().equals(s))
				{
					allFields.remove(i);
					break;
				}
		}
		
		allFields.add(node);
	}
	
	public void setMethodOffset(int offset)
	{
		offsetMethods = offset;
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
		// TODO Auto-generated method stub
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
}
