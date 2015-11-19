package Siam;

import Siam.Interface.*;

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

    private Bouton boutonPoserPiece;
    private Bouton boutonSortirPiece;
    private Bouton boutonDeplacerPiece;
    private Bouton boutonChangerOrientation;
    private Bouton boutonPoserPieceSelec;
    private Bouton boutonSortirPieceSelec;
    private Bouton boutonDeplacerPieceSelec;
    private Bouton boutonChangerOrientationSelec;

    private Fleche flecheHaut;
    private Fleche flecheBas;
    private Fleche flecheDroite;
    private Fleche flecheGauche;
    private Fleche flecheHautSelec;
    private Fleche flecheBasSelec;
    private Fleche flecheDroiteSelec;
    private Fleche flecheGaucheSelec;

    private Fleche elephant;
    private Fleche rhinoceros;

    private DetectionSouris detectionSouris;
    private boolean pieceSelectionnee;
    private boolean placerPiece;
    private boolean sortirPiece;
    private boolean deplacerPiece;
    private boolean changerOrientation;
    private boolean selectionnerOrientation;
    private Joueur joueurActif;
    private Animal animalSelectionnee;

    private Thread thread;
    private boolean running;

    public Game() {
        this(new Joueur(Camp.ELEPHANT), new Joueur(Camp.RHINOCEROS), false, false, false, false, false, false);
    }

    public Game(Joueur joueur1, Joueur joueur2, boolean pieceSelectionnee, boolean placerPiece, boolean sortirPiece, boolean deplacerPiece, boolean changerOrientation, boolean selectionnerOrientation) {
        this.plateau = new Plateau(NOMBRE_CASE_INI);
        joueurs = new Joueur[2];
        joueurs[0] = joueur1;
        joueurs[1] = joueur2;
        joueurActif = joueurs[0];

        joueurs[0].setPlateau(plateau);
        joueurs[1].setPlateau(plateau);

        boutonPoserPiece = new Bouton(0, 0, SpriteBouton.boutonPoserPiece);
        boutonSortirPiece = new Bouton(0, 125, SpriteBouton.boutonSortirPiece);
        boutonDeplacerPiece = new Bouton(0, 250, SpriteBouton.boutonDeplacerPiece);
        boutonChangerOrientation = new Bouton(0, 375, SpriteBouton.boutonChangerOrientation);
        boutonPoserPieceSelec = new Bouton(0, 0, SpriteBouton.boutonPoserPieceSelec);
        boutonSortirPieceSelec = new Bouton(0, 125, SpriteBouton.boutonSortirPieceSelec);
        boutonDeplacerPieceSelec = new Bouton(0, 250, SpriteBouton.boutonDeplacerPieceSelec);
        boutonChangerOrientationSelec = new Bouton(0, 375, SpriteBouton.boutonChangerOrientationSelec);

        flecheHaut = new Fleche(75, 0, SpriteFleche.flecheBas, Orientation.HAUT);
        flecheBas = new Fleche(75, 100, SpriteFleche.flecheBas, Orientation.BAS);
        flecheDroite = new Fleche(125, 50, SpriteFleche.flecheDroite, Orientation.DROITE);
        flecheGauche = new Fleche(25, 50, SpriteFleche.flecheDroite, Orientation.GAUCHE);
        flecheHautSelec = new Fleche(75, 0, SpriteFleche.flecheBasSelec, Orientation.HAUT);
        flecheBasSelec = new Fleche(75, 100, SpriteFleche.flecheBasSelec, Orientation.BAS);
        flecheDroiteSelec = new Fleche(125, 50, SpriteFleche.flecheDroiteSelec, Orientation.DROITE);
        flecheGaucheSelec = new Fleche(25, 50, SpriteFleche.flecheDroiteSelec, Orientation.GAUCHE);

        elephant = new Fleche(75, 50, SpriteFleche.elephant, null);
        rhinoceros = new Fleche(75, 50, SpriteFleche.rhinoceros, null);

        image = new BufferedImage(LARGEUR_FENETRE_INI,HAUTEUR_FENETRE_INI, BufferedImage.TYPE_INT_RGB);
        pixels = ((DataBufferInt) image.getRaster().getDataBuffer()).getData();

        this.pieceSelectionnee = pieceSelectionnee;
        this.placerPiece = placerPiece;
        this.sortirPiece = sortirPiece;
        this.deplacerPiece = deplacerPiece;
        this.changerOrientation = changerOrientation;
        this.selectionnerOrientation = selectionnerOrientation;
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

    public boolean isSortirPiece() {
        return sortirPiece;
    }

    public void setSortirPiece(boolean sortirPiece) {
        this.sortirPiece = sortirPiece;
    }

    public boolean isDeplacerPiece() {
        return deplacerPiece;
    }

    public void setDeplacerPiece(boolean deplacerPiece) {
        this.deplacerPiece = deplacerPiece;
    }

    public boolean isChangerOrientation() {
        return changerOrientation;
    }

    public void setChangerOrientation(boolean changerOrientation) {
        this.changerOrientation = changerOrientation;
    }

    public boolean isSelectionnerOrientation() {
        return selectionnerOrientation;
    }

    public void setSelectionnerOrientation(boolean selectionnerOrientation) {
        this.selectionnerOrientation = selectionnerOrientation;
    }

    public Joueur getJoueurActif() {
        return joueurActif;
    }

    public void setJoueurActif(Joueur joueur) {
        joueurActif = joueur;
    }

    public Animal getAnimalSelectionnee() {
        return animalSelectionnee;
    }

    public void setAnimalSelectionnee(Animal animalSelectionnee) {
        this.animalSelectionnee = animalSelectionnee;
    }

    public void changerJoueurActif() {
        if (joueurActif == joueurs[0]) joueurActif = joueurs[1];
        else joueurActif = joueurs[0];
    }

    public synchronized void start(JFrame fenetre) {
        running = true;
        thread = new Thread(this, "Affichage");
        detectionSouris = new DetectionSouris(this, plateau);

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

        if (placerPiece) boutonPoserPieceSelec.render(ecran);
        else boutonPoserPiece.render(ecran);
        if (sortirPiece) boutonSortirPieceSelec.render(ecran);
        else boutonSortirPiece.render(ecran);
        if (deplacerPiece) boutonDeplacerPieceSelec.render(ecran);
        else boutonDeplacerPiece.render(ecran);
        if (changerOrientation) boutonChangerOrientationSelec.render(ecran);
        else boutonChangerOrientation.render(ecran);

        if (selectionnerOrientation) {
            flecheHautSelec.render(ecran);
            flecheBasSelec.render(ecran);
            flecheDroiteSelec.render(ecran);
            flecheGaucheSelec.render(ecran);
        } else {
            flecheHaut.render(ecran);
            flecheBas.render(ecran);
            flecheDroite.render(ecran);
            flecheGauche.render(ecran);
        }

        if (joueurActif.getCamp() == Camp.ELEPHANT) elephant.render(ecran);
        else rhinoceros.render(ecran);

        for (int i = 0; i < pixels.length; i++){
            pixels[i] = ecran.getPixel(i);
        }

        Graphics g = bs.getDrawGraphics();
        g.drawImage(image,0,0, fenetre.getWidth(),fenetre.getHeight(),null);
        g.dispose();
        bs.show();
    }
}
