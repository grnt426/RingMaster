package RingMaster.Cards;

import RingMaster.CardInstance;
import RingMaster.CardType;

/**
 * Author:      Grant Kurtz
 */
public class Monster extends Card {

	public Monster(CardInstance name, CardType type) {
		super(name, type);
	}

	@Override
	public Card clone() {
		Monster m = new Monster(getName(), getType());
		return m;
	}
}
