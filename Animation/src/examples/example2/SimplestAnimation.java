package examples.example2;
import java.awt.Color;
import java.awt.Graphics2D;

import engine.Game;
import engine.GameLoop;

class SimplestAnimationGame extends Game {
	
	int x = 50;
	int y = 50;
	
	public SimplestAnimationGame() {
		super("Simplest animation game", 640, 480);
	}

	@Override
	public void update(int deltaTime) {
		
		x += 5;
		x = x % ( getWidth() - 30 );
	}

	@Override
	public void repaint(Graphics2D g) {
		
		g.setColor( new Color(200, 150, 100));
		g.drawRect(x, y, 30, 30);
		
	}
	
}

public class SimplestAnimation {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Game g = new SimplestAnimationGame();
		g.setShowFPS(true);
		
		GameLoop loop = new GameLoop(g);		
		loop.start();
	}

}
