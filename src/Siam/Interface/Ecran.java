package Siam.Interface;

import Siam.Constantes;

public class Ecran implements Constantes {

    private int largeur, hauteur;
    private int[] pixels;

    public Ecran(int largeur, int hauteur){
        this.largeur = largeur;
        this.hauteur = hauteur;
        pixels = new int[largeur * hauteur];
    }

    public void clear(){
        for(int i =0; i < pixels.length; i++) pixels[i] = 0;
    }

    public int getPixel(int index){
        return pixels[index];
    }

    // Prend les coordonnees d'un sprite et place ses pixels dans le tableau de pixel
    public void renderSprite(int xp, int yp, Sprite sprite, boolean xflip, boolean yflip) {
        xp = xp * TAILLE_SPRITE + BORDURE_FENETRE/2;
        yp = yp * TAILLE_SPRITE + BORDURE_FENETRE/2;

        for (int y = 0; y < sprite.getHauteur(); y++) {
            int ya = yp + y;
            int ys = y;
            if(yflip)ys = TAILLE_SPRITE-1-y;
            for (int x = 0; x < sprite.getLargeur(); x++) {
                int xs = x;
                if (xflip) xs = TAILLE_SPRITE-1-x;
                int xa = xp + x;
                if(xa < -sprite.getLargeur() || xa >= largeur || ya < 0 || ya >= hauteur) break;
                if(xa < 0) xa = 0;
                int col = sprite.getPixel(xs + ys * TAILLE_SPRITE);
                if (col != 0xffff00ff) pixels[xa + ya * largeur] = col;
            }
        }
    }
}
