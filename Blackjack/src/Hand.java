import java.util.ArrayList;

public class Hand {
    private ArrayList<Card> hand;

    public Hand() {
        hand = new ArrayList<Card>();
    }

    // method that takes a card from the deck and adds a card to a hand
    public void takeCardFromDeck(Deck deck) {
        hand.add(deck.takeCard());
    }

    // toString() method to print the Dealer and Player's current hand
    public String toString() {
        String output = "";
        for (Card card : hand) {
            output += card + " - ";
        }
        return output;
    }

    public int calculatedValue() {
        // var to count the number of aces + the current total value of the hand
        int value = 0;
        int aceCount = 0;

        // for ea card in this hand
        for (Card card : hand) {
            // add the card value to the hand
            value += card.getValue();
            // count how many aces have been added
            if (card.getValue() == 11) {
                aceCount++;
            }
        }
        // if there is a scenario where we have mult. aces, as may be the case of drawing 10 + 2 or more aces
        // got back and set ea ace to 1 until the current value < 21, if possible
        if (value > 21 && aceCount > 0) {
            while (aceCount > 0 && value > 21) {
                aceCount--;
                value -= 10;
            }
        }
        return value;
    }

    // gets first card from Dealer's hand
    public Card getCard(int idx) {
        return hand.get(idx);
    }

    public void discardHandToDeck(Deck discardDeck) {

        // copy card from hand to discardDeck
        discardDeck.addCards(hand);

        // clears the hand
        hand.clear();
    }
}
