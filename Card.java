public class Card {
    private String suit;
    private String rank;

    public Card(String suit, String rank) {
        this.suit = suit;
        this.rank = rank;
    }

    private String getSuitPretty() {
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
        switch (this.rank) {
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

    public static void main(String[] args) {
    }
}