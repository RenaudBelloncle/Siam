package Siam.Sons;

import Siam.Enum.Camp;
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

        try {

            //STANDARD
            String standardPath = "file:res/Standard/Bruitage/";

            boutton = new AudioClip(standardPath + "fall_new.wav");
            erreur = new AudioClip(standardPath + "erreur.wav");

            elephant1 = new AudioClip(standardPath + "elephant1.mp3");
            elephant1.setVolume(0.25);
            elephant2 = new AudioClip(standardPath +  "elephant2.mp3");
            elephant2.setVolume(0.1);
            elephant3 = new AudioClip(standardPath + "elephant3.mp3");
            elephant3.setVolume(0.25);

            rinhoceros1 = new AudioClip(standardPath + "Rinhoceros1.mp3");
            rinhoceros2 = new AudioClip(standardPath + "Rinhoceros2.mp3");
            rinhoceros3 = new AudioClip(standardPath + "Rinhoceros3.mp3");

            poserPieceStandard = new AudioClip(standardPath + "poserPiece.mp3");
            sortieStandard = new AudioClip(standardPath + "sortie_cartoon.wav");

            marcheStandard = new AudioClip(standardPath + "marche_standard.wav");
            pousserPieceStandard = new AudioClip(standardPath + "nouvelle_poussee_standard.wav");
            orienterStandard = new AudioClip(standardPath + "orienter_standard.wav");

            //NOEL
            String noelPath = "file:res/Noel/Bruitage/";

            bonhomme1 = new AudioClip(noelPath + "hohoho_1.wav");
            bonhomme2 = new AudioClip(noelPath + "hohoho_2.wav");
            bonhomme3 = new AudioClip(noelPath + "hohoho_3.wav");

            renne1 = new AudioClip(noelPath + "gremlin_rire_1.wav");
            renne2 = new AudioClip(noelPath + "gremlin_2.wav");
            renne3 = new AudioClip(noelPath + "hahaha_jouet.wav");

            apparitionNoel = new AudioClip(noelPath + "apparition_noel.mp3");
            sortieNoel = new AudioClip(noelPath + "sortir_piece_noel_clochette.wav");
            sortieNoel.setVolume(0.45);

            deplacementRenne = new AudioClip(noelPath + "deplacement_renne_raccourci.wav");
            deplacementBonhomme = new AudioClip(noelPath + "deplacement_bonhomme_raccourci.wav");
            pousseeNoel = new AudioClip(noelPath + "poussee_craquement_noel.wav");
            orientationNoel = new AudioClip(noelPath + "orientation_noel.wav");
            orientationNoel.setVolume(0.3);
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
    }

    private void playAudio(String name, Theme theme){
        switch(theme){
            case STANDARD:
            {
                AudioClip sample = soundLibraryStandart.get(name);
                if(sample != null){
                    sample.play();
                }
                break;
            }

            case NOEL:
            {
                AudioClip sample = soundLibraryNoel.get(name);
                if(sample != null){
                    sample.play();
                }
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
        //System.out.println("son rinhoceros " + rand);
    }

    public void playBouttonSound(Theme theme){
        playAudio("boutton", theme);
        //System.out.println("son boutton");
    }

    public void playControlSound(Theme theme){
        playAudio("boutton", theme);
        //System.out.println("son controle");
    }

    public void playPousseeSound(Theme theme) {
        playAudio("pousserPiece", theme);
        //System.out.println("son poussee");
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
        //System.out.println("son orientation");
    }

    public void playPoserPieceSound(Theme theme) {
        playAudio("poserPiece", theme);
        //System.out.println("son poser piece");
    }

    public void playErrorActionSound(Theme theme){
        playAudio("erreur", theme);
        //System.out.println("son erreur");
    }

    public void playSortieSound(Theme theme){
        playAudio("sortirPiece", theme);
        System.out.println("son sortie");
    }
}
