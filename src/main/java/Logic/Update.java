package main.java.Logic;

import main.java.Intefaces.Updatable;
import main.java.Models.Asteroid;
import main.java.Models.Bullet;

public class Update implements Updatable {

    private static Update ourInstance = new Update();

    static Update getInstance() {
        return ourInstance;
    }


    @Override
    public void update() {
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
