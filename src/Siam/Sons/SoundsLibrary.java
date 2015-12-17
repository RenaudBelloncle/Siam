package Siam.Sons;

import Siam.Enum.Camp;
import Siam.Enum.Theme;

import java.applet.Applet;
import java.applet.AudioClip;
import java.net.URL;
import java.util.HashMap;
import java.util.Random;


public class SoundsLibrary {
    private HashMap<String,AudioClip> soundLibraryStandart;
    private HashMap<String,AudioClip> soundLibraryNoel;
    private HashMap<String,AudioClip> soundLibraryStarWars;
    private static final Random random = new Random();

    public SoundsLibrary (){
        AudioClip boutton = null;
        AudioClip erreur = null;

        // STANDARD
        AudioClip elephant1 = null;
        AudioClip elephant2 = null;
        AudioClip elephant3 = null;

        AudioClip rinhoceros1 = null;
        AudioClip rinhoceros2 = null;
        AudioClip rinhoceros3 = null;

        AudioClip poserPieceStandard = null;
        AudioClip sortieStandard = null;

        AudioClip marcheStandard = null;
        AudioClip pousserPieceStandard = null;
        AudioClip orienterStandard = null;

        // NOEL
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

        try {

            //STANDARD
            String standardPath = "file:res/Standard/Bruitage/";

            boutton = Applet.newAudioClip(new URL(standardPath + "fall_new.wav"));
            erreur = Applet.newAudioClip(new URL(standardPath + "erreur.wav"));

            elephant1 = Applet.newAudioClip(new URL(standardPath + "elephant1.mp3"));
            //elephant1.setVolume(0.25);
            elephant2 = Applet.newAudioClip(new URL(standardPath +  "elephant2.mp3"));
            //elephant2.setVolume(0.1);
            elephant3 = Applet.newAudioClip(new URL(standardPath + "elephant3.mp3"));
            //elephant3.setVolume(0.25);

            rinhoceros1 = Applet.newAudioClip(new URL(standardPath + "Rinhoceros1.mp3"));
            rinhoceros2 = Applet.newAudioClip(new URL(standardPath + "Rinhoceros2.mp3"));
            rinhoceros3 = Applet.newAudioClip(new URL(standardPath + "Rinhoceros3.mp3"));

            poserPieceStandard = Applet.newAudioClip(new URL(standardPath + "poserPiece.mp3"));
            sortieStandard = Applet.newAudioClip(new URL(standardPath + "sortie_cartoon.wav"));

            marcheStandard = Applet.newAudioClip(new URL(standardPath + "marche_standard.wav"));
            pousserPieceStandard = Applet.newAudioClip(new URL(standardPath + "nouvelle_poussee_standard.wav"));
            orienterStandard = Applet.newAudioClip(new URL(standardPath + "orienter_standard.wav"));

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

            erreurStarWars = Applet.newAudioClip(new URL(starwarsPath + "SWErr.WAV"));
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }

        //STANDARD
        soundLibraryStandart = new HashMap<>();
        soundLibraryStandart.put("boutton", boutton);
        soundLibraryStandart.put("erreur", erreur);

        soundLibraryStandart.put("elephant1", elephant1);
        soundLibraryStandart.put("elephant2", elephant2);
        soundLibraryStandart.put("elephant3", elephant3);

        soundLibraryStandart.put("rinhoceros1", rinhoceros1);
        soundLibraryStandart.put("rinhoceros2", rinhoceros2);
        soundLibraryStandart.put("rinhoceros3", rinhoceros3);

        soundLibraryStandart.put("poserPiece", poserPieceStandard);
        soundLibraryStandart.put("sortirPiece", sortieStandard);

        soundLibraryStandart.put("deplacerPieceElephant", marcheStandard);
        soundLibraryStandart.put("deplacerPieceRinhoceros", marcheStandard);
        soundLibraryStandart.put("pousserPiece", pousserPieceStandard);
        soundLibraryStandart.put("orienterPiece", orienterStandard);

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
        soundLibraryStarWars.put("orienterPiece", orienterStarWars);
    }

    private void playAudio(String name, Theme theme){
        AudioClip sample = null;
        switch(theme){
            case STANDARD:
                sample = soundLibraryStandart.get(name);
                break;
            case NOEL:
                sample = soundLibraryNoel.get(name);
                break;
            case STARWARS:
                sample = soundLibraryStarWars.get(name);
                break;
        }
        if(sample != null) sample.play();
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
    }

    public void playBouttonSound(Theme theme){
        playAudio("boutton", theme);
    }

    public void playControlSound(Theme theme){
        playAudio("boutton", theme);
    }

    public void playPousseeSound(Theme theme) {
        playAudio("pousserPiece", theme);
    }

    public void playMarcheSound(Theme theme, Camp camp){
        switch (camp){
            case ELEPHANT:
                playAudio("deplacerPieceElephant", theme);
                break;
            case RHINOCEROS:
                playAudio("deplacerPieceRinhoceros", theme);
                break;
        }
    }

    public void playOrientationSound(Theme theme){
        playAudio("orienterPiece", theme);
    }

    public void playPoserPieceSound(Theme theme) {
        playAudio("poserPiece", theme);
    }

    public void playErrorActionSound(Theme theme){
        playAudio("erreur", theme);
    }

    public void playSortieSound(Theme theme){
        playAudio("sortirPiece", theme);
    }
}
