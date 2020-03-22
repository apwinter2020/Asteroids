package main.java.Graphics;

import main.java.Intefaces.Updatable;
import main.java.Logic.GameState;
import main.java.Util.Config;
import main.java.Util.ImageLoader;
import main.java.Util.Urls;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Properties;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class GamePanel extends JPanel implements Updatable {

    private Drawer drawer;


    private Timer myTimer = new Timer();
    private BufferedImage bgImage;

    private int bgImageX;
    private int bgImageY;
    private int bgImageSpeedX;
    private int bgImageSpeedY;
    private int coefficient;
    private int timeCounter;


    public GamePanel() {
        super();
        this.init();
    }


    private void init() {
        new GameAction(this);

        this.configPanel(Config.ReadProperties(Urls.GAMEPANEL_CONFIG_FILE));

        this.myTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                GamePanel.this.update();

            }
        }, 1, 10);
    }

    private void configPanel(Properties properties) {

        try (Scanner input = new Scanner(new File(Urls.GAMEPANEL_CONFIG_FILE))) {

            this.bgImage = ImageLoader.getInstance().loadImage(input.next());
            this.bgImageX = input.nextInt();
            this.bgImageY = input.nextInt();
            this.bgImageSpeedX = input.nextInt();
            this.bgImageSpeedY = input.nextInt();
            this.coefficient = input.nextInt();
            this.timeCounter = input.nextInt();

            this.setSize(input.nextInt(), input.nextInt());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        this.paintGamePanel((Graphics2D) g);
    }

    private void paintGamePanel(Graphics2D graphics2D) {
        graphics2D.drawImage(this.bgImage, this.bgImageX, this.bgImageY, null);

        if (drawer == null) drawer = new Drawer(graphics2D);

        if (GameState.getInstance().isGameOver()) {
            drawer.drawGameOver(graphics2D);
        } else {
            drawer.drawGameState(graphics2D);
        }
    }

    private void updateBackgroundImage() {

        this.repaint();
        this.revalidate();

        this.updateCounter();

        this.bgImageX += coefficient * this.bgImageSpeedX;
        this.bgImageY += coefficient * this.bgImageSpeedY;


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
        GameState.getInstance().update();
        this.updateBackgroundImage();
    }


}