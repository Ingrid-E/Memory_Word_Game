package components;

import java.awt.Color;

import javax.swing.JLabel;

public class GameText extends JLabel{

	private static final long serialVersionUID = 1L;
	
	public GameText(String text, float size) {
		this.setText(text);
		this.setFont(GameFont.nasalization.deriveFont(size));
		this.setForeground(Color.WHITE);
	}
	
}
