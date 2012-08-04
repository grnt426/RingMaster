package RingMaster.NetCode;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Author:      Grant Kurtz
 */
public class Server extends Talker{

	private int port;

	public Server(int port, ActionListener listener) {
		super(listener);
		this.port = port;
	}

	@Override
	public void run() {
		Socket socket = null;
		try {
			ServerSocket server = new ServerSocket(port);
			socket = server.accept();
			setInput(socket.getInputStream());
			setOutput(socket.getOutputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
		talk();

		// Alright, cleanup everything
		if (socket != null) {
			try {
				socket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
