package tetris.fabricafiguras;

import tetris.ConversoDeImagen;
import tetris.Figura;
import tetris.FiguraL;

public class FabricaFiguraL extends FabricaDeFiguras {

	public FabricaFiguraL(ConversoDeImagen conversoDeImagen) {
		super(conversoDeImagen);
		
	}

	@Override
	public Figura fabricarFigura() {
		return new FiguraL(2, 2, "VERDE", conversoDeImagen);
	}

}
