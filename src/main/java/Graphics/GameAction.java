package main.java.Graphics;

import main.java.Logic.Mapper;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;

public class GameAction implements KeyListener {

    private Timer up,right,left, down,shoot;

    private final GamePanel gamePanel;
    private final Mapper mapper;


    GameAction(GamePanel gamePanel, Mapper mapper) {
        this.gamePanel = gamePanel;
        this.mapper = mapper;
        this.init();
    }

    private void init() {
        this.defineTimers();
        gamePanel.addKeyListener(this);
        hideCursor();
    }

    private void defineTimers() {
        ActionListener l = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mapper.addRequest(Mapper.RequestType.SPACESHIP_MOVE_LEFT);
            }
        };
        left = new Timer(10, l);
        ActionListener r = e -> mapper.addRequest(Mapper.RequestType.SPACESHIP_MOVE_RIGHT);
        right = new Timer(10, r);
        ActionListener d = e -> mapper.addRequest(Mapper.RequestType.SPACESHIP_MOVE_DOWN);
        down = new Timer(10, d);
        ActionListener u = e -> mapper.addRequest(Mapper.RequestType.SPACESHIP_MOVE_UP);
        up = new Timer(10, u);
        ActionListener s = e -> mapper.addRequest(Mapper.RequestType.SPACESHIP_SHOOT_BULLET);
        shoot = new Timer(120 , s);
    }

    private void hideCursor() {
        Toolkit toolkit = Toolkit.getDefaultToolkit();

        Point point = new Point(0, 0);
        BufferedImage cursorImg = new BufferedImage(1, 1, BufferedImage.TYPE_INT_ARGB);
        Cursor cursor = toolkit.createCustomCursor(cursorImg, point, "cursor");

        this.gamePanel.setCursor(cursor);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    private void createRequest(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_SPACE:
                shoot.start();
                break;
            case KeyEvent.VK_LEFT:
                left.start();
                break;
            case KeyEvent.VK_RIGHT:
                right.start();
                break;
            case KeyEvent.VK_DOWN:
                down.start();
                break;
            case KeyEvent.VK_UP:
                up.start();
                break;
        }
    }

    private void stopRequest(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_SPACE:
                shoot.stop();
                break;
            case KeyEvent.VK_LEFT:
                left.stop();
                break;
            case KeyEvent.VK_RIGHT:
                right.stop();
                break;
            case KeyEvent.VK_DOWN:
                down.stop();
                break;
            case KeyEvent.VK_UP:
                up.stop();
                break;
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        createRequest(e);
    }

    @Override
    public void keyReleased(KeyEvent e) {
        stopRequest(e);
    }



}
