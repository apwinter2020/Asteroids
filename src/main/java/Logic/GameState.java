package main.java.Logic;

import main.java.Models.Asteroid;
import main.java.Models.Bullet;
import main.java.Models.Player;
import main.java.Util.AsteroidsObjectPool;
import main.java.Util.BulletsObjectPool;
import main.java.Util.ConfigLoader;
import main.java.Util.IntegerProperties;
//import main.java.Util.Constants;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Properties;

public class GameState {
    private static GameState gameState;

    private Player player;
    private AsteroidsObjectPool asteroidsObjectPool;
    private List<Asteroid> asteroids;


    private List<Bullet> bullets;
    private BulletsObjectPool bulletsObjectPool;
    private IntegerProperties constants;


    private boolean gameOver = false;

    private GameState() {
        this.player = new Player("", "", "");
        constants = ConfigLoader.getInstance("default").getProperties("Constants");

        asteroids = new ArrayList<>();
        asteroidsObjectPool = new AsteroidsObjectPool(asteroids);
        for (int i = 0; i < constants.readInteger("asteroidNumber"); i++) {
            checkOutAsteroid();
        }

        bullets = Collections.synchronizedList( new ArrayList<>());
        bulletsObjectPool = new BulletsObjectPool(bullets);
        player.getSpaceShip().setBulletsObjectPool(bulletsObjectPool);
    }

    public static GameState getInstance() {
        if (gameState == null) gameState = new GameState();
        return gameState;
    }

    public boolean isGameOver() {
        return gameOver;
    }

    public void setGameOver(boolean gameOver) {
        this.gameOver = gameOver;
    }

    public List<Asteroid> getAsteroids() {
        return asteroids;
    }

    public Player getPlayer() {
        return player;
    }

    public void checkInAsteroid(Asteroid asteroid) {
        asteroid.reset();
        asteroidsObjectPool.checkIn(asteroid);
    }

    public void checkOutAsteroid() {
        asteroidsObjectPool.checkOut();
    }

    public void checkInBullet(Bullet bullet) {
        bulletsObjectPool.checkIn(bullet);
    }

    public List<Bullet> getBullets() {
        return bullets;
    }

}

