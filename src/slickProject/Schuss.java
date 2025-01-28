package slickProject;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.geom.Circle;
import org.newdawn.slick.geom.Shape;
import org.newdawn.slick.Color;

public class Schuss {
    private static final float SCHUSS_RADIUS = 10; // Konstante für den Radius der Schuss-Hitbox
    private float x;
    private float y;
    private float speed;
    private float directionX;
    private float directionY;
    public boolean active;
    private int ttl;
    Shape hitBox;

    /**
     * 
     * @param x Setzt die Position von dem Schuss auf dem x Wert fest.
     * @param y Setzt die Position von dem schuss auf dem y Wert fest.
     * @param speed Setzt fest wie schnell ein schuss sich bewegen kann.
     * @param directionX Setzt fest wie / ob der schuss sich auf der x achse bewegt.
     * @param directionY Setzt fest wie / ob der schuss sich auf der y achse bewegt.
     */
    
    public Schuss(float x, float y, float speed, float directionX, float directionY) {
        this.x = x;
        this.y = y;
        this.speed = speed;
        this.directionX = directionX;
        this.directionY = directionY;
        this.active = true;
        this.ttl = 570;
        updateHitBox();
    }

    public void update() {
        if (ttl > 0) {
            x += directionX * speed;
            y += directionY * speed;
            ttl--;
            updateHitBox();
        } else {
            active = false;
        }
        if (x < 385 || x > 1525 || y < 155 || y > 850) {
            active = false;
        }
    }

    private void updateHitBox() {
        hitBox = new Circle(getX() + 8, getY() + 5, SCHUSS_RADIUS);
    }

    public void render(Graphics g) {
        if (active) {
            g.setColor(Color.white);
            g.fillOval(x, y, 15, 15); // Kreis für den Schuss
            g.fill(hitBox);
        }
    }

    // Getter und Setter
    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public boolean isActive() {
        return active;
    }

    /**
     * 
     * @param active Legt fest ob ein Schuss activ ist oder nicht.
     */
    
    public void setActive(boolean active) {
        this.active = active;
    }

    public Shape getHitBox() {
        return this.hitBox;
    }
}