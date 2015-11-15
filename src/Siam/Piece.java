package Siam;

import Siam.Interface.Ecran;

public abstract class Piece {

    private Case position;
    private int orientation;

    public Piece(Case position, int orientation) {
        this.position = position;
        this.orientation = orientation;
    }

    public int[] getPosition() {
        return new int[]{position.getAbscisse(), position.getOrdonnee()};
    }

    public void setPosition(int abscisse, int ordonnee) {
        position.setAbscisse(abscisse);
        position.setOrdonnee(ordonnee);
    }

    public int getOrientation() {
        return orientation;
    }

    public void setOrientation(int orientation) {
        this.orientation = orientation;
    }

    public abstract void render(Ecran ecran);
}