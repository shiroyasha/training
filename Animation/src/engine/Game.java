package engine;

import java.awt.Graphics2D;
import java.awt.event.KeyEvent;

public abstract class Game {

	private int fps;
	private boolean showFPS;
	
	private String title;
	private int width;
	private int height;
	
	private static Game defaultGame;
	
	public Game( String title, int width, int height ) {
		this.fps = 0;
		this.title = title;
		
		this.width = width;
		this.height = height;
		
		defaultGame = this;
	}

	public abstract void update( int deltaTime );
	public abstract void repaint( Graphics2D g);
	
	public void keyPressed(KeyEvent e) {}
	
	public void keyReleased(KeyEvent e) {}
	
	
	
	public static Game getDefaultGame() {
		return defaultGame;
	}
	
	
	public boolean isShowFPS() {
		return showFPS;
	}

	public void setShowFPS(boolean showFPS) {
		this.showFPS = showFPS;
	}

	public int getFPS() {
		return fps;
	}
	
	public String getTitle() {
		return title;
	}

	void setFps(int fps) {
		this.fps = fps;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}
}
