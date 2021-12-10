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
        
        ventanaJuego.setVisible(true);
        
        //agrego para que no se pueda cambiar el tamao de la ventana luego de setearlo
        ventanaJuego.setResizable(false);
        
        Panel panel= new Panel (anchoVentana, largoVentana);

        ventanaJuego.add(panel);
        
        ventanaJuego.pack();
        
        ventanaJuego.setLocationRelativeTo(null);
         
        ventanaJuego.addKeyListener(panel);      
        
        panel.run();
        
        Thread hilo = new Thread(panel);
        
        hilo.start(); // ejecuta run en forma de hilo
        
	}
	
	

}