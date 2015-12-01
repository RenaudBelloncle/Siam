package Siam.Interface;

import Siam.Constantes;
import Siam.Enum.Theme;
import Siam.Jeu;
import Siam.Sons.Musique;
import Siam.Sons.SoundsLibrary;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

public class Menu extends JFrame implements ActionListener, Constantes {

    private Jeu jeu;
    private OutilsFont outilsFont;
    private JFrame fenetre;
    private SoundsLibrary soundsLibrary;

    private JLabel titre;
    private JButton jouer;
    private JButton instructions;
    private JButton option;
    private JButton themeSuivant;
    private JButton scores;
    private JButton quitter;
    private JLabel optionL;
    private JButton couperSon;
    private JButton annuler;

    private JPanel panPrincipal;
    private JPanel panTitre;
    private JPanel panBoutons;
    private JPanel panVide;
    private JPanel panVide2;

    private Theme theme;
    private Musique musique;
    private boolean son;

    public Menu(Jeu jeu, JFrame fenetre, Theme theme, Musique musique, boolean son, SoundsLibrary soundsLibrary){
        this.jeu = jeu;
        this.fenetre = fenetre;
        this.musique = musique;
        this.son = son;
        outilsFont = new OutilsFont();
        this.theme = theme;

        this.soundsLibrary = soundsLibrary;
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
        instructions = new JButton("Regles");
        scores = new JButton("Scores");
        quitter = new JButton("Quitter");

        optionL = new JLabel("Options", SwingConstants.CENTER);
        annuler = new JButton("Annuler");
        option = new JButton("Options");
        if (son) couperSon = new JButton("Musique On");
        else couperSon = new JButton("Musique Off");
        themeSuivant = new JButton("Theme suivant");
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
        if (theme == Theme.STANDARD) {
            outilsFont.changerFontJLabel(titre, 150, Color.orange, outilsFont.getStandardFontMenu());
            outilsFont.changerFontButton(jouer, 60, Color.orange, outilsFont.getStandardFontTexte());
            outilsFont.changerFontButton(scores, 60, Color.orange, outilsFont.getStandardFontTexte());
            outilsFont.changerFontButton(option, 60, Color.orange, outilsFont.getStandardFontTexte());
            outilsFont.changerFontButton(quitter, 60, Color.orange, outilsFont.getStandardFontTexte());

            outilsFont.changerFontJLabel(optionL, 65, Color.orange, outilsFont.getStandardFontMenu());
            outilsFont.changerFontButton(instructions, 55, Color.orange, outilsFont.getStandardFontTexte());
            outilsFont.changerFontButton(couperSon, 55, Color.orange, outilsFont.getStandardFontTexte());
            outilsFont.changerFontButton(themeSuivant, 55, Color.orange, outilsFont.getStandardFontTexte());
            outilsFont.changerFontButton(annuler, 55, Color.orange, outilsFont.getStandardFontTexte());
        } else if (theme == Theme.NOEL) {
            outilsFont.changerFontJLabel(titre, 150, Color.red, outilsFont.getNoelFontMenu());
            outilsFont.changerFontButton(jouer, 70, Color.green, outilsFont.getNoelFontTexte());
            outilsFont.changerFontButton(scores, 70, Color.green, outilsFont.getNoelFontTexte());
            outilsFont.changerFontButton(option, 70, Color.green, outilsFont.getNoelFontTexte());
            outilsFont.changerFontButton(quitter, 70, Color.green, outilsFont.getNoelFontTexte());

            outilsFont.changerFontJLabel(optionL, 65, Color.green, outilsFont.getNoelFontMenu());
            outilsFont.changerFontButton(instructions, 65, Color.green, outilsFont.getNoelFontTexte());
            outilsFont.changerFontButton(couperSon, 65, Color.green, outilsFont.getNoelFontTexte());
            outilsFont.changerFontButton(themeSuivant, 65, Color.green, outilsFont.getNoelFontTexte());
            outilsFont.changerFontButton(annuler, 65, Color.green, outilsFont.getNoelFontTexte());
        }
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
        soundsLibrary.playBouttonSound(theme);

        if(source == quitter) {
            System.exit(0);
        }
        else if(source == jouer) {
            new ChoixCamp(jeu, jeu.getFenetre(), theme, musique, son, soundsLibrary);
        }
        else if(source == instructions) {
            new Instructions(theme);
        }
        //else if(source == scores) {
            //TODO Afficher les scores
        //}
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
            jeu.setTheme(theme);
            if (son) {
                musique.arret();
                musique = new Musique(theme);
                musique.start();
            }
            afficheMenuOption();
            fenetre.setVisible(true);
        }
        else if(source == couperSon) {
            if (son){
                couperSon = new JButton("Musique Off");
                musique.arret();
                couperSon.addActionListener(this);
                son = false;
            }
            else{
                couperSon = new JButton("Musique On");
                musique = new Musique(theme);
                musique.start();
                couperSon.addActionListener(this);
                son = true;
            }
            afficheMenuOption();
            fenetre.setVisible(true);
        }
    }
}