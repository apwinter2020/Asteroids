package main.java.Logic;

import main.java.Intefaces.ObjectFactory;
//import main.java.Util.Constants;
import main.java.Models.Asteroid;
import main.java.Util.ConfigLoader;
import main.java.Util.IntegerProperties;
import main.java.Util.Vector2D;

import java.util.Random;

public class AsteroidFactory implements ObjectFactory<Asteroid> {
    private Random random;
    private int count;
    private IntegerProperties constants;


    public AsteroidFactory() {
        random = new Random(System.nanoTime());
        constants = ConfigLoader.getInstance("default").getProperties("Constants");
    }

    @Override
    public Asteroid createNew() {
        count++;
        System.out.println(count+" asteroids created");
        int x = random.nextInt(constants.readInteger("maxWidth") - constants.readInteger("maxSize"));
        int size = random.nextInt(constants.readInteger("maxSize") - constants.readInteger("minSize")) + constants.readInteger("minSize");
        int y = -random.nextInt(constants.readInteger("maxHeight"));
        int speedY = random.nextInt(constants.readInteger("maxSpeed") - constants.readInteger("minSpeed")) + constants.readInteger("minSpeed");
        return new Asteroid(new Vector2D(x, y), size, 0, speedY, "asteroid");
    }
}
