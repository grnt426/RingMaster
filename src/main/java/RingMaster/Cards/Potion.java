package RingMaster.Cards;

import RingMaster.CardInstance;
import RingMaster.CardType;

/**
 * Author:      Grant Kurtz
 */
public class Potion extends Card {

	private boolean used;

	public Potion(CardInstance name, CardType type) {
		super(name, type);
		used = false;
	}

	@Override
	public Card clone() {
		Potion p = new Potion(getName(), getType());
		return p;
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
		used = true;
	}

	@Override
	public int getHealth() {
		return 0;
	}

	@Override
	public boolean expired() {
		return used;
	}
}
