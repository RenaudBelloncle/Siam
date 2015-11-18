package Siam;

import Siam.Interface.Ecran;
import Siam.Interface.Sprite;

public class Montagne extends Piece {

    public Montagne() {
        super();
    }

    public void render(Ecran ecran) {
        ecran.renderSprite(getAbscisse(), getOrdonnee(), Sprite.caseMontagne, false, false);
    }
}
