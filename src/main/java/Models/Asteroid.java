package main.java.Models;
import main.java.Util.ConfigLoader;
import main.java.Util.IntegerProperties;
import main.java.Util.Vector2D;

import java.util.Properties;
import java.util.Random;

public class Asteroid extends MyComponent {
    private IntegerProperties Constants;

    public static Random random = new Random();

    public Asteroid(Vector2D position, int size, int speedX, int speedY, String componentName) {
        super(position, size, speedX, speedY, componentName);
        Constants = ConfigLoader.getInstance("default").getProperties("Constants");
    }

    public void reset() {
        getPosition().setX(random.nextInt(Constants.readInteger("maxWidth") - Constants.readInteger("maxSize")));
        setSize(random.nextInt(Constants.readInteger("maxSize") - Constants.readInteger("minSize")) + Constants.readInteger("minSize"));
        getPosition().setY(-random.nextInt(Constants.readInteger("maxHeight")));
        setSpeedY(random.nextInt(Constants.readInteger("maxSpeed") - Constants.readInteger("minSpeed")) + Constants.readInteger("minSpeed"));

    }

    public Vector2D getRandomPosition() {
        return new Vector2D(random.nextInt(Constants.readInteger("maxWidth") - Constants.readInteger("maxSize")), -this.getSize());
    }

}
