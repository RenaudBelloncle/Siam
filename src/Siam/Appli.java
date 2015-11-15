package Siam;

import Siam.Interface.ChoixCamp;

public class Appli {
    public static void main(String[] args) {
        Game game = new Game();
        ChoixCamp choixCamp = new ChoixCamp(game, game.getJoueurs()[0]);
        choixCamp.setVisible(true);
    }
}
