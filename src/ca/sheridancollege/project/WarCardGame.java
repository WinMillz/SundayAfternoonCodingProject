package ca.sheridancollege.project;

import java.util.ArrayList;

/**
 *
 * @author Jinyoung Jeon August 2021
 * @author Juyoung Jung August 2021
 * @author Tamara Dang August 2021
 * @author Winston Martinez August 2021
 */
public class WarCardGame extends Game {

    GroupOfCards deck;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        // Create group of cards from enum Deck
        GroupOfCards deck = new GroupOfCards(Deck.values().length);

        for (int i = 0; i < Deck.values().length; i++) {
            deck.addCard(new WarCard(i));
        }

        //System.out.println(deck.getCards());//remove
        
        deck.shuffle(); // Shuffle deck
        
        // Declare ArrayLists for player hands
        GroupOfCards playerOneHand = new GroupOfCards(Deck.values().length /2);
        
        // Distribute cards into player hands
        //for (int p=0; p < 2; p++) {
            for (int i=0; i < Deck.values().length / 2; i++) {
                playerOneHand.addCard(distributeCards(deck));
            }
        //} // **how to loop through multiple players?

        System.out.println(deck.getCards()); //remove
        System.out.println(playerOneHand.getCards()); //remove
        
        // **Testing *needs rework* Comparing value of two cards
        // Add card to playedList and returning value
        ArrayList<Card> playedList = deck.getCards();
        // Cast into WarCard and get last card from ArrayList
        WarCard check = (WarCard)playedList.get(playedList.size()-1);
        // Check value of WarCard
        System.out.println(check.getValue()); // end testing *needs rework*

    }

    public WarCardGame(String name) {
        super(name);
    }

    /**
     * This method distributes cards to players at the start of the game.
     * The method removes the first card in the GroupOfCards deck and 
     * returns it.
     *
     * @param deck the group of cards to draw from
     * @return the card that was removed from the deck
     */
    public static Card distributeCards(GroupOfCards deck) {
        
        Card card = null;
        
        if (deck.getSize() > 0) {
            card = deck.removeCard(0);
        }
        return card;

    }
    
    /**
     * **NOT COMPLETE**
     * @param card
     * @return the value of the card
     */
    public static int checkValue(WarCard card) {
 
        return card.getValue();
    }

    @Override
    public void play() {

    }

    @Override
    public void declareWinner() {

    }
}
