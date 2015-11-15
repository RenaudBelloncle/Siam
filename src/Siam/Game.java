package Siam;

import Siam.Interface.ChoixCamp;

public class Game {

    private Plateau plateau;

    public static void main(String[] args) {
        ChoixCamp vue = new ChoixCamp();
        Joueur joueur = new Joueur();

        vue.setVisible(true);
    }
}
