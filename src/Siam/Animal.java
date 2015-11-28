package Siam;

import Siam.Enum.Camp;
import Siam.Enum.Orientation;
import Siam.Interface.Ecran;
import Siam.Interface.Sprite;

public class Animal extends Piece {

    private Orientation orientation;
    private Camp camp;
    private boolean selectionnee;

    public Animal() {
        this(0, 0, Orientation.HAUT, Camp.ELEPHANT, false);
    }

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

    public void render(Ecran ecran) {
        if (camp == Camp.ELEPHANT)
        {
            if (orientation == Orientation.HAUT) ecran.renderSprite(getAbscisse(), getOrdonnee(), Sprite.casePionJoueur1, false, false);
            if (orientation == Orientation.BAS) ecran.renderSprite(getAbscisse(), getOrdonnee(), Sprite.casePionJoueur1, false, true);
            if (orientation == Orientation.GAUCHE) ecran.renderSprite(getAbscisse(), getOrdonnee(), Sprite.casePionJoueur1Gauche, false, false);
            if (orientation == Orientation.DROITE) ecran.renderSprite(getAbscisse(), getOrdonnee(), Sprite.casePionJoueur1Gauche, true, false);
            if (selectionnee) ecran.renderSprite(getAbscisse(), getOrdonnee(), Sprite.focus, false, false);
        }
        if (camp == Camp.RHINOCEROS)
        {
            if (orientation == Orientation.HAUT) ecran.renderSprite(getAbscisse(), getOrdonnee(), Sprite.casePionJoueur2, false, false);
            if (orientation == Orientation.BAS) ecran.renderSprite(getAbscisse(), getOrdonnee(), Sprite.casePionJoueur2, false, true);
            if (orientation == Orientation.GAUCHE) ecran.renderSprite(getAbscisse(), getOrdonnee(), Sprite.casePionJoueur2Gauche, false, false);
            if (orientation == Orientation.DROITE) ecran.renderSprite(getAbscisse(), getOrdonnee(), Sprite.casePionJoueur2Gauche, true, false);
            if (selectionnee) ecran.renderSprite(getAbscisse(), getOrdonnee(), Sprite.focus, false, false);
        }
    }

    public boolean estVide() {
        return false;
    }
}