package tetris;

import java.awt.Graphics;

public abstract class Figura implements Dibujable {

	private static final int ANCHO_CELDA = 25;
	private static final int LARGO_CELDA = 25;
	private String color;
	protected int [][] matrizFigura;
	protected int posicionX;
	protected int posicionY;
	protected int velocidadX;
	protected int velocidadY;
	private ConversoDeImagen conversoDeImagen;
	
	public Figura(int posicionX, int posicionY, String color, ConversoDeImagen conversoDeImagen) {
		this.posicionX = posicionX;
		this.posicionY = posicionY;
		this.velocidadX = 0;
		this.velocidadY = 1;
		this.color = color;
		matrizFigura = new int[4][4];
		this.conversoDeImagen = conversoDeImagen;
	}
	
	@Override
	public void dibujarse(Graphics graphics) {
		for(int i = 0; i < matrizFigura.length ; i++) {
			for(int j = 0;  j < matrizFigura[i].length; j++) {
				if(matrizFigura[i][j] != 0) {
					int posx = (posicionX + j) * ANCHO_CELDA;
					int posy = (posicionY + i) * LARGO_CELDA;
					graphics.drawImage(conversoDeImagen.getImagen(this.color), posx, posy, ANCHO_CELDA, LARGO_CELDA, null);
				}
			}
		}
	}
	
	public void figuraRotar() {
		    int tamanio = matrizFigura.length;
		    int[][] nuevaMatriz = new int[tamanio][tamanio];

		    for (int x=0;x<tamanio;x++) {
		        for (int y=0;y<tamanio;y++) {
		            nuevaMatriz[y][tamanio-1-x] = matrizFigura[x][y];
		        }
		    }
		    matrizFigura = nuevaMatriz;
	}
	
//	public void moverse() {
//		this.posicionX = posicionX + velocidadX;
//		this.posicionY = posicionY + velocidadY;
//	}
	
	public void frenar() {
		this.velocidadY = 0;
		this.velocidadX = 0;
	}
	

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getPosicionX() {
		return posicionX;
	}

	public void setPosicionX(int posicionX) {
		this.posicionX = posicionX;
	}

	public int getPosicionY() {
		return posicionY;
	}

	public int getVelocidadX() {
		return velocidadX;
	}

	public void setVelocidadX(int velocidadX) {
		this.velocidadX = velocidadX;
	}

	public int getVelocidadY() {
		return velocidadY;
	}

	public void setVelocidadY(int velocidadY) {
		this.velocidadY = velocidadY;
	}

	public void setPosicionY(int posicionY) {
		this.posicionY = posicionY;
	}

	public int[][] getMatrizFigura() {
		return matrizFigura;
	}

	public void moverseAbajo() {
		this.posicionY++;
		//this.posicionY = posicionY + velocidadY;
	};
	
	public void moverseDerecha() {
		this.posicionX++;
	};

	public void moverseIzquierda() {
		this.posicionX--;
	};
	
		
}
