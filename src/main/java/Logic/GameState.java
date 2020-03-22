package main.java.Logic;

import main.java.Intefaces.Updatable;
import main.java.Models.Asteroid;
import main.java.Models.AsteroidGroup;
import main.java.Models.Player;
import main.java.Models.Ship;
import main.java.Util.Vector2D;

public class GameState implements Updatable {

    private Player player = new Player("", "", "");
    private AsteroidGroup asteroidGroup = new AsteroidGroup();
    private boolean gameOver = false;

    private static GameState ourInstance = new GameState();

    public static GameState getInstance() {
        if (ourInstance == null) ourInstance = new GameState();
        return ourInstance;
    }


    public void moveSpaceShip(Vector2D newPosition) {
        this.player.getShip().getPosition().setY(newPosition.getY());
        this.player.getShip().getPosition().setX(newPosition.getX());
    }


    public Player getPlayer() {
        return player;
    }

    private void checkCollisions() {
        Ship spaceShip = getPlayer().getShip();
        for (Asteroid asteroid : this.getAsteroidGroup().getAsteroids()) {
            if (asteroid.getBox().intersects(spaceShip.getBox())) {
                this.setGameOver(true);
            }
        }
    }

    @Override
    public void update() {
        this.getAsteroidGroup().update();
        this.getPlayer().getShip().update();

        this.checkCollisions();
    }

    public boolean isGameOver() {
        return gameOver;
    }

    public AsteroidGroup getAsteroidGroup() {
        return asteroidGroup;
    }

    public void setGameOver(boolean gameOver) {
        this.gameOver = gameOver;
    }
}

