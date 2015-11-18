package Siam;

import Siam.Interface.Ecran;

public abstract class Piece {

    private Case position;
    private int orientation;

    public Piece() {
        this(null,0);
    }

    public Piece(Case position, int orientation) {
        this.position = position;
        this.orientation = orientation;
    }

    public Case getPosition() {
        return position;
    }

    public void setPosition(Case position) {
        this.position = position;
    }

    public int getOrientation() {
        return orientation;
    }

    public void setOrientation(int orientation) {
        this.orientation = orientation;
    }

    public abstract void render(Ecran ecran);
}