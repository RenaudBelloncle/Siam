package Siam.Interface;

public class Bouton {

    private int abscisse;
    private int ordonnne;
    private SpriteBouton sprite;

    public Bouton(int abscisse, int ordonnne, SpriteBouton sprite) {
        this.abscisse = abscisse;
        this.ordonnne = ordonnne;
        this.sprite = sprite;
    }

    public void render(Ecran ecran) {
        ecran.renderBouton(abscisse, ordonnne, sprite);
    }
}
