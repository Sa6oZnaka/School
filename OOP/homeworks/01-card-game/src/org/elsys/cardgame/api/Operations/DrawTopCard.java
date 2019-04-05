package org.elsys.cardgame.api.Operations;

import org.elsys.cardgame.api.BasicDeck;
import org.elsys.cardgame.api.BasicOperation;

public class DrawTopCard extends BasicOperation {

    private BasicDeck myDeck;

    DrawTopCard(BasicDeck deck){
        super("draw_top_card");

        this.myDeck = deck;
    }

    @Override
    public void execute(){
        System.out.println( myDeck.drawTopCard() );
    }

}
