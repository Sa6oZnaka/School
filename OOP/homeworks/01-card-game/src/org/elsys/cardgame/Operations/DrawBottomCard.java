package org.elsys.cardgame.Operations;

import org.elsys.cardgame.api.BasicDeck;
import org.elsys.cardgame.api.BasicOperation;
import org.elsys.cardgame.api.Card;
import org.elsys.cardgame.api.Deck;

public class DrawBottomCard extends BasicOperation {

    private Deck myDeck;

    public DrawBottomCard(Deck deck){
        super("draw_bottom_card");

        this.myDeck = deck;
    }

    @Override
    public void execute(){
        Card c = myDeck.drawBottomCard();
        System.out.println( c.getSuit() + "" + c.getRank() );
    }

}
