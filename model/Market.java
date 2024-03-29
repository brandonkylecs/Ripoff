/*
 * The Register object for handling registration.
 */
package model;

import events.RipoffEvent;
import events.RipoffMessage;

/**
 *
 * @author Tyler Wallschleger
 */
public class Market extends RipoffBase {

    public Market() {
        System.out.println("Market Module Loaded");
    }

    @Override
    public void messageReceived(RipoffEvent _event) {
        switch (_event.getMessage().getCode()){
            default:
                System.out.println("I don\'t know what you want me to do: " + _event.getMessage().getCode());
                break;
        }
    }
}