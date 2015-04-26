package game;

public class Ball {
	public float x,y;
	public boolean fliesRight = true;
	public boolean fliesDown  = true;
	public float angleRatio = 0.2f;
	//public static int Score = 0;
	

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
			else{
				fliesRight = false;
			}
		}
		if (fliesRight == false){
			if(this.x>0.0f){
				this.x = this.x-angleRatio;
			}
			else{
				fliesRight = true;
			}
			
		}
		if (fliesDown == true){
			if(this.y<720.0f){
				this.y = this.y+0.4f;
			}
			else {
				fliesDown = false;
				//Score++;
			
			}
		}
		if(fliesDown ==false){
			//Score++;
			if(this.y>0){
				this.y = this.y-0.4f;
			}
			else{
				fliesDown = true;
			}
		}
		

	
		
		
	
	}
	
	
}
