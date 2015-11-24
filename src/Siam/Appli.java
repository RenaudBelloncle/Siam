package Siam;

import Siam.Interface.ChoixCamp;

public class Appli {
    public static void main(String[] args) {
        Game game = new Game();
        new ChoixCamp(game, game.getFenetre());

    }
}
