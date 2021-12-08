package tetris;

public class FiguraL extends Figura {

	public FiguraL(int posicionX, int posicionY, String color, ConversoDeImagen conversoDeImagen) {
		super(posicionX, posicionY, color, conversoDeImagen);
		matrizFigura = new int [][] {{0, 3, 0},
		                			 {0, 3, 0},
		                			 {0, 3, 3}};
	}


}
