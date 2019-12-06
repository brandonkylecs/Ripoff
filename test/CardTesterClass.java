package test;

/**
 * This class tests methods from the Card class.
 *
 * @author Brandon Kyle Last Updated: 12/05/2019
 */
import model.Card;

public class CardTesterClass {
    private Card testCardOne = new Card("Test Card One", "01", 1);
    private Card testCardTwo = new Card("Test Card Two", "02", 2);
    private Card testCardZero = new Card("Test Card Zero", "0", 0);
    private Card testCardTen = new Card("Test Card Ten", "10", 10);
    private Card testCardTwenty = new Card("Test Card Twenty", "20", 20);
    
    /**
     * This method will perform all of the tests in this class. This will be called in the runTests class.
     * 
     */
    public void runCardTests() {
        this.testCardComparePower();
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
        System.out.println("This method should return SECOND CARD. It retuns " + testCardTwenty.comparePower(testCardTen));
        System.out.println("Error Cases");
        System.out.println("This method should return ERROR. It returns " + testCardZero.comparePower(testCardOne));
        System.out.println("This method should return ERROR. It returns " + testCardOne.comparePower(testCardZero));
    }
}
