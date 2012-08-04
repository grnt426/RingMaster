package RingMaster;

import RingMaster.Cards.Card;
import RingMaster.Cards.CardCollection;

import java.util.Scanner;

/**
 * Author:      Grant Kurtz
 */
public class Console {

	private Controller controller;
	Scanner scan;

	public Console(Controller c) {
		controller = c;
		scan = new Scanner(System.in);
	}

	public void processCommands() {
		System.out.print("Connecting");
		while(!controller.isGameRunning()){
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.print(".");
		}
		System.out.println("Connected!");

		while(true){

			// Print game status
			CardCollection hand = controller.getHand();
			System.out.println("Hand:");
			for(int i = 0; i < hand.getCardCount(); i++){
				Card c = hand.getCard(i);
				System.out.println(i + ". " + c.getName() + ", " + c.getType());
			}

			if(controller.ourTurn()){

				// prompt for commands
				System.out.println("Take turn!");

				// print command list

				// Input Caret
				processCommand();
			}
			else{
				System.out.println("Waiting for other player to finish...");
				controller.awaitOurTurn();
			}
		}
	}

	private void processCommand() {
		String command = "";
		showCommandList();
		System.out.print("> ");
		command = scan.nextLine();
		while(!isValidCommand(command)){
			System.err.println("'" + command + "' is an invalid command!");
			showCommandList();
			System.out.print("> ");
			command = scan.nextLine();
		}
	}

	private boolean isValidCommand(String command) {
		String[] args = command.split(" ");
		if(args[0].equals("play")){
			int card = Integer.parseInt(args[1]);
			int ringPos = Integer.parseInt(args[2]);
			return controller.placeCard(card, ringPos);
		}
		return false;
	}

	private void showCommandList() {
		System.out.println(
				"play card_hand_pos card_ring_pos - Place a card on the " +
				"Ring\n" +
				"quit - Quit the game");
	}
}
