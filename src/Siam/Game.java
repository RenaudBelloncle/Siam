package Siam;

import Siam.Interface.*;

import javax.swing.*;

public class Game implements Runnable, Constantes {

    private Plateau plateau;
    private Joueur[] joueurs;

    private JFrame fenetre;

    private DetectionSouris souris;

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
        this(new Joueur(Camp.ELEPHANT), new Joueur(Camp.RHINOCEROS), false, false, false, false, false, false, null);
    }

    public Game(Joueur joueur1, Joueur joueur2, boolean pieceSelectionnee, boolean placerPiece, boolean sortirPiece,
                boolean deplacerPiece, boolean changerOrientation, boolean selectionnerOrientation,
                Animal animalSelectionnee) {

        this.plateau = new Plateau(NOMBRE_CASE_INI);
        joueurs = new Joueur[2];
        joueurs[0] = joueur1;
        joueurs[1] = joueur2;
        joueurActif = joueurs[0];
        fenetre = new JFrame();

        joueurs[0].setPlateau(plateau);
        joueurs[1].setPlateau(plateau);

        souris = new DetectionSouris(this, plateau);

        this.pieceSelectionnee = pieceSelectionnee;
        this.placerPiece = placerPiece;
        this.sortirPiece = sortirPiece;
        this.deplacerPiece = deplacerPiece;
        this.changerOrientation = changerOrientation;
        this.selectionnerOrientation = selectionnerOrientation;

        this.animalSelectionnee = animalSelectionnee;

        running = false;
    }

    public Plateau getPlateau(){return plateau;}

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

    public JFrame getFenetre(){
        return fenetre;
    }

    public synchronized void start() {
        running = true;
        thread = new Thread(this, "Affichage");

        new VueJeu(this, plateau, fenetre, souris);
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
            fenetre.repaint();
        }
        stop();
    }
}
