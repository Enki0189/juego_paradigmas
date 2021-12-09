package tetris.fabricafiguras;

import tetris.ConversoDeImagen;
import tetris.Figura;
import tetris.FiguraT;

public class FabricaFiguraT extends FabricaDeFiguras{

	public FabricaFiguraT(ConversoDeImagen conversoDeImagen) {
		super(conversoDeImagen);
		
	}

	@Override
	public Figura fabricarFigura() {
		return new FiguraT(2, 2, "VIOLETA", conversoDeImagen);
	}

}
