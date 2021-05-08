package memordy;

import java.awt.EventQueue;

public class Memordy {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EventQueue.invokeLater(new Runnable() {

			@Override
			public void run() {
				//Add interface
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						MainMenu menu = new MainMenu();
					}
				});
			}
			
		});

	}

}
