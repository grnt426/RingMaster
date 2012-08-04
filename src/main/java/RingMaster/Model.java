package RingMaster;

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

	public Model(String name) {
		this.name = name;
		board = new Board();

		listen = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getActionCommand().equals("endTurn")){
					ourTurn = true;
				}
				else if(e.getActionCommand().equals("seedSet")){
					SEED = client.getSeed();
					gen = new Random(SEED);
					initializeCards(false);
					gameRunning = true;
				}
				else if(e.getActionCommand().equals("start")){
					ourTurn = true;
					gameRunning = true;
				}
			}
		};
	}

	public void playCard(int handPos, int placePos){

	}

	public void sendCommand(String command){
		talker.setTheirTurn(command);
		do{
			try{
				Thread.sleep(50);
			}
			catch (InterruptedException i){
				i.printStackTrace();
			}
		}while(!ourTurn);
	}

	public void startServer() {
		SEED = 15;
		gen = new Random(SEED);
		initializeCards(true);
		server = new Server(PORT, listen, SEED);
		talker = server;
		Thread t = new Thread(server);
	}

	private void initializeCards(boolean playerOne) {
		board.initCards(gen, playerOne);
	}

	public void startClient(String serverIP) {
		client = new Client(serverIP, PORT, listen);
		talker = client;
		Thread t = new Thread(client);
	}
}
