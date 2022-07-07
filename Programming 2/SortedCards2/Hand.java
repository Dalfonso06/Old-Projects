/*
 * Uses Java ArrayList to hold cards for the hand
 */
package sortedcards;
import java.util.ArrayList;

/**
 * Adds thirteen cards from a shuffled deck and sorts them with their according
 * suit and proper position in rank.
 * @author danielalfonso
 */
public class Hand {
    
    private Card[] hand;
    private int amount;
         
    /**
     * A constructor for the hand class that creates a new empty ArrayList
     * of Card.
     */
    Hand(int amount) {
        
        // To only allow 52 cards in a deck.
        if (amount <= 52 && amount > 0) {
            hand = new Card[amount]; 
            this.amount = amount;
        } else if (amount < 0 || amount > 52) {
            hand = new Card[51];
            this.amount = 51;
        }
    }
    
    /**
     * Places a card in the hand in the proper section.
     */
    public void fillHand() {
        
        Deck deck = new Deck(); // Creates a new deck.
        deck.shuffle(); // Shuffles the deck.
        
        // Adds the first card to the hand
        hand[0] = deck.topDeck();
        
        
        // Adds the remaining 12 cards in their proper location.
        for (int i = 0; i < amount; i++) {
            
            Card card = deck.topDeck(); // Creates a card variable to work with.
            int counter = 0; // Keep track of amount of comparisons.
            
            // To check if the suit of the card was the same as one in the hand.
            boolean suitChecked = false;
            
            // Iterates through the hand.
            for (int u = 0; u < i; u++) {
                
                /* Checks if the suit of the card is the same as the suit in
                 * the hand. 
                 */
                if (card.getSuit().equals(hand[u].getSuit())) { 
                    
                    // To keep track if the suit was already seen before.
                    suitChecked = true;
                    
                    /* If the rank of the card is less than the card in the 
                     * hand it is checking, add the card at u index. 
                     */
                    if (card.getRank() < hand[u].getRank()) {
                        
                        for (int j = (hand.length - 1); j > u; j--) {
                            hand[j] = hand[j - 1];
                        }
                        hand[u] = card;
                        break; // Stops the loop to add the next card.
                        
                    } else {
                        // Adds to the counter.
                        counter++;
                    }
                
                /* Runs if the previous comparison was the same suit as the card
                 * but the next one isn't. This is the highest card of that 
                 * suit.
                 */
                } else if (suitChecked){
                     for (int j = (hand.length - 1); j > u; j--) {
                         hand[j] = hand[j - 1];
                     }
                     hand[u] = card;
                     suitChecked = false; // Resets the boolean for next card.
                     break;
                } else {
                    counter++;
                }
            }
            
            /* If a card has been compared the amount of times as the size of
             * the list, then add it to the end of the hand.
             */
            if (counter == i) {
                hand[i] = card;
                counter = 0; // Resets counter for next card.
            }
        }
    }    
    
    
    /**
     * Turns the ArrayList hand into a String.
     * @return ArrayList separated by spaces in a String.
     */
    public String toString() {
        
        String finalString = "";
        
        // For every item in hand, add to string with a space to separate it.
        for (int i = 0; i < hand.length; i++) {
            finalString += hand[i] + " ";
        }
        
        return finalString;
    }
}
