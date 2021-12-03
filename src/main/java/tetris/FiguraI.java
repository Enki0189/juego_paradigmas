package tetris;

public class FiguraI extends Figura {

	public FiguraI(int posicionX, int posicionY, String color, ConversoDeImagen conversoDeImagen) {
		super(posicionX, posicionY, color, conversoDeImagen);
		matrizFigura = new int [][] {{0, 1, 0, 0},
									 {0, 1, 0, 0},
									 {0, 1, 0, 0},
									 {0, 1, 0, 0}};
	}


}
