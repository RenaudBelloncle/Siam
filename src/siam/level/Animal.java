package siam.level;

import siam.graphics.Screen;
import siam.graphics.Sprite;
import siam.player.Camp;

public class Animal extends Piece {

    private Orientation orientation;
    private boolean isSelected = false;

    public Animal(int x, int y, Sprite sprite, Camp camp, Orientation orientation) {
        super(x, y, sprite, camp);
        this.orientation = orientation;
    }

    public void render(Screen screen) {
        screen.renderPiece(x, y, this);
    }
}
