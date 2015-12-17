package Siam;

import Siam.Enum.Camp;
import Siam.Enum.Orientation;
import Siam.Enum.Theme;
import Siam.Interface.VueJeu;
import Siam.Sons.Musique;
import Siam.Sons.SoundsLibrary;

import javax.swing.*;
import java.awt.*;
import java.io.*;

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
    private boolean placerMontagne;

    private Joueur joueurActif;
    private String pseudoJoueurActif;
    private Animal animalSelectionnee;

    private Thread thread;
    private boolean running;
    private boolean varianteNombreDePieceActive;
    private boolean varianteCaseBannieActive;
    private boolean varianteMontagneActive;

    public Jeu() {
        this(new Joueur(Camp.ELEPHANT, ""), new Joueur(Camp.RHINOCEROS, ""),
                false, false, false, false, false, false, false, null, new JFrame(), null, Theme.STANDARD,
                new Musique(Theme.STANDARD), true, false, false, false, new SoundsLibrary());

    }

    public Jeu(Plateau plateau){
        this();
        this.plateau = plateau;
        this.placerMontagne=false;
    }

    public Jeu(Joueur joueur1, Joueur joueur2, boolean pieceSelectionnee, boolean placerPiece, boolean sortirPiece,
               boolean deplacerPiece, boolean changerOrientation, boolean selectionnerOrientation, boolean enCoursDeDeplacement,
               Animal animalSelectionnee, JFrame fenetre, VueJeu vueJeu, Theme theme, Musique musique, boolean son,
               boolean varianteNombre,boolean varianteCase, boolean varianteMontagne, SoundsLibrary soundsLibrary) {

        this.plateau = new Plateau(NOMBRE_CASE_INI, this);
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
        this.placerMontagne=false;

        this.animalSelectionnee = animalSelectionnee;

        this.vueJeu = vueJeu;

        this.theme = theme;
        this.musique = musique;
        this.musique.start();
        this.son = son;

        varianteCaseBannieActive = varianteCase;
        varianteNombreDePieceActive = varianteNombre;
        varianteMontagneActive = varianteMontagne;

        running = false;
    }

    public void setPlacerMontagne(boolean status){
        this.placerMontagne=status;
    }

    public boolean getPlacerMontagne(){
        return placerMontagne;
    }

    public Plateau getPlateau() {
        return plateau;
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

    public String getPseudoJoueur(Camp camp) {

        Joueur[] joueurs;
        joueurs = getJoueurs();
        if (joueurs[0].getCamp() == camp) { return joueurs[0].getPseudo(); }
        else { return joueurs[1].getPseudo(); }

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
        vueJeu.changerJoueurActif();
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

    public boolean varianteMontagneActive(){
        return varianteMontagneActive;
    }

    public void initJeu(Joueur joueur1, Joueur joueur2) {
        this.plateau = new Plateau(NOMBRE_CASE_INI, this);
        plateau.initMontagne();
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

    public void activerVariante(boolean varCase, boolean varPiece, boolean varMontagne){
        varianteNombreDePieceActive = varPiece;
        varianteCaseBannieActive = varCase;
        varianteMontagneActive = varMontagne;
    }

    public synchronized void start() {
        running = true;
        thread = new Thread(this, "Affichage");
        pseudoJoueurActif = getPseudoJoueur(joueurActif.getCamp());
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
        else if (placerMontagne){
            vueJeu.getPoser().setEnabled(true);
            vueJeu.getDeplacer().setEnabled(false);
            vueJeu.getSortir().setEnabled(false);
            vueJeu.getOrienter().setEnabled(false);
            vueJeu.getFlecheHaut().setEnabled(false);
            vueJeu.getFlecheBas().setEnabled(false);
            vueJeu.getFlecheDroite().setEnabled(false);
            vueJeu.getFlecheGauche().setEnabled(false);
        }
        else if (pieceSelectionnee && animalSelectionnee != null) {
            vueJeu.getDeplacer().setEnabled(true);
            if (animalSelectionnee.getAbscisse() == 0 ||
                    animalSelectionnee.getOrdonnee() == 0 ||
                    animalSelectionnee.getAbscisse() == NOMBRE_CASE_INI-1 ||
                    animalSelectionnee.getOrdonnee() == NOMBRE_CASE_INI-1)
                vueJeu.getSortir().setEnabled(true);
            vueJeu.getOrienter().setEnabled(true);
        }
        else if (!selectionnerOrientation) {
            if (!joueurActif.restePiece() || (varianteNombreDePieceActive &&
                    !joueurActif.restePieceDispo()))
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
        if (placerPiece || placerMontagne) {
            vueJeu.getPoser().setForeground(Color.BLUE);
        } else {
            switch (theme) {
                case STANDARD:
                    vueJeu.getPoser().setForeground(Color.ORANGE);
                    break;
                case NOEL:
                    vueJeu.getPoser().setForeground(Color.RED);
                    break;
                case STARWARS:
                    vueJeu.getPoser().setForeground(Color.YELLOW);
                    break;
            }
        }
        if (deplacerPiece) {
            vueJeu.getDeplacer().setForeground(Color.BLUE);
        } else {
            switch (theme) {
                case STANDARD:
                    vueJeu.getDeplacer().setForeground(Color.ORANGE);
                    break;
                case NOEL:
                    vueJeu.getDeplacer().setForeground(Color.RED);
                    break;
                case STARWARS:
                    vueJeu.getDeplacer().setForeground(Color.YELLOW);
                    break;
            }
        }
        if (changerOrientation) {
            vueJeu.getOrienter().setForeground(Color.BLUE);
        } else {
            switch (theme) {
                case STANDARD:
                    vueJeu.getOrienter().setForeground(Color.ORANGE);
                    break;
                case NOEL:
                    vueJeu.getOrienter().setForeground(Color.RED);
                    break;
                case STARWARS:
                    vueJeu.getOrienter().setForeground(Color.YELLOW);
                    break;
            }
        }
    }

    public void deselection(){
        pieceSelectionnee = false;
        getAnimalSelectionnee().setSelectionnee(false);
        animalSelectionnee =null;
        selectionnerOrientation = false;
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

    public void sauvegarder(){

        File file = new File("save.txt");
        try {
            PrintStream ps = new PrintStream(file);
            ps.println(joueurs.length);
            int numJoueur = -1;
            for(int i = 0; i < joueurs.length; i++){
                joueurs[i].sauvegarder(ps);
                if(joueurActif.equals(joueurs[i]))
                    numJoueur = i;
            }
            ps.println(numJoueur);
            plateau.sauvegarder(ps);
            ps.println(theme);
            ps.println(varianteCaseBannieActive);
            ps.println(varianteMontagneActive);
            ps.println(varianteNombreDePieceActive);
        } catch (FileNotFoundException e) {
            try {
                file.createNewFile();
                PrintStream ps = new PrintStream(file);
            } catch (IOException e1) {
                System.err.println("Echec sauvegarde");
            }
        }
    }

    public void charger(){
        String line;
        try {
            BufferedReader br = new BufferedReader(new FileReader("save.txt"));
            int nbJoueur = Integer.parseInt(br.readLine());
            joueurs = new Joueur[nbJoueur];
            for(int i = 0; i < nbJoueur; i++ ) {
                joueurs[i] = new Joueur(br.readLine(), Integer.parseInt(br.readLine()),
                        Integer.parseInt(br.readLine()), Integer.parseInt(br.readLine()));
                switch (br.readLine()) {
                    case "ELEPHANT":
                         joueurs[i].setCamp(Camp.ELEPHANT);
                        break;
                    case "RHINOCEROS":
                        joueurs[i].setCamp(Camp.RHINOCEROS);
                        break;
                    case "NEUTRE":
                        joueurs[i].setCamp(Camp.NEUTRE);
                        break;
                    case "MONTAGNE":
                        joueurs[i].setCamp(Camp.NEUTRE);
                        break;
                }
            }
            setJoueurActif(joueurs[Integer.parseInt(br.readLine())]);
            plateau = new Plateau(Integer.parseInt(br.readLine()),this);
            Case[][] plat = new Case[plateau.getTailleCote()][plateau.getTailleCote()];
            for(int i = 0; i < plateau.getTailleCote();i++) {
                for (int j = 0; j < plateau.getTailleCote(); j++) {
                    switch (br.readLine()) {
                        case "0":
                            plat[i][j] = new Case(Integer.parseInt(br.readLine()), Integer.parseInt(br.readLine()));
                            break;
                        case "1":
                            int x = Integer.parseInt(br.readLine());
                            int y = Integer.parseInt(br.readLine());
                            Camp c = Camp.NEUTRE;
                            switch (br.readLine()) {
                                case "ELEPHANT":
                                    c = (Camp.ELEPHANT);
                                    break;
                                case "RHINOCEROS":
                                    c = (Camp.RHINOCEROS);
                                    break;
                                case "NEUTRE":
                                    c = (Camp.NEUTRE);
                                    break;
                            }
                            plat[i][j] = new Montagne(x, y, c);
                            break;
                        case "2":
                            int xi = Integer.parseInt(br.readLine());
                            int yi = Integer.parseInt(br.readLine());
                            Camp ci = Camp.NEUTRE;
                            switch (br.readLine()) {
                                case "ELEPHANT":
                                    ci = (Camp.ELEPHANT);
                                    break;
                                case "RHINOCEROS":
                                    ci = (Camp.RHINOCEROS);
                                    break;
                                case "NEUTRE":
                                    ci = (Camp.NEUTRE);
                                    break;
                            }
                            Animal a = new Animal(xi,yi,ci);
                            switch (br.readLine()) {
                                case "HAUT":
                                    a.setOrientation(Orientation.HAUT);
                                    break;
                                case "BAS":
                                    a.setOrientation(Orientation.BAS);
                                    break;
                                case "GAUCHE":
                                    a.setOrientation(Orientation.GAUCHE);
                                    break;
                                case "DROITE":
                                    a.setOrientation(Orientation.DROITE);
                                    break;
                            }
                            if(joueurs[0].getCamp() == ci)
                                joueurs[0].ajouterAnimal(a);
                            else if(joueurs[1].getCamp() == ci)
                                joueurs[1].ajouterAnimal(a);
                            plat[i][j] = a;
                            break;
                    }
                }
            }
            plateau.setPlateau(plat);
            switch (br.readLine()) {
                case "STANDARD":
                    setTheme(Theme.STANDARD);
                    break;
                case "NOEL":
                    setTheme(Theme.NOEL);
                    break;
            }
            varianteCaseBannieActive = Boolean.parseBoolean(br.readLine());
            varianteMontagneActive = Boolean.parseBoolean(br.readLine());
            varianteNombreDePieceActive = Boolean.parseBoolean(br.readLine());

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

            start();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
