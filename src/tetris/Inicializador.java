package tetris;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class Inicializador {

	public static void main(String[] args) {
		
		int anchoVentana = 800;
        int largoVentana = 600;
        
        System.setProperty("sun.java2d.opengl", "true");
        
        JFrame ventanaJuego = new JFrame("Mi Juego");

       
        ventanaJuego.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

       
        ventanaJuego.setLocationRelativeTo(null);

        
        ventanaJuego.setVisible(true);

        
        Panel panelJuego = new Panel(anchoVentana, largoVentana);

        ventanaJuego.add(panelJuego);

      
        ventanaJuego.pack();

	}

}
