package pkgPokerBLL;

import java.util.ArrayList;
import java.util.Collections;
import java.util.UUID;

import pkgPokerEnum.eRank;
import pkgPokerEnum.eSuit;

public class Deck {

	private UUID DeckID;
	private ArrayList<Card> DeckCards = new ArrayList<Card>();

	public Deck() {

		super();
		int iCardNbr = 0;
		for (eSuit suit : eSuit.values()) {
			for (eRank rank : eRank.values()) {
				if ((suit != eSuit.JOKER) && (rank != eRank.JOKER)) {
					DeckCards.add(new Card(rank, suit, ++iCardNbr));
				}
			}
		}
		Collections.shuffle(DeckCards);
	}
	
	public Deck(int NbrJokers)  {
		this();
		for (int i = 0; i < NbrJokers; i++) {
			Card c = new Card(eSuit.JOKER,eRank.JOKER,52+i);
			DeckCards.add(c);
		}
		
	}

	public Card DrawCard() {

		return DeckCards.remove(0);
	}
}