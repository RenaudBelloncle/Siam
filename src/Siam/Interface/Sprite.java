package Siam.Interface;

import Siam.Constantes;
import Siam.Enum.Theme;

import java.awt.image.BufferedImage;

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
    public static Sprite StandardCaseMontagneElephant = new Sprite(ImageLibrairie.imageLibrairie.getImage(Theme.STANDARD,"CaillouElephant"),TAILLE_SPRITE,TAILLE_SPRITE);
    public static Sprite StandardCaseMontagneRhinoceros = new Sprite(ImageLibrairie.imageLibrairie.getImage(Theme.STANDARD,"CaillouRhino"),TAILLE_SPRITE,TAILLE_SPRITE);
    public static Sprite StandardFocus = new Sprite(ImageLibrairie.imageLibrairie.getImage(Theme.STANDARD,"Focus"),TAILLE_SPRITE,TAILLE_SPRITE);
    public static Sprite StandardCaseBannie = new Sprite(ImageLibrairie.imageLibrairie.getImage(Theme.STANDARD,"CaseBannie"), TAILLE_SPRITE,TAILLE_SPRITE);

    public static Sprite NoelCaseVide = new Sprite(ImageLibrairie.imageLibrairie.getImage(Theme.NOEL,"Case"),TAILLE_SPRITE,TAILLE_SPRITE);
    public static Sprite NoelCasePionJoueur1 = new Sprite(ImageLibrairie.imageLibrairie.getImage(Theme.NOEL,"Elephant"),TAILLE_SPRITE,TAILLE_SPRITE);
    public static Sprite NoelCasePionJoueur2 = new Sprite(ImageLibrairie.imageLibrairie.getImage(Theme.NOEL,"Rhinoceros"),TAILLE_SPRITE,TAILLE_SPRITE);
    public static Sprite NoelCasePionJoueur1Gauche = new Sprite(ImageLibrairie.imageLibrairie.getImage(Theme.NOEL,"ElephantGauche"),TAILLE_SPRITE,TAILLE_SPRITE);
    public static Sprite NoelCasePionJoueur2Gauche = new Sprite(ImageLibrairie.imageLibrairie.getImage(Theme.NOEL,"RhinocerosGauche"),TAILLE_SPRITE,TAILLE_SPRITE);
    public static Sprite NoelCaseMontagne = new Sprite(ImageLibrairie.imageLibrairie.getImage(Theme.NOEL,"Montagne"),TAILLE_SPRITE,TAILLE_SPRITE);
    public static Sprite NoelCaseMontagneElephant = new Sprite(ImageLibrairie.imageLibrairie.getImage(Theme.NOEL,"CaillouElephant"),TAILLE_SPRITE,TAILLE_SPRITE);
    public static Sprite NoelCaseMontagneRhinoceros = new Sprite(ImageLibrairie.imageLibrairie.getImage(Theme.NOEL,"CaillouRhino"),TAILLE_SPRITE,TAILLE_SPRITE);
    public static Sprite NoelFocus = new Sprite(ImageLibrairie.imageLibrairie.getImage(Theme.NOEL,"Focus"),TAILLE_SPRITE,TAILLE_SPRITE);
    public static Sprite NoelCaseBannie = new Sprite(ImageLibrairie.imageLibrairie.getImage(Theme.NOEL,"CaseBannie"), TAILLE_SPRITE,TAILLE_SPRITE);

    public static Sprite StarWarsCaseVide = new Sprite(ImageLibrairie.imageLibrairie.getImage(Theme.STARWARS,"Case"),TAILLE_SPRITE,TAILLE_SPRITE);
    public static Sprite StarWarsCasePionJoueur1 = new Sprite(ImageLibrairie.imageLibrairie.getImage(Theme.STARWARS,"Elephant"),TAILLE_SPRITE,TAILLE_SPRITE);
    public static Sprite StarWarsCasePionJoueur2 = new Sprite(ImageLibrairie.imageLibrairie.getImage(Theme.STARWARS,"Rhinoceros"),TAILLE_SPRITE,TAILLE_SPRITE);
    public static Sprite StarWarsCasePionJoueur1Gauche = new Sprite(ImageLibrairie.imageLibrairie.getImage(Theme.STARWARS,"ElephantGauche"),TAILLE_SPRITE,TAILLE_SPRITE);
    public static Sprite StarWarsCasePionJoueur2Gauche = new Sprite(ImageLibrairie.imageLibrairie.getImage(Theme.STARWARS,"RhinocerosGauche"),TAILLE_SPRITE,TAILLE_SPRITE);
    public static Sprite StarWarsCaseMontagne = new Sprite(ImageLibrairie.imageLibrairie.getImage(Theme.STARWARS,"Montagne"),TAILLE_SPRITE,TAILLE_SPRITE);
    public static Sprite StarWarsCaseMontagneElephant = new Sprite(ImageLibrairie.imageLibrairie.getImage(Theme.STARWARS,"CaillouElephant"),TAILLE_SPRITE,TAILLE_SPRITE);
    public static Sprite StarWarsCaseMontagneRhinoceros = new Sprite(ImageLibrairie.imageLibrairie.getImage(Theme.STARWARS,"CaillouRhino"),TAILLE_SPRITE,TAILLE_SPRITE);
    public static Sprite StarWarsFocus = new Sprite(ImageLibrairie.imageLibrairie.getImage(Theme.STARWARS,"Focus"),TAILLE_SPRITE,TAILLE_SPRITE);
    public static Sprite StarWarsCaseBannie = new Sprite(ImageLibrairie.imageLibrairie.getImage(Theme.STARWARS,"CaseBannie"), TAILLE_SPRITE,TAILLE_SPRITE);

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