package tetris;

import java.awt.Graphics;

public class Tablero implements Dibujable {

	private static final int ANCHO_CELDA = 25;
	private static final int LARGO_CELDA = 25;
	private static final int LIMITE_INFERIOR_TABLERO = 22;
	private static final int LIMITE_IZQUIERDA_TABLERO = 0;
	private static final int LIMITE_DERECHA_TABLERO = 10;
	protected int[][] matrizTablero;
	private CreadorDeFiguras creadorDeFiguras;
	private ConversoDeImagen conversoDeImagen;
	private Figura figuraActual;
	private Figura proximaFigura;
	protected int posicionX;
	protected int posicionY;
	public static int lineasBorradas = 0;
	public static int lineasAcumuladas = 0;
	public static int puntaje = 0;
	public boolean seBorroLinea = false;
	public boolean gameOver = false;
	public boolean gamePause = false;
	public static int level = 1;
	

	public Tablero(ConversoDeImagen conversoDeImagen) {
		this.matrizTablero = new int[][] { { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, 
										   { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
										   { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, 
										   { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
										   { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
										   { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, 
										   { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, 
										   { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
										   { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
										   { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
										   { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
										   { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
										   { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
										   { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
										   { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
										   { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
										   { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
										   { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
										   { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
										   { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
										   { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
										   { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
										   { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
										   { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
										   { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
										   { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 } };

		this.conversoDeImagen = conversoDeImagen;
		this.creadorDeFiguras = new CreadorDeFiguras(conversoDeImagen);
		figuraActual = creadorDeFiguras.crearUnaFigura();
		proximaFigura = creadorDeFiguras.crearUnaFigura();
		proximaFigura.setPosicionX(10);
		proximaFigura.setPosicionY(3);
	}

	public void actualizar() {
		if (gameOver == false && gamePause == false ) {
			figuraActual.moverseAbajo();
			if (figuraCayo()) {
				figuraActual.retroceder();
				insertarFiguraEnTablero();
				hayColisionArriba();
				if (gameOver == false && gamePause == false) {
					figuraActual = proximaFigura;
					figuraActual.setPosicionX(2);
					figuraActual.setPosicionY(0); 
					proximaFigura = creadorDeFiguras.crearUnaFigura();
					proximaFigura.setPosicionX(10);
					proximaFigura.setPosicionY(3);
					
					borrarLinea();					
				}
				
			}
				
		}
		acumularPuntaje();
		nivel();
   } 
	

	public void acumularPuntaje() {
		lineasAcumuladas = lineasAcumuladas + lineasBorradas;
		if (lineasBorradas == 1) {
			puntaje = puntaje + 10;
		} else if (lineasBorradas < 4) {
			puntaje = puntaje + (lineasBorradas * 15);
		} else {
			puntaje = puntaje + (lineasBorradas * 20);
		}
		lineasBorradas = 0;

	}
	
	public void nivel() {
		if(puntaje >= 200) {
			level = 2;
		} 
		if (puntaje >= 400) {
			level = 3;
		}
		if (puntaje >= 600) {
			level = 4;
		}

	}


	// Los 4 metodos de abajo se van a usar para el teclado.
	public void moverFiguraActualDerecha() {
		if (hayColisionADerecha() == false) {
			figuraActual.moverseDerecha();
		}
	}

	public void hayColisionArriba() {
		for (int i = 0; i < this.matrizTablero[2].length; i++) {
			if (this.matrizTablero[2][i] != 0) {
				gameOver = true;
			}

		}

	}

	private boolean hayColisionADerecha() {
		int[][] tableroFigura = figuraActual.getMatrizFigura();
		for (int i = 0; i < tableroFigura.length; i++) {
			for (int j = 0; j < tableroFigura[i].length; j++) {
				int posicionXinterseccion = figuraActual.getPosicionX() + j;
				int posicionYinterseccion = figuraActual.getPosicionY() + i;
				if (tableroFigura[i][j] != 0 && (figuraActual.getPosicionX() + j == (LIMITE_DERECHA_TABLERO - 1)
						|| matrizTablero[posicionYinterseccion][posicionXinterseccion + 1] != 0)) {
					return true;
				}
			}
		}
		return false;
	}

	public void moverFiguraActualIzquierda() {
		if (hayColisionAIzquierda() == false) {
			figuraActual.moverseIzquierda();
		}
	}

	private boolean hayColisionAIzquierda() {
		int[][] tableroFigura = figuraActual.getMatrizFigura();
		for (int i = 0; i < tableroFigura.length; i++) {
			for (int j = 0; j < tableroFigura[i].length; j++) {
				int posicionXinterseccion = figuraActual.getPosicionX() + j;
				int posicionYinterseccion = figuraActual.getPosicionY() + i;
				if (tableroFigura[i][j] != 0 && (figuraActual.getPosicionX() + j == LIMITE_IZQUIERDA_TABLERO
						|| matrizTablero[posicionYinterseccion][posicionXinterseccion - 1] != 0)) {
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
		int[][] tableroFiguraRotada = figuraActual.obtenerProximaRotacion();
		if (!hayInterseccion(tableroFiguraRotada)) {
			figuraActual.rotar();
		}
	}

	private boolean hayInterseccion(int[][] tableroFiguraRotada) {
		for (int i = 0; i < tableroFiguraRotada.length; i++) {
			for (int j = 0; j < tableroFiguraRotada[i].length; j++) {
				int posicionXinterseccion = figuraActual.getPosicionX() + j;
				int posicionYinterseccion = figuraActual.getPosicionY() + i;
				if (tableroFiguraRotada[i][j] != 0 && (posicionXinterseccion < LIMITE_IZQUIERDA_TABLERO
						|| posicionXinterseccion >= LIMITE_DERECHA_TABLERO
						|| posicionYinterseccion >= LIMITE_INFERIOR_TABLERO
						|| this.matrizTablero[posicionYinterseccion][posicionXinterseccion] != 0)) {
					return true;
				}
			}
		}
		return false;
	}

	private void insertarFiguraEnTablero() {
		int[][] tableroFigura = figuraActual.getMatrizFigura();

		for (int i = 0; i < tableroFigura.length; i++) {
			for (int j = 0; j < tableroFigura[i].length; j++) {
				if (tableroFigura[i][j] != 0) {
					int posXInsercion = figuraActual.getPosicionX() + j;
					int posYInsercion = figuraActual.getPosicionY() + i;
					this.matrizTablero[posYInsercion][posXInsercion] = tableroFigura[i][j];
				}
			}
		}
	}

	private boolean figuraCayo() {
		int[][] tableroFigura = figuraActual.getMatrizFigura();

		for (int i = 0; i < tableroFigura.length; i++) {
			for (int j = 0; j < tableroFigura[i].length; j++) {
				if (tableroFigura[i][j] != 0) {
					int posXInsercion = figuraActual.getPosicionX() + j;
					int posYInsercion = figuraActual.getPosicionY() + i;
					if (posYInsercion >= LIMITE_INFERIOR_TABLERO
							|| this.matrizTablero[posYInsercion][posXInsercion] != 0) {
						return true;
					}
				}
			}
		}

		return false;
	}

	public void borrarLinea() {
		int size = matrizTablero.length - 1;

		for (int i = matrizTablero.length - 1; i > 0; i--) {
			int count = 0;
			for (int j = 0; j < matrizTablero[0].length; j++) {
				if (matrizTablero[i][j] != 0) {
					count++;
				}
				matrizTablero[size][j] = matrizTablero[i][j];
			}
			if (count < matrizTablero[0].length) {
				size--;
			}
			if (count == 10) {
				lineasBorradas++;
			}
		}
	}

	@Override
	public void dibujarse(Graphics graphics) {
		for (int i = 0; i < matrizTablero.length; i++) {
			for (int j = 0; j < matrizTablero[i].length; j++) {
				if (matrizTablero[i][j] != 0) {
					int posx = j * ANCHO_CELDA;
					int posy = i * LARGO_CELDA;
					if(i >= 2) {
						graphics.drawImage(conversoDeImagen.getImagen(matrizTablero[i][j]), (posx + 150), (posy),
								(ANCHO_CELDA), (LARGO_CELDA), null);
					}

				}
			}
		}
		figuraActual.dibujarse(graphics);
		proximaFigura.dibujarse(graphics);
	}

}