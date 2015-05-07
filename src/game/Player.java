package game;

public class Player {
	
	//The position of player on x-axis
	private float positionX;
	//Always constant
	private float positionY = 612;
	
	public float speed;
	public int length;
	public int width;
	public float initialPosition;
	//As the player increases the speed in some conditions, we need to reset it sometimes
	private float speedConstant;
	
	/**
	 * Constructor for the player object
	 * @param speed -> initial speed of the player
	 * @param position -> initial position of the player
	 * @param length -> the length of the player
	 * @param width -> the width of the player
	 */
	public Player(float speed, float position, int length, int width) {
		
		this.speed = speed;
		//X coordinate of the player
		this.positionX = position;
		this.length = length;
		this.width = width;
		//The constant speed is used later on
		this.speedConstant = speed;
		/*
		 * All the time level starts again (i.e. after player lost one life),
		 * the player is going to spawn on the initialPosition
		*/
		this.initialPosition = position;
	
	}
	
	/**
	 * Method to move player to the left,
	 * while player holds the button -> speed grows (checkSpeed())
	 * also if player hit the wall, he stops to move
	 */
	public void moveLeft() {
		checkSpeed();
	    positionX-=speed; 
	    checkBorders();
	}
	
	/**
	 * Same as for the previous method
	 */
	public void moveRight(){
		checkSpeed();
	    positionX+=speed;
	    checkBorders();
	  
	}
	
	/**
	 * Method to check whether the player hits the wall
	 */
	private void checkBorders(){
		if (positionX<93){
			positionX = 93;
		}
		if (positionX>1013){
			positionX = 1013;
		}
	}
	
	/**
	 * When player releases the button, speed resets
	 */
	public void resetSpeed(){
		speed = speedConstant;
	}
	
	/**
	 * While the player object is moving, the speed is rising.
	 * This, the longer player holds buttons (moves object), the faster is moves
	 */
	private void checkSpeed(){
		if(speed + 0.005f < 12.0f)
		speed =speed+ 0.8f;
	}
	
	/**
	 * Put player object on the initial position
	 */
	public void Reset(){
		positionX = initialPosition;
	}
	
	/**
	 * @return the yPosition of the player
	 */
	public float GetY()
	{
		return this.positionY;
	}
	
	/**
	 * @return the xPositon of the player
	 */
	public float GetX()
	{
		return this.positionX;
	}
	
	/**
	 *@return width of the player
	 */
	public float GetWidth()
	{
		return this.width;
	}
	
	/**
	 * @return length of the player
	 */
	public float GetLength()
	{
		return this.length;
	}
	
	/**
	 * @return the current speed of the player object
	 */
	public float GetSpeed(){
		return this.speed;
	}
}
