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
		load();
	}
	public static BufferedImage get(String s) {
		return images.get(s);
	}
	private static void load() {
		File dir = new File("resources");
		File[] resources = dir.listFiles();
		for(File f: resources) {
			try {
				String name = f.getName();
				images.put(name.substring(0, name.indexOf('.')), ImageIO.read(f));
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
	}
}
