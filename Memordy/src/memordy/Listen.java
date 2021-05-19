package memordy;

import java.awt.Cursor;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JButton;



public class Listen implements MouseListener, MouseMotionListener{
	private MainMenu mainMenu;
	private boolean menu = false;
	private int x,y;
	
	
	public Listen(MainMenu window) {
		mainMenu = window;
		menu = true;
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		
		if(menu) {
			if(e.getSource() == mainMenu.exit) {
				System.exit(0);
			}
			if(e.getSource() == mainMenu.newGameB) {
				mainMenu.changeGUI("New Game");
			}
			if(e.getSource() == mainMenu.loadGameB) {
				mainMenu.changeGUI("Load Game");
			}
			if(e.getSource() == mainMenu.menChar || e.getSource() == mainMenu.womanChar || e.getSource() == mainMenu.catChar) {
				mainMenu.choosingCharacter(e.getSource());
			}
			if(e.getSource() == mainMenu.backButton) {
				mainMenu.changeGUI("Main Menu");
			}
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
		if(menu) {
			if(e.getSource() instanceof JButton) {
				mainMenu.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			else {
				mainMenu.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
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

}
