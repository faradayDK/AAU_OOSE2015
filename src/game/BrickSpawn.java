package game;

public class BrickSpawn {
	
	private float interval = 3f;
	private float bricksWidth = 100;
	private float bricksHeight = 25;
	private float width;
	private float height;
	
	//creates the different lines of bricks with different type
	public BrickSpawn(Brick [] bricks, float startWidth, float startHeight){
		this.height = startHeight; 
		this.width = startWidth;

		for(int i = 0 ; i < bricks.length ; i++){
			int type = (i/10)%3 +1;
			

			bricks[i] = new Brick(type, this.width, this.height);
			if(width + bricksWidth + 200 > 1280){
				this.width = startWidth;
				this.height += bricksHeight + interval;
			}			
			
			else
			width += bricksWidth + interval;
			
		}

	}

}
