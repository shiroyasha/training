package examples.example3;

import java.awt.Color;
import java.awt.Graphics2D;

import engine.Entity;
import engine.Game;
import engine.GameLoop;

class Rectangle extends Entity {

	public Rectangle() {
		setPosition(30, 30);
		setSize(30, 30);
	}
	
	@Override
	public void update(int deltaTime) {
		double x = (getX() + 5) % ( Game.getDefaultGame().getWidth() - getWidth() );
		setX( x );
	}

	@Override
	public void repaint(Graphics2D g) {
		g.setColor( new Color(200, 150, 100));
		g.drawRect( (int)getX() , (int)getY(), (int)getWidth(), (int)getHeight()); 
	}
	
}

class EntityGame extends Game {
	
	Rectangle r = new Rectangle();
	
	public EntityGame() {
		super("Using Entities", 640, 480);
	}

	@Override
	public void update(int deltaTime) {
		r.update(deltaTime);
	}

	@Override
	public void repaint(Graphics2D g) {
		r.repaint(g);
	}
	
}

public class UsingEntities {

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
