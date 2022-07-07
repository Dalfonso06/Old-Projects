 /*
 * This class uses ArrayList to store Card type variables and the random
 * import to shuffle the array.
 */
package sortedcards;
import java.util.ArrayList;
import java.util.Random;

/**
 * Creates an ArrayList of cards to create a full deck of 52, shuffles the deck,
 * and returns the top card on the deck.
 * @author danielalfonso
 */
public class Deck {
    
    private ArrayList<Card> deck = new ArrayList<Card>(); // To hold all cards.
    private ArrayList<String> suits = new ArrayList<String>(); // hold suits.
    private Random rand = new Random(); // used in the shuffle method.
    
    /**
     * A constructor that creates the deck and assigns the ArrayList deck with 
     * 52 cards.
     */
    Deck() {
        
        // Adds all the suit symbols to the "suits" ArrayList.
        suits.add("\u2660");
        suits.add("\u2663");
        suits.add("\u2665");
        suits.add("\u2666");
        
        // Adds the cards to the deck.
        for (int i = 0; i < suits.size(); i++) {
            for (int u = 2; u <= 14; u++) {
                deck.add(new Card(u, suits.get(i)));
            }
        }
    }
    
    /**
     * Removes the top card from the deck ArrayList.
     * @return Last item on the deck ArrayList.
     */
    public Card topDeck() {
        
        // .remove() removes and returns the last item of the list.
        return deck.remove(deck.size() - 1);
    }
    
    /**
     * Shuffles the deck four times by changing the card at i, with a random
     * card in the deck.
     */
    public void shuffle() {
        
        Card placeHolder; // hold the original spot to flip.
        int DECK_SIZE = 52;
        
        for (int u = 0; u < 4; u++){ // To shuffle the deck 4 times. 
            for (int i = 0; i < DECK_SIZE; i++) {
                int randint = rand.nextInt(DECK_SIZE);
                placeHolder = deck.get(i);
                deck.set(i, deck.get(randint));
                deck.set(randint, placeHolder);
            }
        }
        
    }
    
}
