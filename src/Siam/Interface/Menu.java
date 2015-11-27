package Siam.Interface;

import Siam.Constantes;
import Siam.Game;

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
    private Instructions instruction;
    private JFrame fenetre;

    private JLabel titre;
    private JButton jeuxSolo;
    private JButton jeuxMulti;
    private JButton instructions;
    private JButton option;
    private JButton themeSuivant;
    private JButton scores;
    private JButton quitter;
    private JButton local;
    private JButton reseau;
    private JLabel multi;
    private JLabel optionL;
    private JButton couperSon;
    private JButton annuler;

    private JPanel panPrincipal;
    private JPanel panTitre;
    private JPanel panBoutons;
    private JPanel panVide;
    private JPanel panVide2;

    private int theme= 0;

    public Menu(JFrame fenetre){
        this(new Game(fenetre), fenetre);
    }

    public Menu(Game game,JFrame fenetre){
        this.game = game;
        this.fenetre = fenetre;
        outil = new OutilsFont();
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
        jeuxSolo = new JButton("Solo");
        jeuxMulti = new JButton("Multi");
        instructions = new JButton("Règles");
        scores = new JButton("Scores");
        quitter = new JButton("Quitter");

        multi = new JLabel("Jeux multi");
        optionL = new JLabel("    Options");
        reseau = new JButton("Réseau");
        local = new JButton("Local");
        annuler = new JButton("Annuler");
        option = new JButton("Options");
        couperSon = new JButton("Couper le son");
        themeSuivant = new JButton("Thème suivant");

    }

    public void afficheMenu(){

        initPanel();

        panTitre.add(titre);
        panBoutons.add(jeuxSolo);
        panBoutons.add(jeuxMulti);
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

    public void afficheMenuMulti(){

        initPanel();

        panTitre.add(titre);
        panBoutons.add(multi);
        panBoutons.add(local);
        panBoutons.add(reseau);
        panBoutons.add(annuler);

        chargerImage();
        changerPolice();

        panBoutons.setLayout(new GridLayout(5, 1));
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

        //changement de la police
        outil.changerFontJLabel(titre, 150, Color.orange, outil.getFontMenu());/*outil.getFont(int theme)*/
        outil.changerFontButton(jeuxSolo, 60, Color.orange, outil.getFontTexte());
        outil.changerFontButton(jeuxMulti, 60, Color.orange, outil.getFontTexte());
        outil.changerFontButton(scores, 60, Color.orange, outil.getFontTexte());
        outil.changerFontButton(option, 60, Color.orange, outil.getFontTexte());
        outil.changerFontButton(quitter, 60, Color.orange, outil.getFontTexte());

        outil.changerFontJLabel(multi, 65, Color.orange, outil.getFontMenu());
        outil.changerFontJLabel(optionL, 65, Color.orange, outil.getFontMenu());
        outil.changerFontButton(local, 55, Color.orange, outil.getFontTexte());
        outil.changerFontButton(reseau, 55, Color.orange, outil.getFontTexte());
        outil.changerFontButton(instructions, 55, Color.orange, outil.getFontTexte());
        outil.changerFontButton(couperSon, 55, Color.orange, outil.getFontTexte());
        outil.changerFontButton(themeSuivant, 55, Color.orange, outil.getFontTexte());
        outil.changerFontButton(annuler, 55, Color.orange, outil.getFontTexte());
    }

    public void chargerImage(){
        try {
            panPrincipal = new JPanel() {
                BufferedImage image = ImageIO.read(new File(tabFond[theme]));

                public void paintComponent(Graphics g) {
                    super.paintComponent(g);
                    fenetre.repaint();
                    g.drawImage(image, 0, 0, LARGEUR_FENETRE, HAUTEUR_FENETRE, this);
                }
            };
        } catch (IOException e) {
            e.printStackTrace();
        }
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
        jeuxSolo.addActionListener(listener);
        jeuxMulti.addActionListener(listener);
        instructions.addActionListener(listener);
        scores.addActionListener(listener);
        quitter.addActionListener(listener);
        local.addActionListener(listener);
        reseau.addActionListener(listener);
        annuler.addActionListener(listener);
        option.addActionListener(listener);
        themeSuivant.addActionListener(listener);
    }

    public int getTheme(){
        return theme;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        Object source = e.getSource();

        if(source == quitter) {
            System.exit(0);
        }
        else if(source == jeuxSolo) {
            ChoixCamp choixCamp = new ChoixCamp(game, game.getFenetre());
        }
        else if(source == jeuxMulti) {
            afficheMenuMulti();
            fenetre.setVisible(true);
        }
        else if(source == instructions) {
            instruction = new Instructions();
        }
        else if(source == scores) {

        }
        else if(source == local) {
            game.start();
        }

        else if(source == reseau) {

        }
        else if(source == annuler) {
            lanceMenu();
        }
        else if(source == option) {
            afficheMenuOption();
            fenetre.setVisible(true);
        }
        else if(source == themeSuivant) {
            theme += 1;

            if (theme >1){
                theme = 0;
            }
            afficheMenuOption();
            fenetre.setVisible(true);
        }
    }
}