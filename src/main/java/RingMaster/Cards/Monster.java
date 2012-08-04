package RingMaster.Cards;

import RingMaster.CardInstance;
import RingMaster.CardType;

/**
 * Author:      Grant Kurtz
 */
public class Monster extends Card {

	private int hp;

	public Monster(CardInstance name, CardType type) {
		super(name, type);
		hp = 7;
	}

	@Override
	public Card clone() {
		Monster m = new Monster(getName(), getType());
		return m;
	}

	@Override
	public int getAttackPower() {
		return 3;
	}

	@Override
	public int getDefensePower() {
		return 1;
	}

	@Override
	public void applyDamage(int dmg) {
		hp -= dmg;
	}

	@Override
	public int getHealth() {
		return hp;
	}

	@Override
	public boolean expired() {
		return hp > 0;
	}
}
