package Siam;

import Siam.Enum.Camp;
import Siam.Enum.Orientation;
import Siam.Enum.Theme;
import Siam.Enum.TraceType;
import Siam.Interface.Ecran;

import java.io.PrintStream;
import java.util.ArrayList;

public class Plateau {

    private int tailleCote;
    private Case[][] plateau;
    private Jeu jeu;
    private ArrayList <Trace> traceDePas;

    public Plateau(int tailleCote, Jeu jeu){
        this.jeu = jeu;
        this.tailleCote = tailleCote;
        plateau = new Case[tailleCote][tailleCote];

        for(int y = 0; y < tailleCote; y++){
            for(int x = 0; x < tailleCote; x++) plateau[x][y] = new Case(x,y);
        }
        traceDePas = new ArrayList<>();
    }

    public void initMontagne() {
        if(jeu.varianteMontagneActive()){
            plateau[2][2] = new Montagne(2,2, Camp.NEUTRE);
            plateau[1][2] = new Montagne(1,2, Camp.ELEPHANT);
            plateau[3][2] = new Montagne(3,2, Camp.RHINOCEROS);
        }
        else{
            plateau[2][2] = new Montagne(2,2, null);
            plateau[1][2] = new Montagne(1,2, null);
            plateau[3][2] = new Montagne(3,2, null);
        }
    }

    public void setPlateau(Case[][] plateau){
        this.plateau = plateau;
    }

    public Case getCase(int x, int y) {
        return plateau[x][y];
    }

    public int getTailleCote() {
        return tailleCote;
    }

    public void posePiece(Piece piece) {
        plateau[piece.getAbscisse()][piece.getOrdonnee()] = piece;
        traceDePas.add(piece.creerTrace(TraceType.POSE, null));
    }

    public void sortirPiece(int colonne, int ligne) {
        plateau[colonne][ligne] = new Case(colonne, ligne);
    }

    public void affichage(Ecran ecran, Theme theme) {
        for(int i = 0; i < tailleCote; i ++){
            for(int j = 0; j < tailleCote; j++){
                getCase(j,i).affichage(ecran, theme);
            }
        }
    }

    public void deplacerPiece(Piece piece, int absTarget, int ordTarget, TraceType traceType) {
        //TODO fix it ?
        traceDePas.add(piece.creerTrace(traceType, getOrientationWithTargetCoord(piece.getAbscisse(),
                piece.getOrdonnee(), absTarget, ordTarget)));
        piece.setLastPosition(plateau[piece.getAbscisse()][piece.getOrdonnee()]);
        plateau[absTarget][ordTarget] = piece;
        plateau[piece.getAbscisse()][piece.getOrdonnee()] = new Case(piece.getAbscisse(), piece.getOrdonnee());
        piece.setAbscisse(absTarget);
        piece.setOrdonnee(ordTarget);
    }

    public boolean testCaseAdjacente(Case case1, Case case2) {
        int diffAbs = case1.getAbscisse() - case2.getAbscisse();
        int diffOrd = case1.getOrdonnee() - case2.getOrdonnee();
        return (diffAbs == 1 || diffAbs == -1) && diffOrd == 0 || diffAbs == 0 && (diffOrd == 1 || diffOrd == -1);
    }

    public ArrayList<Piece> getLignePoussee(Animal pousseur) {
        boolean caseSuivanteNonVide = true;
        ArrayList<Piece> ret = new ArrayList<>();
        ret.add(pousseur);
        int abscisse = pousseur.getAbscisse();
        int ordonnee = pousseur.getOrdonnee();

        ArrayList <Integer> vector2f = getAjoutXY(pousseur.getOrientation());

        while(caseSuivanteNonVide){
            abscisse += vector2f.get(0);
            ordonnee += vector2f.get(1);

            if(abscisse < 0 || abscisse >= tailleCote
                    || ordonnee < 0 || ordonnee >= tailleCote){
                caseSuivanteNonVide = false;
            }
            else if(getCase(abscisse, ordonnee).estVide()){
                caseSuivanteNonVide = false;
            }
            else{
                ret.add((Piece)getCase(abscisse, ordonnee));
            }
        }
        return ret;
    }

    public TokenSommePoussee calculResultatPoussee(ArrayList<Piece> ligne){
        TokenSommePoussee ret = new TokenSommePoussee();
        Orientation orientationPush = ((Animal)ligne.get(0)).getOrientation();
        Orientation oppose = getOpposeeOrientation(orientationPush);

        for (Piece aLigne : ligne) {
            if (aLigne instanceof Animal) {
                if (((Animal) aLigne).getOrientation() == orientationPush) {
                    ret.addSomme(1);
                }
                if (((Animal) aLigne).getOrientation() == oppose) {
                    ret.addSomme(-1);
                }
            }
            if (aLigne instanceof Montagne) {
                ret.addSomme(-1);
                ret.setPeutEtreNull(true);
            }
        }
        return ret;
    }

