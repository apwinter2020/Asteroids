package main.java.Models;

import main.java.Util.MyComponent;
import main.java.Util.Vector2D;

public class Bullet extends MyComponent {

    public Bullet(Vector2D position) {
        this(position, "bullet");
    }

    public Bullet(Vector2D position, String componentName) {
        super(position, 50, 0, -5, componentName);
    }


}


