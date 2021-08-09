package components;

import java.awt.Color;

import javax.swing.JButton;

public class GameButton extends JButton{
	private static final long serialVersionUID = 1L;

	public GameButton(String text, float fontSize) {
		this.setText(text);
		this.setForeground(Color.WHITE);
		this.setFont(GameFont.nasalization.deriveFont(fontSize));
		this.setContentAreaFilled(false);
		this.setBorderPainted(false);
		this.setFocusable(false);
	}
}
