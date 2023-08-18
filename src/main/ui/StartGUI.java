package ui;

import model.Card;
import model.Cards;
import model.Computer;
import model.User;
import persistence.JsonReaderComputer;
import persistence.JsonReaderUser;
import persistence.JsonWriter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Random;

//A simple Blackjack game
public class StartGUI extends JFrame {
    JPanel playerDisplay;     //display declares the title of user's card.
    JPanel computer1Display;  //display declares the title of computer 1's card.
    JPanel computer2Display;  //display declares the title of computer 2's card.
    JPanel playerPanel;       //actual panel displays user's card.
    JPanel computerPanel1;    //actual panel displays computer 1's card.
    JPanel computerPanel2;    //actual panel displays computer 2's card.
    JPanel option;            //panel displays user's options.
    JButton hit;              //button in option panel corresponds to the action "hit"
    JButton stand;            //button in option panel corresponds to the action "stand"
    JButton quit;             //button in option panel corresponds to the action "quit"
    JButton restart;          //button in option panel corresponds to the action "restart"
    JButton reOrder;          //button in option panel corresponds to the action "reorder"
    JButton groupBySuit;      //button in option panel corresponds to the action "groupBySuit"
    JButton save;             //button in option panel corresponds to the action "save"
    JButton load;             //button in option panel corresponds to the action "load"
    User humanPlayer;         //representation of the user
    Computer computerPlayer1; //representation of the computer player 1
    Computer computerPlayer2; //representation of the computer player 2
    Cards gameDeck;           //the deck of cards.
    JsonWriter jsonWriter1;   //json writer for user
    JsonWriter jsonWriter2;   //json writer for computer player'1
    JsonWriter jsonWriter3;   //json writer for computer player'2
    JsonReaderUser jsonReader1;   //json reader for user
    JsonReaderComputer jsonReader2;  //json reader for computer player'1
    JsonReaderComputer jsonReader3;  //json writer for computer player'2
    static final String JSON_STORE1 = "./data/humanPlayer.json";     //storage of the jason file of user
    static final String JSON_STORE2 = "./data/computerPlayer1.json"; //storage of the jason file of computer 1
    static final String JSON_STORE3 = "./data/computerPlayer2.json"; //storage of the jason file of computer 2


