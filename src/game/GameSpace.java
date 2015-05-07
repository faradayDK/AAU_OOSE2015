package game;
//import java.awt.event.*;
//import java.awt.image.BufferedImage;
//import java.io.File;
//import java.io.InputStream;
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
	public Brick [] bricks = Brick.Spawn(90, 100, 50);
	//create ball and player object
	public Ball ball;
	public Player player;
	public Timer timer;
	
	public int lives = 3;
	//Setup for the screen size
	public static int spaceHeight = 720;
	public static int spaceWidth = 1280;
	
	
	public boolean pressed= false;
	
	public Score score;
	
	
	private Image [] scoreImg = new Image[10];
	public int level = 0;
	int Xpos, Ypos;
	private Image level1, exit, back, back1, livesWord, life;
	private Image [] brickTex = new Image[3];
	private Image[] loseLife = new Image[3];
	
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
		
		//import images for main menu
	
		level1 = new Image("/img/NewGame.png");
		exit = new Image("/img/exit.png");
		back = new Image("/img/back.jpg");
		back1 = new Image("/img/back1.jpg");
		livesWord = new Image("img/LivesWord.png");
		life = new Image("img/Life.png");
		
		for (int i =0; i<loseLife.length; i++)
			loseLife[i] = new Image("img/lost"+ (i+1) +".png");
		
		//import images for brick textures

		for(int i = 0 ; i < brickTex.length; i++)
			brickTex[i] = new Image("/img/"+"brick" + (brickTex.length - i) + ".png");
		


	}
	public void update(GameContainer gc, int delta) throws SlickException {
		
		
		//If game level
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
       
        	if(ball.collision(player) ){
        		
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
        		if(ball.collision(bricks[j]) && !bricks[j].GetDestroyed()){
        		ball.fliesDown = !ball.fliesDown;
        		bricks[j].ReduceLife();
        		//scoreCounter();
        		score.AddScore();
        		}
        	}
        	if(ball.GetY()>700){
        		lives--;
        		level =2;
        		
        	}
		
		}
        if (timer.delay == 0){
        	ball.resetBall();
			 level = 1;
			 timer.resetDelay();
		 }
        if (lives== 0){
        	level = 0;
        	lives = 3;
        	ball.resetBall();
        	
        	
        }   
        if (level == 0) {
        	//change levels by clicking on menu
    		
    		Xpos = Mouse.getX();
    		//use to solve upwards problem!
    		Ypos = spaceHeight - Mouse.getY();
    	
            if(Xpos>250 && Xpos<950 && Ypos>100 && Ypos<300 && mouseClicked(0)){
    				level = 1;
    				
    		if(Xpos>250 && Xpos<950 && Ypos>315 && Ypos<470)
    						System.exit(0);
            }
        }
    		
        
	}

	@Override
	public void render(GameContainer gc, Graphics g) throws SlickException
	{
		 if (level == 0) {
			//render main menu
		
			back1.draw(0,0);
			level1.draw(100,100);
			exit.draw(100,400);
			
		 }

		 else if(level == 1) {
			back.draw(0,0);
			livesWord.draw(900,8);
			if(lives == 3){
				life.draw(980,5);
				life.draw(1020,5);
				life.draw(1060,5);
				
			}
			if (lives ==2){
				life.draw(1020,5);
				life.draw(1060,5);
				
			}
			if (lives ==1){
				life.draw(1060,5);
				
			}
			
			for(int i = 0 ; i<bricks.length; i++){
				if(!bricks[i].GetDestroyed()){
					brickTex[bricks[i].GetType()-1].draw(bricks[i].GetX(), bricks[i].GetY());

				}
			}
			
			g.setColor(Color.white);
			g.drawRect(player.GetX() , spaceHeight - 100, player.length , player.width);
			g.setColor(Color.white);
			g.fillOval(ball.GetX(), ball.GetY(), 20,20);
			
	
			score.DisplayScore();
		}
		 else if(level ==2){
			 back.draw(0,0);

				//Display score images and lose life images
			 score.DisplayScore();
				if(timer.delay==3){
					loseLife[2].draw(0,0);
					timer.timerStart();
				}
				if (timer.delay ==2){
					loseLife[1].draw(0,0);
					timer.timerStart();
				}
				if(timer.delay == 1){
					loseLife[0].draw(0,0);
					timer.timerStart();
				}
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
				appgc.setMaximumLogicUpdateInterval(60);
		        appgc.setMinimumLogicUpdateInterval(1);
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
	
	public void resetLevel(){
	level = 1;
		
	}
		
}
