package ca.sheridancollege.project;

import java.util.Scanner;

/**
 *
 * @author Jinyoung (Kayla) Jeon August 2021
 * @author Juyoung (Jenny) Jung August 2021
 * @author Tamara Dang August 2021
 * @author Winston Martinez August 2021
 */
public class WarCardGame extends Game {

    private WarPlayer p1;
    private WarPlayer p2;
    private boolean playNewGame = false;
    private Scanner input = new Scanner(System.in);

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        // Create instance of WarGame
        WarCardGame warGame = new WarCardGame("War by Sunday Afternoon",
                new WarPlayer("Player 1"), new WarPlayer("Player 2"));
        do {
            warGame.play();
        } while (warGame.getPlayNewGame());

    }

    public WarCardGame(String name, WarPlayer p1, WarPlayer p2) {
        super(name);
        this.p1 = p1;
        this.p2 = p2;
        getPlayers().add(p1);
        getPlayers().add(p2);
    }

    /**
     * This method models 1 full game of play
     */
    @Override
    public void play() {

        WarAsciiArt.displayGameStart();

        System.out.println("Welcome to War. Two players are required.\n"
                + "There will be five total rounds.\nFirst player to get three"
                + "wins will be crowned as the CHAMPION!");

        //prompt players for names
        String p1Name = "Player 1";
        String p2Name = "Player 2";
        do {
            System.out.print("Enter Name for Player 1: ");
            p1Name = input.nextLine();
            System.out.print("Enter name for Player 2: ");
            p2Name = input.nextLine();

            if (p1Name.equalsIgnoreCase(p2Name)) {
                System.out.println("Players must have unique names, please "
                        + "re-enter.");
            }
        } while (p1Name.equalsIgnoreCase(p2Name));

        //register player names
        p1.setName(p1Name);
        p2.setName(p2Name);

        //continue to play rounds until end game condition is reached
        while (p1.getRoundWinCount() < 3 && p2.getRoundWinCount() < 3) {
            if (p1.isForfeit()) {
                p2.setRoundWinCount(3);
            } else if (p2.isForfeit()) {
                p1.setRoundWinCount(3);
            } else {
                playRound();
                incrementRoundWon();

                //System.out.println("\n\nReady for the next round?");
            }

        }

        //declare winner of most recent game
        declareWinner();

        //prompt player for another game and reset values
        String newGame;
        do {
            System.out.println("Press \"Y\" to play a new game, Press \"E\" to "
                    + "exit:");
            newGame = input.nextLine();
            if (newGame.equalsIgnoreCase("Y")) {
                playNewGame = true;
                p1.setForfeit(false);
                p2.setForfeit(false);

                p1.setRoundWinCount(0);
                p2.setRoundWinCount(0);

            } else if (newGame.equalsIgnoreCase("E")) {
                playNewGame = false;
                WarAsciiArt.displayGameEnd();
            }
        } while (!newGame.equalsIgnoreCase("Y") 
                 && !newGame.equalsIgnoreCase("E"));
    }

    /**
     * This method 1 round of play
     */
    public void playRound() {

        //clear win pile for each player and distribute cards
        p1.getWinList().getCards().clear();
        p2.getWinList().getCards().clear();
        distributeCards(p1, p2);

        //play turns until hand of players reaches 0 or player forfeits
        while (p1.getInHand().getSize() > 0 && p2.getInHand().getSize() > 0) {

            if (!p1.isForfeit() && !p2.isForfeit()) {
                playTurn();
            } else {
                p1.getInHand().getCards().clear();
                p2.getInHand().getCards().clear();
            }
        }
    }

    /**
     * This method models one turn of play
     */
    public void playTurn() {
        String playerInput = "";

        //prompt player to select option
        for (int i = 0; i < getPlayers().size(); i++) {
            if (p1.isForfeit() || p2.isForfeit())
                break;
            while (true) {
                System.out.println("\n" + getPlayers().get(i).getName() 
                                   + "'s turn");
                showInstructions();
                playerInput = input.nextLine();
                if (playerInput.equals("c")) {
                      System.out.println(getPlayers().get(i).getName() 
                            + " currently has " 
                            + ((WarPlayer)getPlayers().get(i))
                                    .getInHand().getSize()
                            + " cards left and "
                            + ((WarPlayer)getPlayers().get(i))
                                    .getWinList().getSize()
                            + " cards in their Win Pile");
                } else if (playerInput.equals("p")) {
                    ((WarPlayer)getPlayers().get(i)).play();
                    break;
                } else if (playerInput.equals("t")) {
                    ((WarPlayer)getPlayers().get(i)).setForfeit(true);
                     System.out.println(((WarPlayer)getPlayers().get(i))
                            .getName() + " forfeits!");
                    break;
                } else {
                    System.out.println("Please enter valid input command");
                }
        }

        }

        //assess winner of turn
        int compareCard;
        boolean shouldPlayWar = false;

        if (!p1.isForfeit() && !p2.isForfeit()) {
            do {
                compareCard = compareCards(p1, p2);
                shouldPlayWar = determinePlayWar(compareCard);
                if (shouldPlayWar) {
                    WarAsciiArt.displayWar();
                    //System.out.println("\nIt's War!!");
                    p1.playWar();
                    p2.playWar();
                } else if (compareCard == 1) {
                    System.out.println(p1.getName() + " wins the turn!");
                } else {
                    System.out.println(p2.getName() + " wins the turn!");
                }
            } while (shouldPlayWar);
        }
    }

    /**
     * This method distributes cards to players at the start of the game.
     *
     * @param p1
     * @param p2
     */
    public void distributeCards(WarPlayer p1, WarPlayer p2) {

        // Create group of cards from enum Deck
        GroupOfCards initialDeck = new GroupOfCards();
        for (int i = 0; i < Deck.values().length; i++) {
            initialDeck.getCards().add(new WarCard(i));
        }

        initialDeck.shuffle(); // Shuffle deck

        // Distribute cards into player hands
        if (initialDeck.getSize() > 0) {

            for (int i = 0; i < Deck.values().length / 2; i++) {
                p1.getInHand().getCards().add(initialDeck.getCards().remove(0));
                p2.getInHand().getCards().add(initialDeck.getCards().remove(0));
            }

        }

    }

    /**
     * This method takes the last card in player1 and player2's activeDeck and
     * compares the two card values.
     *
     * @param p1
     * @param p2
     * @return 1 if player1's card is higher value; 2 if player2's card value is
     * higher; 0 if value is equal.
     */
    public int compareCards(WarPlayer p1, WarPlayer p2) {
        int compareCard = 0;

        // Get the value of the last card in player 1 and player 2's active decks
        int p1CardValue = p1.getActiveDeck().getCards().get(
                p1.getActiveDeck().getSize() - 1).getValue();
        int p2CardValue = p2.getActiveDeck().getCards().get(
                p2.getActiveDeck().getSize() - 1).getValue();

        if (p1CardValue > p2CardValue) {

            // Player 1 has the higher value card
            // Remove cards from activeDecks and add to player 1 winList
            while (p1.getActiveDeck().getSize() > 0) {
                p1.getWinList().getCards().add(
                        p1.getActiveDeck().getCards().remove(0));
            }
            while (p2.getActiveDeck().getSize() > 0) {
                p1.getWinList().getCards().add(
                        p2.getActiveDeck().getCards().remove(0));
            }

            compareCard = 1;

        } else if (p1CardValue < p2CardValue) {

            // Player 2 has the higher value card
            // Remove cards from activeDecks and add to player 2 winList
            while (p1.getActiveDeck().getSize() > 0) {
                p2.getWinList().getCards().add(
                        p1.getActiveDeck().getCards().remove(0));
            }
            while (p2.getActiveDeck().getSize() > 0) {
                p2.getWinList().getCards().add(
                        p2.getActiveDeck().getCards().remove(0));
            }

            compareCard = 2;

        }

        return compareCard;
    }

    /**
     * This method determines if war should be played
     *
     * @param compareCard
     * @return
     */
    public boolean determinePlayWar(int compareCard) {

        switch (compareCard) {
            case 0:
                return true;
            default:
                return false;
        }

    }

    /**
     * This method determines the winner based on rounds won
     */
    @Override
    public void declareWinner() {
        if (p1.getRoundWinCount() > p2.getRoundWinCount()) {
            System.out.println(p1.getName() + " Wins the Game!!");
        } else if (p2.getRoundWinCount() > p1.getRoundWinCount()) {
            System.out.println(p2.getName() + " Wins the Game!!");
        }
    }

    /**
     * This method determines which player has won the most recent round and
     * increments the RoundWinCount datamember for the WarPlayer
     */
    public void incrementRoundWon() {

        if (!p1.isForfeit() && !p2.isForfeit()) {
            if (p1.getWinList().getSize() > p2.getWinList().getSize()) {
                p1.setRoundWinCount(p1.getRoundWinCount() + 1);
                System.out.printf("%s: %d vs. %s: %d", p1.getName(), 
                        p1.getRoundWinCount(),
                        p2.getName(), p2.getRoundWinCount());
            } else if (p1.getWinList().getSize() < p2.getWinList().getSize()) {
                p2.setRoundWinCount(p2.getRoundWinCount() + 1);
                System.out.printf("%s: %d vs. %s: %d", p1.getName(), 
                        p1.getRoundWinCount(),
                        p2.getName(), p2.getRoundWinCount());
            } else {
                System.out.println("This round is tie.");
            }
        }
    }

    /**
     * This method displays the options available to the player
     */
    public void showInstructions() {
        System.out.println("Type \"c\" to check how many cards you have left\n"
                + "Type \"p\" to play your next card\n"
                + "Type \"t\" to forfeit the game:");
    }

    public boolean getPlayNewGame() {
        return playNewGame;
    }

    public void setPlayNewGame(boolean playNewGame) {
        this.playNewGame = playNewGame;
    }

}
