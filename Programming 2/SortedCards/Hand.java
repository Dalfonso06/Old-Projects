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
    
    private ArrayList<Card> hand;
         
    /**
     * A constructor for the hand class that creates a new empty ArrayList
     * of Card.
     */
    Hand() {
        
        hand = new ArrayList<Card>(); 
    }
    
    /**
     * Places a card in the hand in the proper section.
     */
    public void fillHand() {
        
        Deck deck = new Deck(); // Creates a new deck.
        deck.shuffle(); // Shuffles the deck.
        int REST_OF_HAND = 12;
        
        // Adds the first card to the hand
        hand.add(deck.topDeck());   
        
        
        // Adds the remaining 12 cards in their proper location.
        for (int i = 0; i < REST_OF_HAND; i++) {
            
            Card card = deck.topDeck(); // Creates a card variable to work with.
            int counter = 0; // Keep track of amount of comparisons.
            
            // To check if the suit of the card was the same as one in the hand.
            boolean suitChecked = false;
            
            // Iterates through the hand.
            for (int u = 0; u < hand.size(); u++) {
                
                /* Checks if the suit of the card is the same as the suit in
                 * the hand. 
                 */
                if (hand.get(u).getSuit().equals(card.getSuit())) { 
                    
                    // To keep track if the suit was already seen before.
                    suitChecked = true;
                    
                    /* If the rank of the card is less than the card in the 
                     * hand it is checking, add the card at u index. 
                     */
                    if (card.getRank() < hand.get(u).getRank()) {
                        hand.add(u, card);
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
                     hand.add(u, card);
                     suitChecked = false; // Resets the boolean for next card.
                     break;
                } else {
                    counter++;
                }
            }
            
            /* If a card has been compared the amount of times as the size of
             * the list, then add it to the end of the hand.
             */
            if (counter == hand.size()) {
                hand.add(card);
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
        for (int i = 0; i < hand.size(); i++) {
            finalString += hand.get(i) + " ";
        }
        
        return finalString;
    }
}
