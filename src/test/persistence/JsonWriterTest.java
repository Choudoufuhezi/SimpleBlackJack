package persistence;

import model.Card;
import model.Cards;
import model.Computer;
import model.User;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class JsonWriterTest extends JsonTest{

    @Test
    void testWriterInvalidFileUser() {
        try {
            User hp = new User("human player 1");
            JsonWriter writer = new JsonWriter("./data/my\0illegal:fileName.json");
            writer.open();
            fail("IOException was expected");
        } catch (IOException e) {
            // pass
        }
    }

    @Test
    void testWriterInvalidFileComputer() {
        try {
            Computer cp = new Computer("computer player 1");
            JsonWriter writer = new JsonWriter("./data/my\0illegal:fileName.json");
            writer.open();
            fail("IOException was expected");
        } catch (IOException e) {
            // pass
        }
    }

    @Test
    void testWriterEmptyUser() {
        try {
            User hp = new User("human player 1");
            JsonWriter writer = new JsonWriter("./data/testWriterEmptyUser.json");
            writer.open();
            writer.write(hp);
            writer.close();

            JsonReaderUser reader = new JsonReaderUser ("./data/testWriterEmptyUser.json");
            ArrayList<String> tester = new ArrayList<>();
            hp = reader.read();
            assertEquals(0, hp.computeCurrentCards());
            assertEquals(tester, hp.getSuitList());
            assertEquals(tester, hp.getValueList());

        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }

    @Test
    void testWriterEmptyComputer() {
        try {
            Computer cp = new Computer("computer player 1");
            JsonWriter writer = new JsonWriter("./data/testWriterEmptyComputer.json");
            writer.open();
            writer.write(cp);
            writer.close();

            JsonReaderComputer reader = new JsonReaderComputer("./data/testWriterEmptyComputer.json");
            ArrayList<String> tester = new ArrayList<>();
            cp = reader.read();
            assertEquals(0, cp.computeCurrentCards());
            assertEquals(tester, cp.getSuitList());
            assertEquals(tester, cp.getValueList());

        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }


    @Test
    void testWriterEmptyComputer2() {
        try {
            Computer cp = new Computer("computer player 1");
            JsonWriter writer = new JsonWriter("./data/testWriterEmptyComputer2.json");
            writer.open();
            writer.write(cp);
            writer.close();

            JsonReaderComputer reader = new JsonReaderComputer("./data/testWriterEmptyComputer2.json");
            ArrayList<String> tester = new ArrayList<>();
            cp = reader.read();
            assertEquals(0, cp.computeCurrentCards());
            assertEquals(tester, cp.getSuitList());
            assertEquals(tester, cp.getValueList());

        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }

    @Test
    void testWriterGeneralUser() {
        try {
            User hp = new User("human player 1");
            hp.addAnyCard(new Card("A", "Spades"));
            hp.addAnyCard(new Card("5", "Clubs"));
            JsonWriter writer = new JsonWriter("./data/testWriterGeneralUser.json");
            writer.open();
            writer.write(hp);
            writer.close();

            JsonReaderUser reader = new JsonReaderUser ("./data/testWriterGeneralUser.json");
            hp = reader.read();
            Cards tester = hp.getCurrentCards();
            assertEquals(2, tester.getSize());
            checkCard("A", "Spades", tester.takeDeckCard().get(0));
            checkCard("5", "Clubs", tester.takeDeckCard().get(1));

        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }


    @Test
    void testWriterGeneralComputer() {
        try {
            Computer cp = new Computer("computer player 1");
            cp.addAnyCard(new Card("A", "Spades"), cp);
            cp.addAnyCard(new Card("5", "Clubs"), cp);
            JsonWriter writer = new JsonWriter("./data/testWriterGeneralComputer.json");
            writer.open();
            writer.write(cp);
            writer.close();

            JsonReaderComputer reader = new JsonReaderComputer  ("./data/testWriterGeneralComputer.json");
            cp = reader.read();
            Cards tester = cp.getCurrentCards();
            assertEquals(2, tester.getSize());
            checkCard("A", "Spades", tester.takeDeckCard().get(0));
            checkCard("5", "Clubs", tester.takeDeckCard().get(1));

        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }

    @Test
    void testWriterGeneralComputer2() {
        try {
            Computer cp = new Computer("computer player 2");
            cp.addAnyCard(new Card("A", "Spades"), cp);
            cp.addAnyCard(new Card("5", "Clubs"), cp);
            JsonWriter writer = new JsonWriter("./data/testWriterGeneralComputer2.json");
            writer.open();
            writer.write(cp);
            writer.close();

            JsonReaderComputer reader = new JsonReaderComputer("./data/testWriterGeneralComputer2.json");
            cp = reader.read();
            Cards tester = cp.getCurrentCards();
            assertEquals(2, tester.getSize());
            checkCard("A", "Spades", tester.takeDeckCard().get(0));
            checkCard("5", "Clubs", tester.takeDeckCard().get(1));

        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }


}
