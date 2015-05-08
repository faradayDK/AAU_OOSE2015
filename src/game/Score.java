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
				scoreAllImg[i] = new Image("img/" + i + ".png");
			} catch (SlickException e) {
				System.out.println("img/" + i + ".png cannot be found");
			}


		//assign image for the score word
		try {
			scoreWord = new Image("img/ScoreWord.png");
		} catch (SlickException e) {
			System.out.println("img/ScoreWord.png cannot be found");
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
	//
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
			//It will help to decompose the score number (e.g. 6456) to a four simple digits -> 6 , 4 ,5 ,6

			int number = (int) Math.pow(10, scoreDisplayNumber.length-1-i);
			if(number >= 10){
				//checks whether the score can be divisible by certain decimal
				//if no -> leave this digit as 0
				if(scoreCountingModulo>= number ){
					//then it counts what kind of number should this certain digit take
					scoreDisplayNumber[i]  = (int)(scoreCountingModulo/number);
					/*then it removes the decimal part from the score (if number was 8278, after % operation it will become 278
					 *it prepares it for the next digit
					 */
					scoreCountingModulo = scoreCountingModulo - number*scoreDisplayNumber[i];
				}
				else
					scoreDisplayNumber[i] = 0;
			}
			//if modulo is lower than 10 it assigns it to the last digit 
			else if (scoreCountingModulo<10){
				scoreDisplayNumber[i]  = scoreCountingModulo;
			}
		}
		//after the numbers for each digit are calculated
		//we assign images for each of these 4-digits, that corresponds to the numbers, that should be displayed
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
