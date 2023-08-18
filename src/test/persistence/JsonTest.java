package persistence;

import model.Card;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JsonTest {
    protected void checkCard(String cardValue, String cardSuit, Card card) {
        assertEquals(cardSuit, card.getSuit());
        assertEquals(cardValue, card.getValue());
    }
}
