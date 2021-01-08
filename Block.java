import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.SequenceInputStream;
import java.util.Date;

public class Block {
	public String hash;
	public String previousHash;
	private String productInfo; //our data will be a simple message.
	private long timeStamp; //as number of milliseconds since 1/1/1970.
	private int nonce;

    
public String calculateHash() {
	String calculatedhash = StringUtil.applySha256( 
			previousHash +
			productInfo +
			Long.toString(timeStamp) +
			Integer.toString(nonce) 
			);
	return calculatedhash;
}

	//Block Constructor.
	public Block(String content,String previousHash) {
		this.productInfo = content;
		this.previousHash = previousHash;
		this.timeStamp = new Date().getTime();
		this.hash = calculateHash(); //Making sure we do this after we set the other values.

	}
	
	public Block(StringBuilder sb, String previousHash2) {
		// TODO Auto-generated constructor stub
	}
	

	
	public static void main (String args[]) throws IOException {
		
		String file1 = ("C:\\Users\\kyle.yorke\\eclipse-workspace\\KyleBlockchain\\A.txt");
		String file2 = ("C:\\Users\\kyle.yorke\\eclipse-workspace\\KyleBlockchain\\B.txt");
		InputStream fis1 = new FileInputStream(file1);
        @SuppressWarnings("resource")
		InputStream fis2 = new FileInputStream(file2);
        
        @SuppressWarnings("resource")
		InputStream sis = new SequenceInputStream(fis1, fis2);
        
       // System.out.println("Read data from "+file1+" & "
              //  +file2 +" using SequenceInputStream");
   
   int ch;
   while ((ch = sis.read()) != -1) { // read till end of file of both files
          System.out.print((char) ch);
   }

	try{
		
	       //  DataInputStream dis = 
		  //  new DataInputStream (
		    //	 new FileInputStream ("C:\\Users\\kyle.yorke\\eclipse-workspace\\KyleBlockchain\\A.txt"));
		     //  
		// byte[] datainBytes = new byte[dis.available()];
		// dis.readFully(datainBytes);
		// dis.close();
		       
		// String content = new String(datainBytes, 0, datainBytes.length);
		     
		// System.out.println(content);
		 
	}catch(Exception ex){
		ex.printStackTrace();
	}
		
  }
	public void mineBlock(int difficulty) {
		String target = new String(new char[difficulty]).replace('\0', '0'); //Create a string with difficulty * "0" 
		while(!hash.substring( 0, difficulty).equals(target)) {
			nonce ++;
			hash = calculateHash();
		}
		System.out.println("Block Mined!!! : " + hash);
	}
}
