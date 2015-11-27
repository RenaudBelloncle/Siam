package Siam.Interface;

import Siam.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VueJeu implements ActionListener, Constantes {

    private Game game;
    private JFrame fenetre;

    private DetectionSouris souris;

    private JButton poser;
    private JButton deplacer;
    private JButton sortir;
    private JButton orienter;
    private JButton flecheHaut;
    private JButton flecheDroite;
    private JButton flecheGauche;
    private JButton flecheBas;

    public VueJeu(Game game, JFrame fenetre, DetectionSouris souris){
        this.game = game;
        this.fenetre = fenetre;
        this.souris = souris;

        initVueJeu();
        affichageVueJeu();

        fenetre.setTitle("Siam");
        fenetre.setResizable(false);
        fenetre.pack();
        fenetre.setLocationRelativeTo(null);
        fenetre.setVisible(true);

        setControlBouton(this);
    }

    public void initVueJeu() {
        poser = new JButton("Poser une piece");
        deplacer = new JButton("Deplacer une piece");
        sortir = new JButton("Sortir une piece");
        orienter = new JButton("Orienter une piece");
        flecheHaut = new JButton("Haut");
        flecheDroite = new JButton("Droite");
        flecheGauche = new JButton("Gauche");
        flecheBas = new JButton("Bas");
    }

    public void affichageVueJeu() {
        PanelPlateau panelPlateau = new PanelPlateau(game, souris);
        JPanel panelJeu = new JPanel();
        JPanel panelBouton = new JPanel();
        JPanel panelPoser = new JPanel();
        JPanel panelDeplacer = new JPanel();
        JPanel panelSortir = new JPanel();
        JPanel panelOrienter = new JPanel();
        JPanel panelHaut = new JPanel();
        JPanel panelFleche = new JPanel();
        JPanel panelGauche = new JPanel();
        JPanel panelDroite = new JPanel();
        JPanel panelBas = new JPanel();

        panelJeu.add(panelPlateau);

        deplacer.setEnabled(false);
        sortir.setEnabled(false);
        orienter.setEnabled(false);
        flecheHaut.setEnabled(false);
        flecheBas.setEnabled(false);
        flecheGauche.setEnabled(false);
        flecheDroite.setEnabled(false);

        panelPoser.add(poser);
        panelDeplacer.add(deplacer);
        panelSortir.add(sortir);
        panelOrienter.add(orienter);

        panelFleche.setLayout(new BorderLayout());
        panelHaut.add(flecheHaut);
        panelGauche.add(flecheGauche);
        panelDroite.add(flecheDroite);
        panelFleche.add(panelDroite, BorderLayout.EAST);
        panelFleche.add(panelGauche, BorderLayout.WEST);
        panelBas.add(flecheBas);

        panelBouton.add(panelPoser);
        panelBouton.add(panelDeplacer);
        panelBouton.add(panelSortir);
        panelBouton.add(panelOrienter);
        panelBouton.add(panelHaut);
        panelBouton.add(panelFleche);
        panelBouton.add(panelBas);
        panelBouton.setLayout(new GridLayout(7, 1));
        panelJeu.add(panelBouton);

        panelJeu.setLayout(new BoxLayout(panelJeu, BoxLayout.X_AXIS));
        fenetre.setContentPane(panelJeu);
    }

    public void setControlBouton(ActionListener actionListener) {
        poser.addActionListener(actionListener);
        deplacer.addActionListener(actionListener);
        sortir.addActionListener(actionListener);
        orienter.addActionListener(actionListener);
        flecheHaut.addActionListener(actionListener);
        flecheBas.addActionListener(actionListener);
        flecheDroite.addActionListener(actionListener);
        flecheGauche.addActionListener(actionListener);
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        Object source = event.getSource();
        if (source == poser && !game.isSelectionnerOrientation()) {
            game.setPlacerPiece(true);
        }
        if (source == sortir && game.isPieceSelectionnee()) {
            if (game.getAnimalSelectionnee().getAbscisse() == 0 || game.getAnimalSelectionnee().getAbscisse() == 4 || game.getAnimalSelectionnee().getOrdonnee() == 0 || game.getAnimalSelectionnee().getOrdonnee() == 4) {
                game.setSortirPiece(true);
                game.getJoueurActif().sortirPiece(game.getAnimalSelectionnee().getAbscisse(), game.getAnimalSelectionnee().getOrdonnee());
                game.changerJoueurActif();
            } else {
                game.getAnimalSelectionnee().setSelectionnee(false);
            }
            game.setPieceSelectionnee(false);
            game.setAnimalSelectionnee(null);
            game.setSelectionnerOrientation(false);
            game.setSortirPiece(false);
        }
        if (source == deplacer && game.isPieceSelectionnee()) {
            game.setDeplacerPiece(true);
        }
        if (source == orienter && game.isPieceSelectionnee()) {
            game.setChangerOrientation(true);
            game.setSelectionnerOrientation(true);
        }
        if (game.isSelectionnerOrientation() && source == flecheHaut) {
            game.getAnimalSelectionnee().setOrientation(Orientation.HAUT);
            game.deselection();
            game.setEnCoursDeDeplacement(false);
            if (game.isChangerOrientation()) game.setChangerOrientation(false);
            game.changerJoueurActif();
        }
        if (game.isSelectionnerOrientation() && source == flecheDroite) {
            game.getAnimalSelectionnee().setOrientation(Orientation.DROITE);
            game.deselection();
            game.setEnCoursDeDeplacement(false);
            if (game.isChangerOrientation()) game.setChangerOrientation(false);
            game.changerJoueurActif();
        }
        if (game.isSelectionnerOrientation() && source == flecheBas) {
            game.getAnimalSelectionnee().setOrientation(Orientation.BAS);
            game.deselection();
            game.setEnCoursDeDeplacement(false);
            if (game.isChangerOrientation()) game.setChangerOrientation(false);
            game.changerJoueurActif();
        }
        if (game.isSelectionnerOrientation() && source == flecheGauche) {
            game.getAnimalSelectionnee().setOrientation(Orientation.GAUCHE);
            game.deselection();
            game.setEnCoursDeDeplacement(false);
            if (game.isChangerOrientation()) game.setChangerOrientation(false);
            game.changerJoueurActif();
        }
    }

    public JButton getPoser() {
        return poser;
    }

    public JButton getDeplacer() {
        return deplacer;
    }

    public JButton getSortir() {
        return sortir;
    }

    public JButton getOrienter() {
        return orienter;
    }

    public JButton getFlecheHaut() {
        return flecheHaut;
    }

    public JButton getFlecheDroite() {
        return flecheDroite;
    }

    public JButton getFlecheGauche() {
        return flecheGauche;
    }

    public JButton getFlecheBas() {
        return flecheBas;
    }
}
