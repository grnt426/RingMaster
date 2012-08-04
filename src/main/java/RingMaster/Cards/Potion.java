package RingMaster.Cards;

import RingMaster.CardInstance;
import RingMaster.CardType;

/**
 * Author:      Grant Kurtz
 */
public class Potion extends Card{

	public Potion(CardInstance name, CardType type) {
		super(name, type);
	}

	@Override
	public Card clone() {
		Potion p = new Potion(getName(), getType());
		return p;
	}
}
