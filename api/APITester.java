package api;

/**
 * This is a temporary class to test API functionality.
 * @author Dakota Simpkins
 * Last Updated: 12/8/2019
 */
public class APITester {

    public static void main(String args[]) {
        APITranslator api = new APITranslator();
        double bal = api.getBal();
        System.out.println(bal);

        //Amount is in cents (USD)
        int testAmount = 10000;
        api.chargeAccount(testAmount);
        System.out.println(bal);
    }
}
