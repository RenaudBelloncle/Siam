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
        game = new Game(joueurs[0], joueurs[1], false);
        Assert.assertArrayEquals(joueurs, game.getJoueurs());
    }

    @Test
    public void testIsInsertionPiece() {
        Assert.assertFalse(game.isInsertionPiece());
    }

    @Test
    public void testSetInsertionPiece() {
        game = new Game(new Joueur(0), new Joueur(0), true);
        Assert.assertTrue(game.isInsertionPiece());
    }

    @Test
    public void testGetJoueurActif() {
        Joueur joueur1 = Mockito.mock(Joueur.class);
        Joueur joueur2 = Mockito.mock(Joueur.class);
        game = new Game(joueur1, joueur2, false);
        Assert.assertSame(joueur1, game.getJoueurActif());
    }

    @Test
    public void testSetJoueurActif() {
        Joueur joueur = Mockito.mock(Joueur.class);
        game.setJoueurActif(joueur);
        Assert.assertSame(joueur, game.getJoueurActif());
    }
}
