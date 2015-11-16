package Siam;

import Siam.Interface.Ecran;

public class Plateau {
    int tailleCote;
    private Case[][] plateau;

    public Plateau(int tailleCote){
        this.tailleCote = tailleCote;
        plateau = new Case[tailleCote][tailleCote];

        for(int y = 0; y < tailleCote; y++){
            for(int x = 0; x < tailleCote; x++){
                plateau[x][y] = new Case(x,y);
            }
        }
    }

    public Case getCase(int x, int y){
        return plateau[x][y];
    }

    public int getTailleCote(){
        return tailleCote;
    }

    public void render(Ecran ecran){
        for(int i = 0; i < tailleCote; i ++){
            for(int j = 0; j < tailleCote; j++){
                getCase(j,i).render(ecran);
            }
        }
    }
}
