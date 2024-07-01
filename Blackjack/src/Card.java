public class Card {
    // create priv. instance vars needed for constructor params.
    private Suit suit;
    private Rank rank;

    // constructor to create a card given a suit + rank
    public Card(Suit suit, Rank rank) {
        this.suit = suit;
        this.rank = rank;
    }

    //create getter methods to figure out ea. card's suit, rank + value
    public int getValue() {
        return rank.rankValue;
    }

    public Suit getSuit() {
        return suit;
    }

    public Rank getRank() {
        return rank;
    }

    public String toString() {
        return ("[" + rank + " of " + suit + "] (" + this.getValue() + ")");
    }

}
