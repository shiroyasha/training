package engine;

import java.awt.Graphics2D;

public abstract class Entity {

	private double x;
	private double y;
	
	private double width;
	private double height;
	
	private double velocity_x;
	private double velocity_y;
	
	private double acceleration_x;
	private double acceleration_y;
	
	public Entity() {
		super();
	}
	
	public abstract void update( int deltaTime );
	public abstract void repaint( Graphics2D g );
	
	public void recalculatePosition( int deltaTime) {
		double dt = ((double)deltaTime) / 1000.0;
		
		velocity_x = velocity_x + acceleration_x*dt;
		velocity_y = velocity_y + acceleration_y*dt;
		
		x = x + velocity_x * dt;
		y = y + velocity_y * dt;
	}

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}
	
	public void setPosition(double x, double y) {
		setX(x);
		setY(y);
	}
	

	public double getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}
	
	public void setSize( int width, int height) {
		setWidth(width);
		setHeight(height);
	}

	public double getVelocity_x() {
		return velocity_x;
	}

	public void setVelocity_x(double velocity_x) {
		this.velocity_x = velocity_x;
	}

	public double getVelocity_y() {
		return velocity_y;
	}

	public void setVelocity_y(double velocity_y) {
		this.velocity_y = velocity_y;
	}
	
	public void setVelocity( double x, double y) {
		setVelocity_x(x);
		setVelocity_y(y);
	}

	public double getAcceleration_x() {
		return acceleration_x;
	}

	public void setAcceleration_x(double acceleration_x) {
		this.acceleration_x = acceleration_x;
	}

	public double getAcceleration_y() {
		return acceleration_y;
	}

	public void setAcceleration_y(double acceleration_y) {
		this.acceleration_y = acceleration_y;
	}
	
	public void setAcceleration( double x, double y) {
		setAcceleration_x(x);
		setAcceleration_y(y);
	}
}
