package tetris;

public class FiguraZ extends Figura{

	public FiguraZ(int posicionX, int posicionY, String color, ConversoDeImagen conversoDeImagen) {
		super(posicionX, posicionY, color, conversoDeImagen);
		                			 
		matrizFigura = new int [][] {{0, 0, 2},
			                		 {0, 2, 2},
			                		 {0, 2, 0}};
	}

}
