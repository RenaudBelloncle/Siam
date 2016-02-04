package siam.level;

import siam.graphics.Screen;
import siam.graphics.Sprite;

public class Tile {

    private int x, y;
    private boolean banished = false;
    private Sprite sprite;
    private Piece piece = null;

    public Tile(int x, int y, boolean banished) {
        this.x = x;
        this.y = y;
        this.banished = banished;
        if (banished) sprite = Sprite.bannedTile;
        else sprite = Sprite.tile;
    }

    public void insertPiece(Piece piece) {
        this.piece = piece;
    }

    public void render(Screen screen) {
        screen.renderTile(x, y, this);
        if (piece != null) piece.render(screen);
    }

    public Sprite getSprite() {
        return sprite;
    }

    public Piece getPiece(){
        return piece;
    }
}
