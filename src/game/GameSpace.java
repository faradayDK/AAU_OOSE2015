package game;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
//Package "Basic Game" for 2D game development

public class GameSpace extends BasicGame
{

	//Global variables
	public Brick [] bricks = new Brick[30];
	public BrickSpawn brickSpawn;
	public Ball ball;
	public Player player;
	
	//Setup for the screen size
	public static int spaceHeight = 720;
	public static int spaceWidth = 1280;
	public int BallChange = 10;
	
	
	//images for score
	Image one, two, three, four, five, six, seven, eight, nine, zero, first, second, third, fourth;
	public int fourthNumber =0;
	public int thirdNumber =0;
	public int secondNumber =0;
	public int firstNumber =0;
	public boolean hit4score = false;
	public int Score = 8;
	
	
	
	
	
	
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
		brickSpawn = new BrickSpawn(bricks, 100, 50, 1);
		
		//import images for score
		zero = new Image("D:/Users/liza/Desktop/AAU/MED4/OOSE/MiniProject/0.png");
		one = new Image ("D:/Users/liza/Desktop/AAU/MED4/OOSE/MiniProject/1.png");
		two = new Image ("D:/Users/liza/Desktop/AAU/MED4/OOSE/MiniProject/2.png");
		three = new Image ("D:/Users/liza/Desktop/AAU/MED4/OOSE/MiniProject/3.png");
		four = new Image ("D:/Users/liza/Desktop/AAU/MED4/OOSE/MiniProject/4.png");
		five = new Image ("D:/Users/liza/Desktop/AAU/MED4/OOSE/MiniProject/5.png");
		six = new Image ("D:/Users/liza/Desktop/AAU/MED4/OOSE/MiniProject/6.png");
		seven = new Image ("D:/Users/liza/Desktop/AAU/MED4/OOSE/MiniProject/7.png");
		eight = new Image ("D:/Users/liza/Desktop/AAU/MED4/OOSE/MiniProject/8.png");
		nine = new Image ("D:/Users/liza/Desktop/AAU/MED4/OOSE/MiniProject/9.png");
		
		first = zero;
		second = zero;
		third = zero;
		fourth = zero;
		

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
        		
        		
        		Score++;
        		counter();
        		first.draw(0,0);
        		second.draw(50, 0);
        		third.draw(100,0);
        		fourth.draw(150,0);
        		
        		
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
		System.out.println(Score);
		ball.MoveBall();
	
    for(int i = 0 ; i<bricks.length; i++){
	g.drawRect(bricks[i].GetX() ,bricks[i].GetY() , bricks[i].GetWidth() , bricks[i].GetHeight() );
	//System.out.println(bricks[i].GetX());
    }
   
	g.drawRect(player.position , spaceHeight - 100, player.length , player.width);
	g.drawOval(ball.GetX(), ball.GetY(), 20,20);
	
	
	first.draw(0,0);
	second.draw(50, 0);
	third.draw(100,0);
	fourth.draw(150,0);
	if (hit4score == true) {
    	counter();
    	hit4score = false;
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
			case 0: fourth = zero;
			break;
			case 1: fourth = one;
			break;
			case 2: fourth = two;
			break;
			case 3: fourth = three;
			break;
			case 4: fourth = four;
			break;
			case 5: fourth = five;
			break;
			case 6: fourth = six;
			break;
			case 7: fourth = seven;
			break;
			case 8: fourth = eight;
			break;
			case 9: fourth = nine;
			break;
			case 10: 
				Score++;
				fourth = zero;
			}
			
			switch(thirdNumber) {
			//third number
			case 0: third = zero;
			break;
			case 1: third = one;
			break;
			case 2: third = two;
			break;
			case 3: third = three;
			break;
			case 4: third = four;
			break;
			case 5: third = five;
			break;
			case 6: third = six;
			break;
			case 7: third = seven;
			break;
			case 8: third = eight;
			break;
			case 9: third = nine;
			break;
			case 10: 
				secondNumber++;
				thirdNumber = 0;
			}
			switch(secondNumber) {
			case 0: second = zero;
			break;
			case 1: second = one;
			break;
			case 2: second = two;
			break;
			case 3: second = three;
			break;
			case 4: second = four;
			break;
			case 5: second = five;
			break;
			case 6: second = six;
			break;
			case 7: second = seven;
			break;
			case 8: second = eight;
			break;
			case 9: second = nine;
			break;
			case 10: 
				Score++;
				second = zero;
			}
			switch(firstNumber) {
			case 0: first = zero;
			break;
			case 1: first = one;
			break;
			case 2: first = two;
			break;
			case 3: first = three;
			break;
			case 4: first = four;
			break;
			case 5: first = five;
			break;
			case 6: first = six;
			break;
			case 7: first = seven;
			break;
			case 8: first = eight;
			break;
			case 9: first = nine;
			break;
			case 10: 
				Score++;
				first = zero;
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

	
}
