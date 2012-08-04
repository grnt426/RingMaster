package RingMaster.Cards;

import RingMaster.CardInstance;
import RingMaster.CardType;

/**
 * Author:      Grant Kurtz
 */
public class None extends Card {

	public None(CardInstance name, CardType type) {
		super(name, type);
	}

	@Override
	public Card clone() {
		None n = new None(getName(), getType());
		return n;
	}
}
