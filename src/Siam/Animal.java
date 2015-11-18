package Siam;

import Siam.Interface.Ecran;
import Siam.Interface.Sprite;

public class Animal extends Piece {

    private int orientation;
    private int camp;

    public Animal() {
        this(0, 0, 0, 0);
    }

    public Animal(int abscisse, int ordonnee, int orientation, int camp) {
        super(abscisse, ordonnee);
        this.orientation = orientation;
        this.camp = camp;
    }

    public int getOrientation() {
        return orientation;
    }

    public void setOrientation(int orientation) {
        this.orientation = orientation;
    }

    public void render(Ecran ecran) {
        if (camp == 0) ecran.renderSprite(getAbscisse(), getOrdonnee(), Sprite.casePionJoueur1, false, false);
        if (camp == 1) ecran.renderSprite(getAbscisse(), getOrdonnee(), Sprite.casePionJoueur2, false, false);
    }
}
