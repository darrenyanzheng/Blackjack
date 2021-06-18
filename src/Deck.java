
import java.util.ArrayList;
import java.util.Random;

public class Deck {
    private ArrayList<Card> cards;

    public Deck() {
        cards = new ArrayList<>();
    }

    public void createDeck() {
        for (Card.Suit cardSuit : Card.Suit.values()) {
            for (Card.Face cardFace : Card.Face.values()) {
                cards.add(new Card(cardSuit, cardFace));
            }
        }
    }

    public String toString() {
        String cardListOutput = " ";
        for (Card aCard : this.cards) {
            cardListOutput += "\n" + "-" + aCard.toString();


        }
        return cardListOutput;
    }

    public void shuffle() {
        ArrayList<Card> tempDeck = new ArrayList<Card>();
        Random rand = new Random();
        int randomIndex = 0;
        int sizeOfDeck = this.cards.size();
        for (int i = 0; i < sizeOfDeck; i++) {
            randomIndex = rand.nextInt((this.cards.size() - 1) + 1);
            tempDeck.add(this.cards.get((randomIndex)));
            this.cards.remove(randomIndex);
        }
        this.cards = tempDeck;
    }

    public void removeCard(int i) {
        this.cards.remove(i);
    }

    public void addCard(Card cardToAdd) {
        this.cards.add(cardToAdd);
    }

    public Card getCard(int i) {
        return this.cards.get(i);
    }

    public void draw(Deck playingDeck) {
        this.cards.add(playingDeck.getCard(0));
        playingDeck.removeCard(0);
    }

    public int valueOfCards() {
        int value = 0;
        int aces = 0;

        for (Card card : this.cards) {
            switch (card.getFace()) {
                case TWO:
                    value += 2;
                    break;
                case THREE:
                    value += 3;
                    break;
                case FOUR:
                    value += 4;
                    break;
                case FIVE:
                    value += 5;
                    break;
                case SIX:
                    value += 6;
                    break;
                case SEVEN:
                    value += 7;
                    break;
                case EIGHT:
                    value += 8;
                    break;
                case NINE:
                    value += 9;
                    break;
                case TEN:
                    value += 10;
                    break;
                case JACK:
                    value += 10;
                    break;
                case QUEEN:
                    value += 10;
                    break;
                case KING:
                    value += 10;
                    break;
                case ACE:
                    aces++;
                    break;
            }
        }
        for (int i = 0; i < aces; i++) {
            if (value > 10) {
                value += 1;
            } else {
                value += 11;
            }
        }


        return value;
    }

    public int deckSize() {
        return this.cards.size();
    }

    public void resetDeck(Deck masterDeck) {
        int deckList = this.cards.size();
        for (int i = 0; i < deckList; i++) {
            masterDeck.addCard(this.getCard(i));

        }
    }
}


