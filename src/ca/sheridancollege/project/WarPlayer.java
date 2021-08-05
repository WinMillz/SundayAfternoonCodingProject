package ca.sheridancollege.project;

import java.util.Scanner;

/**
 * This class is a child class of Player.
 *
 * @author Jinyoung (Kayla) Jeon, Juyoung (Jenny) Jung
 */
public class WarPlayer extends Player {

    private GroupOfCards inHand;
    private GroupOfCards winList;
    private GroupOfCards activeDeck;
    
    public int roundCountP1;
    public int roundCountP2;

    public WarPlayer(String name) {
        super(name);
        inHand = new GroupOfCards();
        winList = new GroupOfCards();
        activeDeck = new GroupOfCards();
    }

    public GroupOfCards getInHand() {
        return inHand;
    }

    public void setInHand(GroupOfCards inHand) {
        this.inHand = inHand;
    }

    public GroupOfCards getWinList() {
        return winList;
    }

    public void setWinList(GroupOfCards winList) {
        this.winList = winList;
    }

    public GroupOfCards getActiveDeck() {
        return activeDeck;
    }

    public void setActiveDeck(GroupOfCards activeDeck) {
        this.activeDeck = activeDeck;
    }
    
    

    @Override
    public void play() {

        // deal a card 
        // take the first card in inHand, then put it in the activeDeck
        if (inHand.getSize() != 0) {
            activeDeck.getCards().add(inHand.getCards().remove(0));
        }

        System.out.print(getName() + " dealt " + activeDeck.getCards().get(0));
        System.out.println(" [rest of cards: " + inHand.getSize() + "]");

    }

    public void playWar() {

        if (inHand.getSize() > 3) {
            // to play War, player needs at least 4 cards inHand
            activeDeck.getCards().add(inHand.getCards().remove(0));
            activeDeck.getCards().add(inHand.getCards().remove(0));
            activeDeck.getCards().add(inHand.getCards().remove(0));
            activeDeck.getCards().add(inHand.getCards().remove(0));
        } else {
            // declare winner() method? 
        }
    }

    public void addWinList(WarPlayer playerWhoLost) {

        winList.getCards().addAll(activeDeck.getCards());
        winList.getCards().addAll(playerWhoLost.activeDeck.getCards());

    }

// when a player's hand is empty, invoke this method.
    public void incrementRoundWon(WarPlayer player1, WarPlayer player2) {
        if (player1.winList.getSize() > player2.winList.getSize()) {
            roundCountP1++;
            System.out.printf("%s: %d vs. %s: %d", player1.getName(), roundCountP1,
            player2.getName(), roundCountP2);
        } else if (player1.winList.getSize() < player2.winList.getSize()) {
            roundCountP2++;
            System.out.printf("%s: %d vs. %s: %d", player1.getName(), roundCountP1,
            player2.getName(), roundCountP2);
        } else {
            System.out.println("This round is tie.");
        }
    }

    // This main method is for testing WarPlayer object
    // -> NEED TO REMOVE
    public static void main(String[] args) {

        //WarCard.Deck[] deck = WarCard.Deck.values(); // using Deck enum
        GroupOfCards initDeck = new GroupOfCards();

        // initDeck contains all 52 card objects in Deck enum
        //for (int i = 0; i < deck.length; i++) {
       //     WarCard card = new WarCard(i);
        //    initDeck.getCards().add(card);
        //}

        // shuffle 52 cards
        initDeck.shuffle();
        System.out.println("------------------------------------");

        WarPlayer player1 = new WarPlayer("J");
        WarPlayer player2 = new WarPlayer("K");

        // assign random 26 cards to each player
        for (int i = 0; i < initDeck.getCards().size(); i += 2) {
            player1.inHand.getCards().add(initDeck.getCards().get(i));
            player2.inHand.getCards().add(initDeck.getCards().get(i + 1));
        }

        // testing : player 1's inhand 
        System.out.println("------------------------------------");
        System.out.println(player1.getName() + "'s card list. Total: "
                + player1.inHand.getSize());
        for (int i = 0; i < player1.inHand.getSize(); i++) {
            System.out.println(player1.inHand.getCards().get(i));
        }

        // testing : player 2's inhand 
        System.out.println("------------------------------------");
        System.out.println(player2.getName() + "'s card list. Total: "
                + player2.inHand.getSize());
        for (int i = 0; i < player2.inHand.getSize(); i++) {
            System.out.println(player2.inHand.getCards().get(i));
        }

        // deal a card
        player1.play();
        player2.play();

        WarCard topCard1 = player1.activeDeck.getCards().get(0);
        WarCard topCard2 = player2.activeDeck.getCards().get(0);

        // compare their cards
        if (topCard1.getValue() > topCard2.getValue()) { // if player1 wins,

            player1.addWinList(player2); // add all cards in activeDeck in player1's winList

        } else if (topCard1.getValue() < topCard2.getValue()) { // if player2 wins,

            player2.addWinList(player1); // add all cards in activeDeck in player2's winList

        } else if (topCard1.getValue() == topCard2.getValue()) {

            player1.playWar();  // if their values are the same,
            player2.playWar();  // play war

        }

        System.out.println("------------------------------");
        System.out.println(player1.getName() + "'s win list. Total: "
                + player1.winList.getSize());
        for (int i = 0; i < player1.winList.getSize(); i++) {
            System.out.println(player1.winList.getCards().get(i));
        }

        System.out.println(player2.getName() + "'s win list. Total: "
                + player2.winList.getSize());
        for (int i = 0; i < player2.winList.getSize(); i++) {
            System.out.println(player2.winList.getCards().get(i));
        }

    } // close test main method

}
