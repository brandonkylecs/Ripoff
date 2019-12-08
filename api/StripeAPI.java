/**
 * This class connects to the Stripe API and does stuff.
 * @author Dakota Simpkins
 * Last Updated: 12/8/2019
 */
package api;

import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.*;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class StripeAPI {

    //Used for getting amount in balance.
    private static int FIRST_POSITION = 0;

    public StripeAPI() {
        Stripe.apiKey = "sk_test_4eC39HqLyjWDarjtT1zdp7dc";
    }

    /*
     *Creates a customer object based on specific parameters.
     */
    protected Customer createCustomer(Map<String, Object> _params) {
        try {
            Customer customer = Customer.create(_params);
            return customer;
        } catch (StripeException ex) {
            Logger.getLogger(StripeAPI.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    /*
     * Returns balance amount of the stripe account as an integer.
     * @returns balAmount
     */
    protected double getBalance() {
        try {
            Balance bal = Balance.retrieve();
            double balAmount = bal.getAvailable().get(FIRST_POSITION).getAmount().doubleValue();
            return balAmount/100;
        } catch (StripeException ex) {
            Logger.getLogger(StripeAPI.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    /*
     * Makes a charge on the account, does not change balance if on test environment.
     * @returns charge
     */
    public Charge chargeAccount(int _amount) {
        try {
            Map<String, Object> params = new HashMap<>();
            params.put("amount", _amount);
            params.put("currency", "usd");
            params.put("source", "tok_visa");
            params.put("description","Charge for jenny.rosen@example.com");
            Charge charge = Charge.create(params);
            return charge;
        } catch (StripeException ex) {
            Logger.getLogger(StripeAPI.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
