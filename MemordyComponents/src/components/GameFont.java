package components;

import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.io.File;
import java.io.IOException;

public class GameFont {
	public static java.awt.Font nasalization = GameFont.gamingFont();

	private static Font gamingFont() {
		try {
			nasalization = Font.createFont(Font.TRUETYPE_FONT, new File(GameText.class.getResource("/fonts/nasalization-rg.ttf").getFile()));
			GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
			ge.registerFont(nasalization);
			
		} catch (FontFormatException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return nasalization;
	}
}
