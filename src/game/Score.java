package game;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;


public class Score {

	private int [] scoreDisplayNumber = new int [4];
	private int score = 0;
	private int scoreCountingModulo = score;
	private Image [] scoreDisplayImg = new Image[4];
	private static Image [] scoreAllImg = new Image[10];
	
	public Score(){
		//assign images for each score
		for(int i = 0; i < scoreAllImg.length; i++)
			try {
				scoreAllImg[i] = new Image("/img/" + i + ".png");
			} catch (SlickException e) {
				System.out.println("/img/" + i + ".png cannot be found");
			}
		
		//Number that will be displayed
		for(int i = 0 ; i < scoreDisplayNumber.length ; i++)
			scoreDisplayNumber[i] = 0;
		
		//Assign 0th images to all score images
		for ( int i = 0 ; i < scoreDisplayImg.length ; i++)
			scoreDisplayImg[i] = scoreAllImg[0];
	}
	
	
	public void Add(){
		score++;
		scoreCountingModulo = score;
		
		for( int i = 0 ; i < scoreDisplayNumber.length; i++){
			int number = (int) Math.pow(10, scoreDisplayNumber.length-1-i);
			if(number >= 10){
				if(scoreCountingModulo> number - 1){
					scoreDisplayNumber[i]  = (int)(scoreCountingModulo/number);
					scoreCountingModulo = scoreCountingModulo - number*scoreDisplayNumber[i];
				}
			}
			else if (scoreCountingModulo<10){
				scoreDisplayNumber[i]  = scoreCountingModulo;
			}
		}
		
		for( int i = 0 ; i < scoreDisplayImg.length ; i++)
			scoreDisplayImg[i] = scoreAllImg[scoreDisplayNumber[i]];
	}
	
	
	public void Display(float startX, float startY){
		for(int i = 0 ; i<scoreDisplayImg.length; i++)
		scoreDisplayImg[i].draw(startX+(i*50),startY);
	}
	
	public void Reset(){
		score = -1;
		Add();
		

		
		
	}
}
