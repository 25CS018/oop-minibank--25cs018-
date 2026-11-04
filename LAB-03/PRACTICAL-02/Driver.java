
public class Driver {
    public static void main(String[] args) {
        // Creates an array to store 6 unique Card objects
        Card[] cards = new Card[6];
        // Keeps track of the number of unique cards stored
        int count = 0;
        // Creates an array containing 6 Card objects
        Card[] newCards = {
            new Card("King", "Spades"),
            new Card("Queen", "Heart"),
            new Card("King", "Spades"),
            new Card("Ace", "Spades"),
            new Card("Queen", "Spades"),
            new Card("Ace", "Spades")
        };
        // Iterates through each card in the newCards array
        for (Card card : newCards) {
        // Assumes that the current card is not a duplicate
        boolean duplicate = false;
        // Checks the current card against previously stored cards
        for (int i = 0; i < count; i++) {
        // Compares the current card with the stored card
        if (card.equals(cards[i])) {
        // Prints a message if a duplicate card is found
                    System.out.println("Duplicate found: " + card);
                    // Marks the card as duplicate
                    duplicate = true;
                    // Stops checking because duplicate is already found
                    break;
                }
            }
            // Adds the card only if it is not a duplicate
            if (!duplicate) {
                cards[count] = card;
                // Increases count after adding a unique card
                count++;
            }
        }
    }
}
