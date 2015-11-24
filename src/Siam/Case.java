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

    public Case(Case caseModel){
        this.ordonnee = caseModel.ordonnee;
        this.abscisse = caseModel.abscisse;
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
        ecran.renderSprite(abscisse, ordonnee, Sprite.caseVide,false,false);
    }

    public boolean estVide(){
        return true;
    }
}
