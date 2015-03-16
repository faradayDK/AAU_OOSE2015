package game;

import java.awt.event.KeyEvent;

public class Player {
	public float position;
	public int speed;
	private int length;
	private int color;
	private int speedConstant;
	
	
	public Player(int speed, float position, int length, int color) {
		
		this.speed = speed;
		this.position = position;
		this.length = length;
		this.color = color;
		this.speedConstant = speed;
	
	}
	
	public void moveLeft() {
		

	    position+=speed; 
	    speed =speed+1;
	     
	}
	public void moveRight(){

	    position-=speed;
	    speed = speed+1;
	}
	public void resetSpeed(){
		speed = speedConstant;
	}
}
