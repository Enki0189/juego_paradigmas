package tetris;

public class FiguraT extends Figura{

	public FiguraT(int posicionX, int posicionY, String color, ConversoDeImagen conversoDeImagen) {
		super(posicionX, posicionY, color, conversoDeImagen);
		matrizFigura = new int [][] {{1, 1, 1, 0},
		                			 {0, 1, 0, 0},
		                			 {0, 0, 0, 0},
		                			 {0, 0, 0, 0}};
	}


}
