package main.java.Graphics;

import main.java.Logic.Constants;
import main.java.Logic.GameState;
import main.java.Models.Asteroid;
import main.java.Models.Bullet;
import main.java.Models.SpaceShip;
import main.java.Util.MyComponent;

import java.awt.*;

class Drawer {

    private Graphics2D graphics2D;

    Drawer(Graphics2D graphics2D) {
        setGraphics2D(graphics2D);
    }

    void drawGameState(Graphics2D graphics2D) {
        drawAsteroids(graphics2D);
        drawSpaceShip(graphics2D);
    }

    void drawSpaceShip(Graphics2D graphics2D) {

        SpaceShip spaceShip = GameState.getInstance().getPlayer().getShip();

        //this line draw space ship
        drawImage(graphics2D, spaceShip);

        //this loop draw spaceship.bullets
        for (Bullet bullet : spaceShip.getBullets()) {
            drawImage(graphics2D, bullet);
        }

    }

    void drawAsteroids(Graphics2D graphics2D) {
        synchronized (GameState.getInstance().getAsteroidGroup().getAsteroids()) {
            for (Asteroid asteroid : GameState.getInstance().getAsteroidGroup().getAsteroids()) {
                drawImage(graphics2D, asteroid);
            }
        }
    }

    void drawGameOver(Graphics2D graphics2D) {
        String prompt = "Game Over! :(";
        Font font = new Font("Helvetica", Font.BOLD, 50);
        FontMetrics fontMetrics = graphics2D.getFontMetrics(font);
        int width = fontMetrics.stringWidth(prompt);
        graphics2D.setColor(Color.white);
        graphics2D.setFont(font);
        graphics2D.drawString(prompt, (Constants.maxWidth - width) / 2, (Constants.maxHeight - 50) / 2);
    }

    void drawImage(Graphics2D graphics2D, MyComponent component) {
        graphics2D.drawImage(component.getImage(), component.getPosition().getX(), component.getPosition().getY(), component.getSize(), component.getSize(), null);
    }

    public Graphics2D getGraphics2D() {
        return graphics2D;
    }

    private void setGraphics2D(Graphics2D graphics2D) {
        this.graphics2D = graphics2D;
    }
}



