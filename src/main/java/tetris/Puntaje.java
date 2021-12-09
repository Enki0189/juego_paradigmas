package tetris;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

public class Puntaje {
	public static int lineasAcumuladas = Tablero.lineasAcumuladas;
	public static int lineasBorradasPorTurno;
	public int puntaje;
	public static int level = 1;
	
	public Puntaje(int puntaje, int lineasAcumuladas) {
		Puntaje.lineasAcumuladas = lineasAcumuladas;
		this.puntaje = puntaje;
		Puntaje.lineasBorradasPorTurno = Tablero.lineasBorradas;
		//nivel();
	}
	
	public static void infoEnPantalla(Graphics2D g2d) {
		//cuadrado para nivel
 		g2d.setColor(new Color(0, 0, 0));
 		g2d.fillRect(575, 264, 110, 35);
 		g2d.setColor(new Color(222, 27, 82));
 		g2d.drawRect(575, 264, 110, 35);
 		g2d.setFont(new Font("Rubik", Font.PLAIN, 30));
 		String nivel = "" + level;
 		g2d.drawString(nivel, 600, 290);
		
 		//cuadrado para lineas
 		g2d.setColor(new Color(0,0,0));
 		g2d.fillRect(575, 330, 110, 35);
 		g2d.setColor(new Color(222, 27, 82));
 		g2d.drawRect(575, 330, 110, 35);
 		g2d.setFont(new Font("Rubik", Font.PLAIN, 30));
 		String lineas = "" + Tablero.lineasAcumuladas;
 		g2d.drawString(lineas, 600, 358);
 		
 		//cuadrado para puntaje
 		g2d.setColor(new Color(0, 0, 0));
 		g2d.fillRect(575, 390, 110, 35);
 		g2d.setColor(new Color(222, 27, 82));
 		g2d.drawRect(575, 390, 110, 35);
 		g2d.setFont(new Font("Rubik", Font.PLAIN, 30));
 		String puntaje = "" + Tablero.puntaje;
 		g2d.drawString(puntaje, 600, 417);
 		
 	}
	
	/*public void nivel() {
		if(Tablero.puntaje > 200) {
			level++;
		} else if (Tablero.puntaje > 400) {
			level++;
		}
	}*/
	

}
