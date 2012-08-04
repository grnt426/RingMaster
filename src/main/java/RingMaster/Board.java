package RingMaster;

import RingMaster.Cards.*;

import java.util.Random;

/**
 * Author:      Grant Kurtz
 */
public class Board {

	/**
	 * The two players' Rings
	 */
	private Ring playerOneRing;
	private Ring playerTwoRing;

	/**
	 * The two player's set of cards
	 */
	private PlayerCardCollection playerOneCards;
	private PlayerCardCollection playerTwoCards;

	/**
	 * The two player's Player Cards
	 */
	private PlayerCard playerOnePC;
	private PlayerCard playerTwoPC;

	private boolean isPlayerOne;

	public Board() {

		// Initialize Player One's data
		playerOnePC = new PlayerCard();
		playerOneRing = new Ring(playerOnePC, new RotationCard(1));
		playerOneCards = new PlayerCardCollection();

		// Initialize Player Two's data
		playerTwoPC = new PlayerCard();
		playerTwoRing = new Ring(playerTwoPC, new RotationCard(1));
		playerTwoCards = new PlayerCardCollection();
	}

	public void initCards(Random gen, boolean playerOne) {
		isPlayerOne = playerOne;

		// Generate Player One's deck
		for (int i = 0; i < 50; i++) {
			playerOneCards.addToDeck(new Monster(CardInstance.MONSTER,
					CardType.ATTACK));
		}
		playerOneCards.drawCards(5);

		// Generate Player Two's deck
		for (int i = 0; i < 50; i++) {
			playerTwoCards.addToDeck(new Monster(CardInstance.MONSTER,
					CardType.ATTACK));
		}
		playerTwoCards.drawCards(5);
	}

	public CardCollection getHand() {
		if(isPlayerOne)
			return playerOneCards.getHand();
		else
			return playerTwoCards.getHand();
	}
}
