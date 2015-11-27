package Siam.Interface;

import Siam.Enum.Camp;
import Siam.Constantes;
import Siam.Enum.Theme;
import Siam.Game;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class EcranVictoire implements ActionListener, Constantes {

    private Game game;
    private JFrame fenetre;
    private OutilsFont outils;
    private JButton retour;
    private JLabel gagnant;
    private Theme theme;

    public EcranVictoire(Game game, JFrame fenetre, Camp campGagnant, Theme theme){
        this.game = game;
        this.fenetre = fenetre;
        this.theme = theme;
        initEcranVictoire(campGagnant);
        afficheEcranVictoire();
        retour.addActionListener(this);

        fenetre.setSize(LARGEUR_FENETRE, HAUTEUR_FENETRE);
        fenetre.setLocationRelativeTo(null);
        fenetre.setResizable(false);
        fenetre.setTitle("Siam");
        fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fenetre.setVisible(true);
    }

    public void initEcranVictoire(Camp campGagnant){
        StringBuilder str = new StringBuilder("La victoire est pour les ");
        if(campGagnant == Camp.ELEPHANT) {
            str.append("Eléphants");
        }
        else{
            str.append("Rhinocéros");
        }
        gagnant = new JLabel(String.valueOf(str));
        outils = new OutilsFont();
        retour = new JButton("retour");
    }

    public void afficheEcranVictoire() {
        JPanel panPrincipal = new JPanel();
        JPanel phraseGagnant = new JPanel();
        JPanel vide = new JPanel();
        JPanel retourPanel = new JPanel();

        panPrincipal.setOpaque(false);
        phraseGagnant.setOpaque(false);
        vide.setOpaque(false);
        retourPanel.setOpaque(false);

        panPrincipal = new JPanel() {
            BufferedImage image = ImageLibrairie.imageLibrairie.getImage(theme, "FondMenu");

            public void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(image, 0, 0, LARGEUR_FENETRE, HAUTEUR_FENETRE, this);
            }
        };

        //changement de la police
        outils.changerFontJLabel(gagnant, 40, Color.orange, outils.getFontTexte());
        outils.changerFontButton(retour, 80, Color.orange, outils.getFontMenu());

        phraseGagnant.add(gagnant);
        retourPanel.add(retour);
        panPrincipal.add(phraseGagnant);
        panPrincipal.add(vide);
        panPrincipal.add(retourPanel);
        panPrincipal.setLayout(new BoxLayout(panPrincipal, BoxLayout.Y_AXIS));

        fenetre.setContentPane(panPrincipal);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if (source == retour) {
            new Menu(game, fenetre, theme);
        }
    }
}