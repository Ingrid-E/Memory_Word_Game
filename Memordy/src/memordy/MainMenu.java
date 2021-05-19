package memordy;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Graphics;
import java.awt.GraphicsEnvironment;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import components.ChooseSavedGame;
import components.Circle;
import components.ImageResize;
import components.RoundTextField;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class MainMenu extends JFrame{
	private JFrame main;
	private JPanel mainMenu, newGame, loadGame;
	private JLabel background;
	private ImageResize resizeImg;
	private Font nasalization;
	private Listen listen;
	private Circle chosenChar;
	protected JButton newGameB, loadGameB, rules, exit, startButton, backButton;
	protected JLabel menChar, womanChar, catChar;
	private ImageIcon backgroundImg = new ImageIcon(MainMenu.class.getResource("/images/StarBackground.gif"));
	private static final long serialVersionUID = 1L;
	
	public MainMenu() {
		//Initialicing Objects
		listen = new Listen(this);
		chosenChar = new Circle();
		chosenChar.setVisible(false);
		//Basic window atributes
		main = this;
		main.setUndecorated(true);
		main.setName("Main Menu");
		main.setVisible(true);
		main.setSize(800,600);
		main.setLocationRelativeTo(null);
		main.setResizable(false);
		main.addMouseMotionListener(listen);
		main.addMouseListener(listen);
		main.setLayout(null);
		//Adding Font
		try {
			nasalization = Font.createFont(Font.TRUETYPE_FONT, new File(MainMenu.class.getResource("/fonts/nasalization-rg.ttf").getFile()));
			GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
			ge.registerFont(nasalization);
			
		} catch (FontFormatException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//Creating Global Exit Button
		exit = new JButton("X");
		exit.setForeground(Color.WHITE);
		exit.setFont(nasalization.deriveFont(36f));
		exit.setContentAreaFilled(false);
		exit.setBorderPainted(false);
		exit.setFocusable(false);
		exit.setBounds(720,0,72,72);
		exit.addMouseListener(listen);
		
		//Creating Global Background
		resizeImg = new ImageResize(backgroundImg, main.getWidth(), main.getHeight());
		backgroundImg = resizeImg.resize();
		background = new JLabel();
		background.setBounds(0, 0, 800, 600);
		background.setIcon(backgroundImg);
		
		//Global Play, Back Button
		startButton = new JButton("Start");
		startButton.setFont(nasalization.deriveFont(48f));
		startButton.setBounds(620,530, 200,50);
		startButton.setForeground(Color.WHITE);
		startButton.setContentAreaFilled(false);
		startButton.setBorderPainted(false);
		startButton.setFocusable(false);
		startButton.addMouseListener(listen);
		
		backButton = new JButton("Back");
		backButton.setFont(nasalization.deriveFont(48f));
		backButton.setBounds(0,530, 180,50);
		backButton.setForeground(Color.WHITE);
		backButton.setContentAreaFilled(false);
		backButton.setBorderPainted(false);
		backButton.setFocusable(false);
		backButton.addMouseListener(listen);
		
		//Main Menu GUI
		mainMenuGUI();
		
		
		
	}	
	
	private void mainMenuGUI() {
		//Main Menu JPanel
		mainMenu = new JPanel();
		mainMenu.setSize(this.getSize());
		mainMenu.setLayout(null);
		
		
		JLabel title = new JLabel("Memordy");
		title.setBounds(134, 40, 526, 120);
		title.setForeground(Color.WHITE);
		title.setFont(nasalization.deriveFont(100f));
		
		newGameB = new JButton();
		newGameB.setIcon(new ImageIcon(MainMenu.class.getResource("/images/NewGame.gif")));
		newGameB.setContentAreaFilled(false);
		newGameB.setBorderPainted(false);
		newGameB.setFocusable(false);
		newGameB.setBounds(24, 180, 243, 243);
		
		loadGameB = new JButton();
		loadGameB.setIcon(new ImageIcon(MainMenu.class.getResource("/images/LoadGame.gif")));
		loadGameB.setContentAreaFilled(false);
		loadGameB.setBorderPainted(false);
		loadGameB.setFocusable(false);
		loadGameB.setBounds(279, 250, 243, 243);
		
		rules = new JButton();
		rules.setContentAreaFilled(false);
		rules.setIcon(new ImageIcon(MainMenu.class.getResource("/images/Rules.gif")));
		rules.setBorderPainted(false);
		rules.setFocusable(false);
		rules.setBounds(522, 310, 243, 243);
		
		//Adding mouse listeners
		newGameB.addMouseListener(listen);
		loadGameB.addMouseListener(listen);
		
		mainMenu.add(exit);		
		mainMenu.add(loadGameB);
		mainMenu.add(newGameB);
		mainMenu.add(rules);
		mainMenu.add(title);
		mainMenu.add(background);
		main.add(mainMenu);
	}
	
	private void newGameGUI() {
		newGame = new JPanel();
		newGame.setSize(this.getSize());
		newGame.setLayout(null);
		
		JLabel playerName = new JLabel("Player Name");
		playerName.setBounds(227, 46, 350, 60);
		playerName.setForeground(Color.WHITE);
		playerName.setFont(nasalization.deriveFont(48f));
		
		JTextField inputName = new RoundTextField(25);
		inputName.setBounds(185, 127, 415, 53);
		inputName.setFont(nasalization.deriveFont(36f));
		inputName.setForeground(Color.WHITE);
		
		JLabel chooseCharacter = new JLabel("Choose Character");
		chooseCharacter.setBounds(170, 243, 460, 60);
		chooseCharacter.setFont(nasalization.deriveFont(48f));
		chooseCharacter.setForeground(Color.WHITE);
		
		menChar = new JLabel();
		menChar.setIcon(new ImageIcon(MainMenu.class.getResource("/images/Men.png")));
		menChar.setBounds(75, 340, 160, 160);
		menChar.addMouseListener(listen);
		
		womanChar = new JLabel();
		womanChar.setIcon(new ImageIcon(MainMenu.class.getResource("/images/Woman.png")));
		womanChar.setBounds(298, 340, 160, 160);
		womanChar.addMouseListener(listen);
		
		catChar = new JLabel();
		catChar.setIcon(new ImageIcon(MainMenu.class.getResource("/images/Cat.png")));
		catChar.setBounds(517, 340, 160, 160);
		catChar.addMouseListener(listen);
		
		newGame.add(backButton);
		newGame.add(startButton);
		newGame.add(catChar);
		newGame.add(womanChar);
		newGame.add(menChar);
		newGame.add(chosenChar);
		newGame.add(chooseCharacter);
		newGame.add(inputName);
		newGame.add(playerName);
		newGame.add(exit);
		newGame.add(background);
		main.add(newGame);
	}
	
	protected void choosingCharacter(Object source) {
		chosenChar.setVisible(true);
		JLabel character = (JLabel)source;
		chosenChar.setBounds(character.getBounds().x,character.getBounds().y, 165, 165);
		
	}
	
	private void loadGameGUI() {
		loadGame = new JPanel();
		loadGame.setSize(this.getSize());
		loadGame.setLayout(null);
		
		JLabel chooseGame = new JLabel("Choose Game");
		chooseGame.setBounds(231, 33, 352, 57);
		chooseGame.setFont(nasalization.deriveFont(48f));
		chooseGame.setForeground(Color.WHITE);
		
		ChooseSavedGame save1 = new ChooseSavedGame();
		save1.setBounds(30, 112, 600, 120);
		
		ChooseSavedGame save2 = new ChooseSavedGame();
		save2.setBounds(30, 250, 600, 120);
		
		ChooseSavedGame save3 = new ChooseSavedGame();
		save3.setBounds(30, 388, 600, 120);
		
		loadGame.add(save1);
		loadGame.add(save2);
		loadGame.add(save3);
		loadGame.add(chooseGame);	
		loadGame.add(startButton);
		loadGame.add(backButton);
		loadGame.add(exit);
		loadGame.add(background);
		main.add(loadGame);
	}
	
	
	
	protected void changeGUI(String change) {
		chosenChar.setVisible(false);
		main.getContentPane().removeAll();
		main.revalidate();
		main.repaint();
		
		if(change == "Main Menu") mainMenuGUI();
		if(change == "New Game") newGameGUI();
		if(change == "Load Game") loadGameGUI();
	}





	

}
