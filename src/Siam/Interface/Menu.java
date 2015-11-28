package Siam.Interface;

import Siam.Constantes;
import Siam.Enum.Theme;
import Siam.Game;
import Siam.Sons.Musique;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Menu extends JFrame implements ActionListener, Constantes {

    private Game game;
    private OutilsFont outil;
    private Musique libMuse;
    private JFrame fenetre;

    private JLabel titre;
    private JButton jouer;
    private JButton instructions;
    private JButton option;
    private JButton themeSuivant;
    private JButton scores;
    private JButton quitter;
    private JLabel multi;
    private JLabel optionL;
    private JButton couperSon;
    private JButton annuler;

    private JPanel panPrincipal;
    private JPanel panTitre;
    private JPanel panBoutons;
    private JPanel panVide;
    private JPanel panVide2;

    private Theme theme;
    private boolean son;

    public Menu(Game game,JFrame fenetre, Theme theme, Musique libMuse, boolean musique){
        this.game = game;
        this.fenetre = fenetre;
        this.libMuse = libMuse;
        this.son = musique;
        outil = new OutilsFont();
        this.theme = theme;
        fenetre.setSize(LARGEUR_FENETRE, HAUTEUR_FENETRE);
        fenetre.setLocationRelativeTo(null);
        fenetre.setResizable(false);
        fenetre.setTitle("Siam");
        fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        initMenu();
        lanceMenu();
        setControlMenu(this);
    }

    public void lanceMenu(){
        afficheMenu();
        fenetre.setVisible(true);
    }

    public void initMenu(){
        titre = new JLabel("Siam");
        jouer = new JButton("Jouer");
        instructions = new JButton("Règles");
        scores = new JButton("Scores");
        quitter = new JButton("Quitter");

        multi = new JLabel("Jeux multi");
        optionL = new JLabel("    Options");
        annuler = new JButton("Annuler");
        option = new JButton("Options");
        couperSon = new JButton("Musique On");
        themeSuivant = new JButton("Thème suivant");

    }

    public void afficheMenu(){

        initPanel();

        panTitre.add(titre);
        panBoutons.add(jouer);
        panBoutons.add(scores);
        panBoutons.add(option);
        panBoutons.add(quitter);

        chargerImage();
        changerPolice();

        panBoutons.setLayout(new GridLayout(6, 1));
        panPrincipal.setLayout(new GridLayout(2, 2));

        panPrincipal.add(panTitre);
        panPrincipal.add(panVide);
        panPrincipal.add(panVide2);
        panPrincipal.add(panBoutons);

        fenetre.setContentPane(panPrincipal);
    }

    public void afficheMenuOption(){

        initPanel();

        panTitre.add(titre);
        panBoutons.add(optionL);
        panBoutons.add(instructions);
        panBoutons.add(themeSuivant);
        panBoutons.add(couperSon);
        panBoutons.add(annuler);

        chargerImage();
        changerPolice();

        panBoutons.setLayout(new GridLayout(6, 1));
        panPrincipal.setLayout(new GridLayout(2, 2));

        panPrincipal.add(panTitre);
        panPrincipal.add(panVide);
        panPrincipal.add(panVide2);
        panPrincipal.add(panBoutons);

        fenetre.setContentPane(panPrincipal);
    }

    public void changerPolice(){
        outil.changerFontJLabel(titre, 150, Color.orange, outil.getFontMenu());
        outil.changerFontButton(jouer, 60, Color.orange, outil.getFontTexte());
        outil.changerFontButton(scores, 60, Color.orange, outil.getFontTexte());
        outil.changerFontButton(option, 60, Color.orange, outil.getFontTexte());
        outil.changerFontButton(quitter, 60, Color.orange, outil.getFontTexte());

        outil.changerFontJLabel(multi, 65, Color.orange, outil.getFontMenu());
        outil.changerFontJLabel(optionL, 65, Color.orange, outil.getFontMenu());
        outil.changerFontButton(instructions, 55, Color.orange, outil.getFontTexte());
        outil.changerFontButton(couperSon, 55, Color.orange, outil.getFontTexte());
        outil.changerFontButton(themeSuivant, 55, Color.orange, outil.getFontTexte());
        outil.changerFontButton(annuler, 55, Color.orange, outil.getFontTexte());
    }

    public void chargerImage(){
        panPrincipal = new JPanel() {
            BufferedImage image = ImageLibrairie.imageLibrairie.getImage(theme, "FondMenu");
            public void paintComponent(Graphics g) {
                super.paintComponent(g);
                fenetre.repaint();
                g.drawImage(image, 0, 0, LARGEUR_FENETRE, HAUTEUR_FENETRE, this);
            }
        };
    }

    public void initPanel(){

        panPrincipal = new JPanel();
        panTitre = new JPanel();
        panBoutons = new JPanel();
        panVide = new JPanel();
        panVide2 = new JPanel();

        panPrincipal.setOpaque(false);
        panTitre.setOpaque(false);
        panBoutons.setOpaque(false);
        panVide.setOpaque(false);
        panVide2.setOpaque(false);
    }

    public void setControlMenu(ActionListener listener){
        jouer.addActionListener(listener);
        instructions.addActionListener(listener);
        scores.addActionListener(listener);
        quitter.addActionListener(listener);
        annuler.addActionListener(listener);
        option.addActionListener(listener);
        themeSuivant.addActionListener(listener);
        couperSon.addActionListener(listener);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        Object source = e.getSource();

        if(source == quitter) {
            System.exit(0);
        }
        else if(source == jouer) {
            new ChoixCamp(game, game.getFenetre(), theme, libMuse, son);
        }
        else if(source == instructions) {
            new Instructions(theme);
        }
        else if(source == scores) {
            //TODO Afficher les scores
        }
        else if(source == annuler) {
            lanceMenu();
        }
        else if(source == option) {
            afficheMenuOption();
            fenetre.setVisible(true);
        }
        else if(source == themeSuivant) {
            switch (theme) {
                case STANDARD:
                    theme = Theme.NOEL;
                    break;
                case NOEL:
                    theme = Theme.STANDARD;
                    break;
            }
            afficheMenuOption();
            fenetre.setVisible(true);
        }
        else if(source == couperSon) {
            if (son){
                couperSon = new JButton("Musique Off");
                libMuse.arret();
                couperSon.addActionListener(this);
                son = false;
            }
            else{
                couperSon = new JButton("Musique On");
                libMuse = new Musique();
                libMuse.start();
                couperSon.addActionListener(this);
                son = true;
            }
            afficheMenuOption();
            fenetre.setVisible(true);
        }
    }
}