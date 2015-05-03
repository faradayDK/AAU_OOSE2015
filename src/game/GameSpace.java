package game;
import java.awt.event.*;
//import java.awt.image.BufferedImage;
//import java.io.File;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;


import org.lwjgl.input.Mouse;
import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.Color;


//Package "Basic Game" for 2D game development

public class GameSpace extends BasicGame
{

	//Global variables for bricks
	public Brick [] bricks = new Brick[90];
	public Color [] colors = {Color.yellow, Color.blue , Color.green};
	public BrickSpawn brickSpawn;
	//create ball and player object
	public Ball ball;
	public Player player;

	//Setup for the screen size
	public static int spaceHeight = 720;
	public static int spaceWidth = 1280;
	
	public int BallChange = 10;
	public boolean Pressed= false;
	
	
	//images to display score
	private Image [] scoreDisplayImg = new Image[4];
	//Number to display score
	public int [] scoreDisplayNumber = new int[4];
	//totall score number
	public int score = 0; 
	
	public boolean hit4score = false;
	
	private Image [] scoreImg = new Image[10];
	public boolean level = false;
	int Xpos, Ypos;
	private Image level1, level2, level3, exit;
	
	public GameSpace(String gameName)
	{
		super(gameName);
	}
	
	
	@Override
	public void init(GameContainer gc) throws SlickException
	{
		//assign location for ball and player
		ball = new Ball(100,100);
		player = new Player(0.3f , (int)(spaceWidth /2) , 120 , 20);
		
		//assign images for each score
		for(int i = 0; i < scoreImg.length; i++)
			scoreImg[i] = new org.newdawn.slick.Image("/img/" + i + ".png");
		
		//Number that will be displayed
		for(int i = 0 ; i < scoreDisplayNumber.length ; i++)
			scoreDisplayNumber[i] = 0;
		
		//Assign 0th images to all score images
		for ( int i = 0 ; i < scoreDisplayImg.length ; i++)
			scoreDisplayImg[i] = scoreImg[0];
		
		//create grid of bricks
		brickSpawn = new BrickSpawn(bricks, 100, 50, 1);
		

		
		
		//import images for main menu
	
		level1 = new org.newdawn.slick.Image("/img/level1.png");
		level2 = new org.newdawn.slick.Image("/img/level2.png");
		level3 = new org.newdawn.slick.Image("/img/level3.png");
		exit = new org.newdawn.slick.Image("/img/exit.png");


	}
	public void update(GameContainer gc, int i) throws SlickException {
		
		//If game level
		if(level == true){
			//////////////////////////////////////////
			//Player control
			Input input = gc.getInput();
			if (input.isKeyDown(Input.KEY_LEFT))
				player.moveLeft();
       
			else if (input.isKeyDown(Input.KEY_RIGHT))
				player.moveRight();
        
			else 
				player.resetSpeed();
    
        
        if(ball.GetY()> 600.0f && ball.GetY()<610.0f){
        	if(ball.GetX()> player.position-8 && ball.GetX() <player.position+108 ){
        		ball.fliesDown = false;

        		score++;
        		scoreCounter();
        	
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
	//change levels by clicking on menu
		Xpos = Mouse.getX();
		//use to solve upwards problem!
		Ypos = spaceHeight - Mouse.getY();
		//System.out.println(Xpos + " " + Ypos);
	
        if(Xpos>250 && Xpos<950 && Ypos>100 && Ypos<254 && mouseClicked(0)){
        	System.out.println(mouseClicked(0));
				level = true;
		if(Xpos>250 && Xpos<950 && Ypos>255 && Ypos<310)
					//if(Mouse.isButtonDown(0))
						//sbg.enterState(1);
				
		if(Xpos>250 && Xpos<950 && Ypos>315 && Ypos<470)
						System.exit(0);
		}
        
        
	}

	@Override
	public void render(GameContainer gc, Graphics g) throws SlickException
	{

		if(level == true) {
			ball.MoveBall();
			for(int i = 0 ; i<bricks.length; i++){
				if(!bricks[i].GetDestroyed()){
					g.setColor(colors[bricks[i].GetType() - 1]);
					g.fillRect(bricks[i].GetX() ,bricks[i].GetY() , bricks[i].GetWidth() , bricks[i].GetHeight() );
    
				}
			}
			for(int i = 0 ; i<bricks.length; i++){
				g.drawRect(bricks[i].GetX() ,bricks[i].GetY() , bricks[i].GetWidth() , bricks[i].GetHeight() );
				//System.out.println(bricks[i].GetX());
			}
			g.setColor(Color.white);
			g.drawRect(player.position , spaceHeight - 100, player.length , player.width);
			g.setColor(Color.white);
			g.fillOval(ball.GetX(), ball.GetY(), 20,20);
	
			//Display score images
			for(int i = 0 ; i<scoreDisplayImg.length; i++)
			scoreDisplayImg[i].draw(i*50,0);
		}
		
		else if (level == false) {
			//render main menu
			level1.draw(250,100);
			level2.draw(250,250);
			level3.draw(250,400);
			exit.draw(250,550);
			}
	
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

	
	public boolean mouseClicked(int button){
		boolean pressed = Mouse.isButtonDown(button);
		return pressed;
	}
	
	
	public void scoreCounter() {
		int FalseScore = score;
		if(FalseScore>999){
			scoreDisplayNumber[0]  = (int)(FalseScore/1000);
			FalseScore = FalseScore - 1000*scoreDisplayNumber[0];
		}
		if (FalseScore>99){
			scoreDisplayNumber[1]  = (int)(FalseScore/100);
			FalseScore = FalseScore - 100*scoreDisplayNumber[1] ;
		}
		if(FalseScore>9){
			scoreDisplayNumber[2]  = (int)(FalseScore/10);
			FalseScore = FalseScore - 10*scoreDisplayNumber[2] ;
		}
		if (FalseScore<10){
			scoreDisplayNumber[3]  = FalseScore;
		}
		
		//DISPLAY SCORES
		for( int i = 0 ; i < scoreDisplayImg.length ; i++)
		scoreDisplayImg[i] = scoreImg[scoreDisplayNumber[i]];
			

	}
}
