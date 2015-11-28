package Siam;

import Siam.Enum.Camp;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class JeuUnitTest {

    private Jeu jeu;

    @Before
    public void setUp() {
        jeu = new Jeu();
    }

    @Test
    public void testGetJoueurs() {
        Joueur[] joueurs = new Joueur[2];
        joueurs[0] = Mockito.mock(Joueur.class);
        joueurs[1] = Mockito.mock(Joueur.class);
        jeu = new Jeu(joueurs[0], joueurs[1], false, false, false, false, false, false, null, null);
        Assert.assertArrayEquals(joueurs, jeu.getJoueurs());
    }

    @Test
    public void testIsPieceSelectionnee() {
        Assert.assertFalse(jeu.isPieceSelectionnee());
    }

    @Test
    public void testSetPieceSelectionnee() {
        jeu.setPieceSelectionnee(true);
        Assert.assertTrue(jeu.isPieceSelectionnee());
    }

    @Test
    public void testIsPlacerPiece() {
        Assert.assertFalse(jeu.isPlacerPiece());
    }

    @Test
    public void testSetPlacerPiece() {
        jeu.setPlacerPiece(true);
        Assert.assertTrue(jeu.isPlacerPiece());
    }

    @Test
    public void testIsSortirPiece() {
        jeu = new Jeu(new Joueur(Camp.ELEPHANT), new Joueur(Camp.RHINOCEROS), false, false, false, false, false, false, null, null);
        Assert.assertFalse(jeu.isSortirPiece());
    }

    @Test
    public void testSetSortirPiece() {
        jeu = new Jeu(new Joueur(Camp.ELEPHANT), new Joueur(Camp.RHINOCEROS), false, false, false, false, false, false, null, null);
        jeu.setSortirPiece(true);
        Assert.assertTrue(jeu.isSortirPiece());
    }

    @Test
    public void testIsDeplacerPiece() {
        jeu = new Jeu(new Joueur(Camp.ELEPHANT), new Joueur(Camp.RHINOCEROS), false, false, false, false, false, false, null, null);
        Assert.assertFalse(jeu.isDeplacerPiece());
    }

    @Test
    public void testSetDeplacerPiece() {
        jeu = new Jeu(new Joueur(Camp.ELEPHANT), new Joueur(Camp.RHINOCEROS), false, false, false, false, false, false, null, null);
        jeu.setDeplacerPiece(true);
        Assert.assertTrue(jeu.isDeplacerPiece());
    }

    @Test
    public void testIsChangerOrientation() {
        jeu = new Jeu(new Joueur(Camp.ELEPHANT), new Joueur(Camp.RHINOCEROS), false, false, false, false, false, false, null, null);
        Assert.assertFalse(jeu.isChangerOrientation());
    }

    @Test
    public void testSetChangerOrientation() {
        jeu = new Jeu(new Joueur(Camp.ELEPHANT), new Joueur(Camp.RHINOCEROS), false, false, false, false, false, false, null, null);
        jeu.setChangerOrientation(true);
        Assert.assertTrue(jeu.isChangerOrientation());
    }

    @Test
    public void testIsSelectionnerOrientation() {
        jeu = new Jeu(new Joueur(Camp.ELEPHANT), new Joueur(Camp.RHINOCEROS), false, false, false, false, false, false, null, null);
        Assert.assertFalse(jeu.isSelectionnerOrientation());
    }

    @Test
    public void testSetSelectionnerOrientation() {
        jeu = new Jeu(new Joueur(Camp.ELEPHANT), new Joueur(Camp.RHINOCEROS), false, false, false, false, false, false, null, null);
        jeu.setSelectionnerOrientation(true);
        Assert.assertTrue(jeu.isSelectionnerOrientation());
    }

    @Test
    public void testGetJoueurActif() {
        Joueur joueur1 = Mockito.mock(Joueur.class);
        Joueur joueur2 = Mockito.mock(Joueur.class);
        jeu = new Jeu(joueur1, joueur2, false, false, false, false, false, false, null, null);
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
        jeu = new Jeu(new Joueur(Camp.ELEPHANT), new Joueur(Camp.RHINOCEROS), false, false, false, false, false, false, animal, null);
        Assert.assertSame(animal, jeu.getAnimalSelectionnee());
    }

    @Test
    public void testSetAnimalSelectionne() {
        jeu = new Jeu(new Joueur(Camp.ELEPHANT), new Joueur(Camp.RHINOCEROS), false, false, false, false, false, false, null, null);
        Animal animal = Mockito.mock(Animal.class);
        jeu.setAnimalSelectionnee(animal);
        Assert.assertSame(animal, jeu.getAnimalSelectionnee());
    }

    @Test
    public void testChangerJoueursActif() {
        Joueur joueur1 = Mockito.mock(Joueur.class);
        Joueur joueur2 = Mockito.mock(Joueur.class);
        jeu = new Jeu(joueur1, joueur2, false, false, false, false, false, false, null, null);
        Assert.assertSame(joueur1, jeu.getJoueurActif());
        jeu.changerJoueurActif();
        Assert.assertSame(joueur2, jeu.getJoueurActif());
    }
}
