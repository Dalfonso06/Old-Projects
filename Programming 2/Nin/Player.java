/*
 * Interface for all the player types.
 */
package nin;

/**
 * Interface for all player classes to have implemented.
 * @author danielalfonso
 */
public interface Player {
    
    /**
     * A method that allows players to take marbles from the pile.
     * @param marbles to use the same Pile type object on all classes.
     * @return The marbles taken.
     */
    int move(Pile marbles);
    
    /**
     * Method that returns the name of player.
     * @return 
     */
    String playerName();
    
}
