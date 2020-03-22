package main.java.Logic;

import main.java.Intefaces.Updatable;
import main.java.Models.*;
import main.java.Util.Vector2D;

import java.util.Iterator;

public class GameState implements Updatable {

    private Player player = new Player("", "", "");

    private boolean gameOver = false;
    private AsteroidGroup asteroidGroup = new AsteroidGroup();
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

    //this method examined collision between spaceShip and asteroids
    private void checkSpaceShipCollisions() {
        SpaceShip spaceShip = this.getPlayer().getShip();

        for (Asteroid asteroid : this.getAsteroidGroup().getAsteroids()) {
            if (asteroid.getBox().intersects(spaceShip.getBox())) {
                this.setGameOver(true);
            }
        }

    }

    //this method examined collision between spaceShip.bullets and asteroids
    private void checkBulletsCollision() {

        for (Iterator<Bullet> bulletIterator = this.getPlayer().getShip().getBullets().iterator(); bulletIterator.hasNext(); ) {
            Bullet bullet = bulletIterator.next();

            for (Iterator<Asteroid> asteroidIterator = this.getAsteroidGroup().getAsteroids().iterator(); asteroidIterator.hasNext(); ) {
                Asteroid asteroid = asteroidIterator.next();

                if (bullet.getBox().intersects(asteroid.getBox())) {
                    asteroidIterator.remove();
                    bulletIterator.remove();
                }
            }
        }

    }

    private void checkCollision() {
        checkBulletsCollision();
        checkSpaceShipCollisions();
    }

    @Override
    public void update() {
        Update.getInstance().update();
        this.checkCollision();
    }

    public boolean isGameOver() {
        return gameOver;
    }

    private void setGameOver(boolean gameOver) {
        this.gameOver = gameOver;
    }

    public AsteroidGroup getAsteroidGroup() {
        return asteroidGroup;
    }
}

