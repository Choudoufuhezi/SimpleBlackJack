package ui;

import model.Card;

import javax.swing.*;


//Representation of graphic of each poker card.
public class CardGUI {
    Card card;            // textual representation of the card.
    ImageIcon cardImage;   // graphic representation of the card.

    //EFFECTS: initializer without any inputs.
    public CardGUI() {
    }

    //MODIFIES: this
    //EFFECTS: assign input Card as Card for this graphic.
    public void assignUI(Card card) {
        this.card = card;
    }

    //REQUIRES: this.card != null;
    //EFFECTS: direct Card to the corresponding method and paint the card.
    public ImageIcon paintCard() {
        if ((this.card.getValue().equals("J"))
                || (this.card.getValue().equals("Q"))
                || (this.card.getValue().equals("K"))) {
            return searchFaceCard();
        } else if (this.card.getSuit().equals("Hearts")) {
            return searchHearts();
        } else if (this.card.getSuit().equals("Diamonds")) {
            return searchDiamonds();
        } else if (this.card.getSuit().equals("Clubs")) {
            return searchClubs();
        } else {
            return searchSpades();
        }
    }


    //REQUIRES: (this.card == "Hearts" && this.card != "J" && this.card != "Q" && this.card != "K" && this.card == null)
    //MODIFIES: this
    //EFFECTS: paints the card based on the value and suit.
    private ImageIcon searchHearts() {
        if (this.card.getSuit().equals("Hearts") && (this.card.getValue().equals("A"))) {
            cardImage = new ImageIcon("./src/main/ui/CardIcons/Heart-A.png");
        } else if (this.card.getSuit().equals("Hearts") && (this.card.getValue().equals("2"))) {
            cardImage = new ImageIcon("./src/main/ui/CardIcons/Heart-2.png");
        } else if (this.card.getSuit().equals("Hearts") && (this.card.getValue().equals("3"))) {
            cardImage = new ImageIcon("./src/main/ui/CardIcons/Heart-3.png");
        } else if (this.card.getSuit().equals("Hearts") && (this.card.getValue().equals("4"))) {
            cardImage = new ImageIcon("./src/main/ui/CardIcons/Heart-4.png");
        } else if (this.card.getSuit().equals("Hearts") && (this.card.getValue().equals("5"))) {
            cardImage = new ImageIcon("./src/main/ui/CardIcons/Heart-5.png");
        } else if (this.card.getSuit().equals("Hearts") && (this.card.getValue().equals("6"))) {
            cardImage = new ImageIcon("./src/main/ui/CardIcons/Heart-6.png");
        } else if (this.card.getSuit().equals("Hearts") && (this.card.getValue().equals("7"))) {
            cardImage = new ImageIcon("./src/main/ui/CardIcons/Heart-7.png");
        } else if (this.card.getSuit().equals("Hearts") && (this.card.getValue().equals("8"))) {
            cardImage = new ImageIcon("./src/main/ui/CardIcons/Heart-8.png");
        } else if (this.card.getSuit().equals("Hearts") && (this.card.getValue().equals("9"))) {
            cardImage = new ImageIcon("./src/main/ui/CardIcons/Heart-9.png");
        } else {
            cardImage = new ImageIcon("./src/main/ui/CardIcons/Heart-10.png");
        }
        return cardImage;
    }

