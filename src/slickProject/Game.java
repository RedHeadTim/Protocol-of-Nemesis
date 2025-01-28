package slickProject;

import org.newdawn.slick.*;
import org.newdawn.slick.geom.*;
import java.util.ArrayList;
import org.newdawn.slick.SlickException;

public class Game extends BasicGame 
{
    private Player player;
    private Boss boss;
    private Boss boss1;
    private Boss boss2;
    private Image bild; 
    private Image logo;
    private Sound intro;
    private Sound game;
    private boolean introPlayed = false;
    private boolean gamePlaying = false;
    int zaehler = 0;
    double scaleFactor = 1.002;
    private boolean actionStarted = false;
    private boolean actionStarted2 = false;
    private boolean actionStarted3 = false;
    private boolean actionStarted4 = false;
    private boolean actionStarted5 = false;
    private boolean actionStarted6 = false;
    private boolean actionStarted7 = false;
    private boolean actionStarted8 = false;
    private boolean dead1 = false;
    private boolean dead2 = false;
    private boolean dead3 = false;
    private StartScreen start;
    private Image FigurLable; 
    private Image mission;
    private Image basics;
    private Image ready;
    private String text;
    private String text1;
    private int newWidth = 1800; 
    private int newHeight = 920;
    private int newWidth2 = 220; 
    private int newHeight2 = 220;
    private int h = 3; //Leben
    private float d = 5; //Schaden
    private float r = 1; //radius
    private float ss = 2; // schieß geschwindigkeit
    private float s = 1; //geschwindigkeit
    private int f = 0; // fragmente
    private int k = 0; //key card
    private int b = 0; //getötete bosse
    private int w = 1; //Welle
    private ArrayList<Schuss> schuesse;
    Input at;
    
    public Game()
    {
        super("Protocol of Nemesis");
    }
    
    @Override
    public void init(GameContainer gc) throws SlickException 
    {
        player = new Player();
        boss = new Boss();
        boss1 = new Boss();
        boss2 = new Boss();
        bild = new Image("res/Hintergrund_1.jpg");
        logo = new Image("res/Logo.PNG"); 
        start = new StartScreen (820, 530, 200, 80, 30, null); //int x, int y, int w, int h, int radius, Color color
        FigurLable = new Image("res/Figur-Lable.jpg");
        mission = new Image("res/Mission.jpg");
        basics = new Image("res/Basics.jpg");
        ready = new Image("res/Ready.jpg");
        intro = new Sound("res/Nemesis-Intro.wav");
        game = new Sound("res/Nemesis-Game.wav");
        schuesse = new ArrayList<>();
    }
    
