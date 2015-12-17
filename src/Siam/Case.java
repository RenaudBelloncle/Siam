package Siam;

import Siam.Enum.Orientation;
import Siam.Enum.Theme;
import Siam.Enum.TraceType;
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
        if (theme == Theme.STANDARD) ecran.affichageSprite(abscisse, ordonnee, Sprite.StandardCaseVide,false,false);
        else if (theme == Theme.NOEL) ecran.affichageSprite(abscisse, ordonnee, Sprite.NoelCaseVide,false,false);
    }

    public boolean estVide(){
        return true;
    }

    public Trace creerTrace(TraceType traceType, Orientation direction)
    {
        return null;
    }

    public void sauvegarder(PrintStream ps){
        ps.println(abscisse);
        ps.println(ordonnee);
    }
}