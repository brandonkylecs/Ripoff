package model;

/**
 * This class contains the Deck object which will represent the card deck in the game. In the game, it will contain all of a user's usable cards.
 *
 * @author Brandon Kyle Last Updated: 10/06/2019
 */

import java.util.ArrayList;

public class Deck {

    private ArrayList<Card> deckCards = new ArrayList<Card>();

    public Deck(ArrayList<Card> _cards) {
        this.deckCards = _cards;
        System.out.println("Deck module loaded.");
    }

    public Deck() {
        System.out.println("Deck module loaded.");
    }

    /**
     * This method will return all the Cards in the Deck.
     *
     * @return
     */
    @Override
    public String toString() {
        String returnedString = "This deck contains the cards:\n";
        for(int count=0; count<this.deckCards.size(); count++) {
            returnedString += this.deckCards.get(count) + "\n";
        }
        return returnedString;
    }

    /**
     * This method sorts the deck by the ID of the cards.
     *
     */
    public void sortByID() {
        ArrayList<Card> sortedDeck = new ArrayList<Card>();
        int minIndex;
        while(!this.deckCards.isEmpty()) {
            minIndex = findMinIDIndex();
            sortedDeck.add(this.deckCards.remove(minIndex));
        }
        this.deckCards = sortedDeck;
    }

    /**
     * This method will shuffle the Cards that are in the Deck randomly.
     *
     */
    public void shuffleCards() {
        ArrayList<Card> shuffledDeck = new ArrayList<Card>();
        while(!this.deckCards.isEmpty()) {
            shuffledDeck.add(this.deckCards.remove((int) (Math.random() * this.deckCards.size())));
        }
        this.deckCards = shuffledDeck;
    }

    /**
     * This method will calculate the total power of all of the Cards in a Deck.
     *
     * @return
     */
    public int calculateTotalPower() {
        int totalPower = 0;
        for(int count=0; count<this.deckCards.size(); count++) {
            totalPower += this.deckCards.get(count).getPower();
        }
        return totalPower;
    }

    /**
     * This method will calculate the average power of the Cards in a Deck.
     *
     * @return
     */
    public int calculateAveragePower() {
        // If there are no cards in the deck, 0 is returned so that an error is not thrown from dividing by zero.
        if(deckCards.isEmpty()) {
            System.out.println("There are no cards in the deck!");
            return 0;
        }
        return this.calculateTotalPower()/deckCards.size();
    }

    /**
     * This method combines two decks together and removes cards from the other deck.
     *
     * @param _deckToAdd
     */
    public void combineDecks(Deck _deckToAdd) {
        while(!_deckToAdd.deckCards.isEmpty()) {
            this.deckCards.add(_deckToAdd.deckCards.remove(0));
        }
    }

    /**
     * Called when a specific number of cards needs to be randomly drawn from the deck. The randomly drawn cards are not replaced. Returns an ArrayList of the cards that were drawn.
     *
     * @param _numberDrawn
     * @return
     */
    public ArrayList<Card> drawCards(int _numberDrawn) {
        ArrayList<Card> drawnCards = new ArrayList();
        Card cardDrawn;
        for(int count=0; count<_numberDrawn; count++) {
            // If the user is out of cards to draw the loop will terminate so that an error is not thrown.
            if(this.deckCards.isEmpty()) {
                System.out.println("User has no more cards to draw.");
                break;
            }
            cardDrawn = this.deckCards.remove((int) (Math.random()*this.deckCards.size()));
            drawnCards.add(cardDrawn);
        }
        return drawnCards;
    }

    /**
     * This method will randomly select a card from the deck.
     *
     * @return
     */
    public Card randomPick() {
        int cardToPick = (int) (Math.random()*this.deckCards.size());
        return this.deckCards.get(cardToPick);
    }

    /**
     * This method will add a Card to the Deck.
     *
     * @param _cardToAdd
     */
    public void addCard(Card _cardToAdd) {
        this.deckCards.add(_cardToAdd);
    }

    /**
     * This method will add an ArrayList of Cards into the Deck.
     *
     * @param _setToAdd
     */
    public void addSet(ArrayList<Card> _setToAdd) {
        int originalSize = _setToAdd.size();
        for(int count=0; count<originalSize; count++) {
            this.deckCards.add(_setToAdd.remove(0));
        }
    }

    /**
     * This method finds the index of the card in the deck with the minimum ID and returns it. This is intended to be used as a helper method with sortByID().
     *
     * @return
     */
    private int findMinIDIndex() {
        int minIndex = 0;
        for(int count=0; count < this.deckCards.size(); count++) {
            if(Integer.parseInt(this.deckCards.get(count).getID()) < Integer.parseInt(this.deckCards.get(minIndex).getID())) {
                minIndex = count;
            }
        }
        return minIndex;
    }

// ================= GETTERS ==========================
    public ArrayList<Card> getDeckCards() {
        return this.deckCards;
    }

    public int getSize() {
        return this.deckCards.size();
    }

// ================= SETTERS ==========================
    public void setDeckCards(ArrayList<Card> newDeck) {
        this.deckCards = newDeck;
    }

}