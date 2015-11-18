package Siam;

import Siam.Interface.Ecran;
import Siam.Interface.Sprite;

public class Animal extends Piece {

    private int camp;

    public Animal() {
        super();
    }

    public Animal(int abscisse, int ordonnee, int orientation, int camp) {
        super(abscisse, ordonnee, orientation);
        this.camp = camp;
    }

    public void render(Ecran ecran) {
        if (camp == 0) ecran.renderSprite(getAbscisse(), getOrdonnee(), Sprite.casePionJoueur1, false, false);
        if (camp == 1) ecran.renderSprite(getAbscisse(), getOrdonnee(), Sprite.casePionJoueur2, false, false);
    }
}
