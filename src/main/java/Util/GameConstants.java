package main.java.Util;

public class GameConstants {
    private Configs properties ;
    private String name;
    private static GameConstants constants;
    private GameConstants(){
        this("Constants");
    }

    private GameConstants(String name) {
        this.name = name;
        properties = ConfigLoader.getInstance().getProperties(name);
        System.out.println(name);
    }
    public static GameConstants getInstance(String name){
        if(constants == null){
            constants = new GameConstants(name);
        }
        return constants;
    }
    public static GameConstants getInstance(){
        return GameConstants.getInstance("Constants");
    }

    public int getConstant(String name){
        return properties.readInteger(name);
    }
}
