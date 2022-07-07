/*
 * Below Average Computer
 */
package nin;
import java.util.Random;

/**
 * Class for the Below Average Computer to play.
 * @author danielalfonso
 */
public class BelowAverageComputer implements Player {
    
    private Random rand = new Random();
    
    /**
     * Picks a random number of marbles that it is allowed to take from the
     * pile and returns that number.
     * @param marbles
     * @return The number picked.
     */
    @Override
    public int move(Pile marbles) {
        
        // Grabs the pile size.
        int pileSize = marbles.getMarbles();
        // Random number of half the pile size.
        int marble = rand.nextInt(pileSize / 2);
        
        return marble;
    }
    
    /**
     * Returns name of the Below Average Computer.
     * @return 
     */
    @Override
    public String playerName() {
       
        return "Below Average Computer";
    }

    
    
}
