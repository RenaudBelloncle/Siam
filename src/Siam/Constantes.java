package Siam;

public interface Constantes {
    int NOMBRE_CASE_INI = 5;
    int TAILLE_SPRITE = 128;
    int BORDURE_FENETRE = 100;
    int LARGEUR_AFFICHAGE_PLATEAU = TAILLE_SPRITE*NOMBRE_CASE_INI+BORDURE_FENETRE;
    int HAUTEUR_AFFICHAGE_PLATEAU = LARGEUR_AFFICHAGE_PLATEAU;
    int HAUTEUR_FENETRE = LARGEUR_AFFICHAGE_PLATEAU;
    int LARGEUR_FENETRE = HAUTEUR_FENETRE+200;
    int NBTHEMES = 2;

    final String[] tabFond = {"res/images/fondJungle.jpg", "res/images/fondNoel.jpg"};
}
