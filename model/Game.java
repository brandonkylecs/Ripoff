/*
 * The Game object for creating new games.
 */
package model;

import events.RipoffEvent;
import events.RipoffMessage;

/**
 *
 * @author tnwallsc
 */
public class Game extends RipoffBase {

    public Game() {
        System.out.println("Game Module Loaded");
    }
    
    /*
    * Called when the pllayer wants to learn how to play.
    */
    public void howToPlay() {
        // An item has been added to the ticket. Fire an event and let everyone know.
        System.out.println("Step 1: Have no life. \nStep 2: Deal cards\nStep 3: Cry yourself to sleep.");
    }

   /*
    * Called when an item has been added to the transaction.
    */
    public void playAI() {
        // An item has been added to the ticket. Fire an event and let everyone know.
        System.out.println("You're going to lose foolish human!");
    }

   /*
    * Called when an item has been remoed from a tranaction.
    */
    public void playHoomans() {
        System.out.println("Thanks for killing each other, human!");
    }

    @Override
    public void messageReceived(RipoffEvent event) {
        switch (event.getMessage().getCode()){
            case RipoffMessage.HOW_TO_PLAY:
                this.howToPlay();
                break;
            case RipoffMessage.PLAY_AGAINST_AI:
                this.playAI();
                break;
            case RipoffMessage.PLAY_AGAINST_HOOMANS:
                this.playHoomans();
                break;
            default:
                System.out.println("Ignoring Message Event. Irrelevant to Game: " + event.getMessage().getCode());
                break;
        }
    }
}
