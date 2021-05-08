package memordy;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.io.File;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import components.ImageResize;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class MainMenu extends JFrame{
	private JFrame main;
	private JPanel mainMenu;
	private JLabel background;
	private ImageResize resizeImg;
	private Font nasalization;
	private Listen listen;
	protected JButton newGame, loadGame, rules, exit;
	private ImageIcon backgroundImg = new ImageIcon(MainMenu.class.getResource("/images/StarBackground.gif"));
	private static final long serialVersionUID = 1L;
	
	public MainMenu() {
		listen = new Listen(this);
		mainMenu = new JPanel();
		//Basic window atributes
		main = this;
		main.setName("Main Menu");
		main.setSize(800,600);
		main.setVisible(true);
		main.setResizable(false);
		//Adding Font
		try {
			nasalization = Font.createFont(Font.TRUETYPE_FONT, new File(MainMenu.class.getResource("/fonts/nasalization-rg.ttf").getFile()));
			GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
			ge.registerFont(nasalization);
			
		} catch (FontFormatException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//Main Menu
		mainMenuGUI();
		
		
	}
	
	
	
	private void mainMenuGUI() {
		//Main Menu JPanel
		mainMenu.setSize(this.getSize());
		mainMenu.setLayout(null);
		
		//Gif Star Background, resizing image to fit window size.
		resizeImg = new ImageResize(backgroundImg, main.getWidth(), main.getHeight());
		backgroundImg = resizeImg.resize();
		background = new JLabel();
		background.setBounds(0, 0, 800, 600);
		background.setIcon(backgroundImg);
		
		JLabel title = new JLabel("Memordy");
		title.setBounds(134, 40, 526, 120);
		title.setForeground(Color.WHITE);
		title.setFont(nasalization.deriveFont(100f));
		
		newGame = new JButton();
		newGame.setIcon(new ImageIcon(MainMenu.class.getResource("/images/NewGame.gif")));
		newGame.setContentAreaFilled(false);
		newGame.setBorderPainted(false);
		newGame.setFocusable(false);
		newGame.setBounds(24, 180, 243, 243);
		
		loadGame = new JButton();
		loadGame.setIcon(new ImageIcon(MainMenu.class.getResource("/images/LoadGame.gif")));
		loadGame.setContentAreaFilled(false);
		loadGame.setBorderPainted(false);
		loadGame.setFocusable(false);
		loadGame.setBounds(279, 250, 243, 243);
		
		rules = new JButton();
		rules.setContentAreaFilled(false);
		rules.setIcon(new ImageIcon(MainMenu.class.getResource("/images/Rules.gif")));
		rules.setBorderPainted(false);
		rules.setFocusable(false);
		rules.setBounds(522, 310, 243, 243);
		
		exit = new JButton("X");
		exit.setForeground(Color.WHITE);
		exit.setFont(nasalization.deriveFont(36f));
		exit.setContentAreaFilled(false);
		exit.setBorderPainted(false);
		exit.setFocusable(false);
		exit.setBounds(720,0,72,72);
		
		//Adding mouse listeners
		exit.addMouseListener(listen);
		newGame.addMouseListener(listen);
		
		mainMenu.add(exit);		
		mainMenu.add(loadGame);
		mainMenu.add(newGame);
		mainMenu.add(rules);
		mainMenu.add(title);
		mainMenu.add(background);
		main.getContentPane().add(mainMenu);
	}
	
	protected void changeGUI(String change) {
		if(change == "New Game") {
			main.remove(mainMenu);
			main.revalidate();
			main.repaint();
			newGameGUI();
		}
	}
	
	private void newGameGUI() {

	}
	
	


}
