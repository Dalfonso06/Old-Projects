/*
 * Class that actually plays the Nim game.
 */
package nin;

/**
 * Class to play the game of Nim.
 * @author danielalfonso
 */
public class Nim {

    private Pile marbles;
    
    public String play(Player player1, Player player2) {
        
        int pileSize = marbles.getMarbles(); // Gets size of pile.
        
        int tracker = 1; 
        
        System.out.println("Total marbles: " + pileSize);
        while (pileSize != 0) {
            
            // Checks if it's player one's turn.
            if (tracker == 1) {
                
                // Player 1 goes first.
                System.out.println("Player 1 chooses " +
                        player1.move(marbles) + " marbles");
                tracker = 2;
                System.out.println("Total marbles: " + pileSize);
                
            // Checks if it isn't player one's turn.
            } else {
                
                player2.move(marbles); // Player 2 goes after.
                tracker = 1;
                System.out.println("Total marbles: " + pileSize);
                
            }
        }
        
        // This means player 1 picked last, therefore lost.
        if (tracker == 2) {
            
            return player2.playerName();
            
        // Player 2 picked last therefore player 2 loses.
        } else if (tracker == 1) {
            
            return player1.playerName();
        }
        
        return "No one wins";
    }
    
}
