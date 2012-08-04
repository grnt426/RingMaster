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
			int rand = gen.nextInt(10);
			if (rand < 4)
				playerOneCards.addToDeck(new Monster(CardInstance.MONSTER,
						CardType.ATTACK));
			else if (rand >= 4 && rand < 8)
				playerOneCards.addToDeck(new Potion(CardInstance.POTION,
						CardType.SINGLE_USE));
			else
				playerOneCards.addToDeck(new BigMonster(
						CardInstance.BIG_MONSTER, CardType.ATTACK));
		}
		playerOneCards.drawCards(5);

		// Generate Player Two's deck
		for (int i = 0; i < 50; i++) {
			int rand = gen.nextInt(10);
			if (rand < 4)
				playerTwoCards.addToDeck(new Monster(CardInstance.MONSTER,
						CardType.ATTACK));
			else if (rand >= 4 && rand < 8)
				playerTwoCards.addToDeck(new Potion(CardInstance.POTION,
						CardType.SINGLE_USE));
			else
				playerTwoCards.addToDeck(new BigMonster(
						CardInstance.BIG_MONSTER, CardType.ATTACK));
		}
		playerTwoCards.drawCards(5);
	}

	public CardCollection getHand() {
		if (isPlayerOne)
			return playerOneCards.getHand();
		else
			return playerTwoCards.getHand();
	}

	public boolean playCard(int handPos, int placePos) {
		if (isPlayerOne) {
			Card c = playerOneCards.getHand().getCard(handPos);
			if (playerOneRing.setCard(c, placePos)) {
				playerOneCards.removeCardFromHand(handPos);
				return true;
			}
		} else {
			Card c = playerTwoCards.getHand().getCard(handPos);
			if (playerTwoRing.setCard(c, placePos)) {
				playerTwoCards.removeCardFromHand(handPos);
				return true;
			}
		}
		return false;
	}

	public void playOtherCard(int handPos, int ringPos) {
		if (!isPlayerOne) {
			Card c = playerOneCards.getHand().getCard(handPos);
			if (playerOneRing.setCard(c, ringPos)) {
				playerOneCards.removeCardFromHand(handPos);
			}
		} else {
			Card c = playerTwoCards.getHand().getCard(handPos);
			if (playerTwoRing.setCard(c, ringPos)) {
				playerTwoCards.removeCardFromHand(handPos);
			}
		}
	}

	public void fillOurHand() {
		if (isPlayerOne)
			playerOneCards.fillHand();
		else
			playerTwoCards.fillHand();
	}

	public void fillTheirHand() {
		if (isPlayerOne)
			playerTwoCards.fillHand();
		else
			playerOneCards.fillHand();
	}
}
