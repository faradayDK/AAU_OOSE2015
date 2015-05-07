package game;

public class Timer {
	
	// this class works as a timer. it takes 2 variables: time and delay. 
	//Time is actually a representation of length of seconds in our Timer. Delay shows how many seconds you want it to count.
	
	private int time, time2, delay2;
	
	public int delay;
	
	public Timer(int time, int delay){
		this.time = time;
		this.time2 = time;
		this.delay = delay;
		this.delay2 = delay;
	}
	// when this function is called, for example timer.start() it starts to decrease the time each frame. When the time equals to zero, 
	// it minuses delay. Thus delay works as a times that shows sort of seconds. 
	public void Start(){
		 if(time>0){
			 time--;
		 }
		 else{
			 delay--;
			 resetTime();
		 }
	}
	// resets time to initial one
	public void resetTime(){
		time = time2;
	}
	// makes it possible to track the delay
	public int GetDelay(){
		return delay;
	}
	//resets delay, so you can use it once again
	public void resetDelay(){
		delay = delay2;
	}

}
