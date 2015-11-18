package Siam;

import Siam.Interface.Ecran;

public abstract class Piece extends Case {

    private int orientation;

    public Piece() {
        this(0,0,0);
    }

    public Piece(int abscisse, int ordonnee, int orientation) {
        super(abscisse, ordonnee);
        this.orientation = orientation;
    }

    public int getOrientation() {
        return orientation;
    }

    public void setOrientation(int orientation) {
        this.orientation = orientation;
    }

    public abstract void render(Ecran ecran);
}