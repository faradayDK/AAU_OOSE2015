package game;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
//Package "Basic Game" for 2D game development

//Main script 
public class GameSpace extends BasicGame
{

	public GameSpace(String gameName)
	{
		super(gameName);
	}
	
	@Override
	public void init(GameContainer gc) throws SlickException
	{
		
	}

	@Override
	public void update(GameContainer gc, int i) throws SlickException 
	{
		
	}

	@Override
	public void render(GameContainer gc, Graphics g) throws SlickException
	{
		
	}

	//Main method
	public static void main(String[] args)
	{
		try
		{
			AppGameContainer appgc;
			appgc = new AppGameContainer(new GameSpace("Breakout"));
			appgc.setDisplayMode(1280, 720, false);
			appgc.start();
		}
		catch (SlickException ex)
		{
			Logger.getLogger(GameSpace.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
}
