package api;

/**
 *
 * @author Dakoats
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
