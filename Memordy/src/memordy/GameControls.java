package memordy;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JLabel;

import components.CometMoving;
import components.GameText;
import components.RoundTextField;

public class GameControls {
	protected int level,set;
	private ArrayList<String> inputtedWords;
	private String[] words;
	private MainMenu window;
	private CometMoving comet;
	private Player player;
	private GameData data;
	
	
	public GameControls(MainMenu window, GameData data) {
		this.window = window;
		this.player = new Player();
		this.level = 1;
		this.set = 0;
		this.data = data;
		this.comet = new CometMoving("");
	}
	
	public void exitGame() {
		data.saveData();
	}
	
	public void addWord(String word) {
		GameText words = new GameText(word, 50);
		words.setForeground(Color.RED);
		words.setSize(550/2, 100);
		window.words.add(words);
	}
	
	
	public void startingNewGame(String name, Object icon) {
		data.createPlayer(name, (JLabel)icon);
		this.setPlayer(data.getPlayer(name));
	}
	
	public void setPlayer(Player player) {
		this.player = player;
		System.out.println(player.level);
		this.level = player.level;
		this.words = player.getLevelWords();
		this.comet.setText(words[player.wordQuantity-1]);
	}
	
	public Player getPlayer() {
		System.out.println("Player name: " + this.player.username);
		return this.player;
	}
	
	public int getLevel() {
		return level;
	}
	
	
	
	public void showComets(CometMoving comet, Player player) {
		//Mover el cometa
		this.comet = comet;
		comet.setBounds(-528, -428, 528, 428);
		setPlayer(player);
		moveComets("Move Comet");
	}
	
	private void nextWord(int word) {
		comet.setText(words[word]);
	}
	
	private void inputWords() {
		window.changeGUI("Input Words");
	}
	
	public void wrongWord(RoundTextField textField) {
		
		Timer timer = new Timer();
		TimerTask task = new TimerTask() {
			int counter = 0;
			int moveX = textField.getX();
			int initialPos = textField.getX();
			boolean right = true;
			boolean left = false;
			@Override
			public void run() {
				textField.borderColor = Color.red;
				if(right) {
					if(moveX == initialPos+3) {
						left = true;
						right = false;
					}else {
						moveX++;
					}
				}else if(left) {
					if(moveX == initialPos-3) {
						right = false;
						left = false;
					}else {
						moveX--;
					}
				}else {
					if(moveX == initialPos) {
						System.out.println(counter);
						textField.borderColor = new Color(234,55,234);
						timer.cancel();
					}else {
						moveX++;
					}
				}
				textField.setLocation(moveX, textField.getY());
				counter++;
			}
			
		};
		timer.scheduleAtFixedRate(task, 0, 30);
	}
	
	
	private void moveComets(String work) {
		Timer timer = new Timer();
		TimerTask task = new TimerTask() {
			int counter = 0;
			int word = player.wordQuantity-1;
			int x = -528;
			int y = -428;
			@Override
			public void run() {
				if(work == "Move Comet") {
					comet.setBounds(x, y, 528, 428); //Arreglar que finalize en la esquina inferior
					x = x + 4;
					y = y + 3;
				}
				if(y>600) {
					System.out.println("Y: " + counter);
				}
				if(counter == 342) {
					if(word == 0) {
						inputWords();
						timer.cancel();
					}else {
						word--;
						System.out.println("Word: " + word);
						nextWord(word);
						counter = 0;
						x = -528;
						y = -428;
					}
				}
				counter ++;
			};
		};
		timer.scheduleAtFixedRate(task, 1000, 30);
	}

	
	
	
}
