import java.util.ArrayList;

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

	public Node typeCheck() {
		/*
		ArrayList<Node> uniq = FOOLlib.getTotalDecMethodsAndFields(this);
		ArrayList<Node> pt = new ArrayList<Node>();
		for(Node n : uniq) {
			if(n instanceof FunNode) {
				((FunNode)n).typeCheck();
			} else if (n instanceof ParNode) {
			      pt.add(((ParNode)n).typeCheck());
			}
		}
		
	    return new ArrowTypeNode (pt, this);
	    */
		/*
		if(superEntry != null)//cioè se c'è ereditarietà
		{
			// ***** MARCO: secondo me qui c'è un problema. Invece di controllare tutti i tipi del child con tutti i tipi dei parametri del parent
			// dovremmo usare una variabile boolean flag che viene resettata dentro il primo ciclo (for(i...)) e che diventa true se c'è un riscontro (isSubtype restituisce True) nel secondo ciclo (for(j...)). 
			// Una volta fuori dal secondo ciclo ci sarebbe un controllo if(flag == false){ System.exit(0); }
			/*for(int i = 0; i < classEntry.allFields.size(); i++)
			{
				for(int j = 0; j < superEntry.allFields.size(); j++)
				{
					if(!FOOLlib.isSubtype(((FieldNode)classEntry.allFields.get(i)).getSymType(), 
							((FieldNode)superEntry.allFields.get(j)).getSymType()))
					{
						System.out.println("Wrong field type in field "+ 
								((FieldNode)superEntry.allFields.get(j)).getName() +" for class "+ name);
						System.exit(0);
					}
				}
			}
		 */
		/* 
		 * Checking the type of the fields in the child class to see if they match the parent class' fields' types.
		 */
		/*
			boolean flag = false;
			int i = 0;
			int j = 0;
			while( i < classEntry.allFields.size() )
			{
				while( j < superEntry.allFields.size() )
				{
					if( FOOLlib.isSubtype(((FieldNode)classEntry.allFields.get(i)).getSymType(), 
						((FieldNode)superEntry.allFields.get(j)).getSymType()) ){
						flag = true;
						break;
					}

					j++;
				}

				if(!flag)	// If no match has been found... 
				{
					System.out.println("Wrong field type in field "+ 
							((FieldNode)superEntry.allFields.get(--j)).getName() +" for class "+ name);
					System.exit(0);
				}

				i++;
			}

			/*
		 * Checking the types of the methods and their parameters with the parent class' methods.
		 */
		/*
			i=0;
			flag=false;
			while( i < classEntry.allMethods.size() )
			{
				j=0;
				while( j < superEntry.allMethods.size() )
				{
//					System.out.println("class SymType:"+((MethodNode)classEntry.allMethods.get(i)).getSymType()
//							+" for class "+name);
//					System.out.println("super SymType:"+((MethodNode)superEntry.allMethods.get(j)).getSymType()
//							+" for class "+name);
					if( FOOLlib.isSubtype(((MethodNode)classEntry.allMethods.get(i)).getSymType(), 
							((MethodNode)superEntry.allMethods.get(j)).getSymType()) )
					{
						flag = true;
						break;
					}

					j++;
				}

				if(!flag){
					System.out.println("class method name:"+((MethodNode)classEntry.allMethods.get(i)).getName()
							+" for class "+name);
					System.out.println("super method name:"+((MethodNode)superEntry.allMethods.get(j)).getName()
							+" for class "+name);

					System.out.println("Wrong method type in method "+ 
							((MethodNode)superEntry.allMethods.get(--j)).getName()+" for class: "+name);
					System.exit(0);
				}

				i++;
			}
		}

		//return new ClassTypeNode();
		 * 
		 */
		return new ClassTypeNode(name); //non siamo sicuri.
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
