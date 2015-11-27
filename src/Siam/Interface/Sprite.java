package Siam.Interface;

import Siam.Constantes;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Sprite implements Constantes{
    private String path;
    private int[] pixels;
    private int largeur, hauteur;

    public static Sprite caseVide = new Sprite("/Standard/Sprites/case.png",TAILLE_SPRITE,TAILLE_SPRITE);
    public static Sprite casePionJoueur1 = new Sprite("/Standard/Sprites/pionBlanc.png",TAILLE_SPRITE,TAILLE_SPRITE);
    public static Sprite casePionJoueur2 = new Sprite("/Standard/Sprites/pionNoir.png",TAILLE_SPRITE,TAILLE_SPRITE);
    public static Sprite casePionJoueur1Gauche = new Sprite("/Standard/Sprites/pionBlancGauche.png",TAILLE_SPRITE,TAILLE_SPRITE);
    public static Sprite casePionJoueur2Gauche = new Sprite("/Standard/Sprites/pionNoirGauche.png",TAILLE_SPRITE,TAILLE_SPRITE);
    public static Sprite casePionJoueur1Selec = new Sprite("/Standard/Sprites/pionBlancSelec.png",TAILLE_SPRITE,TAILLE_SPRITE);
    public static Sprite casePionJoueur2Selec = new Sprite("/Standard/Sprites/pionNoirSelec.png",TAILLE_SPRITE,TAILLE_SPRITE);
    public static Sprite casePionJoueur1GaucheSelec = new Sprite("/Standard/Sprites/pionBlancGaucheSelec.png",TAILLE_SPRITE,TAILLE_SPRITE);
    public static Sprite casePionJoueur2GaucheSelec = new Sprite("/Standard/Sprites/pionNoirGaucheSelec.png",TAILLE_SPRITE,TAILLE_SPRITE);
    public static Sprite caseMontagne = new Sprite("/Standard/Sprites/montagne.png",TAILLE_SPRITE,TAILLE_SPRITE);

    public Sprite(String path,int _hauteur, int _largeur){
        largeur = _largeur;
        hauteur = _hauteur;
        pixels = new int[hauteur * largeur];
        this.path = path;
        load();
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