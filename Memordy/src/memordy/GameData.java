package memordy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

import javax.swing.JLabel;

public class GameData implements Serializable{
	private static final long serialVersionUID = 1L;
	protected ArrayList<Player> players;
	protected ArrayList<String> words;
	protected HashMap<String, ArrayList<String>> wordList;

	public GameData() {
		this.players = new ArrayList<Player>();
		this.wordList = new HashMap<>();
		readWords();
	}
	
	private void setPlayerWords(Player player) {
		ArrayList<String> randomize = new ArrayList<>();
		randomize.addAll(words);
		Collections.shuffle(randomize);
		wordList.put(player.username, randomize);
	}
	public ArrayList<String> getPlayerWords(String name){
		return wordList.get(name);
	}
	
	private void readWords() {
		words = new ArrayList<>();
		String line;
		try {
			BufferedReader reader = new BufferedReader(new FileReader("src/gameData/words.txt"));
			while((line = reader.readLine())!=null) {
				words.add(line);
			}
			reader.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	protected void createPlayer(String name, JLabel icon) {
		Player newPlayer = new Player(name, icon);
		players.add(newPlayer);
		setPlayerWords(newPlayer);
	}
	
	protected Player getPlayer(String name) {
		Player user = null;
		for(Player player: players) {
			if(player.username == name) {
				user = player;
				return user;
			}
		}
		return user;
	}
	
	protected void saveData() {
		try {
			ObjectOutputStream file = new ObjectOutputStream(new FileOutputStream("src/gameData/game-data.txt"));
			file.writeObject(this);
			file.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public void printPlayers() {
		for(Player player: this.players) {
			System.out.println(player.username);
		}
	}
	
	
	
	

}
