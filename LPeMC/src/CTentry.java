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
	
	public CTentry(Node d, int nl)
	{
		dec = d;
		nestingLevel = nl;
		locals = new HashSet<Integer>();
	}
	
	// If the field passed in input exists already in the 'allFields' data structure the new item is placed at its place and the function returns 'true' (meaning: yes, there has been overriding).
	// Otherwise, the function adds the new item and returns 'false' (meaning: no overriding).
	public boolean setFieldAndCheck(Node node, String s)
	{
		for(int i = 0;i < allFields.size();i++)
		{
			if(((FieldNode)allFields.get(i)).getName().equals(s))
			{
				allFields.set(i, node);
				offsetFields++;	 // Adjusting the offset to consider the replaced item (one less item will be in the list, so we go e.g. from -3 to -2 -> only 2 fields are set).
				return true;
			}
		}
		
		allFields.add(node);
		return false;
	}
	
	public void addLocals(int i)
	{
		locals.add(i);
	}
	
	public boolean setMethodAndCheck(Node node, String s)
	{
		for(int i = 0;i < allMethods.size();i++)
		{
			if(((MethodNode)allMethods.get(i)).getName().equals(s))
			{				
				allMethods.set(i, node);
				offsetMethods--;				
				return true;
			}
		}

		allMethods.add(node);
		return false;
	}
	
	public void setField(Node field)
	{
		allFields.add(field);
	}
	
	public void setFieldOffset(int offset)
	{
		offsetFields = offset;
	}
	
	public int getFieldOffset()
	{
		return offsetFields;
	}
	
	public void decFieldOffset()
	{
		offsetFields--;
	}
	
	public void setMethod(Node method)
	{
		allMethods.add(method);
	}
	
	public void setMethodOffset(int offset)
	{
		offsetMethods = offset;
	}
	
	public int getMethodOffset()
	{
		return offsetMethods;
	}
	
	public void incMethodOffset()
	{
		offsetMethods++;
	}
	
	
	public void setFields(ArrayList <Node> fList)
	{
		allFields = fList;
	}
	
	public void setMethods(ArrayList <Node> mList)
	{
		allMethods = mList;
	}
	
	public ArrayList<Node> getFields()
	{
		return allFields;
	}

	public ArrayList<Node> getMethods()
	{
		return allMethods;
	}
	
	
	public void addType(Node t)
	{
		type = t;
	}

	public String toPrint(String string)
	{
		return "CTentry";
	}

	public Node getType()
	{
		return type;
	}

	public int getNestinglevel()
	{
		return nestingLevel;
	}

	public HashMap<String,STentry> getVirtualTable()
	{
		return vTable;
	}

	public void setVirtualTable(HashMap<String,STentry> vt)
	{
		vTable = vt;
	}
	
	// This function returns 'true' if the variable 'locals' contains the offset passed in input. 
	public boolean checkLocals(int offset)
	{
		return locals.contains(offset);
	}
	
	public Node getDec()
	{
		return dec;
	}
	
	public HashSet<Integer> getLocals()
	{
		return locals;
	}
}
