package model;

import events.RipoffMessage;

/**
 * This class contains the Card object which will be used to represent the cards in the game. All cards will have a name, ID, and power.
 *
 * @author Brandon Kyle Last Updated: 12/05/2019
 */
public class Card {

    private String cardName;
    private String cardId;
    private int cardPower;

    public Card(String _name, String _id, int _power) {
        this.cardName = _name;
        this.cardId = _id;
        this.cardPower = _power;
        System.out.println("Card module loaded.");
    }

    /**
     * This is the toString() method for the Card class. It will return a String containing information about the card's name, ID, and power.
     *
     * @return
     */
    @Override
    public String toString() {
        return "This card's name is: " + this.cardName + ". This card's ID is " + this.cardId + ". This card's power is " + this.cardPower + ".";
    }
    /**
     * This method will compare the power of two Cards. If this Card has more power, it will return FIRST CARD. If the parameter compareCard has more power, it will return SECOND CARD. If they have equal
     * power, it will return DRAW. If the card's power is less than 1, ERROR is returned, since no Card will have power less than 1 unless something has gone wrong.
     *
     * @param _compareCard
     * @return
     */
    public int comparePower(Card _compareCard) {
        System.out.println("");
        System.out.println("PLAYER CARD " + this.cardPower);
        System.out.println("AI CARD: " + _compareCard.getPower());
        System.out.println("");
        //ERROR will be returned 
        if(this.cardPower < 1 || _compareCard.getPower() < 1) {
            return RipoffMessage.ERROR;
        }
        if(this.cardPower > _compareCard.getPower()) {
            return RipoffMessage.PLAYER_WON_ROUND;
        }
        if(this.cardPower < _compareCard.getPower()) {
            return RipoffMessage.AI_WON_ROUND;
        }
        return RipoffMessage.DRAW_ROUND;
    }

// ================= GETTERS ==========================
    public String getName() {
        return this.cardName;
    }

    public String getID() {
        return this.cardId;
    }

    public int getPower() {
        return this.cardPower;
    }

// ================= SETTERS ==========================
    public void setName(String _name) {
        this.cardName = _name;
    }

    public void setId(String _id) {
        this.cardId = _id;
    }

    public void setPower(int _power) {
        this.cardPower = _power;
    }

}