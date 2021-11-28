package tetris;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class Inicializador {

	public static void main(String[] args) {
				
		int anchoVentana = 800;
        int largoVentana = 600;
        
        System.setProperty("sun.java2d.opengl", "true");
        
        JFrame ventanaJuego = new JFrame("Tetris");

       
        ventanaJuego.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

       
        ventanaJuego.setLocationRelativeTo(null);

        
        ventanaJuego.setVisible(true);

        
        Panel panel= new Panel (anchoVentana, largoVentana);

        ventanaJuego.add(panel);

      
        ventanaJuego.pack();
        
        ventanaJuego.addMouseMotionListener(panel);
        
        panel.run();
        
        Thread hilo = new Thread(panel);
        
        hilo.start(); // ejecuta run en forma de hilo
        
        
        
	}

}
