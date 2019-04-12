package org.elsys.cardgame;

import org.elsys.cardgame.Operations.Shuffle;
import org.elsys.cardgame.Operations.Size;
import org.elsys.cardgame.Operations.Sort;
import org.elsys.cardgame.Operations.TopCard;
import org.elsys.cardgame.api.BasicDeck;
import org.elsys.cardgame.api.BasicGame;
import org.elsys.cardgame.api.Card;

import java.util.Comparator;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        String cards = in.nextLine();

        Comparator<Card> WarCmp = new Comparator<Card>() {
            @Override
            public int compare(Card card1, Card card2) {
                if( card1.getSuit().ordinal() == card2.getSuit().ordinal()) {
                    return card1.getRank().ordinal() - card2.getRank().ordinal();
                }else{
                    return card1.getSuit().ordinal() - card2.getSuit().ordinal();
                }
            }
        };

        /*BasicDeck myDeck = new BasicDeck(cards, 10, WarCmp);
        BasicGame myGame = new BasicGame(myDeck);

        myGame.addOperation(new Size(myDeck));
        myGame.addOperation(new Shuffle(myDeck));
        myGame.addOperation(new Sort(myDeck));
        myGame.addOperation(new TopCard(myDeck));
        */

    }

}