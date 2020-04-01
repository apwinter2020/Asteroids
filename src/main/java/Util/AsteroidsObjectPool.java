package main.java.Util;

import main.java.Logic.AsteroidFactory;
import main.java.Models.Asteroid;

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
