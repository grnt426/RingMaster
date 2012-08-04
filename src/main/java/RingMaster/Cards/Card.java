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

	public abstract Card clone();

}
