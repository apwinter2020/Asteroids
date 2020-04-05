package main.java.ir.sharif.math.ap98.asteroid.Util;


import main.java.ir.sharif.math.ap98.asteroid.Logic.AsteroidFactory;
import main.java.ir.sharif.math.ap98.asteroid.Models.Asteroid;

import java.util.List;

public class AsteroidsObjectPool extends ObjectPool<Asteroid> {
    private AsteroidFactory asteroidFactory = new AsteroidFactory();

    public AsteroidsObjectPool(List<Asteroid> inUse) {
        super(inUse);
    }

    @Override
    protected Asteroid create() {
        return asteroidFactory.createNew();
    }

}
