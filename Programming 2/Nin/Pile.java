/*
 * Pile class.
 */
package nin;
import java.util.Random;

/**
 * Class to keep track of the pile of marbles.
 * @author danielalfonso
 */
public class Pile {
    
    private Random rand = new Random();
    private int totalPile; // Hold the total pile.
    
    /**
     * Constructor that instantiates totalPile with a number between 10 and 100.
     */
    public Pile() {
        
        totalPile = rand.nextInt(91) + 10;
    }
    
    /**
     * Method that returns 
     * @return instance variable
     */
    public int getMarbles() {
        
        return totalPile;
    }
    
    /**
     * Method to remove a determined amount of marbles.
     * @param removal 
     */
    public void removeMarbles(int removal) {
        
        // Total pile minus the amount passed in the parameter
        totalPile -= removal;
    }
    
}
