package game;

public class Brick 
{
    
	//
	private int type = 0;
	private int lives = 3;
	private float x, y ;
	private float width = 100;
	private float height = 25;
	private boolean destroyed;
	
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
		//else if (type == 4)
		this.x = x;
		this.y = y;
		this.destroyed = false;
	}
	
	/**
	 * Get X-value (Top-right corner)
	 * Returns the float
	 */
	public float GetX ()
	{
		return this.x;
	}
	/**
	 * Get Y-value (Top-right corner)
	 * Returns the float
	 */
	public float GetY()
	{
		return this.y;
	}
	/**
	 * Get the length of the brick
	 * Returns the float
	 */
	public float GetHeight()
	{
		return this.height;
	}
	/**
	 * Get the width of the brick
	 * Returns the float
	 */
	public float GetWidth()
	{
		return this.width;
	}
	
	
	/**
	 * Get the type
	 * Returns the int
	 */
	public int GetType()
	{
		return this.type;
	}
	
	public int GetLife()
	{
		return this.lives;
	}
	
	public boolean GetDestroyed(){
		return this.destroyed;
	}
	
	private void checkLife(){
		if(this.lives <= 0){
			this.destroyed = true;
			return;
		}
		type = lives;
	}
	public void ReduceLife(){
		this.lives --;
		checkLife();
	}
	
}
