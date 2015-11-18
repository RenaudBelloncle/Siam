package Siam.Interface;

public class Ecran {
    private int largeur, hauteur;
    private int[] pixels;

    public Ecran(int _largeur, int _hauteur){
        largeur = _largeur;
        hauteur = _hauteur;
        pixels = new int[largeur * hauteur];
    }

    public void clear(){
        for(int i =0; i < pixels.length; i++){
            pixels[i] = 0;
        }
    }

    public int getPixel(int index){
        return pixels[index];
    }

    public int getLargeur() {
        return largeur;
    }

    public int getHauteur() {
        return hauteur;
    }

    // Prend les coordonnees d'un sprite et place ses pixels dans le tableau de pixel
    public void renderSprite(int xp, int yp, Sprite sprite, boolean xflip, boolean yflip){
        xp -= 0;
        yp -= 0;

        for (int y = 0; y < sprite.getSize(); y++) {
            int ya = yp + y;
            int ys = y;
            if(yflip)ys = 127-y;
            for (int x = 0; x < sprite.getSize(); x++) {
                int xs = x;
                if (xflip) xs = 127-x;
                int xa = xp + x;
                if(xa < -sprite.getSize() || xa >= largeur || ya < 0 || ya >= hauteur) break;
                if(xa < 0) xa = 0;
                int col = sprite.getPixel(xs + ys * 128);
                if (col != 0xffff00ff) pixels[xa + ya * largeur] = col;
            }
        }
    }
}
