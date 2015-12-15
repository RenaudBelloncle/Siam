package Siam;

import Siam.Enum.Camp;
import Siam.Enum.Orientation;
import Siam.Enum.Theme;
import Siam.Enum.TraceType;
import Siam.Interface.Ecran;
import Siam.Interface.Sprite;

import static Siam.Enum.Camp.ELEPHANT;

public class Trace extends Case {

    private Sprite sprite;

    public Trace(int abscisse, int ordonnee, Orientation direction_orientation,
                 Orientation orientation_piece, TraceType traceType, Camp camp) {
        super(abscisse, ordonnee);
        initSprite(direction_orientation, orientation_piece, traceType, camp);
    }

    public void affichage(Ecran ecran, Theme theme){
        //TODO
        ecran.affichageSprite(getAbscisse(), getOrdonnee(), sprite, false, false);
    }

    public void initSprite(Orientation direction_orientation,
                           Orientation orientation_piece,
                           TraceType traceType, Camp camp){
        //TODO
        switch(traceType){
            case POSE : {
                if (camp == Camp.MONTAGNE) {
                    sprite = null;
                } else if (camp == ELEPHANT) {
                    sprite = null;
                } else {
                    sprite = null;
                }
                break;
            }

            case MARCHE : {
                if (camp == Camp.ELEPHANT) {
                    switch (direction_orientation) {
                        case BAS:
                            sprite = null;
                            break;
                        case HAUT:
                            sprite = null;
                            break;
                        case GAUCHE:
                            sprite = null;
                            break;
                        case DROITE:
                            sprite = null;
                            break;
                    }
                } else if(camp == Camp.RHINOCEROS) {
                    switch (direction_orientation) {
                        case BAS:
                            sprite = null;
                            break;
                        case HAUT:
                            sprite = null;
                            break;
                        case GAUCHE:
                            sprite = null;
                            break;
                        case DROITE:
                            sprite = null;
                            break;
                    }
                }
                break;
            }
            case POUSSEE : {
                if (camp == Camp.MONTAGNE) {
                    switch (direction_orientation) {
                        case BAS:
                            sprite = null;
                            break;
                        case HAUT:
                            sprite = null;
                            break;
                        case GAUCHE:
                            sprite = null;
                            break;
                        case DROITE:
                            sprite = null;
                            break;
                    }
                } else if (camp == ELEPHANT) {
                    if(direction_orientation == orientation_piece ||
                            sontOpposee(direction_orientation, orientation_piece))
                    {
                        switch (direction_orientation) {
                            case BAS:
                                sprite = null;
                                break;
                            case HAUT:
                                sprite = null;
                                break;
                            case GAUCHE:
                                sprite = null;
                                break;
                            case DROITE:
                                sprite = null;
                                break;
                        }
                    }
                    else
                    {
                        switch (direction_orientation) {
                            case BAS:
                                sprite = null;
                                break;
                            case HAUT:
                                sprite = null;
                                break;
                            case GAUCHE:
                                sprite = null;
                                break;
                            case DROITE:
                                sprite = null;
                                break;
                        }
                    }
                } else {
                    if(direction_orientation == orientation_piece ||
                            sontOpposee(direction_orientation, orientation_piece))
                    {
                        switch (direction_orientation) {
                            case BAS:
                                sprite = null;
                                break;
                            case HAUT:
                                sprite = null;
                                break;
                            case GAUCHE:
                                sprite = null;
                                break;
                            case DROITE:
                                sprite = null;
                                break;
                        }
                    }
                    else
                    {
                        switch (direction_orientation) {
                            case BAS:
                                sprite = null;
                                break;
                            case HAUT:
                                sprite = null;
                                break;
                            case GAUCHE:
                                sprite = null;
                                break;
                            case DROITE:
                                sprite = null;
                                break;
                        }
                    }
                }
                break;
            }
        }
    }

    public boolean sontOpposee(Orientation o1, Orientation o2){
        switch(o1){
            case BAS :
                return o2 == Orientation.HAUT;
            case HAUT:
                return o2 == Orientation.BAS;
            case GAUCHE:
                return o2 == Orientation.DROITE;
            case DROITE:
                return o2 == Orientation.GAUCHE;
        }
        System.out.println("ERREUR DANS L'APPEL DE LA FONCTION SONTOPPOSEE");
        return false;
    }
}