    public boolean analyseTokenPoussee(TokenSommePoussee token) {
        return token.getSomme() > 0 || token.getSomme() >= 0 && token.isPeutEtreNull();
    }

    public Piece decalageLigne(ArrayList<Piece> ligne)
    {
        Orientation orientationLigne = ((Animal)ligne.get(0)).getOrientation();
        ArrayList<Integer> vector2f = getAjoutXY(orientationLigne);
        Piece ret = null;

        int absDernierePiece = ligne.get(ligne.size()-1).getAbscisse() + vector2f.get(0);
        int ordDernierePiece = ligne.get(ligne.size()-1).getOrdonnee() + vector2f.get(1);

        if(absDernierePiece < 0 || absDernierePiece >= tailleCote
                || ordDernierePiece < 0 || ordDernierePiece >= tailleCote)
        {
            ret = ligne.get(ligne.size()-1);
        }
        else
        {
            deplacerPiece(ligne.get(ligne.size()-1), absDernierePiece, ordDernierePiece, TraceType.POUSSEE);
        }

        for(int i = ligne.size() - 2; i >= 0 ; i--){
            deplacerPiece(ligne.get(i), ligne.get(i).getAbscisse() + vector2f.get(0),
                    ligne.get(i).getOrdonnee() + vector2f.get(1), TraceType.POUSSEE);
        }
        return ret;
    }

    public Camp trouveCampGagnant(ArrayList <Piece> ligne, Piece montagne){

        if( jeu.varianteMontagneActive()){
            if(montagne.getCamp() == Camp.ELEPHANT) return Camp.RHINOCEROS;
            else if(montagne.getCamp() == Camp.RHINOCEROS) return Camp.ELEPHANT;
            else return Camp.NEUTRE;
        }
        else {
            Animal pousseur;
            pousseur = (Animal)ligne.get(0);
            Animal pieceCourante;
            Orientation orientationPousseur = pousseur.getOrientation();
            for (int i = ligne.size() - 2;i >= 1; i++) {

                if (ligne.get(i) instanceof Animal) {
                    pieceCourante = (Animal)ligne.get(i);
                    if (pieceCourante.getOrientation() == orientationPousseur) {
                        return pieceCourante.getCamp();
                    }
                }
            }
            return pousseur.getCamp();
        }
    }

    public ArrayList<Integer> getAjoutXY(Orientation orientation){
        ArrayList<Integer> vector2f = new ArrayList<>();

        switch(orientation){
            case BAS:
                vector2f.add(0);
                vector2f.add(1);
                break;
            case HAUT:
                vector2f.add(0);
                vector2f.add(-1);
                break;
            case GAUCHE:
                vector2f.add(-1);
                vector2f.add(0);
                break;
            case DROITE:
                vector2f.add(1);
                vector2f.add(0);
                break;
        }
        return vector2f;
    }

    public Orientation getOpposeeOrientation(Orientation orientation){
        switch(orientation){
            case BAS:
                return Orientation.HAUT;
            case HAUT:
                return Orientation.BAS;
            case GAUCHE:
                return Orientation.DROITE;
            case DROITE:
                return Orientation.GAUCHE;
        }
        System.out.println("ERREUR : getOpposeeOrientation : orientation inconnue");
        return null;
    }

    public Orientation getOrientationWithTargetCoord(int currentAbs, int currentOrd,
                                                     int targetAbs, int targetOrd){
        if(currentAbs == targetAbs + 1){
            return Orientation.DROITE;
        }
        if(currentAbs == targetAbs - 1){
            return Orientation.GAUCHE;
        }
        if(currentOrd == targetOrd + 1){
            return Orientation.BAS;
        }
        if(currentOrd == targetOrd - 1){
            return Orientation.HAUT;
        }
        System.out.println("ERREUR : getOrientationWithTargetCoord : orientation inconnue");
        return null;
    }

    public void sauvegarder(PrintStream ps){
        ps.println(tailleCote);
        for(int i = 0; i < tailleCote; i++){
            for(int j = 0; j < tailleCote; j++){
                if(plateau[i][j] instanceof Animal){
                    ps.println(2);
                    plateau[i][j].sauvegarder(ps);
                }
                else if(plateau[i][j] instanceof Montagne){
                    ps.println(1);
                    plateau[i][j].sauvegarder(ps);
                }
                else{
                    ps.println(0);
                    plateau[i][j].sauvegarder(ps);
                }
            }
        }
    }
}