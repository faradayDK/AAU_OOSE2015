package game;
import org.newdawn.slick.Input;

public class Player {
	public float positionX;
	private float positionY = 600;
	public float speed;
	public int length;
	public int width;
	
	private int color;
	private float speedConstant;

	
	
	public Player(float speed, float position, int length, int width) {
		
		this.speed = speed;
		this.positionX = position;
		this.length = length;
		this.width = width;
		this.speedConstant = speed;
	
	}
	
	
	public void moveLeft() {
		  checkSpeed();
	    positionX-=speed; 
	    checkBorders();


	}
	public void moveRight(){
		  checkSpeed();
	    positionX+=speed;
	    checkBorders();
	  
	}
	
	private void checkBorders(){
		if (positionX<93){
			positionX = 93;
		}
		if (positionX>1013){
			positionX = 1013;
		}
	}
	
	public void resetSpeed(){
		speed = speedConstant;
	}
	
	private void checkSpeed(){
		if(speed + 0.005f < 12.0f)
		speed =speed+ 0.8f;
	}
	
	public float GetY()
	{
		return this.positionY;
	}
	public float GetX()
	{
		return this.positionX;
	}
	
	public float GetWidth()
	{
		return this.width;
	}
	public float GetLength()
	{
		return this.length;
	}
}
