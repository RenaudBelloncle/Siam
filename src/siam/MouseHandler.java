package siam;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MouseHandler implements MouseListener, Constants {

    private int[] clickCoord;
    private boolean allowed;
    private boolean rightClick;

    public MouseHandler(){
        super();
        allowed = false;
        rightClick = false;
        clickCoord = new int[]{-1,-1};
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
        if (SwingUtilities.isRightMouseButton(e)) {
            rightClick = true;
            resetClick();
        } else if (SwingUtilities.isLeftMouseButton(e)) {
            if (allowed) {
                clickCoord[0] = (e.getX() - BOARD_BORDER / 2) / SPRITE_SIZE;
                clickCoord[1] = (e.getY() - BOARD_BORDER / 2) / SPRITE_SIZE;
            }
        } else resetClick();
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if (SwingUtilities.isRightMouseButton(e)) rightClick = false;
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    public int[] getClick(){
        return clickCoord;
    }

    public void resetClick(){
        clickCoord[0]=clickCoord[1]=-1;
    }

    public boolean isSelected(){
        return clickCoord[0]!=-1 && clickCoord[1]!=-1;
    }

    public void openClick(){
        allowed = true;
    }

    public void closeClick(){
        allowed = false;
        resetClick();
    }

    public boolean isRightClick() {
        return rightClick;
    }
}