    //REQUIRES: (this.card == "Diamonds" && this.card != "J" && this.card != "Q" && this.card != "K" &&
    // this.card == null)
    //MODIFIES: this
    //EFFECTS: paints the card based on the value and suit.
    private ImageIcon searchDiamonds() {
        if (this.card.getSuit().equals("Diamonds") && (this.card.getValue().equals("A"))) {
            cardImage = new ImageIcon("./src/main/ui/CardIcons/Dimond-A.png");
        } else if (this.card.getSuit().equals("Diamonds") && (this.card.getValue().equals("2"))) {
            cardImage = new ImageIcon("./src/main/ui/CardIcons/Dimond-2.png");
        } else if (this.card.getSuit().equals("Diamonds") && (this.card.getValue().equals("3"))) {
            cardImage = new ImageIcon("./src/main/ui/CardIcons/Dimond-3.png");
        } else if (this.card.getSuit().equals("Diamonds") && (this.card.getValue().equals("4"))) {
            cardImage = new ImageIcon("./src/main/ui/CardIcons/Dimond-4.png");
        } else if (this.card.getSuit().equals("Diamonds") && (this.card.getValue().equals("5"))) {
            cardImage = new ImageIcon("./src/main/ui/CardIcons/Dimond-5.png");
        } else if (this.card.getSuit().equals("Diamonds") && (this.card.getValue().equals("6"))) {
            cardImage = new ImageIcon("./src/main/ui/CardIcons/Dimond-6.png");
        } else if (this.card.getSuit().equals("Diamonds") && (this.card.getValue().equals("7"))) {
            cardImage = new ImageIcon("./src/main/ui/CardIcons/Dimond-7.png");
        } else if (this.card.getSuit().equals("Diamonds") && (this.card.getValue().equals("8"))) {
            cardImage = new ImageIcon("./src/main/ui/CardIcons/Dimond-8.png");
        } else if (this.card.getSuit().equals("Diamonds") && (this.card.getValue().equals("9"))) {
            cardImage = new ImageIcon("./src/main/ui/CardIcons/Dimond-9.png");
        } else {
            cardImage = new ImageIcon("./src/main/ui/CardIcons/Dimond-10.png");
        }
        return cardImage;
    }

    //REQUIRES: (this.card == "Clubs" && this.card != "J" && this.card != "Q" && this.card != "K" && this.card == null)
    //MODIFIES: this
    //EFFECTS: paints the card based on the value and suit.
    private ImageIcon searchClubs() {
        if (this.card.getSuit().equals("Clubs") && (this.card.getValue().equals("A"))) {
            cardImage = new ImageIcon("./src/main/ui/CardIcons/Club-A.png");
        } else if (this.card.getSuit().equals("Clubs") && (this.card.getValue().equals("2"))) {
            cardImage = new ImageIcon("./src/main/ui/CardIcons/Club-2.png");
        } else if (this.card.getSuit().equals("Clubs") && (this.card.getValue().equals("3"))) {
            cardImage = new ImageIcon("./src/main/ui/CardIcons/Club-3.png");
        } else if (this.card.getSuit().equals("Clubs") && (this.card.getValue().equals("4"))) {
            cardImage = new ImageIcon("./src/main/ui/CardIcons/Club-4.png");
        } else if (this.card.getSuit().equals("Clubs") && (this.card.getValue().equals("5"))) {
            cardImage = new ImageIcon("./src/main/ui/CardIcons/Club-5.png");
        } else if (this.card.getSuit().equals("Clubs") && (this.card.getValue().equals("6"))) {
            cardImage = new ImageIcon("./src/main/ui/CardIcons/Club-6.png");
        } else if (this.card.getSuit().equals("Clubs") && (this.card.getValue().equals("7"))) {
            cardImage = new ImageIcon("./src/main/ui/CardIcons/Club-7.png");
        } else if (this.card.getSuit().equals("Clubs") && (this.card.getValue().equals("8"))) {
            cardImage = new ImageIcon("./src/main/ui/CardIcons/Club-8.png");
        } else if (this.card.getSuit().equals("Clubs") && (this.card.getValue().equals("9"))) {
            cardImage = new ImageIcon("./src/main/ui/CardIcons/Club-9.png");
        } else {
            cardImage = new ImageIcon("./src/main/ui/CardIcons/Club-10.png");
        }
        return cardImage;
    }

