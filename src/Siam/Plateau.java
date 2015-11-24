package Siam;

import Siam.Interface.Ecran;

import java.util.ArrayList;

public class Plateau {

    private int tailleCote;
    private Case[][] plateau;

    public Plateau(int tailleCote){
        this.tailleCote = tailleCote;
        plateau = new Case[tailleCote][tailleCote];

        for(int y = 0; y < tailleCote; y++){
            for(int x = 0; x < tailleCote; x++) plateau[x][y] = new Case(x,y);
        }

        initMontagne();
    }

    public void initMontagne() {
        plateau[2][2] = new Montagne(2,2);
        plateau[1][2] = new Montagne(1,2);
        plateau[3][2] = new Montagne(3,2);
    }

    public Case getCase(int x, int y) {
        return plateau[x][y];
    }

    public int getTailleCote() {
        return tailleCote;
    }

    public void posePiece(Piece piece) {
        plateau[piece.getAbscisse()][piece.getOrdonnee()] = piece;
    }

    public void sortirPiece(int colonne, int ligne) {
        plateau[colonne][ligne] = new Case(colonne, ligne);
    }

    public void render(Ecran ecran) {
        for(int i = 0; i < tailleCote; i ++){
            for(int j = 0; j < tailleCote; j++){
                getCase(j,i).render(ecran);
            }
        }
    }

    //Methode qui ne test rien, FAIRE LES TESTS AVANT l'appel de cette methode
    public void deplacerPiece(Piece piece, int absTarget, int ordTarget) {
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

    public ArrayList<Piece> getLinePushed(Animal pusher) {
        boolean nextCaseIsNotVoid = true;
        ArrayList<Piece> ret = new ArrayList<>();
        ret.add(pusher);
        int currentAbs = pusher.getAbscisse();
        int currentOrd = pusher.getOrdonnee();
        int ajoutx = 0;
        int ajouty = 0;
        switch(pusher.getOrientation()){
            case BAS:
                ajouty = 1;
                break;
            case HAUT:
                ajouty = -1;
                break;
            case GAUCHE:
                ajoutx = -1;
                break;
            case DROITE:
                ajoutx = 1;
                break;
        }
        while(nextCaseIsNotVoid){
            currentAbs += ajoutx;
            currentOrd += ajouty;

            if(currentAbs < 0 || currentAbs >= tailleCote
                    || currentOrd < 0 || currentOrd >= tailleCote){
                nextCaseIsNotVoid = false;
            }
            else if(getCase(currentAbs, currentOrd).estVide()){
                nextCaseIsNotVoid = false;
            }
            else{
                ret.add((Piece)getCase(currentAbs, currentOrd));
            }
        }
        return ret;
    }

    public TokenSommePoussee calculResultatPoussee(ArrayList<Piece> ligne){
        TokenSommePoussee ret = new TokenSommePoussee();
        Orientation orientationPush = ((Animal)ligne.get(0)).getOrientation();
        Orientation oppose = orientationPush;
        switch(orientationPush){
            case BAS:
                oppose = Orientation.HAUT;
                break;
            case HAUT:
                oppose = Orientation.BAS;
                break;
            case GAUCHE:
                oppose = Orientation.DROITE;
                break;
            case DROITE:
                oppose = Orientation.GAUCHE;
                break;
        }
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
}
