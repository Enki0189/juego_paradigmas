package tetris;

import java.awt.Color;
import java.awt.Graphics;

public class FiguraI extends Figura {

	public FiguraI(int posicionX, int posicionY, int velocidadX, int velocidadY, Color color) {
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
		dibujarElementoBasico(graphics, getPosicionX()+ ANCHO_ELEMENTO_BASICO, getPosicionY());
		dibujarElementoBasico(graphics, getPosicionX()+ (ANCHO_ELEMENTO_BASICO * 2), getPosicionY());
		dibujarElementoBasico(graphics, getPosicionX()+ (ANCHO_ELEMENTO_BASICO * 3), getPosicionY());
        
		
	}

}
