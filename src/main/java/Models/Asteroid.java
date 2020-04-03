package main.java.Models;
import main.java.Util.GameConstants;
import main.java.Util.Vector2D;

import java.util.Random;

public class Asteroid extends MyComponent {
    private GameConstants Constants;

    public static Random random = new Random();

    public Asteroid(Vector2D position, int size, int speedX, int speedY, String componentName) {
        super(position, size, speedX, speedY, componentName);
        Constants = GameConstants.getInstance();
    }

    public void reset() {
        getPosition().setX(random.nextInt(Constants.getConstant("maxWidth") - Constants.getConstant("maxSize")));
        setSize(random.nextInt(Constants.getConstant("maxSize") - Constants.getConstant("minSize")) + Constants.getConstant("minSize"));
        getPosition().setY(-random.nextInt(Constants.getConstant("maxHeight")));
        setSpeedY(random.nextInt(Constants.getConstant("maxSpeed") - Constants.getConstant("minSpeed")) + Constants.getConstant("minSpeed"));

    }

    public Vector2D getRandomPosition() {
        return new Vector2D(random.nextInt(Constants.getConstant("maxWidth") - Constants.getConstant("maxSize")), -this.getSize());
    }

}
