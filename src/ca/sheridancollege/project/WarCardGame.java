package ca.sheridancollege.project;

/**
 *
 * @author Jinyoung (Kayla) Jeon August 2021
 * @author Juyoung (Jenny) Jung August 2021
 * @author Tamara Dang August 2021
 * @author Winston Martinez August 2021
 */
public class WarCardGame extends Game {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        WarCardGame warGame = new WarCardGame("War by Sunday Afternoon");

        // Create new Players
        WarPlayer player1 = new WarPlayer("J");
        WarPlayer player2 = new WarPlayer("K");

        warGame.distributeCards(player1, player2);

        // **REMOVE** Checking that cards were distributed
        System.out.println("Player 1: " + player1.getName() + ", # of cards inHand : "
                + player1.getInHand().getSize() + "\nCards: " + player1.getInHand().getCards()); //remove
        System.out.println("Player 2: " + player2.getName() + ", # of cards inHand : "
                + player2.getInHand().getSize() + "\nCards: " + player2.getInHand().getCards()); //remove

        // **REPLACE** With play() method
        player1.getActiveDeck().getCards().add(player1.getInHand().getCards().remove(0));
        player2.getActiveDeck().getCards().add(player1.getInHand().getCards().remove(0));

        // **REMOVE** Test checking values in activeDeck 
        System.out.println("P1 activeDeck: " + player1.getActiveDeck().getCards()); //remove
        System.out.println("P2 activeDeck: " + player2.getActiveDeck().getCards()); //remove

        int compareCard = warGame.compareCards(player1, player2);
        System.out.println("Result of compare cards: " + compareCard); //remove

        boolean shouldPlayWar = warGame.determinePlayWar(compareCard);
        System.out.println("Should play war: " + shouldPlayWar); //remove

        // **REMOVE** Test checking values in activeDeck and winList 
        System.out.println("P1 activeDeck: " + player1.getActiveDeck().getCards()); //remove
        System.out.println("P2 activeDeck: " + player2.getActiveDeck().getCards()); //remove
        System.out.println("P1 winList: " + player1.getWinList().getCards()); //remove
        System.out.println("P2 winList: " + player2.getWinList().getCards()); //remove
    }

    public WarCardGame(String name) {
        super(name);
    }

    /**
     * This method distributes cards to players at the start of the game.
     *
     * @param player1
     * @param player2
     */
    public void distributeCards(WarPlayer player1, WarPlayer player2) {

        // Create group of cards from enum Deck
        GroupOfCards initialDeck = new GroupOfCards();
        for (int i = 0; i < Deck.values().length; i++) {
            initialDeck.getCards().add(new WarCard(i));
        }

        initialDeck.shuffle(); // Shuffle deck

        // Distribute cards into player hands
        if (initialDeck.getSize() > 0) {

            for (int i = 0; i < Deck.values().length / 2; i++) {
                player1.getInHand().getCards().add(initialDeck.getCards().remove(0));
                player2.getInHand().getCards().add(initialDeck.getCards().remove(0));
            }

        }

    }

    /**
     * This method takes the last card in player1 and player2's activeDeck and
     * compares the two card values.
     *
     * @param player1
     * @param player2
     * @return 1 if player1's card is higher value; 2 if player2's card value
     * is higher; 0 if value is equal.
     */
    public int compareCards(WarPlayer player1, WarPlayer player2) {
        int compareCard = 0;

        // Get the value of the last card in player 1 and player 2's active decks
        int player1CardValue = player1.getActiveDeck().getCards().get(
                player1.getActiveDeck().getSize() - 1).getValue();
        int player2CardValue = player2.getActiveDeck().getCards().get(
                player2.getActiveDeck().getSize() - 1).getValue();

        if (player1CardValue > player2CardValue) {

            // Player 1 has the higher value card
            // Remove cards from activeDecks and add to player 1 winList
            while (player1.getActiveDeck().getSize() > 0) {
                player1.getWinList().getCards().add(
                        player1.getActiveDeck().getCards().remove(0));
            }
            while (player2.getActiveDeck().getSize() > 0) {
                player1.getWinList().getCards().add(
                        player2.getActiveDeck().getCards().remove(0));
            }

            compareCard = 1;

        } else if (player1CardValue < player2CardValue) {

            // Player 2 has the higher value card
            // Remove cards from activeDecks and add to player 2 winList
            while (player1.getActiveDeck().getSize() > 0) {
                player2.getWinList().getCards().add(
                        player1.getActiveDeck().getCards().remove(0));
            }
            while (player2.getActiveDeck().getSize() > 0) {
                player2.getWinList().getCards().add(
                        player2.getActiveDeck().getCards().remove(0));
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

    @Override
    public void play() {

    }

    @Override
    public void declareWinner() {

    }
}
