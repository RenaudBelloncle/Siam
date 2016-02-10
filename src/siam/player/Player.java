package siam.player;

public class Player {

    protected Camp camp;
    protected String name;

    public Player() {
        this(Camp.NEUTRAL, "");
    }

    public Player(Camp camp, String name) {
        this.camp = camp;
        this.name = name;
    }

    public Camp getCamp() {
        return camp;
    }

    public String getName() {
        return name;
    }

}
