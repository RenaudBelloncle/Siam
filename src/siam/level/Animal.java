package siam.level;

import siam.graphics.Screen;
import siam.graphics.Sprite;
import siam.player.Camp;

import javax.print.attribute.standard.OrientationRequested;

public class Animal extends Piece {

    private Orientation orientation;
    private boolean isSelected = false;

    public Animal(int x, int y, Sprite sprite, Camp camp, Orientation orientation) {
        super(x, y, sprite, camp);
        this.orientation = orientation;
    }

    public Orientation getOrientation() {
        return orientation;
    }

    public void render(Screen screen) {
        screen.renderPiece(x, y, this);
    }

    public void setOrientation(Orientation o){
        orientation = o;
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
