import java.io.*; 
public class txtreader
{ 
  public static void main(String[] args)throws Exception 
  	{ 
	  File userproductinformation = new File("C:\\Users\\kyle.yorke\\eclipse-workspace\\KyleBlockchain\\A.txt"); 
  
	  @SuppressWarnings("resource")
	  BufferedReader br = new BufferedReader(new FileReader(userproductinformation)); 
	  String stest; 
	  while ((stest = br.readLine()) != null) 
		  
		  
		  System.out.println(stest); 
  	} 
} 