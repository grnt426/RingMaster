package RingMaster.Cards;

import RingMaster.CardInstance;
import RingMaster.CardType;

/**
 * Author:      Grant Kurtz
 */
public class BigMonster extends Card {

	private int hp;

	public BigMonster(CardInstance name, CardType type) {
		super(name, type);
		hp = 10;
	}

	@Override
	public Card clone() {
		return null;
	}

	@Override
	public int getAttackPower() {
		return 5;
	}

	@Override
	public int getDefensePower() {
		return 2;
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
		return hp < 1;
	}
}
