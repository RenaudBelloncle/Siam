package Siam;

import Siam.Enum.Theme;
import Siam.Interface.Ecran;
import Siam.Interface.Sprite;

import java.io.PrintStream;

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

    public void affichage(Ecran ecran, Theme theme){
        switch (theme) {
            case STANDARD:
                ecran.affichageSprite(getAbscisse(), getOrdonnee(), Sprite.StandardCaseVide,false,false);
                break;
            case NOEL:
                ecran.affichageSprite(getAbscisse(), getOrdonnee(), Sprite.NoelCaseVide,false,false);
                break;
            case STARWARS:
                ecran.affichageSprite(getAbscisse(), getOrdonnee(), Sprite.StarWarsCaseVide,false,false);
                break;
        }
    }

    public boolean estVide(){
        return true;
    }

    public void sauvegarder(PrintStream ps){
        ps.println(abscisse);
        ps.println(ordonnee);
    }
}