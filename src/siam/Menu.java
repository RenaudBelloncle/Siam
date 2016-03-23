package siam;

import siam.audio.Music;
import siam.audio.SoundsLibrary;
import siam.graphics.FontTools;
import siam.graphics.Sprite;
import siam.graphics.TextureManager;
import siam.player.Player;
import siam.player.Theme;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Menu implements ActionListener, Constants, Texts {

    private FontTools fontTools = new FontTools();

    private boolean optionState;
    private boolean campState;
    private boolean winnerState;
    private boolean playState;
    private boolean multiState;

    private boolean songEnable;
    private boolean ai;
    private boolean variantPieceOn;
    private boolean variantTileOn;
    private boolean variantMountainOn;

    private JFrame frame;
    private JLabel title;
    private JButton play;
    private JButton option;
    private JButton theme;
    private JButton exit;
    private JLabel secondTitle;
    private JButton rules;
    private JButton song;
    private JButton local;
    private JButton host;
    private JButton join;
    private JTextField ip;
    private JButton online;
    private JButton computer;
    private JLabel whiteLabel;
    private JTextField whiteField;
    private JLabel blackLabel;
    private JTextField blackField;
    private JCheckBox variantPiece;
    private JCheckBox variantTile;
    private JCheckBox variantMountain;
    private JRadioButton whiteCamp;
    private JRadioButton blackCamp;
    private JLabel victory;

    private Player winner;
    private Player loser;
    private Music music;
    private SoundsLibrary soundsLibrary;

    private Theme themes = Theme.STANDARD;

    // Utilisé uniquement la première frois
    public Menu() {
        optionState = false;
        campState = false;
        winnerState = false;
        playState = false;
        multiState = false;

        frame = new JFrame();
        this.music = new Music(themes);
        songEnable = true;
        this.soundsLibrary = new SoundsLibrary();
        music.start();

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

    // Utilisé pour le menu de base, les options et les différentes style de jeu
    public Menu(JFrame frame, boolean option, boolean play, Music music,
                SoundsLibrary soundsLibrary, boolean songEnable, Theme theme) {
        if (option && play) play = false;
        this.optionState = option;
        this.playState = play;
        this.winnerState = false;
        this.campState = false;
        this.multiState = false;

        this.frame = frame;
        this.music = music;
        this.songEnable = songEnable;
        this.soundsLibrary = soundsLibrary;

        this.themes = theme;

        Dimension dimension = new Dimension(WIN_WIDTH, WIN_HEIGTH);
        frame.setPreferredSize(dimension);

        initFrame();
        renderFrame();

        setControl(this);

        frame.setVisible(true);
    }

    // Utilisé pour choisir son camp
    public Menu(JFrame frame, boolean ai, Music music, SoundsLibrary soundsLibrary,
                boolean songEnable, Theme theme) {
        optionState = false;
        campState = true;
        winnerState = false;
        playState = false;
        multiState = false;

        this.ai = ai;
        variantMountainOn = false;
        variantPieceOn = false;
        variantTileOn = false;

        this.frame = frame;
        this.music = music;
        this.songEnable = songEnable;
        this.soundsLibrary = soundsLibrary;

        this.themes = theme;

        Dimension dimension = new Dimension(WIN_WIDTH, WIN_HEIGTH);
        frame.setPreferredSize(dimension);

        initFrame();
        renderFrame();

        setControl(this);

        frame.setVisible(true);
    }

    // Utilisé pour les victoires
    public Menu(JFrame frame, Player winner, Player loser, Music music,
                SoundsLibrary soundsLibrary, boolean songEnable, Theme theme,
                boolean variantPieceOn, boolean variantTileOn, boolean variantMountainOn,
                boolean ai) {
        optionState = false;
        campState = false;
        winnerState = true;
        playState = false;
        multiState = false;

        this.themes = theme;
        this.winner = winner;
        this.loser = loser;

        this.frame = frame;
        this.music = music;
        this.songEnable = songEnable;
        this.soundsLibrary = soundsLibrary;

        this.variantPieceOn = variantPieceOn;
        this.variantTileOn = variantTileOn;
        this.variantMountainOn = variantMountainOn;
        this.ai = ai;

        Dimension dimension = new Dimension(WIN_WIDTH, WIN_HEIGTH);
        frame.setPreferredSize(dimension);

        initFrame();
        renderFrame();

        setControl(this);

        frame.setVisible(true);
    }

    // Constructeur pour le multi
    public Menu(JFrame frame, Music music, SoundsLibrary soundsLibrary,
                boolean songEnable, Theme theme, boolean camp){
        this.optionState = false;
        this.playState = false;
        this.winnerState = false;
        this.campState = camp;
        this.multiState = true;

        this.frame = frame;
        this.music = music;
        this.songEnable = songEnable;
        this.soundsLibrary = soundsLibrary;

        this.themes = theme;

        Dimension dimension = new Dimension(WIN_WIDTH, WIN_HEIGTH);
        frame.setPreferredSize(dimension);

        initFrame();
        renderFrame();

        setControl(this);

        frame.setVisible(true);
    }

    public String getWhiteField() {
        return whiteField.getText();
    }

    public String getBlackField() {
        return blackField.getText();
    }

    public String getIpField() {
        return ip.getText();
    }

    private void initFrame() {
        if (winnerState) {
            victory = new JLabel( winner.getName() + WINNER_LABEL);
            play = new JButton(PLAY_BUTTON);
            exit = new JButton(EXIT_BUTTON);
        } else if (campState) {
            if(!multiState) {
                title = new JLabel(TITLE_CAMP_LABEL);
                whiteLabel = new JLabel(WHITE_LABEL);
                whiteField = new JTextField(WHITE_LABEL);
                whiteField.setPreferredSize(new Dimension(300, 40));
                blackLabel = new JLabel(BLACK_LABEL);
                blackField = new JTextField(BLACK_LABEL);
                blackField.setPreferredSize(new Dimension(300, 40));
                play = new JButton(PLAY_BUTTON);
                exit = new JButton(EXIT_BUTTON);
                if (ai) {
                    whiteCamp = new JRadioButton();
                    blackCamp = new JRadioButton();
                    ButtonGroup group = new ButtonGroup();
                    group.add(whiteCamp);
                    group.add(blackCamp);
                } else {
                    variantPiece = new JCheckBox(VARIANT_PIECE_LABEL);
                    variantTile = new JCheckBox(VARIANT_TILE_LABEL);
                    variantMountain = new JCheckBox(VARIANT_MOUNTAIN_LABEL);
                }
            }
            else{
                title = new JLabel(TITLE_MULTI_LABEL);
                whiteLabel = new JLabel(NAME_LABEL);
                whiteField = new JTextField(NAME_LABEL);
                whiteField.setPreferredSize(new Dimension(300, 40));

                play = new JButton(PLAY_BUTTON);
                exit = new JButton(EXIT_BUTTON);
                variantPiece = new JCheckBox(VARIANT_PIECE_LABEL);
                variantTile = new JCheckBox(VARIANT_TILE_LABEL);
                variantMountain = new JCheckBox(VARIANT_MOUNTAIN_LABEL);
            }
        } else if (playState) {
            title = new JLabel(TITLE_LABEL);
            secondTitle = new JLabel(PLAY_LABEL);
            local = new JButton(LOCAL_BUTTON);
            online = new JButton(ONLINE_BUTTON);
            computer = new JButton(COMPUTER_BUTTON);
            exit = new JButton(EXIT_BUTTON);
        } else if (optionState) {
            title = new JLabel(TITLE_LABEL);
            secondTitle = new JLabel(OPTION_LABEL);
            rules = new JButton(RULES_BUTTON);
            theme = new JButton(THEME_BUTTON);
            if (songEnable) {
                song = new JButton(SONG_ENABLE_BUTTON);
            } else {
                song = new JButton(SONG_DISABLE_BUTTON);
            }
            exit = new JButton(EXIT_BUTTON);
        } else if(multiState) {
            title = new JLabel(TITLE_LABEL);
            host = new JButton(HOST_BUTTON);
            join = new JButton(JOIN_BUTTON);
            ip = new JTextField(LABEL_IP);
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
                        BufferedImage image = TextureManager.library.getImage(themes, "White Background");
                        public void paintComponent(Graphics g) {
                            super.paintComponent(g);
                            frame.repaint();
                            g.drawImage(image, 0, 0, WIN_WIDTH, WIN_HEIGTH, this);
                        }
                    };
                    break;
                case BLACK:
                    mainPanel = new JPanel() {
                        BufferedImage image = TextureManager.library.getImage(themes, "Black Background");
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
                BufferedImage image = TextureManager.library.getImage(themes, "Camp Background");
                public void paintComponent(Graphics g) {
                    super.paintComponent(g);
                    frame.repaint();
                    g.drawImage(image, 0, 0, WIN_WIDTH, WIN_HEIGTH, this);
                }
            };
            JPanel titlePanel = new JPanel();
            JPanel whitePanel = new JPanel();
            JPanel variantPanel = new JPanel();
            JPanel variant1Panel = new JPanel();
            JPanel variant2Panel = new JPanel();
            JPanel variant3Panel = new JPanel();
            JPanel buttonPanel = new JPanel();
            JPanel emptyPanel = new JPanel();
            JPanel playPanel = new JPanel();
            JPanel exitPanel = new JPanel();

            mainPanel.setOpaque(false);
            titlePanel.setOpaque(false);
            whitePanel.setOpaque(false);
            variantPanel.setOpaque(false);
            variant1Panel.setOpaque(false);
            variant2Panel.setOpaque(false);
            variant3Panel.setOpaque(false);
            buttonPanel.setOpaque(false);
            emptyPanel.setOpaque(false);
            playPanel.setOpaque(false);
            exitPanel.setOpaque(false);

            updateFonts();

            titlePanel.add(title);

            if (ai) whitePanel.add(whiteCamp);
            whitePanel.add(whiteLabel);
            whitePanel.add(whiteField);

            if (!ai) {
                variant1Panel.add(variantPiece);
                variant2Panel.add(variantTile);
                variant3Panel.add(variantMountain);

                variantPanel.setLayout(new GridLayout(3, 1));
                variantPanel.add(variant1Panel);
                variantPanel.add(variant2Panel);
                variantPanel.add(variant3Panel);
            }

            playPanel.add(play);
            exitPanel.add(exit);

            buttonPanel.setLayout(new GridLayout(1, 2));
            buttonPanel.add(playPanel);
            buttonPanel.add(exitPanel);

            mainPanel.setLayout(new GridLayout(5, 1));
            mainPanel.add(titlePanel);
            mainPanel.add(whitePanel);
            if(!multiState){
                JPanel blackPanel = new JPanel();
                blackPanel.setOpaque(false);
                if (ai) blackPanel.add(blackCamp);
                blackPanel.add(blackLabel);
                blackPanel.add(blackField);
                mainPanel.add(blackPanel);
            }
            if (!ai) mainPanel.add(variantPanel);
            else mainPanel.add(emptyPanel);
            mainPanel.add(buttonPanel);
        } else if (playState) {
            mainPanel = new JPanel() {
                BufferedImage image = TextureManager.library.getImage(themes, "Menu Background");
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

            buttonPanel.setLayout(new GridLayout(5, 1));
            buttonPanel.add(secondTitle);
            buttonPanel.add(local);
            buttonPanel.add(computer);
            buttonPanel.add(online);
            buttonPanel.add(exit);

            mainPanel.setLayout(new GridLayout(2, 2));
            mainPanel.add(titlePanel);
            mainPanel.add(emptyPanel1);
            mainPanel.add(emptyPanel2);
            mainPanel.add(buttonPanel);
        } else if (optionState) {
            mainPanel = new JPanel() {
                BufferedImage image = TextureManager.library.getImage(themes, "Menu Background");
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
            buttonPanel.add(secondTitle);
            buttonPanel.add(rules);
            buttonPanel.add(theme);
            buttonPanel.add(song);
            buttonPanel.add(exit);

            mainPanel.setLayout(new GridLayout(2, 2));
            mainPanel.add(titlePanel);
            mainPanel.add(emptyPanel1);
            mainPanel.add(emptyPanel2);
            mainPanel.add(buttonPanel);
        }
        else if(multiState){
            mainPanel = new JPanel() {
                BufferedImage image = TextureManager.library.getImage(themes, "Menu Background");
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

            titlePanel.add(title);

            buttonPanel.setLayout(new GridLayout(3, 1));
            buttonPanel.add(host);
            buttonPanel.add(join);
            buttonPanel.add(ip);

            mainPanel.setOpaque(false);
            titlePanel.setOpaque(false);
            emptyPanel1.setOpaque(false);
            emptyPanel2.setOpaque(false);
            buttonPanel.setOpaque(false);

            updateFonts();

            mainPanel.setLayout(new GridLayout(2, 2));
            mainPanel.add(titlePanel);
            mainPanel.add(emptyPanel1);
            mainPanel.add(emptyPanel2);
            mainPanel.add(buttonPanel);
        } else {
            mainPanel = new JPanel() {
                BufferedImage image = TextureManager.library.getImage(themes, "Menu Background");
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
        if (themes == Theme.STANDARD) {
            if (winnerState) {
                fontTools.updateFontJLabel(victory, 80, Color.orange, fontTools.getTextFont());
                fontTools.updateFontJButton(play, 80, Color.orange, fontTools.getTextFont());
                fontTools.updateFontJButton(exit, 80, Color.orange, fontTools.getTextFont());
            } else if (campState) {
                fontTools.updateFontJLabel(title, 80, Color.orange, fontTools.getMenuFont());
                if (ai) fontTools.updateFondJRadioButton(whiteCamp, 60, Color.orange, fontTools.getTextFont());
                fontTools.updateFontJLabel(whiteLabel, 60, Color.orange, fontTools.getTextFont());
                fontTools.updateFontJTextField(whiteField, 40, Color.orange, fontTools.getTextFont());
                if (ai) fontTools.updateFondJRadioButton(blackCamp, 60, Color.orange, fontTools.getTextFont());
                if(!multiState) {
                    fontTools.updateFontJLabel(blackLabel, 60, Color.orange, fontTools.getTextFont());
                    fontTools.updateFontJTextField(blackField, 40, Color.orange, fontTools.getTextFont());
                }
                if (!ai) {
                    fontTools.updateFontJCheckBox(variantPiece, 30, Color.orange, fontTools.getTextFont());
                    fontTools.updateFontJCheckBox(variantTile, 30, Color.orange, fontTools.getTextFont());
                    fontTools.updateFontJCheckBox(variantMountain, 30, Color.orange, fontTools.getTextFont());
                }

                fontTools.updateFontJButton(play, 60, Color.orange, fontTools.getTextFont());
                fontTools.updateFontJButton(exit, 60, Color.orange, fontTools.getTextFont());
            } else if (playState) {
                fontTools.updateFontJLabel(title, 150, Color.orange, fontTools.getMenuFont());
                fontTools.updateFontJLabel(secondTitle, 60, Color.orange, fontTools.getMenuFont());
                fontTools.updateFontJButton(local, 50, Color.orange, fontTools.getTextFont());
                fontTools.updateFontJButton(online, 50, Color.orange, fontTools.getTextFont());
                fontTools.updateFontJButton(computer, 50, Color.orange, fontTools.getTextFont());
                fontTools.updateFontJButton(exit, 50, Color.orange, fontTools.getTextFont());
            } else if (optionState) {
                fontTools.updateFontJLabel(title, 150, Color.orange, fontTools.getMenuFont());
                fontTools.updateFontJLabel(secondTitle, 60, Color.orange, fontTools.getMenuFont());
                fontTools.updateFontJButton(rules, 50, Color.orange, fontTools.getTextFont());
                fontTools.updateFontJButton(theme, 50, Color.orange, fontTools.getTextFont());
                fontTools.updateFontJButton(song, 50, Color.orange, fontTools.getTextFont());
                fontTools.updateFontJButton(exit, 50, Color.orange, fontTools.getTextFont());
            } else if(multiState){
                fontTools.updateFontJLabel(title, 150, Color.orange, fontTools.getMenuFont());
                fontTools.updateFontJButton(host, 50, Color.orange, fontTools.getTextFont());
                fontTools.updateFontJButton(join, 50, Color.orange, fontTools.getTextFont());
                fontTools.updateFontJTextField(ip, 40, Color.orange, fontTools.getTextFont());
            }else{
                fontTools.updateFontJLabel(title, 150, Color.orange, fontTools.getMenuFont());
                fontTools.updateFontJButton(play, 60, Color.orange, fontTools.getTextFont());
                fontTools.updateFontJButton(option, 60, Color.orange, fontTools.getTextFont());
                fontTools.updateFontJButton(exit, 60, Color.orange, fontTools.getTextFont());
            }
        } else if ( themes == Theme.CHRISTMAS) {
            if (winnerState) {
                fontTools.updateFontJLabel(victory, 95, Color.red, fontTools.getTextFontChristmas());
                fontTools.updateFontJButton(play, 95, Color.red, fontTools.getTextFontChristmas());
                fontTools.updateFontJButton(exit, 95, Color.red, fontTools.getTextFontChristmas());
            } else if (campState) {
                fontTools.updateFontJLabel(title, 95, Color.red, fontTools.getMenuFontChristmas());
                if (ai) fontTools.updateFondJRadioButton(whiteCamp, 80, Color.red, fontTools.getTextFontChristmas());
                fontTools.updateFontJLabel(whiteLabel, 80, Color.red, fontTools.getTextFontChristmas());
                fontTools.updateFontJTextField(whiteField, 80, Color.red, fontTools.getTextFontChristmas());
                if (ai) fontTools.updateFondJRadioButton(blackCamp, 80, Color.red, fontTools.getTextFontChristmas());
                if(!multiState) {
                    fontTools.updateFontJLabel(blackLabel, 80, Color.red, fontTools.getTextFontChristmas());
                    fontTools.updateFontJTextField(blackField, 80, Color.red, fontTools.getTextFontChristmas());
                }
                if (!ai) {
                    fontTools.updateFontJCheckBox(variantPiece, 50, Color.red, fontTools.getTextFontChristmas());
                    fontTools.updateFontJCheckBox(variantTile, 50, Color.red, fontTools.getTextFontChristmas());
                    fontTools.updateFontJCheckBox(variantMountain, 50, Color.red, fontTools.getTextFontChristmas());
                }
                fontTools.updateFontJButton(play, 80, Color.red, fontTools.getTextFontChristmas());
                fontTools.updateFontJButton(exit, 80, Color.red, fontTools.getTextFontChristmas());
            } else if (playState) {
                fontTools.updateFontJLabel(title, 150, Color.red, fontTools.getMenuFontChristmas());
                fontTools.updateFontJLabel(secondTitle, 80, Color.red, fontTools.getMenuFontChristmas());
                fontTools.updateFontJButton(local, 80, Color.red, fontTools.getTextFontChristmas());
                fontTools.updateFontJButton(online, 80, Color.red, fontTools.getTextFontChristmas());
                fontTools.updateFontJButton(computer, 80, Color.red, fontTools.getTextFontChristmas());
                fontTools.updateFontJButton(exit, 80, Color.red, fontTools.getTextFontChristmas());
            } else if (optionState) {
                fontTools.updateFontJLabel(title, 150, Color.red, fontTools.getMenuFontChristmas());
                fontTools.updateFontJLabel(secondTitle, 80, Color.red, fontTools.getMenuFontChristmas());
                fontTools.updateFontJButton(rules, 80, Color.red, fontTools.getTextFontChristmas());
                fontTools.updateFontJButton(theme, 80, Color.red, fontTools.getTextFontChristmas());
                fontTools.updateFontJButton(song, 80, Color.red, fontTools.getTextFontChristmas());
                fontTools.updateFontJButton(exit, 80, Color.red, fontTools.getTextFontChristmas());
            } else if(multiState){
                fontTools.updateFontJLabel(title, 150, Color.red, fontTools.getMenuFontChristmas());
                fontTools.updateFontJButton(host, 80, Color.red, fontTools.getMenuFontChristmas());
                fontTools.updateFontJButton(join, 80, Color.red, fontTools.getMenuFontChristmas());
                fontTools.updateFontJTextField(ip, 80, Color.red, fontTools.getTextFontChristmas());
            }else {
                fontTools.updateFontJLabel(title, 150, Color.red, fontTools.getMenuFontChristmas());
                fontTools.updateFontJButton(play, 100, Color.red, fontTools.getTextFontChristmas());
                fontTools.updateFontJButton(option, 100, Color.red, fontTools.getTextFontChristmas());
                fontTools.updateFontJButton(exit, 100, Color.red, fontTools.getTextFontChristmas());
            }
        } else {
            if (winnerState) {
                fontTools.updateFontJLabel(victory, 70, Color.yellow, fontTools.getTextFontStarWars());
                fontTools.updateFontJButton(play, 70, Color.yellow, fontTools.getTextFontStarWars());
                fontTools.updateFontJButton(exit, 70, Color.yellow, fontTools.getTextFontStarWars());
            } else if (campState) {
                fontTools.updateFontJLabel(title, 70, Color.yellow, fontTools.getMenuFontStarWars());
                if (ai) fontTools.updateFondJRadioButton(whiteCamp, 60, Color.yellow, fontTools.getTextFontStarWars());
                fontTools.updateFontJLabel(whiteLabel, 60, Color.yellow, fontTools.getTextFontStarWars());
                fontTools.updateFontJTextField(whiteField, 70, Color.yellow, fontTools.getTextFontStarWars());
                if (ai) fontTools.updateFondJRadioButton(blackCamp, 60, Color.yellow, fontTools.getTextFontStarWars());
                if(!multiState) {
                    fontTools.updateFontJLabel(blackLabel, 70, Color.yellow, fontTools.getTextFontStarWars());
                    fontTools.updateFontJTextField(blackField, 70, Color.yellow, fontTools.getTextFontStarWars());
                }
                //fontTools.updateFontJLabel(whiteLabel, 60, Color.yellow, fontTools.getTextFontStarWars());
                if (!ai) {
                    fontTools.updateFontJCheckBox(variantPiece, 35, Color.yellow, fontTools.getTextFontStarWars());
                    fontTools.updateFontJCheckBox(variantTile, 35, Color.yellow, fontTools.getTextFontStarWars());
                    fontTools.updateFontJCheckBox(variantMountain, 35, Color.yellow, fontTools.getTextFontStarWars());
                }
                fontTools.updateFontJButton(play, 60, Color.yellow, fontTools.getTextFontStarWars());
                fontTools.updateFontJButton(exit, 60, Color.yellow, fontTools.getTextFontStarWars());
            } else if (playState) {
                fontTools.updateFontJLabel(title, 150, Color.yellow, fontTools.getMenuFontStarWars());
                fontTools.updateFontJLabel(secondTitle, 60, Color.yellow, fontTools.getMenuFontStarWars());
                fontTools.updateFontJButton(local, 50, Color.yellow, fontTools.getTextFontStarWars());
                fontTools.updateFontJButton(online, 50, Color.yellow, fontTools.getTextFontStarWars());
                fontTools.updateFontJButton(computer, 50, Color.yellow, fontTools.getTextFontStarWars());
                fontTools.updateFontJButton(exit, 50, Color.yellow, fontTools.getTextFontStarWars());
            } else if (optionState) {
                fontTools.updateFontJLabel(title, 150, Color.yellow, fontTools.getMenuFontStarWars());
                fontTools.updateFontJLabel(secondTitle, 60, Color.yellow, fontTools.getMenuFontStarWars());
                fontTools.updateFontJButton(rules, 50, Color.yellow, fontTools.getTextFontStarWars());
                fontTools.updateFontJButton(theme, 50, Color.yellow, fontTools.getTextFontStarWars());
                fontTools.updateFontJButton(song, 50, Color.yellow, fontTools.getTextFontStarWars());
                fontTools.updateFontJButton(exit, 50, Color.yellow, fontTools.getTextFontStarWars());
            } else if(multiState){
                fontTools.updateFontJLabel(title, 150, Color.yellow, fontTools.getMenuFontStarWars());
                fontTools.updateFontJButton(host, 50, Color.yellow, fontTools.getMenuFontStarWars());
                fontTools.updateFontJButton(join, 50, Color.yellow, fontTools.getMenuFontStarWars());
                fontTools.updateFontJTextField(ip, 70, Color.yellow, fontTools.getTextFontStarWars());
            }else {
                fontTools.updateFontJLabel(title, 150, Color.yellow, fontTools.getMenuFontStarWars());
                fontTools.updateFontJButton(play, 70, Color.yellow, fontTools.getTextFontStarWars());
                fontTools.updateFontJButton(option, 70, Color.yellow, fontTools.getTextFontStarWars());
                fontTools.updateFontJButton(exit, 70, Color.yellow, fontTools.getTextFontStarWars());
            }
        }
    }


    private void setControl(ActionListener actionListener) {
        if (winnerState) {
            play.addActionListener(actionListener);
            exit.addActionListener(actionListener);
        } else if (campState) {
            play.addActionListener(actionListener);
            exit.addActionListener(actionListener);
        } else if (playState) {
            local.addActionListener(actionListener);
            computer.addActionListener(actionListener);
            online.addActionListener(actionListener);
            exit.addActionListener(actionListener);
        } else if (optionState) {
            rules.addActionListener(actionListener);
            theme.addActionListener(actionListener);
            song.addActionListener(actionListener);
            exit.addActionListener(actionListener);
        } else if(multiState){
            host.addActionListener(actionListener);
            join.addActionListener(actionListener);
        } else {
            play.addActionListener(actionListener);
            option.addActionListener(actionListener);
            exit.addActionListener(actionListener);
        }
    }

    public void actionPerformed(ActionEvent actionEvent) {
        Object source = actionEvent.getSource();
        soundsLibrary.playButtonSound();
        if (winnerState) {
            if (source == play) {
                if (ai) {
                    new Menu(frame, true, music, soundsLibrary, songEnable, themes);
                } else new Game(frame, music, soundsLibrary, songEnable, variantMountainOn,
                            variantPieceOn, variantTileOn, themes, loser.getName(), winner.getName());
            } else if (source == exit) {
                new Menu(frame, false, false, music, soundsLibrary, songEnable, themes);
            }
        } else if (campState && !multiState) {
            if (source == play) {
                if (ai) {
                    if (!whiteCamp.isSelected() && !blackCamp.isSelected()) return;
                    new Game(frame, music, soundsLibrary, songEnable, themes,
                            getBlackField(), blackCamp.isSelected(), getWhiteField());
                } else {
                    new Game(frame, music, soundsLibrary, songEnable, variantMountain.isSelected(),
                            variantPiece.isSelected(), variantTile.isSelected(),
                            themes, getBlackField(), getWhiteField());
                }
            } else if (source == exit) {
                new Menu(frame, false, false, music, soundsLibrary, songEnable, themes);
            }
        } else if (playState) {
            if (source == local) {
                new Menu(frame, false, music, soundsLibrary, songEnable, themes);
            } else if (source == computer) {
                new Menu(frame, true, music, soundsLibrary, songEnable, themes);
            } else if (source == exit) {
                new Menu(frame, false, false, music, soundsLibrary, songEnable, themes);
            }
            else if(source == online){
                new Menu(frame, music, soundsLibrary, songEnable, themes, false);
            }
        } else if (optionState) {
            if (source == rules) {
                try {
                    Desktop.getDesktop().open(new File("rules.pdf"));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else if (source == theme) {
                if (themes == Theme.STANDARD) {
                    themes = Theme.CHRISTMAS;
                    updateFonts();
                    renderFrame();
                    Sprite.changeToChristmas();
                    if (songEnable) {
                        music.stopIt();
                        music = new Music(themes);
                        music.start();
                    }
                }
                else if (themes == Theme.CHRISTMAS) {
                    themes = Theme.STARWARS;
                    updateFonts();
                    renderFrame();
                    Sprite.changeToStarWars();
                    if (songEnable) {
                        music.stopIt();
                        music = new Music(themes);
                        music.start();
                    }
                }
                else {
                    themes = Theme.STANDARD;
                    updateFonts();
                    renderFrame();
                    Sprite.changeToStandard();
                    if (songEnable) {
                        music.stopIt();
                        music = new Music(themes);
                        music.start();
                    }
                }
            } else if (source == song) {
                if (!songEnable) {
                    song.setText(SONG_ENABLE_BUTTON);
                    music = new Music(themes);
                    music.start();
                    songEnable = true;
                } else {
                    song.setText(SONG_DISABLE_BUTTON);
                    music.stopIt();
                    songEnable = false;
                }
            } else if (source == exit) {
                new Menu(frame, false, false, music, soundsLibrary, songEnable, themes);
            }
        } else if(multiState){
            if(!campState) {
                if (source == host) {
                    new Server();
                    new Menu(frame, music, soundsLibrary, songEnable, themes, true);
                } else if (source == join) {
                    new Client(12345,getIpField(),frame, music, soundsLibrary, songEnable,themes,"Jerry");
                }
            }else {
                if (source == play) {
                    new Client(12345,"localhost",frame, music, soundsLibrary, songEnable, variantMountain.isSelected(),
                            variantPiece.isSelected(), variantTile.isSelected(),
                            themes,getWhiteField());
                } else if (source == exit) {
                    new Menu(frame, false, false, music, soundsLibrary, songEnable, themes);
                }
            }
        } else{
            if (source == play) {
                new Menu(frame, false, true, music, soundsLibrary, songEnable, themes);
            } else if (source == option) {
                new Menu(frame, true, false, music, soundsLibrary, songEnable, themes);
            } else if (source == exit) {
                System.exit(0);
            }
        }
    }
}
