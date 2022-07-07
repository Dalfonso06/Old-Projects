/*
 * User class
 */
package nin;
import java.util.Scanner;
/**
 * Class for the user to play Nim.
 * @author danielalfonso
 */
public class User implements Player {
    
    private Scanner scan = new Scanner(System.in);
    private String name = "None";
    
    /**
     * Constructor method that provides a name to the user.
     * @param name A string to set the private variable.
     */
    public User(String name) {
        
        this.name = name;
    }
    
    /**
     * A move method to return the marbles taken. Makes sure that human player
     * can't take an illegal amount of marbles (more than half).
     * @param marbles Pile type object to use same pile of marbles.
     * @return 
     */
    @Override
    public int move(Pile marbles) {
        
        int pileSize = marbles.getMarbles(); // Gets the size of pile.
        int marble = -10;
        
        /* 
         * Keeps asking user to pick a number again if they choose a number
         * greater than half or less than 0 i.e. a negative integer.
         */ 
        do {
            
            System.out.println(name + ", enter a number: ");
            marble = scan.nextInt();  
            
        } while (marble > pileSize || marble <= 0);
        
        return marble;
    }
    
    /**
     * A method that returns the player name.
     * @return 
     */
    @Override
    public String playerName() {
        
        return name;
    }
     
}
