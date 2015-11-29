package Siam;

import Siam.Interface.Menu;

public class Appli {
    public static void main(String[] args) {
        Jeu jeu = new Jeu();
        new Menu(jeu, jeu.getFenetre(), jeu.getTheme(),jeu.getMusique(), jeu.isSon());
    }
}