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

public class CreadorDeFiguras {
	
    //private ArrayList<Figura> listaDeFiguras = new ArrayList<>();
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
	}
    
   public Figura crearUnaFigura() {
		//mezcla el ArrayList y devuelve la primera figura
		//método 1: mezclar el arrayList con shuffle y luego mostrar el primero con listaDeFiguras.get(0) 
		Collections.shuffle(fabricasDeFiguras);
		//método2: simplemente usar get(numero random) (también podríamos mezclar las dos cosas)
		return fabricasDeFiguras.get((int) (Math.random() * fabricasDeFiguras.size())).fabricarFigura();

	}

}
