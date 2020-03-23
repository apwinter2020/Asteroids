package main.java.Models;

import main.java.Util.AsteroidFactory;
import main.java.Util.ObjectPool;

public class AsteroidGroup  {

    AsteroidFactory asteroidFactory = new AsteroidFactory();

    ObjectPool<Asteroid> asteroidPool = new ObjectPool<Asteroid>(100) {
        @Override
        public Asteroid createNew() {
            return AsteroidGroup.this.asteroidFactory.createNew();
        }
    };


    public ObjectPool<Asteroid> getAsteroidPool() {
        return asteroidPool;
    }

}



