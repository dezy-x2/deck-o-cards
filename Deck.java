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

    public void deal(ArrayList<Hand> hands) {
        ArrayList<Card> shuffledDeck = this.shuffle();
        int cardsPerHand = shuffledDeck.size() / hands.size();
        for (int i = 0; i < cardsPerHand; i++) {
            for (Hand hand : hands) {
                hand.addCard(shuffledDeck.remove(0));
            }
        }
        if (shuffledDeck.size() > 0) {
            for (Hand hand : hands) {
                try {
                    hand.addCard(shuffledDeck.remove(0));
                } catch (Exception e) {
                }
            }
        }
    }

    public static void main(String[] args) {
        Deck deck = new Deck();
        ArrayList<Hand> hands = new ArrayList<Hand>();
        String[] names = { "Joe", "Bob", "Sally", "Mary", "Tom" };
        for (String name : names) {
            hands.add(new Hand(name));
        }
        deck.deal(hands);
        for (Hand hand : hands) {
            System.out.println(hand.toString());
        }
    }
}