package main.java.Models;

import main.java.Intefaces.Drawable;
import main.java.Intefaces.Updatable;
import main.java.Util.MyComponent;
import main.java.Util.SoundPlayer;
import main.java.Util.Urls;
import main.java.Util.Vector2D;

import java.awt.*;
import java.util.ArrayList;

public class Ship extends MyComponent implements Drawable, Updatable {

    private ArrayList<Bullet> bullets = new ArrayList<>();



    public Ship(Vector2D position) {
        super(position, 50, 5, "spaceship");
    }


    public void shootBullet(Vector2D position) {
        SoundPlayer.play(Urls.RESOURCE_URL + "Sound\\laser.wav");

        this.bullets.add(new Bullet(position));
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        synchronized (bullets) {
            for (Bullet bullet : bullets) {
                bullet.paint(g);
            }
        }
    }

    @Override
    public void update() {
        synchronized (bullets) {
            for (Bullet bullet : this.bullets) {
                bullet.update();
            }
        }
    }

    public ArrayList<Bullet> getBullets() {
        return bullets;
    }
}
