package persistence;

import model.Card;
import model.User;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

// Represents a reader that reads human player's information from JSON data stored in file
public class JsonReaderUser {
    private String source;

    // EFFECTS: constructs reader to read from source file
    public JsonReaderUser(String source) {
        this.source = source;
    }

    // EFFECTS: reads human player's data from file and returns it;
    // throws IOException if an error occurs reading data from file
    public User read() throws IOException {
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


    // EFFECTS: parses human player's data from JSON object and returns it
    private User parseUser(JSONObject jsonObject) {
        User hp = new User("human player");
        addThingies(hp, jsonObject);
        return hp;
    }

    // MODIFIES: hp
    // EFFECTS: parses cards from JSON object and adds them to human player
    private void addThingies(User hp, JSONObject jsonObject) {
        JSONArray jsonArray = jsonObject.getJSONArray("currentCards");
        for (Object json : jsonArray) {
            JSONObject nextThingy = (JSONObject) json;
            addCard(hp, nextThingy);
        }
    }

    // MODIFIES: hp
    // EFFECTS: parses card from JSON object and adds it to human player
    private void addCard(User hp, JSONObject jsonObject) {
        String cardValue = jsonObject.getString("cardValue");
        String cardSuit = jsonObject.getString("cardSuit");
        Card card = new Card(cardValue, cardSuit);
        hp.addAnyCard(card);
    }
}
