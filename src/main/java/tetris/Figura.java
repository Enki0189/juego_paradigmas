package tetris;

import java.awt.Color;
import java.awt.Graphics;

public abstract class Figura implements FiguraMetodos {

	private int posicionX;
	private int posicionY;
	private int velocidadX;
	private int velocidadY;
	private int ancho;
	private int largo;
	private Color color;
	protected static final int ANCHO_ELEMENTO_BASICO = 25;
	protected static final int LARGO_ELEMENTO_BASICO = 25;

	public Figura(int posicionX, int posicionY, int velocidadX, int velocidadY, Color color) {
		this.posicionX = posicionX;
		this.posicionY = posicionY;
		this.velocidadX = velocidadX;
		this.velocidadY = velocidadY;
		this.color = color;
	}

	protected void dibujarElementoBasico(Graphics graphics, int posX, int posY) {
		graphics.setColor(getColor());
        graphics.fillRect(posX, posY, ANCHO_ELEMENTO_BASICO, LARGO_ELEMENTO_BASICO);
        graphics.setColor(Color.black);
        graphics.drawRect(posX, posY, ANCHO_ELEMENTO_BASICO, LARGO_ELEMENTO_BASICO);
	}
	
	public int getPosicionX() {
		return posicionX;
	}

	public void setPosicionX(int posicionX) {
		this.posicionX = posicionX;
	}

	public int getPosicionY() {
		return posicionY;
	}

	public void setPosicionY(int posicionY) {
		this.posicionY = posicionY;
	}

	public int getVelocidadX() {
		return velocidadX;
	}

	public void setVelocidadX(int velocidadX) {
		this.velocidadX = velocidadX;
	}

	public int getVelocidadY() {
		return velocidadY;
	}

	public void setVelocidadY(int velocidadY) {
		this.velocidadY = velocidadY;
	}

	public int getAncho() {
		return ancho;
	}

	public void setAncho(int ancho) {
		this.ancho = ancho;
	}

	public int getLargo() {
		return largo;
	}

	public void setLargo(int largo) {
		this.largo = largo;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}
	

}
