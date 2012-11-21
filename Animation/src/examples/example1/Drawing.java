package examples.example1;
import java.awt.Color;
import java.awt.Graphics2D;

import engine.Game;
import engine.GameLoop;

class MyGame extends Game {
	
	int x = 50;
	int y = 50;
	
	public MyGame() {
		super("Drawing game", 640, 480);
	}

	@Override
	public void update(int deltaTime) {
		//no animation, so no update needed
	}

	@Override
	public void repaint(Graphics2D g) {
		
		g.setColor( new Color(200, 150, 100));
		g.drawRect(x, y, 30, 30);
		
	}
	
}

public class Drawing {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Game g = new MyGame();
		g.setShowFPS(true);
		
		GameLoop loop = new GameLoop(g);		
		loop.start();
	}

}
