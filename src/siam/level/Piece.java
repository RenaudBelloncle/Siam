package siam.level;

import siam.graphics.Screen;
import siam.graphics.Sprite;
import siam.player.Camp;

public abstract class Piece {

    protected int x, y;
    protected Sprite sprite;
    protected Camp camp;

    public Piece(int x, int y, Sprite sprite, Camp camp) {
        this.x = x;
        this.y = y;
        this.sprite = sprite;
        this.camp = camp;
    }

    public Sprite getSprite() {
        return sprite;
    }

    public abstract void render(Screen screen);
}
