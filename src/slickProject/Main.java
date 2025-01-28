package slickProject;

import org.newdawn.slick.*;

public class Main
{
	public static void main(String[] args) throws SlickException 
	{
		AppGameContainer appgc;
		appgc = new AppGameContainer(new Game());
		appgc.setDisplayMode(1900, 1020, false);
		appgc.setMaximumLogicUpdateInterval(30);
		appgc.start();
	}
}