import java.util.Scanner;

public class Player extends Person {

    Scanner input = new Scanner(System.in);

    // creates a new Player
    public Player() {
        super.setName("Player");
    }

    public void makeDecision(Deck deck, Deck discard) {
        int decision = 0;
        boolean getNum = true;

        // while getting a number
        while (getNum) {

            try {
                System.out.println("Would you like to: 1 - Hit or 2 - Stand?");
                decision = input.nextInt();
                getNum = false;
            } catch (Exception e) {
                System.out.println("Invalid entry, please enter 1 to Hit or 2 to Stand.");
                input.next();
            }
            // scanner is not closed as it will be used later
        }
        // if they decide to hit
        if (decision == 1) {
            // hit the deck using the deck + discard deck
            this.hit(deck, discard);
            // return (exit the method) if they have blackjack or busted
            if (this.getHand().calculatedValue() > 20) {
                return;
            }
            // if they didn't bust or get 21, this allows player to hit or stand again
            else {
                this.makeDecision(deck, discard);
            }
            // if they type any number other than 1, we'll assume they're standing
        } else {
            System.out.println("You stand.");
        }
    }

}
