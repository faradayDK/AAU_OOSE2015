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
	
	/**
	 * Increase score by certain value
	 * @param add -> add to the score
	 */
	public void Add(int add){
		//increase score
		score += add;
		//Variable is used to calculate number for each of the 4-digits
		scoreCountingModulo = score;
		/*This for-loop takes the each of the 4-digit and by dividing 
		 * the scores by 1000, 100, 10 it calculates how big should be the left-most digit
		 * then the second digit and so on
		 *
		 */
		for( int i = 0 ; i < scoreDisplayNumber.length; i++){
			//with a first run the number is going to be 1000,
			//the second is going to be 100
			//then 10
			
			//
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
	
	/**
	 * Method to display the score
	 * @param startX -> the Xcoord
	 * @param startY -> the Ycoord
	 */
	public void Display(float startX, float startY){
		scoreWord.draw(startX, startY);
		for(int i = 0 ; i<scoreDisplayImg.length; i++)
		scoreDisplayImg[i].draw(startX + 100 +(i*30),startY);
	}
	/**
	 * Method for reseting the score and the 4-digits
	 */
	public void Reset(){
		//Initial score
		score = 0 ;
		//We need to update each digit -> tell it that now score is equal to 0
		//Number that will be displayed
		for(int i = 0 ; i < scoreDisplayNumber.length ; i++)
			scoreDisplayNumber[i] = 0;
		
		//Assign 0th images to all score images
		for ( int i = 0 ; i < scoreDisplayImg.length ; i++)
			scoreDisplayImg[i] = scoreAllImg[0];
		

		
		
	}
}
