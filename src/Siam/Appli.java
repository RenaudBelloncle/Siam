package Siam;

import Siam.Interface.Menu;


public class Appli {
    public static void main(String[] args) {
        Game game = new Game();
        Menu menu = new Menu(game, game.getFenetre());

    }
}
