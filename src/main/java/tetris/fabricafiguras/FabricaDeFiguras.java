package tetris.fabricafiguras;

import tetris.ConversoDeImagen;
import tetris.Figura;

public abstract class FabricaDeFiguras {
	
	protected ConversoDeImagen conversoDeImagen;
	
	public FabricaDeFiguras(ConversoDeImagen conversoDeImagen) {
		this.conversoDeImagen = conversoDeImagen;
	}

	public abstract Figura fabricarFigura();
	

}
