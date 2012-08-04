package RingMaster;

import RingMaster.NetCode.Server;

/**
 * Author:      Grant Kurtz
 */
public class Model {

	private final int PORT = 2525;

	private Board board;

	private boolean hostTurn;

	public Model(){
		board = new Board();

	}


	public void startServer() {
		Server server = new Server(PORT);
	}

	public void startClient() {

	}
}
