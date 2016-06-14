import java.io.*;

import org.antlr.runtime.*;

public class Test {
    public static void main(String[] args) throws Exception {
    	
        String fileName = "prova.fool";//"testOptional_punto1.fool";//"testOptional_punto2.fool";//
        
        ANTLRFileStream input = new ANTLRFileStream(fileName);
        FOOLLexer lexer = new FOOLLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        FOOLParser parser = new FOOLParser(tokens);
        
        System.out.println("--- Parsing ---\n");
        Node ast = parser.prog(); 	//generazione AST con Id associate a relative entry symbol table
        System.out.println("You had: "+lexer.lexicalErrors+" lexical errors and "+parser.getNumberOfSyntaxErrors()+" syntax errors.");
        System.out.println("\n--- Abstract Syntax Tree ---");
        System.out.println(ast.toPrint(""));
        
        System.out.println("--- Type checking ---");
        Node type = ast.typeCheck(); //type-checking bottom-up 
        System.out.println(type.toPrint("Type checking ok! Type of the program is: "));
        
        System.out.println("--- Code generation ---");
     // ora consideriamo anche la SVM.g
     // estendiamo Node con un nuovo metodo: codeGeneration()
        String code = ast.codeGeneration();	// mettiamo tutto il codice assembler (che quando avevamo fatto l'assemblatore facevamo a mano) in una stringa.
     // lo mettiamo in un file.
        BufferedWriter out = new BufferedWriter(new FileWriter(fileName+".asm"));	// essendo .asm è un file per l'assemblatore. Per avere il metodo write() lo wrappiamo in un Buffered Writer.
        out.write(code);	// scriviamo il file
        out.close();
        System.out.println("Code generated! Assembling and running generated code.");
        
     // eseguiamo il codice assemblato tramite la nostra virtual machine (VM)
        ANTLRFileStream inputVM = new ANTLRFileStream(fileName+".asm");
        SVMLexer lexerVM = new SVMLexer(inputVM);
        CommonTokenStream tokensVM = new CommonTokenStream(lexerVM);
        SVMParser parserVM = new SVMParser(tokensVM);
        
        parserVM.assembly();
        
        System.out.println("\n--- Code execution ---");
        ExecuteVM vm = new ExecuteVM(parserVM.code);
        vm.cpu();  
        
    }
}
