package memordy;

import java.awt.EventQueue;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class Memordy {
	public static GameData data;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EventQueue.invokeLater(new Runnable() {

			@Override
			public void run() {
				//Add interface
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							ObjectInputStream readData = new ObjectInputStream(new FileInputStream("src/gameData/game-data.txt"));
							Object gameData = readData.readObject();
							data = (GameData) gameData;
							readData.close();
						} catch (IOException e) {
							System.out.println("No existe el archivo game-data, inicio desde 0");
							data = new GameData();
						} catch (ClassNotFoundException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						System.out.println(data.players.size());
						data.printPlayers();
						MainMenu menu = new MainMenu(data);
					}
				});
			}
			
		});

	}

}
