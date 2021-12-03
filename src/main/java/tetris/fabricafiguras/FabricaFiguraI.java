package tetris.fabricafiguras;

import tetris.ConversoDeImagen;
import tetris.Figura;
import tetris.FiguraI;

public class FabricaFiguraI extends FabricaDeFiguras{

	public FabricaFiguraI(ConversoDeImagen conversoDeImagen) {
		super(conversoDeImagen);
		
	}

	@Override
	public Figura fabricarFigura() {
	    return new FiguraI(2, 2, "AZUL", conversoDeImagen);
	}

}
