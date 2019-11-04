package model;

/**
 *
 * @author Brandon Kyle Last Updated 10/06/2019
 */
import java.util.ArrayList;

public class ComputerOpponent extends Contender {

    private int advantagePoints;

    public ComputerOpponent(Deck _usedDeck) {
        this.setDeck(_usedDeck);
        System.out.println("ComputerOpponent module loaded.");
    }

    public ComputerOpponent() {
        System.out.println("ComputerOpponent module loaded.");
    }

    /**
     * This method will ask the AI to choose a card from _pickedCards number of Cards in its Deck. If it cannot draw that many Cards from its Deck but can draw some Cards,
     * it will draw all of the Cards that it can. If the Deck is empty, the method will end, the AI will not pick a Card, and null will be returned. Otherwise, the AI will draw
     * _pickedCards number of Cards from its Deck, decide which one to pick based on its current state, add the unused Cards that were drawn back into it's deck, shuffle the Deck,
     * and return the Card that was picked.
     *
     * @param _pickedCards
     * @return
     */
    @Override
    public Card queryForCard(int _pickedCards) {
        System.out.println("The AI is being queried for its card.");
        if(_pickedCards > this.myDeck.getSize()) {
            System.out.println("The AI can not draw that many cards!");
            if(this.myDeck.getSize()!=0) {
                _pickedCards = this.myDeck.getSize();
            }
            else {
                System.out.println("The AI is out of cards.");
                return null;
            }
        }
        ArrayList<Card> choices = this.myDeck.drawCards(_pickedCards);
        Card drawnCard = this.decideCard(choices);
        myDeck.addSet(choices);
        myDeck.shuffleCards();
        return drawnCard;
    }

    /**
     * This method sets the initial amount of advantage points that the AI opponent will have. It compares the power of the AI's deck and the player's deck.
     * This will help decide how aggressive the AI will be at the start of the match.
     *
     * @param _enemyDeck
     */
    public void compareInitialPower(Contender _enemyUser) {
        Deck enemyDeck = _enemyUser.getDeck();
        int myDeckPower = this.myDeck.calculateAveragePower() + this.myDeck.calculateTotalPower();
        int enemyDeckPower = enemyDeck.calculateAveragePower() + enemyDeck.calculateTotalPower();
        int comparativePower = myDeckPower - enemyDeckPower;
        comparativePower = comparativePower/3;
        this.advantagePoints += comparativePower;
        System.out.println("The AI currently has " + this.advantagePoints + " advantage points.");
    }

    /**
     * This method will be used by the AI to determine which card to draw. If it is in an aggressive state, it will draw the card with the most power.
     * If it is in a protective state, it will draw the card with the least power. If it is in a neutral state, it will draw a random card.
     *
     * @param _selectedCards
     * @return
     */
    public Card decideCard(ArrayList<Card> _selectedCards) {
        int state = decideAIState();
        int indexOfDrawnCard = 0;
        switch (state) {
            case -1:    indexOfDrawnCard = indexProtectiveCard(_selectedCards);
                        break;
            case 0:     indexOfDrawnCard = (int) (Math.random() * _selectedCards.size());
                        break;
            case 1:     indexOfDrawnCard = indexAggressiveCard(_selectedCards);
                        break;
        }
        System.out.println("The AI has drawn card " + _selectedCards.get(indexOfDrawnCard) + "!");
        return _selectedCards.remove(indexOfDrawnCard);
    }

    /**
     * This method decides the state of the AI between neutral, aggressive, and protective using the advantagePoints and Math.random(). The more advantagePoints the AI has,
     * the less chance of it being neutral and going to either aggressive or protective. An AI whose advantagePoints are greater than 0 will not be aggressive, and an AI whose
     * advantage points are less than 0 will not be protective. An AI with 0 advantagePoints will be neutral in every case. This is a helper method for decideCard().
     *
     * @return
     */
    private int decideAIState() {
        int state;
        state = (int) (Math.random() * this.advantagePoints);
        if(state < 0) {
            System.out.println("The AI is aggressive.");
            return 1;
        }
        if(state > 0) {
            System.out.println("The AI is protective.");
            return -1;
        }
        System.out.println("The AI is neutral.");
        return 0;
    }

    /**
     * This is a helper method for the decideCard() method. It will go through the ArrayList of _selectedCards and return the index of the card with the most power.
     *
     * @param _selectedCards
     * @return
     */
    private int indexAggressiveCard(ArrayList<Card> _selectedCards) {
        int aggressiveIndex = 0;
        for(int count = 1; count < _selectedCards.size(); count++)
        {
            if(_selectedCards.get(count).getPower() > _selectedCards.get(aggressiveIndex).getPower()) {
                aggressiveIndex = count;
            }
        }
        return aggressiveIndex;
    }

    /**
     * This is a helper method for the decideCard() method. It will go through the ArrayList of _selectedCards and return the index of the card with the least power.
     *
     * @param _selectedCards
     * @return
     */
    private int indexProtectiveCard(ArrayList<Card> _selectedCards) {
        int protectiveIndex = 0;
        for(int count = 1; count < _selectedCards.size(); count++)
        {
            if(_selectedCards.get(count).getPower() < _selectedCards.get(protectiveIndex).getPower()) {
                protectiveIndex = count;
            }
        }
        return protectiveIndex;
    }

// ================= SETTERS ==========================
    /**
     * This method increments the variable wonRounds and increases the advantagePoints of the AI by 1.
     *
     */
    @Override
    public void incrementWonRounds() {
        this.wonRounds = this.wonRounds++;
        this.advantagePoints = this.advantagePoints++;
    }

    /**
     * This method increments the variable lostRounds and decreases the advantagePoints of the AI by 1.
     *
     */
    @Override
    public void incrementLostRounds() {
        this.lostRounds = this.lostRounds++;
        this.advantagePoints = this.advantagePoints--;
    }
}
