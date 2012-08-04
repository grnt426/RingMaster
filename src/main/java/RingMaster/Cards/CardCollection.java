package RingMaster.Cards;

import RingMaster.CardInstance;
import RingMaster.CardType;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Author:      Grant Kurtz
 */
public class CardCollection {

	LinkedList<Card> cards;

	public CardCollection(){
		cards = new LinkedList<Card>();
	}

	public void addCards(List newCards){
		cards.addAll(newCards);
	}

	public void addCard(Card c){
		cards.add(c);
	}

	public List<Card> drawCards(int count){
		List<Card> drawnCards = new ArrayList<Card>();
		for(int i = 0; i < count; i++){
			Card c = cards.poll();
			if(c != null)
				drawnCards.add(c);
			else
				break;
		}
		return drawnCards;
	}

	public Card findFirst(CardInstance instance){
		for(Card card : (Card[]) cards.toArray()){
			if(card.getName() == instance){
				return card;
			}
		}
		return null;
	}

	public void shuffle() {
		Collections.shuffle(cards);
	}

	public int getCardCount() {
		return cards.size();
	}

	public Card getCard(int i) {
		return cards.get(i);
	}

	public void removeCard(int pos) {
		cards.remove(pos);
	}
}
