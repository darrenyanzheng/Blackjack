
public class Card {

    public enum Suit {
        DIAMONDS, CLUBS, HEARTS, SPADES
    }
    public enum Face {
        ACE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING
    }
    private Suit suit;
    private Face face;

    public Card (Suit suit, Face face) {
        this.suit = suit;
        this.face = face;
    }
    public Suit getSuit() {
        return suit;
    }
    public Face getFace() {
        return face;
    }
    public String toString() {
        return this.suit.toString() + "-" +  this.face.toString();
    }
}
