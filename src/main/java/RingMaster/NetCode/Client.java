package RingMaster.NetCode;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.Socket;

/**
 * Author:      Grant Kurtz
 */
public class Client extends Talker{

	private int port;
	private String serverIP;
	private int seed;

	public Client(String ip, int port, ActionListener listener) {
		super(listener, false);
		serverIP = ip;
		this.port = port;
	}

	@Override
	public void run() {
		Socket socket = null;
		try {
			socket = new Socket(serverIP, port);
			setInput(socket.getInputStream());
			setOutput(socket.getOutputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
		receiveSeed();
		talk();

		// tear shit down
		if (socket != null) {
			try {
				socket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	private void receiveSeed() {
		try {
			seed = getInput().read();
		} catch (IOException e) {
			System.err.println("WHY DIDN'T YOU JUST SEND A FUCKING BYTE?");
			e.printStackTrace();
		}
		getListener().actionPerformed(new ActionEvent(this,
				ActionEvent.ACTION_PERFORMED, "seedSet"));
	}

	public int getSeed() {
		return seed;
	}
}
