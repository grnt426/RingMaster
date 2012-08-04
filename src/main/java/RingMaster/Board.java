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
		playerOnePC = new PlayerCard(CardInstance.PLAYER, CardType.TYPELESS);
		playerOneRing = new Ring(playerOnePC, new RotationCard(1));
		playerOneCards = new PlayerCardCollection();

		// Initialize Player Two's data
		playerTwoPC = new PlayerCard(CardInstance.PLAYER, CardType.TYPELESS);
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

	public boolean playCard(boolean playerOne, int handPos, int placePos) {
		if (playerOne) {
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

	public void fillHand(boolean playerOne) {
		if (playerOne)
			playerOneCards.fillHand();
		else
			playerTwoCards.fillHand();
	}

	public Ring getRing(boolean playerOne) {
		if (playerOne)
			return playerOneRing;
		else
			return playerTwoRing;
	}

	public void rotate(boolean playerOne) {
		if (playerOne)
			playerOneRing.applyRotation();
		else
			playerTwoRing.applyRotation();
	}

	public void activate(boolean playerOne) {
		Ring ring;
		Ring theirRing;
		if(playerOne){
			ring = playerOneRing;
			theirRing = playerTwoRing;
		}
		else{
			ring = playerTwoRing;
			theirRing = playerOneRing;
		}

		Card active = ring.getActive();
		if(active.getName() == CardInstance.PLAYER)
			return;
		Card theirActive = theirRing.getActive();

		activateCard(active, theirActive);
		if(theirActive.expired()){
			if(theirActive.getName() == CardInstance.PLAYER){
				System.out.println("Player card destroyed!");
			}
			else{
				System.out.println(theirActive + " was destroyed!");
				theirRing.setCard(new None(CardInstance.NONE, CardType.TYPELESS), 0);
			}
		}
	}

	private void activateCard(Card active, Card theirActive) {
		if(active.getType() == CardType.ATTACK){
			int dmg = active.getAttackPower() - theirActive.getDefensePower();
			theirActive.applyDamage(dmg);
			System.out.println(active.getName() + " attacked " +
					theirActive.getName() + " for " + dmg + " damage. Defender" +
					" has " + theirActive.getHealth() + " health left.");
		}
	}


	public boolean isPlayerOne() {
		return isPlayerOne;
	}

	public boolean didPlayerWin(boolean playerOne) {
		if(playerOne)
			return playerTwoRing.getPlayerCard().expired();
		else
			return playerOneRing.getPlayerCard().expired();
	}
}
