package siam.level;

import siam.graphics.Screen;
import siam.graphics.Sprite;
import siam.player.Camp;

public class Mountain extends Piece {

    public Mountain(int x, int y, Camp camp) {
        super(x, y, camp);
        switch (camp) {
            case WHITE:
                setSprite(Sprite.whiteMountain);
                break;
            case BLACK:
                setSprite(Sprite.blackMountain);
                break;
            case NEUTRAL:
                setSprite(Sprite.mountain);
                break;
        }
    }

    public void render(Screen screen) {
        screen.renderPiece(x, y, this);
    }
}
