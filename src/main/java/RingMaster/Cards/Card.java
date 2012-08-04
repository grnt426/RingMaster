package RingMaster.Cards;

import RingMaster.CardInstance;
import RingMaster.CardType;

/**
 * Author:      Grant Kurtz
 */
public abstract class Card {

	private final CardType type;
	private final CardInstance name;

	public Card(CardInstance name, CardType type){
		this.name = name;
		this.type = type;
	}

	public CardType getType() {
		return type;
	}

	public CardInstance getName() {
		return name;
	}

	public String toString(){
		if(name == CardInstance.PLAYER)
			return "@";
		return name.toString().charAt(0) + "";
	}

	public abstract Card clone();

	public abstract int getAttackPower();

	public abstract int getDefensePower();

	public abstract void applyDamage(int dmg);

	public abstract int getHealth();

	public abstract boolean expired();
}
