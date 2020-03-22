package main.java.Graphics;

import main.java.Intefaces.Updatable;
import main.java.Logic.GameState;
import main.java.Models.AsteroidGroup;
import main.java.Models.Player;
import main.java.Util.ImageLoader;
import main.java.Util.Urls;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.IllegalFormatCodePointException;
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


        this.configPanel();

        this.myTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                GamePanel.this.update();

            }
        }, 1, 10);
    }

    private void configPanel() {

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

        g.drawImage(this.bgImage, this.bgImageX, this.bgImageY, null);

        if (drawer == null) drawer = new Drawer((Graphics2D) g);

        if (GameState.getInstance().isGameOver()) {
            drawer.drawGameOver((Graphics2D) g);
        } else {
            drawer.drawGameState((Graphics2D) g);
        }

    }

    @Override
    public void update() {

        GameState.getInstance().update();

        this.revalidate();
        this.repaint();

        if (this.timeCounter % 100 == 0) {
            this.coefficient *= -1;
            this.timeCounter = 1;
        }

        this.bgImageX += coefficient * this.bgImageSpeedX;
        this.bgImageY += coefficient * this.bgImageSpeedY;

        this.timeCounter++;
    }

}