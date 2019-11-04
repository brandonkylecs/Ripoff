
package games;

import java.util.ArrayList;
import model.Card;
import model.Deck;
import model.Contender;
import model.ComputerOpponent;

/**
 *
 * @author Brandon Kyle Last Updated: 10/08/2019
 */
import java.util.Scanner;
public class GameControllerConsole {

    private Scanner readInput = new Scanner(System.in);

    public GameControllerConsole() {
    }

    public void runGame(int _numDrawn) {
        Contender playerOne = new Contender();
        ComputerOpponent playerTwo = new ComputerOpponent();
        boolean draw = false;
        int oneWins = 0;
        int twoWins = 0;
        System.out.println("Welcome to the game.");
        playerOne.setDeck(difficultySelectHuman());
        playerTwo.setDeck(difficultySelectAI());
        while(oneWins < 3 && twoWins < 3 && !draw) {
            int result = roundResult(playerOne, playerTwo, _numDrawn);
            switch (result) {
                case 1:
                    oneWins = oneWins + 1;
                    System.out.println("You win this round. You have score " + oneWins + ". Bob has score " + twoWins + ".");
                    break;
                case -1:
                    twoWins = twoWins + 1;
                    System.out.println("You lose this round. You have score " + oneWins + ". Bob has score " + twoWins + ".");
                    break;
                case 0:
                    System.out.println("The cards had the same power, therefore no points are awarded. You have score " + oneWins + ". Bob has score " + twoWins + ".");
                    break;
            }
            if(oneWins < 3 && twoWins < 3) {
                draw = drawChecker(playerOne, playerTwo);
            }
        }
        if(oneWins == 3) {
            System.out.println("You won!");
        }
        if(twoWins == 3) {
            System.out.println("Bob won...");
        }
    }

    /**
     * This method activates a round of the game, has the user and computer draw a Card, and then returns the result of a comparison of power between the Cards.
     *
     * @param _human
     * @param _computer
     * @param _numDrawn
     * @return
     */
    private int roundResult(Contender _human, ComputerOpponent _computer, int _numDrawn) {
        System.out.println("You currently have the cards: \n" + _human.getDeck());
        System.out.println("Drawing cards...");
        Card oneCard = this.askForCard(_human, _numDrawn);
        System.out.println("The opponent is drawing their card...");
        Card twoCard = _computer.queryForCard(_numDrawn);
        return oneCard.comparePower(twoCard);
    }

    /**
     * This method draws Cards for the user and then asks the user which Card they would like to select, and then returns the selected Card. If the user makes an invalid input, the method
     * runs again until a correct input is made. The number of Cards drawn can be specified with the _numDrawn parameter.
     *
     * @param _player
     * @param _numDrawn
     * @return
     */
    private Card askForCard(Contender _player, int _numDrawn) {
        ArrayList<Card> drawnCards = _player.getDeck().drawCards(_numDrawn);
        Card pickedCard;
        System.out.println("You have drawn the cards:\n");
        for(int count = 0; count < drawnCards.size(); count++) {
            System.out.println(count + 1 + ". " + drawnCards.get(count));
        }
        System.out.println("Which card would you like to play?");
        String selectedCard = readInput.nextLine();
        int numberOfCard = -1;
        // If the user types in something that is not a number, the program will catch the error so that the program does not terminate and the query will repeat so the user can try again.
        try {
            numberOfCard = Integer.parseInt(selectedCard) - 1;
        }
        catch(NumberFormatException noInt) {
        }
        // This checks to ensure that the input from the user is within the range of Cards that they can select.
        if(numberOfCard > -1 && numberOfCard < drawnCards.size()) {
            pickedCard = drawnCards.remove(numberOfCard);
            System.out.println("The user has drawn " + pickedCard);
            _player.getDeck().addSet(drawnCards);
            return pickedCard;
        }
        System.out.println("Invalid input, please try again.");
        // If the user's input is out of range, a new Deck consisting just of those Cards is created to be set to the _player's Deck so that the method can use a recursion and force the player
        // to chooose one of those Cards.
        Deck unusedCards = new Deck();
        unusedCards.addSet(drawnCards);
        // A temporary Deck is created to store all of the other Cards that a _player has.
        Deck temp = _player.getDeck();
        _player.setDeck(unusedCards);
        pickedCard = askForCard(_player, _numDrawn);
        //The _player's other Cards are added back into its Deck.
        _player.getDeck().addSet(temp.getDeckCards());
        return pickedCard;
    }

