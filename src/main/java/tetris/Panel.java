 package tetris;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.JPanel;


public class Panel extends JPanel implements Runnable, MouseMotionListener, KeyListener {

	private static final long serialVersionUID = 1L;
	private int anchoJuego;
	private int largoJuego;
	private int posicionX;
	private int posicionY;
	private int velocidadX;
    private int velocidadY;
    Figura figura;
    private ConversoDeImagen conversoDeImagenes;

	public Panel(int anchoJuego, int largoJuego) {
		this.anchoJuego = anchoJuego;
		this.largoJuego = largoJuego;
		conversoDeImagenes = new ConversoDeImagen("src/main/resources/imagenes/");
		figura = new FiguraL (2, 2, "NARANJA", conversoDeImagenes);
	}

	@Override
	public void run() {
		while (true) {
            actualizarAmbiente();
            repintar();
            esperar(1000);
            figura.figuraRotar();
            figura.setPosicionY(figura.getPosicionY() + 1);
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
		figura.dibujarse(g);
	}
	
	private void actualizarAmbiente() {
		posicionX=posicionX+velocidadX;
        posicionY=posicionY+velocidadY;
    }



	@Override
	public void mouseDragged(MouseEvent e) {
		
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		this.posicionX = e.getX();
		this.posicionY = e.getY();
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
        if (arg0.getKeyCode() == 39) {
            velocidadX = 5;
        }
        if (arg0.getKeyCode() == 37) {
            velocidadX =-5;
        }
        
        if (arg0.getKeyCode() == 38) {
            velocidadY = -5;
        }
        
        if (arg0.getKeyCode() == 40) {
            velocidadY = 5;
        }
        
        if (arg0.getKeyCode() == KeyEvent.VK_UP) {
        	figura.figuraRotar();
        }
    }

	@Override
	public void keyReleased(KeyEvent e) {
		 velocidadX = 0;
	     velocidadY = 0;
		
	}
	
	

}
