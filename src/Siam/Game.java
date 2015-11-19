package Siam;

import Siam.Interface.Ecran;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;
import java.util.Random;

public class Game implements Runnable, Constantes {

    private Plateau plateau;
    private Joueur[] joueurs;

    // L'ecran gere un tableau de pixel
    private JFrame fenetre;
    private Ecran ecran;
    private BufferedImage image;
    private int[] pixels;

    private DetectionSouris detectionSouris;
    private boolean pieceSelectionnee;
    private boolean placerPiece;
    private Joueur joueurActif;

    private Thread thread;
    private boolean running;

    public Game() {
        this(new Joueur(Camp.ELEPHANT), new Joueur(Camp.RHINOCEROS), false, false);
    }

    public Game(Joueur joueur1, Joueur joueur2, boolean pieceSelectionnee, boolean placerPiece) {
        this.plateau = new Plateau(NOMBRE_CASE_INI);
        joueurs = new Joueur[2];
        joueurs[0] = joueur1;
        joueurs[1] = joueur2;
        joueurActif = joueurs[0];

        joueurs[0].setPlateau(plateau);
        joueurs[1].setPlateau(plateau);

        image = new BufferedImage(LARGEUR_FENETRE_INI,HAUTEUR_FENETRE_INI, BufferedImage.TYPE_INT_RGB);
        pixels = ((DataBufferInt) image.getRaster().getDataBuffer()).getData();

        this.pieceSelectionnee = pieceSelectionnee;
        this.placerPiece = placerPiece;
        running = false;
    }

    public Joueur[] getJoueurs() {
        return joueurs;
    }

    public boolean isPieceSelectionnee() {
        return pieceSelectionnee;
    }

    public void setPieceSelectionnee(boolean pieceSelectionnee) {
        this.pieceSelectionnee = pieceSelectionnee;
    }

    public boolean isPlacerPiece() {
        return placerPiece;
    }

    public void setPlacerPiece(boolean placerPiece) {
        this.placerPiece = placerPiece;
    }

    public Joueur getJoueurActif() {
        return joueurActif;
    }

    public void setJoueurActif(Joueur joueur) {
        joueurActif = joueur;
    }

    public synchronized void start(JFrame fenetre) {
        running = true;
        thread = new Thread(this, "Affichage");
        detectionSouris = new DetectionSouris(this);

        // Fenetre + debut de gestion graphique
        this.fenetre = fenetre;
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

        for (int i = 0; i < pixels.length; i++){
            pixels[i] = ecran.getPixel(i);
        }

        Graphics g = bs.getDrawGraphics();
        g.drawImage(image,0,0, fenetre.getWidth(),fenetre.getHeight(),null);
        g.dispose();
        bs.show();
    }
}
