package main.java.Logic;

import main.java.Models.Asteroid;
import main.java.Models.AsteroidGroup;
import main.java.Models.Bullet;
import main.java.Models.SpaceShip;
import main.java.Util.ObjectPool;
import main.java.Util.Vector2D;

import java.util.Iterator;

public class Mapper {

    private static GameState gameState = new GameState();

    public static void shootBullet(Vector2D position) {
        gameState.getPlayer().getShip().shootBullet(position);
    }

    public static void moveSpaceShip(Vector2D newPosition) {
        gameState.getPlayer().getShip().setPosition(new Vector2D(newPosition.getX(), newPosition.getY()));
    }

    //this method examined collision between spaceShip and asteroids
    static boolean checkSpaceShipCollisions(SpaceShip spaceShip, ObjectPool<Asteroid> objectPool) {

        for (Asteroid asteroid : objectPool.getPool()) {
            if (asteroid.getBox().intersects(spaceShip.getBox())) {
                return true;
            }
        }

        return false;
    }

    //this method examined collision between spaceShip.bullets and asteroids
    static void checkBulletsCollision(SpaceShip spaceShip, AsteroidGroup asteroidGroup) {
        for (Iterator<Bullet> bulletIterator = spaceShip.getBullets().iterator(); bulletIterator.hasNext(); ) {
            Bullet bullet = bulletIterator.next();

            for (Iterator<Asteroid> asteroidIterator = asteroidGroup.getAsteroidPool().getPool().iterator(); asteroidIterator.hasNext(); ) {
                Asteroid asteroid = asteroidIterator.next();

                if (bullet.getBox().intersects(asteroid.getBox())) {

                }
            }
        }
    }

    public static boolean isGameOver() {
        return gameState.isGameOver();
    }

    public static SpaceShip getSpaceShip() {
        return gameState.getPlayer().getShip();
    }

    public static ObjectPool getAsteroids() {
        return gameState.getAsteroidGroup().getAsteroidPool();
    }
}
