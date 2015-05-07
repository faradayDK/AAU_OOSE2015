package game;

public class Ball {
	private float x,y;
	public boolean fliesRight = true;
	public boolean fliesDown  = true;
	public float leftBorder = 100.0f;
	public float rightBorder = 1120.0f;
	public int ballChange = 15;
	public float angleRatio = 2.0f;	
	public float makeBallFlySlower =0.0f;
	public float ballYSpeed = 2.0f;
	public float ballAcceleration = 0;

	public Ball( int x, int y){
		this.x = x;
		this.y = y;
	}
	public float GetX(){
		return  this.x;
	}
	public float GetY(){
		return this.y;
	}
	
	// This function makes the ball move. It also includes the function check Direction which serves as
	//borders for the ball.
	public void MoveBall(){
		
		if (fliesRight == true){
			if(this.x<=rightBorder){
				this.x = ((this.x+ angleRatio) - makeBallFlySlower)+ballAcceleration;
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
		checkDirection();	
		BallCorrection();
		BallAcceleration();
	}
	
	// Both BallAngle1 and BallAngle2 work as physics for the ball. 
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
	}
	public void resetBall(){
		this.x = 400;
		this.y = 400;
		fliesRight = true;
		fliesDown = true;
		angleRatio = 2.0f;
	}
	private void BallCorrection(){
		makeBallFlySlower = angleRatio/3;
	}
	//public void 
	public void BallAcceleration(){
		if (ballAcceleration<6.0f)
		ballAcceleration = ballAcceleration+0.001f;
		if(ballAcceleration>6.0f)
			ballAcceleration = 6.0f;
	}
	
	public boolean collision(Player player){
		
		if(this.x > player.GetX()-5 && this.x < (player.GetX() + player.GetLength()+5)){
			if(this.y > player.GetY() && this.y < (player.GetY() + player.GetWidth())){
				return true;
			}
		}
		
		return false;
	}
	
	public boolean collision(Brick brick){
		
		float correction = 1.5f;
		if(this.x + correction > brick.GetX() - correction && this.x - correction < (brick.GetX() + brick.GetWidth() + correction)){
			if(this.y + correction > brick.GetY() - correction && this.y - correction  < (brick.GetY() + brick.GetHeight() + correction)){
				if(!brick.GetDestroyed())
					return true;
			}
		}
		
		return false;
	}
}
