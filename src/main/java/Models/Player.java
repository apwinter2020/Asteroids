package main.java.Models;

//import main.java.Util.Constants;
import main.java.Util.ConfigLoader;
import main.java.Util.IntegerProperties;
import main.java.Util.Vector2D;

import java.io.File;
import java.io.Serializable;
import java.util.Properties;

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
        IntegerProperties constants = ConfigLoader.getInstance("default").getProperties("Constants");

        this.ship = new SpaceShip(new Vector2D(constants.readInteger("maxWidth") / 2 - 25, constants.readInteger("maxHeight") / 2 + 200));

    }

    public SpaceShip getSpaceShip() {
        return ship;
    }
}
