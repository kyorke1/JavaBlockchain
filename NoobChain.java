import java.io.DataInputStream; 
import java.io.File; 
import java.io.FileInputStream; 
import java.io.PrintStream; 
import java.util.ArrayList; 
import com.google.gson.GsonBuilder; 

public class NoobChain { 
     
    public static ArrayList<Block> blockchain = new ArrayList<Block>(); 
    public static int difficulty = 1; 

    @SuppressWarnings("resource") 
    public static void main(String[] args) { 

        String content = null; 
        try{ 

            DataInputStream dis =  
            new DataInputStream ( 
            new FileInputStream ("C:\\Users\\kyle.yorke\\eclipse-workspace\\KyleBlockchain\\A.txt")); 
            PrintStream o = new PrintStream(new File("C:\\Users\\kyle.yorke\\eclipse-workspace\\KyleBlockchain\\BlockChains\\BlockChain.txt" + System.currentTimeMillis())); 
       

            byte[] datainBytes = new byte[dis.available()]; 
            dis.readFully(datainBytes); 
            dis.close(); 
             
            content = new String(datainBytes, 0, datainBytes.length); 

            content = content.replaceAll("\r\n", "    ");  

            //System.out.println(content); 

            //add our blocks to the blockchain ArrayList: 

        blockchain.add(new Block(content, "0d04aa1d08b55dbc99135d657a01113e42fb1c0c1aefe712e6d6624c5d69aeb6")); 
        System.out.println("Trying to Mine block 1... "); 
        blockchain.get(0).mineBlock(difficulty); 

        //blockchain.add(new Block("00002",blockchain.get(blockchain.size()-1).hash)); 

        //System.out.println("Trying to Mine block 2... "); 

        //blockchain.get(1).mineBlock(difficulty); 

         

        //blockchain.add(new Block("00003",blockchain.get(blockchain.size()-1).hash)); 

        //System.out.println("Trying to Mine block 3... "); 

        //blockchain.get(2).mineBlock(difficulty);     
   
        System.out.println("\nBlockchain is Valid: " + isChainValid());    
        String blockchainJson = new GsonBuilder().setPrettyPrinting().create().toJson(blockchain); 
        System.out.println("\nThe block chain: "); 
        System.out.println(blockchainJson); 

        System.setOut(o); 
        System.out.println(blockchainJson); 
    } 

        catch(Exception ex){ 
        ex.printStackTrace(); 
        } 
} 

    public static Boolean isChainValid() { 

        Block currentBlock;  
        Block previousBlock; 
        String hashTarget = new String(new char[difficulty]).replace('\0', '0'); 
        
        //loop through blockchain to check hashes: 

        for(int i=1; i < blockchain.size(); i++) { 

            currentBlock = blockchain.get(i); 

            previousBlock = blockchain.get(i-1); 

            //compare registered hash and calculated hash: 

            if(!currentBlock.hash.equals(currentBlock.calculateHash()) ){ 

                System.out.println("Current Hashes not equal");             

                return false; 

            } 

            //compare previous hash and registered previous hash 

            if(!previousBlock.hash.equals(currentBlock.previousHash) ) { 

                System.out.println("Previous Hashes not equal"); 

                return false; 

            } 

            //check if hash is solved 

            if(!currentBlock.hash.substring( 0, difficulty).equals(hashTarget)) { 

                System.out.println("This block hasn't been mined"); 

                return false; 

            } 

        } 

        return true; 

    } 

} 


//////////////////////////
//Coded by Kyle Yorke/////
//////////////////////////
 