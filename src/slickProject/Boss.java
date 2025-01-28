package slickProject;

import org.newdawn.slick.Color;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Circle;
import org.newdawn.slick.geom.Shape;

public class Boss {

	 public Image boss;
	 public float posX = 385 + (1525 - 385) * (float) Math.random();
	 public float posY = 155 + (790 - 155) * (float) Math.random();
	 public int Health = 3;
	 public boolean active = true;
	 Shape hitBox;
	 
	public Boss() throws SlickException {
		  boss = new Image("res/Boss.png");
		  hitBox = new Circle(getX() - 4,getY() - 14, 20);
		  this.active = true;
		}
	
	/**
	 * 
	 * @param x Setzt die Position von dem Boss auf dem x Wert fest.
	 * @param y Setzt die Position von dem Boss auf dem y Wert fest.
	 */
	
	public void setPosition(float x, float y) {
        this.posX = x;
        this.posY = y;
        this.hitBox = new Circle(posX - 4, posY - 14, 20);
    }
	
	public void draw(GameContainer gc, Graphics g) {
	  g.setColor(Color.white);
	  g.fill(hitBox);
	  drawCentered(boss, posX, posY);
	}
	
	public float getX() {
        return posX;
    }

    public float getY() {
        return posY;
    }
	
    /**
     * 
     * @param image Legt das Image fest welches gezeichnet werden soll.
     * @param x Zeichnet das Image auf der x Kordinate.
     * @param y Zeichnet das Image auf der y Kordinate.
     */
    
	private void drawCentered(Image image, float x, float y) {
        float drawX = x - image.getWidth() / 2;
        float drawY = y - image.getHeight() / 2;
        image.draw(drawX, drawY);
        hitBox = new Circle(getX() - 4,getY() - 14, 20);
    }

    public int getHealth() {
        return Health;
    }
    
    public Shape getHitBox() {
		return this.hitBox;
	}
 }
 

