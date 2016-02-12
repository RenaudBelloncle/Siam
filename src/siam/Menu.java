package siam;

import siam.audio.Music;
import siam.audio.SoundsLibrary;
import siam.graphics.FontTools;
import siam.graphics.TextureManager;
import siam.player.Player;
import siam.player.Theme;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

public class Menu implements ActionListener, Constants, Texts {

    private FontTools fontTools = new FontTools();

    private boolean optionState;
    private boolean campState;
    private boolean winnerState;
    private boolean songEnable = true;
    private boolean variantPieceOn;
    private boolean variantTileOn;
    private boolean variantMountainOn;

    private JFrame frame;
    private JLabel title;
    private JButton play;
    private JButton option;
    private JButton theme;
    private JButton exit;
    private JLabel optionLabel;
    private JButton rules;
    private JButton song;
    private JLabel whiteLabel;
    private JTextField whiteField;
    private JLabel blackLabel;
    private JTextField blackField;
    private JCheckBox variantPiece;
    private JCheckBox variantTile;
    private JCheckBox variantMountain;
    private JLabel victory;

    private Player winner;
    private Music music;
    private SoundsLibrary soundsLibrary;

    private Theme themes = Theme.STANDARD;

    public Menu() {
        this.music = new Music();
        this.soundsLibrary = new SoundsLibrary();
        music.start();

        optionState = false;
        campState = false;
        winnerState = false;

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
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public Menu(JFrame frame, boolean option, boolean camp, Music music,
                SoundsLibrary soundsLibrary, boolean songEnable) {
        if (option && camp) camp = false;
        optionState = option;
        campState = camp;
        winnerState = false;

        variantMountainOn = false;
        variantPieceOn = false;
        variantTileOn = false;

        this.frame = frame;
        this.music = music;
        this.songEnable = songEnable;
        this.soundsLibrary = soundsLibrary;

        Dimension dimension = new Dimension(WIN_WIDTH, WIN_HEIGTH);
        frame.setPreferredSize(dimension);

        initFrame();
        renderFrame();

        setControl(this);

        frame.setVisible(true);
    }

    public Menu(JFrame frame, Player winner, Music music,
                SoundsLibrary soundsLibrary, boolean songEnable) {
        optionState = false;
        campState = false;
        winnerState = true;

        this.winner = winner;

        this.frame = frame;
        this.music = music;
        this.songEnable = songEnable;
        this.soundsLibrary = soundsLibrary;

        Dimension dimension = new Dimension(WIN_WIDTH, WIN_HEIGTH);
        frame.setPreferredSize(dimension);

        initFrame();
        renderFrame();

        setControl(this);

        frame.setVisible(true);
    }

    private void initFrame() {
        if (winnerState) {
            victory = new JLabel(WINNER_LABEL + winner.getName());
            play = new JButton(PLAY_BUTTON);
            exit = new JButton(EXIT_BUTTON);
        } else if (campState) {
            title = new JLabel(TITLE_CAMP_LABEL);
            whiteLabel = new JLabel(WHITE_LABEL);
            whiteField = new JTextField(WHITE_LABEL);
            whiteField.setPreferredSize(new Dimension(300, 40));
            blackLabel = new JLabel(BLACK_LABEL);
            blackField = new JTextField(BLACK_LABEL);
            blackField.setPreferredSize(new Dimension(300, 40));
            variantPiece = new JCheckBox(VARIANT_PIECE);
            variantTile = new JCheckBox(VARIANT_TILE);
            variantMountain = new JCheckBox(VARIANT_MOUNTAIN);
            play = new JButton(PLAY_BUTTON);
            exit = new JButton(EXIT_BUTTON);
        } else if (optionState) {
            title = new JLabel(TITLE_LABEL);
            optionLabel = new JLabel(OPTION_LABEL);
            rules = new JButton(RULES_BUTTON);
            theme = new JButton(THEME_BUTTON);
            if (songEnable) {
                song = new JButton(SONG_ENABLE_BUTTON);
            } else {
                song = new JButton(SONG_DISABLE_BUTTON);
            }
            exit = new JButton(EXIT_BUTTON);
        } else {
            title = new JLabel(TITLE_LABEL);
            play = new JButton(PLAY_BUTTON);
            option = new JButton(OPTION_BUTTON);
            exit = new JButton(EXIT_BUTTON);
        }
    }

    private void renderFrame() {
        JPanel mainPanel;
        if (winnerState) {
            switch (winner.getCamp()) {
                case WHITE:
                    mainPanel = new JPanel() {
                        BufferedImage image = TextureManager.library.getImage("White Background");
                        public void paintComponent(Graphics g) {
                            super.paintComponent(g);
                            frame.repaint();
                            g.drawImage(image, 0, 0, WIN_WIDTH, WIN_HEIGTH, this);
                        }
                    };
                    break;
                case BLACK:
                    mainPanel = new JPanel() {
                        BufferedImage image = TextureManager.library.getImage("Black Background");
                        public void paintComponent(Graphics g) {
                            super.paintComponent(g);
                            frame.repaint();
                            g.drawImage(image, 0, 0, WIN_WIDTH, WIN_HEIGTH, this);
                        }
                    };
                    break;
                default:
                    mainPanel = new JPanel();
                    break;
            }
            JPanel emptyPanel = new JPanel();
            JPanel textPanel = new JPanel();
            JPanel buttonPanel = new JPanel();

            updateFonts();

            mainPanel.setOpaque(false);
            emptyPanel.setOpaque(false);
            textPanel.setOpaque(false);
            buttonPanel.setOpaque(false);

            textPanel.add(victory);

            buttonPanel.setLayout(new GridLayout(1, 2));
            buttonPanel.add(play);
            buttonPanel.add(exit);

            mainPanel.setLayout(new GridLayout(3, 1));
            mainPanel.add(emptyPanel);
            mainPanel.add(textPanel);
            mainPanel.add(buttonPanel);
        } else if (campState) {
            mainPanel = new JPanel() {
                BufferedImage image = TextureManager.library.getImage("Camp Background");
                public void paintComponent(Graphics g) {
                    super.paintComponent(g);
                    frame.repaint();
                    g.drawImage(image, 0, 0, WIN_WIDTH, WIN_HEIGTH, this);
                }
            };
            JPanel titlePanel = new JPanel();
            JPanel whitePanel = new JPanel();
            JPanel blackPanel = new JPanel();
            JPanel variantPanel = new JPanel();
            JPanel variant1Panel = new JPanel();
            JPanel variant2Panel = new JPanel();
            JPanel variant3Panel = new JPanel();
            JPanel buttonPanel = new JPanel();
            JPanel playPanel = new JPanel();
            JPanel exitPanel = new JPanel();

            mainPanel.setOpaque(false);
            titlePanel.setOpaque(false);
            whitePanel.setOpaque(false);
            blackPanel.setOpaque(false);
            variantPanel.setOpaque(false);
            variant1Panel.setOpaque(false);
            variant2Panel.setOpaque(false);
            variant3Panel.setOpaque(false);
            buttonPanel.setOpaque(false);
            playPanel.setOpaque(false);
            exitPanel.setOpaque(false);

            updateFonts();

            titlePanel.add(title);

            whitePanel.add(whiteLabel);
            whitePanel.add(whiteField);

            blackPanel.add(blackLabel);
            blackPanel.add(blackField);

            variant1Panel.add(variantPiece);
            variant2Panel.add(variantTile);
            variant3Panel.add(variantMountain);

            variantPanel.setLayout(new GridLayout(3, 1));
            variantPanel.add(variant1Panel);
            variantPanel.add(variant2Panel);
            variantPanel.add(variant3Panel);

            playPanel.add(play);
            exitPanel.add(exit);

            buttonPanel.setLayout(new GridLayout(1, 2));
            buttonPanel.add(playPanel);
            buttonPanel.add(exitPanel);

            mainPanel.setLayout(new GridLayout(5, 1));
            mainPanel.add(titlePanel);
            mainPanel.add(whitePanel);
            mainPanel.add(blackPanel);
            mainPanel.add(variantPanel);
            mainPanel.add(buttonPanel);
        } else if (optionState) {
            mainPanel = new JPanel() {
                BufferedImage image = TextureManager.library.getImage("Menu Background");
                public void paintComponent(Graphics g) {
                    super.paintComponent(g);
                    frame.repaint();
                    g.drawImage(image, 0, 0, WIN_WIDTH, WIN_HEIGTH, this);
                }
            };
            JPanel titlePanel = new JPanel();
            JPanel emptyPanel1 = new JPanel();
            JPanel emptyPanel2 = new JPanel();
            JPanel buttonPanel = new JPanel();

            mainPanel.setOpaque(false);
            titlePanel.setOpaque(false);
            emptyPanel1.setOpaque(false);
            emptyPanel2.setOpaque(false);
            buttonPanel.setOpaque(false);

            updateFonts();

            titlePanel.add(title);

            buttonPanel.setLayout(new GridLayout(6, 1));
            buttonPanel.add(optionLabel);
            buttonPanel.add(rules);
            buttonPanel.add(theme);
            buttonPanel.add(song);
            buttonPanel.add(exit);

            mainPanel.setLayout(new GridLayout(2, 2));
            mainPanel.add(titlePanel);
            mainPanel.add(emptyPanel1);
            mainPanel.add(emptyPanel2);
            mainPanel.add(buttonPanel);
        } else {
            mainPanel = new JPanel() {
                BufferedImage image = TextureManager.library.getImage("Menu Background");
                public void paintComponent(Graphics g) {
                    super.paintComponent(g);
                    frame.repaint();
                    g.drawImage(image, 0, 0, WIN_WIDTH, WIN_HEIGTH, this);
                }
            };
            JPanel titlePanel = new JPanel();
            JPanel emptyPanel1 = new JPanel();
            JPanel emptyPanel2 = new JPanel();
            JPanel buttonPanel = new JPanel();

            mainPanel.setOpaque(false);
            titlePanel.setOpaque(false);
            emptyPanel1.setOpaque(false);
            emptyPanel2.setOpaque(false);
            buttonPanel.setOpaque(false);

            updateFonts();

            titlePanel.add(title);

            buttonPanel.setLayout(new GridLayout(4, 1));
            buttonPanel.add(play);
            buttonPanel.add(option);
            buttonPanel.add(exit);

            mainPanel.setLayout(new GridLayout(2, 2));
            mainPanel.add(titlePanel);
            mainPanel.add(emptyPanel1);
            mainPanel.add(emptyPanel2);
            mainPanel.add(buttonPanel);
        }

        frame.setContentPane(mainPanel);
    }

    private void updateFonts() {
        if (winnerState) {
            fontTools.updateFontJLabel(victory, 80, Color.orange, fontTools.getTextFont());
            fontTools.updateFontJButton(play, 40, Color.orange, fontTools.getTextFont());
            fontTools.updateFontJButton(exit, 40, Color.orange, fontTools.getTextFont());
        } else if (campState) {
            fontTools.updateFontJLabel(title, 80, Color.orange, fontTools.getMenuFont());
            fontTools.updateFontJLabel(whiteLabel, 60, Color.orange, fontTools.getTextFont());
            fontTools.updateFontJTextField(whiteField, 40, Color.orange, fontTools.getTextFont());
            fontTools.updateFontJLabel(blackLabel, 60, Color.orange, fontTools.getTextFont());
            fontTools.updateFontJTextField(blackField, 40, Color.orange, fontTools.getTextFont());
            fontTools.updateFontJCheckBox(variantPiece, 30, Color.orange, fontTools.getTextFont());
            fontTools.updateFontJCheckBox(variantTile, 30, Color.orange, fontTools.getTextFont());
            fontTools.updateFontJCheckBox(variantMountain, 30, Color.orange, fontTools.getTextFont());
            fontTools.updateFontJButton(play, 60, Color.orange, fontTools.getTextFont());
            fontTools.updateFontJButton(exit, 60, Color.orange, fontTools.getTextFont());
        } else if (optionState) {
            fontTools.updateFontJLabel(title, 150, Color.orange, fontTools.getMenuFont());
            fontTools.updateFontJLabel(optionLabel, 60, Color.orange, fontTools.getMenuFont());
            fontTools.updateFontJButton(rules, 50, Color.orange, fontTools.getTextFont());
            fontTools.updateFontJButton(theme, 50, Color.orange, fontTools.getTextFont());
            fontTools.updateFontJButton(song, 50, Color.orange, fontTools.getTextFont());
            fontTools.updateFontJButton(exit, 50, Color.orange, fontTools.getTextFont());
        } else {
            fontTools.updateFontJLabel(title, 150, Color.orange, fontTools.getMenuFont());
            fontTools.updateFontJButton(play, 60, Color.orange, fontTools.getTextFont());
            fontTools.updateFontJButton(option, 60, Color.orange, fontTools.getTextFont());
            fontTools.updateFontJButton(exit, 60, Color.orange, fontTools.getTextFont());
        }
    }

    private void setControl(ActionListener actionListener) {
        if (winnerState) {
            play.addActionListener(actionListener);
            exit.addActionListener(actionListener);
        } else if (campState) {
            play.addActionListener(actionListener);
            exit.addActionListener(actionListener);
        } else if (optionState) {
            rules.addActionListener(actionListener);
            theme.addActionListener(actionListener);
            song.addActionListener(actionListener);
            exit.addActionListener(actionListener);
        } else {
            play.addActionListener(actionListener);
            option.addActionListener(actionListener);
            exit.addActionListener(actionListener);
        }
    }

    public void actionPerformed(ActionEvent actionEvent) {
        Object source = actionEvent.getSource();
        soundsLibrary.playButtonSound(themes);
        if (winnerState) {
            if (source == play) {
                new Game(frame, music, soundsLibrary, songEnable, variantMountainOn,variantPieceOn, variantTileOn);
            } else if (source == exit) {
                new Menu(frame, false, false, music, soundsLibrary, songEnable);
            }
        } else if (campState) {
            if (source == play) {
                new Game(frame, music, soundsLibrary, songEnable, variantMountain.isSelected(),variantPiece.isSelected(), variantTile.isSelected());
            } else if (source == exit) {
                new Menu(frame, false, false, music, soundsLibrary, songEnable);
            }
        } else if (optionState) {
            if (source == rules) {
                //TODO - Affichage règles
            } else if (source == song) {
                if (!songEnable) {
                    song.setText(SONG_ENABLE_BUTTON);
                    music.start();
                    songEnable = true;
                } else {
                    song.setText(SONG_DISABLE_BUTTON);
                    music.stopIt();
                    songEnable = false;
                }
            } else if (source == exit) {
                new Menu(frame, false, false, music, soundsLibrary, songEnable);
            } else if (source == theme) {

            }
        } else {
            if (source == play) {
                new Menu(frame, false, true, music, soundsLibrary, songEnable);
            } else if (source == option) {
                new Menu(frame, true, false, music, soundsLibrary, songEnable);
            } else if (source == exit) {
                System.exit(0);
            }
        }
    }

}