package tetris;

import java.awt.Graphics;

public class Tablero implements Dibujable {
	
	private static final int ANCHO_CELDA = 25;
	private static final int LARGO_CELDA = 25;
	private static final int LIMITE_INFERIOR_TABLERO = 22;
	private static final int LIMITE_IZQUIERDA_TABLERO = 0;
	private static final int LIMITE_DERECHA_TABLERO = 10;
	protected int [][] matrizTablero;
	private CreadorDeFiguras creadorDeFiguras;
	private ConversoDeImagen conversoDeImagen;
	private Figura figuraActual;
	protected int posicionX;
	protected int posicionY;
	
	public Tablero (ConversoDeImagen conversoDeImagen) {
		this.matrizTablero = new int [][] {{0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
										   {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
										   {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
										   {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
										   {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
										   {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
										   {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
										   {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
										   {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
										   {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
										   {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
										   {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
										   {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
										   {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
										   {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
										   {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
										   {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
										   {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
										   {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
										   {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
										   {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
										   {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
										   {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
										   {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
										   {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
										   {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}};
										   
         this.conversoDeImagen = conversoDeImagen;
         this.creadorDeFiguras = new CreadorDeFiguras(conversoDeImagen);
         figuraActual = creadorDeFiguras.crearUnaFigura();
	}
	
	public void actualizar() {
		figuraActual.moverseAbajo();
		
		if(huboColision()) {
			figuraActual.retroceder();
			insertarFiguraEnTablero();
			//TODO Verificar si hubo linea: encontrarYBorrarLineas()
			figuraActual = creadorDeFiguras.crearUnaFigura();
		}
		
	}
	
	//Los 4 metodos de abajo se van a usar para el teclado. 
	public void moverFiguraActualDerecha() {
		if(hayColisionADerecha() == false) {
			figuraActual.moverseDerecha();
		}
	}
	
	private boolean hayColisionADerecha() {
		int[][] tableroFigura = figuraActual.getMatrizFigura();
		for(int i = 0; i < tableroFigura.length; i++) {
			for(int j = 0; j < tableroFigura[i].length; j++) {
				if(tableroFigura[i][j] != 0 && figuraActual.getPosicionX() + j == (LIMITE_DERECHA_TABLERO - 1)) {
					return true;
				}
			}
		}
		return false;
	}
	

	public void moverFiguraActualIzquierda() {
		if(hayColisionAIzquierda() == false) {
			figuraActual.moverseIzquierda();
		}
	}
	
	private boolean hayColisionAIzquierda() {
		int[][] tableroFigura = figuraActual.getMatrizFigura();
		for(int i = 0; i < tableroFigura.length; i++) {
			for(int j = 0; j < tableroFigura[i].length; j++) {
				if(tableroFigura[i][j] != 0 && figuraActual.getPosicionX() + j == LIMITE_IZQUIERDA_TABLERO) {
					return true;
				}
			}
		}
		return false;
	}

	public void moverFiguraAbajo() {
		this.actualizar();
	}
	
	public void rotarFiguraActual() {
		figuraActual.figuraRotar();
	}
	
	private void insertarFiguraEnTablero() {
		int[][] tableroFigura = figuraActual.getMatrizFigura();
		
		for(int i = 0; i < tableroFigura.length; i++) {
			for(int j = 0; j < tableroFigura[i].length; j++) {
				if(tableroFigura[i][j] != 0) {
					int posXInsercion = figuraActual.getPosicionX() + j;
					int posYInsercion = figuraActual.getPosicionY() + i;
					this.matrizTablero[posYInsercion][posXInsercion] = tableroFigura[i][j];
				}
			}
		}
	}

	private boolean huboColision() {
		int[][] tableroFigura = figuraActual.getMatrizFigura();
		
		for(int i = 0; i < tableroFigura.length; i++) {
			for(int j = 0; j < tableroFigura[i].length; j++) {
				if(tableroFigura[i][j] != 0) {
					int posXInsercion = figuraActual.getPosicionX() + j;
					int posYInsercion = figuraActual.getPosicionY() + i;
					if(posYInsercion >= LIMITE_INFERIOR_TABLERO || this.matrizTablero[posYInsercion][posXInsercion] != 0) {
						return true;
					}
				}
			}
		}
		
		return false;
	}
	
	@Override
	public void dibujarse(Graphics graphics) {
		for(int i = 0; i < matrizTablero.length ; i++) {
			for(int j = 0;  j < matrizTablero[i].length; j++) {
				if(matrizTablero[i][j] != 0) {
					int posx = j * ANCHO_CELDA;
					int posy = i * LARGO_CELDA;
					graphics.drawImage(conversoDeImagen.getImagen("ROJO"), (posx+150), (posy), (ANCHO_CELDA), (LARGO_CELDA), null);
					
				}
			}
		}
		figuraActual.dibujarse(graphics);
		// borra la linea completa de 1 en la matrix 
        int size = matrizTablero.length - 1;

		for(int i = matrizTablero.length - 1; i > 0; i--)
		{
			int count = 0;
			for(int j = 0; j < matrizTablero[0].length; j++)
			{
				if(matrizTablero[i][j] != 0)
					count++;
				
				matrizTablero[size][j] = matrizTablero[i][j];
			}
			if(count < matrizTablero[0].length) {
				size --;
			}
		}
	}

}