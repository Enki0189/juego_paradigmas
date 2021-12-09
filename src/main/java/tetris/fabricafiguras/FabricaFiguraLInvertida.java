package tetris.fabricafiguras;

import tetris.ConversoDeImagen;
import tetris.Figura;
import tetris.FiguraLInvertida;

public class FabricaFiguraLInvertida extends FabricaDeFiguras {
	
	public FabricaFiguraLInvertida(ConversoDeImagen conversoDeImagen) {
		super(conversoDeImagen);
		
	}

	@Override
	public Figura fabricarFigura() {
		return new FiguraLInvertida(2, 2, "AMARILLO", conversoDeImagen);
	}

}
