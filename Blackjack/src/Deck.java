import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Deck {
    // creates instance variable 'deck' of type ArrayList Card
    private ArrayList<Card> deck;

    // builds constructor for the Deck - deck is an empty ArrayList for future use
    public Deck() {
        deck = new ArrayList<Card>();
    }

    // getter to access cards in deck

    public ArrayList<Card> getCards() {
        return deck;
    }

    // creates add() method to add one card to the deck
    public void addCard(Card card) {
        deck.add(card);
    }

    // creates toString() method that returns a String containing 52 card deck
    public String toString() {
        // a string to hold everything that will be returned
        String output = "";

        // for ea Card 'card' in the deck
        for (Card card : deck) {
            // add the card and the escape char for a new line
            output += card;
            output += "\n";
        }
        return output;
    }

    /* overloaded constructor that takes boolean val. of 'true' to make a deck w/ 52 cards
     new Deck() creates an empty deck, while new Deck(true) creates a full deck
     makeDeck will use a loop and .value() method to run through enums that returns an array with all their
     values */
    public Deck(boolean makeDeck) {
        deck = new ArrayList<Card>();
        if (makeDeck) {
            // iterates through all the suits
            for (Suit suit : Suit.values()) {
                // iterates through all the ranks
                for (Rank rank : Rank.values()) {
                    // adds a new card containing ea. iteration of suit and rank
                    deck.add(new Card(suit, rank));
                }
            }
        }
    }
    /* creates a loop that iterates through the number of cards in the deck. Each time the loop executes,
    it will pull one card at random from the deck ArrayList, and add it to a new shuffled ArrayList.
    Finally, it will replace the old deck with the newly shuffled ArrayList of cards. */

    /*  public void shuffle() {

          ArrayList<Card> shuffled = new ArrayList<Card>();
          // iterate through the size of the deck, ensuring ea. card can be pulled
          while (deck.size() > 0) {
              // select random index to pull card
              int cardToPull = (int) (Math.random() * (deck.size() - 1));
              // add this random card to a new shuffled deck
              shuffled.add(deck.get(cardToPull));
              // remove pulled card from the OG deck
              deck.remove(cardToPull);
          }
          deck = shuffled;
      }*/
    public void shuffle() {
        Collections.shuffle(deck, new Random());
    }

    // method that returns the top card from the deck + removes it from the deck at the same time
    public Card takeCard() {
        // take a copy of the first card from the deck
        Card cardToTake = new Card(deck.get(0));
        // remove the card from the deck
        deck.remove(0);
        // give the card back
        return cardToTake;
    }

    // method to check if the deck of cards being used has cards left to draw from, or if it needs reshuffling
    public boolean hasCards() {
        if (deck.size() > 0) {
            return true;
        } else {
            return false;
        }
    }

    // empties out current deck
    public void emptyDeck() {
        deck.clear();
    }

    // @param cards an arraylist of cards to be added to this deck
    public void addCards(ArrayList<Card> cards) {
        deck.addAll(cards);
    }

    // take all the cards from discarded deck + put them in this deck, shuffled.
    // clear the old deck
    // @param discard = the deck we're getting the cards from
    public void reloadDeckFromDiscard(Deck discard) {
        this.addCards(discard.getCards());
        this.shuffle();
        discard.emptyDeck();
        System.out.println("Ran out of cards: creating a new deck from discard pile and shuffling deck.");
    }


}
