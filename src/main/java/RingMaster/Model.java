package RingMaster;

import RingMaster.NetCode.Client;
import RingMaster.NetCode.Server;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

/**
 * Author:      Grant Kurtz
 */
public class Model {

	private final int PORT = 2525;
	private int SEED = 15;
	private Board board;
	private boolean ourTurn;
	ActionListener listen;
	Random gen = new Random(SEED);
	Client client;
	Server server;

	public Model() {
		board = new Board();

		listen = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getActionCommand().equals("endTurn")){
					ourTurn = true;
				}
				else if(e.getActionCommand().equals("seedSet")){
					SEED = client.getSeed();
				}
				else if(e.getActionCommand().equals("start")){
					ourTurn = true;
				}
			}
		};


	}


	public void startServer() {
		server = new Server(PORT, listen, SEED);
		Thread t = new Thread(server);
	}

	public void startClient(String serverIP) {
		client = new Client(serverIP, PORT, listen);
		Thread t = new Thread(client);
	}
}
