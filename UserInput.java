import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;

import javax.swing.*; 
 
  

public class UserInput { 

   public static void main(String[] args) throws FileNotFoundException { 
	  
	  PrintStream o = new PrintStream(new File("A.txt")); 
	  PrintStream console = System.out;
	   
      JTextField Field1 = (new JTextField(10)); 

      JTextField Field2 = new JTextField(10); 

      JTextField Field3 = new JTextField(10); 

      JTextField Field4 = new JTextField(10); 

      JTextField Field5 = new JTextField(10); 

  

      JPanel myPanel = new JPanel(); 

      myPanel.add(new JLabel("Time(hh:mm)")); 

      myPanel.add(Field1); 

      myPanel.add(Box.createVerticalStrut(15)); // a spacer 

      myPanel.add(new JLabel("Date(DD/MM/YYYY)")); 

      myPanel.add(Field2); 

      myPanel.add(Box.createVerticalStrut(15)); // a spacer 

      myPanel.add(new JLabel("Weight(kg)")); 

      myPanel.add(Field3); 

      myPanel.add(Box.createVerticalStrut(15)); // a spacer 

      myPanel.add(new JLabel("Manufacturer")); 

      myPanel.add(Field4); 

      myPanel.add(Box.createVerticalStrut(15)); // a spacer 

      myPanel.add(new JLabel("Location")); 

      myPanel.add(Field5); 

      myPanel.add(Box.createVerticalStrut(15)); // a spacer 

  

      int result = JOptionPane.showConfirmDialog(null, myPanel,  

               "Please enter the product details", JOptionPane.OK_CANCEL_OPTION); 

      if (result == JOptionPane.OK_OPTION) { 

    	 System.setOut(console); 
         System.out.println("Time: " + Field1.getText()); 

         System.setOut(console);
         System.out.println("Date:  " + Field2.getText()); 

         System.setOut(console);
         System.out.println("Weight: "  + Field3.getText() + "kgs"); 

         System.setOut(console);
         System.out.println("Maufacturer: " + Field4.getText()); 

         System.setOut(console);
         System.out.println("Location: " + Field5.getText()); 
         
         //written to a file
         System.setOut(o); 
         System.out.println("Time: " + Field1.getText()); 

         System.setOut(o);
         System.out.println("Date:  " + Field2.getText()); 

         System.setOut(o);
         System.out.println("Weight: "  + Field3.getText() + "kgs"); 

         System.setOut(o);
         System.out.println("Maufacturer: " + Field4.getText()); 

         System.setOut(o);
         System.out.println("Location: " + Field5.getText());
         
      } 

   } 

} 