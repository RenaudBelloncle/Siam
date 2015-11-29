package Siam;

import Siam.Enum.Theme;
import Siam.Interface.Ecran;
import Siam.Interface.Sprite;

public class Montagne extends Piece {

    public Montagne(int colonne, int ligne) {
        super(colonne, ligne);
    }

    public void affichage(Ecran ecran, Theme theme) {
        if (theme == Theme.STANDARD) ecran.affichageSprite(getAbscisse(), getOrdonnee(), Sprite.StandardCaseVide,false,false);
        else if (theme == Theme.NOEL) ecran.affichageSprite(getAbscisse(), getOrdonnee(), Sprite.NoelCaseVide,false,false);
        if (theme == Theme.STANDARD)  ecran.affichageSprite(getAbscisse(), getOrdonnee(), Sprite.StandardCaseMontagne, false, false);
        else if (theme == Theme.NOEL)  ecran.affichageSprite(getAbscisse(), getOrdonnee(), Sprite.NoelCaseMontagne, false, false);
    }

    public boolean estVide(){
        return false;
    }
}