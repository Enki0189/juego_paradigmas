package tetris;

public class FiguraLInvertida extends Figura {
	
	public FiguraLInvertida(int posicionX, int posicionY, String color, ConversoDeImagen conversoDeImagen) {
		super(posicionX, posicionY, color, conversoDeImagen);
		matrizFigura = new int [][] {{0, 0, 6},
		                			 {0, 0, 6},
		                			 {0, 6, 6}};
	}

}
