package Siam;

import Siam.Interface.Ecran;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;
import java.util.Random;

public class Game implements Runnable, Constantes {

    static final Random random = new Random();

    private Plateau plateau;
    private Joueur[] joueurs;

    // L'�cran g�re un tableau de pixel
    private JFrame fenetre;
    private Ecran ecran;
    private BufferedImage image = new BufferedImage(LARGEUR_FENETRE_INI,HAUTEUR_FENETRE_INI, BufferedImage.TYPE_INT_RGB);
    private int[] pixels = ((DataBufferInt) image.getRaster().getDataBuffer()).getData();

    private Thread thread;
    private boolean running = false;

    public Game() {
        joueurs = new Joueur[2];
        joueurs[0] = new Joueur();
        joueurs[1] = new Joueur();
        plateau = new Plateau(NOMBRE_CASE_INI);
    }

    public Joueur[] getJoueurs() {
        return joueurs;
    }

    public synchronized void start(JFrame _fenetre) {
        running = true;
        thread = new Thread(this, "Affichage");

        // Fenetre + debut de gestion graphique
        fenetre = _fenetre;
        fenetre.removeAll();
        Dimension size = new Dimension(LARGEUR_FENETRE_INI, HAUTEUR_FENETRE_INI);
        fenetre.setPreferredSize(size);
        ecran = new Ecran(LARGEUR_FENETRE_INI, HAUTEUR_FENETRE_INI);
        fenetre.setTitle("Siam");
        fenetre.setResizable(false);
        fenetre.pack();
        fenetre.setLocationRelativeTo(null);
        fenetre.setVisible(true);

        thread.start();
    }

    public synchronized void stop() {
        running = false;
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void run() {
        while(running) {
            update();
            render();
        }
        stop();
    }

    public void update() {

    }

    public void render() {
        BufferStrategy bs = fenetre.getBufferStrategy();
        if(bs == null){
            fenetre.createBufferStrategy(3);
            return;
        }
        ecran.clear();
        plateau.render(ecran);

        for (int i = 0; i < pixels.length; i++){
            pixels[i] = ecran.getPixel(i);
        }

        Graphics g = bs.getDrawGraphics();
        g.drawImage(image,0,0, fenetre.getWidth(),fenetre.getHeight(),null);
        g.dispose();
        bs.show();
    }
}
