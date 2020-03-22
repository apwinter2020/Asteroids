package main.java.Models;

import main.java.Intefaces.Drawable;
import main.java.Intefaces.Movable;
import main.java.Intefaces.Updatable;
import main.java.Logic.Constants;
import main.java.Util.AsteroidFactory;

import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class AsteroidGroup implements Updatable, Movable, Drawable {

    private final AsteroidFactory asteroidFactory = new AsteroidFactory();

    private final ArrayList<Asteroid> asteroids = new ArrayList<>();

    private final Random random = new Random();


    @Override
    public void paint(Graphics g) {
        synchronized (this.asteroids) {
            for (Asteroid asteroid : this.asteroids) {
                asteroid.paint(g);
            }
        }
    }

    @Override
    public void move() {
        synchronized (this.asteroids) {
            for (Asteroid asteroid : this.asteroids) {
                asteroid.move();
            }
        }
    }

    @Override
    public void update() {
        this.makeAsteroid();
        this.move();
    }

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



