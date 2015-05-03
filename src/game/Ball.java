package game;

public class Ball {
	private float x,y;
	private float previousX, previousY;
	public boolean fliesRight = true;
	public boolean fliesDown  = true;
	public float angleRatio = 0.2f;	

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
	
	public void MoveBall(){
		
		if (fliesRight == true){
			if(this.x<1280){
				this.x = this.x+ angleRatio;
			}

		}
		if (fliesRight == false){
			if(this.x>0.0f){
				this.x = this.x-angleRatio;
			}

			
		}
		if (fliesDown == true){
			if(this.y<720.0f){
				this.y = this.y+0.4f;
			}

		}
		if(fliesDown ==false){
			//Score++;
			if(this.y>0){
				this.y = this.y-0.4f;
			}

		}
		checkDirection();
		previousY = y;
		previousX = x;
		
		
	
	}
	
	private void checkDirection(){
		if(this.y - previousY >=0)
			fliesDown = true;
		else
			fliesDown = false;
		
		if(this.x - previousX >= 0)
			fliesRight = true;
		else
			fliesRight = false;
	
		if(this.y >= 720 || this.y <= 0)
			fliesDown = !fliesDown;
		if(this.x  >=1280 || this.x <= 0)
			fliesRight = !fliesRight;
	}
}
