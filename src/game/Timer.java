package game;

public class Timer {
	private int time, time2, delay2;
	
	public int delay;
	
	public Timer(int time, int delay){
		this.time = time;
		this.time2 = time;
		this.delay = delay;
		this.delay2 = delay;
	}

	public void Start(){
		 if(time>0){
			 time--;
		 }
		 else{
			 delay--;
			 resetTime();
		 }
	}
	public void resetTime(){
		time = time2;
	}
	public int GetDelay(){
		return delay;
	}
	public void resetDelay(){
		delay = delay2;
	}

}
