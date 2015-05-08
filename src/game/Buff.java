package game;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Buff {
	private float x;
	private float y;
	private float width;
	private Image image;
	private boolean collected;
	
	public Buff( float x, float y){
		this.x = x;
		this.y = y;
		this.width = 10;
		collected = false;
		try {
			image = new Image("/img/BuffPic.png");
		} catch (SlickException e) {
			System.out.println("/img/BuffPic.png cannot be found");
		}

		
	}
	public void moveBuff(){
		y+=3;
	}
	public float GetX(){
		return x;
	}
	public float GetY(){
		return y;
	}
	public float GetWidth(){
		return width;
	}
	
	public void Spawn(float x, float y){
		this.x = x;
		this.y = y;
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
		image.draw(x,y);
	}


}
