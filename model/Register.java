/*
 * The Register object for handling registration.
 */
package com.stripe.ripoff.model;

import events.RipoffEvent;
import events.RipoffMessage;

/**
 *
 * @author tnwallsc
 */
public class Register extends RipoffBase {

    public Register() {
        System.out.println("Register Module Loaded");
    }

   /*
    * Called when the player wants to create a profile.
    */
    public void createProfile() {
        System.out.println("Creating profile...");
    }

    @Override
    public void messageReceived(RipoffEvent event) {
        switch (event.getMessage().getCode()){
            case RipoffMessage.CREATE_PROFILE:
                this.createProfile();
                break;
            default:
                System.out.println("I don\'t know what you want me to do: " + event.getMessage().getCode());
                break;
        }
    }
}
