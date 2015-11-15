package Siam;

import Siam.Interface.Ecran;
import Siam.Interface.Sprite;

public class Case implements Constantes{

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

    public void render(Ecran ecran){
        ecran.renderSprite(abscisse*128+BORDURE_FENETRE/2, ordonnee*128+BORDURE_FENETRE/2, Sprite.caseVide,false,false);
    }
}
