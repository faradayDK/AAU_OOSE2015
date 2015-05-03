package game;
import org.newdawn.slick.Input;

public class Player {
	public float position;
	public float speed;
	public int length;
	public int width;
	private int color;
	private float speedConstant;

	
	
	public Player(float speed, float position, int length, int width) {
		
		this.speed = speed;
		this.position = position;
		this.length = length;
		this.width = width;
		this.speedConstant = speed;
	
	}
	
	public void moveLeft() {
	    position-=speed; 
	    checkSpeed();


	}
	public void moveRight(){
	    position+=speed;
	    checkSpeed();
	}
	public void resetSpeed(){
		speed = speedConstant;
	}
	private void checkSpeed(){
		if(speed + 0.005f < 2.0f)
		speed =speed+ 0.005f;
	}
}
