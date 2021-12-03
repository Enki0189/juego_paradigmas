package tetris;

import java.awt.Graphics;

public class Tablero implements Dibujable {
	
	protected int [][] matrizTablero;
	private CreadorDeFiguras creadorDeFiguras;
	private Figura figuraActual;
	
	public Tablero (CreadorDeFiguras creadorDeFiguras) {
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
										   {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}};
										   
         this.creadorDeFiguras = creadorDeFiguras;
	}
	
	private void hayColision() {
		// Si se detecta colision, se debe subir la figura una posicion arriba porque quedaria superpuesta con la de abajo.
		figuraActual.setVelocidadY(-1);
//		figuraActual.mover();
		
		insertarFiguraEnTablero();
		
//		figuraActual = creadorDeFiguras.pedirFigura();
	
	}
	
	private void insertarFiguraEnTablero() {
		int[][] tableroFigura = figuraActual.getMatrizFigura();
		
		for(int i = 0; i < tableroFigura.length; i++) {
			for(int j = 0; j < tableroFigura[i].length; j++) {
				if(tableroFigura[i][j] != 0) {
					int posXInsercion = figuraActual.getPosicionX() + j;
					int posYInsercion = figuraActual.getPosicionY() + i;
					this.matrizTablero[posXInsercion][posYInsercion] = tableroFigura[i][j];
				}
			}
		}
	}

	@Override
	public void dibujarse(Graphics graphics) {
		// TODO Auto-generated method stub
		
	}

}
