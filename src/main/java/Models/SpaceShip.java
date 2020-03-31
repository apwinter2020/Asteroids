package main.java.Models;

import main.java.Util.BulletsObjectPool;
import main.java.Util.ConfigLoader;
import main.java.Util.SoundPlayer;
import main.java.Util.Vector2D;

public class SpaceShip extends MyComponent {


    private BulletsObjectPool bulletsObjectPool;


    public SpaceShip(Vector2D position) {
        super(position, 50, 10, 10, "spaceship");
    }


    public void shootBullet() {
        SoundPlayer.play(ConfigLoader.getInstance("default").getAddress("RESOURCE_URL") + "Sound/laser.wav");
        bulletsObjectPool.checkOut().setPosition(this.getPosition());
    }

    public BulletsObjectPool getBulletsObjectPool() {
        return bulletsObjectPool;
    }

    public void setBulletsObjectPool(BulletsObjectPool bulletsObjectPool) {
        this.bulletsObjectPool = bulletsObjectPool;
    }


}
