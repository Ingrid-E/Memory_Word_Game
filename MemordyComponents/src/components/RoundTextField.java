/**
 * Found on the web:
 * https://stackoverflow.com/questions/8515601/java-swing-rounded-border-for-jtextfield
 */
package components;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Shape;
import java.awt.geom.RoundRectangle2D;

import javax.swing.JTextField;

public class RoundTextField extends JTextField{
	private static final long serialVersionUID = 1L;
	private Shape shape;
	private int radius = 30;
	public Color borderColor;
	
	public RoundTextField(int size) {
		super(size);
		setOpaque(false);
		this.borderColor = new Color(234,55,234);
	}
	 protected void paintComponent(Graphics g) {
         g.setColor(new Color(255,255,255,0));
         g.fillRoundRect(0, 0, getWidth()-1, getHeight()-1, radius, radius);
         super.paintComponent(g);
    }

    protected void paintBorder(Graphics g) {
         g.setColor(borderColor);
         g.drawRoundRect(0, 0, getWidth()-1, getHeight()-1, radius, radius);
    }
    public boolean contains(int x, int y) {
         if (shape == null || !shape.getBounds().equals(getBounds())) {
             shape = new RoundRectangle2D.Float(0, 0, getWidth()-1, getHeight()-1, radius, radius);
         }
         return shape.contains(x, y);
    }
	
}