    @Override
    public void update(GameContainer gc, int delta) throws SlickException 
    {  
    	
    // Tasten Druck am anfang
    	at = gc.getInput();
        if (at.isKeyPressed(Input.KEY_ENTER)) {
            actionStarted = true;
        }
        
     // Logo Größe ändern
        if (zaehler < 325 && actionStarted) {
            int newWidth = (int) (logo.getWidth() * scaleFactor);
            int newHeight = (int) (logo.getHeight() * scaleFactor);
            logo = logo.getScaledCopy(newWidth, newHeight);
            zaehler ++;
    	}
     
     // Mausklick auf die Schaltfläche "START"
        Input mouseInput = gc.getInput();
        int mouseXx = mouseInput.getMouseX();
        int mouseYy = mouseInput.getMouseY();
        
     // Abgerundetes Rechteck um die Schaltfläche "START"
        RoundedRectangle startButtonRecttt = new RoundedRectangle(820, 530, 200, 80, 30);   // x, y, width, height, ecken
        if (mouseInput.isMousePressed(Input.MOUSE_LEFT_BUTTON) && startButtonRecttt.contains(mouseXx, mouseYy) && actionStarted) {
            actionStarted2 = true;
        }
        
     // eintleite text
        text = "Year 2421\n\n"
                + "All of us are dead. If you're reading this, it means our mission to deactivate the AI has failed.\n\n"
                + "Now, you are our last hope. After the AI seized control, humanity is on the brink of extinction.\n\n"
                + "However, you possess the ability to defeat it. Hack your way through the 'Protocol of Nemesis' to \n\n"
                + "the core of the AI and destroy it. You are the only one who can save humanity now.\n\n"
                + "- Unknown";
        
     // Mission bild größe ändern
        mission = mission.getScaledCopy(newWidth, newHeight);
        
     // übergang Misson zu Basics
        if (at.isKeyPressed(Input.KEY_1) && actionStarted2) {
            actionStarted4 = true;
        }
        
     // basics bild größe ändern
        basics = basics.getScaledCopy(newWidth, newHeight);
        
     // übergang Basics zu Ready
    	Input aat = gc.getInput();
        if (aat.isKeyPressed(Input.KEY_2) && actionStarted4) {
            actionStarted5 = true;
        }
        
     // ready bild größe ändern
        ready = ready.getScaledCopy(newWidth, newHeight);
        
     // übergang ready zum Spiel 
    	Input aattt = gc.getInput();
        if (aattt.isKeyPressed(Input.KEY_3) && actionStarted5) {
            actionStarted3 = true;
        }
        
     // attribute 
        text1 = "Health: " + h + "\n\n" 
                + "Damage: " + d + "\n\n" 
                + "Range: " + r + "\n\n" 
                + "Shot Speed: " + ss + "\n\n" 
                + "Speed: " + s + "\n\n" 
                + "Fragments: " + f + "\n\n" 
                + "Key Card: " + k + "\n\n"
                + "Inactive Bots: "+ b;

     // figurenlabel  größe ändern
        FigurLable = FigurLable.getScaledCopy(newWidth2, newHeight2);
        
     // Grenzen Boden
        int minX = 385;   //links
        int maxX = 1525;  //rechts
        int minY = 155;   //oben
        int maxY = 790;   //unten
        
     //Figur bewegen
        Input in = gc.getInput();
        
        if (in.isKeyDown(Input.KEY_A) && player.posX > minX) {
            player.blickrichtung = 3;
            player.posX = player.posX - 1;
        }
        if (in.isKeyDown(Input.KEY_D) && player.posX < maxX) {
            player.blickrichtung = 1;
            player.posX = player.posX + 1;
        }
        if (in.isKeyDown(Input.KEY_W) && player.posY > minY) {
            player.blickrichtung = 0;
            player.posY = player.posY - 1;
        }
        if (in.isKeyDown(Input.KEY_S) && player.posY < maxY) {
            player.blickrichtung = 2;
            player.posY = player.posY + 1;
        }
        
      // player tot
        if (h <= 0) {
        	actionStarted6 = true;
        	actionStarted3 = false;
        	actionStarted7 = false;
        	actionStarted8 = false;
        	h = 0;
        } 
        
      // Update-Schüsse
        for (Schuss schuss : schuesse) {
            schuss.update();
        } 
        
      // schüsse generieren 
        if (at.isKeyPressed(Input.KEY_UP) && actionStarted3 ^ actionStarted7 ^ actionStarted8) {
            schuesse.add(new Schuss(player.getX(), player.getY(), ss, 0, -1)); 
        }
        if (at.isKeyPressed(Input.KEY_DOWN) && actionStarted3 ^ actionStarted7 ^ actionStarted8) {
            schuesse.add(new Schuss(player.getX(), player.getY(), ss, 0, 1)); 
        }
        if (at.isKeyPressed(Input.KEY_RIGHT) && actionStarted3 ^ actionStarted7 ^ actionStarted8) {
            schuesse.add(new Schuss(player.getX(), player.getY(), ss, 1, 0)); 
        }
        if (at.isKeyPressed(Input.KEY_LEFT) && actionStarted3 ^ actionStarted7 ^ actionStarted8) {
            schuesse.add(new Schuss(player.getX(), player.getY(), ss, -1, 0));
        }
     
    
      // Boss verfolgt den Spieler
        if (boss != null && boss.active && actionStarted3 ^ actionStarted8) {
            float playerX = player.getX();
            float playerY = player.getY();
            float bossX = boss.getX();
            float bossY = boss.getY();
            double distance = Math.sqrt(Math.pow(playerX - bossX, 2) + Math.pow(playerY - bossY, 2));
            double dx = (playerX - bossX) / distance;
            double dy = (playerY - bossY) / distance;
            bossX += dx * 0.5f; 
            bossY += dy * 0.5f; 
            boss.setPosition(bossX, bossY); 
        }
        
     // Boss1 verfolgt den Spieler
        if (boss1 != null && actionStarted7 && boss1.active) {
            float playerX = player.getX();
            float playerY = player.getY();
            float bossX = boss1.getX();
            float bossY = boss1.getY();
            double distance = Math.sqrt(Math.pow(playerX - bossX, 2) + Math.pow(playerY - bossY, 2));
            double dx = (playerX - bossX) / distance;
            double dy = (playerY - bossY) / distance;
            bossX += dx * 0.5f; 
            bossY += dy * 0.5f; 
            boss1.setPosition(bossX, bossY); 
        }
        
     // Boss2 verfolgt den Spieler
        if (boss2 != null && actionStarted7 && boss2.active) {
            float playerX = player.getX();
            float playerY = player.getY();
            float bossX = boss2.getX();
            float bossY = boss2.getY();
            double distance = Math.sqrt(Math.pow(playerX - bossX, 2) + Math.pow(playerY - bossY, 2));
            double dx = (playerX - bossX) / distance;
            double dy = (playerY - bossY) / distance;
            bossX += dx * 0.5f; 
            bossY += dy * 0.5f; 
            boss2.setPosition(bossX, bossY); 
        }
        
      // kollisionen boss und player
        if (player.getHitBox().intersects(boss.getHitBox()) && boss.active && actionStarted3 ^ actionStarted8) {
            boss.active = false;
            dead1 = true;
            h--;
        }
        
     // kollisionen boss1 und player
        if (player.getHitBox().intersects(boss1.getHitBox()) && actionStarted7 && boss1.active) {
        	boss1.active = false;
        	dead2 = true;
            h--;
        }
        
      // kollisionen boss2 und player
        if (player.getHitBox().intersects(boss2.getHitBox()) && boss2.active && actionStarted7) {
            boss2.active = false;
            dead3 = true;
            h--;
        }
     // kollisionen boss und schuss
        for (Schuss s : schuesse) {
            if (boss.getHitBox().intersects(s.getHitBox()) && s.active && actionStarted3 ^ actionStarted8 && boss.active) {
                boss.Health--;
                s.active = false;
            }
        }
        
     // kollisionen boss1 und schuss
        for (Schuss s : schuesse) {
            if (boss1.getHitBox().intersects(s.getHitBox()) && actionStarted7 && s.active && boss1.active) {
                boss1.Health--;
                s.active = false;
            }
        }
        
     // kollisionen boss2 und schuss
        for (Schuss s : schuesse) {
            if (boss2.getHitBox().intersects(s.getHitBox()) && actionStarted7 && s.active && boss2.active) {
                boss2.Health--;
                s.active = false;
            }
        }
         
     // boss tot
        if (boss.Health <= 0) {
        	dead1 = true;
        	boss.active = false;
        	b++;
        	boss.Health = 3;
        }
        
     // boss1 tot
        if (boss1.Health <= 0) {
        	dead2 = true;
        	boss1.active = false;
        	b++;
        	boss1.Health = 3;
        } 
        
     // boss2 tot
        if (boss2.Health <= 0) {
        	dead3 = true;
        	boss2.active = false;
        	b++;
        	boss2.Health = 3;
        } 
        
      // actionStarted3 zu actionStarted7
        if (dead1 && actionStarted3 == true) {
        	actionStarted3 = false;
        	actionStarted7 = true;
        	boss.active = true;
        	w++;
        } 
        
        // actionStarted7 zu actionStarted8
        if (dead2 && dead3 && actionStarted7 == true) {
        	actionStarted7 = false;
        	dead1 = false;
        	actionStarted8 = true;
        	boss1.active = true;
        	boss2.active = true;
        	w++;
        }
        
     // actionStarted8 zu actionStarted3
        if (dead1 && actionStarted8 == true) {
        	actionStarted8 = false;
        	actionStarted7 = true;
        	boss.active = true;
        	dead1 = false;
        	dead2 = false;
        	w++;
        } 
        
      // neustart des Hauptgames (ohne intro)
        if (at.isKeyPressed(Input.KEY_ESCAPE) && actionStarted6 == true) {
        	actionStarted3 = true;
        	actionStarted8 = false;
        	actionStarted7 = false;
        	actionStarted6 = false;
        	boss.active = true;
        	boss1.active = true;
        	boss2.active = true;
        	dead1 = false;
        	dead2 = false;
        	dead3 = false;
        	player.posX = 920;
        	player.posY = 510;
        	h = 3; 
            d = 5; 
            r = 1; 
            ss = 2; 
            s = 1; 
            f = 0; 
            k = 0; 
            b = 0; 
            w = 1;
        } 
        
      // Musik
        if (actionStarted == true && introPlayed == false) {
            if (!introPlayed) {
                intro.play();
                introPlayed = true;
            }
        }
        
        if (actionStarted3) {
            if (!gamePlaying) {
            	intro.stop();
                game.loop();
                gamePlaying = true;
            }
        }
    }
    
