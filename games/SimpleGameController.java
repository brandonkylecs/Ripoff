/*
 * Controller class for the Simple Register system. Listens for new panel and
 * exit events from the GUI.
 */
package games;

import model.RipoffBase;
import model.Game;
import gui.RipoffGUI;
import javafx.stage.Stage;
import events.RipoffEvent;
import events.RipoffMessage;
import model.Player;
import events.ListenerInterface;
/**
 *
 * @author tnwallsc
 */
public class SimpleGameController implements ListenerInterface {

    // Add reference to all modules.
    protected RipoffGUI gui;
    protected RipoffBase activeModule = null;

    SimpleGameController(Stage primaryStage) {
        // Initialize the GUI.
        this.gui = new RipoffGUI(primaryStage);
        // Register this controller as a listener.
        this.gui.addListener(this);
    }

   /*
    * Load the main menu panel. Unregisters the active module from the GUI event
    * listeners and sets the active panel to null.
    */
    private void mainPanel() {
        // Load the main GUI.
        this.gui.loadMainPanel();
        // Remove the active panel from the list of listeners.
        this.gui.removeListener(this.activeModule);
        // Clear out any active panel.
        this.activeModule = null;
    }

   /*
    * Loads the game Panel to the main screen and registers the Game
    * object.
    */
    private void gamePanel(){
        // Load the game GUI.
        this.gui.loadGamePanel();
        // Register Active Module as listener.
        this.registerPanelListener(new Game());
    }

   /*
    * Loads the player panel to the main screen and registers the Player
    * object.
    */
    private void playerPanel(){
        // Load the GUI
        this.gui.loadPlayerPanel();
        // Register Active Module as listener.
        this.registerPanelListener(new Player());
    }

   /*
    * Given a module, this method registers that module as the active module. Also
    * adds the given module as a listener to the GUI.
    */
    private void registerPanelListener(RipoffBase newModule) {
        this.activeModule = newModule;
        this.gui.addListener(newModule);
    }

   /*
    * Respond to events that this module is listening for.
    */
    @Override
    public void messageReceived(RipoffEvent event) {
        // We're only interested in 3 particular events.
        switch (event.getMessage().getCode()){
            case RipoffMessage.GAME_PANEL:
                System.out.println("Controller Responding to Game Panel Event.");
                this.gamePanel();
                break;
            case RipoffMessage.PLAYER_PANEL:
                System.out.println("Controller Responding to Player Panel Event.");
                this.playerPanel();
                break;
            case RipoffMessage.EXIT_PANEL:
                System.out.println("Controller Responding to Main Menu Panel Event.");
                this.mainPanel();
                break;
            default:
                System.out.println("Ignoring Message Code as Irrelevant to Controller. " + event.getMessage().getCode());
                break;
        }
    }

}