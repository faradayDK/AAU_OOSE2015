package game;

import org.lwjgl.input.Mouse;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.GameState;
import org.newdawn.slick.state.StateBasedGame;

public class Menu implements GameState {
	public Menu(int state){}
	int Xpos, Ypos;
	private org.newdawn.slick.Image level1, level2, level3, exit;
	boolean level = false;
	
	public void init(GameContainer gc, StateBasedGame sbg)
			throws SlickException {
		
		//import images for main menu
		
		level1 = new org.newdawn.slick.Image("/img/level1.png");
		level2 = new org.newdawn.slick.Image("/img/level2.png");
		level3 = new org.newdawn.slick.Image("/img/level3.png");
		exit = new org.newdawn.slick.Image("/img/exit.png");

	}

	public void render(GameContainer gc, StateBasedGame arg1, Graphics arg2)
			throws SlickException {
		
		//render main menu
		if (level == false) {
				level1.draw(250,100);
				level2.draw(250,250);
				level3.draw(250,400);
				exit.draw(250,550);
		}
	}
	
	public void update(GameContainer gc, StateBasedGame sbg, int i) throws SlickException 
	{
		Xpos = Mouse.getX();
		Ypos = Mouse.getY();
		
		if(Xpos>250 && Xpos<950 && Ypos>100 && Ypos<254)
			if(Mouse.isButtonDown(0))
				sbg.enterState(1);
		
		if(Xpos>250 && Xpos<950 && Ypos>255 && Ypos<310)
			if(Mouse.isButtonDown(0))
				sbg.enterState(1);
		
		if(Xpos>250 && Xpos<950 && Ypos>100 && Ypos<254)
			if(Mouse.isButtonDown(0))
				System.exit(0);
	}

	@Override
	public void mouseClicked(int arg0, int arg1, int arg2, int arg3) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseDragged(int arg0, int arg1, int arg2, int arg3) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(int arg0, int arg1, int arg2, int arg3) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(int arg0, int arg1, int arg2) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(int arg0, int arg1, int arg2) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseWheelMoved(int arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void inputEnded() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void inputStarted() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isAcceptingInput() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setInput(Input arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(int arg0, char arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(int arg0, char arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void controllerButtonPressed(int arg0, int arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void controllerButtonReleased(int arg0, int arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void controllerDownPressed(int arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void controllerDownReleased(int arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void controllerLeftPressed(int arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void controllerLeftReleased(int arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void controllerRightPressed(int arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void controllerRightReleased(int arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void controllerUpPressed(int arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void controllerUpReleased(int arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void enter(GameContainer arg0, StateBasedGame arg1)
			throws SlickException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getID() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void leave(GameContainer arg0, StateBasedGame arg1)
			throws SlickException {
		// TODO Auto-generated method stub
		
	}

}
