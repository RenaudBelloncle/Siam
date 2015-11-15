package Siam;

import java.util.Random;

public class Game implements Runnable {

    static final Random random = new Random();

    private Plateau plateau;
    private Joueur[] joueurs;

    private Thread thread;
    private boolean running = false;

    public Game() {
        joueurs = new Joueur[2];
        joueurs[0] = new Joueur();
        joueurs[1] = new Joueur();
    }

    public Joueur[] getJoueurs() {
        return joueurs;
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
        while(running) {
            update();
            render();
        }
        stop();
    }

    public void update() {

    }

    public void render() {

    }
}
