package Siam;

import Siam.Interface.Ecran;
import Siam.Interface.Sprite;

public class Animal extends Piece {

    private Orientation orientation;
    private Camp camp;

    public Animal() {
        this(0, 0, Orientation.HAUT, Camp.ELEPHANT);
    }

    public Animal(int abscisse, int ordonnee, Orientation orientation, Camp camp) {
        super(abscisse, ordonnee);
        this.orientation = orientation;
        this.camp = camp;
    }

    public Orientation getOrientation() {
        return orientation;
    }

    public void setOrientation(Orientation orientation) {
        this.orientation = orientation;
    }

    public void render(Ecran ecran) {
        if (camp == Camp.ELEPHANT) {
            if (orientation == Orientation.HAUT) ecran.renderSprite(getAbscisse(), getOrdonnee(), Sprite.casePionJoueur1, false, false);
            if (orientation == Orientation.BAS) ecran.renderSprite(getAbscisse(), getOrdonnee(), Sprite.casePionJoueur1, true, false);
            if (orientation == Orientation.GAUCHE) ecran.renderSprite(getAbscisse(), getOrdonnee(), Sprite.casePionJoueur1Gauche, false, false);
            if (orientation == Orientation.DROITE) ecran.renderSprite(getAbscisse(), getOrdonnee(), Sprite.casePionJoueur1Gauche, false, true);
        }
        if (camp == Camp.RHINOCEROS) {
            if (orientation == Orientation.HAUT) ecran.renderSprite(getAbscisse(), getOrdonnee(), Sprite.casePionJoueur2, false, false);
            if (orientation == Orientation.BAS) ecran.renderSprite(getAbscisse(), getOrdonnee(), Sprite.casePionJoueur2, true, false);
            if (orientation == Orientation.GAUCHE) ecran.renderSprite(getAbscisse(), getOrdonnee(), Sprite.casePionJoueur2Gauche, false, false);
            if (orientation == Orientation.DROITE) ecran.renderSprite(getAbscisse(), getOrdonnee(), Sprite.casePionJoueur2Gauche, false, true);
        }
    }
}
