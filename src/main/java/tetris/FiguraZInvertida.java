package tetris;

public class FiguraZInvertida extends Figura{
	
	public FiguraZInvertida(int posicionX, int posicionY, String color, ConversoDeImagen conversoDeImagen) {
		super(posicionX, posicionY, color, conversoDeImagen);
		matrizFigura = new int [][] {{0, 7, 0},
		                			 {0, 7, 7},
		                			 {0, 0, 7}};
	}

}
