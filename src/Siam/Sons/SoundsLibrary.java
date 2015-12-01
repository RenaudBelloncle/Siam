package Siam.Sons;

import Siam.Enum.Theme;
import javafx.scene.media.AudioClip;

import java.net.URL;
import java.util.HashMap;


public class SoundsLibrary {
    private HashMap<String,AudioClip> soundLibraryStandart;
    private HashMap<String,AudioClip> soundLibraryNoel;

    public SoundsLibrary (){
        AudioClip boutton = null;
        try {
            boutton = new AudioClip("file:res/Standard/Bruitage/clique_boutton.wav");
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }

        //TODO ajouter les sons manquants
        soundLibraryStandart = new HashMap<>(1);
        soundLibraryStandart.put("boutton", boutton);
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
        //playAudio("boutton", theme);
        System.out.println("son elephant");
    }

    public void playRinhocerosSound(Theme theme){
        //playAudio("boutton", theme);
        System.out.println("son rinhoceros");
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
        //playAudio("boutton", theme);
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
        //playAudio("boutton", theme);
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
