package siam.level;

import siam.Constants;
import siam.graphics.Screen;
import siam.graphics.Sprite;
import siam.player.Camp;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;

public class Board extends JPanel implements Constants,Cloneable {

    private final int SIZE;
    private Tile[][] tiles;
    private Screen screen;

    private BufferedImage image;
    private int[] pixels;

    public Board(int size) {
        this.SIZE = size;
        tiles = new Tile[size][size];

        screen = new Screen(BOARD_SIZE * SPRITE_SIZE + BOARD_BORDER, BOARD_SIZE * SPRITE_SIZE + BOARD_BORDER);
        Dimension dimension = new Dimension(SIZE * SPRITE_SIZE + BOARD_BORDER, SIZE * SPRITE_SIZE + BOARD_BORDER);
        setPreferredSize(dimension);

        initBoard();

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

    public Piece getPiece(int x, int y){
        return tiles[x][y].getPiece();
    }

    public void renderSelection(int x, int y){
        screen.renderSelection(x,y);
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

    public void putPiece(Piece p){
        int [] coord = convertPixToCase(p.getCoord());
        System.out.println(coord[0] + " " + coord[1]);
        tiles[coord[0]][coord[1]].insertPiece(p);
    }

    private int[] convertPixToCase(int[] pix){
        return new int[]{pix[0]/SPRITE_SIZE,pix[1]/SPRITE_SIZE};
    }


    // Test si une piece est selectionnee
    public boolean pieceSelected(){
        for(int i = 0; i < SIZE; i++){
            for(int j = 0; j < SIZE; j++){
                if(pieceSelected(i,j)){
                    return true;
                }
            }
        }
        return false;
    }

    // Test si la piece x y est selectionnee
    public boolean pieceSelected(int x, int y){
        if(tiles[x][y].getPiece() instanceof Animal){
            if(((Animal)tiles[x][y].getPiece()).getIsSelected()){
                return true;
            }
        }
        return false;
    }

    // Recupere la piece selectionnee
    public Animal getPieceSelected(){
        for(int i = 0; i < SIZE; i++){
            for(int j = 0; j < SIZE; j++){
                if(pieceSelected(i,j)){
                    return (Animal)tiles[i][j].getPiece();
                }
            }
        }
        return null;
    }

    // Deselectionne la piece selectionnee
    public void deselect(){
        Animal a = getPieceSelected();
        a.deselected();
    }

    // Selectionne la piece x y si c'est un animal
    public boolean select(int x, int y){
        if(getPiece(x, y) instanceof Animal){
            ((Animal) getPiece(x,y)).selected();
            return true;
        }
        return false;
    }

    // Retourne si la case x y est libre ou non
    public boolean isFree(int x, int y){
        return tiles[x][y].getPiece() == null;
    }
}