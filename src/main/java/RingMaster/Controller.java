package RingMaster;

import RingMaster.Cards.CardCollection;

/**
 * Author:      Grant Kurtz
 */
public class Controller {

	private Model model;

	public Controller(String name, Model model){
		this.model = model;
		model.startServer();
	}

	public Controller(String name, Model model, String ip) {
		this.model = model;
		model.startClient(ip);
	}

	public boolean isGameRunning() {
		return model.isGameRunning();
	}

	public CardCollection getHand() {
		return model.getOurHand();
	}
}
