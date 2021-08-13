package components;

import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsEnvironment;
import java.awt.geom.Rectangle2D;
import java.io.File;
import java.io.IOException;

import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class RotateLabel extends JLabel {
	private Font nasalization;
	
    public RotateLabel(String text) {
       super(text);
       int lenght = text.length();
       this.setHorizontalAlignment(SwingConstants.RIGHT);
       setBounds(3,-8, 530, 440);
    }
    @Override
    public void paintComponent(Graphics g) {
       Graphics2D gx = (Graphics2D) g;
       gx.rotate(0.6, getX() + getWidth()/2, getY() + getHeight()/2);
       super.paintComponent(g);
    }
 }
