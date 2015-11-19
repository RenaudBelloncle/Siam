package Siam.Interface;

import Siam.Orientation;

public class Fleche {

    private int abscisse;
    private int ordonnne;
    private SpriteFleche sprite;
    private Orientation orientation;

    public Fleche(int abscisse, int ordonnne, SpriteFleche sprite, Orientation orientation) {
        this.abscisse = abscisse;
        this.ordonnne = ordonnne;
        this.sprite = sprite;
        this.orientation = orientation;
    }

    public void render(Ecran ecran) {
        if (orientation == Orientation.HAUT) ecran.renderFleche(abscisse, ordonnne, sprite, false, true);
        if (orientation == Orientation.BAS) ecran.renderFleche(abscisse, ordonnne, sprite, false, false);
        if (orientation == Orientation.GAUCHE) ecran.renderFleche(abscisse, ordonnne, sprite, true, false);
        if (orientation == Orientation.DROITE) ecran.renderFleche(abscisse, ordonnne, sprite, false, false);
    }
}
