package Siam;

import Siam.Interface.Ecran;
import Siam.Interface.Sprite;

public class Animal extends Piece {

    private Orientation orientation;
    private Camp camp;
    private boolean selected;

    public Animal() {
        this(0, 0, Orientation.HAUT, Camp.ELEPHANT, false);
    }

    public Animal(int abscisse, int ordonnee, Orientation orientation, Camp camp, boolean selected) {
        super(abscisse, ordonnee);
        this.orientation = orientation;
        this.camp = camp;
        this.selected = selected;
    }

    public Orientation getOrientation() {
        return orientation;
    }

    public void setOrientation(Orientation orientation) {
        this.orientation = orientation;
    }

    public void render(Ecran ecran) {
        if (camp == Camp.ELEPHANT) {
            if (selected) {
                if (orientation == Orientation.HAUT) ecran.renderSprite(getAbscisse(), getOrdonnee(), Sprite.casePionJoueur1Selec, false, false);
                if (orientation == Orientation.BAS) ecran.renderSprite(getAbscisse(), getOrdonnee(), Sprite.casePionJoueur1Selec, true, false);
                if (orientation == Orientation.GAUCHE) ecran.renderSprite(getAbscisse(), getOrdonnee(), Sprite.casePionJoueur1GaucheSelec, false, false);
                if (orientation == Orientation.DROITE) ecran.renderSprite(getAbscisse(), getOrdonnee(), Sprite.casePionJoueur1GaucheSelec, false, true);
            } else {
                if (orientation == Orientation.HAUT) ecran.renderSprite(getAbscisse(), getOrdonnee(), Sprite.casePionJoueur1, false, false);
                if (orientation == Orientation.BAS) ecran.renderSprite(getAbscisse(), getOrdonnee(), Sprite.casePionJoueur1, true, false);
                if (orientation == Orientation.GAUCHE) ecran.renderSprite(getAbscisse(), getOrdonnee(), Sprite.casePionJoueur1Gauche, false, false);
                if (orientation == Orientation.DROITE) ecran.renderSprite(getAbscisse(), getOrdonnee(), Sprite.casePionJoueur1Gauche, false, true);
            }
        }
        if (camp == Camp.RHINOCEROS) {
            if (selected) {
                if (orientation == Orientation.HAUT) ecran.renderSprite(getAbscisse(), getOrdonnee(), Sprite.casePionJoueur2Selec, false, false);
                if (orientation == Orientation.BAS) ecran.renderSprite(getAbscisse(), getOrdonnee(), Sprite.casePionJoueur2Selec, true, false);
                if (orientation == Orientation.GAUCHE) ecran.renderSprite(getAbscisse(), getOrdonnee(), Sprite.casePionJoueur2GaucheSelec, false, false);
                if (orientation == Orientation.DROITE) ecran.renderSprite(getAbscisse(), getOrdonnee(), Sprite.casePionJoueur2GaucheSelec, false, true);
            } else {
                if (orientation == Orientation.HAUT) ecran.renderSprite(getAbscisse(), getOrdonnee(), Sprite.casePionJoueur2, false, false);
                if (orientation == Orientation.BAS) ecran.renderSprite(getAbscisse(), getOrdonnee(), Sprite.casePionJoueur2, true, false);
                if (orientation == Orientation.GAUCHE) ecran.renderSprite(getAbscisse(), getOrdonnee(), Sprite.casePionJoueur2Gauche, false, false);
                if (orientation == Orientation.DROITE) ecran.renderSprite(getAbscisse(), getOrdonnee(), Sprite.casePionJoueur2Gauche, false, true);
            }
        }
    }
}