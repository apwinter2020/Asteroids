package main.java.Logic;

import main.java.Models.Asteroid;
import main.java.Models.Bullet;

public class Update {

    private static Update ourInstance = new Update();

    public static Update getInstance() {
        return ourInstance;
    }


    void update() {
        updateAsteroidGroup();
        updateBullets();
    }


    private void updateAsteroidGroup() {
        GameState.getInstance().getAsteroidGroup().makeAsteroid();

        for (Asteroid asteroid : GameState.getInstance().getAsteroidGroup().getAsteroids()) {
            asteroid.move();
        }
    }

    private void updateBullets() {
        for (Bullet bullet : GameState.getInstance().getPlayer().getShip().getBullets()) {
            bullet.move();
        }
    }
}
