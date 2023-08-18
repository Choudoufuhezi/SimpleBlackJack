# CPSC210 - Simple Version Of BlackJack

## Introduction

Blackjack is a traditional casino gambling game, and I think most of you have either heard of it or played it before. 
The rules are simple: each player in this game gets to choose either drawn or stand from a deck of cards. 
If the accumulative value of the cards of a player is greater than 21, the player automatically loses; otherwise, 
whose value is closer to 21 (ideal), wins. Due to the limitation of time, this will be a simpler version of blackjack 
and is expected to be a single-player game (human player vs. computer player). This game is intended designed
for programmers that never use Java or other object-oriented programming languages, to provide them with an overview 
of Java projects, thus this game would mainly serve an educational purpose.


## Reason Of Choosing This Project

The blackjack game has served a relatively meaningful purpose throughout my programming journey. 
The first time I learned to programme back in middle school was to add a small feature to an existing blackjack game 
using Python. I kept getting syntax errors and failed test cases, got frustrated, spent a night on that project, 
and finally, everything ran properly. That was the most rewarding experience that I've ever had in my life, 
and that was part of the reason that drove me to where I am today, and this is why I chose this game as my project.


## User Stories

This simple version of the blackjack application is expected to achieve the following functionalities.

- **As a user, I should be given the option to *quit* the game at any point of the game**
- **As a user, for each round of the game, an random poker card should pass to me if I choose to *"hit"***
- **As a user, for each round of the game, I shouldn't be getting any cards if I choose to *"stand"***
- **As a user, after finishing one round of the game, I should be given the option to *"restart"* the game**
- **As a user, if I accidentally clicked an invalid option, I should be notified and redirect to that page again**
- **As a user, I should have the option to save the current match(unless user/player has won/lost)** 
- **As a user, I should have the option to load the previous saved match**

- **As a user, I should be given the option to *"reOrder"* the cards(last card = first card and so on) in human player
's hand.**
- **As a user, I should be given the option to *"groupBySuit"* the cards in human player's hand.**
- **As a user, I should be able to play the game on a GUI along with all the above functionalities without any problems**


# Instructions for Grader

- You can generate the first required action related to adding Xs to a Y by click **"hit"**, doing so would allow the
user to take a card from the deck to human player's hand for this round. Doing so would also trigger the random actions 
of the  two computer players, they will be randomly assigned to either take a card from the deck or stop taking cards 
for this round. 
- You can generate the second required action related to adding Xs to a Y by click **"reOrder"**, doing so would allow
the human player to swap the index of the card. (e.g. suppose you have a list of card in you hand right now, which are 
["A", "K", "2"], if user has clicked the reOrder button, the order will be changed to [”2“, "K", "A"])
- You can generate the third action related to adding Xs to a Y by click **"restart"**, doing so will remove all the 
cards that player holds(both computer and human), in order to reinitialize the game.
- You can generate the fourth action related to adding Xs to a Y by click **"groupBySuit"**, doing so will recorder and 
group the cards in human player's hand by suits. 
- You can generate the fifth action related to adding Xs to a Y by click **"stand"**, doing so would allow the
human player to stop taking cards for this round. Save as hit, doing so would also trigger the random actions of the
two computer players, they will be randomly assigned to either take a card from the deck or stop taking cards for this
round.
- You can locate my visual component in the player panel, computer 1 panel, as well as computer 2 panel, they all have
the same background color in dark green. On these panels, the graphical version of corresponding poker cards that each
player holds will be displayed in these sections. 
- You can save the state of my application by clicking **"save"** button, doing so would save the cards in all player's
hand. After hitting the save button, a popup window will be displayed to inform you whether you have successfully saved 
or not.
- You can reload the state of my application by clicking **"load"** button. doing so would load the cards in all player's
hand, note that, once you do so, your current match will be replaced with the cards that you've loaded. Similar to save
button, after hitting the load button, a popup window will be displayed to inform you whether you have successfully saved 
or not.


# Phase 4: Task 2;

**The Following three lines of print statements illustrates the cards in each player's hand has been cleared.**
- human player's list of cards has been initialized/reinitialized Suits:[] values:[]
- computer player 1's cards has been initialized/reinitialized Suits:[] values:[]
- computer player 2's cards has been initialized/reinitialized Suits:[] values:[]

**The Following three lines of print statements tells if a player has chosen to hit, and card added to their hand**
- human player has chosen to hit, card suit: Clubs card value: 5  has been added to human player's list of cards. The updated information of the deck: Suits: [Clubs] values: [5]
- computer player 1 has chosen to hit, card suit: Clubs card value: 10 has been added to computer player 1's list of cards.The updated list for computer player 1follows: Suits:[Clubs] Values:[10]
- computer player 2 has chosen to hit, card suit: Clubs card value: 5 has been added to computer player 2's list of cards.The updated list for computer player 2follows: Suits:[Clubs] Values:[5]

**The Following three lines of print statements tells if a player has chosen to stand, no card will be passed to them**
- human player has chosen to stand. The updated information of the deck:Suits: [Spades] values: [7]
- computer player 1 has chosen to stand The updated list for computer player 1 follows: Suits:[Spades] Values:[3]
- computer player 2 has chosen to stand The updated list for computer player 2 follows: Suits:[Clubs, Clubs] Values:[5, K]

**The Following two line of print statements tells if a human player has chosen to reOrder the cards they have**
- human player's list of cards has been reordered from to suits: [Diamonds, Diamonds, Hearts] values: [4, 6, 8]
- human player's list of cards has been reordered from to suits: [Hearts, Diamonds, Diamonds] values: [8, 6, 4]

# Phase 4: Task 3;

- Because my understanding of data structures and object-oriented programming was limited at the beginning of the term, 
there are several adjustments I intend to make after completing the course. To start, I plan to create an Abstract 
class encompassing shared functionalities between User and Computer. Subsequently, both the Computer and User classes 
will extend this Abstract class, containing only their distinct functionalities. Additionally, I'm considering 
refactoring the User and Computer classes into a new class that represents all three players in the game. Each player's 
deck of cards will be stored in a HashMap, with each entry corresponding to a player. I'm undertaking 
these modifications primarily to address the redundancy in my code. I personally believe that adopting 
this approach will enhance efficiency, especially when integrating new features and functionalities into my code.