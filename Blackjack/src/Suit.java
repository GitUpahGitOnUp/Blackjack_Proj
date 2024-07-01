public enum Suit {
    CLUB("Clubs"),
    DIAMOND("Diamonds"),
    HEART("Hearts"),
    SPADE("Spades");
    // create constructor for Suit enum that takes a String value
    String suitName;

    Suit(String suitName) {
        this.suitName = suitName;
    }

    public String toString() {
        return suitName;
    }

}
