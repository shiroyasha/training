package examples.example7;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;

import engine.Entity;
import engine.Game;
import engine.GameLoop;

class Rectangle extends Entity {

	public Rectangle() {
		setPosition(30, 330);
		setSize(30, 30);
		
		setVelocity(0, -100);
		setAcceleration(0, 5000); //some big ( appropriate ) constant for gravitation simulation
	}
	
	@Override
	public void update(int deltaTime) {
		recalculatePosition(deltaTime);

		if( getY() > 200 - getHeight() ) {
			setY( 200 - getHeight() );
		}
	}

	@Override
	public void repaint(Graphics2D g) {
		g.setColor( new Color(200, 150, 100));
		g.drawRect( (int)getX() , (int)getY(), (int)getWidth(), (int)getHeight()); 
		
		g.setColor( new Color(50, 50, 50));
		g.drawLine(10, 200, 100, 200);
		g.setFont( new Font("monospace", 0, 20));
		g.drawString("Press space to jump ^_^", Game.getDefaultGame().getWidth()/2 - 170, 200 );
	}
	
}

class EntityGame extends Game {
	
	Rectangle r = new Rectangle();
	
	public EntityGame() {
		super("Gravitation = acceleration towards the floor", 640, 480);
	}

	@Override
	public void update(int deltaTime) {
		r.update(deltaTime);
	}

	@Override
	public void repaint(Graphics2D g) {
		r.repaint(g);
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		if( e.getKeyCode() == KeyEvent.VK_SPACE ) {
			r.setVelocity(0, -1000);
		}
	}
	
}

public class Gravitation {

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
