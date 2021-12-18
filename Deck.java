import java.util.ArrayList;

public class Deck {
    private ArrayList<Card> cards;

    public Deck() {
        this.cards = makeDeck();
    }

    private ArrayList<Card> makeDeck() {
        ArrayList<Card> deck = new ArrayList<Card>();
        String[] suits = { "Spades", "Hearts", "Diamonds", "Clubs" };
        String[] ranks = { "Ace", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Jack",
                "Queen", "King" };
        for (String suit : suits) {
            for (String rank : ranks) {
                deck.add(new Card(suit, rank));
            }
        }
        return deck;
    }

    public ArrayList<Card> shuffle() {
        ArrayList<Card> shuffledDeck = new ArrayList<Card>();
        for (int i = 52; i > 0; i--) {
            int randomIndex = (int) (Math.random() * i);
            shuffledDeck.add(this.cards.get(randomIndex));
        }
        return shuffledDeck;
    }

    public static void main(String[] args) {
        Deck deck = new Deck();
        System.out.println(deck.shuffle());
    }
}