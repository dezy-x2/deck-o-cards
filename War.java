import java.util.ArrayList;

public class War {
    public static void main(String[] args) {

    }

    private void handleWar(Hand hand1, Hand hand2) {
        ArrayList<Card> cards1ForGrabs = hand1.getNextCard(4);
        ArrayList<Card> cards2ForGrabs = hand2.getNextCard(4);
        Card warCard1 = cards1ForGrabs.remove(0);
        Card warCard2 = cards2ForGrabs.remove(0);
        String warResult = this.compareCards(warCard1, warCard2);
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

    private String compareCards(Card card1, Card card2) {
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