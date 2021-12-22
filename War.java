import java.util.ArrayList;

public class War {
    public static void main(String[] args) {
        Hand jacksHand = new Hand("Jack");
        Hand johnsHand = new Hand("John");
        Deck deck = new Deck();
        deck.deal(new ArrayList<Hand>() {
            {
                add(jacksHand);
                add(johnsHand);
            }
        });
        playGame(jacksHand, johnsHand);
    }

    private static void playGame(Hand hand1, Hand hand2) {
        // continue playing until one of the hands is empty
        while (getWinner(hand1, hand2) == null) {
            System.out.println(hand1.getSize() + " " + hand2.getSize());
            // we get the active card for each player
            Card hand1PlayCard = hand1.getNextCard(1).get(0);
            Card hand2PlayCard = hand2.getNextCard(1).get(0);
            // find out who won the round or if it is war
            String roundResults = compareCards(hand1PlayCard, hand2PlayCard);
            if (roundResults.equals("card1")) {
                // if card1 wins give hand2's play card to hand1
                hand1.addCard(hand1PlayCard);
                hand1.addCard(hand2PlayCard);
            } else if (roundResults.equals("card2")) {
                // if card2 wins give hand1's play card to hand2
                hand2.addCard(hand2PlayCard);
                hand2.addCard(hand1PlayCard);
            } else if (roundResults.equals("war")) {
                // you have to give the play card back to the player who played it
                // if you don't there will be an err claiming that the player has no cards left
                hand1.addCard(hand1PlayCard);
                hand2.addCard(hand2PlayCard);
                handleWar(hand1, hand2);
            }
        }
        // find out who's the winner & give them their accolades
        Hand finalWinner = getWinner(hand1, hand2);
        if (finalWinner != null) {
            System.out.println(finalWinner.name + " wins!");
        }
    }

    private static void handleWar(Hand hand1, Hand hand2) {
        // get the cards that the players are gonna play in the war
        // we grab 4 instead of 3 so that we have their play card as well
        ArrayList<Card> cards1ForGrabs = hand1.getNextCard(4);
        ArrayList<Card> cards2ForGrabs = hand2.getNextCard(4);
        Card warCard1 = cards1ForGrabs.get(0);
        Card warCard2 = cards2ForGrabs.get(0);
        // find out who won
        String warResult = compareCards(warCard1, warCard2);
        if (warResult.equals("card1")) {
            // give the winner all the cards
            hand1.addCard(cards1ForGrabs);
            hand1.addCard(cards2ForGrabs);
        } else if (warResult.equals("card2")) {
            // give the winner all the cards
            hand2.addCard(cards1ForGrabs);
            hand2.addCard(cards2ForGrabs);
        } else {
            // if there's a tie just give them back (I might eventually adjust this)
            hand1.addCard(cards1ForGrabs);
            hand2.addCard(cards2ForGrabs);
        }
    }

    private static Hand getWinner(Hand hand1, Hand hand2) {
        // if you have no cards then the other guy wins
        if (hand1.getSize() == 0) {
            return hand2;
        } else if (hand2.getSize() == 0) {
            return hand1;
        } else {
            return null;
        }
    }

    private static String compareCards(Card card1, Card card2) {
        // returns true if card1 is greater than card2
        if (card1.getValue() > card2.getValue()) {
            return "card1";
        } else if (card1.getValue() < card2.getValue()) {
            return "card2";
        } else {
            return "war";
        }
    }
}