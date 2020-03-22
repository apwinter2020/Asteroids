package main.java.Logic;

import main.java.Util.Urls;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Constants {

    public static int spaceShipSize;
    public static int initialAsteroids;
    public static int asteroidChance;
    public static int maxWidth;
    public static int maxHeight;
    public static int maxSpeed;
    public static int minSpeed;
    public static int maxSize;
    public static int minSize;


    static {
        Constants.configConstance();
    }

    private static void configConstance() {

        try (Scanner input = new Scanner(new File(Urls.CONSTANCE_CONFIG_FILE))) {

            spaceShipSize = input.nextInt();
            maxWidth = input.nextInt();
            maxHeight = input.nextInt();
            maxSpeed = input.nextInt();
            minSpeed = input.nextInt();
            maxSize = input.nextInt();
            minSize = input.nextInt();
            initialAsteroids = input.nextInt();
            asteroidChance = input.nextInt();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


    }

}
