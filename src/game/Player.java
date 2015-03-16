package game;

import java.awt.event.KeyEvent;

public class Player {
	private float position;
	private int speed;
	private int length;
	private int color;
	
	
	public Player(int speed, float position, int length, int color) {
		
		this.speed = speed;
		this.position = position;
		this.length = length;
		this.color = color;
	
	}
	
	public void move(KeyEvent e) {
	if ( e.getKeyCode() == KeyEvent.VK_LEFT){
	     position+=speed; 
	}
	if ( e.getKeyCode() == KeyEvent.VK_RIGHT){
	     position-=speed;
	}
	}
}
