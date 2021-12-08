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
 
 public class Panel extends JPanel implements Runnable, KeyListener {
    
     private static final long serialVersionUID = 1L;
 	 private int pantalla;
 	 private final static int WELCOME_SCREEN = 1;
 	 private final static int GAME_SCREEN = 2;
 	 private int anchoJuego;
 	 private int largoJuego;
     private Tablero tablero;
     private Clip music;
     private Image pantallaBienvenida = ImageLoader.loadImage("/tetrisInicio.png");
     private Image fondoJuego = ImageLoader.loadImage("/Fondo_juego.png");
     private boolean gamePaused = false;
     private int contadorTiempoCaida = 0;



 	public Panel(int anchoJuego, int largoJuego) {
 		this.pantalla = WELCOME_SCREEN;
 		this.anchoJuego = anchoJuego;
 		this.largoJuego = largoJuego;
 		tablero = new Tablero(new ConversoDeImagen("src/main/resources/imagenes/"));
         music = ImageLoader.LoadSound("/Tetris_theme.wav");
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
 		String mensaje = "PRESIONA LA BARRA ESPACIADORA PARA INICIAR";
 		g2d.drawString(mensaje, anchoJuego - 530, 65);
 	}


 	@Override 
 	public void run() {
 		while (true) {
             actualizarAmbiente();
             repintar();
             esperar(25);
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
 			dibujarPantalla(graphics2d, fondoJuego);
 			//super.paintComponent(g);
 			tablero.dibujarse(g);
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
 		if (pantalla == GAME_SCREEN) {
 			//40 Veces 25 milisegundos es un segundo. Entonces cada 1 segundo cae la figura.
 			if(contadorTiempoCaida == 40) {
 				contadorTiempoCaida = 0;
 				tablero.actualizar();
 			}
 			contadorTiempoCaida++;
 		}
     }
 
 	@Override
 	public void keyTyped(KeyEvent e) {
 	}
 	
 	@Override
 	public void keyPressed(KeyEvent arg0) {
 		if (pantalla == GAME_SCREEN) {
 			if (arg0.getKeyCode() == KeyEvent.VK_RIGHT) {
 	        	tablero.moverFiguraActualDerecha();
 	        }
 	        
 	        if (arg0.getKeyCode() == KeyEvent.VK_LEFT) {
 	        	tablero.moverFiguraActualIzquierda();
 	        }
 	        
 	        if (arg0.getKeyCode() == KeyEvent.VK_DOWN) {
 	        	tablero.moverFiguraAbajo();
 	        }
 	        
 	        if (arg0.getKeyCode() == KeyEvent.VK_UP) {
 	        	tablero.rotarFiguraActual();
 	        }
 		}
         
         
         if (arg0.getKeyCode() == KeyEvent.VK_SPACE && pantalla == WELCOME_SCREEN ) {
         	actualizarAmbiente();
         	pantalla = GAME_SCREEN;
         }
     }
 	@Override
 	public void keyReleased(KeyEvent e) {
 		
 	}




 }