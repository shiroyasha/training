package engine;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class GameLoop extends JPanel implements Runnable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	final int DELAY;
	int x, y;

	private Thread animator;

	private Game game;
	
	private JFrame frame = new JFrame();
	
	public GameLoop() {
		this(null, 20);
	}
	
	public GameLoop( Game game ) {
		super();	
		this.game = game;
		this.DELAY = 20;
	}
	
	public GameLoop( Game game, int delay ) {
		super();	
		this.game = game;
		this.DELAY = delay;
	}
	
	public void start() {
		
		frame.addKeyListener( new TAdapter() );
		
        frame.add( this );
        frame.setTitle( game.getTitle() );
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setPreferredSize( new Dimension(game.getWidth() , game.getHeight()));
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setResizable(false);
	}
	
    public void addNotify() {
        super.addNotify();
        animator = new Thread(this);
        animator.start();
    }
    
    
    private class TAdapter extends KeyAdapter {

        public void keyReleased(KeyEvent e) {
            game.keyReleased(e);
        }

        public void keyPressed(KeyEvent e) {
            game.keyPressed(e);
        }
    }
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		
		final Graphics2D g2d = (Graphics2D)g.create();
		
		game.repaint(g2d);
		
		g2d.dispose();
		
		if( game.isShowFPS() ) {
			g.setColor( new Color(0, 0, 0));
			g.drawString("FPS: " + game.getFPS(),(int)( game.getWidth() - 80), 10);
		}
		
		Toolkit.getDefaultToolkit().sync();
		g.dispose();
	}

	@Override
	public void run() {
		
        long beforeTime, timeDiff, sleep;
        
        long frames = 0, 
             timePassed = 0; // for FPS counting

        beforeTime = System.currentTimeMillis();

        while (true) {
        	
        	timeDiff = System.currentTimeMillis() - beforeTime;
        	beforeTime = System.currentTimeMillis();
        	
            game.update((int)timeDiff);
            repaint();
            
            frames++;
        	timePassed += timeDiff;
        	if( timePassed > 1000) {
        		game.setFps( (int)((frames*1000) / timePassed) );
        		timePassed = 0;
        		frames = 0;
        	}

            
            sleep = DELAY - timeDiff;

            if (sleep < 0)
                sleep = 2;
            try {
                Thread.sleep(sleep);
            } catch (InterruptedException e) {
                System.out.println("interrupted");
            }
        }
		
	}
}
