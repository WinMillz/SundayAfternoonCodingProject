package ca.sheridancollege.project;


import java.util.ArrayList;

/**
 *
 * @author Juyoung Jung
 */
public class WarCard extends Card {
    
    enum Deck {
        
        CLUBS_2(2), // index of 0
        CLUBS_3(3),
        CLUBS_4(4),
        CLUBS_5(5),
        CLUBS_6(6),
        CLUBS_7(7),
        CLUBS_8(8),
        CLUBS_9(9),
        CLUBS_10(10),
        CLUBS_JACK(11),
        CLUBS_QUEEN(12),
        CLUBS_KING(13),
        CLUBS_ACE(14),
        DIAMONDS_2(2),
        DIAMONDS_3(3),
        DIAMONDS_4(4),
        DIAMONDS_5(5),
        DIAMONDS_6(6),
        DIAMONDS_7(7),
        DIAMONDS_8(8),
        DIAMONDS_9(9),
        DIAMONDS_10(10),
        DIAMONDS_JACK(11),
        DIAMONDS_QUEEN(12),
        DIAMONDS_KING(13),
        DIAMONDS_ACE(14),
        HEARTS_2(2),
        HEARTS_3(3),
        HEARTS_4(4),
        HEARTS_5(5),
        HEARTS_6(6),
        HEARTS_7(7),
        HEARTS_8(8),
        HEARTS_9(9),
        HEARTS_10(10),
        HEARTS_JACK(11),
        HEARTS_QUEEN(12),
        HEARTS_KING(13),
        HEARTS_ACE(14),
        SPADES_2(2),
        SPADES_3(3),
        SPADES_4(4),
        SPADES_5(5),
        SPADES_6(6),
        SPADES_7(7),
        SPADES_8(8),
        SPADES_9(9),
        SPADES_10(10),
        SPADES_JACK(11),
        SPADES_QUEEN(12),
        SPADES_KING(13),
        SPADES_ACE(14);  // index of 51
        
        private int value;
        
        private int getValue() {
            return value;
        }
        
        private Deck(int value) {
            this.value = value;
        }
        
        
    }
    
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
     * Retrieves the rank of each card. 
     * For example, SPADES_ACE returns 14, CLUBS_4 returns 4.
     * 
     * @return the rank of each card
     */
    public int getValue() {
        return this.warCard.getValue();
    }

    @Override
    public String toString() {
        return warCard.name();
    }

}