    //Effects: Initializer of the game, after exiting the game, prints the stored event log.
    public StartGUI() {
        super("Simple Blackjack");
        int width = 1000;
        int height = 1000;
        setBackground(Color.green);
        setSize(width, height);
        init();
        panels();
        addPanels();
        buttons();
        addsLabels();
        addsOptions();
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        setPanelBackgrounds();
        processOptions();
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                humanPlayer.printEventLog();
                System.exit(0);
            }
        });
        setVisible(true);
    }


    //EFFECTS: adds the panels to be ready for display.
    public void addPanels() {
        add(playerDisplay);
        add(playerPanel);
        add(computer1Display);
        add(computerPanel1);
        add(computer2Display);
        add(computerPanel2);
        add(option);
    }

    //MODIFIES: this
    //EFFECTS: set the panels where cards are displayed to "dark green".
    public void setPanelBackgrounds() {
        playerPanel.setBackground(new Color(0,100,0));
        computerPanel1.setBackground(new Color(0,100,0));
        computerPanel2.setBackground(new Color(0,100,0));

    }

    //MODIFIES: this
    //EFFECTS: Set the fonts of the titles, then add to the display panels
    public void addsLabels() {
        JLabel playerLabel  = new JLabel("player's cards");
        JLabel computer1Label  = new JLabel("computer 1's cards");
        JLabel computer2Label = new JLabel("computer 2's cards");

        playerLabel.setFont(new Font("Arial", Font.BOLD, 25));
        computer1Label.setFont(new Font("Arial", Font.BOLD, 25));
        computer2Label.setFont(new Font("Arial", Font.BOLD, 25));
        playerDisplay.add(playerLabel);
        computer1Display.add(computer1Label);
        computer2Display.add(computer2Label);


    }

    //MODIFIES: this
    //EFFECTS: Adds the buttons to the option panel
    public void addsOptions() {
        option.add(hit);
        option.add(stand);
        option.add(quit);
        option.add(restart);
        option.add(reOrder);
        option.add(groupBySuit);
        option.add(save);
        option.add(load);
    }

    //MODIFIES: this
    //EFFECTS: initialize all the buttons in the option panel.
    public void buttons() {
        hit = new JButton("hit");
        stand = new JButton("stand");
        quit = new JButton("quit");
        restart = new JButton("restart");
        reOrder = new JButton("reOrder");
        groupBySuit = new JButton("groupBySuit");
        save = new JButton("save");
        load = new JButton("load");
    }

    //MODIFIES: this
    //EFFECTS: initialize all the panels.
    public void panels() {
        playerDisplay = new JPanel();
        computer1Display = new JPanel();
        computer2Display = new JPanel();
        playerPanel = new JPanel();
        computerPanel1 = new JPanel();
        computerPanel2 = new JPanel();
        option = new JPanel();
    }

    //EFFECTS: process the actions of each corresponding buttons
    public void processOptions() {
        quit.addActionListener(e -> {
            quitMessage();
        });
        save.addActionListener(e -> {
            ifSave();
        });
        load.addActionListener(e -> {
            ifLoad();
        });
        hit.addActionListener(e -> {
            ifHit();
            updateUserInfo();
            updateComputerInfo();
        });
        stand.addActionListener(e -> {
            ifStand();
            updateUserInfo();
            updateComputerInfo();
        });
        processOptions2();
    }


    //EFFECTS: process the actions of each corresponding buttons
    public void processOptions2() {
        restart.addActionListener(e -> {
            clearGUI();
            init();
        });
        reOrder.addActionListener(e -> {
            ifReOrder();
            updateUserInfo();
        });
        groupBySuit.addActionListener(e -> {
            groupBySuit();
            updateUserInfo();
        });
    }

    //MODIFIES: this
    //EFFECTS: reorder the cards for human player
    public void ifReOrder() {
        Collections.reverse(humanPlayer.getCurrentCards().takeDeckCard());
        humanPlayer.ifReorder(humanPlayer);
    }


    //MODIFIES: this
    //EFFECTS: group the suits in the cards for human player.
    public void groupBySuit() {
        Cards lc = new Cards();
        Cards lc1 = new Cards();
        Cards lc2 = new Cards();
        Cards lc3 = new Cards();
        Cards lc4 = new Cards();
        for (Card card: humanPlayer.getCurrentCards().takeDeckCard()) {
            if (card.getSuit().equals("Hearts")) {
                lc.takeDeckCard().add(card);
            } else if (card.getSuit().equals("Spades")) {
                lc1.takeDeckCard().add(card);
            } else if (card.getSuit().equals("Diamonds")) {
                lc2.takeDeckCard().add(card);
            } else if (card.getSuit().equals("Clubs")) {
                lc3.takeDeckCard().add(card);
            }
        }
        lc4.takeDeckCard().addAll(lc.takeDeckCard());
        lc4.takeDeckCard().addAll(lc1.takeDeckCard());
        lc4.takeDeckCard().addAll(lc2.takeDeckCard());
        lc4.takeDeckCard().addAll(lc3.takeDeckCard());
        humanPlayer.setCards(lc4);
    }


    //EFFECTS: pops up a dialog along with a message that inform player that they have exited. Prints the stored
    //event log.
    public void quitMessage() {
        JOptionPane.showMessageDialog(null,
                "thank you for playing",
                "exit message",
                JOptionPane.INFORMATION_MESSAGE);
        humanPlayer.printEventLog();
        System.exit(0);
    }


    //MODIFIES: this
    //EFFECTS: remove everything and refresh all the cards panels.
    public void clearGUI() {
        playerPanel.removeAll();
        playerPanel.repaint();
        computerPanel1.removeAll();
        computerPanel1.repaint();
        computerPanel2.removeAll();
        computerPanel2.repaint();
    }

    //MODIFIES: this
    //EFFECTS: initialize/reinitialize the status of all the objects in the actual game.
    private void init() {
        jsonWriter1 = new JsonWriter(JSON_STORE1);
        jsonWriter2 = new JsonWriter(JSON_STORE2);
        jsonWriter3 = new JsonWriter(JSON_STORE3);

        jsonReader1 = new JsonReaderUser(JSON_STORE1);
        jsonReader2 = new JsonReaderComputer(JSON_STORE2);
        jsonReader3 = new JsonReaderComputer(JSON_STORE3);

        humanPlayer = new User("human player");
        computerPlayer1 = new Computer("computer player 1");
        computerPlayer2 = new Computer("computer player 2");

        humanPlayer.ifRestart(humanPlayer);
        computerPlayer1.ifRestart(computerPlayer1);
        computerPlayer2.ifRestart(computerPlayer2);

        gameDeck = new Cards();
        gameDeck.addNewDeckCard();

    }

    //EFFECTS: pop up dialog inform user the match has been successfully saved, then process the actual saving.
    public void ifSave() {
        JOptionPane.showMessageDialog(null,
                "successfully saved",
                "save message",
                JOptionPane.INFORMATION_MESSAGE);

        saveCurrentGame();
    }

    //EFFECTS: pop up dialog inform user the match has been successfully loaded, then process the actual loading.
    public void ifLoad() {
        clearGUI();
        loadPreviousGame();
        JOptionPane.showMessageDialog(null,
                "successfully loaded",
                "load message",
                JOptionPane.INFORMATION_MESSAGE);

        loadPlayerCards();

        loadComputer1Cards();

        loadComputer2Cards();

    }

    //MODIFIES: this
    //EFFECTS: paints the loaded cards of the user to the user display panel.
    public void loadPlayerCards() {
        for (Card card: this.humanPlayer.getCurrentCards().takeDeckCard()) {
            CardGUI cardGuiPlayer = new CardGUI();
            cardGuiPlayer.assignUI(card);
            cardGuiPlayer.paintCard();
            JLabel playerCard = new JLabel(cardGuiPlayer.cardImage);
            playerPanel.add(playerCard);
        }
        playerPanel.revalidate();
        playerPanel.repaint();
    }

    //MODIFIES: this
    //EFFECTS: paints the loaded cards of the computer 1 to the computer 1 display panel.
    public void loadComputer1Cards() {
        for (Card card: this.computerPlayer1.getCurrentCards().takeDeckCard()) {
            CardGUI cardGuiComputer1 = new CardGUI();
            cardGuiComputer1.assignUI(card);
            cardGuiComputer1.paintCard();
            JLabel playerCard = new JLabel(cardGuiComputer1.cardImage);
            computerPanel1.add(playerCard);
        }
        computerPanel1.revalidate();
        computerPanel1.repaint();
    }

    //MODIFIES: this
    //EFFECTS: paints the loaded cards of the computer 2 to the computer 2 display panel.
    public void loadComputer2Cards() {
        for (Card card: this.computerPlayer2.getCurrentCards().takeDeckCard()) {
            CardGUI cardGuiComputer2 = new CardGUI();
            cardGuiComputer2.assignUI(card);
            cardGuiComputer2.paintCard();
            JLabel playerCard = new JLabel(cardGuiComputer2.cardImage);
            computerPanel2.add(playerCard);
        }
        computerPanel2.revalidate();
        computerPanel2.repaint();
    }

    //MODIFIES: this
    //EFFECTS: passes a single card from the deck of the card and give it to the human player, as well as the computer
    //players. if they have been randomly assigned to "hit(0)" instead of "stand(1)". Event related to stand and
    //hit will be captured.
    public void ifHit() {
        gameDeck.shuffleCards();
        Card getCard1 = gameDeck.takeSingeCard();
        humanPlayer.getCurrentCards().appendCard(getCard1, humanPlayer);
        humanPlayer.ifHit(getCard1, humanPlayer);
        Random action = new Random();
        int hitOrStand = action.nextInt(2);
        if (hitOrStand == 0) {
            Card getCard = gameDeck.takeSingeCard();
            computerPlayer1.getCurrentCards().appendCard(getCard, computerPlayer1);
            computerPlayer1.ifHit(getCard, computerPlayer1);
        } else {
            computerPlayer1.ifStand(computerPlayer1);
        }

        Random action2 = new Random();
        int hitOrStand2 = action2.nextInt(2);
        if (hitOrStand2 == 0) {
            Card getCard = gameDeck.takeSingeCard();
            computerPlayer2.getCurrentCards().appendCard(getCard, computerPlayer2);
            computerPlayer2.ifHit(getCard, computerPlayer2);
        } else {
            computerPlayer2.ifStand(computerPlayer2);
        }

        processResult();

    }

    //MODIFIES: this
    //EFFECTS: cards remain the same for human player. Computer player's action will be randomly assigned.
    //(if they have been randomly assigned to "hit(0)" instead of "stand(1)". Event related to stand and hit will
    //    //be captured.
    public void ifStand() {
        gameDeck.shuffleCards();
        humanPlayer.ifStand(humanPlayer);
        Random action = new Random();
        int hitOrStand = action.nextInt(2);
        if (hitOrStand == 0) {
            Card getCard = gameDeck.takeSingeCard();
            computerPlayer1.getCurrentCards().appendCard(getCard, computerPlayer1);
            computerPlayer1.ifHit(getCard, computerPlayer1);
        } else {
            computerPlayer1.ifStand(computerPlayer1);
        }

        Random action2 = new Random();
        int hitOrStand2 = action2.nextInt(2);
        if (hitOrStand2 == 0) {
            Card getCard = gameDeck.takeSingeCard();
            computerPlayer2.getCurrentCards().appendCard(getCard, computerPlayer2);
            computerPlayer2.ifHit(getCard, computerPlayer2);
        } else {
            computerPlayer2.ifStand(computerPlayer2);
        }

        processResult();
    }



    //EFFECTS: save the current match, if file cannot be found, prints the error message.
    public void saveCurrentGame() {
        try {
            jsonWriter1.open();
            jsonWriter1.write(humanPlayer);
            jsonWriter1.close();

            jsonWriter2.open();
            jsonWriter2.write(computerPlayer1);
            jsonWriter2.close();

            jsonWriter3.open();
            jsonWriter3.write(computerPlayer2);
            jsonWriter3.close();

        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(null,
                    "fail to save",
                    "saving error",
                    JOptionPane.INFORMATION_MESSAGE);
        }
    }

    //MODIFIES: this
    //EFFECTS: loads the previous saved game, if file cannot be found, prints the error message.
    public void loadPreviousGame() {
        try {
            humanPlayer = jsonReader1.read();
            computerPlayer1 = jsonReader2.read();
            computerPlayer2 = jsonReader3.read();

        } catch (IOException e) {
            JOptionPane.showMessageDialog(null,
                    "fail to loaded",
                    "loading error",
                    JOptionPane.INFORMATION_MESSAGE);
        }
    }

    //MODIFIES: this
    //EFFECTS: set up the events that will trigger of finishing the game, if so, displays the status of the
    // user(win/lost).
    private void processResult() {
        updateUserInfo();
        updateComputerInfo();
        Object[] options = {"quit", "restart"};
        if ((humanPlayer.computeCurrentCards() == 21)
                || (computerPlayer1.computeCurrentCards() > 21)
                || (computerPlayer2.computeCurrentCards() > 21)) {

            winInterface(options);

        } else if ((computerPlayer1.computeCurrentCards() == 21)
                || (computerPlayer2.computeCurrentCards() == 21)
                || (humanPlayer.computeCurrentCards() > 21)) {

            lostInterface(options);
        }
    }

    //MIDLIFE: this
    //EFFECTS: updates the panel of the user cards.
    public void updateUserInfo() {
        playerPanel.removeAll();
        for (Card card: this.humanPlayer.getCurrentCards().takeDeckCard()) {
            CardGUI cardGuiPlayer = new CardGUI();
            cardGuiPlayer.assignUI(card);
            cardGuiPlayer.paintCard();
            JLabel playerCard = new JLabel(cardGuiPlayer.cardImage);
            playerPanel.add(playerCard);
        }
        playerPanel.revalidate();
        playerPanel.repaint();
    }

    //MIDLIFE: this
    //EFFECTS: updates the panel of the computer cards.
    public void updateComputerInfo() {
        computerPanel1.removeAll();
        computerPanel2.removeAll();
        for (Card card: this.computerPlayer1.getCurrentCards().takeDeckCard()) {
            CardGUI cardGuiComputer1 = new CardGUI();
            cardGuiComputer1.assignUI(card);
            cardGuiComputer1.paintCard();
            JLabel playerCard = new JLabel(cardGuiComputer1.cardImage);
            computerPanel1.add(playerCard);
        }
        computerPanel1.revalidate();
        computerPanel1.repaint();

        for (Card card: this.computerPlayer2.getCurrentCards().takeDeckCard()) {
            CardGUI cardGuiComputer2 = new CardGUI();
            cardGuiComputer2.assignUI(card);
            cardGuiComputer2.paintCard();
            JLabel playerCard = new JLabel(cardGuiComputer2.cardImage);
            computerPanel2.add(playerCard);
        }
        computerPanel2.repaint();
    }

    //EFFECTS: Displays the win dialog, and ask user either restart or quit,direct them to the corresponding actions.
    public void winInterface(Object[] options) {
        Object userChoice = JOptionPane.showInputDialog(null,
                "you won",
                "game end",
                JOptionPane.QUESTION_MESSAGE,
                null,
                options,
                "quit");

        if (userChoice != null) {
            if (userChoice.equals("restart")) {
                clearGUI();
                init();
            } else {
                quitMessage();
            }
        } else {
            quitMessage();
        }

    }

    //EFFECTS: Displays the lost dialog, and ask user either restart or quit,direct them to the corresponding actions.
    public void lostInterface(Object[] options) {
        Object userChoice = JOptionPane.showInputDialog(null,
                "you lost",
                "game end",
                JOptionPane.QUESTION_MESSAGE,
                null,
                options,
                "quit");

        if (userChoice != null) {
            if (userChoice.equals("restart")) {
                clearGUI();
                init();
            } else {
                quitMessage();
            }
        } else {
            quitMessage();
        }
    }


    //EFFECTS: caller/starter of the game.
    public static void main(String[] args) {
        new StartGUI();
    }
}


