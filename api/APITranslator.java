/**
 *
 * This class translates the given API for the rest of the program to connect to.
 * @author Dakota Simpkins
 * Last Updated: 12/8/2019
 */
package api;

import com.stripe.model.Charge;

public class APITranslator {

    protected static StripeAPI STRIPE = new StripeAPI();

    public APITranslator(){
    }

    /*
     * Gets the balance amount from an account.
     * @returns STRIPE.getBalance()
     */
    public double getBal() {
        return STRIPE.getBalance();
    }

    /*
     * Charges an account a specified amount.
     */
    public void chargeAccount(int _amount) {
        Charge charge = STRIPE.chargeAccount(_amount);
        if(charge != null){
            System.out.println("Charge made successfully");
        }
        else{
            System.out.println("Charge was not made");
        }

    }

}
