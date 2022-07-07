package sortedcards;

/**
 * This class creates a new object of "Card" to use later for the Deck class.
 * @author danielalfonso
 */
public class Card {
     
    private int rank; // to store the rank value.
    private String suit; // to store the suit value.
    
    /**
     * A constructor that creates the card.
     * @param rank Integer that sets the rank value.
     * @param suit String that sets the suit.
     */
    Card(int rank, String suit) {
        this.rank = rank;
        this.suit = suit;
    }
    
    /**
     * Returns the value of the card.
     * @return the rank integer.
     */
    public int getRank() {
        return rank;
    }
    
    /**
     * Returns the suit of the card.
     * @return the suit string.
     */
    public String getSuit() {
        return suit;
    }
    
    /**
     * A toString method that returns a card to a string.
     * @return the rank of the card and suit joined with "of."
     */
    public String toString() {
        
        // if rank == 11, 12, 13, or 14 return proper face letter. (11 = "J")
        switch(rank) { 
            case 11: 
                return 'J' + suit;           
            case 12:
                return 'Q' + suit;
            case 13:
                return 'K' + suit;
            case 14:
                return 'A' + suit;
            default:
                // For all other numbers.
                return rank + suit;
        }
    }
}
