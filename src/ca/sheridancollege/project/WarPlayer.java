package ca.sheridancollege.project;

/**
 * This class models a WarPlayer with inHand, winList, and activeDeck arrayList
 * (GroupOfCards). This class is a child class of Player.
 *
 * @author Jinyoung (Kayla) Jeon August 2021
 * @author Juyoung (Jenny) Jung August 2021
 * @author Tamara Dang August 2021
 * @author Winston Martinez August 2021
 */
public class WarPlayer extends Player {

    private GroupOfCards inHand;
    private GroupOfCards winList;
    private GroupOfCards activeDeck;
    public int roundWinCount;
    private boolean forfeit = false;

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

    public int getRoundWinCount() {
        return roundWinCount;
    }

    public void setRoundWinCount(int roundCount) {
        this.roundWinCount = roundCount;
    }

    public boolean isForfeit() {
        return forfeit;
    }

    public void setForfeit(boolean forfeit) {
        this.forfeit = forfeit;
    }

    @Override
    public void play() {

        // deal a card 
        // take the first card in inHand, then put it in the activeDeck
        if (inHand.getSize() != 0) {
            activeDeck.getCards().add(inHand.getCards().remove(0));
        }

        System.out.print(getName() + " dealt " + activeDeck.getCards().get(0));
        System.out.println(" [cards remaining: " + inHand.getSize() + "]");

    }

    /**
     * This method plays 4 cards from the player's inHand list. If there are
     * less than 4 cards, all cards from the player's inHand list are added to
     * their activeDeck. If there are no cards in the player's inHand list, all
     * cards in the player's activeDeck are added to their winList.
     */
    public void playWar() {

        if (inHand.getSize() > 0) {
            if (inHand.getSize() > 3) {
                // to play War, player needs at least 4 cards inHand
                for (int i = 0; i < 4; i++) {
                    activeDeck.getCards().add(inHand.getCards().remove(0));
                }
            } else {
                // If inHand is < 4, add all remaining cards to activeDeck
                while (inHand.getSize() > 0) {
                    activeDeck.getCards().add(inHand.getCards().remove(0));
                }
            } 
            System.out.print(getName() + " dealt " + 
                    activeDeck.getCards().get(activeDeck.getSize()-1));
        } else {
            // If inHand is 0, add activeDeck to winList
            while (activeDeck.getSize() > 0) {
                winList.getCards().add(activeDeck.getCards().remove(0));
            }
        }

        System.out.println(" [cards remaining: " + inHand.getSize() + "]");
    }

    /**
     * This method takes WarPlayer who are lost, and then moves all cards in
     * both player's activeDeck to its winList.
     *
     * @param playerWhoLost
     */
    public void addWinList(WarPlayer playerWhoLost) {

        winList.getCards().addAll(activeDeck.getCards());
        winList.getCards().addAll(playerWhoLost.activeDeck.getCards());

    }

}