    //REQUIRES: (this.card == "Spades" && this.card != "J" && this.card != "Q" && this.card != "K" && this.card == null)
    //MODIFIES: this
    //EFFECTS: paints the card based on the value and suit.
    private ImageIcon searchSpades() {
        if (this.card.getSuit().equals("Spades") && (this.card.getValue().equals("A"))) {
            cardImage = new ImageIcon("./src/main/ui/CardIcons/Spade-A.png");
        } else if (this.card.getSuit().equals("Spades") && (this.card.getValue().equals("2"))) {
            cardImage = new ImageIcon("./src/main/ui/CardIcons/Spade-2.png");
        } else if (this.card.getSuit().equals("Spades") && (this.card.getValue().equals("3"))) {
            cardImage = new ImageIcon("./src/main/ui/CardIcons/Spade-3.png");
        } else if (this.card.getSuit().equals("Spades") && (this.card.getValue().equals("4"))) {
            cardImage = new ImageIcon("./src/main/ui/CardIcons/Spade-4.png");
        } else if (this.card.getSuit().equals("Spades") && (this.card.getValue().equals("5"))) {
            cardImage = new ImageIcon("./src/main/ui/CardIcons/Spade-5.png");
        } else if (this.card.getSuit().equals("Spades") && (this.card.getValue().equals("6"))) {
            cardImage = new ImageIcon("./src/main/ui/CardIcons/Spade-6.png");
        } else if (this.card.getSuit().equals("Spades") && (this.card.getValue().equals("7"))) {
            cardImage = new ImageIcon("./src/main/ui/CardIcons/Spade-7.png");
        } else if (this.card.getSuit().equals("Spades") && (this.card.getValue().equals("8"))) {
            cardImage = new ImageIcon("./src/main/ui/CardIcons/Spade-8.png");
        } else if (this.card.getSuit().equals("Spades") && (this.card.getValue().equals("9"))) {
            cardImage = new ImageIcon("./src/main/ui/CardIcons/Spade-9.png");
        } else {
            cardImage = new ImageIcon("./src/main/ui/CardIcons/Spade-10.png");
        }
        return cardImage;
    }

    //REQUIRES: cannot be any card with value from 1-10 or card have not been assigned yet(null).
    //MODIFIES: this
    //EFFECTS: paints the card based on the value and suit.
    private ImageIcon searchFaceCard() {
        if (this.card.getSuit().equals("Spades") && (this.card.getValue().equals("J"))) {
            cardImage = new ImageIcon("./src/main/ui/CardIcons/Spade-Jack.png");
        } else if (this.card.getSuit().equals("Spades") && (this.card.getValue().equals("Q"))) {
            cardImage = new ImageIcon("./src/main/ui/CardIcons/Spade-Queen.png");
        } else if (this.card.getSuit().equals("Spades") && (this.card.getValue().equals("K"))) {
            cardImage = new ImageIcon("./src/main/ui/CardIcons/Spade-King.png");
        } else if (this.card.getSuit().equals("Clubs") && (this.card.getValue().equals("J"))) {
            cardImage = new ImageIcon("./src/main/ui/CardIcons/Club-Jack.png");
        } else if (this.card.getSuit().equals("Clubs") && (this.card.getValue().equals("Q"))) {
            cardImage = new ImageIcon("./src/main/ui/CardIcons/Club-Queen.png");
        } else if (this.card.getSuit().equals("Clubs") && (this.card.getValue().equals("K"))) {
            cardImage = new ImageIcon("./src/main/ui/CardIcons/Club-King.png");
        } else if (this.card.getSuit().equals("Diamonds") && (this.card.getValue().equals("J"))) {
            cardImage = new ImageIcon("./src/main/ui/CardIcons/Dimond-Jack.png");
        } else if (this.card.getSuit().equals("Diamonds") && (this.card.getValue().equals("Q"))) {
            cardImage = new ImageIcon("./src/main/ui/CardIcons/Dimond-Queen.png");
        } else if (this.card.getSuit().equals("Diamonds") && (this.card.getValue().equals("K"))) {
            cardImage = new ImageIcon("./src/main/ui/CardIcons/Dimond-King.png");
        } else {
            ifHearts();
        }
        return cardImage;
    }

    //REQUIRES: cannot process any cards except Heart Jack, Heart Queen, and Heart King.
    //MODIFIES: this.
    //EFFECTS: paints the card based on the value and suit.
    private void ifHearts() {
        if (this.card.getSuit().equals("Hearts") && (this.card.getValue().equals("J"))) {
            cardImage = new ImageIcon("./src/main/ui/CardIcons/Heart-Jack.png");
        } else if (this.card.getSuit().equals("Hearts") && (this.card.getValue().equals("Q"))) {
            cardImage = new ImageIcon("./src/main/ui/CardIcons/Heart-Queen.png");
        } else {
            cardImage = new ImageIcon("./src/main/ui/CardIcons/Heart-King.png");
        }
    }

}
