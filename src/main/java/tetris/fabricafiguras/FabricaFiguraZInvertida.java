package tetris.fabricafiguras;

import tetris.ConversoDeImagen;
import tetris.Figura;
import tetris.FiguraZInvertida;

public class FabricaFiguraZInvertida extends FabricaDeFiguras {
	
	public FabricaFiguraZInvertida(ConversoDeImagen conversoDeImagen) {
		super(conversoDeImagen);
		
	}

	@Override
	public Figura fabricarFigura() {
		return new FiguraZInvertida(2, 2, "CELESTE", conversoDeImagen);
	}
	
}
