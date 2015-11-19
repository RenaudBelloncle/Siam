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
        game = new Game(joueurs[0], joueurs[1], false, false, false, false, false, false);
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
    public void testGetJoueurActif() {
        Joueur joueur1 = Mockito.mock(Joueur.class);
        Joueur joueur2 = Mockito.mock(Joueur.class);
        game = new Game(joueur1, joueur2, false, false, false, false, false, false);
        Assert.assertSame(joueur1, game.getJoueurActif());
    }

    @Test
    public void testSetJoueurActif() {
        Joueur joueur = Mockito.mock(Joueur.class);
        game.setJoueurActif(joueur);
        Assert.assertSame(joueur, game.getJoueurActif());
    }
}
