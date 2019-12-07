/**
 *
 * This class translates the given API for the rest of the program to connect to,
 * @author Dakota Simpkins Last Updated: 12/6/2019
 */
package api;

public class APITranslator {

    protected static StripeAPI STRIPE = new StripeAPI();

    public APITranslator(){
    }

    public static int getBal() {
        return STRIPE.getBalance();
    }

    public static void chargeAccount(int _amount) {
        STRIPE.chargeAccount(_amount);
    }

}
