package game;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.imageio.ImageIO;

import org.lwjgl.input.Mouse;
import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.Color;
import org.newdawn.slick.state.StateBasedGame;

import javax.imageio.ImageIO;
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
	public boolean Pressed= false;
	
	
	//images for score
	Image one, two, three, four, five, six, seven, eight, nine, zero, first, second, third, fourth;
	public int fourthNumber =0;
	public int thirdNumber =0;
	public int secondNumber =0;
	public int firstNumber =0;
	public boolean hit4score = false;
	public int Score = 0; //write any
	private org.newdawn.slick.Image [] scoreImg = new org.newdawn.slick.Image[10];
	public boolean level = false;
	int Xpos, Ypos;
	private org.newdawn.slick.Image level1, level2, level3, exit;
	
	//ImageIO.read(new File("images/folder63.jpg"));
	public GameSpace(String gameName)
	{
		super(gameName);
	}
	
	@Override
	public void init(GameContainer gc) throws SlickException
	{
		ball = new Ball(100,100);
		player = new Player(0.3f , (int)(spaceWidth /2) , 120 , 20);
		
		for(int i = 0; i < scoreImg.length; i++)
		scoreImg[i] = new org.newdawn.slick.Image("/img/" + i + ".png");
		
		//create grid of bricks
		brickSpawn = new BrickSpawn(bricks, 100, 50, 1);
		
		//import images for score
		
		first = scoreImg[0];
		second = scoreImg[0];
		third = scoreImg[0];
		fourth = scoreImg[0];
		
		//import images for main menu
	
		level1 = new org.newdawn.slick.Image("/img/level1.png");
		level2 = new org.newdawn.slick.Image("/img/level2.png");
		level3 = new org.newdawn.slick.Image("/img/level3.png");
		exit = new org.newdawn.slick.Image("/img/exit.png");
	
		level = false;
		

	}
	public void update(GameContainer gc, int i) throws SlickException {
		if(level == true){
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
        		
        		
        		Score++;
        		counter();
        	
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
		Xpos = Mouse.getX();
		 Ypos = Mouse.getY();
		
	
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
	
	//render score
	first.draw(0,0);
	second.draw(50, 0);
	third.draw(100,0);
	fourth.draw(150,0);
	//moment of the collision
	if (hit4score == true) {
    	counter();
    	hit4score = false;
    }
		}
		if (level == false) {
	//render main menu
	level1.draw(250,100);
	level2.draw(250,250);
	level3.draw(250,400);
	exit.draw(250,550);
		}
	
	}
	public void counter() {
		int FalseScore = Score;
		if(FalseScore>999){
			firstNumber  = (int)(FalseScore/1000);
			FalseScore = FalseScore - 1000*firstNumber;
		}
		if (FalseScore>99){
			secondNumber = (int)(FalseScore/100);
			FalseScore = FalseScore - 100*secondNumber;
		}
		if(FalseScore>9){
			thirdNumber = (int)(FalseScore/10);
			FalseScore = FalseScore - 10*thirdNumber;
		}
		if (FalseScore<10){
			fourthNumber = FalseScore;
		}
		//fourth counter
		
			switch(fourthNumber) {
			case 0: fourth = scoreImg[0];
			break;
			case 1: fourth = scoreImg[1];
			break;
			case 2: fourth = scoreImg[2];
			break;
			case 3: fourth = scoreImg[3];
			break;
			case 4: fourth = scoreImg[4];
			break;
			case 5: fourth = scoreImg[5];
			break;
			case 6: fourth = scoreImg[6];
			break;
			case 7: fourth = scoreImg[7];
			break;
			case 8: fourth = scoreImg[8];
			break;
			case 9: fourth = scoreImg[9];
			break;
			case 10: 
				Score++;
				fourth = scoreImg[0];
			}
			
			switch(thirdNumber) {
			//third number
			case 0: third = scoreImg[0];
			break;
			case 1: third = scoreImg[1];
			break;
			case 2: third = scoreImg[2];
			break;
			case 3: third = scoreImg[3];
			break;
			case 4: third = scoreImg[4];
			break;
			case 5: third = scoreImg[5];
			break;
			case 6: third = scoreImg[6];
			break;
			case 7: third = scoreImg[7];
			break;
			case 8: third = scoreImg[8];
			break;
			case 9: third = scoreImg[9];
			break;
			case 10: 
				secondNumber++;
				thirdNumber = 0;
			}
			switch(secondNumber) {
			case 0: second = scoreImg[0];
			break;
			case 1: second = scoreImg[1];
			break;
			case 2: second = scoreImg[2];
			break;
			case 3: second = scoreImg[3];
			break;
			case 4: second = scoreImg[4];
			break;
			case 5: second = scoreImg[5];
			break;
			case 6: second = scoreImg[6];
			break;
			case 7: second = scoreImg[7];
			break;
			case 8: second = scoreImg[8];
			break;
			case 9: second = scoreImg[9];
			break;
			case 10: 
				Score++;
				second = scoreImg[0];
			}
			switch(firstNumber) {
			case 0: first = scoreImg[0];
			break;
			case 1: first = scoreImg[1];
			break;
			case 2: first = scoreImg[2];
			break;
			case 3: first = scoreImg[3];
			break;
			case 4: first = scoreImg[4];
			break;
			case 5: first = scoreImg[5];
			break;
			case 6: first = scoreImg[6];
			break;
			case 7: first = scoreImg[7];
			break;
			case 8: first = scoreImg[8];
			break;
			case 9: first = scoreImg[9];
			break;
			case 10: 
				Score++;
				first = scoreImg[0];
			}
			
			
			
			}
			
	public class Main extends StateBasedGame{
		public static final int menu = 0;
		public static final int game = 1;

		public Main(String name) {
			super(name);
		//	this.addState(new Menu(menu));
		//	this.addState(new Game(game));
		
		}

		
		public void initStatesList(GameContainer gc) throws SlickException {
	
			this.getState(menu).init(gc, this);
			
			this.enterState(menu);
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
		//boolean pressed = Mouse.isButtonDown(button);
		boolean pressed = Mouse.getEventButtonState();
		
	

		return pressed;
	
	}

}
