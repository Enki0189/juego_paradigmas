package tetris.fabricafiguras;

import tetris.ConversoDeImagen;
import tetris.Figura;
import tetris.FiguraZ;

public class FabricaFiguraZ extends FabricaDeFiguras{

	public FabricaFiguraZ(ConversoDeImagen conversoDeImagen) {
		super(conversoDeImagen);
		
	}

	@Override
	public Figura fabricarFigura() {
		return new FiguraZ(2, 2, "ROJO", conversoDeImagen);
	}

}
