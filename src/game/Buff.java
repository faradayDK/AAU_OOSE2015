package game;

public class Buff {
	float BrickX;
	float BrickY;
	float Width =10;
	
	public Buff( float BrickX, float BrickY){
		this.BrickX = BrickX;
		this.BrickY = BrickY;
		
	}
	public void moveBuff(){
		BrickY+=3;
	}
	public float GetX(){
		return BrickX;
	}
	public float GetY(){
		return BrickY;
	}
	public float GetWidth(){
		return Width;
	}


}
