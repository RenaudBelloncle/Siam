package Siam;

import Siam.Enum.Camp;
import Siam.Enum.Theme;
import Siam.Interface.*;
import Siam.Sons.Musique;
import Siam.Sons.SoundsLibrary;

import javax.swing.*;

public class Jeu implements Runnable, Constantes {

    private Plateau plateau;
    private Joueur[] joueurs;

    private VueJeu vueJeu;
    private JFrame fenetre;
    private Theme theme;
    private Musique musique;
    private boolean son;
    private SoundsLibrary soundsLibrary;

    private DetectionSouris souris;

    private boolean pieceSelectionnee;

    private boolean placerPiece;
    private boolean sortirPiece;
    private boolean deplacerPiece;
    private boolean changerOrientation;
    private boolean selectionnerOrientation;
    private boolean enCoursDeDeplacement;

    private Joueur joueurActif;
    private Animal animalSelectionnee;

    private Thread thread;
    private boolean running;
    private boolean varianteNombreDePieceActive;
    private boolean varianteCaseBannieActive;

    public Jeu() {
        this(new Joueur(Camp.ELEPHANT), new Joueur(Camp.RHINOCEROS),
                false, false, false, false, false, false, false, null, new JFrame(), null, Theme.STANDARD,
                new Musique(Theme.STANDARD), true, false, false, new SoundsLibrary());

    public Jeu(Plateau plateau){
        this();
        this.plateau = plateau;
    }

    public Jeu(Joueur joueur1, Joueur joueur2, boolean pieceSelectionnee, boolean placerPiece, boolean sortirPiece,
               boolean deplacerPiece, boolean changerOrientation, boolean selectionnerOrientation, boolean enCoursDeDeplacement,
               Animal animalSelectionnee, JFrame fenetre, VueJeu vueJeu, Theme theme, Musique musique, boolean son,
               boolean varianteNombre,boolean varianteCase) {

        varianteCaseBannieActive = varianteCase;
        varianteNombreDePieceActive = varianteNombre;

        this.plateau = new Plateau(NOMBRE_CASE_INI);
        joueurs = new Joueur[2];
        joueurs[0] = joueur1;
        joueurs[1] = joueur2;
        joueurActif = joueurs[0];
        this.fenetre = fenetre;
        this.soundsLibrary = soundsLibrary;

        joueurs[0].setPlateau(plateau);
        joueurs[1].setPlateau(plateau);

        souris = new DetectionSouris(this, plateau);

        this.pieceSelectionnee = pieceSelectionnee;
        this.placerPiece = placerPiece;
        this.sortirPiece = sortirPiece;
        this.deplacerPiece = deplacerPiece;
        this.changerOrientation = changerOrientation;
        this.selectionnerOrientation = selectionnerOrientation;
        this.enCoursDeDeplacement = enCoursDeDeplacement;

        this.animalSelectionnee = animalSelectionnee;

        this.vueJeu = vueJeu;

        this.theme = theme;
        this.musique = musique;
        this.musique.start();
        this.son = son;

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

    public boolean isEnCoursDeDeplacement() {
        return enCoursDeDeplacement;
    }

    public void setEnCoursDeDeplacement(boolean enCoursDeDeplacement) {
        this.enCoursDeDeplacement = enCoursDeDeplacement;
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
        joueurActif.finDeTour();
        if (joueurActif == joueurs[0]) joueurActif = joueurs[1];
        else joueurActif = joueurs[0];
    }

    public JFrame getFenetre(){
        return fenetre;
    }

    public VueJeu getVueJeu() {
        return vueJeu;
    }

    public void setTheme(Theme theme) {
        this.theme = theme;
    }

    public Theme getTheme() {
        return theme;
    }

    public void setMusique(Musique musique) {
        this.musique = musique;
    }

    public Musique getMusique() {
        return musique;
    }

    public void setSon(boolean son) {
        this.son = son;
    }

    public boolean isSon() {
        return son;
    }

    public boolean varianteCaseBannieActive(){
        return varianteCaseBannieActive;
    }

    public boolean varianteNombreDePieceMaxActive(){
        return varianteNombreDePieceActive;
    }

    public void initJeu(Joueur joueur1, Joueur joueur2) {
        this.plateau = new Plateau(NOMBRE_CASE_INI);
        joueurs = new Joueur[2];
        joueurs[0] = joueur1;
        joueurs[1] = joueur2;
        setJoueurActif(joueurs[0]);

        joueurs[0].setPlateau(plateau);
        joueurs[1].setPlateau(plateau);

        souris = new DetectionSouris(this, plateau);

        pieceSelectionnee = false;
        placerPiece = false;
        sortirPiece = false;
        deplacerPiece = false;
        changerOrientation = false;
        selectionnerOrientation = false;
        enCoursDeDeplacement = false;

        animalSelectionnee = null;
    }

    public void activerVariante(boolean varCase, boolean varPiece){
        varianteNombreDePieceActive = varPiece;
        varianteCaseBannieActive = varCase;
    }

    public synchronized void start() {
        running = true;
        thread = new Thread(this, "Affichage");

        vueJeu = new VueJeu(this, fenetre, souris);
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
            affichageBouton();
            fenetre.repaint();
        }
        stop();
    }

    private void affichageBouton() {
        if(enCoursDeDeplacement){
            vueJeu.getDeplacer().setEnabled(false);
            vueJeu.getSortir().setEnabled(false);
            vueJeu.getOrienter().setEnabled(false);
            vueJeu.getPoser().setEnabled(false);
        }
        else if (pieceSelectionnee) {
            vueJeu.getDeplacer().setEnabled(true);
            if (animalSelectionnee.getAbscisse() == 0 || animalSelectionnee.getOrdonnee() == 0 ||
                    animalSelectionnee.getAbscisse() == NOMBRE_CASE_INI-1 ||
                    animalSelectionnee.getOrdonnee() == NOMBRE_CASE_INI-1) vueJeu.getSortir().setEnabled(true);
            vueJeu.getOrienter().setEnabled(true);
        }
        else if (!selectionnerOrientation) {
            if (!joueurActif.restePiece() || (varianteNombreDePieceActive && !joueurActif.restePieceDispo()))
                vueJeu.getPoser().setEnabled(false);
            else vueJeu.getPoser().setEnabled(true);
            vueJeu.getDeplacer().setEnabled(false);
            vueJeu.getSortir().setEnabled(false);
            vueJeu.getOrienter().setEnabled(false);
            vueJeu.getFlecheHaut().setEnabled(false);
            vueJeu.getFlecheBas().setEnabled(false);
            vueJeu.getFlecheDroite().setEnabled(false);
            vueJeu.getFlecheGauche().setEnabled(false);
        }
        if (selectionnerOrientation) {
            vueJeu.getPoser().setEnabled(false);
            vueJeu.getFlecheHaut().setEnabled(true);
            vueJeu.getFlecheBas().setEnabled(true);
            vueJeu.getFlecheDroite().setEnabled(true);
            vueJeu.getFlecheGauche().setEnabled(true);
        }

    }

    public void deselection(){
        setPieceSelectionnee(false);
        getAnimalSelectionnee().setSelectionnee(false);
        setAnimalSelectionnee(null);
        setSelectionnerOrientation(false);
    }

    public boolean testOrientationEntreAnimalEtCase(Animal animal,Case uneCase){
        switch(animal.getOrientation()){
            case BAS:
                return animal.getAbscisse() == uneCase.getAbscisse()
                        && animal.getOrdonnee() + 1 == uneCase.getOrdonnee();
            case HAUT:
                return animal.getAbscisse() == uneCase.getAbscisse()
                        && animal.getOrdonnee()  -1 == uneCase.getOrdonnee();
            case DROITE:
                return animal.getAbscisse() + 1 == uneCase.getAbscisse()
                        && animal.getOrdonnee() == uneCase.getOrdonnee();
            case GAUCHE:
                return animal.getAbscisse() - 1 == uneCase.getAbscisse()
                        && animal.getOrdonnee() == uneCase.getOrdonnee();
        }
        return false;
    }

    public SoundsLibrary getSoundsLibrary() {
        return soundsLibrary;
    }
}
