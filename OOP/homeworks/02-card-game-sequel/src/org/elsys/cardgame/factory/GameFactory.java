
package org.elsys.cardgame.factory;

import java.util.List;

import org.elsys.cardgame.api.*;

public class GameFactory {

    public static Game createWarGame(List<Card> cards) {

        DeckImplement deck = new DeckImplement(cards, 26, DeckFactory.cmp());

        return new GameImplement(deck);

    }

    public static Game createSantaseGame(List<Card> cards) {

        DeckImplement deck = new DeckImplement(cards, 6, DeckFactory.cmp());

        return new GameImplement(deck);

    }

    public static Game createBeloteGame(List<Card> cards) {

        DeckImplement deck = new DeckImplement(cards, 8, DeckFactory.cmp());

        return new GameImplement(deck);

    }

}