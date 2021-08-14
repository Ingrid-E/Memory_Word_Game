package memordy;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JLabel;

public class Player implements Serializable{
	private static final long serialVersionUID = 1L;
	//Atributes
	protected String username;
	protected int level, set,wordQuantity;
	private int points;
	protected JLabel icon;
	private ArrayList<String> words;
	private String[][] levelWords;
	private ArrayList<String> wordsGuessed;
	
	public Player() {
		this.username = "";
		this.level = 1;
		this.set = 0;
		this.points = 0;
		this.icon = null;
		this.wordQuantity = 4 + (2*(this.level-1));
		this.words = new ArrayList<>();
		this.wordsGuessed = new ArrayList<>();
		this.levelWords = new String[2][wordQuantity];
	}
	public Player(String username, JLabel icon) {
		this.username = username;
		this.level = 1;
		this.set = 0;
		this.points = 0;
		this.wordQuantity = 4 + (2*(this.level-1));
		this.icon = icon;
		this.words = new ArrayList<>();
		this.wordsGuessed = new ArrayList<>();
		this.levelWords = new String[2][wordQuantity];
	}
	public Player(String username, int level, int points, JLabel icon) {
		this.username = username;
		this.level = level;
		this.wordQuantity = 4 + (2*(this.level-1));
		this.points = points;
		this.icon = icon;
		this.set = 0;
		this.words = new ArrayList<>();
		this.wordsGuessed = new ArrayList<>();
		this.levelWords = new String[2][wordQuantity];
	}
	public void setWords(ArrayList<String> words) {
		this.words = words;
	}
	public ArrayList<String> getWords(){
		return this.words;
	}
	
	public void setLevelWords() {
		wordQuantity = 4 + (2*(this.level-1));
		for(int i = 0; i < wordQuantity*2; i++) {
			if(i >= wordQuantity) {
				levelWords[1][i-4] = words.get(i);
			}else {
				levelWords[0][i] = words.get(i);
			}
		}
	}
	
	public String[] getLevelWords() {
		return levelWords[set];
	}
	public void addGuessedWord(String word) {
		wordsGuessed.add(word);
	}
	public ArrayList<String> getGuessedWords(){
		return wordsGuessed;
	}
}
