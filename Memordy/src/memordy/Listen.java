package memordy;

import java.awt.Cursor;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;



public class Listen implements MouseListener{
	private MainMenu mainMenu;
	
	public Listen(MainMenu window) {
		mainMenu = window;
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		if(mainMenu.getName() == "Main Menu") {
			if(e.getSource() == mainMenu.exit) {
				System.exit(0);
			}
			if(e.getSource() == mainMenu.newGame) {
				mainMenu.changeGUI("New Game");
			}
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		if(mainMenu.getName() == "Main Menu") {
			if(e.getSource() == mainMenu.newGame || e.getSource() == mainMenu.exit) {
				mainMenu.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
		}
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		if(mainMenu.getName() == "Main Menu") {
			if(e.getSource() == mainMenu.newGame || e.getSource() == mainMenu.exit) {
				mainMenu.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
		}
	}

}
