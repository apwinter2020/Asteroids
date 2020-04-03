package ir.sharif.math.ap98.asteroid.UserInterfaces.SwingGUI;

import ir.sharif.math.ap98.asteroid.Intefaces.Updatable;
import ir.sharif.math.ap98.asteroid.Logic.Updater;
import ir.sharif.math.ap98.asteroid.UserInterfaces.Mapper;
import ir.sharif.math.ap98.asteroid.Util.ImageLoader;
import ir.sharif.math.ap98.asteroid.Util.PanelConfig;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;


public class GamePanel extends JPanel implements Updatable {

    private Drawer drawer;
    private Updater updater;
    private Mapper mapper;
    private GameAction gameAction;
    private BufferedImage bgImage;
    private PanelConfig config;


    private int bgImageX;
    private int bgImageY;
    private int bgImageSpeedX;
    private int bgImageSpeedY;
    private int coefficient;
    private int timeCounter;


    public GamePanel() {
        super();
        init();
        start();
    }


    private void init() {
        updater = new Updater();
        mapper = Mapper.getInstance();
        gameAction = new GameAction(this);
        config = new PanelConfig("GAMEPANEL_CONFIG_FILE");

        configurePanel();
    }

    private void start() {
        javax.swing.Timer t = new javax.swing.Timer(16, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                update();
                draw();
            }
        });
        t.start();
    }

    private void configurePanel() {

        this.bgImage = ImageLoader.getInstance().loadImage(config.getBgImage());
        this.bgImageX = config.getBgImageX();
        this.bgImageY = config.getBgImageY();
        this.bgImageSpeedX = config.getBgImageSpeedX();
        this.bgImageSpeedY = config.getBgImageSpeedY();
        this.coefficient = config.getCoefficient();
        this.timeCounter = config.getTimeCounter();

        this.setSize(config.getWidth(), config.getHeight());
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        if (drawer == null) drawer = new Drawer(g2d);
        drawer.setGraphics2D(g2d);
        paintGamePanel(g2d);
    }

    private void paintGamePanel(Graphics2D graphics2D) {
        graphics2D.drawImage(this.bgImage, this.bgImageX, this.bgImageY, null);

        if (Mapper.getGameState().isGameOver()) {
            drawer.drawGameOver();
        } else {
            drawer.drawGameState(Mapper.getGameState());
        }
    }

    private void updateBackgroundImage() {
        updateCounter();

        bgImageX += coefficient * bgImageSpeedX;
        bgImageY += coefficient * bgImageSpeedY;
    }

    private void updateCounter() {
        if (timeCounter % 100 == 0) {
            coefficient *= -1;
            timeCounter = 1;
        }
        this.timeCounter++;
    }

    @Override
    public void update() {
        updateBackgroundImage();
        mapper.executeRequests();
        updater.update();
    }

    private void draw() {
        repaint();
        revalidate();
    }

    @Override
    public void addNotify() {
        super.addNotify();
        requestFocus();
    }
}