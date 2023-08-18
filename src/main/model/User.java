package model;


import org.json.JSONArray;
import org.json.JSONObject;
import persistence.Writable;

import java.util.ArrayList;

//A class that represents a human blackjack player, with player's current cards in hand.
public class User implements Writable {
    Cards currentCards;    //current list of cards in hand.
    String name;

    //EFFECTS: initialize the computer player by setting the total amount to 0, as well as an empty list of cards.
    public User(String name) {
        this.currentCards = new Cards();
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Cards getCurrentCards() {
        return this.currentCards;
    }

    //EFFECTS: update the list of cards in this class to the given cards.
    public void setCards(Cards cards) {
        this.currentCards = cards;
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

    //REQUIRES: the given list of card should have at least one card.
    //MODIFIES: this
    //EFFECTS: append a card from another list of cards to the current list.
    public void addCard(Cards cards) {
        Card getCard = cards.takeSingeCard();
        this.currentCards.appendCard(getCard, this);
    }

    //MODIFIES: this
    //EFFECTS: appends the input card towards the list of cards.
    public void addAnyCard(Card card) {
        this.currentCards.appendCard(card, this);
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

    // EFFECTS: returns cards in this human player as a JSON array
    public JSONArray currentCardsToJson() {
        JSONArray jsonArray = new JSONArray();

        for (Card c : currentCards.takeDeckCard()) {
            jsonArray.put(c.toJson());
        }

        return jsonArray;
    }

    //EFFECTS: add event when hit is pressed
    public void ifHit(Card card, User human) {
        EventLog.getInstance().logEvent(new Event("human player has chosen to hit, card suit: "
                + card.getSuit() + " card value: " + card.getValue() + " "
                + " has been added to human player's list of cards. The updated information of the deck:"
                + " Suits: " + human.getSuitList() + " values: " + human.getValueList()));
    }


    //EFFECTS: add event when stand is pressed
    public void ifStand(User human) {
        EventLog.getInstance().logEvent(new Event("human player has chosen to stand. "
                + "The updated information of the deck:" + "Suits: "
                + human.getSuitList() + " values: " + human.getValueList()));
    }

    //EFFECTS: add event when restart if pressed
    public void ifRestart(User user) {
        EventLog.getInstance().logEvent(new Event("human player's list of cards has been"
                + " initialized/reinitialized" + " Suits:" + user.getSuitList() + " values:" +  user.getValueList()));
    }

    //EFFECTS: add event when reOrder if pressed
    public void ifReorder(User user) {
        EventLog.getInstance().logEvent(new Event("human player's list of cards has been reordered from to "
                + "suits: " + user.getSuitList() + " values: " + user.getValueList()));
    }

    // EFFECTS: print event logs
    public void printEventLog() {
        for (Event event : EventLog.getInstance()) {
            System.out.println(event);
        }
    }





}
