package tetris.fabricafiguras;

import tetris.ConversoDeImagen;
import tetris.Figura;
import tetris.FiguraCuadrado;

public class FabricaFiguraCuadrado extends FabricaDeFiguras{

	public FabricaFiguraCuadrado(ConversoDeImagen conversoDeImagen) {
		super(conversoDeImagen);
	}

	@Override
	public Figura fabricarFigura() {
		return new FiguraCuadrado(2,2, "NARANJA", super.conversoDeImagen);
	}

}
