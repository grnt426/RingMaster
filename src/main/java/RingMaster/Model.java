package RingMaster;

import RingMaster.Cards.CardCollection;
import RingMaster.NetCode.Client;
import RingMaster.NetCode.Server;
import RingMaster.NetCode.Talker;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

/**
 * Author:      Grant Kurtz
 */
public class Model {

	private final int PORT = 2525;
	private int SEED;
	private Board board;
	private boolean ourTurn;
	private boolean gameRunning;
	ActionListener listen;
	Random gen;
	Client client;
	Server server;
	Talker talker;
	private String name;
	private String command;

	public Model(String name) {
		this.name = name;
		board = new Board();
		command = null;

		listen = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getActionCommand().equals("turnEnd")) {
					String command = talker.getCommand();
					processReceivedCommand(command);
					ourTurn = true;
				} else if (e.getActionCommand().equals("seedSet")) {
					SEED = client.getSeed();
					gen = new Random(SEED);
					initializeCards(false);
					gameRunning = true;
				} else if (e.getActionCommand().equals("start")) {
					ourTurn = true;
					gameRunning = true;
				}
			}
		};
	}

	private void processReceivedCommand(String command) {
		String[] args = command.split(":");
		int handPos = Integer.parseInt(args[0]);
		int ringPos = Integer.parseInt(args[1]);
		playOthersCards(handPos, ringPos);
	}

	private void playOthersCards(int handPos, int ringPos) {
		board.playCard(!board.isPlayerOne(), handPos, ringPos);
		board.fillHand(!board.isPlayerOne());
		board.rotate(!board.isPlayerOne());
	}

	public boolean playCard(int handPos, int placePos) {
		command = handPos + ":" + placePos;
		if(board.playCard(board.isPlayerOne(), handPos, placePos)){
			board.fillHand(board.isPlayerOne());
			board.activate(board.isPlayerOne());
			board.rotate(board.isPlayerOne());
			ourTurn = false;
			return true;
		}
		return false;
	}

	public void awaitOurTurn() {
		if(command != null)
			talker.setTheirTurn(command);
		do {
			try {
				Thread.sleep(50);
			} catch (InterruptedException i) {
				i.printStackTrace();
			}
		} while (!ourTurn);
	}

	public void startServer() {
		SEED = 15;
		gen = new Random(SEED);
		initializeCards(true);
		server = new Server(PORT, listen, SEED);
		talker = server;
		Thread t = new Thread(server);
		t.start();
	}

	private void initializeCards(boolean playerOne) {
		board.initCards(gen, playerOne);
	}

	public void startClient(String serverIP) {
		client = new Client(serverIP, PORT, listen);
		talker = client;
		Thread t = new Thread(client);
		t.start();
	}

	public boolean isGameRunning() {
		return gameRunning;
	}

	public CardCollection getOurHand() {
		return board.getHand();
	}

	public boolean isOurTurn() {
		return ourTurn;
	}

	public Ring getTheirRing() {
		return board.getRing(!board.isPlayerOne());
	}

	public Ring getOurRing() {
		return board.getRing(board.isPlayerOne());
	}
}
