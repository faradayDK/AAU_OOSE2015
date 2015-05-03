package game;

import org.lwjgl.input.Mouse;

public class GameFunctions {

	private int length;
	private int width;
	
	public void SpaceLimit(int length, int width , int distance)
	{
		this.length = length;
		this.width = width;
	}
	
	public boolean mouseClicked(int button){
		//boolean pressed = Mouse.isButtonDown(button);
		boolean pressed = Mouse.getEventButtonState();
		return pressed;
	}
}
