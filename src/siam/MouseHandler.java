package siam;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MouseHandler implements MouseListener, Constants{

    private int[] clickCoord;
    public MouseHandler(){
        super();
        clickCoord = new int[2];
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        clickCoord[0] = (e.getX()-BOARD_BORDER/2)/SPRITE_SIZE;
        clickCoord[1] = e.getY()/SPRITE_SIZE ;
        System.out.println(clickCoord[0] + " " + clickCoord[1]);
    }

    @Override
    public void mousePressed(MouseEvent e) {
        return;
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        return;
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        return;
    }

    @Override
    public void mouseExited(MouseEvent e) {
        return;
    }

    public int[] getClick(){
        return clickCoord;
    }
}
