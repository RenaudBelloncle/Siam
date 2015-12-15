package Siam;

import Siam.Enum.Camp;
import Siam.Enum.Camp;
import Siam.Enum.Orientation;
import Siam.Enum.Theme;
import Siam.Enum.TraceType;
import Siam.Interface.Ecran;
import Siam.Interface.Sprite;

public class Montagne extends Piece {

    public Montagne(int colonne, int ligne, Camp camp) {
        super(colonne, ligne, camp);

    }

    public void affichage(Ecran ecran, Theme theme) {
        if (theme == Theme.STANDARD) {
            ecran.affichageSprite(getAbscisse(), getOrdonnee(), Sprite.StandardCaseVide,false,false);
            if (camp == Camp.ELEPHANT) ecran.affichageSprite(getAbscisse(), getOrdonnee(), Sprite.StandardCaseMontagneElephant, false, false);
            else if (camp == Camp.RHINOCEROS) ecran.affichageSprite(getAbscisse(), getOrdonnee(), Sprite.StandardCaseMontagneRhinoceros, false, false);
            else ecran.affichageSprite(getAbscisse(), getOrdonnee(), Sprite.StandardCaseMontagne, false, false);
        }
        else if (theme == Theme.NOEL) {
            ecran.affichageSprite(getAbscisse(), getOrdonnee(), Sprite.NoelCaseVide,false,false);
            if (camp == Camp.ELEPHANT) ecran.affichageSprite(getAbscisse(), getOrdonnee(), Sprite.NoelCaseMontagneElephant, false, false);
            else if (camp == Camp.RHINOCEROS) ecran.affichageSprite(getAbscisse(), getOrdonnee(), Sprite.NoelCaseMontagneRhinoceros, false, false);
            else ecran.affichageSprite(getAbscisse(), getOrdonnee(), Sprite.NoelCaseMontagne, false, false);
        }
    }

    public boolean estVide(){
        return false;
    }

    public Camp getCamp(){
        return Camp.MONTAGNE;
    }

    public Trace creerTrace(TraceType traceType, Orientation direction){
        return new Trace(getAbscisse(), getOrdonnee(), direction, Orientation.BAS, traceType, getCamp());
    }
}