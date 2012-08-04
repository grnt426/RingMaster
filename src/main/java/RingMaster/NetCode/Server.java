package RingMaster.NetCode;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Author:      Grant Kurtz
 */
public class Server implements Runnable{

	private int port;
	private boolean gameRunning;
	private boolean clientTurn;

	public Server(int port) {
		this.port = port;
	}

	@Override
	public void run() {
		Socket socket;
		try {
			ServerSocket server = new ServerSocket(port);
			socket = server.accept();
		} catch (IOException e) {
			e.printStackTrace();
		}
		while(gameRunning){

		}
	}

	public void endGame(){
		gameRunning = false;
	}

	public void setClientTurn(){
		clientTurn = true;
	}
}
