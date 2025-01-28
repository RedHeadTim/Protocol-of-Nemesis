package slickProject;

import org.newdawn.slick.*;

public class StartScreen {
    private Color rectangleColor;
    private int posX;
    private int posY;
    private int width;
    private int height;
    private int cornerRadius;

    /**
     * 
     * @param x Setzt die Position von dem rechteck auf dem x Wert fest.
     * @param y Setzt die Position von dem rechteck auf dem y Wert fest.
     * @param w beschreibt wie breit das rechteck ist.
     * @param h Beschreibt wie hoch das rechteck ist.
     * @param radius setzt den radius der ecken, des rechtecks fest.
     * @param color Setzt fest welche farbe das viereck bekommt.
     */
    
    public StartScreen(int x, int y, int w, int h, int radius, Color color) {
        posX = x;
        posY = y;
        width = w;
        height = h;
        cornerRadius = radius;
        rectangleColor = color;
    }

    public void draw(GameContainer gc, Graphics g) {
        g.setColor(rectangleColor);
        g.fillRoundRect(posX, posY, width, height, cornerRadius);
    }
}