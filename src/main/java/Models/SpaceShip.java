package main.java.Models;

import main.java.Util.MyComponent;
import main.java.Util.SoundPlayer;
import main.java.Util.Urls;
import main.java.Util.Vector2D;

import java.util.ArrayList;

public class SpaceShip extends MyComponent {

    private ArrayList<Bullet> bullets = new ArrayList<>();


    public SpaceShip(Vector2D position) {
        super(position, 50, 5, "spaceship");
    }


    public void shootBullet(Vector2D position) {
        SoundPlayer.play(Urls.RESOURCE_URL + "Sound\\laser.wav");

        this.bullets.add(new Bullet(position));
    }

    public ArrayList<Bullet> getBullets() {
        return bullets;
    }
}
