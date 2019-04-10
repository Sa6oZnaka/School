package org.elsys.cardgame.Operations;

import org.elsys.cardgame.api.BasicDeck;
import org.elsys.cardgame.api.BasicOperation;

public class DrawBottomCard extends BasicOperation {

    private BasicDeck myDeck;

    DrawBottomCard(BasicDeck deck){
        super("draw_bottom_card");

        this.myDeck = deck;
    }

    @Override
    public void execute(){
        System.out.println( myDeck.drawBottomCard() );
    }

}
