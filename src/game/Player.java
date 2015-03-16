package game;

import java.awt.event.KeyEvent;

public class Player {
	public float position;
	private float speed;
	public int length;
	public int width;
	private int color;
	
	
	public Player(float speed, float position, int length, int width,  int color) {
		
		this.speed = speed;
		this.position = position;
		this.length = length;
		this.width = width;
		this.color = color;
	
	}
	
	public void moveLeft() {

	     position-=speed; 
	     
	}
	public void moveRight(){

	     position+=speed;
	}
}
