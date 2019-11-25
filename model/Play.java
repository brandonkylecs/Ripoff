package model;

import events.RipoffEvent;
import events.RipoffMessage;

/**
 *
 * @author tnwallsc
 */
public class Play extends RipoffBase {
    public Play() {
        System.out.println("Register Module Loaded");
    }

    @Override
    public void messageReceived(RipoffEvent event) {
        switch (event.getMessage().getCode()){
            default:
                System.out.println("I don\'t know what you want me to do: " + event.getMessage().getCode());
                break;
        }
    }
}
