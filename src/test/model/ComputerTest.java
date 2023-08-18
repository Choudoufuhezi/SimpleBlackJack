package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ComputerTest {
    Computer testComputer;

    @BeforeEach
    void runBefore() {
        testComputer = new Computer("y");
    }

    @Test
    void testGetName() {
        assertEquals( testComputer.getName(), "y");
    }


    @Test
    void testGetAmount() {
        assertEquals(testComputer.computeCurrentCards(), 0);
        testComputer.getCurrentCards().appendCard(new Card("10", "Spade"), testComputer);
        assertEquals(testComputer.computeCurrentCards(), 10);

    }

    @Test
    void testGetCurrentCard() {
        Card tester = new Card("10", "Spade");
        testComputer.getCurrentCards().appendCard(tester, testComputer);
        assertEquals(testComputer.getCurrentCards().getSize(), 1);
    }

    @Test
    void testComputeCurrentCard() {
        Card tester = new Card("10", "Spade");
        testComputer.getCurrentCards().appendCard(tester, testComputer);
        assertEquals(testComputer.computeCurrentCards(), 10);

        Card tester1 = new Card("A", "Spade");
        testComputer.getCurrentCards().appendCard(tester1, testComputer);
        assertEquals(testComputer.computeCurrentCards(), 11);

        Card tester2 = new Card("J", "Spade");
        testComputer.getCurrentCards().appendCard(tester2, testComputer);
        assertEquals(testComputer.computeCurrentCards(), 21);


        Card tester3 = new Card("Q", "Spade");
        testComputer.getCurrentCards().appendCard(tester3, testComputer);
        assertEquals(testComputer.computeCurrentCards(), 31);


        Card tester4 = new Card("K", "Spade");
        testComputer.getCurrentCards().appendCard(tester4, testComputer);
        testComputer.computeCurrentCards();
        assertEquals(testComputer.computeCurrentCards(), 41);

    }

    @Test
    void testGetSuitList() {
        Card tester = new Card("10", "Spade");
        testComputer.getCurrentCards().appendCard(tester, testComputer);
        assertEquals(testComputer.getSuitList().get(0), "Spade");
    }

    @Test
    void testGetValueList() {
        Card tester = new Card("10", "Spade");
        testComputer.getCurrentCards().appendCard(tester, testComputer);
        assertEquals(testComputer.getValueList().get(0), "10");
    }


}
