package org.elsys.cardgame.factory;

import org.elsys.cardgame.api.*;
import java.util.*;

public class DeckFactory {

	public static Deck defaultWarDeck() {
		List<Card> cards;

		return new BasicDeck(cards, 26);
	}

	public static Deck defaultSantaseDeck() {
		List<Card> cards;

		return new BasicDeck(cards, 6);
	}

	public static Deck defaultBeloteDeck() {
		List<Card> cards;

		return new BasicDeck(cards, 8);
	}
}
