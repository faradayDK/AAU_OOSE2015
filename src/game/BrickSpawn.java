package game;

public class BrickSpawn {
	
	private float interval = 3f;
	private float bricksWidth = 100;
	private float bricksHeight = 25;
	private float width;
	private float height;
	
	
	public BrickSpawn(Brick [] bricks, float startWidth, float startHeight, int type){
		this.height = startHeight; 
		this.width = startWidth;
		for(int i = 0 ; i < bricks.length ; i++){

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
