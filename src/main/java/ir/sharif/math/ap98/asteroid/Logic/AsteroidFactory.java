package main.java.ir.sharif.math.ap98.asteroid.Logic;


import main.java.ir.sharif.math.ap98.asteroid.Intefaces.ObjectFactory;
import main.java.ir.sharif.math.ap98.asteroid.Models.Asteroid;
import main.java.ir.sharif.math.ap98.asteroid.Util.GameConstants;
import org.apache.commons.math3.geometry.euclidean.twod.Vector2D;

import java.util.Random;

public class AsteroidFactory implements ObjectFactory<Asteroid> {
    private Random random;
    private int count;
    private GameConstants constants;


    public AsteroidFactory() {
        random = new Random(System.nanoTime());
        constants = GameConstants.getInstance();
    }

    @Override
    public Asteroid createNew() {
        count++;
        System.out.println(count+" asteroids created");
        int x = random.nextInt(constants.getConstant("maxWidth") - constants.getConstant("maxSize"));
        int size = random.nextInt(constants.getConstant("maxSize") - constants.getConstant("minSize")) + constants.getConstant("minSize");
        int y = -random.nextInt(constants.getConstant("maxHeight"));
        int speedY = random.nextInt(constants.getConstant("maxSpeed") - constants.getConstant("minSpeed")) + constants.getConstant("minSpeed");
        return new Asteroid(new Vector2D(x, y), size, 0, speedY, "asteroid");
    }
}
