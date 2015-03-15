package game;

public class Brick {

	int type = 0;
	int lives = 3;
	
	public Brick(int type)
	{
		this.type = type;
		if(type == 1 || type == 2 || type == 3)
			lives = type;
	}
}
