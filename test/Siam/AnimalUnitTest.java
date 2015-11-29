package Siam;

import Siam.Enum.Camp;
import Siam.Enum.Orientation;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AnimalUnitTest {

    private Animal animal;

    @Before
    public void setUp() {
        animal = new Animal(0, 0, Orientation.HAUT, Camp.ELEPHANT, false);
    }

    @Test
    public void testGetOrientation() {
        Assert.assertEquals(Orientation.HAUT, animal.getOrientation());
    }

    @Test
    public void testSetOrientation() {
        animal.setOrientation(Orientation.BAS);
        Assert.assertEquals(Orientation.BAS, animal.getOrientation());
    }

    @Test
    public void testEstSelectionnee() {
        Assert.assertFalse(animal.estSelectionnee());
    }

    @Test
    public void testSetSelectionnee() {
        animal.setSelectionnee(true);
        Assert.assertTrue(animal.estSelectionnee());
    }

    @Test
    public void testGetCamp() {
        Assert.assertEquals(Camp.ELEPHANT, animal.getCamp());
    }

    @Test
    public void testSetCamp() {
        animal.setCamp(Camp.RHINOCEROS);
        Assert.assertEquals(Camp.RHINOCEROS, animal.getCamp());
    }

    @Test
    public void testEstVide() {
        Assert.assertFalse(animal.estVide());
    }
}
