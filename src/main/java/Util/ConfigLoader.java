package main.java.Util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.Set;

public class ConfigLoader {

    private static ConfigLoader loader;
    private Properties addresses;
    private static String defaultAddress = "resources/configFiles/logicConfigFiles/MainConfigFile";
    private HashMap<String, IntegerProperties> properties;
    private ConfigLoader(String address){
        initialize(address);
    }
    private void initialize(String address){
        FileReader reader ;
        properties = new HashMap<>();
        try {
            Properties addresses = new Properties();
            reader = new FileReader(address);
            addresses.load(reader);
            this.addresses = addresses;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("main config file doesn't exist");
        } catch (IOException e) {
            e.printStackTrace();
        }
     loadProperties();
    }
    private void loadProperties(){
        Set<Entry<Object , Object>> entries = addresses.entrySet();
        for(Entry<Object , Object> entry : entries){
            String adrs = (String)entry.getValue();
            IntegerProperties property = new IntegerProperties();
            try {
                if(!entry.getKey().equals("RESOURCE_URL")) {
                    File test = new File(adrs);
//                    System.out.println(f.getAbsolutePath());
                    System.out.println(test.getAbsolutePath());
                    FileReader reader = new FileReader(test.getAbsolutePath());
                    property.load(reader);
                    properties.put((String) entry.getKey(), property);
                }

            } catch (FileNotFoundException e) {
                System.out.println(entry.getKey() + " file doesn't exist");
                e.printStackTrace();
            } catch (IOException e) {
                System.out.println(entry.getKey() + " load failed");
                e.printStackTrace();
            }


        }
    }
    public static ConfigLoader getInstance(String address){
        if (loader == null){
            if(address.equals("default")){
                address = defaultAddress;
            }
            loader = new ConfigLoader(address);
        }
        return loader;
    }
    public IntegerProperties getProperties(String name){
        return properties.get(name);

    }

    public String getAddress(String resource_url) {
        return addresses.getProperty(resource_url);
    }
}
