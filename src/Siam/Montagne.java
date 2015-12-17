package Siam;

import Siam.Enum.Camp;
import Siam.Enum.Theme;
import Siam.Interface.Ecran;
import Siam.Interface.Sprite;

public class Montagne extends Piece {

    public Montagne(int colonne, int ligne, Camp camp) {
        super(colonne, ligne, camp);

    }

    public void affichage(Ecran ecran, Theme theme) {
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
        switch (camp) {
            case ELEPHANT:
                switch (theme) {
                    case STANDARD:
                        ecran.affichageSprite(getAbscisse(), getOrdonnee(), Sprite.StandardCaseMontagneElephant, false, false);
                        break;
                    case NOEL:
                        ecran.affichageSprite(getAbscisse(), getOrdonnee(), Sprite.NoelCaseMontagneElephant, false, false);
                        break;
                    case STARWARS:
                        ecran.affichageSprite(getAbscisse(), getOrdonnee(), Sprite.StarWarsCaseMontagneElephant, false, false);
                        break;
                }
                break;
            case RHINOCEROS:
                switch (theme) {
                    case STANDARD:
                        ecran.affichageSprite(getAbscisse(), getOrdonnee(), Sprite.StandardCaseMontagneRhinoceros, false, false);
                        break;
                    case NOEL:
                        ecran.affichageSprite(getAbscisse(), getOrdonnee(), Sprite.NoelCaseMontagneRhinoceros, false, false);
                        break;
                    case STARWARS:
                        ecran.affichageSprite(getAbscisse(), getOrdonnee(), Sprite.StarWarsCaseMontagneRhinoceros, false, false);
                        break;
                }
                break;
            case NEUTRE:
                switch (theme) {
                    case STANDARD:
                        ecran.affichageSprite(getAbscisse(), getOrdonnee(), Sprite.StandardCaseMontagne, false, false);
                        break;
                    case NOEL:
                        ecran.affichageSprite(getAbscisse(), getOrdonnee(), Sprite.NoelCaseMontagne, false, false);
                        break;
                    case STARWARS:
                        ecran.affichageSprite(getAbscisse(), getOrdonnee(), Sprite.StarWarsCaseMontagne, false, false);
                        break;
                }
                break;
        }
    }

    public boolean estVide(){
        return false;
    }

    public Camp getCamp(){
        return camp;
    }
}