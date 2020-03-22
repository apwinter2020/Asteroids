package main.java.Models;

import main.java.Logic.Constants;
import main.java.Util.Vector2D;

import java.io.File;
import java.io.Serializable;

public class Player implements Serializable {

    private String username;
    private String password;
    private String id;

    private File dataFile;

    private SpaceShip ship;


    public Player(String username, String password, String id) {

        this.username = username;
        this.password = password;
        this.id = id;

        this.ship = new SpaceShip(new Vector2D(Constants.maxWidth / 2 - 25, Constants.maxHeight / 2 + 200));

    }

    public SpaceShip getShip() {
        return ship;
    }
}
