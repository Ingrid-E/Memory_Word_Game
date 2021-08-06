package components;

import java.awt.Graphics2D;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.image.BufferedImage;

import javax.swing.Icon;
import javax.swing.ImageIcon;

public class ImageResize{

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
	}
	
	public ImageResize(Icon image, int width, int height) {
		this.width = width;
		this.height = height;
		this.image = new ImageIcon(iconToImage(image));
		type = image.toString();
		type = type.substring(type.indexOf(".")+1, type.length());
	}
	
	private Image iconToImage(Icon icon) {
		if (icon instanceof ImageIcon) {
		      return ((ImageIcon)icon).getImage();
		   } 
		   else {
		      int w = icon.getIconWidth();
		      int h = icon.getIconHeight();
		      GraphicsEnvironment ge = 
		      GraphicsEnvironment.getLocalGraphicsEnvironment();
		      GraphicsDevice gd = ge.getDefaultScreenDevice();
		      GraphicsConfiguration gc = gd.getDefaultConfiguration();
		      BufferedImage image = gc.createCompatibleImage(w, h);
		      Graphics2D g = image.createGraphics();
		      icon.paintIcon(null, g, 0, 0);
		      g.dispose();
		      return image;
		   }
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
