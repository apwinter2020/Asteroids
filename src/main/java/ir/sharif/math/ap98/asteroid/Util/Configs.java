package ir.sharif.math.ap98.asteroid.Util;

import java.util.Properties;

class Configs extends Properties {
    int readInteger(String name){
        return Integer.parseInt(this.getProperty(name));
    }
    boolean readBoolean(String name){
        return Boolean.parseBoolean(this.getProperty(name));
    }
}
