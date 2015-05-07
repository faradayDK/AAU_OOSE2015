package game;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Life {
	
	//Stores the value of life
	private int life;
	//Image for displaying the life
	private Image lifeImg;
	//Image for displaying the word lives
	private Image lifeStringImg;
	
	public Life(){
		//Default lives
		life = 3;
		//Upload the image for the lives
		try {
			lifeImg = new Image("img/Life.png");
		} catch (SlickException e) {
			System.out.println("img/Life.png cannot be found");
		}
		//Upload image for the word
		try{
			lifeStringImg = new Image("img/LivesWord.png");
		} catch (SlickException e){
			System.out.println("img/LivesWord.png cannot be found");
		}
	}
	
	/**
	 * Get the amount of user's life
	 * @return the amount of user's life
	 */
	public int Get(){
		return this.life;
	}
	
	/**
	 * Subtract one life from the user
	 */
	public void Reduce(){
		this.life--;
	}
	
	/**
	 * Method to display the player's life (only in renderer)
	 * @param startX the X coordinate of the life "box"
	 * @param startY the Y coordinate of the life "box"
	 */
	public void Display(float startX, float startY){
		//Draw word
		lifeStringImg.draw(startX, startY + 3);
		
		//Draw lives; depends on the amount of lives that user has
		for(int i = 0 ; i < life ; i++)
			lifeImg.draw(startX + 80 + (i * 40), startY);
	}
	
	/**
	 * Reset the user's life with a value 3
	 */
	
	public void Reset(){
		life = 3;
	}

}
