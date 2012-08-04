package RingMaster;

import RingMaster.Cards.Card;
import RingMaster.Cards.CardCollection;

/**
 * Author:      Grant Kurtz
 */
public class Console {

	private Controller controller;

	public Console(Controller c) {
		controller = c;
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
		}
	}
}
