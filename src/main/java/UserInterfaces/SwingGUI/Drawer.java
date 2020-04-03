package main.java.UserInterfaces.SwingGUI;

//import main.java.Util.Constants;

import main.java.Logic.GameState;
import main.java.Models.Asteroid;
import main.java.Models.Bullet;
import main.java.Models.MyComponent;
import main.java.Models.SpaceShip;
import main.java.Util.GameConstants;

import java.awt.*;
import java.util.List;


class Drawer {
    private GameConstants constants;

    private Graphics2D graphics2D;

    public Drawer(Graphics2D graphics2D) {
        setGraphics2D(graphics2D);
        constants = GameConstants.getInstance();
    }

    void drawGameState(GameState gameState) {
        drawAsteroids(gameState.getAsteroids());
        drawSpaceShip(gameState.getPlayer().getSpaceShip(), gameState.getBullets());
    }

    private void drawSpaceShip(SpaceShip spaceShip, List<Bullet> bullets) {

        //this line draw space ship
        drawImage(spaceShip);

        //this loop draw spaceship.bullets
        for (Bullet bullet : bullets) {
            drawImage(bullet);
        }

    }

    private void drawAsteroids(List<Asteroid> asteroids) {
        for (Asteroid asteroid : asteroids) {
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
        graphics2D.drawString(prompt, (constants.getConstant("maxWidth") - width) / 2, (constants.getConstant("maxHeight") - 50) / 2);
    }

    private void drawImage(MyComponent component) {
        graphics2D.drawImage(component.getImage(), component.getPosition().getX(), component.getPosition().getY(),
                component.getSize(), component.getSize(), null);
    }

    public Graphics2D getGraphics2D() {
        return graphics2D;
    }

    void setGraphics2D(Graphics2D graphics2D) {
        this.graphics2D = graphics2D;
    }
}



