/*
 * The Player object for handling player options.
 */
package model;

import events.RipoffEvent;
import events.RipoffMessage;
import games.SimpleGameController;

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
    * Called when the player sends a message to another player.
    */
    public void sendMessage() {
        System.out.println("Sending message to player: You suck.");
    }
    
    /*
    * Called when the player wants to create a profile.
    */
    public void createProfile(){
        System.out.println("Creating profile.");
    }


    @Override
    public void messageReceived(RipoffEvent event) {
        switch (event.getMessage().getCode()){
            case RipoffMessage.SEE_DECK:
                System.out.println(RipoffMessage.SEE_DECK);
                this.deckShow();
                break;
            case RipoffMessage.SEND_MEMES:
                System.out.println(RipoffMessage.SEND_MEMES);
                this.sendMessage();
                break;
            case RipoffMessage.CREATE_PROFILE:
                System.out.println(RipoffMessage.CREATE_PROFILE);
                this.createProfile();
                break;
            default:
                System.out.println("I don\'t know what you want me to do: " + event.getMessage().getCode());
                break;
        }
    }
}
