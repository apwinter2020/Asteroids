package main.java.Graphics;

//import main.java.Util.Constants;
import main.java.Logic.GameState;
import main.java.Models.Asteroid;
import main.java.Models.Bullet;
import main.java.Models.MyComponent;
import main.java.Util.ConfigLoader;
import main.java.Util.IntegerProperties;

import java.awt.*;
import java.util.List;


class Drawer {
    private IntegerProperties constants;

    private Graphics2D graphics2D;
    private GameState gameState;

    public Drawer(Graphics2D graphics2D) {
        gameState = GameState.getInstance();
        setGraphics2D(graphics2D);
        constants = ConfigLoader.getInstance("default").getProperties("Constants");
    }

    void drawGameState() {
        drawAsteroids();
        drawSpaceShip();
    }

    void drawSpaceShip() {

        //this line draw space ship
        drawImage(gameState.getPlayer().getSpaceShip());

        //this loop draw spaceship.bullets
        List<Bullet> bullets = gameState.getBullets();
        for (Bullet bullet : bullets) {
            drawImage(bullet);
        }

    }

    void drawAsteroids() {
        for (Asteroid asteroid : gameState.getAsteroids()) {
            drawImage(asteroid);
        }
    }

    void drawGameOver() {
        String prompt = "Game Over! :(";
        Font font = new Font("Helvetica", Font.BOLD, 50);
        FontMetrics fontMetrics = graphics2D.getFontMetrics(font);
        int width = fontMetrics.stringWidth(prompt);
        graphics2D.setColor(Color.white);
        graphics2D.setFont(font);
        graphics2D.drawString(prompt, (constants.readInteger("maxWidth") - width) / 2, (constants.readInteger("maxHeight") - 50) / 2);
    }

    void drawImage(MyComponent component) {
        graphics2D.drawImage(component.getImage(), component.getPosition().getX(), component.getPosition().getY(),
                component.getSize(), component.getSize(), null);
    }

    public Graphics2D getGraphics2D() {
        return graphics2D;
    }

    public void setGraphics2D(Graphics2D graphics2D) {
        this.graphics2D = graphics2D;
    }
}



