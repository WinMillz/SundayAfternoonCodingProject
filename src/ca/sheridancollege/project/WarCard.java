package ca.sheridancollege.project;

import java.util.ArrayList;

/**
 *
 * @author Jinyoung Jeon, Juyoung Jung, Tamara Dang, Winston Martinez
 */
public class WarCard extends Card {

    private Deck[] deck;
    private Deck warCard;

    /**
     * WarCard constructor with int parameter as index of cards in Deck.
     *
     * @param num
     */
    public WarCard(int num) {
        deck = Deck.values();
        this.warCard = deck[num];
    }

    /**
     * Retrieves the rank of each card. For example, SPADES_ACE returns 14,
     * CLUBS_4 returns 4.
     *
     * @return the rank of each card
     */
    public int getValue() {
        return this.warCard.getValue();
    }

    /**
     * Override the toString method and return the name of the card.
     * 
     * @return
     */
    @Override
    public String toString() {
        return warCard.getName() + ", rank of " + warCard.getValue();  // update to remove rank
    }

    // This main method is for testing WarCard object
    // -> need to remove
//    public static void main(String[] args) {
//
//        WarCard card2 = new WarCard(2);
//        WarCard card51 = new WarCard(51);
//        
//
//        System.out.println(card2); // output: "CLUBS_4, rank of 4"
//        System.out.println(card51); // output: "SPADES_ACE, rank of 14"
//        System.out.println(card2.getValue()); // 4
//        System.out.println(card51.getValue()); // 14
//    }

}
