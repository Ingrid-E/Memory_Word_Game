package components;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Graphics;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class ChooseSavedGame extends JPanel{
	private static final long serialVersionUID = 1L;
	private JLabel name, level, icon;
	private String playerName, playerLevel;
	private Font nasalization;
	
	public ChooseSavedGame() {
		this.setLayout(null);
		this.setOpaque(true);
		this.setBackground(new Color(0,0,0,0));
		loadFont();
		loadInfo("", 0);
		add(name);
		add(level);
		this.icon = new JLabel();
		this.icon.setIcon(new ImageIcon(ChooseSavedGame.class.getResource("/imgages/noPlayer.png")));
		this.icon.setBounds(2, 2, 116, 116);
		this.setSize(600, 120);
		this.setVisible(true);
	}
	public ChooseSavedGame(String name, int level, JLabel icon) {
		this.setLayout(null);
		this.setOpaque(true);
		this.setBackground(new Color(0,0,0,0));
		loadFont();
		loadInfo(name, level);
		loadIcon(icon);
		add(this.name);
		add(this.level);
		add(this.icon);
		this.setSize(600, 120);
		this.setVisible(true);
		
	}
	
	private void loadFont() {
		//Nasalization font
		try {
			nasalization = Font.createFont(Font.TRUETYPE_FONT, new File(ChooseSavedGame.class.getResource("/fonts/nasalization-rg.ttf").getFile()));
			GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
			ge.registerFont(nasalization);
			
		} catch (FontFormatException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private void loadInfo(String name, int level) {
		this.name = new JLabel("Name: "+name);
		this.name.setBounds(159,12,500,48);
		this.name.setFont(nasalization.deriveFont(40f));
		this.name.setForeground(Color.WHITE);
		
		this.level = new JLabel("Level: "+level);
		this.level.setBounds(159,60,150,48);
		this.level.setFont(nasalization.deriveFont(40f));
		this.level.setForeground(Color.WHITE);
		
	}
	
	private void loadIcon(JLabel icon) {
		ImageResize resized = new ImageResize(icon.getIcon(), 116, 116);
		this.icon = new JLabel();
		this.icon.setIcon(resized.resize());
		this.icon.setBounds(2, 2, 116, 116);
	}

	
}
