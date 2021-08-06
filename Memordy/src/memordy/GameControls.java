package memordy;

import java.util.Timer;
import java.util.TimerTask;

import components.CometMoving;

public class GameControls {
	protected int level;
	private String[] words = {"hola", "mundo", "me", "llamo", "Ingrid"};
	private MainMenu window;
	private CometMoving comet;
	
	
	public GameControls(MainMenu window) {
		level = 1;
		this.window = window;
	}
	
	public void showComets(CometMoving comet) {
		//Mover el cometa
		this.comet = comet;
		comet.setBounds(-528, -428, 528, 428);
		timer("Move Comet");
	}
	
	private void timer(String work) {
		Timer timer = new Timer();
		TimerTask task = new TimerTask() {
			int counter = 0;
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
					System.out.println("Cancelado");
					comet.setText("Reinicio");
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
