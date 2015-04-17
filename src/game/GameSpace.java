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
	public Brick [] bricks = new Brick[20];
	public Ball ball;
	public Player player;
	
	//Setup for the screen size
	public static int spaceWidth = 720;
	public static int spaceLength = 1280;
	
	
	public GameSpace(String gameName)
	{
		super(gameName);
	}
	
	@Override
	public void init(GameContainer gc) throws SlickException
	{
		ball = new Ball(100,100);
		player = new Player(0.5f , (int)(spaceLength /2) , 120 , 20);

		//create grid of bricks
		for (int x = 0; x< bricks.length; x++ )
		{
			//for (int y = 0 ; )
			//bricks[x] = new Brick(1, x * 100, 100);
		}

	}

	@Override
	public void update(GameContainer gc, int i) throws SlickException 
	{
		//Player control
		Input input = gc.getInput();
        if (input.isKeyDown(Input.KEY_LEFT))
        {
        	player.moveLeft();
        }
      
       
        else if (input.isKeyDown(Input.KEY_RIGHT))
        {
        	player.moveRight();
        }
        
        else 
        	player.resetSpeed();
    
        
        if(ball.GetY()> 600.0f && ball.GetY()<610.0f){
        	if(ball.GetX()> player.position && ball.GetX() <player.position+100 ){
        		ball.fliesDown = false;
        		if (input.isKeyDown(Input.KEY_LEFT)){
        			if(ball.fliesRight ==true){
        				
        				ball.angleRatio = Math.abs(ball.angleRatio-player.speed/50);
        				if( (ball.angleRatio-player.speed/50)<0){
        					ball.fliesRight =false;
        				}
        				
        			}
        			else{
        				ball.angleRatio = ball.angleRatio+player.speed/50;
        			}
        		
        		}
        		if (input.isKeyDown(Input.KEY_RIGHT)){
        			if(ball.fliesRight ==true){
        				ball.angleRatio = ball.angleRatio+player.speed/50;
        				
        			}
        			else{
        				ball.angleRatio = Math.abs(ball.angleRatio-player.speed/50);
        				if((ball.angleRatio-player.speed/50)<0){
        					ball.fliesRight = true;
        				}

        			}
        		
        		}
        	
        	}
        }
		
	}

	@Override
	public void render(GameContainer gc, Graphics g) throws SlickException
	{
		ball.MoveBall();
	
    //for(int i = 0 ; i<bricks.length; i++)
	//g.drawRect(bricks[i].GetX() ,bricks[i].GetY() , bricks[i].GetLength() , bricks[i].GetWidth() );	
   
	g.drawRect(player.position , spaceWidth - 100, player.length , player.width);
	g.drawOval(ball.GetX(), ball.GetY(), 20,20);
	

    
	}
	
	//Main method
	public static void main(String[] args)
		{
			try
			{
				AppGameContainer appgc;
				appgc = new AppGameContainer(new GameSpace("Breakout"));
				appgc.setDisplayMode(spaceLength, spaceWidth , false);
				appgc.start();
			}
			catch (SlickException ex)
			{
				Logger.getLogger(GameSpace.class.getName()).log(Level.SEVERE, null, ex);
			}
		}

	
}
