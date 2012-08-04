package RingMaster.NetCode;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Author:      Grant Kurtz
 */
public abstract class Talker implements Runnable {

	private InputStream input;
	private OutputStream output;
	private boolean gameRunning;
	private boolean ourTurn;
	private String receivedCommand;
	private ActionListener listener;
	private String toSendCommand;

	public Talker(ActionListener listener, boolean ourTurn) {
		this.listener = listener;
		this.ourTurn = ourTurn;
	}

	public void talk() {
		while (gameRunning) {
			if (ourTurn) {
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}

			// Process client's turn
			else {

				// Tell client card that was played
				byte[] played = toSendCommand.getBytes();
				try {
					output.write(played);
				} catch (IOException e) {
					System.err.println("O GOD I AM SO SORRY SOMETHING BLOWED " +
							"UP! QUITTING AS SOON AS FUCKING POSSIBLE!");
					e.printStackTrace();
					try {
						input.close();
						output.close();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
					System.exit(1);
				}

				// Wait for client to respond with card played
				byte[] recvPlayed = new byte[5];
				try {
					input.read(recvPlayed);
				} catch (IOException e) {
					e.printStackTrace();
				}
				receivedCommand = recvPlayed.toString();
				listener.actionPerformed(new ActionEvent(this,
						ActionEvent.ACTION_PERFORMED, "turnEnd"));
				ourTurn = true;
			}
		}
	}

	public void setInput(InputStream input) {
		this.input = input;
	}

	public void setOutput(OutputStream output) {
		this.output = output;
	}

	public void endGame() {
		gameRunning = false;
	}

	public void setOurTurn(String command) {
		toSendCommand = command;
		ourTurn = false;
	}

	public ActionListener getListener() {
		return listener;
	}

	public InputStream getInput() {
		return input;
	}

	public OutputStream getOutput() {
		return output;
	}
}