    /**
     * This method checks if there are any conditions present in the match to where it can not be completed. The four conditions it checks for are if the user and AI do not have any Cards
     * left, if only the user does not have any Cards left, if only the AI does not have any Cards left, and if the user and AI only have one Card of equal power left. If any of these
     * are true, true is returned. Otherwise, false is returned.
     *
     * @param _player
     * @param _computer
     * @return
     */
    private boolean drawChecker(Contender _player, Contender _computer) {
        // If both the player and AI have no cards left, the match is a draw and true is returned.
        if(_player.getDeck().getDeckCards().isEmpty() && _computer.getDeck().getDeckCards().isEmpty()) {
            System.out.println("Both users have no cards left to draw from. It is a draw.");
            return true;
        }
        // If the player has no cards left, the AI wins and true is returned.
        if(_player.getDeck().getDeckCards().isEmpty()) {
            System.out.println("You are out of cards. You lose.");
            return true;
        }
        // If the computer has no cards left, the player wins and true is returned.
        if(_computer.getDeck().getDeckCards().isEmpty()) {
            System.out.println("Bob is out of cards. You win.");
            return true;
        }
        // If both the computer and player only have one card left and those cards are of equal power, it is a draw and true is returned.
        if(_player.getDeck().getDeckCards().size() == 1 && _computer.getDeck().getDeckCards().size() == 1 && _player.getDeck().calculateTotalPower() == _computer.getDeck().calculateTotalPower()) {
            System.out.println("Both users only have one card left and that Card is of equal power. It is a draw.");
            return true;
        }
        // If none of these conditions are met, there is no issue and the game can proceed as normal, so false is returned.
        return false;
    }

    /**
     * This allows the user to select which set of Cards they want the AI to use. The good cards have more average and total power than the bad cards.
     *
     * @return
     */
    private Deck difficultySelectAI() {
        Deck enemyDeck = new Deck();
        System.out.println("What cards would you like for the AI to have?\n1. I want the AI to have bad cards.\n2. I want the AI to have good cards.");
        String userInput = readInput.nextLine();
        int userChoice = 0;
        // If the user types in something that is not a number, the program will catch the error so that the program does not terminate and the query will repeat so the user can try again.
        try {
            userChoice = Integer.parseInt(userInput);
        }
        catch(NumberFormatException noInt) {
        }
        switch(userChoice) {
            case 1: enemyDeck.addSet(generateBadCards());
                    return enemyDeck;
            case 2: enemyDeck.addSet(generateGoodCards());
                    return enemyDeck;
        }
        System.out.println("Invalid input. Please try again.");
        return difficultySelectAI();
    }

    /**
     * This allows the user to select which set of Cards they want, the good cards have more average and total power than the bad cards.
     *
     * @return
     */
    private Deck difficultySelectHuman() {
        Deck userDeck = new Deck();
        System.out.println("What cards would you like to have?\n1. I want bad cards.\n2. I want good cards.");
        String userInput = readInput.nextLine();
        int userChoice = 0;
        // If the user types in something that is not a number, the program will catch the error so that the program does not terminate and the query will repeat so the user can try again.
        try {
            userChoice = Integer.parseInt(userInput);
        }
        catch(NumberFormatException noInt) {
        }
        switch(userChoice) {
            case 1: userDeck.addSet(generateBadCards());
                    return userDeck;
            case 2: userDeck.addSet(generateGoodCards());
                    return userDeck;
        }
        System.out.println("Invalid input. Please try again.");
        return difficultySelectHuman();
    }

    /**
     * This generates an ArrayList of comparatively better Cards for use in the game.
     *
     * @return
     */
    private ArrayList<Card> generateGoodCards() {
        Card testCardTwo = new Card("Card Two", "02", 2);
        Card testCardFour = new Card("Card Four", "04", 4);
        Card testCardSix = new Card("Card Six", "06", 6);
        Card testCardEight = new Card("Card Eight", "08", 8);
        Card testCardTen = new Card("Card Ten", "10", 10);
        ArrayList<Card> goodCards = new ArrayList<Card>();
        goodCards.add(testCardTwo);
        goodCards.add(testCardFour);
        goodCards.add(testCardSix);
        goodCards.add(testCardEight);
        goodCards.add(testCardTen);
        return goodCards;
    }

    /**
     * This generates an ArrayList of comparatively worse Cards for use in the game.
     *
     * @return
     */
    private ArrayList<Card> generateBadCards() {
        Card testCardOne = new Card("Card One", "01", 1);
        Card testCardThree = new Card("Card Three", "03", 3);
        Card testCardFive = new Card("Card Five", "05", 5);
        Card testCardSeven = new Card("Card Seven", "07", 7);
        Card testCardNine = new Card("Card Nine", "09", 9);
        ArrayList<Card> badCards = new ArrayList<Card>();
        badCards.add(testCardOne);
        badCards.add(testCardThree);
        badCards.add(testCardFive);
        badCards.add(testCardSeven);
        badCards.add(testCardNine);
        return badCards;
    }
}