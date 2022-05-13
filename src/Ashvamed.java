import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import decryption.Decrypt;
import encryption.Encrypt;

public class Ashvamed  {

	public static void main(String[] args)   
    {  
		Scanner sc= new Scanner(System.in);
		
		System.out.println("Enter the file path:");
		String filename=sc.nextLine();
		File file = new File(filename);
		byte[] encodedfile = null;
		byte[] bytes = null ;
	   
        
        while(true) {
     
          	System.out.println("\n1. Encrypt\n2. Decrypt\n3. Exit\n Choose an option:");
        	String ch=sc.nextLine();
        	if(ch.equals("1")) {
        		
        		try {
        			byte i=0;
        			int j=0;
         	        FileInputStream fileInputStreamReader = new FileInputStream(file);
         	        bytes = new byte[(int)file.length()];
         	        fileInputStreamReader.read(bytes);
         	        fileInputStreamReader.close();
//         	        for (byte integer : bytes) {
//						System.out.println(integer);
//					}
         	    } catch (FileNotFoundException e) {
         	        // TODO Auto-generated catch block
         	        e.printStackTrace();
         	    } catch (IOException e) {
         	        // TODO Auto-generated catch block
         	        e.printStackTrace();
         	    }
         		
        		
        		
                 System.out.println("Enter the key:");
                 String key=sc.nextLine();
                 System.out.println("Enter the salt:");
                 String salt=sc.nextLine();
                 
           
                 
        		 /* Call the encrypt() method and store result of encryption.     */
                String encryptedval = Encrypt.encrypt(bytes,key,salt);  
                
                System.out.println("Encrypted value: " + encryptedval);
                
                try {
              	  FileWriter writer = new FileWriter(filename, false);
              	  writer.write(encryptedval);
              	  writer.close();
              	} catch (IOException e) {
              	  e.printStackTrace();
              	} 
        	}

        	
        	else if(ch.equals("2")) {
        		
        		try {
         	        FileInputStream fileInputStreamReader = new FileInputStream(file);
         	        encodedfile = new byte[(int)file.length()];
         	        fileInputStreamReader.read(encodedfile);
         	       for (byte integer : encodedfile) {
						System.out.println(integer);
					}
         	        fileInputStreamReader.close();
         	    } catch (FileNotFoundException e) {
         	        // TODO Auto-generated catch block
         	        e.printStackTrace();
         	    } catch (IOException e) {
         	        // TODO Auto-generated catch block
         	        e.printStackTrace();
         	    }
         		
                 System.out.println("Enter the key:");
                 String key=sc.nextLine();
                 System.out.println("Enter the salt:");
                 String salt=sc.nextLine();
                 
                 
                 
        		 /* Call the decrypt() method and store result of decryption. */  
                String decryptedval = Decrypt.decrypt(encodedfile,key,salt);  
                
                System.out.println("Decrypted value: " + decryptedval); 
                
                try {
                	  FileWriter writer = new FileWriter(filename, false);
                	  writer.write(decryptedval);
                	  writer.close();
                	} catch (IOException e) {
                	  e.printStackTrace();
                	}  
        	}
        	else {
        		System.exit(0);
        	}
        }
             
    }  

}
