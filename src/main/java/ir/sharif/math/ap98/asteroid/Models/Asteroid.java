package main.java.ir.sharif.math.ap98.asteroid.Models;


import main.java.ir.sharif.math.ap98.asteroid.Util.GameConstants;
import org.apache.commons.math3.geometry.euclidean.twod.Vector2D;

import java.util.Random;

public class Asteroid extends MyComponent {
    public static Random random = new Random();
    private GameConstants Constants;

    public Asteroid(Vector2D position, int size, int speedX, int speedY,
                    String componentName) {
        super(position, size, speedX, speedY, componentName);
        Constants = GameConstants.getInstance();
    }

    public void reset() {
        double x = random.nextInt(Constants.getConstant("maxWidth")
                - Constants.getConstant("maxSize"));
        double y = -random.nextInt(Constants.getConstant("maxHeight"));
        setPosition(new Vector2D(x, y));
        setSize(random
                .nextInt(Constants.getConstant("maxSize")
                        - Constants.getConstant("minSize"))
                + Constants.getConstant("minSize"));

        setSpeedY(random
                .nextInt(Constants.getConstant("maxSpeed")
                        - Constants.getConstant("minSpeed"))
                + Constants.getConstant("minSpeed"));

    }

    public Vector2D getRandomPosition() {
        return new Vector2D(random.nextInt(Constants.getConstant("maxWidth")
                - Constants.getConstant("maxSize")), -this.getSize());
    }

}
