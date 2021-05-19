package components;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Graphics;
import java.awt.GraphicsEnvironment;
import java.io.File;
import java.io.IOException;

import javax.swing.JLabel;
import javax.swing.JPanel;


public class ChooseSavedGame extends JPanel{
	private static final long serialVersionUID = 1L;
	private JLabel name, level;
	private String playerName, playerLevel;
	private Font nasalization;
	
	public ChooseSavedGame() {
		this.setLayout(null);
		//Nasalization font
		try {
			nasalization = Font.createFont(Font.TRUETYPE_FONT, new File(ChooseSavedGame.class.getResource("/fonts/nasalization-rg.ttf").getFile()));
			GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
			ge.registerFont(nasalization);
			
		} catch (FontFormatException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		name = new JLabel("Name: ");
		name.setBounds(159,12,170,48);
		name.setFont(nasalization.deriveFont(40f));
		name.setForeground(Color.WHITE);
		
		level = new JLabel("Level: ");
		level.setBounds(159,60,150,48);
		level.setFont(nasalization.deriveFont(40f));
		level.setForeground(Color.WHITE);
		
		add(name);
		add(level);
		this.setSize(600, 120);
		this.setVisible(true);
	}
	

	public void paintComponent(Graphics g) {
		g.setColor(Color.GRAY);
		g.fillOval(2, 2, 116, 116);
	}
	
}
