package Siam.Interface;

import Siam.Constantes;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class SpriteFleche implements Constantes {
    private String path;
    private int[] pixels;

    public static SpriteFleche flecheBas = new SpriteFleche("/images/spriteBasique/Bas.png");
    public static SpriteFleche flecheBasSelec = new SpriteFleche("/images/spriteBasique/BasSelec.png");
    public static SpriteFleche flecheDroite = new SpriteFleche("/images/spriteBasique/Droite.png");
    public static SpriteFleche flecheDroiteSelec = new SpriteFleche("/images/spriteBasique/DroiteSelec.png");

    public static SpriteFleche elephant = new SpriteFleche("/images/spriteBasique/Elephant.png");
    public static SpriteFleche rhinoceros = new SpriteFleche("/images/spriteBasique/Rhinoceros.png");

    public SpriteFleche(String path){
        pixels = new int[TAILLE_SPRITE_FLECHE * TAILLE_SPRITE_FLECHE];
        this.path = path;
        load();
    }

    public int getSize(){
        return TAILLE_SPRITE_FLECHE;
    }

    public int getPixel(int index){
        return pixels[index];
    }

    private void setColour(int colour) {
        for(int i = 0; i < TAILLE_SPRITE_FLECHE * TAILLE_SPRITE_FLECHE; i++){
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
