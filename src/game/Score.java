package game;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;


public class Score {
	
	//We display score in 4 digits, each digit stores the info about which number to show
	private int [] scoreDisplayNumber = new int [4];
	//Initial score
	private int score = 0;
	//Used to calculate numbers for the [] scoreDisplayNumber
	private int scoreCountingModulo = score;
	//Array stores the images that should be displayed in each of the 4 score-digits
	private Image [] scoreDisplayImg = new Image[4];
	//Array stores images for all digits : 0 1 2 3 4 5 6 7 8 9
	private static Image [] scoreAllImg = new Image[10];
	
	private static Image scoreWord;
	
	/**
	 * Constructor for the score 
	 */
	public Score(){
		//assign images for each score
		for(int i = 0; i < scoreAllImg.length; i++)
			try {
				scoreAllImg[i] = new Image("/img/" + i + ".png");
			} catch (SlickException e) {
				System.out.println("/img/" + i + ".png cannot be found");
			}


		//assign image for the score word
		try {
			scoreWord = new Image("/img/ScoreWord.png");
		} catch (SlickException e) {
			System.out.println("/img/ScoreWord.png cannot be found");
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
		//
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
		scoreWord.draw(startX, startY);
		for(int i = 0 ; i<scoreDisplayImg.length; i++)
		scoreDisplayImg[i].draw(startX + 100 +(i*50),startY);
	}
	
	public void Reset(){
		//Initial score
		score = 0 ;
		//We need to update each digit -> tell it that now score is eqal to 0
		//Number that will be displayed
		for(int i = 0 ; i < scoreDisplayNumber.length ; i++)
			scoreDisplayNumber[i] = 0;
		
		//Assign 0th images to all score images
		for ( int i = 0 ; i < scoreDisplayImg.length ; i++)
			scoreDisplayImg[i] = scoreAllImg[0];
		

		
		
	}
}
