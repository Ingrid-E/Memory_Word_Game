package components;

import java.awt.Image;
import javax.swing.ImageIcon;

public class ImageResize extends ImageIcon{

	private static final long serialVersionUID = 1L;
	private int width, height;
	private ImageIcon image;
	private String type;
	
	public ImageResize(ImageIcon image, int width, int height) {
		this.width = width;
		this.height = height;
		this.image = image;
		type = image.getDescription();
		type = type.substring(type.indexOf(".")+1, type.length());
		System.out.println("Image Type: " + type);
	}
	
	public ImageIcon resize() {
		Image original = image.getImage();
		Image originalResized;
		if(type.equals("gif")) {
			originalResized = original.getScaledInstance(width, height, Image.SCALE_DEFAULT);
		}else {
			originalResized = original.getScaledInstance(width, height, Image.SCALE_SMOOTH);
		}
		ImageIcon resized = new ImageIcon(originalResized);
		return resized;
	}

}
