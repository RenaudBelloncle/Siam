package Siam;

import Siam.Interface.Ecran;

public abstract class Piece extends Case {

    public Piece(int abscisse, int ordonnee) {
        super(abscisse, ordonnee);
    }

    public abstract void affichage(Ecran ecran);

    public boolean estVide(){
        return false;
    }
}