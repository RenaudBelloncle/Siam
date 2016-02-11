package siam.audio;

//import Siam.Enum.Camp;
//import Siam.Enum.Theme;

import siam.player.Camp;

import java.applet.Applet;
import java.applet.AudioClip;
import java.net.URL;
import java.util.HashMap;
import java.util.Random;


public class SoundsLibrary {
    private HashMap<String,AudioClip> soundLibraryStandard;
    private HashMap<String,AudioClip> soundLibraryNoel;
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

        // NOEL
        /*
        AudioClip bonhomme1 = null;
        AudioClip bonhomme2 = null;
        AudioClip bonhomme3 = null;

        AudioClip renne1 = null;
        AudioClip renne2 = null;
        AudioClip renne3 = null;

        AudioClip apparitionNoel = null;
        AudioClip sortieNoel = null;

        AudioClip deplacementRenne = null;
        AudioClip deplacementBonhomme = null;
        AudioClip pousseeNoel = null;
        AudioClip orientationNoel = null;

        // STAR WARS
        AudioClip XWing = null;

        AudioClip TIE1 = null;
        AudioClip TIE2 = null;

        AudioClip poserStarWars = null;
        AudioClip sortirStarWars = null;
        AudioClip deplacerStarWars = null;
        AudioClip pousseeStarWars = null;
        AudioClip orienterStarWars = null;

        AudioClip erreurStarWars = null;
*/
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
/*
            //NOEL
            String noelPath = "file:res/Noel/Bruitage/";

            bonhomme1 = Applet.newAudioClip(new URL(noelPath + "hohoho_1.wav"));
            bonhomme2 = Applet.newAudioClip(new URL(noelPath + "hohoho_2.wav"));
            bonhomme3 = Applet.newAudioClip(new URL(noelPath + "hohoho_3.wav"));

            renne1 = Applet.newAudioClip(new URL(noelPath + "gremlin_rire_1.wav"));
            renne2 = Applet.newAudioClip(new URL(noelPath + "gremlin_2.wav"));
            renne3 = Applet.newAudioClip(new URL(noelPath + "hahaha_jouet.wav"));

            apparitionNoel = Applet.newAudioClip(new URL(noelPath + "apparition_noel.mp3"));
            sortieNoel = Applet.newAudioClip(new URL(noelPath + "sortir_piece_noel_clochette.wav"));
            //sortieNoel.setVolume(0.45);

            deplacementRenne = Applet.newAudioClip(new URL(noelPath + "deplacement_renne_raccourci.wav"));
            deplacementBonhomme = Applet.newAudioClip(new URL(noelPath + "deplacement_bonhomme_raccourci.wav"));
            pousseeNoel = Applet.newAudioClip(new URL(noelPath + "poussee_craquement_noel.wav"));
            orientationNoel = Applet.newAudioClip(new URL(noelPath + "orientation_noel.wav"));
            //orientationNoel.setVolume(0.3);

            // STAR WARS
            String starwarsPath = "file:res/StarWars/Bruitages/";

            XWing = Applet.newAudioClip(new URL(starwarsPath + "XWing.WAV"));

            TIE1 = Applet.newAudioClip(new URL(starwarsPath + "TIE1.WAV"));
            TIE2 = Applet.newAudioClip(new URL(starwarsPath + "TIE2.WAV"));

            poserStarWars = Applet.newAudioClip(new URL(starwarsPath + "SWPoserPiece.WAV"));
            sortirStarWars = Applet.newAudioClip(new URL(starwarsPath + "SWSortie.WAV"));
            deplacerStarWars = Applet.newAudioClip(new URL(starwarsPath + "SWMarch.WAV"));
            pousseeStarWars = Applet.newAudioClip(new URL(starwarsPath + "SWPousser.WAV"));
            orienterStarWars = Applet.newAudioClip(new URL(starwarsPath + "SWOrienter.WAV"));

            erreurStarWars = Applet.newAudioClip(new URL(starwarsPath + "SWErr.WAV"));*/
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
/*
        // NOEL
        soundLibraryNoel = new HashMap<>();
        soundLibraryNoel.put("erreur", erreur);

        soundLibraryNoel.put("elephant1", bonhomme1);
        soundLibraryNoel.put("elephant2", bonhomme2);
        soundLibraryNoel.put("elephant3", bonhomme3);

        soundLibraryNoel.put("rinhoceros1", renne1);
        soundLibraryNoel.put("rinhoceros2", renne2);
        soundLibraryNoel.put("rinhoceros3", renne3);

        soundLibraryNoel.put("poserPiece", apparitionNoel);
        soundLibraryNoel.put("sortirPiece", sortieNoel);

        soundLibraryNoel.put("deplacerPieceElephant", deplacementBonhomme);
        soundLibraryNoel.put("deplacerPieceRinhoceros", deplacementRenne);
        soundLibraryNoel.put("pousserPiece", pousseeNoel);
        soundLibraryNoel.put("orienterPiece", orientationNoel);

        // STARWARS
        soundLibraryStarWars = new HashMap<>();
        soundLibraryStarWars.put("erreur", erreurStarWars);

        soundLibraryStarWars.put("elephant1", XWing);
        soundLibraryStarWars.put("elephant2", XWing);
        soundLibraryStarWars.put("elephant3", XWing);

        soundLibraryStarWars.put("rinhoceros1", TIE1);
        soundLibraryStarWars.put("rinhoceros2", TIE2);
        soundLibraryStarWars.put("rinhoceros3", TIE1);

        soundLibraryStarWars.put("poserPiece", poserStarWars);
        soundLibraryStarWars.put("sortirPiece", sortirStarWars);

        soundLibraryStarWars.put("deplacerPieceElephant", deplacerStarWars);
        soundLibraryStarWars.put("deplacerPieceRinhoceros", deplacerStarWars);
        soundLibraryStarWars.put("pousserPiece", pousseeStarWars);
        soundLibraryStarWars.put("orienterPiece", orienterStarWars);*/
    }

    private void playAudio(String name/*, Theme theme*/){
        AudioClip sample = null;
        sample = soundLibraryStandard.get(name);
        /*switch(theme){
            case STANDARD:
                sample = soundLibraryStandart.get(name);
                break;
            case NOEL:
                sample = soundLibraryNoel.get(name);
                break;
            case STARWARS:
                sample = soundLibraryStarWars.get(name);
                break;
        }*/
        if(sample != null) sample.play();
    }

    public void playWhiteSound(/*Theme theme*/){
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
        playAudio(name/*, theme*/);
    }

    public void playBlackSound(/*Theme theme*/){
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
        playAudio(name/*, theme*/);
    }

    public void playButtonSound(/*Theme theme*/){
        playAudio("button"/*, theme*/);
    }

    public void playControlSound(/*Theme theme*/){
        playAudio("button"/*, theme*/);
    }

    public void playPushSound(/*Theme theme*/) {
        playAudio("push_standard"/*, theme*/);
    }

    public void playWalkSound(/*Theme theme, */ Camp camp){
        switch (camp){
            case WHITE:
                playAudio("walk_standard_white"/*, theme*/);
                break;
            case BLACK:
                playAudio("walk_standard_black"/*, theme*/);
                break;
        }
    }

    public void playTurnSound(/*Theme theme*/){
        playAudio("turn_standard"/*, theme*/);
    }

    public void playPutSound(/*Theme theme*/) {
        playAudio("putPiece"/*, theme*/);
    }

    public void playErrorActionSound(/*Theme theme*/){
        playAudio("error"/*, theme*/);
    }

    public void playOutSound(/*Theme theme*/){
        playAudio("out_standard"/*, theme*/);
    }
}
