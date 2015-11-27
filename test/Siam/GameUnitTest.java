package Siam;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class GameUnitTest {

    private Game game;

    @Before
    public void setUp() {
        game = new Game();
    }

    @Test
    public void testGetJoueurs() {
        Joueur[] joueurs = new Joueur[2];
        joueurs[0] = Mockito.mock(Joueur.class);
        joueurs[1] = Mockito.mock(Joueur.class);
        game = new Game(joueurs[0], joueurs[1], false, false, false, false, false, false, null, null);
        Assert.assertArrayEquals(joueurs, game.getJoueurs());
    }

    @Test
    public void testIsPieceSelectionnee() {
        Assert.assertFalse(game.isPieceSelectionnee());
    }

    @Test
    public void testSetPieceSelectionnee() {
        game.setPieceSelectionnee(true);
        Assert.assertTrue(game.isPieceSelectionnee());
    }

    @Test
    public void testIsPlacerPiece() {
        Assert.assertFalse(game.isPlacerPiece());
    }

    @Test
    public void testSetPlacerPiece() {
        game.setPlacerPiece(true);
        Assert.assertTrue(game.isPlacerPiece());
    }

    @Test
    public void testIsSortirPiece() {
        game = new Game(new Joueur(Camp.ELEPHANT), new Joueur(Camp.RHINOCEROS), false, false, false, false, false, false, null, null);
        Assert.assertFalse(game.isSortirPiece());
    }

    @Test
    public void testSetSortirPiece() {
        game = new Game(new Joueur(Camp.ELEPHANT), new Joueur(Camp.RHINOCEROS), false, false, false, false, false, false, null, null);
        game.setSortirPiece(true);
        Assert.assertTrue(game.isSortirPiece());
    }

    @Test
    public void testIsDeplacerPiece() {
        game = new Game(new Joueur(Camp.ELEPHANT), new Joueur(Camp.RHINOCEROS), false, false, false, false, false, false, null, null);
        Assert.assertFalse(game.isDeplacerPiece());
    }

    @Test
    public void testSetDeplacerPiece() {
        game = new Game(new Joueur(Camp.ELEPHANT), new Joueur(Camp.RHINOCEROS), false, false, false, false, false, false, null, null);
        game.setDeplacerPiece(true);
        Assert.assertTrue(game.isDeplacerPiece());
    }

    @Test
    public void testIsChangerOrientation() {
        game = new Game(new Joueur(Camp.ELEPHANT), new Joueur(Camp.RHINOCEROS), false, false, false, false, false, false, null, null);
        Assert.assertFalse(game.isChangerOrientation());
    }

    @Test
    public void testSetChangerOrientation() {
        game = new Game(new Joueur(Camp.ELEPHANT), new Joueur(Camp.RHINOCEROS), false, false, false, false, false, false, null, null);
        game.setChangerOrientation(true);
        Assert.assertTrue(game.isChangerOrientation());
    }

    @Test
    public void testIsSelectionnerOrientation() {
        game = new Game(new Joueur(Camp.ELEPHANT), new Joueur(Camp.RHINOCEROS), false, false, false, false, false, false, null, null);
        Assert.assertFalse(game.isSelectionnerOrientation());
    }

    @Test
    public void testSetSelectionnerOrientation() {
        game = new Game(new Joueur(Camp.ELEPHANT), new Joueur(Camp.RHINOCEROS), false, false, false, false, false, false, null, null);
        game.setSelectionnerOrientation(true);
        Assert.assertTrue(game.isSelectionnerOrientation());
    }

    @Test
    public void testGetJoueurActif() {
        Joueur joueur1 = Mockito.mock(Joueur.class);
        Joueur joueur2 = Mockito.mock(Joueur.class);
        game = new Game(joueur1, joueur2, false, false, false, false, false, false, null, null);
        Assert.assertSame(joueur1, game.getJoueurActif());
    }

    @Test
    public void testSetJoueurActif() {
        Joueur joueur = Mockito.mock(Joueur.class);
        game.setJoueurActif(joueur);
        Assert.assertSame(joueur, game.getJoueurActif());
    }

    @Test
    public void testGetAnimalSelectionnee() {
        Animal animal = Mockito.mock(Animal.class);
        game = new Game(new Joueur(Camp.ELEPHANT), new Joueur(Camp.RHINOCEROS), false, false, false, false, false, false, animal, null);
        Assert.assertSame(animal, game.getAnimalSelectionnee());
    }

    @Test
    public void testSetAnimalSelectionne() {
        game = new Game(new Joueur(Camp.ELEPHANT), new Joueur(Camp.RHINOCEROS), false, false, false, false, false, false, null, null);
        Animal animal = Mockito.mock(Animal.class);
        game.setAnimalSelectionnee(animal);
        Assert.assertSame(animal, game.getAnimalSelectionnee());
    }

    @Test
    public void testChangerJoueursActif() {
        Joueur joueur1 = Mockito.mock(Joueur.class);
        Joueur joueur2 = Mockito.mock(Joueur.class);
        game = new Game(joueur1, joueur2, false, false, false, false, false, false, null, null);
        Assert.assertSame(joueur1, game.getJoueurActif());
        game.changerJoueurActif();
        Assert.assertSame(joueur2, game.getJoueurActif());
    }
}
