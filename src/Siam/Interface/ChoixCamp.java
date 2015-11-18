package Siam.Interface;

import Siam.Game;
import Siam.Joueur;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

public class ChoixCamp extends JFrame implements ActionListener {

    static final Random random = new Random();
    private Game game;
    private Joueur joueur;
    private OutilsFont outil;

    private JLabel titreCB;
    private JRadioButton JRBelephant, JRBrhinoceros, aleatoire;
    private ButtonGroup BGchoix;
    private JButton valider, annuler;

    public ChoixCamp(Game game, Joueur joueur) {
        this.game = game;
        this.joueur = joueur;
        outil = new OutilsFont();
        choixCamp();
        setControlChoixCamp(this);
    }

    public void choixCamp(){
        initChoixCamp();
        afficheChoixCamp();
        setSize(600, 400);
        setLocationRelativeTo(null);
        setResizable(false);
        setTitle("Siam");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void initChoixCamp(){
        titreCB = new JLabel("Choisis un camp");
        JRBelephant = new JRadioButton("Éléphant");
        JRBrhinoceros = new JRadioButton("Rhinocéros");
        aleatoire = new JRadioButton("Aléatoire", true);
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
                    g.drawImage(image, 0, 0, 600, 400, this);
                }
            };
        } catch (IOException e) {
            e.printStackTrace();
        }

        //changement de la police
        outil.changerFontJLabel(titreCB, 60, Color.orange, outil.getFontMenu());
        outil.changerFontButton(valider, 50, Color.orange, outil.getFontTexte());
        outil.changerFontButton(annuler, 50, Color.orange, outil.getFontTexte());
        outil.changerFontJRadioButton(JRBelephant, 35, Color.orange, outil.getFontTexte());
        outil.changerFontJRadioButton(JRBrhinoceros, 35, Color.orange, outil.getFontTexte());
        outil.changerFontJRadioButton(aleatoire, 35, Color.orange, outil.getFontTexte());

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

        setContentPane(panPrincipal);
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

        if (source == getValider()){
            if(getJRBelephant().isSelected()){
                game.setJoueurActif(game.getJoueurs()[0]);
                joueur.setCamp(0);
            }
            else if (getJRBrhinoceros().isSelected()){
                game.setJoueurActif(game.getJoueurs()[1]);
                joueur.setCamp(1);
            }
            else {
                game.setJoueurActif(game.getJoueurs()[random.nextInt(2)]);
                joueur.setCamp(random.nextInt(2));
            }
            game.start(this);
        }
        else if (source == getAnnuler()){
            System.exit(0);
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
