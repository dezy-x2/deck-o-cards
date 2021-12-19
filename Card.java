public class Card {
    private String suit;
    private String rank;

    public Card(String suit, String rank) {
        // collect the suit and rank of the cards ex: "Spades", "Ace"
        this.suit = suit;
        this.rank = rank;
    }

    private String getSuitPretty() {
        // return the suit of the card in a pretty format ex: "Spades" -> "♠"
        switch (this.suit) {
            case "Spades":
                return "♠";
            case "Hearts":
                return "♥";
            case "Diamonds":
                return "♦";
            case "Clubs":
                return "♣";
            default:
                return "";
        }
    }

    private int getRankPretty() {
        // return the rank of the card in a pretty format ex: "Ace" -> 1
        switch (this.rank) {
            case "Ace":
                return 1;
            case "Two":
                return 2;
            case "Three":
                return 3;
            case "Four":
                return 4;
            case "Five":
                return 5;
            case "Six":
                return 6;
            case "Seven":
                return 7;
            case "Eight":
                return 8;
            case "Nine":
                return 9;
            case "Ten":
                return 10;
            case "Jack":
                return 11;
            case "Queen":
                return 12;
            case "King":
                return 13;
            default:
                return 0;
        }
    }

    public int getValue() {
        // return the value of the card ex: "Ace" -> 1 using the getRankPretty() method
        return getRankPretty();
    }

    @Override
    public String toString() {
        // prints the card in a pretty format to look like a real card
        String prettySuit = this.getSuitPretty();
        int prettyRank = this.getRankPretty();
        String card = "------------------------------\n" +
                "|" + prettyRank + "             " + prettySuit + "             " + prettyRank + "|\n" +
                "|                             |\n" +
                "|                             |\n" +
                "|                             |\n" +
                "|              " + prettySuit + "              |\n" +
                "|                             |\n" +
                "|                             |\n" +
                "|                             |\n" +
                "|" + prettyRank + "             " + prettySuit + "             " + prettyRank + "|\n" +
                "------------------------------";
        return card;

    }

    public static void main(String[] args) {
        Card card = new Card("Clubs", "King");
        System.out.println(card);
    }
}