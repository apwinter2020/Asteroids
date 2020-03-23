package main.java.Logic;

import main.java.Models.Asteroid;
import main.java.Models.Bullet;
import main.java.Util.ObjectPool;

import java.util.ArrayList;

public class Update  {

    private static Update ourInstance = new Update();

    static Update getInstance() {
        return ourInstance;
    }


    public static void updateAsteroidGroup(ObjectPool<Asteroid> objectPool) {

        for (Asteroid asteroid : objectPool.getPool()) {
            asteroid.move();
        }

    }

    public static void updateBullets(ArrayList<Bullet> bullets) {
        for (Bullet bullet : bullets) {
            bullet.move();
        }
    }
}
