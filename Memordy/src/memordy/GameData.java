package memordy;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

import javax.swing.JLabel;

public class GameData implements Serializable{
	private static final long serialVersionUID = 1L;
	protected ArrayList<Player> players;

	public GameData() {
		this.players = new ArrayList<Player>();
	}

	protected void createPlayer(String name, JLabel icon) {
		System.out.println(icon.getIcon());
		Player newPlayer = new Player(name, icon);
		players.add(newPlayer);
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
