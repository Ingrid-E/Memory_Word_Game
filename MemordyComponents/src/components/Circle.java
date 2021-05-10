package components;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class Circle extends JPanel{
	
	public void paintComponent(Graphics g) {
		g.setColor(new Color(234,55,234));
		g.drawOval(-2, -2, 164, 164);
		g.drawOval(-1, -1, 162, 162);
		g.drawOval(0, 0, 160, 160);

	}
}
