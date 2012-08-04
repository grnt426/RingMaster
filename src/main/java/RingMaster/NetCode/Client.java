package RingMaster.NetCode;

import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.Socket;

/**
 * Author:      Grant Kurtz
 */
public class Client extends Talker{

	private int port;
	private String serverIP;

	public Client(String ip, int port, ActionListener listener) {
		super(listener);
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
}
