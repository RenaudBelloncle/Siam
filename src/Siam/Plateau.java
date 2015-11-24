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
            for(int x = 0; x < tailleCote; x++){
                plateau[x][y] = new Case(x,y);
            }
        }
        plateau[2][2] = new Montagne(2,2);
        plateau[1][2] = new Montagne(1,2);
        plateau[3][2] = new Montagne(3,2);
    }

    public Case getCase(int x, int y){
        return plateau[x][y];
    }

    public int getTailleCote(){
        return tailleCote;
    }

    public void posePiece(Piece piece) {
        plateau[piece.getAbscisse()][piece.getOrdonnee()] = piece;
    }

    public void sortirPiece(int colonne, int ligne) {
        plateau[colonne][ligne] = new Case(colonne, ligne);
    }

    public void render(Ecran ecran){
        for(int i = 0; i < tailleCote; i ++){
            for(int j = 0; j < tailleCote; j++){
                getCase(j,i).render(ecran);
            }
        }
    }

    //Methode qui ne test rien, FAIRE LES TESTS AVANT l'appel de cette methode
    public void deplacerPiece(Piece piece, int absTarget, int ordTarget){
        plateau[absTarget][ordTarget] = piece;
        plateau[piece.getAbscisse()][piece.getOrdonnee()] = new Case(piece.getAbscisse(), piece.getOrdonnee());
        piece.setAbscisse(absTarget);
        piece.setOrdonnee(ordTarget);
    }

    public boolean testCaseAdjacente(Case case1, Case case2){
        int diffAbs = case1.getAbscisse() - case2.getAbscisse();
        int diffOrd = case1.getOrdonnee() - case2.getOrdonnee();

        if((diffAbs == 1 || diffAbs == -1) && diffOrd == 0
        || diffAbs == 0 && (diffOrd == 1 || diffOrd == -1))
        {
            return true;
        }
        return false;
    }

    public ArrayList<Piece> getLinePushed(Animal pusher){
        boolean nextCaseIsNotVoid = true;
        ArrayList<Piece> ret = new ArrayList<Piece>();
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
            else if(getCase(currentAbs, currentOrd).isVoid()){
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
        for(int i = 0; i < ligne.size(); i++){
            if(ligne.get(i) instanceof Animal){
                if(((Animal)ligne.get(i)).getOrientation() == orientationPush){
                    ret.addSomme(1);
                }
                if(((Animal)ligne.get(i)).getOrientation() == oppose){
                    ret.addSomme(-1);
                }
            }
            if(ligne.get(i) instanceof Montagne){
                ret.addSomme(-1);
                ret.setPeutEtreNull(true);
            }
        }
        return ret;
    }

    public boolean analyseTokenPoussee(TokenSommePoussee token){
        if(token.getSomme() > 0){
            return true;
        }

        if(token.getSomme() < 0){
            return false;
        }

        return token.isPeutEtreNull();
    }

    public Piece decalageLigne(ArrayList<Piece> ligne)
    {
        Orientation orientationLigne = ((Animal)ligne.get(0)).getOrientation();
        int ajoutx = 0;
        int ajouty = 0;
        Piece ret = null;

        switch(orientationLigne){
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
        int absDernierePiece = ligne.get(ligne.size()-1).getAbscisse() + ajoutx;
        int ordDernierePiece = ligne.get(ligne.size()-1).getOrdonnee() + ajouty;

        if(absDernierePiece < 0 || absDernierePiece >= tailleCote
                || ordDernierePiece < 0 || ordDernierePiece >= tailleCote)
        {
            ret = ligne.get(ligne.size()-1);
        }
        else
        {
            deplacerPiece(ligne.get(ligne.size()-1), absDernierePiece, ordDernierePiece);
        }

        for(int i = ligne.size() - 2; i >= 0 ; i--){
            deplacerPiece(ligne.get(i), ligne.get(i).getAbscisse() + ajoutx,
                    ligne.get(i).getOrdonnee() + ajouty);
        }
        return ret;
    }
}
