package org.elsys.cardgame.Operations;

import org.elsys.cardgame.api.*;

public class DrawTopCard extends BasicOperation {

    private Deck myDeck;

    public DrawTopCard(Deck deck){
        super("draw_top_card");

        this.myDeck = deck;
    }

    @Override
    public void execute(){
        Card c = myDeck.drawTopCard();
        System.out.println( c.getSuit() + "" + c.getRank() );
    }

}
