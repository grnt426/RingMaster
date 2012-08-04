package RingMaster;

import RingMaster.Cards.PlayerCard;
import RingMaster.Cards.PlayerCardCollection;
import RingMaster.Cards.RotationCard;

/**
 * Author:      Grant Kurtz
 */
public class Board {

	/**
	 * The two players' Rings
	 */
	Ring playerOneRing;
	Ring playerTwoRing;

	/**
	 * The two player's set of cards
	 */
	PlayerCardCollection playerOneCards;
	PlayerCardCollection playerTwoCards;

	/**
	 * The two player's Player Cards
	 */
	PlayerCard playerOnePC;
	PlayerCard playerTwoPC;

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
}
