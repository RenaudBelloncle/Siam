package Siam;

import Siam.Interface.Ecran;
import Siam.Interface.Sprite;

public class Animal extends Piece {

    private int camp;

    public Animal() {
        super();
    }

    public Animal(Case position, int orientation, int camp) {
        super(position,orientation);
        this.camp = camp;
    }

    public void render(Ecran ecran) {
        if (camp == 0) ecran.renderSprite(getPosition().getAbscisse(), getPosition().getOrdonnee(), Sprite.casePionJoueur1, false, false);
        if (camp == 1) ecran.renderSprite(getPosition().getAbscisse(), getPosition().getOrdonnee(), Sprite.casePionJoueur2, false, false);
    }
}
