/*
 * The Player object for handling player options.
 */
package model;

import events.RipoffEvent;
import events.RipoffMessage;
import games.SimpleGameController;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

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
     * Saves the user data for when they try to register.  Checks to see if the user exists already.
     * @param _userInfo
     */
    public RipoffMessage registerNewUser(String[] _userInfo) throws IOException{
        if(_userInfo[0].trim().equals("")){
            return new RipoffMessage(RipoffMessage.MISSING_USERNAME);
        }
        else if(_userInfo[1].trim().equals("")){
            return new RipoffMessage(RipoffMessage.MISSING_FIRSTNAME);
        }
        else if(_userInfo[2].trim().equals("")){
            return new RipoffMessage(RipoffMessage.MISSING_PASSWORD);
        }
        // TODO check for user already existing.
        String currentPath = System.getProperty("user.dir");
        System.out.println(currentPath + "\\src\\players\\users.txt");

        PrintWriter write = new PrintWriter(currentPath + "/src/players/users.txt", "UTF-8");
        write.println(Arrays.toString(_userInfo));
        write.close();

        // Return to main panel after logging user in.
        return new RipoffMessage(RipoffMessage.EXIT_PANEL);
    }

    @Override
    public void messageReceived(RipoffEvent _event) {
        switch (_event.getMessage().getCode()){
            case RipoffMessage.SEE_DECK:
                System.out.println(RipoffMessage.SEE_DECK);
                this.deckShow();
                break;
            case RipoffMessage.SEND_MEMES:
                System.out.println(RipoffMessage.SEND_MEMES);
                this.sendMessage();
                break;
            default:
                System.out.println("I don\'t know what you want me to do: " + _event.getMessage().getCode());
                break;
        }
    }
}
