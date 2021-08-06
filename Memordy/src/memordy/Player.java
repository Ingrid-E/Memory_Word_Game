package memordy;

import java.io.Serializable;

import javax.swing.JLabel;

public class Player implements Serializable{
	private static final long serialVersionUID = 1L;
	//Atributes
	protected String username;
	protected int level;
	private int points;
	protected JLabel icon;
	
	public Player() {
		this.username = "";
		this.level = 1;
		this.points = 0;
		this.icon = null;
	}
	public Player(String username, JLabel icon) {
		this.username = username;
		this.level = 1;
		this.points = 0;
		this.icon = icon;
	}
	public Player(String username, int level, int points, JLabel icon) {
		this.username = username;
		this.level = level;
		this.points = points;
		this.icon = icon;
	}
}
