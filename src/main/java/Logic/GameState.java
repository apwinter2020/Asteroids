package main.java.Logic;

import main.java.Intefaces.Updatable;
import main.java.Models.AsteroidGroup;
import main.java.Models.Player;

public class GameState implements Updatable {

    private static GameState ourInstance = new GameState();
    private Player player = new Player("", "", "");
    private boolean gameOver = false;
    private AsteroidGroup asteroidGroup = new AsteroidGroup();

    public static GameState getInstance() {
        if (ourInstance == null) ourInstance = new GameState();
        return ourInstance;
    }


    public Player getPlayer() {
        return player;
    }


    private void checkCollision() {

        Mapper.checkBulletsCollision(this.getPlayer().getShip(), this.getAsteroidGroup());
        if (Mapper.checkSpaceShipCollisions(this.getPlayer().getShip(), this.getAsteroidGroup()))
            this.setGameOver(true);

    }

    @Override
    public void update() {
        Update.getInstance().update();
        this.checkCollision();
    }

    public boolean isGameOver() {
        return gameOver;
    }

    private void setGameOver(boolean gameOver) {
        this.gameOver = gameOver;
    }

    public AsteroidGroup getAsteroidGroup() {
        return asteroidGroup;
    }
}

