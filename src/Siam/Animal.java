package Siam;

import Siam.Enum.Camp;
import Siam.Enum.Orientation;
import Siam.Enum.Theme;
import Siam.Interface.Ecran;
import Siam.Interface.Sprite;

public class Animal extends Piece {

    private Orientation orientation;
    private Camp camp;
    private boolean selectionnee;

    public Animal(int abscisse, int ordonnee, Orientation orientation, Camp camp, boolean selectionnee) {
        super(abscisse, ordonnee);
        this.orientation = orientation;
        this.camp = camp;
        this.selectionnee = selectionnee;
    }

    public Orientation getOrientation() {
        return orientation;
    }

    public void setOrientation(Orientation orientation) {
        this.orientation = orientation;
    }

    public boolean estSelectionnee() {
        return selectionnee;
    }

    public void setSelectionnee(boolean selectionnee) {
        this.selectionnee = selectionnee;
    }

    public Camp getCamp() {
        return camp;
    }

    public void setCamp(Camp camp) {
        this.camp = camp;
    }

    public void affichage(Ecran ecran, Theme theme) {
        if (theme == Theme.STANDARD) ecran.affichageSprite(getAbscisse(), getOrdonnee(), Sprite.StandardCaseVide,false,false);
        else if (theme == Theme.NOEL) ecran.affichageSprite(getAbscisse(), getOrdonnee(), Sprite.NoelCaseVide,false,false);
        if (camp == Camp.ELEPHANT)
        {
            if (orientation == Orientation.HAUT) {
                if (theme == Theme.STANDARD) ecran.affichageSprite(getAbscisse(), getOrdonnee(), Sprite.StandardCasePionJoueur1, false, false);
                else if (theme == Theme.NOEL) ecran.affichageSprite(getAbscisse(), getOrdonnee(), Sprite.NoelCasePionJoueur1, false, false);
            }
            if (orientation == Orientation.BAS) {
                if (theme == Theme.STANDARD) ecran.affichageSprite(getAbscisse(), getOrdonnee(), Sprite.StandardCasePionJoueur1, false, true);
                else if (theme == Theme.NOEL) ecran.affichageSprite(getAbscisse(), getOrdonnee(), Sprite.NoelCasePionJoueur1, false, true);
            }
            if (orientation == Orientation.GAUCHE) {
                if (theme == Theme.STANDARD) ecran.affichageSprite(getAbscisse(), getOrdonnee(), Sprite.StandardCasePionJoueur1Gauche, false, false);
                else if (theme == Theme.NOEL) ecran.affichageSprite(getAbscisse(), getOrdonnee(), Sprite.NoelCasePionJoueur1Gauche, false, false);
            }
            if (orientation == Orientation.DROITE) {
                if (theme == Theme.STANDARD) ecran.affichageSprite(getAbscisse(), getOrdonnee(), Sprite.StandardCasePionJoueur1Gauche, true, false);
                else if (theme == Theme.NOEL) ecran.affichageSprite(getAbscisse(), getOrdonnee(), Sprite.NoelCasePionJoueur1Gauche, true, false);
            }
        }
        if (camp == Camp.RHINOCEROS)
        {
            if (orientation == Orientation.HAUT) {
                if (theme == Theme.STANDARD) ecran.affichageSprite(getAbscisse(), getOrdonnee(), Sprite.StandardCasePionJoueur2, false, false);
                else if (theme == Theme.NOEL) ecran.affichageSprite(getAbscisse(), getOrdonnee(), Sprite.NoelCasePionJoueur2, false, false);
            }
            if (orientation == Orientation.BAS) {
                if (theme == Theme.STANDARD) ecran.affichageSprite(getAbscisse(), getOrdonnee(), Sprite.StandardCasePionJoueur2, false, true);
                else if (theme == Theme.NOEL) ecran.affichageSprite(getAbscisse(), getOrdonnee(), Sprite.NoelCasePionJoueur2, false, true);
            }
            if (orientation == Orientation.GAUCHE) {
                if (theme == Theme.STANDARD) ecran.affichageSprite(getAbscisse(), getOrdonnee(), Sprite.StandardCasePionJoueur2Gauche, false, false);
                else if (theme == Theme.NOEL) ecran.affichageSprite(getAbscisse(), getOrdonnee(), Sprite.NoelCasePionJoueur2Gauche, false, false);
            }
            if (orientation == Orientation.DROITE) {
                if (theme == Theme.STANDARD) ecran.affichageSprite(getAbscisse(), getOrdonnee(), Sprite.StandardCasePionJoueur2Gauche, true, false);
                else if (theme == Theme.NOEL) ecran.affichageSprite(getAbscisse(), getOrdonnee(), Sprite.NoelCasePionJoueur2Gauche, true, false);
            }
        }
        if (selectionnee) {
            if (theme == Theme.STANDARD) ecran.affichageSprite(getAbscisse(), getOrdonnee(), Sprite.StandardFocus, false, false);
            else if (theme == Theme.NOEL) ecran.affichageSprite(getAbscisse(), getOrdonnee(), Sprite.NoelFocus, false, false);
        }
    }

    public boolean estVide() {
        return false;
    }
}