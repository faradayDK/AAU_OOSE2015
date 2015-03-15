package game;

public class Ball {
	public int x,y;
	

	public Ball( int x, int y){
		this.x = x;
		this.y = y;
	}
	public int GetX(){
		return  this.x;
	}
	public int GetY(){
		return this.y;
	}
	public void MoveBall(){
		this.x = this.x+1;
	}
	
	
}
