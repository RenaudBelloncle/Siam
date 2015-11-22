package Siam.Interface;
import Siam.Constantes;
import Siam.Game;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;


public class PanelPlateau extends JPanel implements Constantes{
    private BufferedImage image;
    private int[] pixels;
    private Ecran ecran;
    private Game jeu;

    public PanelPlateau(Game _jeu){
        Dimension taille = new Dimension(LARGEUR_AFFICHAGE_PLATEAU, HAUTEUR_AFFICHAGE_PLATEAU);
        setPreferredSize(taille);
        jeu = _jeu;
        ecran = new Ecran(LARGEUR_AFFICHAGE_PLATEAU, HAUTEUR_AFFICHAGE_PLATEAU);
        image = new BufferedImage(LARGEUR_AFFICHAGE_PLATEAU,HAUTEUR_AFFICHAGE_PLATEAU, BufferedImage.TYPE_INT_RGB);
        pixels = ((DataBufferInt) image.getRaster().getDataBuffer()).getData();
    }

    @Override
    public void paintComponent(Graphics g){
        ecran.clear();
        jeu.getPlateau().render(ecran);

        for (int i = 0; i < pixels.length; i++){
            pixels[i] = ecran.getPixel(i);
        }
        g.drawImage(image, 0, 0, getWidth(), getHeight(), null);
        g.dispose();
    }
}
