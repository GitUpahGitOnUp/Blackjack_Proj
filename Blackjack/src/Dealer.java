public class Dealer extends Person {

    // create a new Dealer that extends the Person class
    public Dealer() {
        super.setName("Dealer"); //'super' keyword calls the parent(Person) class's setName method, and names the "Dealer"
    }

    /*public void printFirstHand() {
        System.out.println(hand);
    }*/
    // prints dealer's first hand, with one card face down
    public void printFirstHand() {
        System.out.println("The dealer's hand looks like this:");
        System.out.println(super.getHand().getCard(0));
        System.out.println("The second card is face down");
    }
}
