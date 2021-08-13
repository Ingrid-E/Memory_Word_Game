package memordy;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JLabel;

public class Player implements Serializable{
	private static final long serialVersionUID = 1L;
	//Atributes
	protected String username;
	protected int level;
	private int points;
	protected JLabel icon;
	private ArrayList<String> words;
	private ArrayList<String[][]> levelWords;
	
	public Player() {
		this.username = "";
		this.level = 1;
		this.points = 0;
		this.icon = null;
		this.words = new ArrayList<>();
	}
	public Player(String username, JLabel icon) {
		this.username = username;
		this.level = 1;
		this.points = 0;
		this.icon = icon;
		this.words = new ArrayList<>();
	}
	public Player(String username, int level, int points, JLabel icon) {
		this.username = username;
		this.level = level;
		this.points = points;
		this.icon = icon;
		this.words = new ArrayList<>();
	}
	public void setWords(ArrayList<String> words) {
		this.words = words;
	}
	public ArrayList<String> getWords(){
		return this.words;
	}
	
	public void setLevelWords() {
		int wordQuantity = 4 + (2*(this.level-1));
		String[][] palabras = new String[2][wordQuantity];
		for(int i = 0; i < wordQuantity*2; i++) {
			if(i >= wordQuantity) {
				palabras[1][i-4] = words.get(i);
			}else {
				palabras[0][i] = words.get(i);
			}
		}
		System.out.println(Arrays.toString(palabras[0]));
		System.out.println(Arrays.toString(palabras[1]));
	}
	
	public void getLevelWords(int set) {
		
	}
}
