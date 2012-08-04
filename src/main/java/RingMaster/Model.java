package RingMaster;

import RingMaster.NetCode.Client;
import RingMaster.NetCode.Server;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Author:      Grant Kurtz
 */
public class Model {

	private final int PORT = 2525;
	private Board board;
	private boolean ourTurn;
	ActionListener listen;

	public Model() {
		board = new Board();

		listen = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ourTurn = true;
			}
		};
	}


	public void startServer() {
		Server server = new Server(PORT, listen);
	}

	public void startClient(String serverIP) {
		Client client = new Client(serverIP, PORT, listen);
	}
}
