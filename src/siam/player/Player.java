package siam.player;

import siam.level.Orientation;

public class Player {

    protected Camp camp;
    protected String name;
    protected int pieceOnBoard = 5;

    public Player() {
        this(Camp.NEUTRAL, "");
    }

    public Player(Camp camp, String name) {
        this.camp = camp;
        this.name = name;
    }

    public Camp getCamp() {
        return camp;
    }

    public String getName() {
        return name;
    }

    public void put(int x, int y, Orientation orientation, Camp camp) {

    }

    public void bringOut(int x, int y, Camp camp) {

    }

    public void move(int x, int y, Orientation orientation, Camp camp) {

    }

    public void orient(int x, int y, Orientation orientation, Camp camp) {

    }
}
