package tetris;

public class FiguraI extends Figura {

	public FiguraI(int posicionX, int posicionY, String color, ConversoDeImagen conversoDeImagen) {
		super(posicionX, posicionY, color, conversoDeImagen);
		matrizFigura = new int [][] {{0, 5, 0, 0},
									 {0, 5, 0, 0},
									 {0, 5, 0, 0},
									 {0, 5, 0, 0}};
	}


}
