import java.util.ArrayList;
import java.util.HashMap;

public class CTentry {
	
	HashMap<String,STentry> vTable = new HashMap<String,STentry>();
	private int offsetFields;               						// offset (<=-1) da usare per un nuovo field                                                                                  (decrementati)
	private int offsetMethods;               						// offset (>=0) da usare per nuovo metodo
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
	public CTentry(Node d, int nl)
	{
		dec = d;
		nestingLevel = nl;
	}
	
	public CTentry(Node d)
	{
		dec = d;
	}
	
	private void setMethodOffset(int offset)
	{
		offsetMethods = offset;
	}
	
	private void setFieldOffset(int offset)
	{
		offsetFields = offset;
	}
	
	private void setMethod(Node method)
	{
		allMethods.add(method);
	}
	
	private void setField(Node field)
	{
		allFields.add(field);
	}
	
	public void addType(Node t)
	{
		type = t;
	}

	
	public String toPrint(String string) {
		// TODO Auto-generated method stub
		return "CTentry";
	}

	public Node getType() {
		// TODO Auto-generated method stub
		return type;
	}
}
