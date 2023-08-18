package persistence;

import model.Cards;
import model.Computer;
import model.User;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class JsonReaderTest extends JsonTest{
    @Test
    void testReaderNonExistentFileUser() {
        JsonReaderUser reader = new JsonReaderUser("./data/noSuchFile.json");
        try {
            User hp = reader.read();
            fail("IOException expected");
        } catch (IOException e) {
            // pass
        }
    }

    @Test
    void testReaderNonExistentFileComputer() {
        JsonReaderComputer reader = new JsonReaderComputer("./data/noSuchFile.json");
        try {
            Computer cp = reader.read();
            fail("IOException expected");
        } catch (IOException e) {
            // pass
        }
    }

    @Test
    void testReaderNonExistentFileComputer2() {
        JsonReaderComputer2 reader = new JsonReaderComputer2("./data/noSuchFile.json");
        try {
            Computer cp = reader.read();
            fail("IOException expected");
        } catch (IOException e) {
            // pass
        }
    }

    @Test
    void testReaderEmptyUser() {
        JsonReaderUser reader = new JsonReaderUser("./data/testWriterEmptyUser.json");
        try {
            User hp = reader.read();
            ArrayList<String> tester = new ArrayList<>();
            assertEquals(0, hp.computeCurrentCards());
            assertEquals(tester, hp.getSuitList());
            assertEquals(tester, hp.getValueList());
        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }

    @Test
    void testReaderEmpty() {
        JsonReaderComputer reader = new JsonReaderComputer("./data/testWriterEmptyComputer.json");
        try {
            Computer cp = reader.read();
            ArrayList<String> tester = new ArrayList<>();
            assertEquals(0, cp.computeCurrentCards());
            assertEquals(tester, cp.getSuitList());
            assertEquals(tester, cp.getValueList());
        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }

    @Test
    void testReaderEmpty2() {
        JsonReaderComputer2 reader = new JsonReaderComputer2("./data/testWriterEmptyComputer2.json");
        try {
            Computer cp = reader.read();
            ArrayList<String> tester = new ArrayList<>();
            assertEquals(0, cp.computeCurrentCards());
            assertEquals(tester, cp.getSuitList());
            assertEquals(tester, cp.getValueList());
        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }

    @Test
    void testReaderGeneralUser() {
        JsonReaderUser reader = new JsonReaderUser("./data/testWriterGeneralUser.json");
        try {
            User hp = reader.read();
            Cards tester = hp.getCurrentCards();
            assertEquals(2, tester.getSize());
            checkCard("A", "Spades", tester.takeDeckCard().get(0));
            checkCard("5", "Clubs", tester.takeDeckCard().get(1));
        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }

    @Test
    void testReaderGeneralComputer() {
        JsonReaderComputer reader = new JsonReaderComputer("./data/testWriterGeneralComputer.json");
        try {
            Computer cp = reader.read();
            Cards tester = cp.getCurrentCards();
            assertEquals(2, tester.getSize());
            checkCard("A", "Spades", tester.takeDeckCard().get(0));
            checkCard("5", "Clubs", tester.takeDeckCard().get(1));
        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }

    @Test
    void testReaderGeneralComputer2() {
        JsonReaderComputer2 reader = new JsonReaderComputer2("./data/testWriterGeneralComputer2.json");
        try {
            Computer cp = reader.read();
            Cards tester = cp.getCurrentCards();
            assertEquals(2, tester.getSize());
            checkCard("A", "Spades", tester.takeDeckCard().get(0));
            checkCard("5", "Clubs", tester.takeDeckCard().get(1));
        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }


}
