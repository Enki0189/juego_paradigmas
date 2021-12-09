package tetris;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import tetris.fabricafiguras.FabricaDeFiguras;
import tetris.fabricafiguras.FabricaFiguraCuadrado;
import tetris.fabricafiguras.FabricaFiguraI;
import tetris.fabricafiguras.FabricaFiguraL;
import tetris.fabricafiguras.FabricaFiguraT;
import tetris.fabricafiguras.FabricaFiguraZ;
import tetris.fabricafiguras.FabricaFiguraLInvertida;
import tetris.fabricafiguras.FabricaFiguraZInvertida;

public class CreadorDeFiguras {
	
    private List<FabricaDeFiguras> fabricasDeFiguras;
	private ConversoDeImagen conversoDeImagenes;
    
    public CreadorDeFiguras(ConversoDeImagen conversoDeImagenes) {
    	this.conversoDeImagenes = conversoDeImagenes;
    	this.fabricasDeFiguras = new ArrayList<>();
    	cargarListaDeFabricasDeFiguras();
    }
    
    private void cargarListaDeFabricasDeFiguras() {
    	fabricasDeFiguras.add(new FabricaFiguraL(conversoDeImagenes));
    	fabricasDeFiguras.add(new FabricaFiguraI(conversoDeImagenes));
    	fabricasDeFiguras.add(new FabricaFiguraZ(conversoDeImagenes));
    	fabricasDeFiguras.add(new FabricaFiguraT(conversoDeImagenes));
    	fabricasDeFiguras.add(new FabricaFiguraCuadrado(conversoDeImagenes));
    	fabricasDeFiguras.add(new FabricaFiguraLInvertida(conversoDeImagenes));
    	fabricasDeFiguras.add(new FabricaFiguraZInvertida(conversoDeImagenes));
	}
    
    public Figura crearUnaFigura() {
        Collections.shuffle(fabricasDeFiguras);
        return fabricasDeFiguras.get((int) (Math.random() * fabricasDeFiguras.size())).fabricarFigura();

	}
    
   

}
