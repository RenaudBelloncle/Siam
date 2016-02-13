package siam.audio;

import siam.player.Camp;
import siam.player.Theme;

import java.applet.Applet;
import java.applet.AudioClip;
import java.net.URL;
import java.util.HashMap;
import java.util.Random;


public class SoundsLibrary {
    private HashMap<String,AudioClip> soundLibraryStandard;
    private HashMap<String,AudioClip> soundLibraryChristmas;
    private HashMap<String,AudioClip> soundLibraryStarWars;
    private static final Random random = new Random();

    public SoundsLibrary (){
        AudioClip button = null;
        AudioClip error = null;

        // STANDARD
        AudioClip white1 = null;
        AudioClip white2 = null;
        AudioClip white3 = null;

        AudioClip black1 = null;
        AudioClip black2 = null;
        AudioClip black3 = null;

        AudioClip putPiece = null;
        AudioClip out_standard = null;

        AudioClip walk_standard = null;
        AudioClip push_standard = null;
        AudioClip turn_standard = null;

        // CHRISTMAS

        AudioClip snowman1 = null;
        AudioClip snowman2 = null;
        AudioClip snowman3 = null;

        AudioClip deer1 = null;
        AudioClip deer2 = null;
        AudioClip deer3 = null;

        AudioClip putChristmas = null;
        AudioClip out_christmas = null;

        AudioClip walk_deer = null;
        AudioClip walk_snowman = null;
        AudioClip push_christmas = null;
        AudioClip turn_christmas = null;

        // STAR WARS
        AudioClip XWing = null;

        AudioClip TIE1 = null;
        AudioClip TIE2 = null;

        AudioClip putStarWars = null;
        AudioClip out_starwars = null;
        AudioClip walk_starwars = null;
        AudioClip push_starwars = null;
        AudioClip turn_starwars = null;

        AudioClip error_starwars = null;

        try {

            //STANDARD
            String standardPath = "file:res/audio/sounds/";

            button = Applet.newAudioClip(new URL(standardPath + "button.wav"));
            error = Applet.newAudioClip(new URL(standardPath + "error.wav"));

            white1 = Applet.newAudioClip(new URL(standardPath + "white1.mp3"));
            //elephant1.setVolume(0.25);
            white2 = Applet.newAudioClip(new URL(standardPath +  "white2.mp3"));
            //elephant2.setVolume(0.1);
            white3 = Applet.newAudioClip(new URL(standardPath + "white3.mp3"));
            //elephant3.setVolume(0.25);

            black1 = Applet.newAudioClip(new URL(standardPath + "black1.MP3"));
            black2 = Applet.newAudioClip(new URL(standardPath + "black2.MP3"));
            black3 = Applet.newAudioClip(new URL(standardPath + "black3.MP3"));

            putPiece = Applet.newAudioClip(new URL(standardPath + "putPiece.mp3"));
            out_standard = Applet.newAudioClip(new URL(standardPath + "out_standard.wav"));

            walk_standard = Applet.newAudioClip(new URL(standardPath + "walk_standard.wav"));
            push_standard = Applet.newAudioClip(new URL(standardPath + "push_standard.wav"));
            turn_standard = Applet.newAudioClip(new URL(standardPath + "turn_standard.wav"));

            //NOEL
            String christmasPath = "file:res/audio/sounds/";

            snowman1 = Applet.newAudioClip(new URL(christmasPath + "hohoho_1.wav"));
            snowman2 = Applet.newAudioClip(new URL(christmasPath + "hohoho_2.wav"));
            snowman3 = Applet.newAudioClip(new URL(christmasPath + "hohoho_3.wav"));

            deer1 = Applet.newAudioClip(new URL(christmasPath + "gremlin_rire_1.wav"));
            deer2 = Applet.newAudioClip(new URL(christmasPath + "gremlin_2.wav"));
            deer3 = Applet.newAudioClip(new URL(christmasPath + "hahaha_jouet.wav"));

            putChristmas = Applet.newAudioClip(new URL(christmasPath + "apparition_noel.mp3"));
            out_christmas = Applet.newAudioClip(new URL(christmasPath + "sortir_piece_noel_clochette.wav"));
            //sortieNoel.setVolume(0.45);

            walk_deer = Applet.newAudioClip(new URL(christmasPath + "deplacement_renne_raccourci.wav"));
            walk_snowman = Applet.newAudioClip(new URL(christmasPath + "deplacement_bonhomme_raccourci.wav"));
            push_christmas = Applet.newAudioClip(new URL(christmasPath + "poussee_craquement_noel.wav"));
            turn_christmas = Applet.newAudioClip(new URL(christmasPath + "orientation_noel.wav"));
            //orientationNoel.setVolume(0.3);

            // STAR WARS
            String starwarsPath = "file:res/audio/sounds/";

            XWing = Applet.newAudioClip(new URL(starwarsPath + "XWing.WAV"));

            TIE1 = Applet.newAudioClip(new URL(starwarsPath + "TIE1.WAV"));
            TIE2 = Applet.newAudioClip(new URL(starwarsPath + "TIE2.WAV"));

            putStarWars = Applet.newAudioClip(new URL(starwarsPath + "SWPut.WAV"));
            out_starwars = Applet.newAudioClip(new URL(starwarsPath + "SWOut.WAV"));
            walk_starwars = Applet.newAudioClip(new URL(starwarsPath + "SWMarch.WAV"));
            push_starwars = Applet.newAudioClip(new URL(starwarsPath + "SWPush.WAV"));
            turn_starwars = Applet.newAudioClip(new URL(starwarsPath + "SWTurn.WAV"));

            error_starwars = Applet.newAudioClip(new URL(starwarsPath + "SWErr.WAV"));
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }

        //STANDARD
        soundLibraryStandard = new HashMap<>();
        soundLibraryStandard.put("button", button);
        soundLibraryStandard.put("error", error);

        soundLibraryStandard.put("white1", white1);
        soundLibraryStandard.put("white2", white2);
        soundLibraryStandard.put("white3", white3);

        soundLibraryStandard.put("black1", black1);
        soundLibraryStandard.put("black2", black2);
        soundLibraryStandard.put("black3", black3);

        soundLibraryStandard.put("putPiece", putPiece);
        soundLibraryStandard.put("out_standard", out_standard);

        soundLibraryStandard.put("walk_standard_white", walk_standard);
        soundLibraryStandard.put("walk_standard_black", walk_standard);
        soundLibraryStandard.put("push_standard", push_standard);
        soundLibraryStandard.put("turn_standard", turn_standard);

        // NOEL
        soundLibraryChristmas = new HashMap<>();
        soundLibraryChristmas.put("error", error);

        soundLibraryChristmas.put("white1", snowman1);
        soundLibraryChristmas.put("white2", snowman2);
        soundLibraryChristmas.put("white3", snowman3);

        soundLibraryChristmas.put("black1", deer1);
        soundLibraryChristmas.put("black2", deer2);
        soundLibraryChristmas.put("black3", deer3);

        soundLibraryChristmas.put("putPiece", putChristmas);
        soundLibraryChristmas.put("out_standard", out_christmas);

        soundLibraryChristmas.put("walk_standard_white", walk_snowman);
        soundLibraryChristmas.put("walk_standard_black", walk_deer);
        soundLibraryChristmas.put("push_standard", push_christmas);
        soundLibraryChristmas.put("turn_standard", turn_christmas);

        // STARWARS
        soundLibraryStarWars = new HashMap<>();
        soundLibraryStarWars.put("error", error_starwars);

        soundLibraryStarWars.put("white1", XWing);
        soundLibraryStarWars.put("white2", XWing);
        soundLibraryStarWars.put("white3", XWing);

        soundLibraryStarWars.put("black1", TIE1);
        soundLibraryStarWars.put("black2", TIE2);
        soundLibraryStarWars.put("black3", TIE1);

        soundLibraryStarWars.put("putPiece", putStarWars);
        soundLibraryStarWars.put("out_standard", out_starwars);

        soundLibraryStarWars.put("walk_standard_white", walk_starwars);
        soundLibraryStarWars.put("walk_standard_black", walk_starwars);
        soundLibraryStarWars.put("push_standard", push_starwars);
        soundLibraryStarWars.put("turn_standard", turn_starwars);
    }

