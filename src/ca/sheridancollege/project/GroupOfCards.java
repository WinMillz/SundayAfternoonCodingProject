/**
 * SYST 17796 Project Base code.
 * Students can modify and extend to implement their game.
 * Add your name as an author and the date!
 */
package ca.sheridancollege.project;

import ca.sheridancollege.project.WarCard.Deck;
import java.util.ArrayList;
import java.util.Collections;

/**
 * A concrete class that represents any grouping of cards for a Game. HINT, you might want to subclass this more than
 * once. The group of cards has a maximum size attribute which is flexible for reuse.
 *
 * @author dancye
 * @author Paul Bonenfant Jan 2020
 */
public class GroupOfCards {

    //The group of cards, stored in an ArrayList
    private ArrayList<WarCard> cards;
    private int size;//the size of the grouping

    
    /**
     * 
     * @param size 
     */
    public GroupOfCards() {
        cards = new ArrayList<WarCard>();
    }

    /**
     * A method that will get the group of cards as an ArrayList
     *
     * @return the group of cards.
     */
    public ArrayList<WarCard> getCards() {
        return cards;
    }

    public void shuffle() {
        Collections.shuffle(cards);
    }

    /**
     * @return the size of the group of cards
     */
    public int getSize() {
        return cards == null ? 0 : getCards().size();
    }

    /**
     * @param size the max size for the group of cards
     */
    public void setSize(int size) {
        this.size = size;
    }
    

    // This main method is for testing GroupOfCards object
    // NEED TO REMOVE
    public static void main(String[] args) {
        
        Deck[] deck = Deck.values(); // using Deck enum

        GroupOfCards initDeck = new GroupOfCards();
        
        // initDeck contains all 52 card objects in Deck enum
        for (int i = 0; i < deck.length ; i++) {
            WarCard card = new WarCard(i);
            initDeck.cards.add(card);
        }
        
        System.out.println(initDeck.getSize()); // 52
        
        // checking : ordered 52 cards
        for (int i = 0; i < initDeck.getSize(); i++) {
            System.out.println(initDeck.getCards().get(i));  
        }

        // shuffle
        initDeck.shuffle();
        System.out.println("------------------------------------");
        
        // checking : shuffled 52 cards
        for (int i = 0; i < initDeck.getSize(); i++) {
            System.out.println(initDeck.getCards().get(i));  
        }
        
        // initialize player's inhand GroupOfCard object
        GroupOfCards inhand1 = new GroupOfCards();
        GroupOfCards inhand2 = new GroupOfCards();
        

        // assign random 26 cards to each inhand object
        for (int i = 0; i < initDeck.getCards().size(); i += 2) {
            inhand1.cards.add(initDeck.getCards().get(i));
            inhand2.cards.add(initDeck.getCards().get(i + 1));
        }
        
        // checking : player 1's inhand 
        System.out.println("------------------------------------");
        System.out.println("\nPlayer 1's card list. Total: " + inhand1.getSize());
        for (int i = 0; i < inhand1.getSize(); i++) {
            System.out.println(inhand1.getCards().get(i));  
        }

        // checking : player 2's inhand 
        System.out.println("------------------------------------");
        System.out.println("\nPlayer 2's card list. Total: " + inhand1.getSize());
        for (int i = 0; i < inhand2.getSize(); i++) {
            System.out.println(inhand2.getCards().get(i));  
        }

    } // close main method -> NEED TO REMOVE

}//end class
