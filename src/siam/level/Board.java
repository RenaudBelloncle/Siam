package siam.level;

import siam.Constants;
import siam.graphics.Screen;
import siam.graphics.Sprite;
import siam.player.Camp;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;

public class Board extends JPanel implements Constants {

    private final int SIZE;
    private Tile[][] tiles;

    private Screen screen;
    private BufferedImage image;
    private int[] pixels;

    public Board(int size) {
        this.SIZE = size;
        tiles = new Tile[size][size];

        Dimension dimension = new Dimension(SIZE * SPRITE_SIZE + BOARD_BORDER, SIZE * SPRITE_SIZE + BOARD_BORDER);
        setPreferredSize(dimension);

        initBoard();

        screen = new Screen(SIZE * SPRITE_SIZE + BOARD_BORDER, SIZE * SPRITE_SIZE + BOARD_BORDER);
        image = new BufferedImage(SIZE * SPRITE_SIZE + BOARD_BORDER, SIZE * SPRITE_SIZE + BOARD_BORDER, BufferedImage.TYPE_INT_RGB);
        pixels = ((DataBufferInt) image.getRaster().getDataBuffer()).getData();
    }

    private void initBoard() {
        for (int y = 0; y < SIZE; y++) {
            for (int x = 0; x < SIZE; x++) {
                tiles[x][y] = new Tile(x, y, false);
            }
        }

        for (int i = 0; i < 3; i++) {
            int xa = (i + 1) * SPRITE_SIZE + BOARD_BORDER / 2;
            int ya = 2 * SPRITE_SIZE + BOARD_BORDER / 2;
            tiles[i + 1][2].insertPiece(new Mountain(xa, ya, Sprite.mountain, Camp.NEUTRAL));
        }
    }

    public void render(Screen screen) {
        for (int y = 0; y < SIZE; y++) {
            for (int x = 0; x < SIZE; x++) {
                tiles[x][y].render(screen);
            }
        }
    }

    public void paintComponent(Graphics graphics) {
        screen.clear();
        render(screen);
        for (int i = 0; i < pixels.length; i++) {
            pixels[i] = screen.getPixel(i);
        }
        graphics.drawImage(image, 0, 0, getWidth(), getHeight(), null);
        graphics.dispose();
    }
}