package RingMaster.Cards;

import RingMaster.CardInstance;
import RingMaster.CardType;

/**
 * Author:      Grant Kurtz
 */
public class BigMonster extends Card {


	public BigMonster(CardInstance name, CardType type) {
		super(name, type);
	}

	@Override
	public Card clone() {
		return null;
	}
}
