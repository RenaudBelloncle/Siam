package siam;

import siam.graphics.FontTools;
import siam.graphics.Sprite;
import siam.graphics.TextureManager;
import siam.level.Animal;
import siam.level.Board;
import siam.level.Orientation;
import siam.level.Piece;
import siam.player.Camp;
import siam.player.Player;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

public class Game implements Runnable, ActionListener, Constants, Texts {

    private FontTools fontTools = new FontTools();

    private Board board;
    private Player[] players;
    private int playerActive;
    private boolean putActive, moveActive, orientActive, bringOutActive, upActive,downActive,leftActive,rightActive;

    private boolean songEnable = false;

    private JFrame frame;
    private JLabel playerName;
    private JButton put;
    private JButton bringOut;
    private JButton move;
    private JButton orient;
    private JButton top;
    private JButton left;
    private JButton right;
    private JButton bottom;
    private JMenuItem newGame;
    private JMenuItem save;
    private JMenuItem rules;
    private JMenuItem backToMenu;
    private JMenuItem song;

    private MouseHandler mouse;
    private Thread thread;
    private boolean running = false;

    public Game() {
        board = new Board(BOARD_SIZE);
        players = new Player[2];
        playerActive = 0;

        players[0] = new Player(Camp.WHITE,"Pistache");
        players[1] = new Player(Camp.BLACK,"Cacahuète");

        frame = new JFrame();

        Dimension dimension = new Dimension(WIN_WIDTH, WIN_HEIGTH);
        frame.setPreferredSize(dimension);

        initFrame();
        renderFrame();

        mouse = new MouseHandler();
        setControl(this);

        putActive=moveActive=orientActive=bringOutActive=upActive=downActive=rightActive=leftActive=false;
        frame.setResizable(false);
        frame.setTitle(TITLE);
        frame.pack();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);

