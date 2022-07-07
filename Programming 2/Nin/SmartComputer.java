/*
 * Smart Computer
 */
package nin;

/**
 * Class for the Smart Computer to play.
 * @author danielalfonso
 */
public class SmartComputer implements Player {
    
    
    /**
     * A move method that returns the amount of marbles taken.
     * @return 
     */
    @Override
    public int move(Pile marbles) {
        
        int pileSize = marbles.getMarbles(); // Amount of marbles
        int marble = -1; 
        
        // Smart computer will make the pile a size of 63, 31, 15, 7, 3, or 1.
        if (pileSize > 63) {
            
            marble = pileSize - 63;
            
        } else if (pileSize > 31) {
            
            marble = pileSize - 31;
            
        } else if (pileSize > 15) {
            
            marble = pileSize - 15;
            
        } else if (pileSize > 7) {
            
            marble = pileSize - 7;
            
        } else if (pileSize > 3) {
            
            marble = pileSize - 3;
            
        } else if (pileSize > 1) {
            
            marble = pileSize - 1;
            
        }
        
        return marble;     
    }
    
    /**
     * Returns the name of the Smart Computer.
     * @return 
     */
    @Override
    public String playerName() {
        
        return "Smart Computer";
    }
    
}