    @Override
    public void render(GameContainer gc, Graphics g) throws SlickException 
    {
    	g.drawString("press 'ENTER' to start", 800, 500);
        if (actionStarted) {
        	g.clear();
            logo.drawCentered(950, 400);
            g.setColor(Color.white);
            start.draw(gc, g);
            g.setColor(Color.black);
            g.drawString("START", 895, 563);
        }
        if (actionStarted2) {
        	g.clear();
        	mission.draw(50, 50); 
        	g.setColor(Color.white);
        	g.drawString(text, 490, 430); 
        	g.drawString("klick 1 to continue", 1280, 820);
        }
        
        if (actionStarted4) {
        	g.clear();
        	basics.draw(50, 50); 
        	g.drawString("klick 2 to continue", 1280, 820); 
        }
        
        if (actionStarted5) {
        	g.clear();
        	ready.draw(50, 50); 
        	g.setColor(Color.white);
        	g.drawString("klick 3 to start your mission", 750, 570); 
        }
        
        if (actionStarted3) {
            g.clear();
            bild.draw(0, 0);
            player.draw(gc, g);
            FigurLable.draw(60, 50); 
            g.setColor(Color.white);
            g.drawString(text1, 60, 310);
            g.drawString("Welle: " + w, 920, 100);
            if (boss.active) {
                boss.draw(gc, g);
            }
        }
        
        if (actionStarted7) {
        	g.clear();
            bild.draw(0, 0);
            player.draw(gc, g);
            FigurLable.draw(60, 50); 
            g.setColor(Color.white);
            g.drawString(text1, 60, 310);
            g.drawString("Welle: " + w, 920, 100);
            if (boss1.active) {
                boss1.draw(gc, g);
            }
            if (boss2.active) {
                boss2.draw(gc, g);
            }
        }
        
        if (actionStarted8) {
        	g.clear();
            bild.draw(0, 0);
            player.draw(gc, g);
            FigurLable.draw(60, 50); 
            g.setColor(Color.white);
            g.drawString(text1, 60, 310);
            g.drawString("Welle: " + w, 920, 100);
            if (boss.active) {
                boss.draw(gc, g);
            }
            
        }
        
        if (actionStarted6) {
            bild.draw(0, 0);
            FigurLable.draw(60, 50); 
            g.setColor(Color.white);
            g.drawString(text1, 60, 310);
            g.drawString("GAME OVER", 920, 510);
            g.drawString("Welle: " + w, 920, 100);
            g.drawString("klick 'ESCAPE' to restart", 850, 533);
        }
        
        for (Schuss schuss : schuesse) {
            schuss.render(g);
        }
    } 
}
