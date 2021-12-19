import java.util.ArrayList;

public class Hand {
    private ArrayList<Card> cards;
    public String name;

    public Hand(String name) {
        // holds the cards and the name of the player
        this.name = name;
        this.cards = new ArrayList<Card>();
    }

    public ArrayList<Card> getNextCard(int depth) {
        // returns the number of cards at the beginning of the hand specified by depth
        ArrayList<Card> removed = new ArrayList<Card>();
        for (int i = 0; i < depth; i++) {
            removed.add(this.cards.remove(0));
        }
        return removed;
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