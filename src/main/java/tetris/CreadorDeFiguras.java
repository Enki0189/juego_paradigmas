package tetris;

import java.util.ArrayList;
import java.util.Collections;

public class CreadorDeFiguras {
	
	private Figura figura;
    private ArrayList<Figura> listaDeFiguras = new ArrayList<>();
	private ConversoDeImagen conversoDeImagenes;
    
    public CreadorDeFiguras(ConversoDeImagen conversoDeImagenes) {
    	this.conversoDeImagenes = conversoDeImagenes;
    	cargarListaDeFiguras();
    	crearUnaFigura();
    }
    
    protected void cargarListaDeFiguras() {
		listaDeFiguras.add(new FiguraL(2, 2, "VERDE", conversoDeImagenes));
		listaDeFiguras.add(new FiguraI(2, 2, "AZUL", conversoDeImagenes));
		listaDeFiguras.add(new FiguraZ(2,2, "ROJO", conversoDeImagenes));
		listaDeFiguras.add(new FiguraT(2,2, "VIOLETA", conversoDeImagenes));
		listaDeFiguras.add(new FiguraCuadrado(2,2, "NARANJA", conversoDeImagenes));
	}
    
    public ArrayList getListaDeFiguras() {
		return listaDeFiguras;
    }
    
   protected Figura crearUnaFigura() {
		//mezcla el ArrayList y devuelve la primera figura
		//método 1: mezclar el arrayList con shuffle y luego mostrar el primero con listaDeFiguras.get(0) 
		Collections.shuffle(listaDeFiguras);
		//método2: simplemente usar get(numero random) (también podríamos mezclar las dos cosas)
		return figura = listaDeFiguras.get((int) (Math.random() * listaDeFiguras.size()));

	}

}
