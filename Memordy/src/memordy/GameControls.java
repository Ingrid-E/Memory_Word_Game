package memordy;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JLabel;

import components.CometMoving;

public class GameControls {
	protected int level;
	private int wordQuantity;
	private ArrayList<String> words;
	private MainMenu window;
	private CometMoving comet;
	private Player player;
	private GameData data;
	
	
	public GameControls(MainMenu window, GameData data) {
		this.window = window;
		this.player = new Player();
		this.wordQuantity = 4;
		this.level = player.level;
		this.data = data;
		this.comet = new CometMoving("");
	}
	
	public void exitGame() {
		data.saveData();
	}
	
	
	public void startingNewGame(String name, Object icon) {
		data.createPlayer(name, (JLabel)icon);
		this.setPlayer(data.getPlayer(name));
	}
	
	public void setPlayer(Player player) {
		this.player = player;
		System.out.println(player.level);
		this.level = player.level;
		this.words = data.getPlayerWords(player.username);
		this.comet.setText(words.get(0));
	}
	
	public int getLevel() {
		return level;
	}
	
	public void showComets(CometMoving comet) {
		//Mover el cometa
		this.comet = comet;
		comet.setBounds(-528, -428, 528, 428);
		timer("Move Comet");
	}
	
	private void nextWord(int word) {
		comet.setText(words.get(word));
	}
	
	private void inputWords() {
		window.changeGUI("Main Menu");
		wordQuantity = 4 + (2*(this.level-1));
		
	}
	
	private void timer(String work) {
		Timer timer = new Timer();
		TimerTask task = new TimerTask() {
			int counter = 0;
			int word = 0;
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
					System.out.println(counter);
				}
				if(counter == 342) {
					if(word == (wordQuantity-1)) {
						inputWords();
						timer.cancel();
					}
					word++;
					nextWord(word);
					counter = 0;
					x = -528;
					y = -428;
				}
				counter ++;
			};
		};
		timer.scheduleAtFixedRate(task, 1000, 30);
	}

	
	
	
}
