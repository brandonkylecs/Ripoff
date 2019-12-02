package games;

/**
 *This class is a Controller for playing a game against the AI. It takes the user's input from the GUI and uses the GameBoardAI model to perform the operations to play the game.
 *
 * @author Brandon Kyle, Last Updated 12/02/2019
 */
import model.GameBoardAI;
import model.Deck;
public class PlayerVsComputerController {
    //The only input the user will offer that is used for the game's operations is them selecting which Card they want to play. The value will be set to -1 because -1 will be an impossible input
    //for the user, so if the input is -1 it will signify that the user's input isn't working correctly.
    private int userInput = -1;
    //The userDeck and computerDeck will both be pulled from the database, which isn't complete yet.
    private Deck userDeck = null;
    private Deck computerDeck = null;
    //Because neither Deck can have any unique Cards the version of the GameBoardAI constructor method that fills the Decks with generic cards will be used instead.
    private GameBoardAI playSession = new GameBoardAI();
    public PlayerVsComputerController() {
    }
}