import java.util.Objects;
// Card class represents a playing card
public class Card {
    // Private variables to store rank and suit of the card
    private String rank;
    private String suit;
    // Constructor to initialize rank and suit values
    public Card(String rank, String suit) {
        this.rank = rank;  // Assigns rank value to the card
        this.suit = suit;  // Assigns suit value to the card
    }
    // Converts the Card object into a readable string
    @Override
    public String toString() {
        return rank + " of " + suit;
    }
    // Compares two Card objects to check whether they are equal
    @Override
    public boolean equals(Object o) {
        // Checks if both references point to the same object
        if (this == o) {
            return true;
        }
        // Checks whether the given object belongs to Card class
        if (!(o instanceof Card)) {
            return false;
        }
        // Typecasts the object into Card class
        Card other = (Card) o;
        // Compares rank and suit of both cards
        // Returns true if both rank and suit are equal
        return Objects.equals(this.rank, other.rank)
                && Objects.equals(this.suit, other.suit);
    }
    // Generates a hash code based on rank and suit
    @Override
    public int hashCode() {
        // Returns hash code using rank and suit values
        return Objects.hash(rank, suit);
    }
}