    private void playAudio(String name, Theme theme){
        AudioClip sample = null;
        sample = soundLibraryStandard.get(name);
        switch(theme){
            case STANDARD:
                sample = soundLibraryStandard.get(name);
                break;
            case CHRISTMAS:
                sample = soundLibraryChristmas.get(name);
                break;
            case STARWARS:
                sample = soundLibraryStarWars.get(name);
                break;
        }
        if(sample != null) sample.play();
    }

    public void playWhiteSound(Theme theme){
        String name = "";
        int rand = random.nextInt(3);
        switch(rand){
            case 0 :
                name = "white1";
                break;
            case 1 :
                name = "white2";
                break;
            case 2 :
                name = "white3";
                break;
        }
        playAudio(name, theme);
    }

    public void playBlackSound(Theme theme){
        String name = "";
        int rand = random.nextInt(3);
        switch(rand){
            case 0 :
                name = "black1";
                break;
            case 1 :
                name = "black2";
                break;
            case 2 :
                name = "black3";
                break;
        }
        playAudio(name, theme);
    }

    public void playButtonSound(Theme theme){
        playAudio("button", theme);
    }

    public void playPushSound(Theme theme) {
        playAudio("push_standard", theme);
    }

    public void playWalkSound(Theme theme,  Camp camp){
        switch (camp){
            case WHITE:
                playAudio("walk_standard_white", theme);
                break;
            case BLACK:
                playAudio("walk_standard_black", theme);
                break;
        }
    }

    public void playTurnSound(Theme theme){
        playAudio("turn_standard", theme);
    }

    public void playPutSound(Theme theme) {
        playAudio("putPiece", theme);
    }

    public void playErrorActionSound(Theme theme){
        playAudio("error", theme);
    }

    public void playOutSound(Theme theme){
        playAudio("out_standard", theme);
    }
}
