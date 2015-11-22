package Siam;

import Siam.Interface.Sprite;

import org.junit.Assert;
import org.junit.Test;

public class SpriteUnitTest {

    @Test
    public void testGetLargeur(){
        Sprite sprite = new Sprite("/images/spriteTest.png",128,128);
        Assert.assertEquals(sprite.getLargeur(), 128);
    }

    @Test
    public void testGetHauteur(){
        Sprite sprite = new Sprite("/images/spriteTest.png",128,128);
        Assert.assertEquals(sprite.getHauteur(), 128);
    }
}
