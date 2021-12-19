public class War {
    public static void main(String[] args) {

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