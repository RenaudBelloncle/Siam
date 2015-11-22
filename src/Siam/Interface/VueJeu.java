package Siam.Interface;
import Siam.Constantes;
import Siam.Game;

import javax.swing.*;
import java.awt.*;

public class VueJeu implements Constantes{
    private Game jeu;
    private PanelPlateau plateau;
    private JFrame fenetre;

    public VueJeu(Game _game, JFrame _fenetre){
        jeu = _game;
        fenetre = _fenetre;
        plateau = new PanelPlateau(jeu);
        JPanel panelJeu = new JPanel();
        JPanel panelBouton = new JPanel();
        panelJeu.add(plateau);
        JButton poser = new JButton("Poser une pièce");
        JButton deplacer = new JButton("Deplacer une pièce");
        JButton retirer = new JButton("Retirer une pièce");
        panelBouton.add(poser);
        panelBouton.add(deplacer);
        panelBouton.add(retirer);
        panelBouton.setLayout(new BoxLayout(panelBouton, BoxLayout.Y_AXIS));
        panelJeu.add(panelBouton);
        fenetre.setContentPane(panelJeu);
        //Initialisation de la fenêtre
        Dimension size = new Dimension(LARGEUR_FENETRE_INI, HAUTEUR_FENETRE_INI);
        fenetre.setPreferredSize(size);
        fenetre.setTitle("Siam");
        fenetre.setResizable(false);
        fenetre.pack();
        fenetre.setLocationRelativeTo(null);
        fenetre.setVisible(true);

    }
}
