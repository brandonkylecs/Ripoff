package test;

/**
 * This class will run all of the tests from the other classes in the test package.
 * 
 * @author Brandon Kyle Last Updated 12/05/2019
 */
public class RunTests {
    public static void main(String args[]) {
        TestMethods cardTester = new TestMethods();
        cardTester.runCardTests();
    }
}
