package siam.level;

import siam.graphics.Screen;
import siam.graphics.Sprite;
import siam.player.Camp;

public class Mountain extends Piece {

    public Mountain(int x, int y, Sprite sprite, Camp camp) {
        super(x, y, sprite, camp);
    }

    public void render(Screen screen) {
        screen.renderPiece(x, y, this);
    }
}
