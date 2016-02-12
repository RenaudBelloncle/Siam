package siam.audio;

import javazoom.jl.player.Player;

import java.io.FileInputStream;
import java.io.InputStream;

public class MP3 {

    private Player player;
    private InputStream inputStream;

    public MP3(String nom) {
        try {
            inputStream = new FileInputStream(nom);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void play() {
        try {
            player = new Player(inputStream);
            PlayerThread pt = new PlayerThread();
            pt.start();
            while (!player.isComplete()) {
                if (player == null) return;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void stop() {
        player.close();
        player = null;
    }

    class PlayerThread extends Thread {
        public void run() {
            try {
                player.play();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public Player getPlayer() {
        return player;
    }

}