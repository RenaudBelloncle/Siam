package Siam;

import Siam.Interface.Ecran;


public class Joueur {

    private Animal[] animals;
    private int camp;

    public Joueur(int camp){
        animals = new Animal[5];
        this.camp = camp;
    }

    public void posePiece(Case aCase) {
        if (camp == 0) {
            animals[0] = new Animal(aCase,0,0);
            System.out.println("Piece créer");
        } else {
            animals[0] = new Animal(aCase,0,1);
            System.out.println("Piece créer");
        }
    }

    public boolean restePiece() {
        for(Piece piece : animals) if (piece.getPosition() == null) return true;
        return false;
    }

    public void render(Ecran ecran){
        if (animals != null) for(Piece piece : animals) piece.render(ecran);
    }
}
