package Siam;

import Siam.Exception.RestePieceException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
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
        //TODO
    }

    @Test
    public void testRestePiece() throws Exception {
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
        Mockito.when(targetCase.isVoid()).thenReturn(false, true);
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
        //fait les calculs : montagne -1, animal mal orienté = 0, animal bien orienté = 1, animal opposé = 1
        //si > 0 pousse ,si == 0 && montagne pousse
        //sinon ne marche pas
    }
}
