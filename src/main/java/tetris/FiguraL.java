package tetris;

import java.awt.Color;
import java.awt.Graphics;

public class FiguraL extends Figura {

	public FiguraL(int posicionX, int posicionY, int velocidadX, int velocidadY, Color color) {
		super(posicionX, posicionY, velocidadX, velocidadY, color);
	}

	@Override
	public void moverse() {
		
		
	}

	@Override
	public boolean hayColision(Figura figura) {
		
		return false;
	}

	@Override
	public void dibujarse(Graphics graphics) {
		dibujarElementoBasico(graphics, getPosicionX(), getPosicionY());
		dibujarElementoBasico(graphics, getPosicionX(), getPosicionY()- LARGO_ELEMENTO_BASICO);
		dibujarElementoBasico(graphics, getPosicionX()+ ANCHO_ELEMENTO_BASICO, getPosicionY() - LARGO_ELEMENTO_BASICO);
		dibujarElementoBasico(graphics, getPosicionX()+ (ANCHO_ELEMENTO_BASICO * 2), getPosicionY() - LARGO_ELEMENTO_BASICO);
	}
}
