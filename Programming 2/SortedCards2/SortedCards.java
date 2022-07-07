/*
 * Daniel Alfonso
 * PID: 6096463
 * COP3337 U04 1201
 */
package sortedcards;
import javax.swing.JOptionPane;
import java.io.PrintWriter;
import java.io.File;
import java.io.IOException;

/**
 *
 * @author danielalfonso
 */
public class SortedCards {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        String m;
        String fileName = "Hands.txt";
        PrintWriter writer = null;
        
        try {
            File file = new File(fileName);
        
            if (!file.exists()) {
                file.createNewFile();
            }
            
            writer = new PrintWriter(fileName);
        
        } catch (IOException e) {
            
            e.printStackTrace();
            
        }
        
        
        
        
  
        do {
            
            m = JOptionPane.showInputDialog(null,   "How many cards would you"
                    + " like to deal", "Enter Number");
            
            if (m != null) {
                Hand myHand = new Hand(Integer.parseInt(m));
                myHand.fillHand();
                JOptionPane.showMessageDialog(null, myHand);
                writer.println(myHand);
            }
            

        } while (m != null); 
        
        writer.close();
    }
    
}
