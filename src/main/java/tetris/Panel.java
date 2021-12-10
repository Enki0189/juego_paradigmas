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
 	 public int pantalla;
 	 private final static int WELCOME_SCREEN = 1;
 	 private final static int GAME_SCREEN = 2;
 	 private int anchoJuego;
 	 private int largoJuego;
     private Tablero tablero;
     private Clip music;
     private Image pantallaBienvenida = ImageLoader.loadImage("/tetrisInicio.png");
     private Image fondoJuego = ImageLoader.loadImage("/Fondo_juego.png");
     private int contadorTiempoCaida = 0;
     public long startTime;
     long elapsedTime;
     static long elapsedSeconds;
     static long secondsDisplay;
     static long elapsedMinutes;
     static long minutesDisplay;

 public Panel(int anchoJuego, int largoJuego) {
     this.pantalla = WELCOME_SCREEN;
 	 this.anchoJuego = anchoJuego;
 	 this.largoJuego = largoJuego;
 	 tablero = new Tablero(new ConversoDeImagen("/imagenes/"));
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
 	 g2d.fillRect(150, largoJuego - 570, anchoJuego - 290, 50);
 	 g2d.setColor(Color.white);
 	 g2d.drawRect(150, largoJuego - 570, anchoJuego - 290, 50);
 	 String mensaje = "PRESIONA LA BARRA ESPACIADORA PARA INICIAR";
 	 g2d.setFont(new Font("Rubik", Font.PLAIN, 20));
 	 g2d.drawString(mensaje, anchoJuego - 640, 65);
 }
 	
 private void mensajeGameOver(Graphics2D g2d) {
     g2d.setColor(new Color(0, 0, 0));
 	 g2d.fillRect(200, 200, 400, 100);
 	 g2d.setColor(Color.white);
 	 g2d.drawRect(200, 200, 400, 100);
 	 g2d.setColor(Color.white);
 	 String mensaje = "GAME OVER";
 	 g2d.setFont(new Font("Rubik", Font.PLAIN, 50));
 	 g2d.drawString(mensaje, 260, 265);
 }

 private void mensajePause(Graphics2D g) {
     String gamePausedString = "GAME PAUSED";
	 g.setColor(Color.WHITE);
	 g.setFont(new Font("Georgia", Font.BOLD, 50));
	 g.drawString(gamePausedString, 150, 300);
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
 		 tablero.dibujarse(g);
 		 Puntaje.infoEnPantalla(graphics2d);
 		 if (tablero.gameOver == true) {
 		     mensajeGameOver(graphics2d);
 		 }
 		 if (tablero.gamePause == true) {
 		     mensajePause(graphics2d);
 		 }
 	}
 }

 private void actualizarAmbiente() {
     if (pantalla == GAME_SCREEN) {
 		//40 Veces 25 milisegundos es un segundo. Entonces cada 1 segundo cae la figura.
 	    if (Tablero.level == 1) {
	 	    if(contadorTiempoCaida == 40) {
	 		    contadorTiempoCaida = 0;
	 			if (tablero.gameOver == false) {
	 		        tablero.actualizar();
	 	        }
	        }
	 		contadorTiempoCaida++;
 		} else if (Tablero.level == 2) {
 		    if(contadorTiempoCaida == 20) {
 	 		    contadorTiempoCaida = 0;
 	 			if (tablero.gameOver == false) {
 	 		        tablero.actualizar();
 	 			}
 	 	    }
 	 			contadorTiempoCaida++;
 		} else if (Tablero.level == 3) {
 		    if(contadorTiempoCaida == 10) {
 	 		    contadorTiempoCaida = 0;
 	 			if (tablero.gameOver == false) {
 	 			    tablero.actualizar();
 	 			}
 	        }
 	 		contadorTiempoCaida++;
 	   } else if (Tablero.level == 4) {
 	       if(contadorTiempoCaida == 5) {
 	 	       contadorTiempoCaida = 0;
 	 		   if (tablero.gameOver == false) {
 	 		       tablero.actualizar();
 	 		   }
 	 	  }
 	 			contadorTiempoCaida++;
 	  }
 }

        if (pantalla == GAME_SCREEN && tablero.gameOver == false) {
 			contarTiempo();
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
         if (arg0.getKeyCode() == KeyEvent.VK_SPACE && pantalla == WELCOME_SCREEN  ) {
         	actualizarAmbiente();
         	pantalla = GAME_SCREEN;
     		iniciarTiempo();
         }
         if (arg0.getKeyCode() == KeyEvent.VK_P && pantalla == GAME_SCREEN ) {
          	tablero.gamePause = true;
         }
         if (arg0.getKeyCode() == KeyEvent.VK_ENTER && pantalla == GAME_SCREEN ) {
           	tablero.gamePause = false;
         }
         if (arg0.getKeyCode() == KeyEvent.VK_R && tablero.gameOver == true) {
        	actualizarAmbiente();
        	repintar();
        	pantalla = WELCOME_SCREEN; 
           	tablero = new Tablero(new ConversoDeImagen("/imagenes/"));
           	tablero.gameOver = false;
           	
         }
         
  }
 	
 @Override
 public void keyReleased(KeyEvent e) {
 }

 	
public void iniciarTiempo() {
    startTime = System.currentTimeMillis();
}
	
public void contarTiempo() {
    elapsedTime = System.currentTimeMillis() - startTime;
	elapsedSeconds = elapsedTime / 1000;
	secondsDisplay = elapsedSeconds % 60;
	elapsedMinutes = elapsedSeconds / 60;
	minutesDisplay = elapsedMinutes % 60;
}

}