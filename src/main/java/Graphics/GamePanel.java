package main.java.Graphics;

import main.java.Intefaces.Updatable;
import main.java.Logic.Mapper;
import main.java.Logic.Updater;
import main.java.Util.ConfigLoader;
import main.java.Util.ImageLoader;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.util.Properties;


public class GamePanel extends JPanel implements Updatable {

    private Drawer drawer;
    private Updater updater;
    private Mapper mapper;
    private GameAction gameAction;
    private BufferedImage bgImage;

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

//        try (Scanner input = new Scanner(new File(Urls.createUrls("default").getProperty("GAMEPANEL_CONFIG_FILE")))) {
        Properties properties = ConfigLoader.getInstance("default").getProperties("GAMEPANEL_CONFIG_FILE");

        this.bgImage = ImageLoader.getInstance().loadImage(properties.getProperty("bgImage"));
        this.bgImageX = Integer.parseInt(properties.getProperty("bgImageX"));
        this.bgImageY = Integer.parseInt(properties.getProperty("bgImageY"));
        this.bgImageSpeedX = Integer.parseInt(properties.getProperty("bgImageSpeedX"));
        this.bgImageSpeedY = Integer.parseInt(properties.getProperty("bgImageSpeedY"));
        this.coefficient = Integer.parseInt(properties.getProperty("coefficient"));
        this.timeCounter = Integer.parseInt(properties.getProperty("timeCounter"));

        this.setSize(Integer.parseInt(properties.getProperty("width")), Integer.parseInt(properties.getProperty("height")));

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (drawer == null) drawer = new Drawer((Graphics2D) g);
        drawer.setGraphics2D((Graphics2D) g);
        paintGamePanel((Graphics2D) g);
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

    public void draw() {
        repaint();
        revalidate();
    }

    @Override
    public void addNotify() {
        super.addNotify();
        requestFocus();
    }
}