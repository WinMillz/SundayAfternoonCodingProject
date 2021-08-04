package ca.sheridancollege.project;

/**
 * This class holds the deck of cards that we will be used in the game.
 * 
 * @author Jinyoung Jeon August 2021
 * @author Juyoung Jung August 2021
 * @author Tamara Dang August 2021
 * @author Winston Martinez August 2021
 */
enum Deck {
    
    CLUBS_2(2, "Two of Clubs"), // index of 0
    CLUBS_3(3, "Three of Clubs"),
    CLUBS_4(4, "Four of Clubs"),
    CLUBS_5(5, "Five of Clubs"),
    CLUBS_6(6, "Six of Clubs"),
    CLUBS_7(7, "Seven of Clubs"),
    CLUBS_8(8, "Eight of Clubs"),
    CLUBS_9(9, "Nine of Clubs"),
    CLUBS_10(10, "Ten of Clubs"),
    CLUBS_JACK(11, "Jack of Clubs"),
    CLUBS_QUEEN(12, "Queen of Clubs"),
    CLUBS_KING(13, "King of Clubs"),
    CLUBS_ACE(14, "Ace of Clubs"),
    DIAMONDS_2(2, "Two of Diamonds"),
    DIAMONDS_3(3, "Three of Diamonds"),
    DIAMONDS_4(4, "Four of Diamonds"),
    DIAMONDS_5(5, "Five of Diamonds"),
    DIAMONDS_6(6, "Six of Diamonds"),
    DIAMONDS_7(7, "Seven of Diamonds"),
    DIAMONDS_8(8, "Eight of Diamonds"),
    DIAMONDS_9(9, "Nine of Diamonds"),
    DIAMONDS_10(10, "Ten of Diamonds"),
    DIAMONDS_JACK(11, "Jack of Diamonds"),
    DIAMONDS_QUEEN(12, "Queen of Diamonds"),
    DIAMONDS_KING(13, "King of Diamonds"),
    DIAMONDS_ACE(14, "Ace of Diamonds"),
    HEARTS_2(2, "Two of Hearts"),
    HEARTS_3(3, "Three of Hearts"),
    HEARTS_4(4, "Four of Hearts"),
    HEARTS_5(5, "Five of Hearts"),
    HEARTS_6(6, "Six of Hearts"),
    HEARTS_7(7, "Seven of Hearts"),
    HEARTS_8(8, "Eight of Hearts"),
    HEARTS_9(9, "Nine of Hearts"),
    HEARTS_10(10, "Ten of Hearts"),
    HEARTS_JACK(11, "Jack of Hearts"),
    HEARTS_QUEEN(12, "Queen of Hearts"),
    HEARTS_KING(13, "King of Hearts"),
    HEARTS_ACE(14, "Ace of Hearts"),
    SPADES_2(2, "Two of Spades"),
    SPADES_3(3, "Three of Spades"),
    SPADES_4(4, "Four of Spades"),
    SPADES_5(5, "Five of Spades"),
    SPADES_6(6, "Six of Spades"),
    SPADES_7(7, "Seven of Spades"),
    SPADES_8(8, "Eight of Spades"),
    SPADES_9(9, "Nine of Spades"),
    SPADES_10(10, "Ten of Spades"),
    SPADES_JACK(11, "Jack of Spades"),
    SPADES_QUEEN(12, "Queen of Spades"),
    SPADES_KING(13, "King of Spades"),
    SPADES_ACE(14, "Ace of Spades");  // index of 51

    private final int value;
    private final String name;

    private Deck(int value, String name) {
        this.value = value;
        this.name = name;
    }

    /**
     * This method returns the numeric value of the card.
     * 
     * @return 
     */
    public int getValue() {
        return value;
    }

    /**
     * This method returns the full name of the card.
     * 
     * @return 
     */
    public String getName() {
        return name;
    }

}
