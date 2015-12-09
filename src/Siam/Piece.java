package Siam;

import Siam.Enum.Orientation;
import Siam.Enum.Theme;
import Siam.Enum.TraceType;
import Siam.Interface.Ecran;

public abstract class Piece extends Case {

    private Case lastPosition;

    public Piece(int abscisse, int ordonnee)
    {

        super(abscisse, ordonnee);
        lastPosition = null;
    }

    public abstract void affichage(Ecran ecran, Theme theme);

    public boolean estVide(){
        return false;
    }

    public void setLastPosition(Case lastPosition) {
        this.lastPosition = lastPosition;
    }

    public Case getLastPosition() {
        return lastPosition;
    }
}