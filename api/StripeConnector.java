package com.stripe.ripoff.api;

import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.*;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Dakoats
 */

public class StripeConnector {
    public StripeConnector() {
        Stripe.apiKey = "sk_test_4eC39HqLyjWDarjtT1zdp7dc";
    }

    public static void customerTest() throws StripeException {
        Map<String, Object> params = new HashMap<>();
        params.put("description", "Customer for jenny.rosen@example.com");
        Customer customer = Customer.create(params);
        System.out.println(customer.getLastResponse().requestId());
    }
}
