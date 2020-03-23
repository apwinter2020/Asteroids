package main.java.Models;

import main.java.Logic.Constants;
import main.java.Util.MyComponent;
import main.java.Util.Vector2D;

import java.util.Random;

public class Asteroid extends MyComponent  {

    public static Random random = new Random();

    public Asteroid(Vector2D position, int size, int speedX,int speedY, String componentName) {
        super(position, size, speedX,speedY, componentName);
    }


    public Vector2D getRandomPosition() {
        return new Vector2D(random.nextInt(Constants.maxWidth - Constants.maxSize), -this.getSize());
    }

}
