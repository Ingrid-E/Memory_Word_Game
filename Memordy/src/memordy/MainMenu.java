package memordy;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Graphics;
import java.awt.GraphicsEnvironment;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import components.ChooseSavedGame;
import components.Circle;
import components.CometMoving;
import components.GameButton;
import components.GameFont;
import components.GameText;
import components.ImageResize;
import components.RoundTextField;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class MainMenu extends JFrame{
	private JFrame main;
	private JPanel mainMenu, newGame, loadGame, showWords, writeWords;
	private JLabel background;
	private ImageResize resizeImg;
	private Listen listen;
	private Circle chosenChar;
	protected JButton newGameB, loadGameB, rules;
	protected JLabel menChar, womanChar, catChar;
	private ImageIcon backgroundImg = new ImageIcon(MainMenu.class.getResource("/images/StarBackground.gif"));
	private GameControls game;
	protected CometMoving comet;
	protected GameData data;
	protected JTextField inputName, inputWords;
	private Player player;
	protected JPanel words;
	private GameButton exit, startButton, backButton, newGameStart;
	private static final long serialVersionUID = 1L;
	
	public MainMenu(GameData data) {
		//Initialicing Objects
		this.data = data;
		listen = new Listen(this);
		chosenChar = new Circle();
		chosenChar.setVisible(false);
		game = new GameControls(this, this.data);
		
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
		
		//Creating Global Background
		resizeImg = new ImageResize(backgroundImg, main.getWidth(), main.getHeight());
		backgroundImg = resizeImg.resize();
		background = new JLabel();
		background.setBounds(0, 0, 800, 600);
		background.setIcon(backgroundImg);
		
		//Exit Button
		exit = new GameButton("X", 36);
		exit.setBounds(720,0,72,72);
		exit.addMouseListener(listen);
		
		//Global Play, Back Button
		startButton = new GameButton("Start", 48);
		startButton.setBounds(620,530, 200,50);
		startButton.addMouseListener(listen);
		
		backButton = new GameButton("Back", 48);
		backButton.setBounds(0,530, 180,50);
		backButton.addMouseListener(listen);
		
		
		//Main Menu GUI
		mainMenuGUI();
		
	}	

	private void mainMenuGUI() {
		//Main Menu JPanel
		mainMenu = new JPanel();
		mainMenu.setSize(this.getSize());
		mainMenu.setLayout(null);
		
		
		GameText title = new GameText("Memordy", 100);
		title.setBounds(134, 40, 526, 120);

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
		
		GameText playerName = new GameText("Player Name",48);
		playerName.setBounds(227, 46, 350, 60);
		
		inputName = new RoundTextField(25);
		inputName.setBounds(185, 127, 415, 53);
		inputName.setFont(GameFont.nasalization.deriveFont(36f));
		inputName.setForeground(Color.WHITE);
		
		GameText chooseCharacter = new GameText("Choose Character",48);
		chooseCharacter.setBounds(170, 243, 460, 60);
		
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
		
		newGameStart = new GameButton("Start", 48);
		newGameStart.setBounds(620,530, 200,50);
		newGameStart.addMouseListener(listen);
		
		newGame.add(backButton);
		newGame.add(newGameStart);
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

	private void loadGameGUI() {
		loadGame = new JPanel();
		loadGame.setSize(this.getSize());
		loadGame.setLayout(null);
		
		GameText chooseGame = new GameText("Choose Game",48);
		chooseGame.setBounds(231, 33, 352, 57);

		ArrayList<ChooseSavedGame> games = new ArrayList<>();
		//Adding player that exist to game
		int x = 0;
		for(Player player:data.players) {
			ChooseSavedGame game = new ChooseSavedGame(player.username, player.level, player.icon);
			game.setBounds(30, 112+(138*x), 600, 120);
			games.add(game);
			x++;
		}
		for(ChooseSavedGame game:games) {
			loadGame.add(game);
		}
		
		loadGame.add(chooseGame);	
		loadGame.add(startButton);
		loadGame.add(backButton);
		loadGame.add(exit);
		loadGame.add(background);
		main.add(loadGame);
	}
	
	private void showWordsGUI() {
		showWords = new JPanel();
		showWords.setSize(this.getSize());
		showWords.setLayout(null);
		
		GameText level = new GameText("Level: " + game.getLevel(), 36);
		level.setBounds(17, 12, 178, 57);
		
		comet = new CometMoving("Comet");
		game.showComets(comet);
	
		showWords.add(comet);
		showWords.add(level);
		showWords.add(exit);
		showWords.add(background);
		main.add(showWords);
	}
	
	private void writeWordsGUI() {
		writeWords = new JPanel();
		writeWords.setSize(this.getSize());
		writeWords.setLayout(null);
		
		GameText wordTitle = new GameText("Words",48);
		wordTitle.setBounds(300, 50, 165, 56);
		
		inputWords = new RoundTextField(45);
		inputWords.setBounds(114, 140, 552, 50);
		inputWords.setFont(GameFont.nasalization.deriveFont(36f));
		inputWords.setForeground(Color.WHITE);
		inputWords.addActionListener(listen);
		
		JPanel testing = new JPanel();
		testing.setBounds(115, 250, 550, 200);
		testing.setLayout(new GridLayout(2, 2));
		
		words = new JPanel();
		words.setBounds(115, 250, 550, 200);
		words.setLayout(new GridLayout(3, 3));
		
		GameText text = new GameText("Hello", 50);
		text.setForeground(Color.RED);
		text.setSize(550/2, 100);
		GameText text2 = new GameText("DIO", 50);
		text2.setForeground(Color.RED);
		text2.setSize(550/2, 100);
		testing.add(text);
		testing.add(text2);
		System.out.println(words.getLayout());

		
		
		ImageIcon imgBackground = new ImageIcon(MainMenu.class.getResource("/images/planetBackground.gif"));
		ImageResize resizeBackground = new ImageResize(imgBackground, main.getWidth(), main.getHeight());
		imgBackground = resizeBackground.resize();
		JLabel planetBackground = new JLabel();
		planetBackground.setBounds(0, 0, 800, 600);
		planetBackground.setIcon(imgBackground);
		
		writeWords.add(wordTitle);
		writeWords.add(inputWords);
		writeWords.add(testing);
		writeWords.add(exit);
		writeWords.add(planetBackground);
		main.add(writeWords);
		
	}
	
	protected void choosingCharacter(Object source) {
		chosenChar.setVisible(true);
		JLabel character = (JLabel)source;
		chosenChar.setBounds(character.getBounds().x,character.getBounds().y, 165, 165);
	}
	
	

	protected void changeGUI(String change) {
		chosenChar.setVisible(false);
		main.getContentPane().removeAll();
		main.revalidate();
		main.repaint();
		
		switch(change) {
			case "MainMenu":
				mainMenuGUI();
				break;
			case "New Game":
				writeWordsGUI();
				break;
			case "Load Game":
				loadGameGUI();
				break;
			case "Show Words":
				showWordsGUI();
				break;
			case "Input Words":
				writeWordsGUI();
				break;
			default:
				mainMenuGUI();
				break;
		}
	}
	
	class Listen implements MouseListener, MouseMotionListener, ActionListener{
		private MainMenu mainMenu;
		private boolean menu = false;
		private int x,y;
		private Object icon;
		
		
		public Listen(MainMenu window) {
			mainMenu = window;
			menu = true;
		}
		
		@Override
		public void mouseClicked(MouseEvent e) {
			if(e.getSource() == exit) {
				game.exitGame();
				System.exit(0);
			}
			if(e.getSource() == newGameB) {
				changeGUI("New Game");
			}
			if(e.getSource() == loadGameB) {
				changeGUI("Load Game");
			}
			if(e.getSource() == menChar || e.getSource() == womanChar || e.getSource() == catChar) {
				icon = e.getSource();
				choosingCharacter(icon);
			}
			if(e.getSource() == backButton) {
				changeGUI("Main Menu");
			}
			if(e.getSource() == startButton) {
				changeGUI("Show Words");
			}
			if(e.getSource() == newGameStart) {
				changeGUI("Show Words");
				game.startingNewGame(inputName.getText(), icon);
			}
		}

		@Override
		public void mousePressed(MouseEvent e) {
			x = e.getX();
			y = e.getY();
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			if(e.getSource() instanceof JButton) {
				setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			else {
				setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseDragged(MouseEvent e) {
			if(menu) {
				mainMenu.setLocation(mainMenu.getLocation().x+e.getX()-x, 
						mainMenu.getLocation().y +e.getY()-y);
			}
			
		}

		@Override
		public void mouseMoved(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			System.out.println(inputWords.getText());
			game.addWord(inputWords.getText());
		}

	}


}


