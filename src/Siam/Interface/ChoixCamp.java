package Siam.Interface;

import Siam.Camp;
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
import java.util.Random;

public class ChoixCamp implements ActionListener, Constantes {

    static final Random random = new Random();

    private Game game;
    private JFrame fenetre;
    private OutilsFont outil;

    private JLabel titreCB;
    private JRadioButton JRBelephant, JRBrhinoceros, aleatoire;
    private ButtonGroup BGchoix;
    private JButton valider, annuler;

    public ChoixCamp(Game game, JFrame fenetre) {
        this.game = game;
        this.fenetre = fenetre;
        outil = new OutilsFont();
        lanceChoixCamp();
        setControlChoixCamp(this);
    }

    public void lanceChoixCamp(){
        initChoixCamp();
        afficheChoixCamp();
        fenetre.setSize(LARGEUR_FENETRE, HAUTEUR_FENETRE);
        fenetre.setLocationRelativeTo(null);
        fenetre.setResizable(false);
        fenetre.setTitle("Siam");
        fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fenetre.setVisible(true);
    }

    public void initChoixCamp(){
        titreCB = new JLabel("Choisis un camp");
        JRBelephant = new JRadioButton("Éléphant", true);
        JRBrhinoceros = new JRadioButton("Rhinocéros");
        aleatoire = new JRadioButton("Aléatoire");
        BGchoix = new ButtonGroup();
        BGchoix.add(JRBelephant);
        BGchoix.add(JRBrhinoceros);
        BGchoix.add(aleatoire);
        valider = new JButton("Valider");
        annuler = new JButton("Annuler");
    }

    public void afficheChoixCamp(){
        JPanel panPrincipal = new JPanel();
        JPanel panTitre = new JPanel();
        JPanel panGBouton = new JPanel();
        JPanel panBouton1 = new JPanel();
        JPanel panBouton2 = new JPanel();
        JPanel panBouton3 = new JPanel();
        JPanel panValiderBouton = new JPanel();

        panPrincipal.setOpaque(false);
        panTitre.setOpaque(false);
        panGBouton.setOpaque(false);
        panBouton1.setOpaque(false);
        panBouton2.setOpaque(false);
        panBouton3.setOpaque(false);
        panValiderBouton.setOpaque(false);

        try {
            panPrincipal = new JPanel() {
                BufferedImage image = ImageIO.read(new File("res/images/menu.png"));

                public void paintComponent(Graphics g) {
                    super.paintComponent(g);
                    g.drawImage(image, 0, 0, LARGEUR_FENETRE, HAUTEUR_FENETRE, this);
                }
            };
        } catch (IOException e) {
            e.printStackTrace();
        }

        //changement de la police
        outil.changerFontJLabel(titreCB, 95, Color.orange, outil.getFontMenu());
        outil.changerFontButton(valider, 80, Color.orange, outil.getFontTexte());
        outil.changerFontButton(annuler, 80, Color.orange, outil.getFontTexte());
        outil.changerFontJRadioButton(JRBelephant, 60, Color.orange, outil.getFontTexte());
        outil.changerFontJRadioButton(JRBrhinoceros, 60, Color.orange, outil.getFontTexte());
        outil.changerFontJRadioButton(aleatoire, 60, Color.orange, outil.getFontTexte());

        panTitre.add(titreCB);
        panBouton1.add(JRBelephant);
        panBouton2.add(JRBrhinoceros);
        panBouton3.add(aleatoire);
        panGBouton.add(panBouton1);
        panGBouton.add(panBouton2);
        panGBouton.add(panBouton3);
        panValiderBouton.add(valider);
        panValiderBouton.add(annuler);

        panGBouton.setLayout(new BoxLayout(panGBouton, BoxLayout.X_AXIS));
        panValiderBouton.setLayout(new GridLayout(1, 2));

        panPrincipal.add(panTitre);
        panPrincipal.add(panGBouton);
        panPrincipal.add(panValiderBouton);
        panPrincipal.setLayout(new BoxLayout(panPrincipal, BoxLayout.Y_AXIS));

        fenetre.setContentPane(panPrincipal);
    }

    public void setControlChoixCamp(ActionListener listener){
        JRBelephant.addActionListener(listener);
        JRBrhinoceros.addActionListener(listener);
        valider.addActionListener(listener);
        annuler.addActionListener(listener);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();

        if (source == getValider())
        {
            if(getJRBelephant().isSelected())game.setJoueurActif(game.getJoueurs()[0]);
            else if (getJRBrhinoceros().isSelected())game.setJoueurActif(game.getJoueurs()[1]);
            else game.setJoueurActif(game.getJoueurs()[random.nextInt(2)]);
            game.start();
        }
        else if (source == getAnnuler()){
            Menu menu = new Menu(game, game.getFenetre());
        }
    }

    public JButton getValider(){
        return valider;
    }

    public JButton getAnnuler(){
        return annuler;
    }

    public JRadioButton getJRBelephant() {
        return JRBelephant;
    }

    public JRadioButton getJRBrhinoceros() {
        return JRBrhinoceros;
    }
}