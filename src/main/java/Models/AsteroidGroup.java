package main.java.Models;

import main.java.Intefaces.Movable;
import main.java.Logic.Constants;
import main.java.Util.AsteroidFactory;

import java.util.ArrayList;
import java.util.Random;

public class AsteroidGroup  {

    private final AsteroidFactory asteroidFactory = new AsteroidFactory();

    private final ArrayList<Asteroid> asteroids = new ArrayList<>();

    private final Random random = new Random();


    public void makeAsteroid() {
        synchronized (this.asteroids) {
            int chance = random.nextInt(100);
            if (chance <= Constants.asteroidChance) {
                asteroids.add(asteroidFactory.makeAsteroid());
            }
        }
    }

    public ArrayList<Asteroid> getAsteroids() {
        return asteroids;
    }
}



