package tetris;

import java.awt.Color;

public interface FiguraMetodos extends Dibujable {
	
	public int getPosicionX();

    public int getPosicionY();

    public int getAncho();

    public int getLargo();

    public int getVelocidadX();

    public int getVelocidadY();

    public Color getColor();

    public void moverse();

    public boolean hayColision(Figura figura);
    

}
