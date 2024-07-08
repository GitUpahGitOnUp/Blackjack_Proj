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
        if (wins > 0 || losses > 0 || pushes > 0) {
            System.out.println();
            System.out.println("Starting Next Round...Wins: " + wins + " Losses: " + losses + " Pushes: " + pushes);
            dealer.getHand().discardHandToDeck(discarded);
            player.getHand().discardHandToDeck(discarded);
        }

        // checks to make sure the deck has at least 4 cards left
        if (deck.cardsLeft() < 4) {
            deck.reloadDeckFromDiscard(discarded);
        }
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

        // dealer's turn
        dealer.printHand();
        while (dealer.getHand().calculatedValue() < 17) {
            dealer.hit(deck, discarded);
        }
        // verifies who the winner is
        if (dealer.getHand().calculatedValue() > 21) {
            System.out.println("Dealer busts");
            wins++;
        }
        if (player.getHand().calculatedValue() > 21) {
            System.out.println("Player busts.");
            losses++;
        } else if (dealer.getHand().calculatedValue() > player.getHand().calculatedValue()) {
            System.out.println("You lose.");
            losses++;
        } else if (player.getHand().calculatedValue() > dealer.getHand().calculatedValue()) {
            System.out.println("You win.");
            wins++;
        } else {
            System.out.println("Push.");
            pushes++;
        }
        startRound();
    }

}
