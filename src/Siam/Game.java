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

    // L'ecran gere un tableau de pixel
    private JFrame fenetre;
    private Ecran ecran;
    private BufferedImage image;
    private int[] pixels;

    private DetectionSouris detectionSouris;
    private boolean insertionPiece;
    private Joueur joueurActif;

    private Thread thread;
    private boolean running;

    public Game() {
        this(new Joueur(0), new Joueur(1), new Plateau(NOMBRE_CASE_INI), false);
    }

    public Game(Joueur joueur1, Joueur joueur2, Plateau plateau, boolean insertionPiece) {
        joueurs = new Joueur[2];
        joueurs[0] = joueur1;
        joueurs[1] = joueur2;
        this.plateau = plateau;
        joueurActif = joueurs[0];

        image = new BufferedImage(LARGEUR_FENETRE_INI,HAUTEUR_FENETRE_INI, BufferedImage.TYPE_INT_RGB);
        pixels = ((DataBufferInt) image.getRaster().getDataBuffer()).getData();

        this.insertionPiece = insertionPiece;
        running = false;
    }

    public Joueur[] getJoueurs() {
        return joueurs;
    }

    public boolean isInsertionPiece() {
        return insertionPiece;
    }

    public void setInsertionPiece(boolean insertionPiece) {
        this.insertionPiece = insertionPiece;
    }

    public Joueur getJoueurActif() {
        return joueurActif;
    }

    public void setJoueurActif(Joueur joueur) {
        joueurActif = joueur;
    }

    public Plateau getPlateau() {
        return plateau;
    }

    public synchronized void start(JFrame _fenetre) {
        running = true;
        thread = new Thread(this, "Affichage");
        detectionSouris = new DetectionSouris(this);

        // Fenetre + debut de gestion graphique
        fenetre = _fenetre;
        fenetre.removeAll();
        Dimension size = new Dimension(LARGEUR_FENETRE_INI, HAUTEUR_FENETRE_INI);
        fenetre.setPreferredSize(size);

        fenetre.addMouseListener(detectionSouris);

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
        for(Joueur joueur : joueurs) joueur.render(ecran);

        for (int i = 0; i < pixels.length; i++){
            pixels[i] = ecran.getPixel(i);
        }

        Graphics g = bs.getDrawGraphics();
        g.drawImage(image,0,0, fenetre.getWidth(),fenetre.getHeight(),null);
        g.dispose();
        bs.show();
    }
}
