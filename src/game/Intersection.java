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
		
		float correction = 1.5f;
		if(ball.GetX() + correction > brick.GetX() - correction && ball.GetX() - correction < (brick.GetX() + brick.GetWidth() + correction)){
			if(ball.GetY() + correction > brick.GetY() - correction && ball.GetY() - correction  < (brick.GetY() + brick.GetHeight() + correction)){
				return true;
			}
		}
		
		return false;
	}
}