        setButtonEnabled();
        start();
    }

    public Game(JFrame frame) {
        board = new Board(BOARD_SIZE);
        players = new Player[2];
        playerActive = 0;

        players[0] = new Player(Camp.WHITE,"Pistache");
        players[1] = new Player(Camp.BLACK,"Cacahuète");

        this.frame = frame;

        Dimension dimension = new Dimension(WIN_WIDTH, WIN_HEIGTH);
        frame.setPreferredSize(dimension);

        putActive = moveActive = orientActive = bringOutActive = upActive = downActive = rightActive = leftActive =  false;
        initFrame();
        renderFrame();

        mouse = new MouseHandler();
        setControl(this);

        frame.setVisible(true);

        setButtonEnabled();
        start();
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    private void initFrame() {
        playerName = new JLabel(players[playerActive].getName());
        put = new JButton(PUT_BUTTON);
        bringOut = new JButton(BRINGOUT_BUTTON);
        move = new JButton(MOVE_BUTTON);
        orient = new JButton(ORIENT_BUTTON);
        top = new JButton(TOP_BUTTON);
        left = new JButton(LEFT_BUTTON);
        right = new JButton(RIGHT_BUTTON);
        bottom = new JButton(BOTTOM_BUTTON);

        newGame = new JMenuItem(NEWGAME_BAR);
        save = new JMenuItem(SAVE_BAR);
        rules = new JMenuItem(RULES_BAR);
        backToMenu = new JMenuItem(BACKTOMENU_BAR);
        if (songEnable) {
            song = new JMenuItem(SONG_ENABLE_BAR);
        } else {
            song = new JMenuItem(SONG_DISABLE_BAR);
        }
    }

    private void renderFrame() {
        JPanel mainPanel = new JPanel();
        JPanel buttonPanel = new JPanel() {
            BufferedImage image = TextureManager.library.getImage("Button Background");
            public void paintComponent(Graphics g) {
                super.paintComponent(g);
                frame.repaint();
                g.drawImage(image, 0, 0, BUTTON_WIDTH, WIN_HEIGTH, this);
            }
        };
        Dimension dimension = new Dimension(BUTTON_WIDTH, WIN_HEIGTH);
        buttonPanel.setPreferredSize(dimension);
        JPanel playerNamePanel = new JPanel();
        JPanel putPanel = new JPanel();
        JPanel bringOutPanel = new JPanel();
        JPanel movePanel = new JPanel();
        JPanel orientPanel = new JPanel();
        JPanel topPanel = new JPanel();
        JPanel sidePanel = new JPanel();
        JPanel leftPanel = new JPanel();
        JPanel rightPanel = new JPanel();
        JPanel bottomPanel = new JPanel();

        mainPanel.setOpaque(false);
        buttonPanel.setOpaque(false);
        playerNamePanel.setOpaque(false);
        putPanel.setOpaque(false);
        bringOutPanel.setOpaque(false);
        movePanel.setOpaque(false);
        orientPanel.setOpaque(false);
        topPanel.setOpaque(false);
        sidePanel.setOpaque(false);
        leftPanel.setOpaque(false);
        rightPanel.setOpaque(false);
        bottomPanel.setOpaque(false);

        updateFonts();

        playerNamePanel.add(playerName);
        putPanel.add(put);
        bringOutPanel.add(bringOut);
        movePanel.add(move);
        orientPanel.add(orient);
        topPanel.add(top);
        leftPanel.add(left);
        rightPanel.add(right);
        bottomPanel.add(bottom);

        sidePanel.setLayout(new GridLayout(1, 2));
        sidePanel.add(leftPanel);
        sidePanel.add(rightPanel);

        buttonPanel.setLayout(new GridLayout(8, 1));
        buttonPanel.add(playerNamePanel);
        buttonPanel.add(putPanel);
        buttonPanel.add(bringOutPanel);
        buttonPanel.add(movePanel);
        buttonPanel.add(orientPanel);
        buttonPanel.add(topPanel);
        buttonPanel.add(sidePanel);
        buttonPanel.add(bottomPanel);

        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.X_AXIS));
        mainPanel.add(board);
        mainPanel.add(buttonPanel);

        frame.setContentPane(mainPanel);

        JMenuBar menuBar = new JMenuBar();
        menuBar.setPreferredSize(new Dimension(WIN_WIDTH, TOPBAR_HEIGHT));
        JMenu menu = new JMenu(MENU_BAR);
        JMenu option = new JMenu(OPTION_BAR);

        menu.add(newGame);
        menu.add(save);
        menu.add(rules);
        menu.add(backToMenu);

        option.add(song);

        menuBar.add(menu);
        menuBar.add(option);

        frame.setJMenuBar(menuBar);
    }

    private void updateFonts() {
        fontTools.updateFontJLabel(playerName, 30, Color.orange, fontTools.getTextFont());
        fontTools.updateFontJButton(put, 30, Color.orange, fontTools.getTextFont());
        fontTools.updateFontJButton(bringOut, 30, Color.orange, fontTools.getTextFont());
        fontTools.updateFontJButton(move, 30, Color.orange, fontTools.getTextFont());
        fontTools.updateFontJButton(orient, 30, Color.orange, fontTools.getTextFont());
        fontTools.updateFontJButton(top, 30, Color.orange, fontTools.getTextFont());
        fontTools.updateFontJButton(left, 30, Color.orange, fontTools.getTextFont());
        fontTools.updateFontJButton(right, 30, Color.orange, fontTools.getTextFont());
        fontTools.updateFontJButton(bottom, 30, Color.orange, fontTools.getTextFont());
    }

    public synchronized void start() {
        running = true;
        thread = new Thread(this, "Display");
        thread.start();
    }

    public synchronized void stop() {
        running = false;
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void run() {
        frame.requestFocus();
        while(running) {
            update();
            render();
        }
        stop();
    }

    public void update() {
        setButtonEnabled();
        boolean actionPerformed = false;
        if(!board.pieceSelected()){
            if(putActive){
                actionPerformed = actionPut();
            }
            selectPiece();
        }
        else{
            if(moveActive){
                actionPerformed = actionMove();
            }
            else if(bringOutActive){
                actionPerformed = actionBringOut();
            }
            else if(orientActive){
                actionPerformed = actionOrient();
            }
        }
        if(actionPerformed){
            nextPlayer();
        }
    }

    public void render() {

    }

    private void setControl(ActionListener actionListener) {
        put.addActionListener(actionListener);
        bringOut.addActionListener(actionListener);
        move.addActionListener(actionListener);
        orient.addActionListener(actionListener);
        top.addActionListener(actionListener);
        left.addActionListener(actionListener);
        right.addActionListener(actionListener);
        bottom.addActionListener(actionListener);
        newGame.addActionListener(actionListener);
        save.addActionListener(actionListener);
        rules.addActionListener(actionListener);
        backToMenu.addActionListener(actionListener);
        song.addActionListener(actionListener);
        board.addMouseListener(mouse);
    }

    public void actionPerformed(ActionEvent actionEvent) {
        Object source = actionEvent.getSource();
        mouse.openClick();
        if (source == newGame) {
            frame.setJMenuBar(null);
            new Menu(frame, false, true);
        } else if (source == save) {
            //TODO - Sauvegarde
            frame.setJMenuBar(null);
            new Menu(frame, false, false);
        } else if (source == rules) {
            //TODO - Affichage règles
        } else if (source == backToMenu) {
            frame.setJMenuBar(null);
            new Menu(frame, false, false);
        } else if (source == song) {
            if (songEnable) {
                songEnable = false;
                song.setText(SONG_DISABLE_BAR);
            } else {
                songEnable = true;
                song.setText(SONG_ENABLE_BAR);
            }
        }
        else if(source == put){
            mouse.closeClick();
            mouse.openClick();
            setButtonSelected(1);
        }
        else if(source == move){
            mouse.closeClick();
            mouse.openClick();
            setButtonSelected(2);
        }
        else if(source == bringOut){
            setButtonSelected(3);
        }
        else if(source == orient){
            setButtonSelected(4);
        }
        else if(source == top){
            upActive = true;
        }
        else if(source == bottom){
            downActive = true;
        }
        else if(source == right){
            rightActive = true;
        }
        else if(source == left){
            leftActive = true;
        }

    }

    public void setButtonEnabled(){
        top.setEnabled(orientActive);
        bottom.setEnabled(orientActive);
        right.setEnabled(orientActive);
        left.setEnabled(orientActive);

        put.setEnabled(players[playerActive].canPut());
        move.setEnabled(board.pieceSelected());
        bringOut.setEnabled(testBringOut());
        orient.setEnabled(board.pieceSelected());
    }

    public void setButtonSelected(int buttonSelected){
        switch(buttonSelected){
            case 1:
                //System.out.println("put");
                putActive = true;
                moveActive = false;
                bringOutActive = false;
                orientActive = false;
                break;
            case 2 :
                //System.out.println("move");
                moveActive = true;
                putActive = false;
                bringOutActive = false;
                orientActive = false;
                break;
            case 3 :
                //System.out.println("bringOut");
                bringOutActive = true;
                moveActive = false;
                putActive = false;
                orientActive = false;
                break;
            case 4 :
                //System.out.println("orient");
                orientActive = true;
                moveActive = false;
                bringOutActive = false;
                putActive = false;
                break;
            default:
                System.out.println("je passe ici ? ");
                putActive = false;
                moveActive = false;
                bringOutActive = false;
                orientActive = false;
        }
    }

    public boolean testBringOut(){
        if(board.getPieceSelected() != null){
            int[] coord = convertPixToCase(board.getPieceSelected().getCoord());
            return board.isOnEdge(coord[0],coord[1]);
        }
        return false;
    }

    public boolean actionPut(){
        if(mouse.isSelected()) {
            int[] coord = convertCaseToPix(mouse.getClick());
            if (board.isOnEdge(mouse.getClick()[0], mouse.getClick()[1])) {
                if (board.isFree(mouse.getClick()[0], mouse.getClick()[1])) {
                    Animal animal;
                    if (playerActive == 0)
                        animal = new Animal(coord[0], coord[1], Sprite.whitePiece,
                                players[playerActive].getCamp(), Orientation.TOP);
                    else
                        animal = new Animal(coord[0], coord[1], Sprite.blackPiece,
                                players[playerActive].getCamp(), Orientation.TOP);
                    animal.selected();
                    board.putPiece(animal);
                    putActive = false;
                    orientActive = true;
                    mouse.closeClick();
                    players[playerActive].put();
                    return actionOrient();
                }
            } else {
                // entrée en poussant
            }
        }
        return false;
    }

    public boolean actionBringOut(){
        board.removePiece(convertPixToCase(board.getPieceSelected().getCoord()));
        players[playerActive].bringOut();
        mouse.closeClick();
        mouse.openClick();
        return true;
    }

    public boolean actionMove(){
        if(mouse.isSelected()) {
            if (isAdjacent()) {
                if(board.isFree(mouse.getClick()[0],mouse.getClick()[1])){
                    int[] newCoordPix = convertCaseToPix(mouse.getClick());
                    board.getPieceSelected().setPosition(newCoordPix[0],newCoordPix[1]);
                    board.movePiece(mouse.getClick()[0],mouse.getClick()[1]);
                }
            } else {
                return false;
            }
            moveActive = false;
            board.deselect();
            mouse.closeClick();
            mouse.openClick();
            return true;
        }
        return false;
    }

    public boolean actionOrient(){
        if(board.getPieceSelected() != null){
            boolean actionPerformed = false;
            Orientation oldOrient = board.getPieceSelected().getOrientation();
            if(upActive){
                board.getPieceSelected().setOrientation(Orientation.TOP);
                actionPerformed = true;
            }
            else if(downActive){
                board.getPieceSelected().setOrientation(Orientation.DOWN);
                actionPerformed = true;
            }
            else if(rightActive){
                board.getPieceSelected().setOrientation(Orientation.RIGTH);
                actionPerformed = true;
            }
            else if(leftActive){
                board.getPieceSelected().setOrientation(Orientation.LEFT);
                actionPerformed = true;
            }
            if(actionPerformed) {
                upActive = false;
                downActive = false;
                rightActive = false;
                leftActive = false;
                double angle = getAngle(oldOrient,board.getPieceSelected().getOrientation());
                if(angle != 0)
                    board.getPieceSelected().setSprite(Sprite.rotate(board.getPieceSelected().getSprite(),angle));
                board.deselect();
                orientActive = false;
                mouse.closeClick();
                mouse.openClick();
                return true;
            }
        }
        return false;
    }

    public int[] convertCaseToPix(int[] point){
        return new int[]{point[0]*SPRITE_SIZE+BOARD_BORDER/2,point[1]*SPRITE_SIZE+BOARD_BORDER/2};
    }

    public int[] convertPixToCase(int[] point){
        return new int[]{point[0]/SPRITE_SIZE,point[1]/SPRITE_SIZE};
    }

    public void nextPlayer(){
        if(playerActive == 0) playerActive = 1;
        else if(playerActive == 1) playerActive = 0;
    }

    public double getAngle(Orientation oldOrient, Orientation newOrient){
        if(oldOrient != board.getPieceSelected().getOrientation()){
            if(oldOrient == Orientation.TOP){
                if(newOrient == Orientation.RIGTH){
                    return Math.PI*2;
                }
                else if(newOrient == Orientation.DOWN){
                    return Math.PI/2;
                }
                else if(newOrient == Orientation.LEFT){
                    return Math.PI;
                }
            }
            else if(oldOrient == Orientation.RIGTH){
                if(newOrient == Orientation.DOWN){
                    return Math.PI*2;
                }
                else if(newOrient == Orientation.LEFT){
                    return Math.PI/2;
                }
                else if(newOrient == Orientation.TOP){
                    return Math.PI;
                }
            }
            else if(oldOrient == Orientation.DOWN){
                if(newOrient == Orientation.LEFT){
                    return Math.PI*2;
                }
                else if(newOrient == Orientation.TOP){
                    return Math.PI/2;
                }
                else if(newOrient == Orientation.RIGTH){
                    return Math.PI;
                }
            }
            else if(oldOrient == Orientation.LEFT){
                if(newOrient == Orientation.TOP){
                    return Math.PI*2;
                }
                else if(newOrient == Orientation.RIGTH){
                    return Math.PI/2;
                }
                else if(newOrient == Orientation.DOWN){
                    return Math.PI;
                }
            }
        }
        return 0;
    }

    public void selectPiece(){

        if(mouse.isSelected()){
            if(board.getPiece(mouse.getClick()[0],mouse.getClick()[1]) != null){
                if(board.getPiece(mouse.getClick()[0],mouse.getClick()[1]).getCamp() == players[playerActive].getCamp()){
                    board.deselect();
                    board.select(mouse.getClick()[0],mouse.getClick()[1]);
                }
            }
        }
    }

    public boolean isAdjacent(){
        int[] coordPieceSelected = convertPixToCase(board.getPieceSelected().getCoord());
        if(coordPieceSelected[0] == mouse.getClick()[0]){
            if(board.isInBound(coordPieceSelected[0],coordPieceSelected[1] - 1)){
                if(coordPieceSelected[1] - 1 == mouse.getClick()[1]){
                    return true;
                }
            }
            if(board.isInBound(coordPieceSelected[0],coordPieceSelected[1] + 1)){
                if(coordPieceSelected[1] + 1 == mouse.getClick()[1]){
                    return true;
                }
            }
        }
        if(coordPieceSelected[1] == mouse.getClick()[1]){
            if(board.isInBound(coordPieceSelected[0] - 1,coordPieceSelected[1])){
                if(coordPieceSelected[0] - 1 == mouse.getClick()[0]){
                    return true;
                }
            }
            if(board.isInBound(coordPieceSelected[0] + 1,coordPieceSelected[1])){
                if(coordPieceSelected[0] + 1 == mouse.getClick()[0]){
                    return true;
                }
            }
        }
        return false;
    }
}