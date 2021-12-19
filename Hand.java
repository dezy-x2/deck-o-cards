import java.util.ArrayList;

public class Hand {
    private ArrayList<Card> cards;
    public String name;

    public Hand(String name) {
        // holds the cards and the name of the player
        this.name = name;
        this.cards = new ArrayList<Card>();
    }

    public Card getNextCard() {
        // returns the next card in the deck
        return this.cards.remove(0);
    }

    public void addCard(Card card) {
        // adds a card to the hand
        this.cards.add(card);
    }

    @Override
    public String toString() {
        // prints each card in the hand
        String hand = this.name + "'s hand:\n";
        for (Card card : this.cards) {
            hand += card.toString() + "\n";
        }
        return hand;
    }

    static void main(String[] args) {

    }
}