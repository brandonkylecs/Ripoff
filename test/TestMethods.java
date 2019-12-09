package test;

/**
 * This class tests methods from the Card class.
 *
 * @author Brandon Kyle Last Updated: 12/05/2019
 */
import model.Card;
import model.Deck;

public class TestMethods {
    private Card testCardOne = new Card("Test Card One", "01", 1);
    private Card testCardTwo = new Card("Test Card Two", "02", 2);
    private Card testCardThree = new Card("Test Card Three", "03", 3);
    private Card testCardFour = new Card("Test Card Four", "04", 4);
    private Card testCardZero = new Card("Test Card Zero", "0", 0);
    private Card testCardTen = new Card("Test Card Ten", "10", 10);
    private Card testCardTwenty = new Card("Test Card Twenty", "20", 20);
    
    /**
     * This method will perform all of the tests in this class. This will be called in the runTests class.
     * 
     */
    public void runCardTests() {
        this.testCardComparePower();
        this.testDeckCalculateTotalPower();
        this.testDeckCalculateAveragePower();
    }
    
    /**
     * This method tests the comparePower() method from the Card class. The test results will be printed to the console.
     * 
     * @return 
     */
    private void testCardComparePower() {
        System.out.println("This method will test the comparePower() method of the Card class.");
        System.out.println("Edge Cases");
        System.out.println("This method should return FIRST CARD. It returns " + testCardTwo.comparePower(testCardOne));
        System.out.println("This method should return SECOND CARD. It returns " + testCardOne.comparePower(testCardTwo));
        System.out.println("This method should return DRAW. It returns " + testCardOne.comparePower(testCardOne));
        System.out.println("Normal Cases");
        System.out.println("This method should return FIRST CARD. It returns " + testCardTen.comparePower(testCardOne));
        System.out.println("This method should return SECOND CARD. It retuns " + testCardOne.comparePower(testCardTen));
        System.out.println("Error Cases");
        System.out.println("This method should return ERROR. It returns " + testCardZero.comparePower(testCardOne));
        System.out.println("This method should return ERROR. It returns " + testCardOne.comparePower(testCardZero));
    }
    
    /**
     * This method tests the calculateTotalPower() method from the Deck class. The test results will be printed to the console.
     * 
     */
    private void testDeckCalculateTotalPower() {
        Deck testDeck = new Deck();
        System.out.println("This method will test the calculateTotalPower() method of the Card class.");
        System.out.println("Edge Cases");
        System.out.println("This method should return 0. It returns " + testDeck.calculateTotalPower());
        testDeck.addCard(testCardOne);
        System.out.println("This method should retun 1. It returns " + testDeck.calculateTotalPower());
        System.out.println("Normal Cases");
        testDeck.addCard(testCardTwo);
        System.out.println("This method should return 3. It returns " + testDeck.calculateTotalPower());
        testDeck.addCard(testCardTen);
        System.out.println("This method should return 13. It returns " + testDeck.calculateTotalPower());
    }
    
    /**
     * This method tests the calculateAveragePower() method from the Deck class. The test results will be printed to the console.
     * 
     */
    private void testDeckCalculateAveragePower() {
        Deck testDeck = new Deck();
        System.out.println("This method will test the calculateAveragePower() method of the Deck class.");
        System.out.println("Edge Cases");
        System.out.println("This method should return 0. It returns " + testDeck.calculateAveragePower());
        testDeck.addCard(testCardOne);
        System.out.println("This method should return 1. It returns " + testDeck.calculateAveragePower());
        System.out.println("Normal Cases");
        testDeck.addCard(testCardOne);
        System.out.println("This method should return 1. It returns " + testDeck.calculateAveragePower());
        testDeck.addCard(testCardFour);
        System.out.println("This method should return 2. It returns " + testDeck.calculateAveragePower());
        System.out.println("Error Cases");
        testDeck.addCard(testCardOne);
        System.out.println("This method should return 1.75. It returns " + testDeck.calculateAveragePower() + " because calculateAveragePower() returns an int and not a double.");
    }
}
