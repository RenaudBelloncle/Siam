package Siam.Interface;

import Siam.Constantes;
import Siam.Enum.Theme;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Sprite implements Constantes{

    private int[] pixels;
    private int largeur;
    private int hauteur;

    public static Sprite caseVide = new Sprite(ImageLibrairie.imageLibrairie.getImage(Theme.STANDARD,"Case"),TAILLE_SPRITE,TAILLE_SPRITE);
    public static Sprite casePionJoueur1 = new Sprite(ImageLibrairie.imageLibrairie.getImage(Theme.STANDARD,"Elephant"),TAILLE_SPRITE,TAILLE_SPRITE);
    public static Sprite casePionJoueur2 = new Sprite(ImageLibrairie.imageLibrairie.getImage(Theme.STANDARD,"Rhinoceros"),TAILLE_SPRITE,TAILLE_SPRITE);
    public static Sprite casePionJoueur1Gauche = new Sprite(ImageLibrairie.imageLibrairie.getImage(Theme.STANDARD,"ElephantGauche"),TAILLE_SPRITE,TAILLE_SPRITE);
    public static Sprite casePionJoueur2Gauche = new Sprite(ImageLibrairie.imageLibrairie.getImage(Theme.STANDARD,"RhinocerosGauche"),TAILLE_SPRITE,TAILLE_SPRITE);
    public static Sprite caseMontagne = new Sprite(ImageLibrairie.imageLibrairie.getImage(Theme.STANDARD,"Montagne"),TAILLE_SPRITE,TAILLE_SPRITE);
    public static Sprite focus = new Sprite(ImageLibrairie.imageLibrairie.getImage(Theme.STANDARD,"Focus"),TAILLE_SPRITE,TAILLE_SPRITE);

    public Sprite(BufferedImage image, int hauteur, int largeur){
        this.largeur = largeur;
        this.hauteur = hauteur;
        pixels = new int[hauteur * largeur];
        int w = image.getWidth();
        int h = image.getHeight();
        image.getRGB(0, 0, w, h, pixels, 0, w);
    }

    public int getLargeur(){
        return largeur;
    }

    public int getHauteur(){
        return hauteur;
    }

    public int getPixel(int index){
        return pixels[index];
    }
}