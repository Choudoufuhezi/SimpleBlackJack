package model;


import org.json.JSONObject;
import persistence.Writable;

// A class that represents a poker card, with its value and suits.
public class Card implements Writable {
    String cardValue;    //value of the poker card
    String cardSuit;     //suit of the poker card

    //REQUIRES: card value as to be one of the following: [A,2,3,4,5,6,7,8,9,10,J,Q,K], and suit has to be one of
    //spades, clubs, hearts, diamonds.
    //EFFECTS: initialize a card by set it to the input card value and suit.
    public Card(String cardValue, String cardSuit) {
        this.cardValue = cardValue;
        this.cardSuit = cardSuit;
    }


    public String getValue() {
        return this.cardValue;
    }


    public String getSuit() {
        return this.cardSuit;
    }


    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("cardValue", cardValue);
        json.put("cardSuit", cardSuit);
        return json;

    }


}
