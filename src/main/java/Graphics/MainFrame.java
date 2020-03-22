package main.java.Graphics;

import main.java.Util.Urls;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MainFrame extends JFrame {

    private final GamePanel gamePanel;

    public MainFrame(GamePanel gamePanel) throws HeadlessException {
        super("Asteroid");

        this.gamePanel = gamePanel;
        this.initFrame();
    }


    private void initFrame() {

        try {

            this.ConfigFrame(new File(Urls.FRAME_CONFIG_FILE));

            this.setDefaultCloseOperation(3);
            this.setLocationRelativeTo(null);

            this.setContentPane(this.gamePanel);
            this.setVisible(true);

        } catch (Exception e) {
            System.out.println(e);
        }

    }

    private void ConfigFrame(File configFile) {


        try (Scanner input = new Scanner(configFile)) {

            this.setSize(input.nextInt(), input.nextInt());
            this.setDefaultCloseOperation(input.nextInt());
            this.setResizable(input.nextBoolean());
            this.setUndecorated(input.nextBoolean());

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

}