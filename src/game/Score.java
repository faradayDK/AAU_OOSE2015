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
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		//Number that will be displayed
		for(int i = 0 ; i < scoreDisplayNumber.length ; i++)
			scoreDisplayNumber[i] = 0;
		
		//Assign 0th images to all score images
		for ( int i = 0 ; i < scoreDisplayImg.length ; i++)
			scoreDisplayImg[i] = scoreAllImg[0];
	}
	
	
	public void AddScore(){
		score++;
		
		scoreCountingModulo = score;
		if(scoreCountingModulo>999){
			scoreDisplayNumber[0]  = (int)(scoreCountingModulo/1000);
			scoreCountingModulo = scoreCountingModulo - 1000*scoreDisplayNumber[0];
		}
		if (scoreCountingModulo>99){
			scoreDisplayNumber[1]  = (int)(scoreCountingModulo/100);
			scoreCountingModulo = scoreCountingModulo - 100*scoreDisplayNumber[1] ;
		}
		if(scoreCountingModulo>9){
			scoreDisplayNumber[2]  = (int)(scoreCountingModulo/10);
			scoreCountingModulo = scoreCountingModulo - 10*scoreDisplayNumber[2] ;
		}
		if (scoreCountingModulo<10){
			scoreDisplayNumber[3]  = scoreCountingModulo;
		}
		
		for( int i = 0 ; i < scoreDisplayImg.length ; i++)
			scoreDisplayImg[i] = scoreAllImg[scoreDisplayNumber[i]];
	}
	
	
	public void DisplayScore(){
		for(int i = 0 ; i<scoreDisplayImg.length; i++)
		scoreDisplayImg[i].draw(100+(i*50),0);
	}
	
	public void ResetScore(){
		score = 0;
	}
}
