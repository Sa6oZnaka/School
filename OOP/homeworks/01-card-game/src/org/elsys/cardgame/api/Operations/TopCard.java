package org.elsys.cardgame.api.Operations;

import org.elsys.cardgame.api.BasicDeck;
import org.elsys.cardgame.api.BasicOperation;

public class TopCard extends BasicOperation {

    private BasicDeck myDeck;

    TopCard(BasicDeck deck){
        super("top_card");

        this.myDeck = deck;
    }

    @Override
    public void execute(){
        System.out.println( myDeck.topCard() );
    }
}
