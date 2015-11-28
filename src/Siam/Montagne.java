package Siam;

import Siam.Interface.Ecran;
import Siam.Interface.Sprite;

public class Montagne extends Piece {

    public Montagne(int colonne, int ligne) {
        super(colonne, ligne);
    }

    public void affichage(Ecran ecran) {
        ecran.affichageSprite(getAbscisse(), getOrdonnee(), Sprite.caseVide, false, false);
        ecran.affichageSprite(getAbscisse(), getOrdonnee(), Sprite.caseMontagne, false, false);
    }

    public boolean estVide(){
        return false;
    }
}