package ir.sharif.math.ap98.asteroid.Models;

//import ir.sharif.math.ap98.asteroid.Util.Constants;

import ir.sharif.math.ap98.asteroid.Util.GameConstants;


import java.io.File;
import java.io.Serializable;

import org.apache.commons.math3.geometry.euclidean.twod.Vector2D;

public class Player implements Serializable {

    private String username;
    private String password;
    private String id;

    private File dataFile;

    private SpaceShip ship;
    private GameConstants constants;


    public Player(String username, String password, String id) {

        this.username = username;
        this.password = password;
        this.id = id;
        constants = GameConstants.getInstance();

        this.ship = new SpaceShip(new Vector2D(constants.getConstant("maxWidth") / 2 - 25, constants.getConstant("maxHeight") / 2 + 200));

    }

    public SpaceShip getSpaceShip() {
        return ship;
    }
}
