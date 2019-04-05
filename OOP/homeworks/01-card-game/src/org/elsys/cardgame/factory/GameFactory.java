package org.elsys.cardgame.factory;

import java.util.List;

import org.elsys.cardgame.api.*;

public class GameFactory {

    public static Game createWarGame(List<Card> cards) {

        Deck WarDeck = DeckFactory.defaultWarDeck();
        return new BasicGame(WarDeck);

    }

    public static Game createSantaseGame(List<Card> cards) {

        Deck SantaseDeck = DeckFactory.defaultWarDeck();
        return new BasicGame(SantaseDeck);

    }

    public static Game createBeloteGame(List<Card> cards) {

        Deck BelotDeck = DeckFactory.defaultWarDeck();
        return new BasicGame(BelotDeck);

    }
}