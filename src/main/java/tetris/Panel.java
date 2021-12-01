 package tetris;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import javax.sound.sampled.Clip;
import javax.swing.JPanel;



public class Panel extends JPanel implements Runnable, MouseMotionListener, KeyListener {

	private static final long serialVersionUID = 1L;
	private int pantalla;
	private final static int WELCOME_SCREEN = 1;
	private final static int GAME_SCREEN = 2;
	private int anchoJuego;
	private int largoJuego;
	private int posicionX;
	private int posicionY;
	private int velocidadX;
    private int velocidadY;
    Figura figura;
    private ConversoDeImagen conversoDeImagenes;
    private CreadorDeFiguras creadorDeFiguras;
    

    private Clip music;
    private Image pantallaBienvenida = ImageLoader.loadImage("/tetrisInicio.png");
    
    //private boolean figLlegoAbajo = false;
    


	public Panel(int anchoJuego, int largoJuego) {
		this.pantalla = WELCOME_SCREEN;
		this.anchoJuego = anchoJuego;
		this.largoJuego = largoJuego;
		conversoDeImagenes = new ConversoDeImagen("src/main/resources/imagenes/");
		creadorDeFiguras = new CreadorDeFiguras(conversoDeImagenes);
		figura = creadorDeFiguras.crearUnaFigura();
		//verificarSiFiguraLlegoAbajo();
		
        music = ImageLoader.LoadSound("/Tetris_theme.wav");
	
		music.loop(Clip.LOOP_CONTINUOUSLY);
	}
	
	private void dibujarPantalla(Graphics g, Image screen) {
		try {
			g.drawImage(screen, 0, 0, anchoJuego, largoJuego, null);
		} catch (Exception e1) {
			throw new RuntimeException(e1);
		}

	}	
	
	private void mostrarMensaje(Graphics2D g2d) {
		g2d.setColor(new Color(0, 0, 0));
		g2d.fillRect(60, largoJuego - 565, anchoJuego - 130, 50);
		g2d.setColor(Color.white);
		g2d.drawRect(60, largoJuego - 565, anchoJuego - 130, 50);
		String mensaje = "Presiona la Barra espaciadora para Iniciar";
		g2d.drawString(mensaje, anchoJuego - 430, 45);
		
	}
	
	
	
	private boolean verificarSiFiguraLlegoAbajo() {
		if((figura.getPosicionY()*25) >= largoJuego-100) {
			System.out.println("Fig llegó abajo: " + true);
			return true;
			//figLlegoAbajo = true;
		}
		System.out.println("Fig llegó abajo: " + false);
		//figLlegoAbajo = false;
		return false;
	}
	

	@Override
	public void run() {
		while (true) {
            actualizarAmbiente();
            repintar();
            esperar(1000);
            if (pantalla == GAME_SCREEN && verificarSiFiguraLlegoAbajo()== false ) {
            	figura.moverseHaciaAbajo();
            }
            /*else if (verificarSiFiguraLlegoAbajo()== true) {
            	figura = creadorDeFiguras.crearUnaFigura();
            }*/
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
		Graphics2D graphics2d = (Graphics2D) g;
		setBackground(Color.black);
		if (pantalla == WELCOME_SCREEN) {
			dibujarPantalla(graphics2d, pantallaBienvenida);
			mostrarMensaje(graphics2d);
		}
		if (pantalla == GAME_SCREEN) {
			super.paintComponent(g);
			figura.dibujarse(g);
		}
	}
	
	private void actualizarAmbiente() {
		posicionX=posicionX+velocidadX;
        posicionY=posicionY+velocidadY;
        verificarSiFiguraLlegoAbajo();
        //figura.moverseHaciaAbajo();
        /*do  {
        	figura.moverseHaciaAbajo();
        } while (verificarSiFiguraLlegoAbajo() == false);*/
        /*if (verificarSiFiguraLlegoAbajo() == true) {
        	crearUnaFigura();
        }*/
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
        if (arg0.getKeyCode() == KeyEvent.VK_RIGHT) {
           figura.posicionX++;
        }
        if (arg0.getKeyCode() == KeyEvent.VK_LEFT) {
        	figura.posicionX--;
        }
        
        if (arg0.getKeyCode() == KeyEvent.VK_DOWN) {
        	//figura.velocidadY++;
        	//compruebo que una vez que llegó abajo no pueda seguir bajando con la tecla
        	if (verificarSiFiguraLlegoAbajo() == false) {
        		figura.setPosicionY(figura.getPosicionY() + 2);
        	}
        }
        
        if (arg0.getKeyCode() == KeyEvent.VK_UP) {
        	//si la pieza llegó abajo, no puede seguir rotando
        	if (verificarSiFiguraLlegoAbajo() == false) {
        		figura.figuraRotar();
        	}
        }
        if (arg0.getKeyCode() == KeyEvent.VK_SPACE && pantalla == WELCOME_SCREEN ) {
        	actualizarAmbiente();
        	pantalla = GAME_SCREEN;
        }
    }

	@Override
	public void keyReleased(KeyEvent e) {
		 velocidadX = 0;
	     velocidadY = 0;
		
	}
	
	

}
