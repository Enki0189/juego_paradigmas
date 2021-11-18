 package tetris;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JPanel;
import javax.swing.event.MouseInputListener;


public class Panel extends JPanel implements Runnable, MouseMotionListener{

	private static final long serialVersionUID = 1L;
	private int anchoJuego;
	private int largoJuego;
	private int posicionX;
	private int posicionY;

	public Panel(int anchoJuego, int largoJuego) {
		this.anchoJuego = anchoJuego;
		this.largoJuego = largoJuego;
		
	}

	@Override
	public void run() {
		while (true) {
            actualizarAmbiente();
            repintar();
            esperar(10);
        }
		
	}
	
	private void esperar(int milisegundos) {
        try {
            Thread.sleep(milisegundos);
        } catch (Exception e1) {
            throw new RuntimeException(e1);
        }
    }
	
	
	@Override
	public Dimension getPreferredSize() {
		return new Dimension (anchoJuego,largoJuego);
	}
	
	private void repintar() {
        this.repaint();
    }
	
	@Override
	protected void paintComponent (Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.BLUE);
		g.fillRect(70,70,70,70);
		g.setColor(Color.RED);
		g.fillRect(70,20,70,20);
		
	
	}
	
	private void actualizarAmbiente() {
        posicionX++;
        posicionY++;
    }



	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		this.posicionX = e.getX();
		this.posicionY = e.getY();
		
	}
	
	

}
