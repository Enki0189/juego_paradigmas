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
	
	
}
