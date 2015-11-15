package Siam;

import Siam.Interface.ChoixCamp;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class Game implements Runnable {

    static final Random random = new Random();

    private Plateau plateau;
    private Joueur[] joueurs;
    private ChoixCamp choixCampInterface;

    private static int hauteur = 300;
    private static int largeur = hauteur * 16 / 9;
    private static int echelle = 2;
    private static String titre = "Siam";
    private static Dimension size;

    private Thread thread;
    private JFrame frame;
    private boolean running = false;

    public Game() {
        size = new Dimension(largeur*echelle, hauteur*echelle);

        frame = new JFrame();
        frame.setSize(600, 400);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        joueurs = new Joueur[2];
        joueurs[0] = new Joueur();
        joueurs[1] = new Joueur();
        choixCampInterface = new ChoixCamp(joueurs[0]);
    }

    public synchronized void start() {
        running = true;
        thread = new Thread(this, "Affichage");
        thread.start();
    }

    public synchronized void stop() {
        running = false;
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void run() {
        frame.add(choixCampInterface);
        frame.setVisible(true);
        while(running) {
            render();
        }
        stop();
    }

    public void render() {

    }

    public static void main(String[] args) {
        Game game = new Game();
        game.start();
    }
}
