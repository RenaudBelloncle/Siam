package siam.level;

import siam.graphics.Screen;
import siam.graphics.Sprite;
import siam.player.Camp;

public class Animal extends Piece {

    private Orientation orientation;
    private boolean isSelected = false;

    public Animal(int x, int y, Camp camp, Orientation orientation) {
        super(x, y, camp);
        switch (camp) {
            case WHITE:
                setSprite(Sprite.whitePiece);
                break;
            case BLACK:
                setSprite(Sprite.blackPiece);
                break;
        }
        this.orientation = orientation;
    }

    public Orientation getOrientation() {
        return orientation;
    }

    public void setOrientation(Orientation orientation) {
        this.orientation = orientation;
    }

    public void render(Screen screen) {
        screen.renderPiece(x, y, this);
    }

    public boolean getIsSelected(){
        return isSelected;
    }

    public void selected(){
        isSelected = true;
    }

    public void deselected(){
        isSelected = false;
    }
}
