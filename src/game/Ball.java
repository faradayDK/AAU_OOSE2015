package game;

public class Ball {
	public int x,y;
	private boolean fliesRight = true;
	private boolean fliesDown  = true;
	

	public Ball( int x, int y){
		this.x = x;
		this.y = y;
	}
	public int GetX(){
		return  this.x;
	}
	public int GetY(){
		return this.y;
	}
	public void MoveBall(){
		
		if (fliesRight == true){
			if(this.x<1280){
				this.x = this.x+1;
			}
			else{
				fliesRight = false;
			}
		}
		if (fliesRight == false){
			if(this.x>0){
				this.x = this.x-1;
			}
			else{
				fliesRight = true;
			}
			
		}
		if (fliesDown == true){
			if(this.y<720){
				this.y = this.y+1;
			}
			else {
				fliesDown = false;
			}
		}
		if(fliesDown ==false){
			if(this.y>0){
				this.y = this.y-1;
			}
			else{
				fliesDown = true;
			}
		}
		

	
		
		
	
	}
	
	
}
