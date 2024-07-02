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
}
