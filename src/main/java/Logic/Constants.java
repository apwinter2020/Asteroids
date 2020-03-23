package main.java.Logic;

import main.java.Util.Config;
import main.java.Util.Urls;

import java.lang.reflect.Field;
import java.util.Properties;

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

    private static Config configConstants = new  Config();

    static {
        configConstance(configConstants.ReadProperties(Urls.CONSTANCE_CONFIG_FILE));
    }


    private static void configConstance(Properties properties) {

        for (Field field : Constants.class.getFields()) {
            configConstants.fieldInit(field, properties);
        }

    }


}
