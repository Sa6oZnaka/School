package org.elsys.cardgame.Operations;

import org.elsys.cardgame.api.Card;
import org.elsys.cardgame.api.OperationImplement;
import org.elsys.cardgame.api.Deck;

public class DrawTopCard extends OperationImplement {

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
