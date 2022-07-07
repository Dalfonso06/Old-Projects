/*
 * This class uses ArrayList to store Card type variables and the random
 * import to shuffle the array.
 */
package sortedcards;
import java.util.Random;

/**
 * Creates an ArrayList of cards to create a full deck of 52, shuffles the deck,
 * and returns the top card on the deck.
 * @author danielalfonso
 */
public class Deck {
    
    private int DECK_SIZE = 52; // The amount in a deck.
    public Card[] deck = new Card[DECK_SIZE]; // To hold all cards.
    // Holds the suit characters (spades, clubs, etc).
    private String[] suits = {"\u2660", "\u2663", "\u2665", "\u2666"};
    private Random rand = new Random(); // used in the shuffle method.
    
    /**
     * A constructor that creates the deck and assigns the ArrayList deck with 
     * 52 cards.
     */
    Deck() {
        
        // Adds the cards to the deck.
        int cardIndex = 0;
        for (int i = 0; i < suits.length; i++) {
            for (int u = 2; u <= 14; u++) {
                deck[cardIndex] = new Card(u, suits[i]);
                cardIndex++;
            }
        }
        
        
    }
    
    /**
     * Removes the top card from the deck ArrayList.
     * @return Last item on the deck ArrayList.
     */
    public Card topDeck() {

        Card topCard = deck[0]; // Holds the top card of the deck.
        
        // Moves all the items down one in the array.
        for (int i = 0; i < (deck.length - 1); i++) {
            deck[i] = deck[i + 1];
        }
        // Sets the last spot on the deck as a "none" Card.
        deck[deck.length - 1] = new Card(-1, "none");
        
        return topCard;
    }
    
    /**
     * Shuffles the deck four times by changing the card at i, with a random
     * card in the deck.
     */
    public void shuffle() {
        
        Card placeHolder; // Hold the original spot to flip.
        int j; // Where to start the shuffle.
        
        for (int u = 0; u < 4; u++){ // To shuffle the deck 4 times. 
            
            for (int i = 0; i < DECK_SIZE; i++) { // Go through every card.
                
                j = i;
                placeHolder = deck[j]; // Hold card at index i.
                int randIndex = rand.nextInt(DECK_SIZE); // Grabs random int.               
                
                // Shifts all the cards up till the random index.
                if (j < randIndex) {
                    for (j = i; j < randIndex; j++) {
                        deck[j] = deck[j + 1];
                    }
                
                // Moves all the cards down till the random index.
                } else if (j > randIndex) {
                    for (j = i; j > randIndex; j--) {
                        deck[j] = deck[j - 1];
                    } 
                } 
                
                deck[randIndex] = placeHolder;          
                
            }
        }
        
    }
    
}
