package tetris;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

public class Puntaje {
	public int lineas;
	public int puntaje;
	
	public Puntaje(int lineas, int puntaje) {
		this.lineas = Tablero.lineasBorradas;
		this.puntaje = puntaje;
	}
	
	public static void infoEnPantalla(Graphics2D g2d) {
 		//cuadrado para lineas
 		g2d.setColor(new Color(0,0,0));
 		g2d.fillRect(575, 330, 110, 35);
 		g2d.setColor(new Color(222, 27, 82));
 		g2d.drawRect(575, 330, 110, 35);
 		g2d.setFont(new Font("Rubik", Font.PLAIN, 30));
 		String lineas = "" + Tablero.lineasBorradas;
 		g2d.drawString(lineas, 600, 358);
 		
 		//cuadrado para lineas
 		g2d.setColor(new Color(0, 0, 0));
 		g2d.fillRect(575, 390, 110, 35);
 		g2d.setColor(new Color(222, 27, 82));
 		g2d.drawRect(575, 390, 110, 35);
 		g2d.setFont(new Font("Rubik", Font.PLAIN, 30));
 		String puntaje = "" + Tablero.lineasBorradas*10;
 		g2d.drawString(puntaje, 600, 417);
 	}
	

}
