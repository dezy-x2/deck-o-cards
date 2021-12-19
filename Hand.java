import java.util.ArrayList;

public class Hand {
    private ArrayList<Card> cards;

    public Hand() {
    }

    public Card getNextCard() {
        return this.cards.remove(0);
    }

    public void addCard(Card card) {
        this.cards.add(card);
    }

    @Override
    public String toString() {
        String hand = "";
        for (Card card : this.cards) {
            hand += card.toString() + "\n";
        }
        return hand;
    }

    static void main(String[] args) {

    }
}