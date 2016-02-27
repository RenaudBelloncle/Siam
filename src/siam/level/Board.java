package siam.level;

import siam.Constants;
import siam.graphics.Screen;
import siam.player.Camp;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;

public class Board extends JPanel implements Constants, Cloneable {

    private final int SIZE;
    private Tile[][] tiles;
    private Screen screen;

    private boolean variantMountainOn;
    private boolean variantTileOn;

    private BufferedImage image;
    private int[] pixels;

    private boolean pieceIsMoving;
    private Piece pieceMoving;

    public Board(int size, boolean variantMountainOn, boolean variantTileOn) {
        this.SIZE = size;
        this.variantMountainOn = variantMountainOn;
        this.variantTileOn = variantTileOn;
        tiles = new Tile[size][size];

        screen = new Screen(BOARD_SIZE * SPRITE_SIZE + BOARD_BORDER, BOARD_SIZE * SPRITE_SIZE + BOARD_BORDER);
        Dimension dimension = new Dimension(SIZE * SPRITE_SIZE + BOARD_BORDER, SIZE * SPRITE_SIZE + BOARD_BORDER);
        setPreferredSize(dimension);

        initBoard();

        image = new BufferedImage(SIZE * SPRITE_SIZE + BOARD_BORDER, SIZE * SPRITE_SIZE + BOARD_BORDER, BufferedImage.TYPE_INT_RGB);
        pixels = ((DataBufferInt) image.getRaster().getDataBuffer()).getData();

        pieceIsMoving = false;
        pieceMoving = null;
    }

    public Board(Board board) {
        SIZE = board.SIZE;
        tiles = board.tiles;

        screen = board.screen;
        image = board.image;
        pixels = new int[board.pixels.length];
        System.arraycopy(board.pixels, 0, pixels, 0, board.pixels.length);
    }

    private void initBoard() {
        for (int y = 0; y < SIZE; y++) {
            for (int x = 0; x < SIZE; x++) {
                tiles[x][y] = new Tile(x, y, false);
            }
        }
        if (variantTileOn) {
            tiles[2][(BOARD_SIZE - 1)] = new Tile(2, (BOARD_SIZE - 1), true);
            tiles[2][0] = new Tile(2, 0, true);
        }
        if (variantMountainOn) {
            for (int i = 0; i < 3; i++) {
                int xa = (i + 1) * SPRITE_SIZE + BOARD_BORDER / 2;
                int ya = 2 * SPRITE_SIZE + BOARD_BORDER / 2;
                if (i == 0) tiles[i + 1][2].insertPiece(new Mountain(xa, ya, Camp.WHITE));
                else if (i == 2) tiles[i + 1][2].insertPiece(new Mountain(xa, ya, Camp.BLACK));
                else tiles[i + 1][2].insertPiece(new Mountain(xa, ya, Camp.NEUTRAL));
            }
        } else {
            for (int i = 0; i < 3; i++) {
                int xa = (i + 1) * SPRITE_SIZE + BOARD_BORDER / 2;
                int ya = 2 * SPRITE_SIZE + BOARD_BORDER / 2;
                tiles[i + 1][2].insertPiece(new Mountain(xa, ya, Camp.NEUTRAL));
            }
        }
    }

    public Tile getTile(int x, int y) {
        return tiles[x][y];
    }

    public void pieceMoving(Piece pieceMoving) {
        pieceIsMoving = true;
        this.pieceMoving = pieceMoving;
    }

    public void pieceStopMoving() {
        pieceIsMoving = false;
        pieceMoving = null;
    }

    public void movePiece(int x, int y, Orientation orientation) {
        switch (orientation) {
            case TOP:
                getTile(x, y - 1).insertPiece(getTile(x, y).getPiece());
                getTile(x, y).brigOutPiece();
                break;
            case DOWN:
                getTile(x, y + 1).insertPiece(getTile(x, y).getPiece());
                getTile(x, y).brigOutPiece();
                break;
            case LEFT:
                getTile(x - 1, y).insertPiece(getTile(x, y).getPiece());
                getTile(x, y).brigOutPiece();
                break;
            case RIGTH:
                getTile(x + 1, y).insertPiece(getTile(x, y).getPiece());
                getTile(x, y).brigOutPiece();
                break;
        }
    }

    public void render(Screen screen) {
        for (int y = 0; y < SIZE; y++) {
            for (int x = 0; x < SIZE; x++) {
                tiles[x][y].render(screen);
            }
        }
        if (pieceIsMoving) pieceMoving.render(screen);
    }

    public Piece getPiece(int x, int y){
        return tiles[x][y].getPiece();
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
        tiles[coord[0]][coord[1]].insertPiece(p);
    }

    public void removePiece(int[]coord){
        tiles[coord[0]][coord[1]].removePiece();
    }

    private int[] convertPixToCase(int[] pix){
        return new int[]{pix[0]/SPRITE_SIZE,pix[1]/SPRITE_SIZE};
    }

    public void changeTile(int x, int y, boolean status) {
        tiles[x][y] = new Tile(x, y, status);
    }

    public boolean pieceSelected(){
        for(int i = 0; i < SIZE; i++){
            for(int j = 0; j < SIZE; j++){
                if(pieceSelected(i,j)) return true;
            }
        }
        return false;
    }

    public boolean pieceSelected(int x, int y) {
        return tiles[x][y].getPiece() instanceof Animal && ((Animal)tiles[x][y].getPiece()).getIsSelected();
    }

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

    public void deselect(){
        if(!pieceSelected()) { return;}
        Animal a = getPieceSelected();
        a.deselected();
    }

    public boolean select(int x, int y){
        if(getPiece(x,y)== null) return false;
        if(getPiece(x, y) instanceof Animal){
            ((Animal) getPiece(x,y)).selected();
            return true;
        }
        return false;
    }

    public boolean isFree(int x, int y){
        return tiles[x][y].isEmpty();
    }

    public boolean isOnEdge(int x, int y){
        return tiles[x][y].isOnEdge();
    }

    public boolean asABanishedTile(int x, int y){
        return tiles[x][y].isBanished();
    }

    public boolean isInBound(int x, int y){
        return 0 <= x && x < SIZE && 0 <= y && y < SIZE;
    }

    public void movePiece(int x, int y, int oldx, int oldy){
        Piece p = getPiece(oldx,oldy);
        removePiece(convertPixToCase(p.getCoord()));
        tiles[x][y].insertPiece(p);
    }
}