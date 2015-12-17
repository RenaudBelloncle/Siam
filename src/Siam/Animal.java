package Siam;

import Siam.Enum.Camp;
import Siam.Enum.Orientation;
import Siam.Enum.Theme;
import Siam.Enum.TraceType;
import Siam.Interface.Ecran;
import Siam.Interface.Sprite;

import java.io.PrintStream;

public class Animal extends Piece {

    private Orientation orientation;
    private boolean selectionnee;

    public Animal(int abscisse, int ordonnee, Orientation orientation, Camp camp, boolean selectionnee) {
        super(abscisse, ordonnee, camp);
        this.orientation = orientation;
        this.selectionnee = selectionnee;
    }

    public Animal(int abscisse, int ordonnee,Camp camp) {
        super(abscisse, ordonnee, camp);
        this.selectionnee = false;
    }

    public Orientation getOrientation() {
        return orientation;
    }

    public void setOrientation(Orientation orientation) {
        this.orientation = orientation;
    }

    public boolean estSelectionnee() {
        return selectionnee;
    }

    public void setSelectionnee(boolean selectionnee) {
        this.selectionnee = selectionnee;
    }

    public void affichage(Ecran ecran, Theme theme) {
        switch (theme) {
            case STANDARD:
                ecran.affichageSprite(getAbscisse(), getOrdonnee(), Sprite.StandardCaseVide,false,false);
                break;
            case NOEL:
                ecran.affichageSprite(getAbscisse(), getOrdonnee(), Sprite.NoelCaseVide,false,false);
                break;
            case STARWARS:
                ecran.affichageSprite(getAbscisse(), getOrdonnee(), Sprite.StarWarsCaseVide,false,false);
                break;
        }
        switch (camp) {
            case ELEPHANT:
                switch (orientation) {
                    case HAUT:
                        switch (theme) {
                            case STANDARD:
                                ecran.affichageSprite(getAbscisse(), getOrdonnee(), Sprite.StandardCasePionJoueur1, false, false);
                                break;
                            case NOEL:
                                ecran.affichageSprite(getAbscisse(), getOrdonnee(), Sprite.NoelCasePionJoueur1, false, false);
                                break;
                            case STARWARS:
                                ecran.affichageSprite(getAbscisse(), getOrdonnee(), Sprite.StarWarsCasePionJoueur1, false, false);
                                break;
                        }
                        break;
                    case BAS:
                        switch (theme) {
                            case STANDARD:
                                ecran.affichageSprite(getAbscisse(), getOrdonnee(), Sprite.StandardCasePionJoueur1, false, true);
                                break;
                            case NOEL:
                                ecran.affichageSprite(getAbscisse(), getOrdonnee(), Sprite.NoelCasePionJoueur1, false, true);
                                break;
                            case STARWARS:
                                ecran.affichageSprite(getAbscisse(), getOrdonnee(), Sprite.StarWarsCasePionJoueur1, false, true);
                                break;
                        }
                        break;
                    case GAUCHE:
                        switch (theme) {
                            case STANDARD:
                                ecran.affichageSprite(getAbscisse(), getOrdonnee(), Sprite.StandardCasePionJoueur1Gauche, false, false);
                                break;
                            case NOEL:
                                ecran.affichageSprite(getAbscisse(), getOrdonnee(), Sprite.NoelCasePionJoueur1Gauche, false, false);
                                break;
                            case STARWARS:
                                ecran.affichageSprite(getAbscisse(), getOrdonnee(), Sprite.StarWarsCasePionJoueur1Gauche, false, false);
                                break;
                        }
                        break;
                    case DROITE:
                        switch (theme) {
                            case STANDARD:
                                ecran.affichageSprite(getAbscisse(), getOrdonnee(), Sprite.StandardCasePionJoueur1Gauche, true, false);
                                break;
                            case NOEL:
                                ecran.affichageSprite(getAbscisse(), getOrdonnee(), Sprite.NoelCasePionJoueur1Gauche, true, false);
                                break;
                            case STARWARS:
                                ecran.affichageSprite(getAbscisse(), getOrdonnee(), Sprite.StarWarsCasePionJoueur1Gauche, true, false);
                                break;
                        }
                        break;
                }
                break;
            case RHINOCEROS:
                switch (orientation) {
                    case HAUT:
                        switch (theme) {
                            case STANDARD:
                                ecran.affichageSprite(getAbscisse(), getOrdonnee(), Sprite.StandardCasePionJoueur2, false, false);
                                break;
                            case NOEL:
                                ecran.affichageSprite(getAbscisse(), getOrdonnee(), Sprite.NoelCasePionJoueur2, false, false);
                                break;
                            case STARWARS:
                                ecran.affichageSprite(getAbscisse(), getOrdonnee(), Sprite.StarWarsCasePionJoueur2, false, false);
                                break;
                        }
                        break;
                    case BAS:
                        switch (theme) {
                            case STANDARD:
                                ecran.affichageSprite(getAbscisse(), getOrdonnee(), Sprite.StandardCasePionJoueur2, false, true);
                                break;
                            case NOEL:
                                ecran.affichageSprite(getAbscisse(), getOrdonnee(), Sprite.NoelCasePionJoueur2, false, true);
                                break;
                            case STARWARS:
                                ecran.affichageSprite(getAbscisse(), getOrdonnee(), Sprite.StarWarsCasePionJoueur2, false, true);
                                break;
                        }
                        break;
                    case GAUCHE:
                        switch (theme) {
                            case STANDARD:
                                ecran.affichageSprite(getAbscisse(), getOrdonnee(), Sprite.StandardCasePionJoueur2Gauche, false, false);
                                break;
                            case NOEL:
                                ecran.affichageSprite(getAbscisse(), getOrdonnee(), Sprite.NoelCasePionJoueur2Gauche, false, false);
                                break;
                            case STARWARS:
                                ecran.affichageSprite(getAbscisse(), getOrdonnee(), Sprite.StarWarsCasePionJoueur2Gauche, false, false);
                                break;
                        }
                        break;
                    case DROITE:
                        switch (theme) {
                            case STANDARD:
                                ecran.affichageSprite(getAbscisse(), getOrdonnee(), Sprite.StandardCasePionJoueur2Gauche, true, false);
                                break;
                            case NOEL:
                                ecran.affichageSprite(getAbscisse(), getOrdonnee(), Sprite.NoelCasePionJoueur2Gauche, true, false);
                                break;
                            case STARWARS:
                                ecran.affichageSprite(getAbscisse(), getOrdonnee(), Sprite.StarWarsCasePionJoueur2Gauche, true, false);
                                break;
                        }
                        break;
                }
                break;
        }
        if (selectionnee) {
            switch (theme) {
                case STANDARD:
                    ecran.affichageSprite(getAbscisse(), getOrdonnee(), Sprite.StandardFocus, false, false);
                    break;
                case NOEL:
                    ecran.affichageSprite(getAbscisse(), getOrdonnee(), Sprite.NoelFocus, false, false);
                    break;
                case STARWARS:
                    ecran.affichageSprite(getAbscisse(), getOrdonnee(), Sprite.StarWarsFocus, false, false);
                    break;
            }
        }
    }

    public boolean estVide() {
        return false;
    }

    public Trace creerTrace(TraceType traceType, Orientation direction){
        return new Trace(getAbscisse(), getOrdonnee(), direction, getOrientation(), traceType, getCamp());
    }

    public void sauvegarder(PrintStream ps){
        super.sauvegarder(ps);
        ps.println(orientation);
    }
}