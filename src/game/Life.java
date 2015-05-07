package game;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Life {
	
	private int life;
	private Image lifeImg;
	private Image lifeStringImg;
	
	public Life(){
		life = 3;
		try {
			lifeImg = new Image("img/Life.png");
		} catch (SlickException e) {
			System.out.println("img/Life.png cannot be found");
		}
		
		try{
			lifeStringImg = new Image("img/LivesWord.png");
		} catch (SlickException e){
			System.out.println("img/LivesWord.png cannot be found");
		}
	}
	
	public int Get(){
		return this.life;
	}
	
	public void Reduce(){
		this.life--;
	}
	
	public void Display(float startX, float startY){
		lifeStringImg.draw(startX, startY + 3);
		
		for(int i = 0 ; i < life ; i++)
			lifeImg.draw(startX + 80 + (i * 40), startY);
	}
	
	public void Reset(){
		life = 3;
	}

}
