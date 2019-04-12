package org.elsys.cardgame.factory;

import org.elsys.cardgame.api.*;
import java.util.*;

public class DeckFactory {

	public static Deck defaultWarDeck() {

		ArrayList<Card> cards = new ArrayList<>();

		for (Suit suit : Suit.values()) {
			for (Rank rank : Rank.values()) {
				cards.add(new CardImplement(rank , suit));
			}
		}

		Comparator<Card> cmp = new Comparator<Card>() {
			@Override
			public int compare(Card card1, Card card2) {
				if( card1.getSuit().ordinal() == card2.getSuit().ordinal()) {
					return card1.getRank().ordinal() - card2.getRank().ordinal();
				}else{
					return card1.getSuit().ordinal() - card2.getSuit().ordinal();
				}
			}
		};

		return new DeckImplement(cards, 26, cmp);
	}

	public static Deck defaultSantaseDeck() {
		ArrayList<Card> cards = new ArrayList<>();

		for (Suit suit : Suit.values()) {
			for (Rank rank : Rank.values()) {
				if (rank.ordinal() >= Rank.NINE.ordinal()) {
					cards.add(new CardImplement(rank , suit));
				}
			}
		}

		Comparator<Card> cmp = new Comparator<Card>() {
			@Override
			public int compare(Card card1, Card card2) {
				if(card1.getSuit().ordinal() != card2.getSuit().ordinal()) {
					return card1.getSuit().ordinal() - card2.getSuit().ordinal();
				}else{
					return card1.getRank().ordinal() - card2.getRank().ordinal();
				}
			}
		};

		return new DeckImplement(cards, 6, cmp);
	}

	public static Deck defaultBeloteDeck() {
		ArrayList<Card> cards = new ArrayList<>();

		for (Suit suit : Suit.values()) {
			for (Rank rank : Rank.values()) {
				if (rank.ordinal() >= Rank.SEVEN.ordinal()) {
					cards.add(new CardImplement(rank , suit));
				}
			}
		}

		Comparator<Card> cmp = new Comparator<Card>() {
			@Override
			public int compare(Card card1, Card card2) {
				if(card1.getSuit().ordinal() != card2.getSuit().ordinal()) {
					return card1.getSuit().ordinal() - card2.getSuit().ordinal();
				}else{
					return card1.getRank().ordinal() - card2.getRank().ordinal();
				}
			}
		};

		return new DeckImplement(cards, 8, cmp);
	}
}
