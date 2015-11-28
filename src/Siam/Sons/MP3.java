package Siam.Sons;

import javazoom.jl.player.Player;

import java.io.FileInputStream;
import java.io.InputStream;

public class MP3 {

    private Player player;
    private InputStream is;

    public MP3(String filename) {
        try {
            is = new FileInputStream(filename);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void play() {
        try {
            player = new Player(is);
            PlayerThread pt = new PlayerThread();
            pt.start();
            while (!player.isComplete()) {}
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void stop() {
        player.close();
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