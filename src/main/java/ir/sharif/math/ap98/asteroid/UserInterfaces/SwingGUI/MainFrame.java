package ir.sharif.math.ap98.asteroid.UserInterfaces.SwingGUI;

import ir.sharif.math.ap98.asteroid.Util.FrameConfig;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {

    private final GamePanel gamePanel;
    private FrameConfig config;

    public MainFrame(GamePanel panel) throws HeadlessException {
        super("Asteroid");

        this.gamePanel = panel;
        this.initFrame();
    }


    private void initFrame() {

        try {

            config = new FrameConfig("FRAME_CONFIG_FILE");
            this.ConfigFrame();


            this.setLocationRelativeTo(null);

            this.setContentPane(this.gamePanel);
            this.setVisible(true);

        } catch (Exception e) {
            System.out.println(e);
        }

    }

    private void ConfigFrame() {
        this.setSize(config.getWidth(), config.getHeight());
        this.setDefaultCloseOperation(config.getCloseOperation());
        this.setResizable(config.isResizaable());
        this.setUndecorated(config.isUndecorated());
    }
}