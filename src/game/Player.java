package game;

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
	    position+=speed; 
	    speed =speed+ 0.01f;

	}
	public void moveRight(){
	    position-=speed;
	    speed = speed + 0.01f;
	}
	public void resetSpeed(){
		speed = speedConstant;
	}
}
