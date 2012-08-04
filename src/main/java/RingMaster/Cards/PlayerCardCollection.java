package RingMaster.Cards;

import java.util.List;

/**
 * Author:      Grant Kurtz
 */
public class PlayerCardCollection {

	private CardCollection deck;
	private CardCollection discard;
	private CardCollection hand;

	public PlayerCardCollection(){
		deck = new CardCollection();
		discard = new CardCollection();
		hand = new CardCollection();
	}

	public void shuffleDeck(){
		deck.shuffle();
	}

	public void drawCards(int count){
		List<Card> drawn = deck.drawCards(count);
		if(drawn.size() < count){
			discard.shuffle();
			deck.addCards(discard.drawCards(discard.getCardCount()));
			drawn.addAll(deck.drawCards(count - drawn.size()));
		}
		hand.addCards(drawn);
	}

	public CardCollection getHand(){
		return hand;
	}

	public void addToDeck(Card c){
		deck.addCard(c);
	}
}
