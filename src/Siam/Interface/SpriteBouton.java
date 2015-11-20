package Siam.Interface;

import Siam.Constantes;
import com.sun.xml.internal.bind.v2.runtime.reflect.opt.Const;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class SpriteBouton implements Constantes{
    private String path;
    private int[] pixels;

    public static SpriteBouton boutonPoserPiece = new SpriteBouton("/images/spriteBasique/BoutonPoserPiece.png");
    public static SpriteBouton boutonDeplacerPiece = new SpriteBouton("/images/spriteBasique/BoutonDeplacerPiece.png");
    public static SpriteBouton boutonSortirPiece = new SpriteBouton("/images/spriteBasique/BoutonSortirPiece.png");
    public static SpriteBouton boutonChangerOrientation = new SpriteBouton("/images/spriteBasique/BoutonChangerOrientation.png");
    public static SpriteBouton boutonPoserPieceSelec = new SpriteBouton("/images/spriteBasique/BoutonPoserPieceSelec.png");
    public static SpriteBouton boutonDeplacerPieceSelec = new SpriteBouton("/images/spriteBasique/BoutonDeplacerPieceSelec.png");
    public static SpriteBouton boutonSortirPieceSelec = new SpriteBouton("/images/spriteBasique/BoutonSortirPieceSelec.png");
    public static SpriteBouton boutonChangerOrientationSelec = new SpriteBouton("/images/spriteBasique/BoutonChangerOrientationSelec.png");

    public SpriteBouton(String path){
        pixels = new int[HAUTEUR_BOUTON * LARGEUR_BOUTON];
        this.path = path;
        load();
    }

    public int getHauteur(){
        return HAUTEUR_BOUTON;
    }

    public int getLargeur() {
        return LARGEUR_BOUTON;
    }

    public int getPixel(int index){
        return pixels[index];
    }

    private void setColour(int colour) {
        for(int i = 0; i < HAUTEUR_BOUTON * LARGEUR_BOUTON; i++){
            pixels[i] = colour;
        }
    }

    // Charge un sprite a partir d'une image
    private void load(){
        try {
            BufferedImage image = ImageIO.read(Sprite.class.getResource(path));
            int w = image.getWidth();
            int h = image.getHeight();
            image.getRGB(0, 0, w, h, pixels, 0, w);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

