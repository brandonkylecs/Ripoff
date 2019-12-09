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
    * Called when the player wants to learn how to play.
    */
    public void howToPlay() {
        System.out.println("Step 1: Have no life. \nStep 2: Deal cards\nStep 3: Cry yourself to sleep.");
    }

   /*
    * Called when you want to play against an AI.
    */
    public void playAI() {
        System.out.println("You're going to lose foolish human!");
    }

   /*
    * Called when you want to play against a human.
    */
    public void playHoomans() {
        System.out.println("Thanks for killing each other, human!");
    }

    @Override
    public void messageReceived(RipoffEvent _event) {
        switch (_event.getMessage().getCode()){
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
                System.out.println("Ignoring Game Message Event. Irrelevant to Game: " + _event.getMessage().getCode());
                break;
        }
    }
}
