package game;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
//Package "Basic Game" for 2D game development



public class GameSpace extends BasicGame
{

	//Global variables
	Brick [] bricks = new Brick[2];
	Ball ball;
	Player player;
	
	public GameSpace(String gameName)
	{
		super(gameName);
	}
	
	@Override
	public void init(GameContainer gc) throws SlickException
	{
		ball = new Ball(100,100);
		player = new Player(1, 600, 4 , 1);
		
		//create grid of bricks
		

	}

	@Override
	public void update(GameContainer gc, int i) throws SlickException 
	{
		Input input = gc.getInput();
        if (input.isKeyDown(Input.KEY_LEFT))
        {
        	player.moveLeft();
        }
        if (input.isKeyDown(Input.KEY_RIGHT))
        {
        	player.moveRight();
        }
		
	}

	@Override
	public void render(GameContainer gc, Graphics g) throws SlickException
	{
	
    for(int i = 0 ; i<bricks.length; i++)
	//g.drawRect(bricks[i].X() ,bricks[i].Y() , bricks[i].Length() , bricks[i].Width() );	
	g.drawRect(player.position, 500, 50 , 25);
	g.drawOval(ball.GetX(), ball.GetY(), 20,20);

    
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
