package game;

public class Brick {
    
	//
	public int type = 0;
	private int lives = 3;
	private float x, y = 0;
	private float length = 100;
	private float width = 15;
	
	public Brick(int type, float x , float y)
	{
		this.type = type;
		if(type == 1 || type == 2 || type == 3)
			lives = type;
		this.x = x;
		this.y = y;
	}
	public float X (){
		return this.x;
	}
	public float Y(){
		return this.y;
	}
	public float Length(){
		return this.length;
	}
	public float Width(){
		return this.width;
	}
}
