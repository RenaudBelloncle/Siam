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

public class Menu implements ActionListener, Constantes {

    private Game game;
    private OutilsFont outil;
    private Instructions instruction;
    private JFrame fenetre;

    private JLabel titre;

    private JButton jeuxSolo;
    private JButton jeuxMulti;
    private JButton instructions;
    private JButton scores;
    private JButton quitter;

    private JButton local;
    private JButton reseau;
    private JLabel multi;
    private JButton annuler;

    public Menu(Game game,JFrame fenetre){
        this.game = game;
        this.fenetre = fenetre;
        outil = new OutilsFont();
        menu();
    }

    public void menu(){
        initMenu();
        afficheMenu();
        fenetre.setSize(LARGEUR_FENETRE, HAUTEUR_FENETRE);
        fenetre.setLocationRelativeTo(null);
        fenetre.setResizable(false);
        fenetre.setTitle("Siam");
        fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fenetre.setVisible(true);
        setControlMenu(this);
    }

    public void menuMulti(){
        initMenu();
        afficheMenuMulti();
        fenetre.setSize(LARGEUR_FENETRE, HAUTEUR_FENETRE);
        fenetre.setLocationRelativeTo(null);
        fenetre.setResizable(false);
        fenetre.setTitle("Siam");
        fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fenetre.setVisible(true);
        setControlMenu(this);
    }

    public void initMenu(){
        titre = new JLabel("Siam");
        jeuxSolo = new JButton("Solo");
        jeuxMulti = new JButton("Multi");
        instructions = new JButton("Règles");
        scores = new JButton("Scores");
        quitter = new JButton("Quitter");

        multi = new JLabel("Jeux multi");
        reseau = new JButton("Réseau");
        local = new JButton("Local");
        annuler = new JButton("Annuler");
    }

    public void afficheMenu(){
        JPanel panPrincipal = new JPanel();
        JPanel panTitre = new JPanel();
        JPanel panBoutons = new JPanel();
        JPanel panVide = new JPanel();
        JPanel panVide2 = new JPanel();

        panTitre.add(titre);
        panBoutons.add(jeuxSolo);
        panBoutons.add(jeuxMulti);
        panBoutons.add(scores);
        panBoutons.add(instructions);
        panBoutons.add(quitter);

        panPrincipal.setOpaque(false);
        panTitre.setOpaque(false);
        panBoutons.setOpaque(false);
        panVide.setOpaque(false);
        panVide2.setOpaque(false);

        try {
            panPrincipal = new JPanel() {
                BufferedImage image = ImageIO.read(new File("res/images/fondJungle.jpg"));

                public void paintComponent(Graphics g) {
                    super.paintComponent(g);
                    g.drawImage(image, 0, 0, LARGEUR_FENETRE, HAUTEUR_FENETRE, this);
                }
            };
        } catch (IOException e) {
            e.printStackTrace();
        }

        //changement de la police
        outil.changerFontJLabel(titre, 150, Color.orange, outil.getFontMenu());
        outil.changerFontButton(jeuxSolo, 60, Color.orange, outil.getFontTexte());
        outil.changerFontButton(jeuxMulti, 60, Color.orange, outil.getFontTexte());
        outil.changerFontButton(instructions, 60, Color.orange, outil.getFontTexte());
        outil.changerFontButton(scores, 60, Color.orange, outil.getFontTexte());
        outil.changerFontButton(quitter, 60, Color.orange, outil.getFontTexte());

        panBoutons.setLayout(new GridLayout(6, 1));
        panPrincipal.setLayout(new GridLayout(2, 2));

        panPrincipal.add(panTitre);
        panPrincipal.add(panVide);
        panPrincipal.add(panVide2);
        panPrincipal.add(panBoutons);


        fenetre.setContentPane(panPrincipal);
    }

    public void afficheMenuMulti(){
        JPanel panPrincipal = new JPanel();
        JPanel panTitre = new JPanel();
        JPanel panBoutons = new JPanel();
        JPanel panVide = new JPanel();
        JPanel panVide2 = new JPanel();

        panTitre.add(titre);
        panBoutons.add(multi);
        panBoutons.add(local);
        panBoutons.add(reseau);
        panBoutons.add(annuler);

        panPrincipal.setOpaque(false);
        panTitre.setOpaque(false);
        panBoutons.setOpaque(false);
        panVide.setOpaque(false);
        panVide2.setOpaque(false);

        try {
            panPrincipal = new JPanel() {
                BufferedImage image = ImageIO.read(new File("res/images/fondJungle.jpg"));

                public void paintComponent(Graphics g) {
                    super.paintComponent(g);
                    g.drawImage(image, 0, 0, LARGEUR_FENETRE, HAUTEUR_FENETRE, this);
                }
            };
        } catch (IOException e) {
            e.printStackTrace();
        }

        //changement de la police
        outil.changerFontJLabel(titre, 150, Color.orange, outil.getFontMenu());
        outil.changerFontJLabel(multi, 70, Color.orange, outil.getFontMenu());
        outil.changerFontButton(local, 60, Color.orange, outil.getFontTexte());
        outil.changerFontButton(reseau, 60, Color.orange, outil.getFontTexte());
        outil.changerFontButton(annuler, 60, Color.orange, outil.getFontTexte());

        panBoutons.setLayout(new GridLayout(5, 1));
        panPrincipal.setLayout(new GridLayout(2, 2));

        panPrincipal.add(panTitre);
        panPrincipal.add(panVide);
        panPrincipal.add(panVide2);
        panPrincipal.add(panBoutons);


        fenetre.setContentPane(panPrincipal);
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
            menuMulti();
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
            menu();
        }
    }
}
