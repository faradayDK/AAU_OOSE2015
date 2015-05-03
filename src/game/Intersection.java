package game;

public class Intersection {

	public Intersection(){
		
	}
	
	public boolean collisionBallPlayer(Ball ball, Player player){
		
		if(ball.GetX() > player.GetX() && ball.GetX() < (player.GetX() + player.GetLength())){
			if(ball.GetY() > player.GetY() && ball.GetY() < (player.GetY() + player.GetWidth())){
				return true;
			}
		}
		
		return false;
	}
	
	public boolean collisionBallBrick (Ball ball, Brick brick){
		
		if(ball.GetX() > brick.GetX() && ball.GetX() < (brick.GetX() + brick.GetWidth())){
			if(ball.GetY() > brick.GetY() && ball.GetY() < (brick.GetY() + brick.GetHeight())){
				return true;
			}
		}
		
		return false;
	}
}
