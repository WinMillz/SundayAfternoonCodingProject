package ca.sheridancollege.project;

/**
 * This class is a child class of Player.
 *
 * @author Jinyoung (Kayla) Jeon
 */
public class WarPlayer extends Player {

    private GroupOfCards hand;

    private GroupOfCards winList;

    public WarPlayer(String name) {
        super(name);
    }

    @Override
    public void play() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void incrementRoundWon() {

    }

}
