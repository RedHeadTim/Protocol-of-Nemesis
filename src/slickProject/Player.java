package slickProject;

import org.newdawn.slick.*;
import org.newdawn.slick.geom.*;

public class Player {

	Image[] bild = new Image[4];
	float posX = 920;
	float posY = 510;
	int blickrichtung = 2;
	int newWidth = 200; 
    int newHeight = 250;
    Shape hitBox;
    
    public float getX() {
        return posX;
    }

    public float getY() {
        return posY;
    }
    
    public float getWidth() {
        return newWidth;
    }
    
    public float getHeight() {
        return newHeight;
    }
	
	public Player( ) throws SlickException {
		bild[0] = new Image("res/Figur_oben.PNG");
		bild[1] = new Image("res/Figur_rechts.PNG");
		bild[2] = new Image("res/Figur_unten.PNG");
		bild[3] = new Image("res/Figur_links.PNG");
		
		bild[0] = bild[0] .getScaledCopy(newWidth, newHeight);
		bild[1] = bild[1] .getScaledCopy(newWidth, newHeight);
		bild[2] = bild[2] .getScaledCopy(newWidth, newHeight);
		bild[3] = bild[3] .getScaledCopy(newWidth, newHeight);
		
		hitBox = new Circle(getX(),getY(),40);
	}
	
	/**
	 * 
	 * @param image Bestimmt welche graphik benutzt werden soll, um den player zu representieren.
	 * @param x Setzt die Position von dem player auf dem x Wert fest.
	 * @param y Setzt die Position von dem player auf dem y Wert fest.
	 */
	
	private void drawCentered(Image image, float x, float y) {
        float drawX = x - image.getWidth() / 2;
        float drawY = y - image.getHeight() / 2;
        image.draw(drawX, drawY);
        hitBox = new Circle(getX(),getY(),40);
    }
	
	public void draw(GameContainer gc, Graphics g) {
		g.setColor(Color.white);
		g.fill(hitBox);
		drawCentered(bild[blickrichtung], posX, posY);
	}
	
	public Shape getHitBox() {
		return this.hitBox;
	}
}
