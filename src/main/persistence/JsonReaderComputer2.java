package persistence;

import model.Card;
import model.Computer;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

// Represents a reader that reads computer player's information from JSON data stored in file
public class JsonReaderComputer2 {
    private String source;

    // EFFECTS: constructs reader to read from source file
    public JsonReaderComputer2(String source) {
        this.source = source;
    }

    // EFFECTS: reads computer data from file and returns it;
    // throws IOException if an error occurs reading data from file
    public Computer read() throws IOException {
        String jsonData = readFile(source);
        JSONObject jsonObject = new JSONObject(jsonData);
        return parseUser(jsonObject);
    }

    // EFFECTS: reads source file as string and returns it
    private String readFile(String source) throws IOException {
        StringBuilder contentBuilder = new StringBuilder();

        try (Stream<String> stream = Files.lines(Paths.get(source), StandardCharsets.UTF_8)) {
            stream.forEach(s -> contentBuilder.append(s));
        }

        return contentBuilder.toString();
    }


    // EFFECTS: parses computer data from JSON object and returns it
    private Computer parseUser(JSONObject jsonObject) {
        Computer cp = new Computer("computer player 2");
        addThingies(cp, jsonObject);
        return cp;
    }

    // MODIFIES: cp
    // EFFECTS: parses cards from JSON object and adds them to computer
    private void addThingies(Computer cp, JSONObject jsonObject) {
        JSONArray jsonArray = jsonObject.getJSONArray("currentCards");
        for (Object json : jsonArray) {
            JSONObject nextThingy = (JSONObject) json;
            addCard(cp, nextThingy);
        }
    }

    // MODIFIES: cp
    // EFFECTS: parses card from JSON object and adds it to computer
    private void addCard(Computer cp, JSONObject jsonObject) {
        String cardValue = jsonObject.getString("cardValue");
        String cardSuit = jsonObject.getString("cardSuit");
        Card card = new Card(cardValue, cardSuit);
        cp.addAnyCard(card, cp);
    }
}