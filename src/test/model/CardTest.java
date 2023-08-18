package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CardTest {
    Card testCard;

    @BeforeEach
    void runBefore() {
        testCard =  new Card("10", "Spade");
    }

    @Test
    void getTestGetValue() {
        assertEquals(testCard.getValue(), "10");
    }

    @Test
    void testGetSuit() {
        assertEquals(testCard.getSuit(), "Spade");
    }
}
