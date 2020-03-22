package main.java.Models;

import main.java.Intefaces.Movable;
import main.java.Util.MyComponent;
import main.java.Util.Vector2D;

public class Asteroid extends MyComponent implements Movable {

    public Asteroid(Vector2D position, int size, int speed, String componentName) {
        super(position, size, speed, componentName);
    }

    @Override
    public void move() {
        this.setPosition(new Vector2D(this.getPosition().getX(),
                this.getPosition().getY() + this.getSpeed()));
    }

}
