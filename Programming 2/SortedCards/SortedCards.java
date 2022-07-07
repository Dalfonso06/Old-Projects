/*
 * Daniel Alfonso
 * PID: 6096463
 * COP3337 U04 1201
 */
package sortedcards;
import javax.swing.JOptionPane;
/**
 *
 * @author danielalfonso
 */
public class SortedCards {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        int m;
        
        do {
            
            Hand myHand = new Hand();
            myHand.fillHand();
            
            m = JOptionPane.showConfirmDialog(null, myHand + "\n would"
                    + " you like to go again?", "Card Sorter", 
                    JOptionPane.YES_NO_OPTION);
            
             
        } while (m != 1);
                
    }
    
}
