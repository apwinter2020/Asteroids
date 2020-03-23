package main.java.Util;

import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Properties;

public class Config {

    public static final int intInstance = new Integer(0);

    public int getValue(Properties properties, String key) {
        return Integer.parseInt(properties.get(key).toString());
    }

    public void fieldInit(Field field, Properties properties) {
        try {
            field.setInt(intInstance, this.getValue(properties, field.getName()));
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    public Properties ReadProperties(String configFile) {

        Properties properties = new Properties();
        try (FileReader fileReader = new FileReader(configFile)) {

            properties.load(fileReader);

        } catch (IOException e) {
            e.printStackTrace();
        }

        return properties;
    }

}
