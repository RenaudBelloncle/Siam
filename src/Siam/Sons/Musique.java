package Siam.Sons;

import java.util.Random;

public class Musique extends Thread{
    MP3 dj;
    String[] bandeSon;
    Random random;
    int compteur;
    int NouvCompteur;


    public Musique (){
        bandeSon = new String[]{"res/Standard/Musiques/Standard1.mp3",
                "res/Standard/Musiques/Standard2.mp3",
                "res/Standard/Musiques/Standard3.mp3"};

        random = new Random();
        compteur = random.nextInt(bandeSon.length);
        dj = new MP3(bandeSon[compteur]);
    }

    public void run(){
        dj.play();

        while (true){

            if (dj.getPlayer().isComplete()){
                NouvCompteur = random.nextInt(bandeSon.length);

                while (compteur == NouvCompteur){
                    NouvCompteur = random.nextInt(bandeSon.length);
                }

                compteur = NouvCompteur;

                dj = new MP3(bandeSon[compteur]);
            }

            dj.play();
        }
    }

    public void arret() {
        dj.stop();
    }
}
