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
    private Figura figura;
    private ConversoDeImagen conversoDeImagenes;
    private CreadorDeFiguras creadorDeFiguras;
    private Clip music;
    private Image pantallaBienvenida = ImageLoader.loadImage("/tetrisInicio.png");
    private Image fondoJuego = ImageLoader.loadImage("/Fondo_juego.png");
    private boolean gamePaused = false;
    //private int mouseX, mouseY;
	//private boolean leftClick = false;
	//private Rectangle stopBounds, refreshBounds;
	//private BufferedImage  pause, refresh;
	

	public Panel(int anchoJuego, int largoJuego) {
		this.pantalla = WELCOME_SCREEN;
		this.anchoJuego = anchoJuego;
		this.largoJuego = largoJuego;
		conversoDeImagenes = new ConversoDeImagen("src/main/resources/imagenes/");
<<<<<<< HEAD

		//figura = new FiguraL (2, 2, "NARANJA", conversoDeImagenes);
		figura = new FiguraT (2, 2, "VIOLETA", conversoDeImagenes);
		/*for (int i = 1; i < 4; i++) {
			
		}*/
        music = ImageLoader.LoadSound("/Tetris_theme.wav");

		creadorDeFiguras = new CreadorDeFiguras(conversoDeImagenes);
=======
        creadorDeFiguras = new CreadorDeFiguras(conversoDeImagenes);
>>>>>>> ea424785ba9a681f071c38b02bb872d9b033239f
		figura = creadorDeFiguras.crearUnaFigura();
        music = ImageLoader.LoadSound("/Tetris_theme.wav");
<<<<<<< HEAD

=======
>>>>>>> ea424785ba9a681f071c38b02bb872d9b033239f
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
<<<<<<< HEAD

		String mensaje = "PRESIONA LA BARRA ESPACIADORA PARA INICIAR";
		g2d.drawString(mensaje, anchoJuego - 530, 65);

		
=======
		String mensaje = "PRESIONA LA BARRA ESPACIADORA PARA INICIAR";
		g2d.drawString(mensaje, anchoJuego - 530, 65);
>>>>>>> ea424785ba9a681f071c38b02bb872d9b033239f
	}
	
		
	
	private boolean verificarSiFiguraLlegoAbajo() {
		if (figura.getPosicionY() * 25 >= (largoJuego - 50)) {
			figura.setVelocidadY(0);
			figura.setVelocidadX(0);
			return true;
		}
		return false;
	}
	
	
	private boolean verificarSiFiguraTocaParedIzquierda() {
		if (figura.getPosicionX() <= 0 ) {
			figura.frenar();
			return true;
		}
		return false;
<<<<<<< HEAD

=======
>>>>>>> ea424785ba9a681f071c38b02bb872d9b033239f
	}
	
	private boolean verificarSiFiguraTocaParedDerecha() {
		if (figura.getPosicionX() >= 10) {
			figura.frenar();
			return true;
		}
		return false;
	}
	

	@Override 
	public void run() {
		while (true) {
            actualizarAmbiente();
            repintar();
            //esperar(1000);
            esperar(50);

            //moverFigura();
		}
	}
	
	private void esperar(int milisegundos) {
        try {
            Thread.sleep(milisegundos);
        } catch (Exception e1) {
            throw new RuntimeException(e1);
        }
    }
	
	private void moverFigura() {
		if (pantalla == GAME_SCREEN && verificarSiFiguraLlegoAbajo() == false ) {
        	figura.moverseAbajo();
        } else if (verificarSiFiguraLlegoAbajo()== true) {
        	figura = creadorDeFiguras.crearUnaFigura();
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
			dibujarPantalla(graphics2d, fondoJuego);
			//super.paintComponent(g);
			figura.dibujarse(g);
		}
		if(gamePaused)
		{
			String gamePausedString = "GAME PAUSED";
			g.setColor(Color.WHITE);
			g.setFont(new Font("Georgia", Font.BOLD, 30));
			g.drawString(gamePausedString, 35, largoJuego/2);
		}
	}
	
	private void actualizarAmbiente() {
		posicionX=posicionX+velocidadX;
        posicionY=posicionY+velocidadY;
        moverFigura();
       
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
        	if (verificarSiFiguraLlegoAbajo() == false && verificarSiFiguraTocaParedDerecha() == false) {
        		figura.moverseDerecha();
        	}
            
        }
        if (arg0.getKeyCode() == KeyEvent.VK_LEFT) {
        	if (verificarSiFiguraLlegoAbajo() == false && verificarSiFiguraTocaParedIzquierda() == false) {
        		figura.moverseIzquierda();
        	}
        }
        
        if (arg0.getKeyCode() == KeyEvent.VK_DOWN) {
        	//compruebo que una vez que llegó abajo no pueda seguir bajando con la tecla
        	if (verificarSiFiguraLlegoAbajo() == false) {
        		figura.moverseAbajo();
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
