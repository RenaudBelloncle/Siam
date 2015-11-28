package Siam.Interface;

import Siam.Enum.Camp;
import Siam.Constantes;
import Siam.Enum.Theme;
import Siam.Game;
import Siam.Joueur;
import Siam.Sons.Musique;

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
    private JButton continuer;
    private JButton retourMenu;
    private JLabel gagnant;
    private Theme theme;
    private Musique libMuse;
    private boolean son;

    public EcranVictoire(Game game, JFrame fenetre, Camp campGagnant, Theme theme, Musique libMuse, boolean son){
        this.game = game;
        this.fenetre = fenetre;
        this.theme = theme;
        this.libMuse = libMuse;
        this.son = son;
        initEcranVictoire(campGagnant);
        afficheEcranVictoire();
        continuer.addActionListener(this);
        retourMenu.addActionListener(this);

        fenetre.setSize(LARGEUR_FENETRE, HAUTEUR_FENETRE);
        fenetre.setLocationRelativeTo(null);
        fenetre.setResizable(false);
        fenetre.setTitle("Siam");
        fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fenetre.setVisible(true);
    }

    public void initEcranVictoire(Camp campGagnant){
        StringBuilder str = new StringBuilder("Victoire des ");
        if(campGagnant == Camp.ELEPHANT)  str.append("Eléphants");
        else str.append("Rhinocéros");
        gagnant = new JLabel(String.valueOf(str));
        outils = new OutilsFont();
        continuer = new JButton("Continuer");
        retourMenu = new JButton("Retour au Menu");
    }

    public void afficheEcranVictoire() {
        JPanel panPrincipal = new JPanel();
        JPanel phraseGagnant = new JPanel();
        JPanel vide = new JPanel();
        JPanel boutonPanel = new JPanel();

        panPrincipal.setOpaque(false);
        phraseGagnant.setOpaque(false);
        vide.setOpaque(false);
        boutonPanel.setOpaque(false);

        panPrincipal = new JPanel() {
            BufferedImage image = ImageLibrairie.imageLibrairie.getImage(theme, "FondMenu");

            public void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(image, 0, 0, LARGEUR_FENETRE, HAUTEUR_FENETRE, this);
            }
        };

        changerPolice();


        phraseGagnant.add(gagnant);
        boutonPanel.add(continuer);
        boutonPanel.add(retourMenu);
        boutonPanel.setLayout(new GridLayout(1, 2));
        panPrincipal.add(vide);
        panPrincipal.add(phraseGagnant);
        panPrincipal.add(boutonPanel);
        panPrincipal.setLayout(new GridLayout(3,1));

        fenetre.setContentPane(panPrincipal);
    }

    private void changerPolice() {
        if (theme == Theme.STANDARD) {
            outils.changerFontJLabel(gagnant, 80, Color.orange, outils.getFontTexte());
            outils.changerFontButton(continuer, 40, Color.orange, outils.getFontMenu());
            outils.changerFontButton(retourMenu, 40, Color.orange, outils.getFontMenu());
        } else if (theme == Theme.NOEL) {
            outils.changerFontJLabel(gagnant, 80, Color.black, outils.getFontTexte());
            outils.changerFontButton(continuer, 40, Color.black, outils.getFontMenu());
            outils.changerFontButton(retourMenu, 40, Color.black, outils.getFontMenu());
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if (source == continuer) {
            game.setTheme(theme);
            game.setLibMuse(libMuse);
            game.setSon(son);
            game.initGame(new Joueur(Camp.ELEPHANT), new Joueur(Camp.RHINOCEROS));
            game.start();
        }
        if (source == retourMenu) {
            new Menu(game, fenetre, theme, libMuse, son);
        }
    }
}