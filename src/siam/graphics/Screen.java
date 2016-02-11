package siam.graphics;

import siam.Constants;
import siam.level.Animal;
import siam.level.Tile;
import siam.level.Piece;

public class Screen implements Constants {

    private int width, heigth;
    private int[] pixels;

    public Screen(int width, int heigth) {
        this.width = width;
        this.heigth = heigth;
        pixels = new int[width * heigth];
    }

    public void clear() {
        for (int i = 0; i < pixels.length; i++) {
            pixels[i] = 0;
        }
    }

    public void renderTile(int xp, int yp, Tile tile) {
        xp = xp * SPRITE_SIZE + BOARD_BORDER / 2;
        yp = yp * SPRITE_SIZE + BOARD_BORDER / 2;
        for (int y = 0; y < SPRITE_SIZE; y++) {
            int ya = y + yp;
            for (int x = 0; x < SPRITE_SIZE; x++) {
                int xa = x + xp;
                if (xa < -SPRITE_SIZE || xa >= width ||  ya < 0 || ya >= heigth) break;
                if (xa < 0) xa = 0;
                pixels[xa + ya * width] = tile.getSprite().getPixel(x + y * SPRITE_SIZE);
            }
        }
    }

    public void renderPiece(int xp, int yp, Piece piece) {
        for (int y = 0; y < SPRITE_SIZE; y++) {
            int ya = y + yp;
            for (int x = 0; x < SPRITE_SIZE; x++) {
                int xa = x + xp;
                if (xa < -SPRITE_SIZE || xa >= width ||
                        ya < 0 || ya >= heigth) break;
                if (xa < 0) xa = 0;
                int col = piece.getSprite().getPixel(x + y * SPRITE_SIZE);
                if (col != 0xFFFF00FF) pixels[xa + ya * width] = col;
            }
        }
        if(piece instanceof Animal){
            if(((Animal) piece).getIsSelected()){
                renderSelection(piece.getCoord()[0],piece.getCoord()[1]);
            }
        }
    }

    public void renderSelection(int xp, int yp){
        for (int y = 0; y < SPRITE_SIZE; y++) {
            int ya = y + yp;
            for (int x = 0; x < SPRITE_SIZE; x++) {
                int xa = x + xp;
                if (xa < -SPRITE_SIZE || xa >= width ||
                        ya < 0 || ya >= heigth) break;
                if (xa < 0) xa = 0;
                int col = Sprite.focus.getPixel(x + y * SPRITE_SIZE);
                if (col != 0xFFFF00FF) pixels[xa + ya * width] = col;
            }
        }
    }

    public int getPixel(int i) {
        return pixels[i];
    }

}
