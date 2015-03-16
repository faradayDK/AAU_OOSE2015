package game;

import java.awt.event.KeyEvent;

public class Player {
	public float position;
	private int speed;
	private int length;
	private int color;
	
	
	public Player(int speed, float position, int length, int color) {
		
		this.speed = speed;
		this.position = position;
		this.length = length;
		this.color = color;
	
	}
	
	public void moveLeft() {

	     position+=speed; 
	     
	}
	public void moveRight(){

	     position-=speed;
	}
}
