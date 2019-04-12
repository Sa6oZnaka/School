package org.elsys.cardgame.Operations;

import org.elsys.cardgame.api.*;

public class DrawBottomCard extends OperationImplement {

    private Deck myDeck;

    public DrawBottomCard(Deck deck){
        super("draw_bottom_card");

        this.myDeck = deck;
    }

    @Override
    public void execute(){
        Card c = myDeck.drawBottomCard();
        System.out.println(c.getSuit() + "" + c.getRank());
    }

}
