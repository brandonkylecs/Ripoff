package api;

/**
 * This is a temporary class to test API functionality.
 * @author Dakota Simpkins
 * Last Updated: 12/8/2019
 */
public class APITester {

    public static void main(String args[]) {
        System.out.println(APITranslator.getBal());

        //Amount is in cents (USD)
        int testAmount = 10000;
        APITranslator.chargeAccount(testAmount);
        System.out.println(APITranslator.getBal());
    }
}
