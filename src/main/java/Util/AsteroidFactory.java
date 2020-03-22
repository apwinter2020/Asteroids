package main.java.Util;

import main.java.Logic.Constants;
import main.java.Models.Asteroid;

import java.util.Random;

public class AsteroidFactory {
    private Random random;

    public AsteroidFactory() {
        random = new Random(System.nanoTime());
    }

    public Asteroid makeAsteroid() {
        int x = random.nextInt(Constants.maxWidth - Constants.maxSize);
        int size = random.nextInt(Constants.maxSize - Constants.minSize) + Constants.minSize;
        int y = -size;
        int speed = random.nextInt(Constants.maxSpeed - Constants.minSpeed) + Constants.minSpeed;
        return new Asteroid(new Vector2D(x, y), size, speed, "asteroid");
    }

}
