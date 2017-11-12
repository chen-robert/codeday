package main;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import javax.imageio.ImageIO;

public class ImageLoader {
	private static HashMap<String, BufferedImage> images;
	static {
		images = new HashMap<>();
		load("cannon");
		load("thruster");
	}
	public static BufferedImage get(String s) {
		return images.get(s);
	}
	private static void load(String s) {
		try {
			images.put(s, ImageIO.read(new File("resources/" + s + ".png")));
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
}
