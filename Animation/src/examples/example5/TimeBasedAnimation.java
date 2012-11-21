package examples.example5;

import java.awt.Color;
import java.awt.Graphics2D;

import engine.Entity;
import engine.Game;
import engine.GameLoop;

class Rectangle extends Entity {

	public Rectangle(int x, int y, int v) {
		setPosition(x, y);
		setSize(30, 30);
		
		setVelocity(v, 0);
	}
	
	@Override
	public void update(int deltaTime) {
		recalculatePosition(deltaTime);
		
		// if we hit the right wall
		if( getX() > Game.getDefaultGame().getWidth() - getWidth()) {
			setVelocity( - getVelocity_x(), 0);
			setX( Game.getDefaultGame().getWidth() - getWidth() );
		}
		if( getX() < 0 ) {
			setVelocity( - getVelocity_x(), 0);
			setX( 0 );			
		}
	}

	@Override
	public void repaint(Graphics2D g) {
		g.setColor( new Color(200, 150, 100));
		g.drawRect( (int)getX() , (int)getY(), (int)getWidth(), (int)getHeight()); 
	}
	
}

class EntityGame extends Game {
	
	Rectangle[] rectangles = new Rectangle[10];
	
	public EntityGame() {
		super("Time based animation", 640, 480);
		
		for( int i = 0; i < rectangles.length; i++)
			rectangles[i] = new Rectangle(0, i * 50, (i + 1) * 50);
	}

	@Override
	public void update(int deltaTime) {
		for( Rectangle r : rectangles )
			r.update(deltaTime);
	}

	@Override
	public void repaint(Graphics2D g) {
		for( Rectangle r : rectangles )
			r.repaint(g);
	}
	
}

public class TimeBasedAnimation {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Game g = new EntityGame();
		g.setShowFPS(true);
		
		GameLoop loop = new GameLoop(g);		
		loop.start();

	}

}
