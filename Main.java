import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
		
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
        	
		
	    try {
	    File file = new File("input.txt");
	    Scanner scan =new Scanner(file);
	    FileWriter writer = new FileWriter("output.txt");
	    
	    writer.write("v2.0 raw");
        writer.write("\n");
	    
        while(scan.hasNextLine()) {
		String[] simpleArray = scan.nextLine().split("\\s",2);
		String[] simpleArray2 =	simpleArray[1].split(",");
        
        String binarystring;
        String opcode;
        
       
        if(simpleArray[0].equals("ADD")) {
        
            
        opcode="0001";
	    
	    Instruction addinstruction = new Instruction(simpleArray[0],simpleArray2[0],simpleArray2[1],simpleArray2[2]);
	    
	    binarystring=opcode+addinstruction.getBinary(simpleArray2[0])+addinstruction.getBinary(simpleArray2[1])+
	    "000"+addinstruction.getBinary(simpleArray2[2]);
	       
        writer.write(addinstruction.getHex(binarystring));
        writer.write(" ");
       
        }
	    
        else if(simpleArray[0].equals("AND")) {
        
        
        opcode="0010";
        
        Instruction andinstruction = new Instruction(simpleArray[0],simpleArray2[0],simpleArray2[1],simpleArray2[2]);
        
        binarystring=opcode+andinstruction.getBinary(simpleArray2[0])+andinstruction.getBinary(simpleArray2[1])+
        	    "000"+andinstruction.getBinary(simpleArray2[2]);
        

	    writer.write(andinstruction.getHex(binarystring));
	    writer.write(" ");
        
        
        }
	    
        else if(simpleArray[0].equals("ADDI")) {
        
       
        opcode="0011";
        int immfive =Integer.parseInt(String.valueOf(simpleArray2[2]));
        Instruction addimmidiateinstruction	= new Instruction(simpleArray[0],simpleArray2[0],simpleArray2[1],immfive);
        binarystring=opcode+addimmidiateinstruction.getBinary(simpleArray2[0])+addimmidiateinstruction.getBinary(simpleArray2[1])+
                     "0"+addimmidiateinstruction.getBinaryImm(immfive);
        

	    writer.write(addimmidiateinstruction.getHex(binarystring));
	    writer.write(" ");
        }
        
        else if(simpleArray[0].equals("ANDI")) {
        
        
        opcode="0100";	
        int immfive =Integer.parseInt(String.valueOf(simpleArray2[2]));
        Instruction andimmidiateinstruction	= new Instruction(simpleArray[0],simpleArray2[0],simpleArray2[1],immfive);
        binarystring=opcode+andimmidiateinstruction.getBinary(simpleArray2[0])+andimmidiateinstruction.getBinary(simpleArray2[1])+
                "0"+andimmidiateinstruction.getBinaryImm(immfive);	
        
        
        
	    writer.write(andimmidiateinstruction.getHex(binarystring));
	    writer.write(" ");
        
        }
        
        else if(simpleArray[0].equals("LD")) {
        
        opcode="0111";	
        int addressnine =Integer.parseInt(String.valueOf(simpleArray2[1]));	
        Instruction loadinstruction	= new Instruction(simpleArray[0],simpleArray2[0],addressnine);	
        binarystring=opcode+loadinstruction.getBinary(simpleArray2[0])+loadinstruction.getBinaryNine(addressnine);
           
        
        writer.write(loadinstruction.getHex(binarystring));
        writer.write(" ");
        	
        }
        
        else if(simpleArray[0].equals("ST")) {
       
        opcode="1000";	
        int addressnine =Integer.parseInt(String.valueOf(simpleArray2[1]));
        Instruction storeinstruction	= new Instruction(simpleArray[0],simpleArray2[0],addressnine);	
        binarystring=opcode+storeinstruction.getBinary(simpleArray2[0])+storeinstruction.getBinaryNine(addressnine);
        
       
	    //storeinstruction.getHex(binarystring);
	    writer.write(storeinstruction.getHex(binarystring));
	    writer.write(" ");
        
        }

        	
        	
        else if(simpleArray[0].equals("JMP")) {
        
        opcode="1001";
        int addresstwelve =Integer.parseInt(String.valueOf(simpleArray2[0]));
        Instruction jumpinstruction	= new Instruction(simpleArray[0],addresstwelve);
        binarystring=opcode+jumpinstruction.getBinaryTwelve(addresstwelve);
        

	    writer.write(jumpinstruction.getHex(binarystring));
	    writer.write(" ");
       
        }
        	
        	
        else if(simpleArray[0].equals("CMP")) {
        	
            opcode="0101";
            Instruction compareinstruction	= new Instruction(simpleArray[0],simpleArray2[0],simpleArray2[1]);
            binarystring=opcode+compareinstruction.getBinary(simpleArray2[0])+compareinstruction.getBinary(simpleArray2[1])+
            		"000000";
   
    	    writer.write(compareinstruction.getHex(binarystring));
    	    writer.write(" ");
        
        }
        	
        else if(simpleArray[0].equals("JE")) {
        	
            opcode="1010";
            int addresstwelve =Integer.parseInt(String.valueOf(simpleArray2[0]));
            Instruction jumpequalinstruction	= new Instruction(simpleArray[0],addresstwelve);
            binarystring=opcode+jumpequalinstruction.getBinaryTwelve(addresstwelve);

    	  
    	    writer.write(jumpequalinstruction.getHex(binarystring));
    	    writer.write(" ");
        
        }
        
        else if(simpleArray[0].equals("JA")) {
        	
            opcode="1011";
            int addresstwelve =Integer.parseInt(String.valueOf(simpleArray2[0]));
            Instruction jumpaboveinstruction	= new Instruction(simpleArray[0],addresstwelve);
            binarystring=opcode+jumpaboveinstruction.getBinaryTwelve(addresstwelve);
 
    	    writer.write(jumpaboveinstruction.getHex(binarystring));
    	    writer.write(" ");
        
        }
        
        else if(simpleArray[0].equals("JB")) {
        	
            opcode="1100";
            int addresstwelve =Integer.parseInt(String.valueOf(simpleArray2[0]));
            Instruction jumpbelowinstruction	= new Instruction(simpleArray[0],addresstwelve);
            binarystring=opcode+jumpbelowinstruction.getBinaryTwelve(addresstwelve);

    	    writer.write(jumpbelowinstruction.getHex(binarystring));
    	    writer.write(" ");
        
        }
        
        
        else if(simpleArray[0].equals("JBE")) {
        	
            opcode="1101";
            int addresstwelve =Integer.parseInt(String.valueOf(simpleArray2[0]));
            Instruction jumpbeloworequalinstruction	= new Instruction(simpleArray[0],addresstwelve);
            binarystring=opcode+jumpbeloworequalinstruction.getBinaryTwelve(addresstwelve);
   
    	    writer.write(jumpbeloworequalinstruction.getHex(binarystring));
    	    writer.write(" ");
        
        }
        
        
        
        else if(simpleArray[0].equals("JAE")) {
        	
            opcode="1110";
            int addresstwelve =Integer.parseInt(String.valueOf(simpleArray2[0]));
            Instruction jumpaboveorequalinstruction	= new Instruction(simpleArray[0],addresstwelve);
            binarystring=opcode+jumpaboveorequalinstruction.getBinaryTwelve(addresstwelve);
        
    	    writer.write(jumpaboveorequalinstruction.getHex(binarystring));
    	    writer.write(" ");
        
        }
           
	    }
	    writer.close();	
	    }
	   catch(FileNotFoundException e) {
		   System.out.println(e.getMessage());
	   }
	
	
	}
	
	
		
}
