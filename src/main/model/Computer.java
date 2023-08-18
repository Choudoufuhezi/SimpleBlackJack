package model;


import org.json.JSONArray;
import org.json.JSONObject;
import persistence.Writable;

import java.util.ArrayList;

//A class that represents a computer blackjack player, with player's current cards in hand.
public class Computer implements Writable {
    Cards currentCards;   //current list of cards in hand.
    String name;  //name of the player.

    //EFFECTS: initialize the computer player by setting the total amount to 0, as well as an empty list of cards.
    public Computer(String name) {
        this.name = name;
        this.currentCards = new Cards();
    }

    public String getName() {
        return name;
    }


    public Cards getCurrentCards() {
        return this.currentCards;
    }


    //EFFECTS: computes the total value of the cards in hand to assign to the total value.
    public int computeCurrentCards() {
        int amount = 0;
        for (Card c: this.currentCards.takeDeckCard()) {
            if (c.getValue().equals("A")) {
                amount = amount + 1;
            } else if ((c.getValue().equals("J")) || (c.getValue().equals("Q")) || (c.getValue().equals("K"))) {
                amount = amount + 10;
            } else {
                amount = amount + Integer.parseInt(c.getValue());
            }
        }
        return amount;
    }

    //MODIFIES: this
    //EFFECTS: appends the input card towards the list of cards.
    public void addAnyCard(Card card, Computer computer) {
        this.currentCards.appendCard(card, computer);
    }


    //EFFECTS: returns all the face value of the current cards.
    public ArrayList<String> getValueList() {
        ArrayList<String> value = new ArrayList<>();
        for (Card c: currentCards.takeDeckCard()) {
            value.add(c.getValue());
        }
        return value;
    }

    //EFFECTS: returns all the suits a deck of the current cards.
    public ArrayList<String> getSuitList() {
        ArrayList<String> suit = new ArrayList<>();
        for (Card c: currentCards.takeDeckCard()) {
            suit.add(c.getSuit());
        }
        return suit;
    }

    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("currentCards", currentCardsToJson());
        return json;

    }

    // EFFECTS: returns cards in this computer player as a JSON array
    public JSONArray currentCardsToJson() {
        JSONArray jsonArray = new JSONArray();

        for (Card c : currentCards.takeDeckCard()) {
            jsonArray.put(c.toJson());
        }

        return jsonArray;
    }

    //EFFECTS: add event when hit is pressed
    public void ifHit(Card card, Computer computer) {
        EventLog.getInstance().logEvent(new Event(computer.getName() + " has chosen to hit, card suit: "
                + card.getSuit() + " card value: " + card.getValue() + " has been added to " + computer.getName() + "'s"
                + " list of cards." + "The updated list for " + computer.getName() + "follows: Suits:"
                + computer.getSuitList() + " Values:" + computer.getValueList()));
    }

    //EFFECTS: add event when stand is pressed
    public void ifStand(Computer computer) {
        EventLog.getInstance().logEvent(new Event(computer.getName() +  " has chosen to stand"
                + " The updated list for " + computer.getName() + " follows: Suits:" + computer.getSuitList()
                + " Values:" + computer.getValueList()));
    }

    //EFFECTS: add event when restart if pressed
    public void ifRestart(Computer computer) {
        EventLog.getInstance().logEvent(new Event(computer.getName()
                + "'s cards has been initialized/reinitialized" + " Suits:" + computer.getSuitList()
                + " values:" + computer.getValueList()));
    }


}
