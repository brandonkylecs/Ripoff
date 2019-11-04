package model;

/**
 * This class is the parent for all the models of contenders that will be made.
 *
 * @author Brandon Kyle Last Updated 10/06/2019
 */
import java.util.ArrayList;
public class Contender {

    protected Deck myDeck;
    protected int wonRounds;
    protected int lostRounds;

    public Contender() {
    }

    public Card queryForCard(int _pickedCards) {
        return null;
    }

// ================= GETTERS ==========================
    public Deck getDeck() {
        return this.myDeck;
    }

    public int getWonRounds() {
        return this.wonRounds;
    }

    public int getLostRounds() {
        return this.lostRounds;
    }

// ================= SETTERS ==========================
    public void setDeck(Deck _newDeck) {
        this.myDeck = _newDeck;
    }

    public void incrementWonRounds() {
        this.wonRounds = this.wonRounds++;
    }

    public void incrementLostRounds() {
        this.lostRounds = this.lostRounds++;
    }
}
