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

	public boolean ourTurn() {
		return model.isOurTurn();
	}

	public void awaitOurTurn() {
		model.awaitOurTurn();
	}

	public boolean placeCard(int card, int ringPos) {
		return model.playCard(card, ringPos);
	}

	public Ring getTheirRing() {
		return model.getTheirRing();
	}

	public Ring getOurRing() {
		return model.getOurRing();
	}

	public boolean sendCommand() {
		return model.sendCommand();
	}

	public void pass() {
		model.pass();
	}

	public boolean weWon() {
		return model.weWon();
	}

	public void quit() {
		model.quit();
	}
}
