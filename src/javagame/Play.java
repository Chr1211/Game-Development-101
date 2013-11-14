package javagame;

import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

import sun.awt.image.PixelConverter.Rgba;

public class Play extends BasicGameState {

	private Animation me, movingUp, movingDown, movingLeft, movingRight;
	private Image worldMap;
	boolean quit = false;
	int[] duration = { 200, 200 };
	float myPositionX = 0;
	float myPositionY = 0;
	float shiftX = myPositionX + 360;
	float shiftY = myPositionY + 160;

	public Play(int state) {

	}

	public void init(GameContainer gc, StateBasedGame sbg)
			throws SlickException {
		worldMap = new Image("res/world.png");
		Image[] walkUp = { new Image("res/buckysBack.png"),
				new Image("res/BuckysBack.png") };
		Image[] walkDown = { new Image("res/buckysFront.png"),
				new Image("res/BuckysFront.png") };
		Image[] walkLeft = { new Image("res/buckysLeft.png"),
				new Image("res/BuckysLeft.png") };
		Image[] walkRight = { new Image("res/buckysRight.png"),
				new Image("res/BuckysRight.png") };

		movingUp = new Animation(walkUp, duration, false);
		movingDown = new Animation(walkDown, duration, false);
		movingLeft = new Animation(walkLeft, duration, false);
		movingRight = new Animation(walkRight, duration, false);
		me = movingDown;
	}

	public void render(GameContainer gc, StateBasedGame sbg, Graphics g)
			throws SlickException {
		worldMap.draw(myPositionX, myPositionY);
		me.draw(shiftX, shiftY);
		g.drawString("My X:" + myPositionX + "\nMy Y: " + myPositionY, 400, 20);

		if (quit == true) {
			g.drawString("Resume (R)", 250, 100);
			g.drawString("Main Menu (M)", 250, 150);
			g.drawString("Quit (Q)", 250, 200);
			if (quit == false) {
				g.clear();
			}
		}

	}

	public void update(GameContainer gc, StateBasedGame sbg, int delta)
			throws SlickException {
		Input input = gc.getInput();

		if (input.isKeyDown(Input.KEY_W)) {
			me = movingUp;
			myPositionY += delta * .1f;
			if (myPositionY > 162) {
				myPositionY -= delta * .1f;
			}
		}
		if (input.isKeyDown(Input.KEY_S)) {
			me = movingDown;
			myPositionY -= delta * .1f;
			if (myPositionY < -600) {
				myPositionY += delta * .1f;
			}
		}
		if (input.isKeyDown(Input.KEY_A)) {
			me = movingLeft;
			myPositionX += delta * .1f;
			if (myPositionX > 364) {
				myPositionX -= delta * .1f;
			}
		}
		if (input.isKeyDown(Input.KEY_D)) {
			me = movingRight;
			myPositionX -= delta * .1f;
			if (myPositionX < -800) {
				myPositionX += delta * .1f;
			}
		}

		// escape
		if (input.isKeyDown(Input.KEY_ESCAPE)) {
			quit = true;
		}
		// When menu is UP
		if (quit == true) {
			if (input.isKeyDown(Input.KEY_R)) {
				quit = false;
			}
			if (input.isKeyDown(Input.KEY_M)) {
				sbg.enterState(0);
			}
			if (input.isKeyDown(Input.KEY_Q)) {
				System.exit(0);
			}
		}
	}

	public int getID() {
		return 1;
	}
}
