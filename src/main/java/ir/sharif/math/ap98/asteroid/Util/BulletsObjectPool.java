package ir.sharif.math.ap98.asteroid.Util;

import ir.sharif.math.ap98.asteroid.Models.Bullet;

import java.util.List;

public class BulletsObjectPool extends ObjectPool<Bullet> {
    public BulletsObjectPool(List<Bullet> inUse) {
        super(inUse);
    }

    @Override
    protected Bullet create() {
        return new Bullet();
    }

}
