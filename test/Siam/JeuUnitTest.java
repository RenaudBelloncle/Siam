package Siam;

import Siam.Enum.Camp;
import Siam.Enum.Theme;
import Siam.Interface.VueJeu;
import Siam.Sons.Musique;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import javax.swing.*;

public class JeuUnitTest {

    private Jeu jeu;

    @Before
    public void setUp() {
        jeu = new Jeu();
    }

    @Test
    public void testGetPlateau() {
        Plateau plateau = Mockito.mock(Plateau.class);
        jeu = new Jeu(plateau);
        Assert.assertSame(plateau, jeu.getPlateau());
    }

    @Test
    public void testGetJoueurs() {
        Joueur[] joueurs = new Joueur[2];
        joueurs[0] = Mockito.mock(Joueur.class);
        joueurs[1] = Mockito.mock(Joueur.class);
        jeu = new Jeu(joueurs[0], joueurs[1], false, false, false, false, false, false, false, null, null, null, null, new Musique(Theme.STANDARD), false);
        Assert.assertArrayEquals(joueurs, jeu.getJoueurs());
    }

    @Test
    public void testIsPieceSelectionnee() {
        jeu = new Jeu(new Joueur(Camp.ELEPHANT), new Joueur(Camp.RHINOCEROS), false, false, false, false, false, false, false, null, null, null, null, new Musique(Theme.STANDARD), false);
        Assert.assertFalse(jeu.isPieceSelectionnee());
    }

    @Test
    public void testSetPieceSelectionnee() {
        jeu.setPieceSelectionnee(true);
        Assert.assertTrue(jeu.isPieceSelectionnee());
    }

    @Test
    public void testIsPlacerPiece() {
        jeu = new Jeu(new Joueur(Camp.ELEPHANT), new Joueur(Camp.RHINOCEROS), false, false, false, false, false, false, false, null, null, null, null, new Musique(Theme.STANDARD), false);
        Assert.assertFalse(jeu.isPlacerPiece());
    }

    @Test
    public void testSetPlacerPiece() {
        jeu.setPlacerPiece(true);
        Assert.assertTrue(jeu.isPlacerPiece());
    }

    @Test
    public void testIsSortirPiece() {
        jeu = new Jeu(new Joueur(Camp.ELEPHANT), new Joueur(Camp.RHINOCEROS), false, false, false, false, false, false, false, null, null, null, null, new Musique(Theme.STANDARD), false);
        Assert.assertFalse(jeu.isSortirPiece());
    }

    @Test
    public void testSetSortirPiece() {
        jeu.setSortirPiece(true);
        Assert.assertTrue(jeu.isSortirPiece());
    }

    @Test
    public void testIsDeplacerPiece() {
        jeu = new Jeu(new Joueur(Camp.ELEPHANT), new Joueur(Camp.RHINOCEROS), false, false, false, false, false, false, false, null, null, null, null, new Musique(Theme.STANDARD), false);
        Assert.assertFalse(jeu.isDeplacerPiece());
    }

    @Test
    public void testSetDeplacerPiece() {
        jeu.setDeplacerPiece(true);
        Assert.assertTrue(jeu.isDeplacerPiece());
    }

    @Test
    public void testIsChangerOrientation() {
        jeu = new Jeu(new Joueur(Camp.ELEPHANT), new Joueur(Camp.RHINOCEROS), false, false, false, false, false, false, false, null, null, null, null, new Musique(Theme.STANDARD), false);
        Assert.assertFalse(jeu.isChangerOrientation());
    }

    @Test
    public void testSetChangerOrientation() {
        jeu.setChangerOrientation(true);
        Assert.assertTrue(jeu.isChangerOrientation());
    }

    @Test
    public void testIsSelectionnerOrientation() {
        jeu = new Jeu(new Joueur(Camp.ELEPHANT), new Joueur(Camp.RHINOCEROS), false, false, false, false, false, false, false, null, null, null, null, new Musique(Theme.STANDARD), false);
        Assert.assertFalse(jeu.isSelectionnerOrientation());
    }

    @Test
    public void testSetSelectionnerOrientation() {
        jeu.setSelectionnerOrientation(true);
        Assert.assertTrue(jeu.isSelectionnerOrientation());
    }

    @Test
    public void testIsEnCoursDeDeplacement() {
        jeu = new Jeu(new Joueur(Camp.ELEPHANT), new Joueur(Camp.RHINOCEROS), false, false, false, false, false, false, false, null, null, null, null, new Musique(Theme.STANDARD), false);
        Assert.assertFalse(jeu.isEnCoursDeDeplacement());
    }

    @Test
    public void testSetEnCoursDeDeplacement() {
        jeu.setEnCoursDeDeplacement(true);
        Assert.assertTrue(jeu.isEnCoursDeDeplacement());
    }

    @Test
    public void testGetJoueurActif() {
        Joueur joueur1 = Mockito.mock(Joueur.class);
        Joueur joueur2 = Mockito.mock(Joueur.class);
        jeu = new Jeu(joueur1, joueur2, false, false, false, false, false, false, false, null, null, null, null, new Musique(Theme.STANDARD), false);
        Assert.assertSame(joueur1, jeu.getJoueurActif());
    }

