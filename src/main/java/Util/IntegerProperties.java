package main.java.Util;

import java.util.Properties;

public class IntegerProperties extends Properties {
    public int readInteger(String name){
        return Integer.parseInt(this.getProperty(name));
    }
}
