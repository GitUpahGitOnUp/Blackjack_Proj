public class Game {

    // vars for Game class
    private int wins, losses, pushes;

    private Deck deck, discarded;
    private Dealer dealer;
    private Player player;


    // Game class constructor
    public Game() {
        // creates a new deck w/ 52 cards
        deck = new Deck(true);
        // creates a new empty deck for discard pile
        discarded = new Deck();

        // creates the people
        dealer = new Dealer();
        player = new Player();

        // shuffle the deck and start first round
        deck.shuffle();
        startRound();
    }

    //method to hold logic for ea. round
    private void startRound() {
        //gives dealer two cards
        dealer.getHand().takeCardFromDeck(deck);
        dealer.getHand().takeCardFromDeck(deck);
        //gives player two cards
        player.getHand().takeCardFromDeck(deck);
        player.getHand().takeCardFromDeck(deck);

        //print ea. player's hand
        dealer.printFirstHand();
        player.printHand();

        // checks if dealer has Blackjack after first 2 cards are dealt
        if (dealer.hasBlackjack()) {
            // Shows the dealer's hand
            dealer.printHand();

            // checks if player has Blackjack
            if (player.hasBlackjack()) {
                // ends round with a 'push'
                System.out.println("Both Player and Dealer have 21 - Push.");
                pushes++;
                startRound();
            } else {
                System.out.println("Dealer has Blackjack - Player has lost this round.");
                dealer.printHand();
                losses++;
                startRound();
            }
        }
        // checks if player has Blackjack to start
        // if we arrive at this code block, then the dealer didn't have Blackjack
        if (player.hasBlackjack()) {
            System.out.println("You have Blackjack - You win!!");
            wins++;
            startRound();
        }
        player.makeDecision(deck, discarded);

    }

}
