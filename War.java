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
            // we get the active card for each player
            Card hand1PlayCard = hand1.getNextCard(1).get(0);
            Card hand2PlayCard = hand2.getNextCard(1).get(0);
            String roundResults = compareCards(hand1PlayCard, hand2PlayCard);
            if (roundResults.equals("card1")) {
                hand1.addCard(hand2PlayCard);
            } else if (roundResults.equals("card2")) {
                hand2.addCard(hand1PlayCard);
            } else if (roundResults.equals("war")) {
                hand1.addCard(hand1PlayCard);
                hand2.addCard(hand2PlayCard);
                handleWar(hand1, hand2);
            }
        }
        Hand finalWinner = getWinner(hand1, hand2);
        if (finalWinner != null) {
            System.out.println(finalWinner.name + " wins!");
        }
    }

    private static void handleWar(Hand hand1, Hand hand2) {
        ArrayList<Card> cards1ForGrabs = hand1.getNextCard(4);
        ArrayList<Card> cards2ForGrabs = hand2.getNextCard(4);
        Card warCard1 = cards1ForGrabs.remove(0);
        Card warCard2 = cards2ForGrabs.remove(0);
        String warResult = compareCards(warCard1, warCard2);
        if (warResult.equals("card1")) {
            hand1.addCard(cards1ForGrabs); // TODO: this still needs work since we don't have a way to handle war again
            hand1.addCard(cards2ForGrabs);
        } else if (warResult.equals("card2")) {
            hand2.addCard(cards1ForGrabs);
            hand2.addCard(cards2ForGrabs);
        } else {
            hand1.addCard(cards1ForGrabs);
            hand2.addCard(cards2ForGrabs);
        }
    }

    private static Hand getWinner(Hand hand1, Hand hand2) {
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