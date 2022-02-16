
public class Instruction {
	
	private String insName;
	private String sourceRegister1;
	private String sourceRegister2;
	private String destinationRegister;
	private int address;
	private String register;
	private String PC;
	private String operand1;
	private String operand2;
	
	public Instruction() {
		
	}

	public Instruction(String insName,String destinationRegister, String sourceRegister1, String sourceRegister2
			) {
		
		this.insName = insName;
		this.sourceRegister1 = sourceRegister1;
		this.sourceRegister2 = sourceRegister2;
		this.destinationRegister = destinationRegister;
	}

	public Instruction(String insName, String sourceRegister1, String destinationRegister, int address) {
		
		this.insName = insName;
		this.sourceRegister1 = sourceRegister1;
		this.destinationRegister = destinationRegister;
		this.address = address;
	}


	
	public Instruction(String insName, String register, int address) {
		
		this.insName = insName;
		this.address = address;
		this.register = register;
	}

	public Instruction(String insName, int address) {
	
		this.insName = insName;
		this.address = address;
	}

	public Instruction(String insName,String operand1,String operand2) {
		this.insName=insName;
		this.operand1=operand1;
		this.operand2=operand2;
	}
	
	
	
    public String getBinary(String registr) {
     
      int decimal=getDecimal(registr);
      String binary=Integer.toBinaryString(decimal);
      
      while(binary.length()<3) {
    	  binary="0"+binary;   
      }
      
      return binary;
   
    }
	
	public int getDecimal(String decimalstr) {
		
		char ch;
    	ch=decimalstr.charAt(1);
	    int value = Integer.parseInt(String.valueOf(ch)); 
	    return value;  
	    
	}
	
	public void getHex2(String binarystr){
		   
			int digitNumber = 1;
		    int sum = 0;
		
		    for(int i = 0; i < binarystr.length(); i++){
	        if(digitNumber == 1)
	            sum+=Integer.parseInt(binarystr.charAt(i) + "")*8;
	        else if(digitNumber == 2)
	            sum+=Integer.parseInt(binarystr.charAt(i) + "")*4;
	        else if(digitNumber == 3)
	            sum+=Integer.parseInt(binarystr.charAt(i) + "")*2;
	        else if(digitNumber == 4 || i < binarystr.length()+1){
	            sum+=Integer.parseInt(binarystr.charAt(i) + "")*1;
	            digitNumber = 0;
	            if(sum < 10)
	                System.out.print(sum);
	            else if(sum == 10)
	                System.out.print("A");
	            else if(sum == 11)
	                System.out.print("B");
	            else if(sum == 12)
	                System.out.print("C");
	            else if(sum == 13)
	                System.out.print("D");
	            else if(sum == 14)
	                System.out.print("E");
	            else if(sum == 15)
	                System.out.print("F");
	            sum=0;
	        }
	        digitNumber++;  
	    }
	}

	
	
	public String getHex(String binarystr){
		   
			int digitNumber = 1;
		    int sum = 0;
		    String hex="";
		    String sumstr;
		    
		    for(int i = 0; i < binarystr.length(); i++){
	        if(digitNumber == 1)
	            sum+=Integer.parseInt(binarystr.charAt(i) + "")*8;
	        else if(digitNumber == 2)
	            sum+=Integer.parseInt(binarystr.charAt(i) + "")*4;
	        else if(digitNumber == 3)
	            sum+=Integer.parseInt(binarystr.charAt(i) + "")*2;
	        else if(digitNumber == 4 || i < binarystr.length()+1){
	            sum+=Integer.parseInt(binarystr.charAt(i) + "")*1;
	            digitNumber = 0;
	            if(sum < 10) {
	               
	            	sumstr=String.valueOf(sum);
	            	hex+=sumstr;
	            }
	            	else if(sum == 10) {
	                
	            hex+="A";
	            	}
	            else if(sum == 11) {
	                
	            hex+="B";
	            }
	            else if(sum == 12) {
	                
	            hex+="C";
	            }
	            else if(sum == 13) {
	              
	            hex+="D";
	            }
	            else if(sum == 14) {
	                
	            hex+="E";
	            }
	            else if(sum == 15) {
	                
	            hex+="F";
	            }
	            	sum=0;
	        }
	        digitNumber++;  
	    
		    
		    
		    }
	
	        return hex;
	}
	
	
	
	 public String getBinaryImm(int addr) {
		 
		 String binary=Integer.toBinaryString(addr);
		 int len =binary.length();
		 if(addr<0) {
	     
			 binary=binary.substring(len-5, len);
			 
	     }

         if(addr>=0) {
	      while(binary.length()<5) {
	    	  binary="0"+binary;   
	      }
         }

               return binary;
	    
	 }
	
	
	
      public String getBinaryNine(int addr) {
		 
		 String binary=Integer.toBinaryString(addr);
		 int len =binary.length();
		 if(addr<0) {
	     
			 binary=binary.substring(len-9, len);
			 
	     }

         if(addr>=0) {
	      while(binary.length()<9) {
	    	  binary="0"+binary;   
	      }
         }

               return binary;
	    
	 }
	 
	 
	 
	 
      public String getBinaryTwelve(int addr) {
 		 
 		 String binary=Integer.toBinaryString(addr);
 		 int len =binary.length();
 		 if(addr<0) {
 	     
 			 binary=binary.substring(len-12, len);
 			 
 	     }

          if(addr>=0) {
 	      while(binary.length()<12) {
 	    	  binary="0"+binary;   
 	      }
          }

                return binary;
 	    
 	 }
	 
	 
	
}
