package Siam.Sons;

import Siam.Enum.Theme;
import javafx.scene.media.AudioClip;

import java.net.URL;
import java.util.HashMap;
import java.util.Random;


public class SoundsLibrary {
    private HashMap<String,AudioClip> soundLibraryStandart;
    private HashMap<String,AudioClip> soundLibraryNoel;
    private static final Random random = new Random();

    public SoundsLibrary (){
        AudioClip boutton = null;

        AudioClip elephant1 = null;
        AudioClip elephant2 = null;
        AudioClip elephant3 = null;

        AudioClip rinhoceros1 = null;
        AudioClip rinhoceros2 = null;
        AudioClip rinhoceros3 = null;

        AudioClip poserPiece = null;
        AudioClip pousserPiece = null;
        try {
            boutton = new AudioClip("file:res/Standard/Bruitage/clique_boutton.wav");

            elephant1 = new AudioClip("file:res/Standard/Bruitage/elephant1.mp3");
            elephant2 = new AudioClip("file:res/Standard/Bruitage/elephant2.mp3");
            elephant3 = new AudioClip("file:res/Standard/Bruitage/elephant3.mp3");

            rinhoceros1 = new AudioClip("file:res/Standard/Bruitage/Rinhoceros1.mp3");
            rinhoceros2 = new AudioClip("file:res/Standard/Bruitage/Rinhoceros2.mp3");
            rinhoceros3 = new AudioClip("file:res/Standard/Bruitage/Rinhoceros3.mp3");

            poserPiece = new AudioClip("file:res/Standard/Bruitage/poserPiece.mp3");
            pousserPiece = new AudioClip("file:res/Standard/Bruitage/pousserPiece.wav");
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }

        //TODO ajouter les sons manquants
        soundLibraryStandart = new HashMap<>();
        soundLibraryStandart.put("boutton", boutton);

        soundLibraryStandart.put("elephant1", elephant1);
        soundLibraryStandart.put("elephant2", elephant2);
        soundLibraryStandart.put("elephant3", elephant3);

        soundLibraryStandart.put("rinhoceros1", rinhoceros1);
        soundLibraryStandart.put("rinhoceros2", rinhoceros2);
        soundLibraryStandart.put("rinhoceros3", rinhoceros3);

        soundLibraryStandart.put("poserPiece", poserPiece);
        soundLibraryStandart.put("pousserPiece", pousserPiece);
    }

    private void playAudio(String name, Theme theme){
        switch(theme){
            case STANDARD:
            {
                AudioClip sample = soundLibraryStandart.get(name);
                sample.play();
                break;
            }

            case NOEL:
            {
                //AudioClip sample = soundLibraryNoel.get(name);
                //sample.play();
                break;
            }
        }
    }

    public void playElephantSound(Theme theme){
        String name = "";
        int rand = random.nextInt(3);
        switch(rand){
            case 0 :
                name = "elephant1";
                break;
            case 1 :
                name = "elephant2";
                break;
            case 2 :
                name = "elephant3";
                break;
        }
        playAudio(name, theme);
        System.out.println("son elephant " + rand);
    }

    public void playRinhocerosSound(Theme theme){
        String name = "";
        int rand = random.nextInt(3);
        switch(rand){
            case 0 :
                name = "rinhoceros1";
                break;
            case 1 :
                name = "rinhoceros2";
                break;
            case 2 :
                name = "rinhoceros3";
                break;
        }
        playAudio(name, theme);
        System.out.println("son rinhoceros " + rand);
    }

    public void playBouttonSound(Theme theme){
        playAudio("boutton", theme);
        System.out.println("son boutton");
    }

    public void playControlSound(Theme theme){
        playAudio("boutton", theme);
        System.out.println("son controle");
    }

    public void playPousseeSound(Theme theme){
        playAudio("pousserPiece", theme);
        System.out.println("son poussee");
    }

    public void playMarcheSound(Theme theme){
        //playAudio("boutton", theme);
        System.out.println("son marche");
    }

    public void playOrientationSound(Theme theme){
        //playAudio("boutton", theme);
        System.out.println("son orientation");
    }

    public void playPoserPieceSound(Theme theme){
        playAudio("poserPiece", theme);
        System.out.println("son poser piece");
    }

    public void playErrorActionSound(Theme theme){
        //playAudio("boutton", theme);
        System.out.println("son erreur");
    }

    public void playSortieSound(Theme theme){
        //playAudio("boutton", theme);
        System.out.println("son sortie");
    }
}
