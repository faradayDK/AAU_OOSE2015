package game;

public class Brick {
    
	//
	private int type = 0;
	private int lives = 3;
	private float x, y = 0;
	private float length = 100;
	private float width = 15;
	
	/**
	 * Create a brick
	 * @param type set the type (1 for glass, 2 for wood , 3 for metal)
	 * @param x X coordinate for the top-right corner
	 * @param y Y coordinate for the top-right corner
	 */
	public Brick(int type, float x , float y)
	{
		this.type = type;
		if(type == 1 || type == 2 || type == 3)
			lives = type;
		this.x = x;
		this.y = y;
	}
	/**
	 * Get X-value (Top-right corner)
	 * Returns the float
	 */
	public float X (){
		return this.x;
	}
	/**
	 * Get Y-value (Top-right corner)
	 * Returns the float
	 */
	public float Y(){
		return this.y;
	}
	/**
	 * Get the length of the brick
	 * Returns the float
	 */
	public float Length(){
		return this.length;
	}
	/**
	 * Get the width of the brick
	 * Returns the float
	 */
	public float Width(){
		return this.width;
	}
	/**
	 * Get the type
	 * Returns the int
	 */
	public int Type(){
		return this.type;
	}
}
