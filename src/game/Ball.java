package game;

public class Ball {
	public float x,y;
	private boolean fliesRight = true;
	public boolean fliesDown  = true;
	

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
				this.x = this.x+0.6f;
			}
			else{
				fliesRight = false;
			}
		}
		if (fliesRight == false){
			if(this.x>0){
				this.x = this.x-0.6f;
			}
			else{
				fliesRight = true;
			}
			
		}
		if (fliesDown == true){
			if(this.y<720){
				this.y = this.y+0.6f;
			}
			else {
				fliesDown = false;
			}
		}
		if(fliesDown ==false){
			if(this.y>0){
				this.y = this.y-0.6f;
			}
			else{
				fliesDown = true;
			}
		}
		

	
		
		
	
	}
	
	
}
