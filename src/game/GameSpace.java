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
	Brick [] bricks = new Brick[2];
	bricks[0]= new Brick(2, 400, 400);
	bricks[1]= new Brick(2, 500, 500);
    for(int i = 0 ; i<2; i++){
	g.drawRect(bricks[i].X() ,bricks[i].Y() , bricks[i].Length() , bricks[i].Width() );	
    }
	
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
