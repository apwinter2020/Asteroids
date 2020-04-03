package ir.sharif.math.ap98.asteroid;

import ir.sharif.math.ap98.asteroid.UserInterfaces.SwingGUI.GamePanel;
import ir.sharif.math.ap98.asteroid.UserInterfaces.SwingGUI.MainFrame;
import ir.sharif.math.ap98.asteroid.Util.ConfigLoader;
//import ir.sharif.math.ap98.asteroid.Util.Urls;


public class Main {

    public static void main(String[] args) {

        Main program = new Main(args);

    }
    public Main(String[] args){
            ConfigLoader urls =ConfigLoader.getInstance(getConfigFile(args));
            MainFrame mainFrame = new MainFrame(new GamePanel());

    }
    private String getConfigFile(String[] args){
        String configAddress = "default";
        if(args.length > 1){
            configAddress = args[1];
        }else{
//            System.out.println(S);
            if(System.getenv("ASTEROID_CONFIG")!= null && !System.getenv("ASTEROID_CONFIG").isEmpty()){
                configAddress = System.getenv("ASTEROID_CONFIG");
            }
        }
        return configAddress;
    }

}
