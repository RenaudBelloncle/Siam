package siam.player;

import siam.level.Orientation;

public class Player {

    protected Camp camp;
    protected String name;
    protected int pieceOnBoard;
    protected int pieceOut;

    public Player() {
        this(Camp.NEUTRAL, "");
    }

    public Player(Camp camp, String name) {
        pieceOnBoard = 0;
        pieceOut = 0;
        this.camp = camp;
        this.name = name;
    }

    public Camp getCamp() {
        return camp;
    }

    public String getName() {
        return name;
    }

    public void put() {
        pieceOnBoard++;
    }

    public void bringOut() {
        pieceOnBoard--;
        pieceOut++;
    }

    public void move(int x, int y, Orientation orientation, Camp camp) {

    }

    public void orient(int x, int y, Orientation orientation, Camp camp) {

    }

    public boolean canPut(){
        return pieceOnBoard < 5;
    }

    public boolean canBringOut() {
        return pieceOut < 1;
    }

    public int getPieceOnBoard(){
        return pieceOnBoard;
    }
}
