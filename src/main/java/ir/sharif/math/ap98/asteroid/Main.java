package main.java.ir.sharif.math.ap98.asteroid;

import main.java.ir.sharif.math.ap98.asteroid.UserInterfaces.SwingGUI.GamePanel;
import main.java.ir.sharif.math.ap98.asteroid.UserInterfaces.SwingGUI.MainFrame;
import main.java.ir.sharif.math.ap98.asteroid.Util.ConfigLoader;


public class Main {


    public Main(String[] args) {
        ConfigLoader urls = ConfigLoader.getInstance(getConfigFile(args));
        MainFrame mainFrame = new MainFrame(new GamePanel());
    }

    public static void main(String[] args) {
        Main program = new Main(args);
    }

    private String getConfigFile(String[] args) {
        String configAddress = "default";
        if (args.length > 1) {
            configAddress = args[1];
        } else {
//            System.out.println(S);
            if (System.getenv("ASTEROID_CONFIG") != null && !System.getenv("ASTEROID_CONFIG").isEmpty()) {
                configAddress = System.getenv("ASTEROID_CONFIG");
            }
        }
        return configAddress;
    }

}
