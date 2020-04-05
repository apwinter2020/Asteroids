package main.java.ir.sharif.math.ap98.asteroid.Models;

import main.java.ir.sharif.math.ap98.asteroid.Util.BulletsObjectPool;
import main.java.ir.sharif.math.ap98.asteroid.Util.ConfigLoader;
import main.java.ir.sharif.math.ap98.asteroid.Util.GameConstants;
import main.java.ir.sharif.math.ap98.asteroid.Util.SoundPlayer;
import org.apache.commons.math3.geometry.euclidean.twod.Vector2D;


public class SpaceShip extends MyComponent {


    private BulletsObjectPool bulletsObjectPool;


    SpaceShip(Vector2D position) {
        super(position, GameConstants.getInstance().getConstant("shipSize"),
                5, 5, "spaceship");
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
