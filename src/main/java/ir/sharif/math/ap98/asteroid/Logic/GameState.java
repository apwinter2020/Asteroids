package ir.sharif.math.ap98.asteroid.Logic;

import ir.sharif.math.ap98.asteroid.Models.Asteroid;
import ir.sharif.math.ap98.asteroid.Models.Bullet;
import ir.sharif.math.ap98.asteroid.Models.Player;
import ir.sharif.math.ap98.asteroid.Util.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//import ir.sharif.math.ap98.asteroid.Util.Constants;

public class GameState {

    private Player player;
    private AsteroidsObjectPool asteroidsObjectPool;
    private List<Asteroid> asteroids;


    private List<Bullet> bullets;
    private BulletsObjectPool bulletsObjectPool;
    private GameConstants constants;


    private boolean gameOver = false;

    public GameState() {
        this.player = new Player("", "", "");
        constants = GameConstants.getInstance();

        asteroids = new ArrayList<>();
        asteroidsObjectPool = new AsteroidsObjectPool(asteroids);
        for (int i = 0; i < constants.getConstant("asteroidNumber"); i++) {
            checkOutAsteroid();
        }

        bullets = Collections.synchronizedList( new ArrayList<>());
        bulletsObjectPool = new BulletsObjectPool(bullets);
        player.getSpaceShip().setBulletsObjectPool(bulletsObjectPool);
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

