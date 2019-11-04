/*
 * The Player object for handling player options.
 */
package model;

import events.RipoffEvent;
import events.RipoffMessage;

/**
 *
 * @author tnwallsc
 */
public class Player extends RipoffBase {

    public Player() {
        System.out.println("Player Module Loaded");
    }

   /*
    * Called when asked to see deck.
    */
    public void deckShow() {
        // Sending solicited deck pic.
        System.out.println("Displaying Deck:");
    }

   /*
    * Called when an item has been remoed from a tranaction.
    */
    public void sendMessage() {
        System.out.println("Sending message to player: You suck.");
    }


    @Override
    public void messageReceived(RipoffEvent event) {
        switch (event.getMessage().getCode()){
            case RipoffMessage.SEE_DECK:
                this.deckShow();
                break;
            case RipoffMessage.SEND_MEMES:
                this.sendMessage();
                break;
            default:
                System.out.println("I don\'t know what you want me to do: " + event.getMessage().getCode());
                break;
        }
    }
}
