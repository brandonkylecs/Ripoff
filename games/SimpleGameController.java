/*
 * Controller class for the Simple Register system. Listens for new panel and
 * exit events from the GUI.
 */
package games;

import java.util.*;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;
import model.RipoffBase;
import model.Game;
import model.Register;
import model.Market;
import model.Play;
import model.GameBoardAI;
import db.MySQLConnector;
import gui.RipoffGUI;
import javafx.stage.Stage;
import events.RipoffEvent;
import events.RipoffMessage;
import model.Player;
import events.ListenerInterface;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author tnwallsc
 */
public class SimpleGameController implements ListenerInterface {

    // Add reference to all modules.
    protected RipoffGUI gui;
    protected RipoffBase activeModule = null;
    protected GameBoardAI gbAI;

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
        this.ripoffPanelListener(new Game());
    }

   /*
    * Loads the player panel to the main screen and registers the Player
    * object.
    */
    private void playerPanel(){
        // Load the GUI
        this.gui.loadPlayerPanel();
        // Register Active Module as listener.
        this.ripoffPanelListener(new Player());
    }

    /*
    * Loads the market panel to the main screen and registers the Market
    * object.
    */
    private void marketPanel(){
        // Load the GUI
        this.gui.loadMarketPanel();
        // Register Active Module as listener.
        this.ripoffPanelListener(new Market());
    }

    /*
    * Loads the register panel to the main screen and registers the Register
    * object.
    */
    private void registerPanel() throws IOException{
        //Load the GUI
        this.gui.loadRegisterPanel();
        // Register Active Module as listener.
        this.ripoffPanelListener(new Register());
    }

    /*
    * Loads the play panel to the main screen and registers the Play
    * object.
    */
    private void playPanel(){
        //Load the GUI
        this.gui.loadPlayPanel();
        // Register Active Module as listener.
        this.ripoffPanelListener(new Play());
    }

    /*
    * When the AI wins, load the view
    */
    private void aiWinPanel(){
        this.gui.loadAiPanel();
    }

    private void playerWinPanel(){
        this.gui.loadPlayerWonPanel();
    }

   /*
    * Given a module, this method registers that module as the active module. Also
    * adds the given module as a listener to the GUI.
    */
    private void ripoffPanelListener(RipoffBase _newModule) {
        this.activeModule = _newModule;
        this.gui.addListener(_newModule);
    }

   /*
    * Respond to events that this module is listening for.
    */
    @Override
    public void messageReceived(RipoffEvent _event) {
        // We're only interested in a few particular events.
        switch (_event.getMessage().getCode()){
            case RipoffMessage.GAME_PANEL:
                System.out.println("Controller Responding to Game Panel Event.");
                this.gamePanel();
                break;
            case RipoffMessage.PLAYER_PANEL:
                System.out.println("Controller Responding to Player Panel Event.");
                this.playerPanel();
                break;
            case RipoffMessage.REGISTER_PANEL:
                System.out.println("Controller Responding to Register Panel Event.");
        {
            try {
                this.registerPanel();
            } catch (IOException ex) {
                Logger.getLogger(SimpleGameController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
                break;
            case RipoffMessage.MARKET_PANEL:
                System.out.println("Controller Responding to Market Panel Event.");
                this.marketPanel();
                break;
            case RipoffMessage.PLAY_PANEL:
                System.out.println("Conroller Responding to Play Panel Event.");
                this.playPanel();
                break;
            case RipoffMessage.EXIT_PANEL:
                System.out.println("Controller Responding to Main Menu Panel Event.");
                this.mainPanel();
                break;
            case RipoffMessage.CHECK_LOGIN:
                System.out.println("Checking for login");
                //this.checkUser();
                break;
            case RipoffMessage.CREATE_PROFILE:
                System.out.println("Creating profile...");
                break;
            case RipoffMessage.AI_WON_ROUND:
                System.out.println("AI won the game.");
                this.aiWinPanel();
            case RipoffMessage.PLAYER_WON_ROUND:
                System.out.println("Player won the game.");
                this.playerWinPanel();
            default:
                System.out.println("Ignoring Simple Message Code as Irrelevant to Controller. " + _event.getMessage().getCode());
                break;
        }
    }
}