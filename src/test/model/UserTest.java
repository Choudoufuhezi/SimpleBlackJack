package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserTest {
    User testUser;

    @BeforeEach
    void runBefore() {
        testUser = new User("x");
    }

    @Test
    void testGetName() {
        assertEquals(testUser.getName(), "x");
    }


    @Test
    void testGetCurrentCard() {
        Card tester = new Card("10", "Spade");
        testUser.getCurrentCards().appendCard(tester, testUser);
        assertEquals(testUser.getCurrentCards().getSize(), 1);

    }


    @Test
    void testComputeCurrentCard() {
        Card tester = new Card("10", "Spade");
        testUser.getCurrentCards().appendCard(tester, testUser);
        assertEquals(testUser.computeCurrentCards(), 10);

        Card tester1 = new Card("A", "Spade");
        testUser.getCurrentCards().appendCard(tester1, testUser);
        assertEquals(testUser.computeCurrentCards(), 11);

        Card tester2 = new Card("J", "Spade");
        testUser.getCurrentCards().appendCard(tester2, testUser);
        assertEquals(testUser.computeCurrentCards(), 21);

        Card tester3 = new Card("Q", "Spade");
        testUser.getCurrentCards().appendCard(tester3, testUser);
        assertEquals(testUser.computeCurrentCards(), 31);

        Card tester4 = new Card("K", "Spade");
        testUser.getCurrentCards().appendCard(tester4, testUser);
        assertEquals(testUser.computeCurrentCards(), 41);

    }

    @Test
    void testAddCard() {
        testUser.getCurrentCards().takeDeckCard();
        int size = testUser.getCurrentCards().getSize();
        Card tester = new Card("10", "Spade");
        User testUser2 = new User("testUser2");
        testUser2.getCurrentCards().appendCard(tester, testUser2);
        testUser.addCard(testUser2.getCurrentCards());

        assertEquals(testUser2.getCurrentCards().getSize(), 0);
        assertEquals(testUser.getCurrentCards().getSize(), size + 1);

    }

    @Test
    void testGetSuitList() {
        Card tester = new Card("10", "Spade");
        testUser.getCurrentCards().appendCard(tester, testUser);
        assertEquals(testUser.getSuitList().get(0), "Spade");
    }

    @Test
    void testGetValueList() {
        Card tester = new Card("10", "Spade");
        testUser.getCurrentCards().appendCard(tester, testUser);
        assertEquals(testUser.getValueList().get(0), "10");
    }

    @Test
    void testSetCard() {
        Card tester = new Card("10", "Spade");
        Card tester2 = new Card("9", "Spade");
        Cards cards = new Cards();
        cards.appendCard(tester, testUser);
        cards.appendCard(tester2, testUser);
        testUser.setCards(cards);
        assertEquals(testUser.getCurrentCards(), cards);
        assertEquals(testUser.getCurrentCards().getSize(), 2);
        assertEquals(testUser.computeCurrentCards(), 19);
    }
}

