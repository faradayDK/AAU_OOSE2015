package game;

public class Ball {
	private float x,y;
	
	private float previousX, previousY;
	
	public boolean fliesRight = true;
	public boolean fliesDown  = true;
	public float leftBorder = 100.0f;
	public float rightBorder = 1120.0f;
	
	public float angleRatio = 2.0f;	
	
	//public 

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
			if(this.x<=rightBorder){
				this.x = this.x+ angleRatio;
			}

		}
		if (fliesRight == false){
			if(this.x>=leftBorder){
				this.x = this.x-angleRatio;
			}

			
		}
		if (fliesDown == true){
			if(this.y<720.0f){
				this.y = this.y+2.0f;
			}

		}
		if(fliesDown ==false){
			//Score++;
			if(this.y>0){
				this.y = this.y-2.0f;
			}

		}
		checkDirection();
		//previousY = y;
		//previousX = x;
		
		
	
	}
	
	private void checkDirection(){
		if(this.x<=leftBorder){
			fliesRight =true;
		}
		if(this.x>=rightBorder){
			fliesRight =false;
		}
		
		
		
		
		
		
		/*
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
			fliesRight = !fliesRight;	*/
	}
}
