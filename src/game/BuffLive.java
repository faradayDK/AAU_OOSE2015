package game;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class BuffLive {
	private float xLive;
	private float yLive;
	private float width;
	private Image imageLive;
	private boolean collected;
	
	public BuffLive(float x, float y) {
		this.xLive = x;
		this.yLive = y;
		this.width = 10;
		collected = false;
		//try to upload image of buff
		try {
			imageLive = new Image("/img/buffLive.png");
		} catch (SlickException e) {
			System.out.println("/img/buffLive.png cannot be found");
		}
	}
	public void moveBuff(){
		yLive+=3;
	}
	//gets location of buff
	public float GetX(){
		return xLive;
	}
	public float GetY(){
		return yLive;
	}
	public float GetWidth(){
		return width;
	}
	public void Spawn(float x, float y) {
		this.xLive = x;
		this.yLive = y;
		collected = false;
	
	}
	public void Collected(){
		collected = true;
	}
	public boolean GetCollected(){
		return collected;
	}
	public void Display(){
		if(!collected)
		imageLive.draw(xLive,yLive);
	}
	
}
