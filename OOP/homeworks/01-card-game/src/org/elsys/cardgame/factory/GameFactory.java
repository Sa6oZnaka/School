
package org.elsys.cardgame.factory;

import java.util.Comparator;
import java.util.List;

import org.elsys.cardgame.api.*;

public class GameFactory {

    public static Game createWarGame(List<Card> cards) {

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

        DeckImplement deck = new DeckImplement(cards, 26, cmp);

        return new GameImplement(deck);

    }

    public static Game createSantaseGame(List<Card> cards) {

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

        DeckImplement deck = new DeckImplement(cards, 6, cmp);

        return new GameImplement(deck);

    }

    public static Game createBeloteGame(List<Card> cards) {

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

        DeckImplement deck = new DeckImplement(cards, 8, cmp);

        return new GameImplement(deck);

    }

}