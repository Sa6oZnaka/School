package org.elsys.cardgame.factory;

import org.elsys.cardgame.api.*;
import java.util.*;

public class DeckFactory {

	public static Deck defaultWarDeck() {

		ArrayList<Card> cards = new ArrayList<>();

		for (Suit suit : Suit.values()) {
			for (Rank rank : Rank.values()) {
				cards.add(new BasicCard(rank , suit));
			}
		}

		return new BasicDeck(cards, 26);
	}

	public static Deck defaultSantaseDeck() {
		ArrayList<Card> cards = new ArrayList<>();

		for (Suit suit : Suit.values()) {
			for (Rank rank : Rank.values()) {
				if (rank.ordinal() > Rank.SIX.ordinal()) {
					cards.add(new BasicCard(rank , suit));
				}
			}
		}

		return new BasicDeck(cards, 6);
	}

	public static Deck defaultBeloteDeck() {
		ArrayList<Card> cards = new ArrayList<>();

		for (Suit suit : Suit.values()) {
			for (Rank rank : Rank.values()) {
				if (rank.ordinal() > Rank.SEVEN.ordinal()) {
					cards.add(new BasicCard(rank , suit));
				}
			}
		}

		return new BasicDeck(cards, 8);
	}
}
