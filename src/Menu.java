import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;


public class Menu {
	public Menu(int state){}
	private org.newdawn.slick.Image level1;
	private org.newdawn.slick.Image level2;
	private org.newdawn.slick.Image level3;
	private org.newdawn.slick.Image exit;
	
	public void init(GameContainer gc) throws SlickException
	{
		//import images for main menu
		
				level1 = new org.newdawn.slick.Image("/img/level1.png");
				level2 = new org.newdawn.slick.Image("/img/level2.png");
				level3 = new org.newdawn.slick.Image("/img/level3.png");
				exit = new org.newdawn.slick.Image("/img/exit.png");
	}
	public void render(GameContainer gc, Graphics g) throws SlickException
	{
		//render main menu
		level1.draw(250,100);
		level2.draw(250,250);
		level3.draw(250,400);
		exit.draw(250,550);
	}
}
