import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

import com.sun.org.apache.bcel.internal.generic.Instruction;

public class ExecuteVM {
    
    public static final int CODESIZE = 10000;
    public static final int MEMSIZE = 10000;
    
    private int[] code;
    private int[] memory = new int[MEMSIZE];
    
    private int ip = 0;
    private int ra;
    private int rv;
    private int sp = MEMSIZE;
    private int fp = MEMSIZE;
    private int hp = 0;
    
    PrintWriter writer;		// This variable is used to store the output of the program in a file.
    
    public ExecuteVM(int[] code) {
    	// Codice di Debug che visualizza il codice del programma in linguaggio macchina.
        System.out.println("Generated code:");
        System.out.println("----------------------");
        for(int i=0; i<code.length; i++){
        	if(code[i] != 25 && code[i] != 5 && code[i] != 6 && code[i] != 7 && code[i] != 8){// 25 = PUSH, 5 = BRANCH, 6 = BRANCHEQ, 7 = BRANCHGR, 8 = BRANCHLESS
        		if(code[i]==0)
        			break;	// This control avoids to associate <invalid> strings to values that belong to the PUSH commands.
        		System.out.println(code[i] +"\t"+ SVMParser.tokenNames[code[i]].toString());
        	}else{
        		System.out.print(code[i] +"\t"+ SVMParser.tokenNames[code[i]].toString()+"   ");
        		System.out.println(code[++i]);
        	}
        }
        System.out.println("\nWe will now display the instructions of the code step by step. Together we display the state of the Stack (as \"stack pointer: stack value\").\nOnly the part of the Stack that contains useful values will be printed.");
        // After this, in the Console, we will show the stack and the state of the pointers for every step of the code during its execution.
        
        // Constructor
        this.code = code;
    }
    
    public void cpu() {
    	writer = null;
    	try {
    		writer = new PrintWriter("programOutput.txt", "UTF-8");
    	} catch (Exception e) {
    		System.out.println("! Unable to create the output file. See ExecuteVM.java. !");
    		e.printStackTrace();
    		System.exit(0);
    	}
    	
    	while ( true ) {
			dumpInstruction();	// Debug statement.

			int bytecode = code[ip++]; // fetch
			int arg1,arg2;
			switch ( bytecode ) {
			case SVMParser.PUSH:
				push( code[ip++] );
				break;
			case SVMParser.POP:
				pop();
				break;
			case SVMParser.ADD :
				arg2=pop();
				arg1=pop();
				push(arg1 + arg2);
				break;
			case SVMParser.MULT :
				arg2=pop();
				arg1=pop();
				push(arg1 * arg2);
				break;
			case SVMParser.DIV :
				arg2=pop();
				arg1=pop();
				push(arg1 / arg2);
				break;
			case SVMParser.SUB :
				arg2=pop();
				arg1=pop();
				push(arg1 - arg2);
				break;
			case SVMParser.STOREW :
				int address = pop();
				memory[address] = pop();    
				break;
			case SVMParser.LOADW :
				push(memory[pop()]);
				break;
			case SVMParser.BRANCH :
				address = code[ip];
				ip = address;
				break;
			case SVMParser.BRANCHEQ :
				address = code[ip++];
				arg2=pop();
				arg1=pop();
				if (arg1 == arg2) ip = address;
				break;
			case SVMParser.BRANCHLESS :
				address = code[ip++];
				arg2=pop();
				arg1=pop();
				if (arg1 <= arg2) ip = address;
				break;
			case SVMParser.BRANCHGR: 
				address = code[ip++];
				arg2=pop();
				arg1=pop();
				if (arg1 >= arg2) ip = address;
				break;

			case SVMParser.JS :
				address = pop();
				ra = ip;
				ip = address;
				break;
			case SVMParser.STORERA :
				ra=pop();
				break;
			case SVMParser.LOADRA :
				push(ra);
				break;
			case SVMParser.STORERV :
				rv=pop();
				break;
			case SVMParser.LOADRV :
				push(rv);
				break;
			case SVMParser.LOADFP :
				push(fp);
				break;
			case SVMParser.STOREFP :
				fp=pop();
				break;
			case SVMParser.COPYFP :
				fp=sp;
				break;
			case SVMParser.STOREHP :
				hp=pop();
				break;
			case SVMParser.LOADHP :
				push(hp);
				break;
			case SVMParser.PRINT :
				System.out.println((sp<MEMSIZE)?"\n>>> output >>>    "+memory[sp]+"\n":"Empty stack!");
				break;
			case SVMParser.HALT :	// The last command executed from the program.
				writer.close();	 // Closing the output file where all the output is memorised.
				System.out.println("\n_End of program_");
				return;
			}
		}
    }
    
    
    private int k=1;	// Variable used while displaying (and saving on a file) the instructions.
    private void dumpInstruction(){
    	System.out.println("----------------------------");
        System.out.print("- INSTRUCTION: "+ k++ + " - ");
        writer.println("----------------------------");
        writer.print("- INSTRUCTION: "+ k++ + " - ");
        
        if(ip > 10000)
        	System.out.println("Errore di esecuzione, l'IP è maggiore di 10000.");
        String command = SVMParser.tokenNames[code[ip]];
        if(command != "PUSH"  &&  command != "BRANCH"  &&  command != "BRANCHGR"  &&  command != "BRANCHEQ"  &&  command != "BRANCHLESS"){
        	System.out.println(command);
        	writer.println(command);
        }else{
        	System.out.print(command);
        	writer.print(command);
        	int tempIp = ip+1;
        	System.out.println(" "+code[tempIp]);
        	writer.println("  "+code[tempIp]);
        }
        System.out.println("  * SP: "+ sp +"\tFP: "+ fp +"\tIP: "+ ip);
        System.out.println("  * RA:"+ ra +"\tRV: "+rv +"\t\tHP:  "+hp);
        writer.println("  * SP: "+ sp +"\tFP: "+ fp +"\tIP: "+ ip);
        writer.println("  * RA:"+ ra +"\tRV: "+rv +"\t\tHP:  "+hp);
        
        dumpStack();
        dumpHeap();
    }
    
    // Function that displays the stack
    private void dumpStack(){
    	System.out.println("-------------- STACK --------------");
    	writer.println("-------------- STACK --------------");
    	for(int i=memory.length-1; i>=sp; i--){
    		System.out.println(i+": "+memory[i]);
    		writer.println(i+": "+memory[i]);
    	}  
    }
    // Function that displays the heap
    public final void dumpHeap(){
		
    	System.out.println("-------------- HEAP --------------");
    	writer.println("-------------- HEAP --------------");
    	for(int i=0; i<=hp; i++){
    		System.out.println(i+": "+memory[i]);
    		writer.println(i+": "+memory[i]);
    	}
    }
    
    private int pop() {
      return memory[sp++];
    }
    
    private void push(int v) {
      memory[--sp] = v;
    }
    
}