package RingMaster;

import RingMaster.Cards.Card;
import RingMaster.Cards.None;

import java.util.HashMap;

import static RingMaster.CardType.TYPELESS;

/**
 * Author:      Grant Kurtz
 */
public class CardFactory {

	private static HashMap<CardInstance, Card> cards;

	public static Card createCard(CardInstance instance) {
		getCards();
		Card c = cards.get(instance).clone();
		if (c == null) {
			switch (instance) {
				case NONE:
				default:
					c = new None(instance, TYPELESS);
			}
			cards.put(instance, c);
		}
		return c;
	}

	private static void getCards() {
		if (cards == null) {
			cards = new HashMap<CardInstance, Card>();
		}
	}
}
