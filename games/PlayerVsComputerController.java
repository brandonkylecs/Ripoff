package games;

/**
 *This class is a Controller for playing a game against the AI. It takes the user's input from the GUI and uses the GameBoardAI model to perform the operations to play the game.
 *
 * @author Brandon Kyle, Tyler Wallschleger Last Updated 12/04/2019
 */
import events.RipoffMessage;
import model.Card;
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

    /*
     * This method takes the card the player chose determines the winner.
     * @param Card _playerCard
     * @returns RipoffMessage winner  -- Needs to return this for the outcome to work with the button
     */
    public RipoffMessage playCard(Card _playerCard){
        RipoffMessage winner = new RipoffMessage(RipoffMessage.PLAYER_WON_ROUND);
        return winner;
    }
}