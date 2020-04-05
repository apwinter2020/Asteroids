package main.java.ir.sharif.math.ap98.asteroid.Models;

import org.apache.commons.math3.geometry.euclidean.twod.Vector2D;

public class Bullet extends MyComponent {

    public Bullet(Vector2D position) {
        this(position, "bullet");
    }
    public Bullet(){
        this(new Vector2D(0,0));
    }

    public Bullet(Vector2D position, String componentName) {
        super(position, 50, 0, -5, componentName);
    }


}