    @Test
    public void testSetJoueurActif() {
        Joueur joueur = Mockito.mock(Joueur.class);
        jeu.setJoueurActif(joueur);
        Assert.assertSame(joueur, jeu.getJoueurActif());
    }

    @Test
    public void testGetAnimalSelectionnee() {
        Animal animal = Mockito.mock(Animal.class);
        jeu = new Jeu(new Joueur(Camp.ELEPHANT), new Joueur(Camp.RHINOCEROS), false, false, false, false, false, false, false, animal, null, null, null, new Musique(Theme.STANDARD), false);
        Assert.assertSame(animal, jeu.getAnimalSelectionnee());
    }

    @Test
    public void testSetAnimalSelectionne() {
        Animal animal = Mockito.mock(Animal.class);
        jeu.setAnimalSelectionnee(animal);
        Assert.assertSame(animal, jeu.getAnimalSelectionnee());
    }

    @Test
    public void testChangerJoueursActif() {
        Joueur joueur1 = Mockito.mock(Joueur.class);
        Joueur joueur2 = Mockito.mock(Joueur.class);
        jeu = new Jeu(joueur1, joueur2, false, false, false, false, false, false, false, null, null, null, null, new Musique(Theme.STANDARD), false);
        Assert.assertSame(joueur1, jeu.getJoueurActif());
        jeu.changerJoueurActif();
        Assert.assertSame(joueur2, jeu.getJoueurActif());
    }

    @Test
    public void testGetFenetre() {
        JFrame fenetre = Mockito.mock(JFrame.class);
        jeu = new Jeu(new Joueur(Camp.ELEPHANT), new Joueur(Camp.RHINOCEROS), false, false, false, false, false, false, false, null, fenetre, null, null, new Musique(Theme.STANDARD), false);
        Assert.assertSame(fenetre, jeu.getFenetre());
    }

    @Test
    public void testGetVueJeu() {
        VueJeu vueJeu = Mockito.mock(VueJeu.class);
        jeu = new Jeu(new Joueur(Camp.ELEPHANT), new Joueur(Camp.RHINOCEROS), false, false, false, false, false, false, false, null, null, vueJeu, null, new Musique(Theme.STANDARD), false);
        Assert.assertSame(vueJeu, jeu.getVueJeu());
    }

    @Test
    public void testGetTheme() {
        jeu = new Jeu(new Joueur(Camp.ELEPHANT), new Joueur(Camp.RHINOCEROS), false, false, false, false, false, false, false, null, null, null, Theme.STANDARD, new Musique(Theme.STANDARD), false);
        Assert.assertEquals(Theme.STANDARD, jeu.getTheme());
    }

    @Test
    public void testSetTheme() {
        jeu.setTheme(Theme.NOEL);
        Assert.assertSame(Theme.NOEL, jeu.getTheme());
    }

    @Test
    public void testSetMusique() {
        Musique musique = Mockito.mock(Musique.class);
        jeu = new Jeu(new Joueur(Camp.ELEPHANT), new Joueur(Camp.RHINOCEROS), false, false, false, false, false, false, false, null, null, null, null, musique, false);
        Assert.assertSame(musique, jeu.getMusique());
    }

    @Test
    public void testGetMusique() {
        Musique musique = Mockito.mock(Musique.class);
        jeu.setMusique(musique);
        Assert.assertSame(musique, jeu.getMusique());
    }

    @Test
    public void testSetSon() {
        jeu = new Jeu(new Joueur(Camp.ELEPHANT), new Joueur(Camp.RHINOCEROS), false, false, false, false, false, false, false, null, null, null, null, new Musique(Theme.STANDARD), false);
        Assert.assertFalse(jeu.isSon());
    }

    @Test
    public void testIsSon() {
        jeu.setSon(true);
        Assert.assertTrue(jeu.isSon());
    }

    @Test
    public void testInitJeu() {
        Joueur[] joueurs = new Joueur[2];
        joueurs[0] = Mockito.mock(Joueur.class);
        joueurs[1] = Mockito.mock(Joueur.class);
        jeu.initJeu(joueurs[0], joueurs[1]);
        Assert.assertArrayEquals(joueurs, jeu.getJoueurs());
        Assert.assertSame(joueurs[0], jeu.getJoueurActif());
        Assert.assertFalse(jeu.isPieceSelectionnee());
        Assert.assertFalse(jeu.isPlacerPiece());
        Assert.assertFalse(jeu.isSortirPiece());
        Assert.assertFalse(jeu.isDeplacerPiece());
        Assert.assertFalse(jeu.isChangerOrientation());
        Assert.assertFalse(jeu.isSelectionnerOrientation());
        Assert.assertFalse(jeu.isEnCoursDeDeplacement());
        Assert.assertNull(jeu.getAnimalSelectionnee());
    }

    @Test
    public void testDeselection() {
        //TODO Test Manquant - JP
    }

    @Test
    public void testTestOrientationEntreAnimalEtCase() {
        //TODO Test Manquant - JP
    }
}
