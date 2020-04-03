package ir.sharif.math.ap98.asteroid.UserInterfaces;

import ir.sharif.math.ap98.asteroid.Intefaces.Request;
import ir.sharif.math.ap98.asteroid.Logic.GameState;
import ir.sharif.math.ap98.asteroid.Models.SpaceShip;


import java.util.ArrayList;
import java.util.Iterator;

import org.apache.commons.math3.geometry.euclidean.twod.Vector2D;

public class Mapper {

    private static Mapper instance = new Mapper();


    private static GameState gameState;
    private ArrayList<Request> requests;


    private Mapper() {
        requests = new ArrayList<>();
        gameState = new GameState();
    }

    private static void moveSpaceShip(Vector2D newPosition) {
        gameState.getPlayer().getSpaceShip().setPosition(new Vector2D(newPosition.getX(), newPosition.getY()));
    }

    private static void shootBullet() {
        SpaceShip spaceShip = gameState.getPlayer().getSpaceShip();
        spaceShip.shootBullet();
    }

    private static void spaceShipMoveRight() {
        SpaceShip spaceShip = gameState.getPlayer().getSpaceShip();
        spaceShip.setPosition(new Vector2D(spaceShip.getPosition().getX() + spaceShip.getSpeedX(), spaceShip.getPosition().getY()));
    }

    private static void spaceShipMoveLeft() {
        SpaceShip spaceShip = gameState.getPlayer().getSpaceShip();
        spaceShip.setPosition(new Vector2D(spaceShip.getPosition().getX() - spaceShip.getSpeedX(), spaceShip.getPosition().getY()));
    }

    private static void spaceShipMoveUp() {
        SpaceShip spaceShip = gameState.getPlayer().getSpaceShip();
        spaceShip.setPosition(new Vector2D(spaceShip.getPosition().getX(), spaceShip.getPosition().getY() - spaceShip.getSpeedY()));
    }

    private static void spaceShipMoveDown() {
        SpaceShip spaceShip = gameState.getPlayer().getSpaceShip();
        spaceShip.setPosition(new Vector2D(spaceShip.getPosition().getX(), spaceShip.getPosition().getY() + spaceShip.getSpeedY()));
    }

    public void addRequest(RequestType requestType) {
        if (requestType != null)
            requests.add(requestType);
    }

    public ArrayList<Request> getRequests() {
        return requests;
    }

    public void executeRequests() {
        for (Iterator<Request> requestIterator = requests.iterator(); requestIterator.hasNext(); ) {
            Request request = requestIterator.next();
            request.execute();
            requestIterator.remove();
        }
    }

    public enum RequestType implements Request {

        SPACESHIP_SHOOT_BULLET {
            @Override
            public void execute() {
                shootBullet();
            }
        },
        SPACESHIP_MOVE_RIGHT {
            @Override
            public void execute() {
                spaceShipMoveRight();
            }
        }, SPACESHIP_MOVE_LEFT {
            @Override
            public void execute() {
                spaceShipMoveLeft();
            }
        }, SPACESHIP_MOVE_UP {
            @Override
            public void execute() {
                spaceShipMoveUp();
            }
        }, SPACESHIP_MOVE_DOWN {
            @Override
            public void execute() {
                spaceShipMoveDown();
            }
        }

    }

    public static GameState getGameState() {
        return gameState;
    }

    public static Mapper getInstance() {
        return instance;
    }
}
