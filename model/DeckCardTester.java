package model;

/**
 * This class performs some simple tests to ensure that both the Deck and Card classes are working correctly.
 *
 * @author Brandon Kyle Last Updated: 10/06/2019
 */
import java.util.ArrayList;
public class DeckCardTester {

    public static void main(String args[]) {
        Card testCardOne = new Card("Card One", "01", 1);
        Card testCardTwo = new Card("Card Two", "02", 2);
        Card testCardThree = new Card("Card Three", "03", 3);
        Card testCardFour = new Card("Card Four", "04", 4);
        Card testCardFive = new Card("Card Five", "05", 5);
        Card testCardSix = new Card("Card Six", "06", 6);
        Card testCardSeven = new Card("Card Seven", "07", 7);
        Card testCardEight = new Card("Card Eight", "08", 8);
        Card testCardNine = new Card("Card Nine", "09", 9);
        Card testCardTen = new Card("Card Ten", "10", 10);
        ArrayList<Card> arrayDeckOne = new ArrayList();
        arrayDeckOne.add(testCardOne);
        arrayDeckOne.add(testCardTwo);
        arrayDeckOne.add(testCardThree);
        arrayDeckOne.add(testCardFour);
        Deck deckOne = new Deck(arrayDeckOne);
        System.out.println("This is the toString of the Card class for Card One: " + testCardOne);
        System.out.println("");
        System.out.println("Card Two is more powerful than Card One. Therefore, the following should be 1. " + testCardTwo.comparePower(testCardOne));
        System.out.println("");
        System.out.println("The first test deck will contain Card One to Card Four. This will check and see if that's the case.\n" + deckOne);
        deckOne.addCard(testCardFive);
        System.out.println("The first test deck shouls now contain Card five as well. " + deckOne);
        ArrayList<Card> arrayToAdd = new ArrayList();
        arrayToAdd.add(testCardSix);
        arrayToAdd.add(testCardSeven);
        arrayToAdd.add(testCardEight);
        arrayToAdd.add(testCardNine);
        arrayToAdd.add(testCardTen);
        deckOne.addSet(arrayToAdd);
        System.out.println("This tests the addSet() method for the Deck class. If it works, all of the ten cards should now be in Deck One.\n" + deckOne);
        System.out.println("This tests the total power of Deck One. The total power should be 55. The total power is " + deckOne.calculateTotalPower() + ".");
        System.out.println("");
        Deck deckTwo = new Deck(deckOne.drawCards(3));
        Deck deckThree = new Deck(deckOne.drawCards(3));
        Deck deckFour = new Deck(deckOne.drawCards(3));
        System.out.println("This tests the drawCards() method. If it is successful, there should be three new decks with three cards, and Deck One with one card. Deck One is:\n" + deckOne);
        System.out.println("Deck Two is:\n" + deckTwo);
        System.out.println("Deck Three is:\n" + deckThree);
        System.out.println("Deck Four is:\n" + deckFour);
        Deck deckFive = new Deck();
        deckFive.addCard(testCardOne);
        System.out.println("This is to test the Deck constructor that does not take an ArrayList of Cards as a parameter. Deck Five should only contain Card One. Deck Five:\n" + deckFive);
        deckOne.combineDecks(deckTwo);
        deckOne.combineDecks(deckThree);
        deckOne.combineDecks(deckFour);
        System.out.println("This is to test the combineDecks method.\n" + deckOne + deckTwo);
        deckOne.sortByID();
        System.out.println("This is to test the sortByID() method. All of the cards in deck one should be sorted in order.\n" + deckOne);
        deckOne.shuffleCards();
        System.out.println("This is to test the shuffleCards() method. The cards in deck one should be sorted randomly.\n" + deckOne);
    }
}