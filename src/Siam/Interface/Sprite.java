package Siam.Interface;

import Siam.Constantes;
import Siam.Enum.Theme;
import org.omg.IOP.TAG_ALTERNATE_IIOP_ADDRESS;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Sprite implements Constantes{

    private int[] pixels;
    private int largeur;
    private int hauteur;

    public static Sprite StandardCaseVide = new Sprite(ImageLibrairie.imageLibrairie.getImage(Theme.STANDARD,"Case"),TAILLE_SPRITE,TAILLE_SPRITE);
    public static Sprite StandardCasePionJoueur1 = new Sprite(ImageLibrairie.imageLibrairie.getImage(Theme.STANDARD,"Elephant"),TAILLE_SPRITE,TAILLE_SPRITE);
    public static Sprite StandardCasePionJoueur2 = new Sprite(ImageLibrairie.imageLibrairie.getImage(Theme.STANDARD,"Rhinoceros"),TAILLE_SPRITE,TAILLE_SPRITE);
    public static Sprite StandardCasePionJoueur1Gauche = new Sprite(ImageLibrairie.imageLibrairie.getImage(Theme.STANDARD,"ElephantGauche"),TAILLE_SPRITE,TAILLE_SPRITE);
    public static Sprite StandardCasePionJoueur2Gauche = new Sprite(ImageLibrairie.imageLibrairie.getImage(Theme.STANDARD,"RhinocerosGauche"),TAILLE_SPRITE,TAILLE_SPRITE);
    public static Sprite StandardCaseMontagne = new Sprite(ImageLibrairie.imageLibrairie.getImage(Theme.STANDARD,"Montagne"),TAILLE_SPRITE,TAILLE_SPRITE);
    public static Sprite StandardFocus = new Sprite(ImageLibrairie.imageLibrairie.getImage(Theme.STANDARD,"Focus"),TAILLE_SPRITE,TAILLE_SPRITE);
    public static Sprite StandardCaseBannie = new Sprite(ImageLibrairie.imageLibrairie.getImage(Theme.STANDARD,"CaseBannie"), TAILLE_SPRITE,TAILLE_SPRITE);

    public static Sprite NoelCaseVide = new Sprite(ImageLibrairie.imageLibrairie.getImage(Theme.NOEL,"Case"),TAILLE_SPRITE,TAILLE_SPRITE);
    public static Sprite NoelCasePionJoueur1 = new Sprite(ImageLibrairie.imageLibrairie.getImage(Theme.NOEL,"Elephant"),TAILLE_SPRITE,TAILLE_SPRITE);
    public static Sprite NoelCasePionJoueur2 = new Sprite(ImageLibrairie.imageLibrairie.getImage(Theme.NOEL,"Rhinoceros"),TAILLE_SPRITE,TAILLE_SPRITE);
    public static Sprite NoelCasePionJoueur1Gauche = new Sprite(ImageLibrairie.imageLibrairie.getImage(Theme.NOEL,"ElephantGauche"),TAILLE_SPRITE,TAILLE_SPRITE);
    public static Sprite NoelCasePionJoueur2Gauche = new Sprite(ImageLibrairie.imageLibrairie.getImage(Theme.NOEL,"RhinocerosGauche"),TAILLE_SPRITE,TAILLE_SPRITE);
    public static Sprite NoelCaseMontagne = new Sprite(ImageLibrairie.imageLibrairie.getImage(Theme.NOEL,"Montagne"),TAILLE_SPRITE,TAILLE_SPRITE);
    public static Sprite NoelFocus = new Sprite(ImageLibrairie.imageLibrairie.getImage(Theme.NOEL,"Focus"),TAILLE_SPRITE,TAILLE_SPRITE);
    public static Sprite NoelCaseBannie = new Sprite(ImageLibrairie.imageLibrairie.getImage(Theme.NOEL,"CaseBannie"), TAILLE_SPRITE,TAILLE_SPRITE);

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