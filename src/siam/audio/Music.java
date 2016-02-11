package siam.audio;

//import Siam.Enum.Theme;

import java.util.Random;

public class Music extends Thread {

    private static Random random = new Random();

    private Thread thread;

    private MP3 dj;
    private String[] standardSounds;
    /*private String[] bandeSonNoel;
    private String[] bandeSonStarWars;

    private Theme theme;*/

    public Music(/*Theme theme*/){
        /*this.theme = theme;*/
        standardSounds = new String[]{"res/audio/songs/Standard1.mp3",
                                        "res/audio/songs/Standard2.mp3",
                                        "res/audio/songs/Standard3.mp3"};
        /*bandeSonNoel = new String[]{"res/Noel/Musiques/Noel1.mp3",
                                    "res/Noel/Musiques/Noel2.mp3",
                                    "res/Noel/Musiques/Noel3.mp3"};
        bandeSonStarWars = new String[]{"res/StarWars/Musiques/StarWars1.mp3",
                                        "res/StarWars/Musiques/StarWars2.mp3",
                                        "res/StarWars/Musiques/StarWars3.mp3",
                                        "res/StarWars/Musiques/StarWars4.mp3",
                                        "res/StarWars/Musiques/StarWars5.mp3",
                                        "res/StarWars/Musiques/StarWars6.mp3"};
                                        */
    }

    public synchronized void start() {
        thread = new Thread(this, "Music");
        thread.start();
    }

    public void run(){
        String[] sounds = standardSounds;
        /*String[] bandeSon = null;
        switch (theme) {
            case STANDARD:
                bandeSon = bandeSonStandard;
                break;
            case NOEL:
                bandeSon = bandeSonNoel;
                break;
            case STARWARS:
                bandeSon = bandeSonStarWars;
                break;
        }*/
        int newCount;
    int count = random.nextInt(sounds.length);
        dj = new MP3(sounds[count]);

        dj.play();

        while (true){

            if (dj == null) {
                return;
            }
            if (dj.getPlayer().isComplete()) {
                newCount = random.nextInt(sounds.length);

                while (count == newCount) {
                    newCount = random.nextInt(sounds.length);
                }

                count = newCount;

                dj = new MP3(sounds[count]);
            }

            dj.play();
        }
    }

    public void stopIt() {
        dj.stop();
        dj = null;
    }
}