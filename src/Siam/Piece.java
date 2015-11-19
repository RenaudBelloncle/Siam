package Siam;

import Siam.Interface.Ecran;

public abstract class Piece extends Case {

    public Piece() {
        this(0,0);
    }

    public Piece(int abscisse, int ordonnee) {
        super(abscisse, ordonnee);
    }

    public abstract void render(Ecran ecran);
}