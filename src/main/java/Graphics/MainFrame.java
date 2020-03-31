package main.java.Graphics;

import main.java.Util.ConfigLoader;
import main.java.Util.IntegerProperties;

import javax.swing.*;
import java.awt.*;
import java.util.Properties;

public class MainFrame extends JFrame {

    private final GamePanel gamePanel;

    public MainFrame( GamePanel panel) throws HeadlessException {
        super("Asteroid");

        this.gamePanel =panel;
        this.initFrame();
    }


    private void initFrame() {

        try {

            this.ConfigFrame(ConfigLoader.getInstance("default").getProperties("FRAME_CONFIG_FILE"));

            this.setLocationRelativeTo(null);

            this.setContentPane(this.gamePanel);
            this.setVisible(true);

        } catch (Exception e) {
            System.out.println(e);
        }

    }

    private void ConfigFrame(IntegerProperties configFile) {
            this.setSize(configFile.readInteger("width"), configFile.readInteger("height"));
            this.setDefaultCloseOperation(configFile.readInteger("CloseOperation"));
            this.setResizable(Boolean.parseBoolean(configFile.getProperty("Resizable")));
            this.setUndecorated(Boolean.parseBoolean(configFile.getProperty("Undecorated")));
    }

}