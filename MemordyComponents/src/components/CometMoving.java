package components;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.io.File;
import java.io.IOException;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class CometMoving extends JPanel{
	private JLabel comet, wordLabel;
	private String word;
	private Font nasalization;
	
	public CometMoving(String newWord) {
		this.setOpaque(false);
		try {
			nasalization = Font.createFont(Font.TRUETYPE_FONT, new File(CometMoving.class.getResource("/fonts/nasalization-rg.ttf").getFile()));
			GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
			ge.registerFont(nasalization);
			
		} catch (FontFormatException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		this.setLayout(null);
		this.word = newWord;
		wordLabel = new RotateLabel(word);
		float size = 65 -((word.length()*4)/2);
		wordLabel.setFont(nasalization.deriveFont(size));
		wordLabel.setForeground(new Color(221, 58, 19));
		comet = new JLabel();
		comet.setIcon(new ImageIcon(CometMoving.class.getResource("/images/Comet.png")));
		comet.setBounds(0, 2, 528, 438);
		
		add(wordLabel);
		add(comet);
		this.setSize(530, 440);
		this.setVisible(true);
	}
	
	public void setText(String text) {
		wordLabel.setText(text);
	}
	
}
