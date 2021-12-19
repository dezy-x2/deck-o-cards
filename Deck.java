import java.util.ArrayList;

public class Deck {
    private ArrayList<Card> cards;

    public Deck() {
        // set up arrayList to hold the cards
        this.cards = makeDeck();
    }

    private ArrayList<Card> makeDeck() {
        // create a new arrayList to hold the cards
        ArrayList<Card> deck = new ArrayList<Card>();
        String[] suits = { "Spades", "Hearts", "Diamonds", "Clubs" };
        String[] ranks = { "Ace", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Jack",
                "Queen", "King" };
        // loop through the suits and ranks and add a new card to the deck for each
        for (String suit : suits) {
            for (String rank : ranks) {
                deck.add(new Card(suit, rank));
            }
        }
        return deck;
    }

    public ArrayList<Card> shuffle() {
        // just randomly selects cards and puts them in a new arrayList
        ArrayList<Card> shuffledDeck = new ArrayList<Card>();
        for (int i = 52; i > 0; i--) {
            int randomIndex = (int) (Math.random() * i);
            shuffledDeck.add(this.cards.get(randomIndex));
        }
        return shuffledDeck;
    }

    public void deal(ArrayList<Hand> hands) {
        // gets a shuffled deck
        ArrayList<Card> shuffledDeck = this.shuffle();
        // find out how many cards per hand
        int cardsPerHand = shuffledDeck.size() / hands.size();
        for (int i = 0; i < cardsPerHand; i++) {
            for (Hand hand : hands) {
                hand.addCard(shuffledDeck.remove(0));
            }
        }
        // if there are any cards left, deal them to the first few hands
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