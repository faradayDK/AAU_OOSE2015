package game;

import org.newdawn.slick.Image;


public class Score {

	int [] scoreDisplayNumber = new int [4];
	int score = 0;
	int scoreContingForImg = score;
	
	
	public void AddScore(){
	//	for(int )
	if(scoreContingForImg>999){
		scoreDisplayNumber[0]  = (int)(scoreContingForImg/1000);
		scoreContingForImg = scoreContingForImg - 1000*scoreDisplayNumber[0];
	}
	if (scoreContingForImg>99){
		scoreDisplayNumber[1]  = (int)(scoreContingForImg/100);
		scoreContingForImg = scoreContingForImg - 100*scoreDisplayNumber[1] ;
	}
	if(scoreContingForImg>9){
		scoreDisplayNumber[2]  = (int)(scoreContingForImg/10);
		scoreContingForImg = scoreContingForImg - 10*scoreDisplayNumber[2] ;
	}
	if (scoreContingForImg<10){
		scoreDisplayNumber[3]  = scoreContingForImg;
	}
	
	}
}
