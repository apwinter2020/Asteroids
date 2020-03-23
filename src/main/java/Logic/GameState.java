package main.java.Logic;

import main.java.Intefaces.Updatable;
import main.java.Models.AsteroidGroup;
import main.java.Models.Player;

import java.util.Timer;
import java.util.TimerTask;

public class GameState implements Updatable {

    private Player player;
    private AsteroidGroup asteroidGroup;

    private Timer updateTimer = new Timer();

    private boolean gameOver = false;

    public GameState() {
        this.player = new Player("", "", "");
        this.asteroidGroup = new AsteroidGroup();

        this.updateTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                GameState.this.update();
            }
        }, 100, 60);
    }

    private void checkCollision() {

        Mapper.checkBulletsCollision(this.getPlayer().getShip(), this.getAsteroidGroup());
        if (Mapper.checkSpaceShipCollisions(this.getPlayer().getShip(), this.getAsteroidGroup().getAsteroidPool()))
            this.setGameOver(true);

    }

    @Override
    public void update() {
        Update.updateAsteroidGroup(this.getAsteroidGroup().getAsteroidPool());
        Update.updateBullets(this.getPlayer().getShip().getBullets());

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

    public Player getPlayer() {
        return player;
    }
}

