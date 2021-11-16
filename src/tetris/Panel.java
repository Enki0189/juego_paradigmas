package tetris;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JPanel;


public class Panel extends JPanel implements Runnable {

	private static final long serialVersionUID = 1L;
	private int anchoJuego;
	private int largoJuego;

	public Panel(int anchoJuego, int largoJuego) {
		this.anchoJuego = anchoJuego;
		this.largoJuego = largoJuego;
	}

	@Override
	public void run() {
		
		
	}
	
	@Override
	public Dimension getPreferredSize() {
		return new Dimension (anchoJuego,largoJuego);
	}
	
	@Override
	protected void paintComponent (Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.BLUE);
		g.fillRect(70,70,70,70);
		g.setColor(Color.RED);
		g.fillRect(70,20,70,20);
		
	
	}

}
