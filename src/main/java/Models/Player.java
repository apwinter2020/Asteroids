package main.java.Models;

import main.java.Logic.Constants;
import main.java.Util.MyComponent;
import main.java.Util.Vector2D;

import java.io.File;
import java.io.Serializable;

public class Player implements Serializable {

    private String username;
    private String password;
    private String id;

    private File dataFile;

    private Ship ship;

    public Player(File dataFile) {

    }


    public Player(String username, String password, String id) {

        this.username = username;
        this.password = password;
        this.id = id;

        this.ship = new Ship(new Vector2D(Constants.maxWidth / 2, Constants.maxHeight / 2 - 200));

//        JsonHandler.getInstance().serialize()
    }

    public Ship getShip() {
        return ship;
    }
}
