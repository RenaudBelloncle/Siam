package Siam;

import Siam.Interface.Ecran;
import Siam.Interface.Sprite;

public class Case {

    private int abscisse;
    private int ordonnee;

    public Case(int abscisse, int ordonnee) {
        this.abscisse = abscisse;
        this.ordonnee = ordonnee;
    }

    public int getAbscisse() {
        return abscisse;
    }

    public void setAbscisse(int abscisse) {
        this.abscisse = abscisse;
    }

    public int getOrdonnee() {
        return ordonnee;
    }

    public void setOrdonnee(int ordonnee) {
        this.ordonnee = ordonnee;
    }

    public void affichage(Ecran ecran){
        ecran.affichageSprite(abscisse, ordonnee, Sprite.caseVide,false,false);
    }

    public boolean estVide(){
        return true;
    }
}