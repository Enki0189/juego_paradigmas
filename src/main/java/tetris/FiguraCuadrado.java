package tetris;

public class FiguraCuadrado extends Figura{

	public FiguraCuadrado(int posicionX, int posicionY, String color, ConversoDeImagen conversoDeImagen) {
		super(posicionX, posicionY, color, conversoDeImagen);
		matrizFigura = new int [][] {{0, 1, 1, 0},
		                			 {0, 1, 1, 0},
		                			 {0, 0, 0, 0},
		                			 {0, 0, 0, 0}};
	}

	@Override
	public void rotar() {
		//El cuadrado no necesita rotar, se sobreescribe con un metodo que no hace nada
	}

}
