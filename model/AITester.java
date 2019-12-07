package model;

/**
 * This class performs tests to ensure that the ComputerOpponent class is working properly and lets the user play against an AI opponent in the console.
 *
 * @author Brandon Kyle Last Updated: 11/25/2019
 */
public class AITester {

    /**
     * This class tests the methods of the gameLogic class and the ComputerOpponent class.
     *
     * @param args
     */
    public static void main(String args[]) {
        GameBoardConsole gameLogic = new GameBoardConsole();
        gameLogic.runGame(2);
    }

}
