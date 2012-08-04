package RingMaster;

import RingMaster.Cards.Card;
import RingMaster.Cards.PlayerCard;
import RingMaster.Cards.RotationCard;

import java.util.HashMap;
import java.util.LinkedList;

/**
 * Contains all the information about the cards that are played on this Ring.
 * Author:      Grant Kurtz
 */
public class Ring {

	private static final int RING_SIZE = 5;
	private PlayerCard playerCard;
	private RotationCard rotation;
	private LinkedList<Card> ring;

	public Ring(PlayerCard playerCard, RotationCard rotation) {
		this.playerCard = playerCard;
		this.rotation = rotation;
		ring = new LinkedList<Card>();
		for(int i = 0; i < RING_SIZE; i++){
			ring.add(CardFactory.createCard(CardInstance.NONE));
		}
	}

	public boolean setCard(Card c, int position){
		if(position > RING_SIZE)
			return false;
		ring.set(position, c);
		return true;
	}

	public Card getCard(int position){
		return ring.get(position);
	}

	public RotationCard replaceRotation(RotationCard newRotationCard){
		RotationCard old = rotation;
		rotation = newRotationCard;
		return old;
	}

	public Card applyRotation(){
		for(int i = 0; i < rotation.getRotationCount(); i++){
			Card c = ring.poll();
			ring.push(c);
		}
		return ring.peek();
	}

	public PlayerCard getPlayerCard(){
		return playerCard;
	}
}
