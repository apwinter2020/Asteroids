package main.java.Logic;

import main.java.Models.Asteroid;
import main.java.Models.AsteroidGroup;
import main.java.Models.Bullet;
import main.java.Models.SpaceShip;
import main.java.Util.Vector2D;

import java.util.Iterator;

public class Mapper {

    public static void shootBullet(Vector2D position) {
        GameState.getInstance().getPlayer().getShip().shootBullet(position);
    }

    public static void moveSpaceShip(Vector2D newPosition) {
        GameState.getInstance().getPlayer().getShip().setPosition(new Vector2D(newPosition.getX(), newPosition.getY()));
    }

    //this method examined collision between spaceShip and asteroids
    static boolean checkSpaceShipCollisions(SpaceShip spaceShip, AsteroidGroup asteroidGroup) {

        for (Asteroid asteroid : asteroidGroup.getAsteroids()) {
            if (asteroid.getBox().intersects(spaceShip.getBox())) {
                return true;
            }
        }

        return false;
    }

    //this method examined collision between spaceShip.bullets and asteroids
    static void checkBulletsCollision(SpaceShip spaceShip,AsteroidGroup asteroidGroup) {

        for (Iterator<Bullet> bulletIterator = spaceShip.getBullets().iterator(); bulletIterator.hasNext(); ) {
            Bullet bullet = bulletIterator.next();

            for (Iterator<Asteroid> asteroidIterator = asteroidGroup.getAsteroids().iterator(); asteroidIterator.hasNext(); ) {
                Asteroid asteroid = asteroidIterator.next();

                if (bullet.getBox().intersects(asteroid.getBox())) {
                    asteroidIterator.remove();
                    bulletIterator.remove();
                }
            }
        }

    }

}
