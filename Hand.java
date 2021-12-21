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
            try {
                removed.add(this.cards.remove(0));
            } catch (IndexOutOfBoundsException e) {
                break;
            }
        }
        return removed;
    }

    public int getSize() {
        // returns the size of the hand
        return this.cards.size();
    }

    public void addCard(Card card) {
        // adds a card to the hand
        this.cards.add(card);
    }

    public void addCard(ArrayList<Card> cards) {
        // adds an array of cards to the hand
        this.cards.addAll(cards);
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