package tetris;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

public class Puntaje {
	public static int lineasAcumuladas = Tablero.lineasAcumuladas;
	public static int lineasBorradasPorTurno;
	public int puntaje;
	
	
	public Puntaje(int puntaje, int lineasAcumuladas) {
		Puntaje.lineasAcumuladas = lineasAcumuladas;
		this.puntaje = puntaje;
		Puntaje.lineasBorradasPorTurno = Tablero.lineasBorradas;
		
	}
	
	public static void infoEnPantalla(Graphics2D g2d) {
		//cuadrado para tiempo
		g2d.setColor(new Color(0, 0, 0));
 		g2d.fillRect(575, 203, 110, 35);
 		g2d.setColor(new Color(222, 27, 82));
 		g2d.drawRect(575, 203, 110, 35);
 		g2d.setFont(new Font("Rubik", Font.PLAIN, 30));
 		String tiempo = ""; 
 		if (Panel.minutesDisplay < 10 && Panel.secondsDisplay < 10) {
 			tiempo = "0" + Panel.minutesDisplay + ":0" + Panel.secondsDisplay;
 		} else if (Panel.minutesDisplay < 10 && Panel.secondsDisplay >= 10 ) {
 			tiempo = "0" + Panel.minutesDisplay + ":" + Panel.secondsDisplay;
 		} else if (Panel.minutesDisplay >= 10 && Panel.secondsDisplay < 10 ) {
 			tiempo = "" + Panel.minutesDisplay + ":0" + Panel.secondsDisplay;
 		} else {
 			tiempo = "" + Panel.minutesDisplay + ":" + Panel.secondsDisplay;
 		}
 		g2d.drawString(tiempo, 590, 230);
		
		//cuadrado para nivel
 		g2d.setColor(new Color(0, 0, 0));
 		g2d.fillRect(575, 264, 110, 35);
 		g2d.setColor(new Color(222, 27, 82));
 		g2d.drawRect(575, 264, 110, 35);
 		g2d.setFont(new Font("Rubik", Font.PLAIN, 30));
 		String nivel = "" + Tablero.level;
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
 		
 		//cuadrado para instrucciones
 		g2d.setColor(new Color(0, 0, 0));
 		g2d.fillRect(520, 60, 225, 75);
 		g2d.setColor(new Color(222, 27, 82));
 		g2d.drawRect(520, 60, 225, 75);
 		g2d.setFont(new Font("Rubik", Font.PLAIN, 17));
 		String mensaje =  "Presiona P para pausar";
 		String mensaje2 = "y Enter para seguir jugando";
 		g2d.drawString(mensaje, 530, 88);
 		g2d.drawString(mensaje2, 530, 110);
 	}
	
	

}
