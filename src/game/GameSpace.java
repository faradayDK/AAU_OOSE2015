package game;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.Color;
//Package "Basic Game" for 2D game development

public class GameSpace extends BasicGame
{

	//Global variables
	public Brick [] bricks = new Brick[90];
	public Color [] colors = {Color.yellow, Color.blue , Color.green};
	public BrickSpawn brickSpawn;
	public Ball ball;
	public Player player;
	
	//Setup for the screen size
	public static int spaceHeight = 720;
	public static int spaceWidth = 1280;
	public int BallChange = 10;
	
	
	public GameSpace(String gameName)
	{
		super(gameName);
	}
	
	@Override
	public void init(GameContainer gc) throws SlickException
	{
		ball = new Ball(100,100);
		player = new Player(0.3f , (int)(spaceWidth /2) , 120 , 20);

		//create grid of bricks
		brickSpawn = new BrickSpawn (bricks, 100, 50, 1);

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
        	if(ball.GetX()> player.position-8 && ball.GetX() <player.position+108 ){
        		ball.fliesDown = false;
        		if (input.isKeyDown(Input.KEY_LEFT)){
        			if(ball.fliesRight ==true){
        				
        				ball.angleRatio = Math.abs(ball.angleRatio-player.speed/BallChange);
        				if( (ball.angleRatio-player.speed/BallChange)<0){
        					ball.fliesRight =false;
        				}
        				
        			}
        			else{
        				ball.angleRatio = ball.angleRatio+player.speed/BallChange;
        			}
        		
        		}
        		if (input.isKeyDown(Input.KEY_RIGHT)){
        			if(ball.fliesRight ==true){
        				ball.angleRatio = ball.angleRatio+player.speed/BallChange;
        				
        			}
        			else{
        				ball.angleRatio = Math.abs(ball.angleRatio-player.speed/BallChange);
        				if((ball.angleRatio-player.speed/BallChange)<0){
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
	
    for(int i = 0 ; i<bricks.length; i++){
    	if(!bricks[i].GetDestroyed()){
    		g.setColor(colors[bricks[i].GetType() - 1]);
	g.fillRect(bricks[i].GetX() ,bricks[i].GetY() , bricks[i].GetWidth() , bricks[i].GetHeight() );
    
    	}
    }
    g.setColor(Color.white);
	g.drawRect(player.position , spaceHeight - 100, player.length , player.width);
	g.setColor(Color.white);
	g.fillOval(ball.GetX(), ball.GetY(), 20,20);
	
	

    
	}
	
	//Main method
	public static void main(String[] args)
		{
			try
			{
				AppGameContainer appgc;
				appgc = new AppGameContainer(new GameSpace("Breakout"));
				appgc.setDisplayMode(spaceWidth, spaceHeight , false);
				appgc.start();
			}
			catch (SlickException ex)
			{
				Logger.getLogger(GameSpace.class.getName()).log(Level.SEVERE, null, ex);
			}
		}

	
}
