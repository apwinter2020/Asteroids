package main.java.Logic;

import main.java.Intefaces.Updatable;
import main.java.Models.Asteroid;
import main.java.Models.Bullet;
import main.java.Models.SpaceShip;
//import main.java.Util.Constants;
import main.java.Util.ConfigLoader;
import main.java.Util.IntegerProperties;
import main.java.Util.Vector2D;

import java.util.List;
import java.util.ListIterator;
import java.util.Properties;
import java.util.Random;

public class Updater implements Updatable {

    private GameState gameState;
    private Random random;
    private IntegerProperties constants;

    public Updater() {
        gameState = Mapper.getInstance().getGameState();
        random = new Random();
        constants = ConfigLoader.getInstance("default").getProperties("Constants");
    }

    @Override
    public void update() {
        updateAsteroids(gameState.getAsteroids());
        updateBullets(gameState.getBullets());
        this.checkCollision();
    }

    private void checkCollision() {
        checkBulletsCollision(gameState.getBullets(), gameState.getAsteroids());
        if (checkSpaceShipCollisions(gameState.getPlayer().getSpaceShip(), gameState.getAsteroids()))
            gameState.setGameOver(true);
    }

    //this method examined collision between spaceShip and asteroids
    private static boolean checkSpaceShipCollisions(SpaceShip spaceShip, List<Asteroid> asteroids) {

        for (Asteroid asteroid : asteroids) {
            if (asteroid.getBox().intersects(spaceShip.getBox())) {
                return true;
            }
        }

        return false;
    }

    //this method examined collision between spaceShip.bullets and asteroids
    private void checkBulletsCollision(List<Bullet> bullets, List<Asteroid> asteroids) {
        ListIterator<Bullet> bulletListIterator = bullets.listIterator();
        while (bulletListIterator.hasNext()) {
            Bullet bullet = bulletListIterator.next();
            ListIterator<Asteroid> asteroidListIterator = asteroids.listIterator();
            while (asteroidListIterator.hasNext()) {
                Asteroid asteroid = asteroidListIterator.next();
                if (bullet.getBox().intersects(asteroid.getBox())) {
                    asteroidListIterator.remove();
                    gameState.checkInAsteroid(asteroid);

                    bulletListIterator.remove();
                    gameState.checkInBullet(bullet);
                    return;
                }
            }
        }
    }

    private void updateAsteroids(List<Asteroid> asteroids) {
        if (asteroids.size() == 0) {
            startWave();
        } else {
            ListIterator<Asteroid> listIterator = asteroids.listIterator();
            while (listIterator.hasNext()) {
                Asteroid asteroid = listIterator.next();
                if (asteroid.getPosition().getY() > constants.readInteger("maxHeight")) {
                    listIterator.remove();
                    gameState.checkInAsteroid(asteroid);
                } else {
                    asteroid.move();
                }
            }
        }

    }

    private void startWave() {
        for (int i = 0; i < constants.readInteger("asteroidNumber"); i++) {
            gameState.checkOutAsteroid();
        }
    }

    private void updateBullets(List<Bullet> bullets) {
        ListIterator<Bullet> bulletListIterator = bullets.listIterator();
        while (bulletListIterator.hasNext()) {
            Bullet bullet = bulletListIterator.next();
            if (bullet.getPosition().getY() < 0) {
                bulletListIterator.remove();
                gameState.checkInBullet(bullet);
            } else {
                bullet.move();
            }
        }
    }

}
