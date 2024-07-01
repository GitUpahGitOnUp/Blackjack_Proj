public class Main {
    public static void main(String[] args) {
        // Greet user
        System.out.println("Welcome to the table - let's play some BlackJack!");

        // Create a new Game object
        Game blackjack = new Game();

        // test out Suit class
        //System.out.println(Suit.CLUB + "  - SUCCESS!");

        // test out Rank class
        //System.out.println(Rank.ACE + " has a value of " + Rank.ACE.rankValue);

        // create new Card obj and test toString method functionality
        //Card testCard = new Card(Suit.CLUB, Rank.ACE);
        //System.out.println(testCard);

        // creates test cards + deck
       /* Deck testDeck = new Deck();
        Card aCard = new Card(Suit.CLUB, Rank.QUEEN);
        Card bCard = new Card(Suit.DIAMOND, Rank.ACE);
        Card cCard = new Card(Suit.SPADE, Rank.SIX);
        // add cards to testDeck
        testDeck.addCard(aCard);
        testDeck.addCard(bCard);
        testDeck.addCard(cCard);*/

        Deck testDeck = new Deck(true);
        // test out first shuffled deck
        testDeck.shuffle();

        System.out.println(testDeck);
    }
}
