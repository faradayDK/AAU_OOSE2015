package game;

public class Ball {
	
	// realtime variables of ball position in the game
	private float x,y;
	
	//boolean that shows if ball flies up or down
	public boolean fliesRight = true;
	
	//boolean that shows if ball flies left or right
	public boolean fliesDown  = true;
	
	//border positions
	public float leftBorder = 100.0f;
	public float rightBorder = 1120.0f;
	
	// this int shows how strong the boll will change the angle after touching the player
	public int ballChange = 15;
	
	//this float shows the actual angle of ball's fly
	public float angleRatio = 2.0f;	
	
	//this float makes the ball fly more smooth even if the angle is big. Without this float the speed of a ball
	//significantly increases when it flies more horizontal
	public float makeBallFlySlower =0.0f;
	
	//shows how ball's Y cordinate changes
	public float ballYSpeed = 2.0f;
	
	//ball acceleration
	public float ballAcceleration = 0;

	//ball constructor
	public Ball( int x, int y){
		this.x = x;
		this.y = y;
	}
	
	//X and Y getters
	public float GetX(){
		return  this.x;
	}
	public float GetY(){
		return this.y;
	}
	
	// This function makes the ball move. It also includes the function that checks Direction which serves as
	//borders for the ball.
	public void MoveBall(){
		
		if (fliesRight == true){
			if(this.x<=rightBorder){
				this.x = ((this.x+ angleRatio) - makeBallFlySlower)+ballAcceleration;
				// this line changes the ball's angle of fly, makes it more smooth from speed perspective 
				//and accelerates it a bit every frame.
			}
		}
		if (fliesRight == false){
			if(this.x>=leftBorder){
				this.x = ((this.x-angleRatio)+makeBallFlySlower)-ballAcceleration;
			}
		}
		if (fliesDown == true){
			if(this.y<720.0f){
				this.y = ((this.y+ballYSpeed)-makeBallFlySlower)+ballAcceleration;
			}
		}
		if(fliesDown ==false){
			//Score++;
			if(this.y>0){
				this.y = ((this.y-ballYSpeed) +makeBallFlySlower)-ballAcceleration;
			}
		}
		// these 3 functions make ball fly only  within borders, corrects the speed and accelerate it a bit
		checkDirection();	
		BallCorrection();
		BallAcceleration();
	}
	
	// Both BallAngle1 and BallAngle2 work as physics for the ball. 
	// it consideres 4 different situations: 
	//1) if the ball flies right, player moves right too, so when touching, ball takes some power from player, 
	// and angle gets bigger.
	//2) if the ball flies to the right, but player moves to the left, so when touching, ball actually looses some angle.
	//3) oposite to 1st.
	//4)oposite to 2nd.
	// else, if it calkulates that force that player gives to ball is very big, it reverts the angle of ball, and it flies oposite direction
	
	public void BallAngle1(Player player){
		if(fliesRight ==true){
			angleRatio = Math.abs(angleRatio-((player.speed)*2)/ballChange);
			if( (angleRatio-player.speed/ballChange)<0){
				fliesRight =false;
			}
		}
		else{
			angleRatio = angleRatio+((player.speed)*2)/ballChange;
		}
	}
	public void BallAngle2(Player player){
		if(fliesRight ==true){
			angleRatio = angleRatio+player.speed/ballChange;	
		}
		else{
			angleRatio = Math.abs(angleRatio-player.speed/ballChange);
			if((angleRatio-player.speed/ballChange)<0){
				fliesRight = true;
			}
		}
	}
	
	// creates the borders for the ball.
	private void checkDirection(){
		if(this.x<=leftBorder){
			fliesRight =true;
		}
		if(this.x>=rightBorder){
			fliesRight =false;
		}
		if (this.y<45){
			fliesDown = true;
		}
	}
	// resetes all ball's features.
	public void Reset(){
		this.x = 400;
		this.y = 400;
		fliesRight = true;
		fliesDown = true;
		angleRatio = 2.0f;
		ResetBallAcceleration();
	}
	
	// corrects the speed of the ball
	private void BallCorrection(){
		makeBallFlySlower = angleRatio/3;
	}
	//accelerates the ball every frame a bit
	public void BallAcceleration(){
		if (ballAcceleration<6.0f)
		ballAcceleration = ballAcceleration+0.001f;
		if(ballAcceleration>6.0f)
			ballAcceleration = 6.0f;
	}
	// resetes acceleration
	public void ResetBallAcceleration(){
		ballAcceleration = ballAcceleration/2;
	}
	// this void returns a boolean that says if the ball touches the player. If it happens, it returns true, otherwise false.
	public boolean Collision(Player player){
		
		if(this.x > player.GetX()-5 && this.x < (player.GetX() + player.GetLength()+5)){
			if(this.y > player.GetY() - player.GetWidth() && this.y < (player.GetY() + player.GetWidth())){
				this.y -=5;
				return true;
			}
		}
		
		return false;
	}
	// same as with player, it detects if ball touches bricks.
	public boolean Collision(Brick brick){
		
		float correction = 1.5f;
		if(this.x + correction > brick.GetX() - correction && this.x - correction < (brick.GetX() + brick.GetWidth() + correction)){
			if(this.y + correction > brick.GetY() - correction && this.y - correction  < (brick.GetY() + brick.GetHeight() + correction)){
				if(!brick.GetDestroyed())
					return true;
			}
		}
		
		return false;
	}
	public boolean CollisionWithBuff(Buff buff){
		
		float correction = 1.5f;
		if(this.x + correction > buff.GetX() - correction && this.x - correction < (buff.GetX() + buff.GetWidth() + correction)){
			if(this.y + correction > buff.GetY() - correction && this.y - correction  < (buff.GetY() + buff.GetWidth() + correction)){
				
					return true;
			}
		}
		
		return false;
	}
}
