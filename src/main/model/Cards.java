package model;


import org.json.JSONArray;
import org.json.JSONObject;
import persistence.Writable;

import java.util.Collections;
import java.util.*;

//Represents a list of poker cards.
public class Cards {
    List<Card> deckOfCard;       //list of poker cards.

    //EFFECTS: initialize an empty list of poker cards.
    public Cards() {
        this.deckOfCard = new ArrayList<>();

    }

    //EFFECTS: adds a full set of poker cards.
    public void addNewDeckCard() {
        this.deckOfCard.add(new Card("A", "Hearts"));
        this.deckOfCard.add(new Card("A", "Diamonds"));
        this.deckOfCard.add(new Card("A", "Clubs"));
        this.deckOfCard.add(new Card("A", "Spades"));
        this.deckOfCard.add(new Card("2", "Hearts"));
        this.deckOfCard.add(new Card("2", "Diamonds"));
        this.deckOfCard.add(new Card("2", "Clubs"));
        this.deckOfCard.add(new Card("2", "Spades"));
        this.deckOfCard.add(new Card("3", "Hearts"));
        this.deckOfCard.add(new Card("3", "Diamonds"));
        this.deckOfCard.add(new Card("3", "Clubs"));
        this.deckOfCard.add(new Card("3", "Spades"));
        this.deckOfCard.add(new Card("4", "Hearts"));
        this.deckOfCard.add(new Card("4", "Diamonds"));
        this.deckOfCard.add(new Card("4", "Clubs"));
        this.deckOfCard.add(new Card("4", "Spades"));
        this.deckOfCard.add(new Card("5", "Hearts"));
        this.deckOfCard.add(new Card("5", "Diamonds"));
        this.deckOfCard.add(new Card("5", "Clubs"));
        this.deckOfCard.add(new Card("5", "Spades"));
        addNewDeckCardHelper();

    }

    //EFFECTS: adds a full set of poker cards.
    public void addNewDeckCardHelper() {
        this.deckOfCard.add(new Card("6", "Hearts"));
        this.deckOfCard.add(new Card("6", "Diamonds"));
        this.deckOfCard.add(new Card("6", "Clubs"));
        this.deckOfCard.add(new Card("6", "Spades"));
        this.deckOfCard.add(new Card("7", "Hearts"));
        this.deckOfCard.add(new Card("7", "Diamonds"));
        this.deckOfCard.add(new Card("7", "Clubs"));
        this.deckOfCard.add(new Card("7", "Spades"));
        this.deckOfCard.add(new Card("8", "Hearts"));
        this.deckOfCard.add(new Card("8", "Diamonds"));
        this.deckOfCard.add(new Card("8", "Clubs"));
        this.deckOfCard.add(new Card("8", "Spades"));
        this.deckOfCard.add(new Card("9", "Hearts"));
        this.deckOfCard.add(new Card("9", "Diamonds"));
        this.deckOfCard.add(new Card("9", "Clubs"));
        this.deckOfCard.add(new Card("9", "Spades"));
        addNewDeckCardHelper1();
    }

    //EFFECTS: adds a full set of poker cards.
    public void addNewDeckCardHelper1() {
        this.deckOfCard.add(new Card("10", "Hearts"));
        this.deckOfCard.add(new Card("10", "Diamonds"));
        this.deckOfCard.add(new Card("10", "Clubs"));
        this.deckOfCard.add(new Card("10", "Spades"));
        this.deckOfCard.add(new Card("J", "Hearts"));
        this.deckOfCard.add(new Card("J", "Diamonds"));
        this.deckOfCard.add(new Card("J", "Clubs"));
        this.deckOfCard.add(new Card("J", "Spades"));
        this.deckOfCard.add(new Card("Q", "Hearts"));
        this.deckOfCard.add(new Card("Q", "Diamonds"));
        this.deckOfCard.add(new Card("Q", "Clubs"));
        this.deckOfCard.add(new Card("Q", "Spades"));
        this.deckOfCard.add(new Card("K", "Hearts"));
        this.deckOfCard.add(new Card("K", "Diamonds"));
        this.deckOfCard.add(new Card("K", "Clubs"));
        this.deckOfCard.add(new Card("K", "Spades"));
    }

    //MODIFIES: this
    //EFFECTS: shuffles the list of cards.
    public void shuffleCards() {
        Collections.shuffle(this.deckOfCard);
    }

    //REQUIRES: the list of card should contain at least one element.
    //MODIFIES: this
    //EFFECTS: returns the last card of the list of cards, and remove
    // that card from the list.
    public Card takeSingeCard() {
        int numberOfCards = this.deckOfCard.size();
        Card cardDirect = this.deckOfCard.get(numberOfCards - 1);
        this.deckOfCard.remove(numberOfCards - 1);
        return cardDirect;
    }

    public List<Card> takeDeckCard() {
        return this.deckOfCard;
    }


    //EFFECTS: append a certain card to the list.
    public void appendCard(Card card, Computer computer) {
        this.deckOfCard.add(card);
//        EventLog.getInstance().logEvent(new Event(computer.getName()
//                + "has been added a card with suit" + card.getSuit() + "and value of" + card.getValue()))
    }

    public void appendCard(Card card, User user) {
        this.deckOfCard.add(card);
//        EventLog.getInstance().logEvent(new Event(user.getName()
//                + "has been added a card with suit" + card.getSuit() + "and value of" + card.getValue()));
    }


    public int getSize() {
        return this.deckOfCard.size();
    }


}