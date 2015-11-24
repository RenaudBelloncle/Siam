package Siam;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class JoueurUnitTest {

    private Joueur joueur;

    @Before
    public void setUp() {
        joueur = new Joueur(Camp.ELEPHANT);
    }

    @Test
    public void setPlateau() {
        Plateau plateau = Mockito.mock(Plateau.class);
        joueur.setPlateau(plateau);
        Assert.assertSame(plateau, joueur.getPlateau());
    }

    @Test
    public void testGetCamp() {
        Assert.assertEquals(Camp.ELEPHANT, joueur.getCamp());
    }

    @Test
    public void testSetCamp() {
        joueur.setCamp(Camp.RHINOCEROS);
        Assert.assertEquals(Camp.RHINOCEROS, joueur.getCamp());
    }

    @Test
    public void testPosePiece() {
        joueur.setPlateau(new Plateau(5));
        joueur.posePiece(0, 0);
        Assert.assertNotSame(joueur.getPlateau().getCase(1, 1), joueur.getPlateau().getCase(0, 0));
        Assert.assertNull(joueur.posePiece(0, 0));
        joueur.posePiece(1, 1);
        joueur.posePiece(2, 2);
        joueur.posePiece(3, 3);
        joueur.posePiece(4, 4);
        //TODO
    }

    @Test
    public void testRestePiece() {
        //TODO
    }

    @Test
    public void testSortirPiece() {
        //TODO
    }

    @Test
    public void testMoveAnimalOnFreeCase(){
        Animal animal = Mockito.mock(Animal.class);
        Plateau plateau = Mockito.mock(Plateau.class);
        Case targetCase = Mockito.mock(Case.class);
        joueur.setPlateau(plateau);

        Mockito.when(plateau.getCase(0, 1)).thenReturn(targetCase);
        Mockito.when(targetCase.estVide()).thenReturn(false, true);
        Mockito.when(targetCase.getAbscisse()).thenReturn(0);
        Mockito.when(targetCase.getOrdonnee()).thenReturn(0);

        //test case adjacente et non vide
        boolean ret = joueur.moveAnimalOnFreeCase(animal, targetCase);
        Assert.assertEquals(ret, false);

        //test case adjacente et vide
        ret = joueur.moveAnimalOnFreeCase(animal, targetCase);
        Assert.assertEquals(ret, true);
    }

    @Test
    public void testMoveAnimalToPush(){
        //TODO
        //chope la ligne de piece dans la meme direction
        //fait les calculs : montagne -1, animal mal orient� = 0, animal bien orient� = 1, animal oppos� = 1
        //si > 0 pousse ,si == 0 && montagne pousse
        //sinon ne marche pas
    }
}
