package main.java.Graphics;

import main.java.Intefaces.Request;
import main.java.Logic.Mapper;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;

public class GameAction implements KeyListener {

    private final GamePanel gamePanel;
    private final Mapper mapper;


    public GameAction(GamePanel gamePanel, Mapper mapper) {
        this.gamePanel = gamePanel;
        this.mapper = mapper;
        this.init();
    }

    private void init() {

        gamePanel.addKeyListener(this);
        hideCursor();

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

    private Request createRequest(KeyEvent e) {
        Request request = null;

        switch (e.getKeyCode()) {
            case KeyEvent.VK_SPACE:
                request = Mapper.RequestType.SPACESHIP_SHOOT_BULLET;
                break;
            case KeyEvent.VK_LEFT:
                request = Mapper.RequestType.SPACESHIP_MOVE_LEFT;
                break;
            case KeyEvent.VK_RIGHT:
                request = Mapper.RequestType.SPACESHIP_MOVE_RIGHT;
                break;
            case KeyEvent.VK_DOWN:
                request = Mapper.RequestType.SPACESHIP_MOVE_DOWN;
                break;
            case KeyEvent.VK_UP:
                request = Mapper.RequestType.SPACESHIP_MOVE_UP;
                break;
        }
        return request;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        System.out.println(e.getWhen());
        mapper.addRequest((Mapper.RequestType) createRequest(e));
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }


}
