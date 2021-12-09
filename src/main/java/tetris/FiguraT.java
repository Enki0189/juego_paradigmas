package tetris;

public class FiguraT extends Figura{

	public FiguraT(int posicionX, int posicionY, String color, ConversoDeImagen conversoDeImagen) {
		super(posicionX, posicionY, color, conversoDeImagen);
		matrizFigura = new int [][] {{0, 0, 4},
		                			 {0, 4, 4},
		                			 {0, 0, 4}};
	}


}
