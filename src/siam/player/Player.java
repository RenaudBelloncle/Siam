package siam.player;

import siam.level.Animal;

import java.util.ArrayList;
import java.util.List;

public class Player {

    private Camp camp;
    private String name;
    private List<Animal> piecesList;

    public Player() {
        this(Camp.NEUTRAL, "");
    }

    public Player(Camp camp, String name) {
        piecesList = new ArrayList<>();
        this.camp = camp;
        this.name = name;
    }

    public Camp getCamp() {
        return camp;
    }

    public String getName() {
        return name;
    }

    public int getPieceNumber(){
        return piecesList.size();
    }
}
