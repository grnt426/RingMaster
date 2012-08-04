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
	private int seed;
	private ServerSocket server;
	private Socket socket;

	public Server(int port, ActionListener listener, int seed) {
		super(listener, true);
		this.port = port;
		this.seed = seed;
	}

	@Override
	public void run() {
		socket = null;
		try {
			server = new ServerSocket(port);
			socket = server.accept();
			setInput(socket.getInputStream());
			setOutput(socket.getOutputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
		sendSeed();
		setGameRunning();
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

	private void sendSeed() {
		try {
			getOutput().write(seed);
			getOutput().flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
		getListener().actionPerformed(new ActionEvent(this,
				ActionEvent.ACTION_PERFORMED, "start"));
	}

	@Override
	protected void closeSocket() {
		try {
			socket.close();
			server.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		finally{
			try {
				server.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
