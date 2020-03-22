package main.java;

import main.java.Graphics.GamePanel;
import main.java.Graphics.MainFrame;
import main.java.Logic.Constants;

public class Main {

    public static void main(String[] args) {

        MainFrame mainFrame = new MainFrame(new GamePanel());

        System.out.println(Constants.minSpeed);
    }

}
