package game;
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
	int bricks_Amount = 80;
	int bricks_StartX = 100;
	int bricks_StartY = 100;
	//Call method that spawns the bricks in a grid
	public Brick [] bricks = Brick.Spawn(bricks_Amount, bricks_StartX, bricks_StartY);
	
	//Create objects
	public Ball ball;
	public Player player;
	public Timer timer;
	public Score score;
	public Life life;
	
	//Setup for the screen size
	public static int spaceHeight = 720;
	public static int spaceWidth = 1280;
	public boolean pressed = false;
	
	//initial level is 0 -> Main menu
	public int level = 0;
	int Xpos, Ypos;

	//Images for the levels's backgrounds
	private Image level_0_NewGame, level_0_exit,
	level_0_backgroundImg, level_1_backgroundImg, 
	level_3_backgroundImg, level_4_backgroundImg, level_5_backgroundImg;
	//Images for the bricks -> each image correspond to the specific type of brick
	private Image [] brickTexture = new Image[3];
	private Image[] secondsCountingImg = new Image[3];
	
	public GameSpace(String gameName)
	{
		super(gameName);
	}
	
	@Override
	public void init(GameContainer gc) throws SlickException
	{
		//assign location for ball and player
		ball = new Ball(400,400);
		player = new Player(2.0f , (int)(spaceWidth /2) , 120 , 20);
		timer = new Timer(50,3);
		score = new Score();
		life = new Life();
		
		//import images for different levels
		level_0_NewGame = new Image("/img/NewGame.png");
		level_0_exit = new Image("/img/exit.png");
		level_0_backgroundImg = new Image("/img/back.jpg");
		level_1_backgroundImg = new Image("/img/back1.jpg");
		level_3_backgroundImg = new Image("/img/ifPause.png");
		level_4_backgroundImg = new Image("/img/ifLost.png");
		level_5_backgroundImg = new Image("/img/ifWinner.png");
		
		//Assign images for the 
		for (int i =0; i<secondsCountingImg.length; i++)
			secondsCountingImg[i] = new Image("img/lost"+ (i+1) +".png");
		
		//Assign textures for the brick types
		for(int i = 0 ; i < brickTexture.length; i++)
			brickTexture[i] = new Image("/img/"+"brick" + (brickTexture.length - i) + ".png");
	}
	
	public void update(GameContainer gc, int delta) throws SlickException {
		//this code will run if the level equals to 0 (Main menu)
		 if (level == 0) {
	        	//change levels by clicking on menu
	    		Xpos = Mouse.getX();
	    		//use to solve upwards problem!
	    		Ypos = spaceHeight - Mouse.getY();
	    	
	            if(Xpos>250 && Xpos<950 && Ypos>100 && Ypos<300 && mouseClicked(0))
	    				level = 1;
	    				
	    		if(Xpos>250 && Xpos<950 && Ypos>315 && Ypos<470)
	    						System.exit(0);
	            
	        }
		
		//the following code will be running if the level is equal to 1. (Game process)
		if(level == 1){
			
			ball.MoveBall();
			//////////////////////////////////////////
			//Player control
			Input input = gc.getInput();
			if (input.isKeyDown(Input.KEY_LEFT))
				player.moveLeft();
			else if (input.isKeyDown(Input.KEY_RIGHT))
				player.moveRight();
			else 
				player.resetSpeed();
			/////////////////////////////////////////
			//Collision
        	if(ball.Collision(player) ){
        		ball.fliesDown = !ball.fliesDown;
        		if (input.isKeyDown(Input.KEY_LEFT)){
        			ball.BallAngle1(player);
        		}
        		if (input.isKeyDown(Input.KEY_RIGHT)){
        			ball.BallAngle2(player);	
        		}
        	}
        	/////////////////////////////
        	//Collision with bricks
        	for(int j = 0 ; j < bricks.length ; j++){
        		if(ball.Collision(bricks[j])){
        		ball.fliesDown = !ball.fliesDown;
        		bricks[j].ReduceLife();
        		//scoreCounter();
        		score.Add();
        		}
        	}
        	if(ball.GetY()>700){
        		life.Reduce();
        		level = 2;	
        	}
        	if (input.isKeyPressed(Input.KEY_ESCAPE)){
        		level = 3;
        		System.out.println(level);
        	}     		
		}
		
		//this Code will run for pause
		if(level ==3){
			Input input = gc.getInput();
			Xpos = Mouse.getX();
    		Ypos = spaceHeight - Mouse.getY();
            if(Xpos>250 && Xpos<950 && Ypos>250 && Ypos<440 && mouseClicked(0)){
    				level = 1;
            }
    		if (Xpos>250 && Xpos<950 && Ypos>450 && Ypos<700 && mouseClicked(0)){
    			score.Reset();
    			level = 0;
            	life.Reset();
            	bricks = Brick.Reset(bricks_Amount, bricks_StartX, bricks_StartY);
            	ball.Reset();
            	player.Reset();
            	
    		}
    		if (level==3 && input.isKeyPressed(Input.KEY_ESCAPE)){
        		level = 1;
        	}	
    		
		}
		if (level ==4){
			
			Xpos = Mouse.getX();
    		Ypos = spaceHeight - Mouse.getY();
            if(Xpos>0 && Xpos<600 && Ypos>550 && Ypos<720 && mouseClicked(0)){
            	score.Reset();
    			level = 1;
            	life.Reset();
            	bricks = Brick.Reset(bricks_Amount, bricks_StartX, bricks_StartY);
            	ball.Reset();
            	player.Reset();
            }
    		if (Xpos>600 && Xpos<1228 && Ypos>550 && Ypos<720 && mouseClicked(0)){
    			score.Reset();
    			level = 0;
            	life.Reset();
            	bricks = Brick.Reset(bricks_Amount, bricks_StartX, bricks_StartY);
            	ball.Reset();
            	player.Reset();
            	
    		}
			
		}
		if (level ==5){
			
			Xpos = Mouse.getX();
    		Ypos = spaceHeight - Mouse.getY();
    		if(Xpos>0 && Xpos<600 && Ypos>550 && Ypos<720 && mouseClicked(0)){
            	score.Reset();
    			level = 1;
            	life.Reset();
            	bricks = Brick.Reset(bricks_Amount, bricks_StartX, bricks_StartY);
            	ball.Reset();
            	player.Reset();
            }
    		if (Xpos>600 && Xpos<1228 && Ypos>550 && Ypos<720 && mouseClicked(0)){
    			score.Reset();
    			level = 0;
            	life.Reset();
            	bricks = Brick.Reset(bricks_Amount, bricks_StartX, bricks_StartY);
            	ball.Reset();
            	player.Reset();
            	
    		}
			
		}
		//Used to store the amount of destroyed bricks
		int destroyedBricks = 0;
		//Counts destroyed bricks
		for(int i = 0 ; i < bricks.length ; i++)
			if(bricks[i].GetDestroyed()) destroyedBricks++;
		//if destroyed bricks are equal to the initial brick amount -> user win!
		if(destroyedBricks == bricks_Amount){
			level = 5;
		}
		
        if (timer.delay == 0){
        	ball.Reset();
        	player.Reset();
			 level = 1;
			 timer.resetDelay();
			 //ball.ResetBallAcceleration();
		 }
        //If user doesn't have any lives
        if (life.Get() == 0){
        	//level 4 - > loose
        	level = 4;
        	//reset all the objects
        	life.Reset();
        	bricks = Brick.Reset(bricks_Amount, bricks_StartX, bricks_StartY);
        	ball.Reset();
        	player.Reset();
        	score.Reset();
        }   
	}

	@Override
	public void render(GameContainer gc, Graphics g) throws SlickException
	{
		//level 0 -> Main menu
		 if (level == 0) {
			//render main menu		
			level_1_backgroundImg.draw(0,0);
			level_0_NewGame.draw(100,100);
			level_0_exit.draw(100,400);
			
		 }
		 //render the game

		 else if(level == 1) {
			 //background renderer
			level_0_backgroundImg.draw(0,0);
			
			//object display
			life.Display(900, 5);
			score.Display(100,5);
			player.Display();

			/*
			 * Displays all the bricks, that are not destroyed,
			 * uses Image [] brickTexture,
			 * each texture correspond to the certain type of a brick
			 */
			for(int i = 0 ; i<bricks.length; i++)
				bricks[i].Display(brickTexture);
		
			//Draw the ball
			g.setColor(Color.white);
			g.fillOval(ball.GetX(), ball.GetY(), 20,20);
			
		}
		 
		 //this level will load if player have lost a life
		 else if(level ==2){
			 level_0_backgroundImg.draw(0,0);

			//Display score images and lose life images
			 life.Display(900, 5);
			 score.Display(100,5);
			 
				if(timer.delay==3){
					secondsCountingImg[2].draw(0,0);
					timer.Start();
				}
				if (timer.delay ==2){
					secondsCountingImg[1].draw(0,0);
					timer.Start();
				}
				if(timer.delay == 1){
					secondsCountingImg[0].draw(0,0);
					timer.Start();
				}
		 } 
		 //this level will load up if player pressed "ESC" for pause
		 else if(level==3){
			 level_0_backgroundImg.draw(0,0);
			 level_3_backgroundImg.draw(0,0);
			 
		 }
		 //this level will load up if player lost the game
		 else if(level==4){
			 level_0_backgroundImg.draw(0,0);
			 level_4_backgroundImg.draw(0,0);
			 score.Display(510,385);
			 
		 }
		 //this level will load up if player won the game
		 else if(level ==5){
			 level_0_backgroundImg.draw(0,0);
			 level_5_backgroundImg.draw(0,0);
			 score.Display(630,265);
			 
			 
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
				appgc.setVSync(true);
				//Set the maximum frame rate 60, so the game works on different computers with same speed
				appgc.setMaximumLogicUpdateInterval(60);
		        appgc.setMinimumLogicUpdateInterval(1);
				appgc.start();
			}
			catch (SlickException ex)
			{
				Logger.getLogger(GameSpace.class.getName()).log(Level.SEVERE, null, ex);
			}
		}

	//Function that checks whether the mouse was pressed
	public boolean mouseClicked(int button){
		boolean pressed = Mouse.isButtonDown(button);
		return pressed;
	}	
}
