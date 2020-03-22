package main.java.Util;

import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;

public class MyComponent{

    private Vector2D position;
    private int size, speedX, speedY;


    private String componentName;

    private BufferedImage image;

    public MyComponent(Vector2D position, int size, int speedX, int speedY, String componentName) {
        this(position, componentName);

        this.size = size;
        this.speedY = speedY;
        this.speedX = speedX;
    }

    public MyComponent(Vector2D position, String componentName) {
        this.componentName = componentName;
        this.position = position;

        this.init();
    }

    private void init() {
        this.image = ImageLoader.getInstance().loadImage("image\\" + this.componentName + ".png");
    }


    public void move() {
        this.setPosition(new Vector2D(this.getPosition().getX() + this.getSpeedX(), this.getPosition().getY() + this.getSpeedY()));
    }

    public Vector2D getPosition() {
        return position;
    }

    public void setPosition(Vector2D position) {
        this.position = position;
    }

    public int getSize() {
        return size;
    }

    public int getSpeedX() {
        return speedX;
    }

    public int getSpeedY() {
        return speedY;
    }

    public BufferedImage getImage() {
        return image;
    }

    public Rectangle2D getBox() {
        return new Rectangle2D.Float(position.getX(), position.getY(), size, size);
    }

}


