
package model;

/**
 * This class contains the logic for the game that will be used in RipoffGUI when the user selects to play against an AI opponent.
 *
 * @author Brandon Kyle, Last Updated 12/05/2019
 */

import events.RipoffMessage;
import java.util.ArrayList;

public class GameBoardAI {
    private int playerOneWins = 0;
    private int playerTwoWins = 0;
    private Contender playerOne = new Contender();
    private ComputerOpponent playerTwo = new ComputerOpponent();
    private ArrayList<Card> playerOneDrawn;
    private ArrayList<Card> playerTwoDrawn;

    /**
     * This constructor method sets the Deck of playerOne and playerTwo to be the parameters.
     *
     * @param _playerOneDeck
     * @param _playerTwoDeck
     */
    public GameBoardAI(Deck _playerOneDeck, Deck _playerTwoDeck) {
        //The playerOneDeck and playerTwoDeck will both get their information from the database but the database is not yet complete.
        playerOne.setDeck(_playerOneDeck);
        playerTwo.setDeck(_playerTwoDeck);
        System.out.println("GameBoardAI module loaded.");
    }

    /**
     * This version of the constructor method does not take any parameters and will just fill the Deck of both playerOne and playerTwo with a set of generic Cards going from one to ten in power.
     */
    public GameBoardAI() {
        playerOne.getDeck().fillDeck();
        playerTwo.getDeck().fillDeck();
    }

    /**
     * This method will take a player's input from the GUI and use that to determine the Card that will be picked. This is intended to be used after the getPlayerOneCardList() method.
     *
     * @param _playerInput
     * @return
     */
    public Card userPickCard(int _playerInput) {
        Card pickedCard = playerOneDrawn.remove(_playerInput);
        System.out.println("The player drew the card " + pickedCard);
        //The Cards that were drawn with the getPlayerOneCardList() method will be readded to the playerOneDeck.
        playerOne.getDeck().addSet(playerOneDrawn);
        return pickedCard;
    }

    /**
     * This method asks playerTwo, the AI opponent, for its Card and returns it. The queryForCard() method automatically restores the AI's Deck to its previous state minus the Card drawn.
     *
     * @return
     */
    public Card aiPickCard() {
        return playerTwo.queryForCard(3);
    }

    /**
     * This method checks which Card had the more power and a Message is returned saying which Card had more. If there is an error, the Message "Error" is returned and a message is printed to
     * the console.
     *
     * @param _playerCard
     * @param _aiCard
     * @return RipoffMessage
     */
    public RipoffMessage determineRoundWinner(Card _playerCard, Card _aiCard) {
        String powerComparison = _playerCard.comparePower(_aiCard);
        RipoffMessage result = new RipoffMessage(RipoffMessage.PLAYER_WON_ROUND);
        //powerComparison will be 1, 0, or -1 depending on which Card has more power. This will return a String saying who won based on that power and increment the wins of the winner.
        switch(powerComparison) {
            case "FIRST CARD":  this.incrementPlayerOneWins();
                                return result;
            case "DRAW":        this.incrementPlayerOneWins();
                                this.incrementPlayerTwoWins();
                                return result = new RipoffMessage(RipoffMessage.DRAW_ROUND);
            case "SECOND CARD": this.incrementPlayerTwoWins();
                                return result = new RipoffMessage(RipoffMessage.AI_WON_ROUND);
        }
        //If powerComparison was not 1, -1, or 0, something went wrong so the Messgae "Error" is returned.
        System.out.println("determineRoundWinner has failed and the returned Meessage is Error.");
        return result = new RipoffMessage(RipoffMessage.ERROR);
    }

    /**
     * This method returns a Deck of Cards that will be used as the user's option for their Card to draw in the game. This will be used in the GUI for displaying to the User which Cards can be
     * selected.
     *
     * @return
     */
    public ArrayList<Card> getPlayerOneChoices() {
        //Draws three Cards from the Deck of the player.
        playerOneDrawn = playerOne.getDeck().drawCards(3);
        System.out.println("The cards " + playerOneDrawn + "have been drawn. The player's Deck has the Cards " + playerOne.getDeck() + "remaining.");
        return playerOneDrawn;
    }

// ================= GETTERS ==========================
    public Deck getPlayerOneDeck() {
        return playerOne.getDeck();
    }

    public Deck getPlayerTwoDeck() {
        return playerTwo.getDeck();
    }

    public int getPlayerOneWins() {
        return playerOneWins;
    }

    public int getPlayerTwoWins() {
        return playerTwoWins;
    }

// ================= SETTERS ==========================
    private void incrementPlayerOneWins() {
        playerOneWins = playerOneWins+1;
    }

    private void incrementPlayerTwoWins() {
        playerTwoWins = playerTwoWins+1;
    }
}
