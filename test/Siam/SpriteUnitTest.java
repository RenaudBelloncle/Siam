package Siam;

import Siam.Interface.Sprite;

import org.junit.Assert;
import org.junit.Test;

public class SpriteUnitTest {

    @Test
    public void testGetSize(){
        Sprite sprite = new Sprite("/images/spriteTest.png");
        Assert.assertEquals(sprite.getSize(), 128);
    }
}
