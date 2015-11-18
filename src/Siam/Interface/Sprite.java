package Siam.Interface;

import Siam.Constantes;
import com.sun.xml.internal.bind.v2.runtime.reflect.opt.Const;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Sprite implements Constantes{
    private String path;
    private int[] pixels;

    public static Sprite caseVide = new Sprite("/images/spriteBasique/case.png");
    public static Sprite casePionJoueur1 = new Sprite("/images/spriteBasique/pionBlanc.png");
    public static Sprite casePionJoueur2 = new Sprite("/images/spriteBasique/pionNoir.png");
    public static Sprite caseMontagne = new Sprite("/images/spriteBasique/montagne.png");

    public Sprite(String _path){
        pixels = new int[TAILLE_SPRITE * TAILLE_SPRITE];
        path = _path;
        load();
    }

    public int getSize(){
        return TAILLE_SPRITE;
    }

    public int getPixel(int index){
        return pixels[index];
    }

    private void setColour(int colour) {
        for(int i = 0; i < TAILLE_SPRITE * TAILLE_SPRITE; i++){
            pixels[i] = colour;
        }
    }

    // Charge un sprite � partir d'une image
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

