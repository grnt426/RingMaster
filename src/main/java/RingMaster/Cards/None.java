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

	@Override
	public int getAttackPower() {
		return 0;
	}

	@Override
	public int getDefensePower() {
		return 0;
	}

	@Override
	public void applyDamage(int dmg) {

	}

	@Override
	public int getHealth() {
		return 0;
	}

	@Override
	public boolean expired() {
		return false;
	}
}
