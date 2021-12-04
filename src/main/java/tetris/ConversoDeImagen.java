package tetris;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;

public class ConversoDeImagen {
	
	private Map<String, BufferedImage> imagenesPorColor;

	public ConversoDeImagen(String path) {
		imagenesPorColor = new HashMap<>();
		try {
			imagenesPorColor.put("NARANJA", ImageIO.read(new File(path, "pieza_naranja_un_bloque.png")));
			imagenesPorColor.put("ROJO", ImageIO.read(new File(path, "pieza_roja_un_bloque.png")));
			imagenesPorColor.put("VERDE", ImageIO.read(new File(path, "pieza_verde_un_bloque.png")));
			imagenesPorColor.put("VIOLETA", ImageIO.read(new File(path, "pieza_violeta_un_bloque.png")));
			imagenesPorColor.put("AZUL", ImageIO.read(new File(path, "pieza_azul_un_bloque.png")));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public BufferedImage getImagen(String color) {
		return imagenesPorColor.get(color.toUpperCase());
	}
	
	public BufferedImage getImagen(int n) {
		if(n == 1) {
			return imagenesPorColor.get("NARANJA");
		} else if(n == 2) {
			return imagenesPorColor.get("ROJO");
		} else if(n == 3) {
			return imagenesPorColor.get("VERDE");
		} else if(n == 4 ) {
			return imagenesPorColor.get("VIOLETA");
		} else if(n == 5) {
			return imagenesPorColor.get("AZUL");
		}
		
		//Si es otro numero retorna siempre azul
		return imagenesPorColor.get("AZUL");
		
	}
}
