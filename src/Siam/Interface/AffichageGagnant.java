package Siam.Interface;

import Siam.Camp;
import Siam.Constantes;
import Siam.Game;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AffichageGagnant implements ActionListener, Constantes {

    private Game game;
    private JFrame fenetre;
    private Camp campGagant;
    private OutilsFont outil;

    public AffichageGagnant(Game game, JFrame fenetre, Camp campGagant) {
        this.game = game;
        this.fenetre = fenetre;
        this.campGagant = campGagant;
        outil = new OutilsFont();
        affichage();
    }

    private void affichage() {
    }


    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        // Si clic sur bouton retour au menu alors
        // new Menu(game, game.getFenetre());
    }
}