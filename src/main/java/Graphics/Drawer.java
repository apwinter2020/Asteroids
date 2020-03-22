package main.java.Graphics;

import main.java.Logic.Constants;
import main.java.Logic.GameState;

import java.awt.*;

public class Drawer {

    private Graphics2D graphics2D;

    public Drawer(Graphics2D graphics2D) {
        setGraphics2D(graphics2D);
    }

    public void setGraphics2D(Graphics2D graphics2D) {
        this.graphics2D = graphics2D;
    }

    public void drawGameState(Graphics2D graphics2D) {

        System.out.println("drawGameState");

        GameState.getInstance().getAsteroidGroup().paint(graphics2D);

        GameState.getInstance().getPlayer().getShip().paint(graphics2D);
    }

    public void drawGameOver(Graphics2D graphics2D) {
        String prompt = "Game Over! :(";
        Font font = new Font("Helvetica", Font.BOLD, 50);
        FontMetrics fontMetrics = graphics2D.getFontMetrics(font);
        int width = fontMetrics.stringWidth(prompt);
        graphics2D.setFont(font);
        graphics2D.drawString(prompt, (Constants.maxWidth - width) / 2, (Constants.maxHeight - 50) / 2);
    }
}
