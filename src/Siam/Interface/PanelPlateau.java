package Siam.Interface;

import Siam.Constantes;
import Siam.DetectionSouris;
import Siam.Enum.Theme;
import Siam.Jeu;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;

public class PanelPlateau extends JPanel implements Constantes{
    private BufferedImage image;
    private int[] pixels;
    private Ecran ecran;
    private Jeu jeu;

    public PanelPlateau(Jeu jeu, DetectionSouris souris) {
        Dimension taille = new Dimension(LARGEUR_AFFICHAGE_PLATEAU, HAUTEUR_AFFICHAGE_PLATEAU);
        setPreferredSize(taille);
        this.jeu = jeu;
        ecran = new Ecran(LARGEUR_AFFICHAGE_PLATEAU, HAUTEUR_AFFICHAGE_PLATEAU);
        image = new BufferedImage(LARGEUR_AFFICHAGE_PLATEAU,HAUTEUR_AFFICHAGE_PLATEAU, BufferedImage.TYPE_INT_RGB);
        pixels = ((DataBufferInt) image.getRaster().getDataBuffer()).getData();
        addMouseListener(souris);
    }

    @Override
    public void paintComponent(Graphics g){
        ecran.vider();
        jeu.getPlateau().affichage(ecran, jeu.getTheme());
        if(jeu.varianteCaseBannieActive() && jeu.getJoueurActif().getNombreTour() < 2){
            if (jeu.getTheme() == Theme.STANDARD){
                ecran.affichageSprite(2, 0, Sprite.StandardCaseBannie, false, false);
                ecran.affichageSprite(2, 4, Sprite.StandardCaseBannie, false, false);
            }
            else if (jeu.getTheme() == Theme.NOEL){
                ecran.affichageSprite(2, 0, Sprite.NoelCaseBannie, false, false);
                ecran.affichageSprite(2, 4, Sprite.NoelCaseBannie, false, false);
            }
        }
        for (int i = 0; i < pixels.length; i++){
            pixels[i] = ecran.getPixel(i);
        }
        g.drawImage(image, 0, 0, getWidth(), getHeight(), null);
        g.dispose();
    }
}