package examples.example6;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

import engine.Entity;
import engine.Game;
import engine.GameLoop;

class Rectangle extends Entity {

	public Rectangle() {
		setPosition(30, 50);
		setSize(30, 30);
		
		setVelocity(10, 0);
		setAcceleration(30, 0);
	}
	
	@Override
	public void update(int deltaTime) {
		recalculatePosition(deltaTime);
		
		if( Math.abs( getVelocity_x() - 5 ) < 5 ) {
			setVelocity(0, 0);
			setAcceleration(0, 0);
		}
		
		if( getX() > (Game.getDefaultGame().getWidth() - getWidth()) ) {
			
			setAcceleration_x( - getAcceleration_x() );
			setVelocity_x( - getVelocity_x() );
			setX( Game.getDefaultGame().getWidth() - getWidth() );
		}
		
		if ( getX() < 0 ) {
			setAcceleration_x( - getAcceleration_x() );
			setVelocity_x( - getVelocity_x() );
			setX(0);
		}
	}

	@Override
	public void repaint(Graphics2D g) {
		g.setColor( new Color(200, 150, 100));
		g.drawRect( (int)getX() , (int)getY(), (int)getWidth(), (int)getHeight()); 
		
		g.setColor( new Color(50, 50, 50));
		g.setFont( new Font("monospace", 0, 20));
		g.drawString("Give it a little time to accelerate ^_^", Game.getDefaultGame().getWidth()/2 - 170, 200 );
	}
	
}

class EntityGame extends Game {
	
	Rectangle r = new Rectangle();
	
	public EntityGame() {
		super("Acceleration", 640, 480);
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

public class Acceleration {

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
