package ca.sheridancollege.project;


import java.util.ArrayList;

/**
 *
 * @author Juyoung Jung
 */
public class WarCard extends Card {
    
    public enum Value {
        TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, 
        QUEEN, KING, ACE
    }
    
    public enum Suit {
        CLUBS, DIAMONDS, HEARTS, SPADES
    }
    
    private Value value;
    private Suit suit;
    
    public WarCard(Value value, Suit suit) {
        this.value = value;
        this.suit = suit;
    }
    
    public Value getValue() {
        return this.value;
    }
    
    public Suit getSuit() {
        return this.suit;
    }
    
    public int getValueOfRank() {
        return value.ordinal() + 2; 
            // each value's rank will be index + 2
            // for example, index 0 (TWO) will have rank of 2, 
            // index 12 (ACE) will have rank of 14
    }
    
    @Override
    public String toString() {
        return value + " of " + suit;
       
    }
    
    // This main method is for testing WarCard object
    // -> need to remove
    public static void main(String[] args) {
        
        Value[] cardValues = Value.values();
        Suit[] cardSuits = Suit.values();
        
        WarCard sample = new WarCard(cardValues[0], cardSuits[0]);
        
        System.out.println(sample); // output: "TWO of CLUBS"
    }
    

}
