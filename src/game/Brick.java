package game;
import org.newdawn.slick.Image;

public class Brick 
{
    
	//Type and lives represent how beaten is a brick, used to assign the image
	private int type = 0;
	private int lives = 3;
	//Bricks position
	private float x, y ;
	//Brick's size
	private static float width = 100;
	private static float height = 25;
	//Brick's state
	private boolean destroyed;
	
	/**
	 * Constructor for the single brick object
	 * @param type set the type (3 - full, 2- half-broken, 1 - nearly broken)
	 * @param x X coordinate for the top-right corner
	 * @param y Y coordinate for the top-right corner
	 */
	private Brick(int type, float x , float y)
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
	 * Method for assigning coordinates and types for bricks
	 * @param amount is the amount of bricks that need to be created
	 * @param startX is the coordinate on X-axis, where the first brick is going to be created
	 * @param startY is the coordinate on Y-axis, where the first brick is going to be created
	 * @return the array of bricks. Each brick has its own location and type.
	 */
	public static Brick[] Spawn (int amount, float startX, float startY){
		
		//Creates array of bricks
		Brick[] bricks = new Brick[amount];
		//Interval used to keep distance between bricks
		float interval = 3f;
		//Size of brick
		float bricksWidth = width;
		float bricksHeight = height;
		//Assign the coordinates for the first brick
		float coordX = startX;
		float coordY = startY;
		
		for(int i = 0 ; i < bricks.length ; i++){
			//Calculating on which line is a brick. The line affects the type of the brick, each 3 lines -> types repeats
			int type = (i/10)%3 +1;
			//Assign type and position for brick
			bricks[i] = new Brick(type, coordX, coordY);
			/*If coordinates of previous brick plus brickWidth and plus "correction value" (makes sure that there is a space between brick and window-border)
			 * is higher than the window-width, it will increase value coordY that means next brick should be spawned on the next line
			 * meanwhile, it will assign the starting coordinates for coordX -> thus, brick will be spawned in the beginning of the line
			 */
			if(coordX + bricksWidth + 200 > 1280){
				coordX = startX;
				coordY += bricksHeight + interval;
			}			
			//in other case, it will just continue to spawn bricks on teh same line
			else
			coordX += bricksWidth + interval;	
		}
		//after all coordinates were assigned to the bricks, it will return teh array of bricks
		return bricks;
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
		return height;
	}
	/**
	 * Get the width of the brick
	 * Returns the float
	 */
	public float GetWidth()
	{
		return width;
	}
	/**
	 * Get the type
	 * Returns the integer that represents the type of a brick
	 */
	public int GetType()
	{
		return this.type;
	}
	/**
	 * Check whether the brick was destroyed
	 * @return the boolean, if true, brick is destroyed
	 */
	public boolean GetDestroyed()
	{
		return this.destroyed;
	}
	/**
	 * Works only inside the class and checks whether the brick has life, if it does
	 * it assigns new type to the brick, that is equal to the number of life
	 */
	private void checkLife()
	{
		if(this.lives <= 0){
			this.destroyed = true;
			return;
		}
		type = lives;
	}
	/**
	 * Method is used in order to reduce life, it also checks whether the brick still has any life.
	 */
	public void ReduceLife()
	{
		this.lives --;
		checkLife();
	}
	
	/**
	 * Same as SPAWN, used to reset the brick-grid
	 * @param amount is the amount of bricks that need to be created
	 * @param startX is the coordinate on X-axis, where the first brick is going to be created
	 * @param startY is the coordinate on Y-axis, where the first brick is going to be created
	 * @return the array of bricks. Each brick has its own location and type.
	 */
	public static Brick [] Reset(int amount, int startX, int startY)
	{
		return Spawn( amount,  startX , startY);
	}
	
	/**
	 * Used to display the brick in renderer, will be displayed if only the brick is not destroyed.
	 * @param texture is an array of images that corresponds to the bricks type
	 */
	public void Display(Image [] texture)
	{
		if(!destroyed)
		texture[this.type-1].draw(this.x, this.y);
	}
}
