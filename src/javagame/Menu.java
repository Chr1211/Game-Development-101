package javagame;

import org.newdawn.slick.*;
import org.newdawn.slick.state.*;
import org.lwjgl.input.Mouse;
import org.lwjgl.input.Keyboard;

public class Menu extends BasicGameState {

	// private String mouse = "No input yet";
	
//	private Image face;
//	private int faceX = 200;
//	private int faceY = 200;

	public Menu(int state) {

	}

	public void init(GameContainer gc, StateBasedGame sbg)
			throws SlickException {
//		face = new Image("res/bubble_right.png");

	}

	public void render(GameContainer gc, StateBasedGame sbg, Graphics g)
			throws SlickException {
		g.fillOval(75,100,100,100);
		g.drawString("Play now!",80,70);
		
//		g.drawImage(face,faceX,faceY);
		
		// g.drawString(mouse, 50, 50);
		// g.drawRect(50, 100, 60, 120);
		//
		// Image img = new Image("res/bubble_right.png");
		// g.drawImage(img, 200, 130);
	}

	public void update(GameContainer gc, StateBasedGame sbg, int delta)
			throws SlickException {
		
		Input input = gc.getInput();
		
	
		 int xPos = Mouse.getX();
		 int yPos = Mouse.getY();
		 
		 if((xPos>75 && xPos<175)&&(yPos>160 && yPos<260)){
			 if(input.isMouseButtonDown(0)){
				 sbg.enterState(1);
			 }
		 }
//		 mouse = "Mouse postion x: " + xPos + " Y: " + yPos;
		
//		Input input = gc.getInput();
//		if(input.isKeyDown(Input.KEY_UP)){
//			faceY -= 1;
//		}
//		if(input.isKeyDown(Input.KEY_DOWN)){
//			faceY += 1;
//		}
//		if(input.isKeyDown(Input.KEY_LEFT)){
//			faceX -= 1;
//		}
//		if(input.isKeyDown(Input.KEY_RIGHT)){
//			faceX += 1;
//		}
	}

	public int getID() {
		return 0;
	}
}
