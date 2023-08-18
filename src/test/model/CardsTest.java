package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class CardsTest {
    Cards testCard;
    Computer computer;

    @BeforeEach
    void runBefore() {
        testCard =  new Cards();
        computer = new Computer("computer");
    }


    @Test
    void testNewDeckCards() {
        Cards testCard2 = new Cards();
        testCard2.appendCard(new Card("A", "Hearts"), computer);
        testCard2.appendCard(new Card("A", "Diamonds"), computer);
        testCard2.appendCard(new Card("A", "Clubs"), computer);
        testCard2.appendCard(new Card("A", "Spades"), computer);
        testCard2.appendCard(new Card("2", "Hearts"), computer);
        testCard2.appendCard(new Card("2", "Diamonds"), computer);
        testCard2.appendCard(new Card("2", "Clubs"), computer);
        testCard2.appendCard(new Card("2", "Spades"), computer);
        testCard2.appendCard(new Card("3", "Hearts"), computer);
        testCard2.appendCard(new Card("3", "Diamonds"), computer);
        testCard2.appendCard(new Card("3", "Clubs"), computer);
        testCard2.appendCard(new Card("3", "Spades"), computer);
        testCard2.appendCard(new Card("4", "Hearts"), computer);
        testCard2.appendCard(new Card("4", "Diamonds"), computer);
        testCard2.appendCard(new Card("4", "Clubs"), computer);
        testCard2.appendCard(new Card("4", "Spades"), computer);
        testCard2.appendCard(new Card("5", "Hearts"), computer);
        testCard2.appendCard(new Card("5", "Diamonds"), computer);
        testCard2.appendCard(new Card("5", "Clubs"), computer);
        testCard2.appendCard(new Card("5", "Spades"), computer);


        testCard.addNewDeckCard();

        assertEquals(testCard.getSize(), 52);

    }
    @Test
    void testNewDeckCardsHelper() {
        Cards testCard2 = new Cards();
        testCard2.appendCard(new Card("6", "Hearts"), computer);
        testCard2.appendCard(new Card("6", "Diamonds"), computer);
        testCard2.appendCard(new Card("6", "Clubs"), computer);
        testCard2.appendCard(new Card("6", "Spades"), computer);
        testCard2.appendCard(new Card("7", "Hearts"), computer);
        testCard2.appendCard(new Card("7", "Diamonds"), computer);
        testCard2.appendCard(new Card("7", "Clubs"), computer);
        testCard2.appendCard(new Card("7", "Spades"), computer);
        testCard2.appendCard(new Card("8", "Hearts"), computer);
        testCard2.appendCard(new Card("8", "Diamonds"), computer);
        testCard2.appendCard(new Card("8", "Clubs"), computer);
        testCard2.appendCard(new Card("8", "Spades"), computer);
        testCard2.appendCard(new Card("9", "Hearts"), computer);
        testCard2.appendCard(new Card("9", "Diamonds"), computer);
        testCard2.appendCard(new Card("9", "Clubs"), computer);
        testCard2.appendCard(new Card("9", "Spades"), computer);

        testCard.addNewDeckCard();

        assertEquals(testCard.getSize(), 52);
    }

    @Test
    void testNewDeckCardsHelper1() {
        Cards testCard2 = new Cards();
        testCard2.appendCard(new Card("10", "Hearts"), computer);
        testCard2.appendCard(new Card("10", "Diamonds"), computer);
        testCard2.appendCard(new Card("10", "Clubs"), computer);
        testCard2.appendCard(new Card("10", "Spades"), computer);
        testCard2.appendCard(new Card("J", "Hearts"), computer);
        testCard2.appendCard(new Card("J", "Diamonds"), computer);
        testCard2.appendCard(new Card("J", "Clubs"), computer);
        testCard2.appendCard(new Card("J", "Spades"), computer);
        testCard2.appendCard(new Card("Q", "Hearts"), computer);
        testCard2.appendCard(new Card("Q", "Diamonds"), computer);
        testCard2.appendCard(new Card("Q", "Clubs"), computer);
        testCard2.appendCard(new Card("Q", "Spades"), computer);
        testCard2.appendCard(new Card("K", "Hearts"), computer);
        testCard2.appendCard(new Card("K", "Diamonds"), computer);
        testCard2.appendCard(new Card("K", "Clubs"), computer);
        testCard2.appendCard(new Card("K", "Spades"), computer);

        testCard.addNewDeckCard();

        assertEquals(testCard.getSize(), 52);

    }

    @Test
    void testTakeSingleCard() {
        testCard.addNewDeckCard();
        Card tester = testCard.takeSingeCard();
        assertEquals(tester.getSuit(), "Spades");
        assertEquals(tester.getValue(), "K");

    }

    @Test
    void testTakingDeckCard() {
        testCard.appendCard(new Card("10", "Clubs"), computer);
        assertEquals(testCard.takeDeckCard().size(), 1);
        testCard.appendCard(new Card("11", "Spade"), computer);
        assertEquals(testCard.takeDeckCard().size(), 2);
    }


    @Test
    void testAppends() {
        testCard.appendCard(new Card("10", "Clubs"), computer);
        assertEquals(testCard.takeDeckCard().size(), 1);
        testCard.appendCard(new Card("11", "Spade"), computer);
        testCard.appendCard(new Card("10", "Diamonds"), computer);
        assertEquals(testCard.takeDeckCard().size(), 3);
    }


    @Test
    void testShuffle() {
        testCard.addNewDeckCard();
        testCard.shuffleCards();
        Card test = testCard.deckOfCard.get(0);
        testCard.shuffleCards();
        Card test2 = testCard.deckOfCard.get(0);
        assertNotEquals(test, test2);
    }


}
