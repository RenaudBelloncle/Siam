package siam;

import siam.graphics.FontTools;
import siam.graphics.TextureManager;
import siam.level.Board;
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

    private Thread thread;
    private boolean running = false;

    public Game() {
        board = new Board(BOARD_SIZE);
        players = new Player[2];
        for (int i = 0; i < 2; i++) {
            players[i] = new Player();
        }

        frame = new JFrame();

        Dimension dimension = new Dimension(WIN_WIDTH, WIN_HEIGTH);
        frame.setPreferredSize(dimension);

        initFrame();
        renderFrame();

        setControl(this);

        frame.setResizable(false);
        frame.setTitle(TITLE);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        start();
    }

    public Game(JFrame frame) {
        board = new Board(BOARD_SIZE);
        players = new Player[2];
        for (int i = 0; i < 2; i++) {
            players[i] = new Player();
        }

        this.frame = frame;

        Dimension dimension = new Dimension(WIN_WIDTH, WIN_HEIGTH);
        frame.setPreferredSize(dimension);

        initFrame();
        renderFrame();

        setControl(this);

        frame.setVisible(true);

        start();
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    private void initFrame() {
        playerName = new JLabel(players[0].getName());
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

    }

    public void render() {
        frame.repaint();
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
    }

    public void actionPerformed(ActionEvent actionEvent) {
        Object source = actionEvent.getSource();
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
    }
}